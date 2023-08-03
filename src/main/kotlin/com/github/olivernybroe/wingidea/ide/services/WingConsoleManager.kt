package com.github.olivernybroe.wingidea.ide.services

import com.github.olivernybroe.wingidea.ide.WingCommandLine
import com.intellij.execution.process.OSProcessHandler
import com.intellij.openapi.Disposable
import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
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
            })
        }
    }

    val isRunning: Boolean
        get() = processHandler?.isProcessTerminated == false

    fun startForPath(path: String) {
        if (isRunning) {
            stop()
        }

        val command = WingCommandLine.createConsole(project)

        processHandler = OSProcessHandler(command)
        this.path = path
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

    // Websocket support -
    // ws://localhost:3000/trpc
    // { 	"id": 200, 	"method": "subscription", 	"params": { 		"path": "app.invalidateQuery" 	} }
    // For all trcpc calls https://github.com/winglang/wing/blob/03d68be294d2dd60bed854a52a6ec30ebcbe62ed/apps/wing-console/console/server/src/router/app.ts#L52


    override fun dispose() {
        processHandler?.destroyProcess()
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
    )

    @Serializable
    data class ResourceDisplay(
        val title: String,
        val description: String,
    )
}