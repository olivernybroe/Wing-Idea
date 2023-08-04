package com.github.olivernybroe.wingidea.ide.toolWindow

import com.github.olivernybroe.wingidea.ide.services.WingConsoleListener
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.components.JBPanel
import com.intellij.ui.content.ContentFactory
import com.github.olivernybroe.wingidea.ide.services.WingConsoleManager
import com.intellij.icons.AllIcons
import com.intellij.icons.AllIcons.Icons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.components.service
import com.intellij.ui.components.JBTreeTable
import com.intellij.ui.jcef.JBCefBrowserBuilder
import com.intellij.ui.treeStructure.Tree
import io.ktor.serialization.*
import io.ktor.serialization.kotlinx.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import javax.swing.JButton
import javax.swing.tree.DefaultMutableTreeNode


/**
 * Defines the explorer window for Wing as a tool window.
 */
class WingConsoleExplorerToolWindowFactory : ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val myToolWindow = WingConsoleExplorerView(toolWindow)
        project.messageBus.connect().subscribe(WingConsoleListener.WING_CONSOLE_TOPIC, myToolWindow)
        val content = ContentFactory.getInstance().createContent(myToolWindow.getContent(), null, false)
        toolWindow.contentManager.addContent(content)
        toolWindow.setTitleActions(listOf(
            RefreshResourcesAction(myToolWindow)
        ))
    }

    override fun shouldBeAvailable(project: Project) = true

    class WingConsoleExplorerView(toolWindow: ToolWindow): WingConsoleListener {
        private val consoleManager = toolWindow.project.service<WingConsoleManager>()
        private val treeModel = DefaultMutableTreeNode("root")

        fun getContent() = Tree(treeModel)

        override suspend fun onStateChanged() {
            treeModel.removeAllChildren()
            val resources = consoleManager.getResources()
            treeModel.userObject = resources

            consoleManager.getResources().childItems?.forEach {
                treeModel.add(DefaultMutableTreeNode(it))
            }
        }
    }

    class RefreshResourcesAction(private val wingConsoleExplorerView: WingConsoleExplorerView): AnAction(AllIcons.Actions.Refresh) {
        override fun actionPerformed(event: AnActionEvent) {
            CoroutineScope(Dispatchers.Default).launch {
                wingConsoleExplorerView.onStateChanged()
            }
        }
    }
}
