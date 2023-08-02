package com.github.olivernybroe.wingidea.ide.toolWindow

import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPanel
import com.intellij.ui.content.ContentFactory
import com.github.olivernybroe.wingidea.WingBundle
import com.github.olivernybroe.wingidea.ide.services.WingConsoleManager
import com.intellij.openapi.components.service
import com.intellij.ui.jcef.JBCefBrowser
import com.intellij.ui.jcef.JBCefBrowserBuilder
import javax.swing.JButton


/**
 * Defines the tool window for Wing.
 */
class WingToolWindowFactory : ToolWindowFactory {

    init {
        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
    }

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val myToolWindow = MyToolWindow(toolWindow)
        val content = ContentFactory.getInstance().createContent(myToolWindow.getContent(), null, false)
        toolWindow.contentManager.addContent(content)
    }

    override fun shouldBeAvailable(project: Project) = true

    class MyToolWindow(toolWindow: ToolWindow) {
        private val consoleManager = toolWindow.project.service<WingConsoleManager>()
        private val browser = JBCefBrowserBuilder().setUrl("${consoleManager.host}:${consoleManager.port}").build()

        fun getContent() = JBPanel<JBPanel<*>>().apply {
            add(browser.component)
        }
    }
}
