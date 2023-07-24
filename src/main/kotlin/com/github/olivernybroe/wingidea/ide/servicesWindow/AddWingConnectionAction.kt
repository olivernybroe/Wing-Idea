package com.github.olivernybroe.wingidea.ide.servicesWindow

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareAction
import com.intellij.remoteServer.configuration.RemoteServersManager

/**
 * Adds an action to the services menu to add a Wing connection.
 */
class AddWingConnectionAction: DumbAwareAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val manager = RemoteServersManager.getInstance()
        val server = manager.createServer(WingServerType(event.project!!))
        manager.addServer(server)
    }
}