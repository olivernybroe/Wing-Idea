package com.github.olivernybroe.wingidea

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareAction
import com.intellij.remoteServer.configuration.RemoteServersManager

class AddWingConnectionAction: DumbAwareAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val manager = RemoteServersManager.getInstance()
        val server = manager.createServer(WingType())
        manager.addServer(server)
    }
}