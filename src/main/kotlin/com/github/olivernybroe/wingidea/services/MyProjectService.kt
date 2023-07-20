package com.github.olivernybroe.wingidea.services

import com.intellij.openapi.components.Service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.github.olivernybroe.wingidea.MyBundle
import com.github.olivernybroe.wingidea.WingCommandLine
import org.jetbrains.plugins.textmate.TextMateService
import org.jetbrains.plugins.textmate.configuration.TextMateConfigurableBundle
import org.jetbrains.plugins.textmate.configuration.TextMateConfigurableData
import org.jetbrains.plugins.textmate.configuration.TextMateUserBundlesSettings
import kotlin.io.path.pathString

@Service(Service.Level.PROJECT)
class MyProjectService(project: Project) {

    init {
        thisLogger().info(MyBundle.message("projectService", project.name))
        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")

        // TextMateUserBundlesSettings.instance!!.addBundle("/Users/oliver.nybroe/Code/github/winglang/wing/apps/vscode-wing", "Wing")

        WingCommandLine.CreateConsole(project).toProcessBuilder().start()
    }

    fun getRandomNumber() = (1..100).random()
}
