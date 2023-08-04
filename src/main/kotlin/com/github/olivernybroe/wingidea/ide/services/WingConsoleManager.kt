package com.github.olivernybroe.wingidea.ide.services

import com.github.olivernybroe.wingidea.WingIcons
import com.github.olivernybroe.wingidea.ide.WingCommandLine
import com.intellij.execution.process.OSProcessHandler
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.navigation.NavigationItem
import com.intellij.openapi.Disposable
import com.intellij.openapi.components.Service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.intellij.pom.Navigatable
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.websocket.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.*
import io.ktor.serialization.kotlinx.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.websocket.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

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
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                encodeDefaults = true
            })
        }
        install(WebSockets) {
            pingInterval = 10_000
            contentConverter = KotlinxWebsocketSerializationConverter(Json {
                prettyPrint = true
                isLenient = true
                encodeDefaults = true
            })
        }
    }
    private val bus = project.messageBus

    val isRunning: Boolean
        get() = processHandler?.isProcessTerminated == false

    suspend fun startForPath(path: String) {
        if (isRunning) {
            stop()
        }

        val command = WingCommandLine.createConsole(project)

        processHandler = OSProcessHandler(command)
        this.path = path
        openWebSocket()
    }

    fun stop() {
        processHandler?.destroyProcess()
        processHandler = null
    }

    fun isRunningForPath(path: String): Boolean {
        return this.path == path && isRunning
    }

    suspend fun getResources(): WingResource {
        return client.get("http://localhost:3000/trpc/app.explorerTree")
            .body<Response<WingResource>>()
            .result
            .data
    }

    suspend fun openWebSocket() {
        client.ws(host = "127.0.0.1", port = 3000, path = "/trpc") {
            val publisher = bus.syncPublisher(WingConsoleListener.WING_CONSOLE_TOPIC)
            sendSerialized(Subscription(params = Params(path = "app.invalidateQuery")))
            while (true) {
                val data = receiveDeserialized<InvalidateQueryResponse>()

                if (data.result.type == InvalidateQueryResultType.DATA) {
                    if (data.result.data === InvalidateQueryResultData.STATE) {
                        publisher.onStateChanged()
                    }
                }
            }
        }
    }

    // Websocket support -
    // ws://localhost:3000/trpc
    // { 	"id": 200, 	"method": "subscription", 	"params": { 		"path": "app.invalidateQuery" 	} }
    // For all trcpc calls https://github.com/winglang/wing/blob/03d68be294d2dd60bed854a52a6ec30ebcbe62ed/apps/wing-console/console/server/src/router/app.ts#L52


    override fun dispose() {
        processHandler?.destroyProcess()
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
    data class InvalidateQueryResponse(
        val id: Int,
        val result: InvalidateQueryResult,
    )

    @Serializable
    data class InvalidateQueryResult(
        val type: InvalidateQueryResultType,
        val data: InvalidateQueryResultData? = null
    )

    @Serializable
    enum class InvalidateQueryResultType {
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
    data class Response<T>(
        val result: Result<T>,
    )


    @Serializable
    data class Result<T>(
        val data: T,
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
}