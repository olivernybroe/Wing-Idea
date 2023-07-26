package com.github.olivernybroe.wingidea.ide.servicesWindow

import com.github.olivernybroe.wingidea.WingIcons
import com.github.olivernybroe.wingidea.ide.WingCommandLine
import com.intellij.execution.process.OSProcessHandler
import com.intellij.execution.process.ProcessEvent
import com.intellij.execution.process.ProcessListener
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
import javax.swing.JComponent
import javax.swing.JLabel

class WingServerType(val project: Project) : ServerType<WingConfiguration>("wing") {
    override fun getPresentableName() = "Wing"

    override fun getIcon() = WingIcons.FILE

    override fun createDefaultConfiguration(): WingConfiguration {
        return WingConfiguration(project)
    }

    override fun createDeploymentConfigurator(project: Project): DeploymentConfigurator<*, WingConfiguration> {
        return WingDeploymentConfigurator()
    }

    override fun createConnector(configuration: WingConfiguration, serverTaskExecutor: ServerTaskExecutor): ServerConnector<*> {
        return object : ServerConnector<WingDeploymentConfiguration>() {
            override fun connect(connectionCallback: ConnectionCallback<WingDeploymentConfiguration>) {
                val command = WingCommandLine.CreateConsole(configuration.project)

                serverTaskExecutor.submit {
                    val process = OSProcessHandler(command)
                    process.addProcessListener(object : ProcessListener {
                        override fun processTerminated(event: ProcessEvent) {
                            connectionCallback.errorOccurred("Wing it stopped running with exit code ${event.exitCode}")
                        }
                    })

                    connectionCallback.connected(object : ServerRuntimeInstance<WingDeploymentConfiguration>() {
                        override fun deploy(
                            deploymentTask: DeploymentTask<WingDeploymentConfiguration>,
                            deploymentLogManager: DeploymentLogManager,
                            deploymentOperationCallback: DeploymentOperationCallback
                        ) {
                            TODO("Deployment not implemented yet")
                        }

                        override fun computeDeployments(callback: ComputeDeploymentsCallback) {
                        }

                        override fun disconnect() {
                            process.destroyProcess()
                        }

                    })
                }
            }

        }
    }
}

class WingDeploymentConfigurator(): DeploymentConfigurator<WingDeploymentConfiguration, WingConfiguration>() {
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


class WingConfiguration(val project: Project) : ServerConfigurationBase<WingConfiguration>() {

}
