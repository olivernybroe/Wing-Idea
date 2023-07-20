package com.github.olivernybroe.wingidea

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServerSupportProvider
import com.intellij.platform.lsp.api.LspServerSupportProvider.LspServerStarter
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor

class WingLspServerSupportProvider : LspServerSupportProvider {
    override fun fileOpened(project: Project, file: VirtualFile, serverStarter: LspServerStarter) {
        if (file.extension == "w") {
            serverStarter.ensureServerStarted(WingLspServerDescriptor(project))
        }
    }
}
private class WingLspServerDescriptor(project: Project) : ProjectWideLspServerDescriptor(project, "Wing") {
    override fun isSupportedFile(file: VirtualFile) = file.extension == "w"
    override fun createCommandLine() = GeneralCommandLine("wing", "lsp")
}