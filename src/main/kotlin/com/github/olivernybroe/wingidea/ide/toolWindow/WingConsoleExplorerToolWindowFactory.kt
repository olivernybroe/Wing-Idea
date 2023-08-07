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
import com.intellij.util.ui.tree.TreeUtil
import io.ktor.serialization.*
import io.ktor.serialization.kotlinx.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import javax.swing.JButton
import javax.swing.event.TreeSelectionEvent
import javax.swing.event.TreeSelectionListener
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.DefaultTreeModel
import javax.swing.tree.TreeSelectionModel


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
            RefreshResourcesAction(project.messageBus.syncPublisher(WingConsoleListener.WING_CONSOLE_TOPIC))
        ))
    }

    override fun shouldBeAvailable(project: Project) = true

    class WingConsoleExplorerView(toolWindow: ToolWindow): WingConsoleListener, TreeSelectionListener {
        private val consoleManager = toolWindow.project.service<WingConsoleManager>()
        private val rootNode = DefaultMutableTreeNode("root")
        private val treeModel = DefaultTreeModel(rootNode)
        private val tree = Tree(treeModel).also {
            it.selectionModel.selectionMode = TreeSelectionModel.SINGLE_TREE_SELECTION
            it.selectionModel.addTreeSelectionListener(this)
        }

        fun getContent() = tree

        override fun onStateChanged() {
            rootNode.removeAllChildren()
            val resources = runBlocking { consoleManager.getResources() }
            rootNode.userObject = resources

            resources.childItems?.forEach {
                rootNode.add(DefaultMutableTreeNode(it))
            }
            treeModel.nodeStructureChanged(rootNode)
        }

        override fun onResourceFocusChanged() {
            val path = runBlocking { consoleManager.getSelectedNode() }

            // Find a node where the userObject id is equal to the path
            val selectedNode = rootNode.children().toList().firstOrNull {
                if (it !is DefaultMutableTreeNode) {
                    return@firstOrNull false
                }
                val userObject = it.userObject
                if (userObject !is WingConsoleManager.WingResource) {
                    return@firstOrNull false
                }

                userObject.id == path
            } ?: return

            tree.selectionModel.selectionPath = TreeUtil.getPath(rootNode, selectedNode)
            tree.repaint()
        }

        override fun valueChanged(event: TreeSelectionEvent) {
            val nodes = tree.getSelectedNodes(DefaultMutableTreeNode::class.java, null)
            // TODO: send request to console about the selected node
        }
    }

    class RefreshResourcesAction(private val listener: WingConsoleListener): AnAction(AllIcons.Actions.Refresh) {
        override fun actionPerformed(event: AnActionEvent) {
            listener.onStateChanged()
        }
    }
}
