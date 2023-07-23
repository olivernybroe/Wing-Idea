package com.github.olivernybroe.wingidea.listeners

import com.intellij.openapi.application.ApplicationActivationListener
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.wm.IdeFrame
import org.jetbrains.plugins.textmate.TextMateService
import org.jetbrains.plugins.textmate.configuration.TextMateUserBundlesSettings

internal class MyApplicationActivationListener : ApplicationActivationListener {

    override fun applicationActivated(ideFrame: IdeFrame) {
        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")

        TextMateUserBundlesSettings.instance!!.addBundle("C:\\Users\\olive\\IdeaProjects\\Wing-Idea\\gen\\vscode-wing", "Wing")
        // TextMateService.getInstance().reloadEnabledBundles()
    }
}
