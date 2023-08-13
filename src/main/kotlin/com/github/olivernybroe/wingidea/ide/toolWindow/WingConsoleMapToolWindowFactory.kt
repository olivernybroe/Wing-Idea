package com.github.olivernybroe.wingidea.ide.toolWindow

import com.github.olivernybroe.wingidea.ide.services.WingConsoleListener
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import com.github.olivernybroe.wingidea.ide.services.WingConsoleManager
import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.service
import com.intellij.ui.jcef.JBCefBrowserBuilder
import kotlinx.coroutines.runBlocking


private const val WING_CONSOLE_IDE_LAYOUT = 4

/**
 * Defines the Graph view for Wing as a tool window.
 */
class WingConsoleMapToolWindowFactory : ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val wingConsoleMapView = WingConsoleMapView(toolWindow)
        project.messageBus.connect().subscribe(WingConsoleListener.WING_CONSOLE_TOPIC, wingConsoleMapView)
        val content = ContentFactory.getInstance().createContent(wingConsoleMapView.getContent(), null, false)
        toolWindow.contentManager.addContent(content)
        toolWindow.setTitleActions(listOf(
            RefreshWingBrowserAction(wingConsoleMapView),
            StopWingConsoleAction(project),
            StartWingConsoleAction(project)
        ))
    }

    override fun shouldBeAvailable(project: Project) = true

    class WingConsoleMapView(toolWindow: ToolWindow): WingConsoleListener {
        private val consoleManager = toolWindow.project.service<WingConsoleManager>()
        val browser = JBCefBrowserBuilder().setUrl(createUrl()).build()

        fun getContent() = browser.component

        private fun createUrl() = "${consoleManager.host}:${consoleManager.port}?layout=$WING_CONSOLE_IDE_LAYOUT"

        override fun onConnectionChanged() {
            browser.loadURL(createUrl())
            browser.cefBrowser.reload()
        }
    }

    class RefreshWingBrowserAction(private val wingConsoleMapView: WingConsoleMapView): AnAction(AllIcons.Actions.Refresh) {
        override fun actionPerformed(event: AnActionEvent) {
            wingConsoleMapView.browser.cefBrowser.reload()
        }
    }

    class StopWingConsoleAction(project: Project): AnAction(AllIcons.Actions.Run_anything) {
        private val consoleManager = project.service<WingConsoleManager>()
        override fun actionPerformed(event: AnActionEvent) {
            consoleManager.stop()
        }
    }

    class StartWingConsoleAction(project: Project): AnAction(AllIcons.Actions.StopRefresh) {
        private val consoleManager = project.service<WingConsoleManager>()
        override fun actionPerformed(event: AnActionEvent) {
            ApplicationManager.getApplication().executeOnPooledThread {
                runBlocking {
                    consoleManager.startForPath(consoleManager.path ?: "")
                }
            }
        }
    }
}
