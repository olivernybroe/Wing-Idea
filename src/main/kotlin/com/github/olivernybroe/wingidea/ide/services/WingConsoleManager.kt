package com.github.olivernybroe.wingidea.ide.services

import com.github.olivernybroe.wingidea.WingIcons
import com.github.olivernybroe.wingidea.ide.WingCommandLine
import com.intellij.execution.impl.ExecutionManagerImpl
import com.intellij.execution.process.KillableProcessHandler
import com.intellij.execution.process.OSProcessHandler
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.navigation.NavigationItem
import com.intellij.openapi.Disposable
import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.websocket.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.delay
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

/**
 * Manages the Wing Console command.
 *
 * Makes sure only one instance of the Wing Console is running at once
 * for a given project.
 *
 * @see [Wing Console](https://www.winglang.io/docs/tools/wing-console)
 */
@Service(Service.Level.PROJECT)
class WingConsoleManager(val project: Project): Disposable {
    var path: String? = null
    var port: Int? = 3000
    var host: String? = "localhost"
    var processHandler: OSProcessHandler? = null
    private val json = Json {
        prettyPrint = true
        isLenient = true
        encodeDefaults = true
        ignoreUnknownKeys = true
    }
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(json)
        }
        install(WebSockets) {
            pingInterval = 10_000
            contentConverter = KotlinxWebsocketSerializationConverter(json)
        }
    }
    private val bus = project.messageBus

    suspend fun startForPath(path: String) {
        stop()

        val command = WingCommandLine.createConsole(project)

        processHandler = KillableProcessHandler(command)
        processHandler?.startNotify()
        this.path = path
        // wait 2 seconds for the server to start
        delay(2000)
        val publisher = bus.syncPublisher(WingConsoleListener.WING_CONSOLE_TOPIC)
        publisher.onStateChanged()
        publisher.onResourceFocusChanged()
        openWebSocket(publisher)
    }

    fun stop() {
        ExecutionManagerImpl.stopProcess(processHandler)
        processHandler = null
    }

    suspend fun getResources(): WingResource {
        return client.get("http://localhost:3000/trpc/app.explorerTree")
            .body<WingResponse<WingResource>>()
            .result
            .data
    }

    suspend fun getSelectedNode(): String {
        return client.get("http://localhost:3000/trpc/app.selectedNode")
            .body<WingResponse<String>>()
            .result
            .data
    }

    suspend fun selectNode(resourcePath: String) {
        client.post("http://localhost:3000/trpc/app.selectNode") {
            setBody(WingSelectNodeRequest(resourcePath))
            contentType(ContentType.Application.Json)
        }
    }

    private suspend fun openWebSocket(publisher: WingConsoleListener) {
        client.ws(host = "127.0.0.1", port = 3000, path = "/trpc") {
            sendSerialized(Subscription(params = Params(path = "app.invalidateQuery")))
            sendSerialized(Subscription(params = Params(path = "app.traces")))
            while (true) {
                val response = receiveDeserialized<SubscriptionQueryResponse<JsonElement>>()

                if (response.result.type == SubscriptionQueryResultType.DATA) {
                    val data = response.result.data
                    if (data is JsonPrimitive) {
                        val result = json.decodeFromString<InvalidateQueryResultData>(data.toString())

                        if (result == InvalidateQueryResultData.STATE) {
                            publisher.onStateChanged()
                        }
                    } else if (data is JsonObject) {
                        json.decodeFromString<WingTrace>(data.toString())

                        publisher.onResourceFocusChanged()
                    }
                }
            }
        }
    }

    // Websocket support -
    // ws://localhost:3000/trpc
    // { 	"id": 200, 	"method": "subscription", 	"params": { 		"path": "app.invalidateQuery" 	} }
    // For all trpc calls https://github.com/winglang/wing/blob/03d68be294d2dd60bed854a52a6ec30ebcbe62ed/apps/wing-console/console/server/src/router/app.ts#L52


    override fun dispose() {
        ExecutionManagerImpl.stopProcess(processHandler)
    }

    // { 	"id": 200, 	"method": "subscription", 	"params": { 		"path": "app.invalidateQuery" 	} }
    @Serializable
    data class Subscription(
        val id: Int = (0..1000).random(),
        val method: String = "subscription",
        val params: Params,
    )

    @Serializable
    data class Params(
        val path: String,
    )

    @Serializable
    data class SubscriptionQueryResponse<T>(
        val id: Int,
        val result: SubscriptionQueryResult<T>,
    )

    @Serializable
    data class SubscriptionQueryResult<T>(
        val type: SubscriptionQueryResultType,
        @Contextual()
        val data: T? = null
        // ▼ {"id":200,"result":{"type":"data","data":{"data":{"message":"List (prefix=null).","status":"success","result":"[]"},"type":"resource","sourcePath":"root/Default/cloud.Bucket","sourceType":"wingsdk.cloud.Bucket","timestamp":"2023-08-04T12:21:48.773Z"}}}
    )

    @Serializable
    enum class SubscriptionQueryResultType {
        @SerialName("started") STARTED,
        @SerialName("data") DATA,
    }

    @Serializable
    enum class InvalidateQueryResultData {
        @SerialName("app.error") ERROR,
        @SerialName("app.state") STATE,
        @SerialName("app.logs") LOGS,
    }

    @Serializable
    data class WingResponse<T>(
        val result: WingResult<T>,
    )


    @Serializable
    data class WingResult<T>(
        val data: T,
    )

    @Serializable
    data class WingTrace(
        val type: String,
        val sourcePath: String,
        val sourceType: String,
        val timestamp: String
    )

    @Serializable
    data class WingResource(
        val id: String,
        val label: String,
        val type: String,
        val childItems: List<WingResource>? = null,
        val display: ResourceDisplay? = null,
    ): NavigationItem {
        override fun toString() = this.label

        override fun getName() = this.label

        override fun getPresentation(): ItemPresentation {
            return PresentationData(
                this.label,
                this.type,
                WingIcons.FILE,
                null
            )
        }
    }

    @Serializable
    data class ResourceDisplay(
        val title: String,
        val description: String,
    )

    @Serializable
    data class WingSelectNodeRequest(val resourcePath: String)
}