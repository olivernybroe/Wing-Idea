package com.github.olivernybroe.wingidea.ide.services

import com.github.olivernybroe.wingidea.ide.WingCommandLine
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.OSProcessHandler
import com.intellij.openapi.Disposable
import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project
import com.intellij.ui.jcef.JBCefBrowser
import com.intellij.ui.jcef.JBCefBrowserBuilder

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
    var browser: JBCefBrowser = JBCefBrowserBuilder().build()
    val isRunning: Boolean
        get() = processHandler?.isProcessTerminated == false

    fun startForPath(path: String) {
        if (isRunning) {
            stop()
        }

        val command = WingCommandLine.createConsole(project)

        processHandler = OSProcessHandler(command)
        browser.loadURL("http://localhost:3000")
        browser.cefBrowser.reload()
        this.path = path
    }

    fun stop() {
        processHandler?.destroyProcess()
        processHandler = null
    }

    fun restart() {
        if (path == null) {
            throw Exception("No path set")
        }

        startForPath(path!!)
    }
    fun isRunningForPath(path: String): Boolean {
        return this.path == path && isRunning
    }

    override fun dispose() {
        browser?.dispose()
    }
}