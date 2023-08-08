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
import com.intellij.openapi.components.service
import com.intellij.ui.treeStructure.Tree
import com.intellij.util.ui.tree.TreeUtil
import kotlinx.coroutines.runBlocking
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
        val consoleExplorerView = WingConsoleExplorerView(toolWindow)
        project.messageBus.connect().subscribe(WingConsoleListener.WING_CONSOLE_TOPIC, consoleExplorerView)
        val content = ContentFactory.getInstance().createContent(consoleExplorerView.getContent(), null, false)
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

        override fun onConnectionChanged() {
            onResourceFocusChanged()
            onStateChanged()
        }

        /**
         * When the user selects an item in the tree, we want to select the same item in the Wing console.
         */
        override fun valueChanged(event: TreeSelectionEvent) {
            val nodes = tree.getSelectedNodes(DefaultMutableTreeNode::class.java, null)

            if (nodes.size != 1) {
                return
            }

            val node = nodes[0]
            if (node !is DefaultMutableTreeNode) {
                return
            }
            val userObject = node.userObject
            if (userObject !is WingConsoleManager.WingResource) {
                return
            }

            runBlocking { consoleManager.selectNode(userObject.id) }
        }
    }

    class RefreshResourcesAction(private val listener: WingConsoleListener): AnAction(AllIcons.Actions.Refresh) {
        override fun actionPerformed(event: AnActionEvent) {
            listener.onStateChanged()
        }
    }
}
