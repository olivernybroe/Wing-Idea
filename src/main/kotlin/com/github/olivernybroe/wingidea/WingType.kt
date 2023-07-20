package com.github.olivernybroe.wingidea

import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.remoteServer.ServerType
import com.intellij.remoteServer.configuration.RemoteServer
import com.intellij.remoteServer.configuration.ServerConfigurationBase
import com.intellij.remoteServer.configuration.deployment.DeploymentConfigurationBase
import com.intellij.remoteServer.configuration.deployment.DeploymentConfigurator
import com.intellij.remoteServer.configuration.deployment.DeploymentSource
import com.intellij.remoteServer.runtime.ServerConnector
import com.intellij.remoteServer.runtime.ServerTaskExecutor
import com.intellij.remoteServer.runtime.deployment.DeploymentLogManager
import com.intellij.remoteServer.runtime.deployment.DeploymentTask
import com.intellij.remoteServer.runtime.deployment.ServerRuntimeInstance
import javax.swing.Icon
import javax.swing.JComponent
import javax.swing.JLabel

class WingType: ServerType<WingConfiguration>("wing") {
    override fun getPresentableName() = "Wing"

    override fun getIcon() = WingIcons.FILE

    override fun createDefaultConfiguration(): WingConfiguration {
        return WingConfiguration()
    }

    override fun createDeploymentConfigurator(project: Project): DeploymentConfigurator<*, WingConfiguration> {
        return WingDeploymentConfigurator(project)
    }

    override fun createConnector(configuration: WingConfiguration, serverTaskExecutor: ServerTaskExecutor): ServerConnector<*> {
        return object : ServerConnector<WingDeploymentConfiguration>() {
            override fun connect(connectionCallback: ConnectionCallback<WingDeploymentConfiguration>) {
                connectionCallback.connected(object : ServerRuntimeInstance<WingDeploymentConfiguration>() {
                    override fun deploy(
                        deploymentTask: DeploymentTask<WingDeploymentConfiguration>,
                        deploymentLogManager: DeploymentLogManager,
                        deploymentOperationCallback: DeploymentOperationCallback
                    ) {

                    }

                    override fun computeDeployments(p0: ComputeDeploymentsCallback) {
                        TODO("Not yet implemented")
                    }

                    override fun disconnect() {
                        TODO("Not yet implemented")
                    }

                })
            }

        }
    }
}

class WingDeploymentConfigurator(project: Project): DeploymentConfigurator<WingDeploymentConfiguration, WingConfiguration>() {
    override fun getAvailableDeploymentSources(): MutableList<DeploymentSource> {
        return mutableListOf()
    }

    override fun createDefaultConfiguration(deploymentSource: DeploymentSource): WingDeploymentConfiguration {
        return WingDeploymentConfiguration()
    }

    override fun createEditor(
        deploymentSource: DeploymentSource,
        remoteServer: RemoteServer<WingConfiguration>?
    ): SettingsEditor<WingDeploymentConfiguration> {
        return object : SettingsEditor<WingDeploymentConfiguration>() {
            override fun resetEditorFrom(configuration: WingDeploymentConfiguration) {
            }

            override fun applyEditorTo(configuration: WingDeploymentConfiguration) {
            }

            override fun createEditor(): JComponent {
                return JLabel("Wing Deployment Editor")
            }
        }
    }

}

class WingDeploymentConfiguration: DeploymentConfigurationBase<WingDeploymentConfiguration>()


class WingConfiguration: ServerConfigurationBase<WingConfiguration>() {

}
