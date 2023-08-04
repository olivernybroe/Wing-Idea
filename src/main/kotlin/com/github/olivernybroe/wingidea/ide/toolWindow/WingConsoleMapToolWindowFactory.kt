package com.github.olivernybroe.wingidea.ide.toolWindow

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import com.github.olivernybroe.wingidea.ide.services.WingConsoleManager
import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.components.service
import com.intellij.ui.jcef.JBCefBrowserBuilder


/**
 * Defines the Graph view for Wing as a tool window.
 */
class WingConsoleMapToolWindowFactory : ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val myToolWindow = WingConsoleMapView(toolWindow)
        val content = ContentFactory.getInstance().createContent(myToolWindow.getContent(), null, false)
        toolWindow.contentManager.addContent(content)
        toolWindow.setTitleActions(listOf(
            RefreshWingBrowserAction(myToolWindow)
        ))
    }

    override fun shouldBeAvailable(project: Project) = true

    class WingConsoleMapView(toolWindow: ToolWindow) {
        private val consoleManager = toolWindow.project.service<WingConsoleManager>()
        val browser = JBCefBrowserBuilder().setUrl("${consoleManager.host}:${consoleManager.port}").build()

        fun getContent() = browser.component
    }

    class RefreshWingBrowserAction(private val wingConsoleMapView: WingConsoleMapView): AnAction(AllIcons.Actions.Refresh) {
        override fun actionPerformed(event: AnActionEvent) {
            wingConsoleMapView.browser.cefBrowser.reload()
        }
    }
}
