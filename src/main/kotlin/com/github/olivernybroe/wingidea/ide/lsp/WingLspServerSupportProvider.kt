package com.github.olivernybroe.wingidea.ide.lsp

import com.github.olivernybroe.wingidea.WingIcons
import com.github.olivernybroe.wingidea.ide.WingCommandLine
import com.github.olivernybroe.wingidea.isWingFile
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServerSupportProvider
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor
import com.intellij.platform.lsp.api.customization.LspCompletionSupport
import org.eclipse.lsp4j.CompletionItem
import javax.swing.Icon

class WingLspServerSupportProvider : LspServerSupportProvider {
    override fun fileOpened(project: Project, file: VirtualFile, serverStarter: LspServerSupportProvider.LspServerStarter) {
        if (file.isWingFile) {
            serverStarter.ensureServerStarted(WingLspServerDescriptor(project))
        }
    }
}

private class WingLspServerDescriptor(project: Project) : ProjectWideLspServerDescriptor(project, "Wing") {
    override fun isSupportedFile(file: VirtualFile) = file.extension == "w"
    override fun createCommandLine() = WingCommandLine.CreateLsp(project)

    override val lspCompletionSupport: LspCompletionSupport
        get() = object : LspCompletionSupport() {
            override fun getIcon(item: CompletionItem): Icon {
                return WingIcons.FILE
            }
        }
}