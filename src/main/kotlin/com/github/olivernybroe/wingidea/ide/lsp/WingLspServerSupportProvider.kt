package com.github.olivernybroe.wingidea.ide.lsp

import com.github.olivernybroe.wingidea.WingIcons
import com.github.olivernybroe.wingidea.ide.WingCommandLine
import com.github.olivernybroe.wingidea.isWingFile
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.InsertHandler
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.editor.EditorModificationUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServerSupportProvider
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor
import com.intellij.platform.lsp.api.customization.LspCompletionSupport
import org.eclipse.lsp4j.CompletionItem
import javax.swing.Icon

@Suppress("UnstableApiUsage")
class WingLspServerSupportProvider : LspServerSupportProvider {
    override fun fileOpened(project: Project, file: VirtualFile, serverStarter: LspServerSupportProvider.LspServerStarter) {
        if (file.isWingFile) {
            serverStarter.ensureServerStarted(WingLspServerDescriptor(project))
        }
    }
}

@Suppress("UnstableApiUsage")
private class WingLspServerDescriptor(project: Project) : ProjectWideLspServerDescriptor(project, "Wing") {
    override fun isSupportedFile(file: VirtualFile) = file.extension == "w"
    override fun createCommandLine() = WingCommandLine.createLsp(project)

    override val lspCompletionSupport: LspCompletionSupport
        get() = object : LspCompletionSupport() {
            override fun getIcon(item: CompletionItem): Icon {
                return super.getIcon(item) ?: WingIcons.FILE
            }

            override fun createLookupElement(parameters: CompletionParameters, item: CompletionItem): LookupElement {
                val lookupElement = super.createLookupElement(parameters, item) as LookupElementBuilder

                val insertText = item.insertText

                // Handle function/method caret location for arguments.
                if (insertText?.contains("$") == true) {
                    return lookupElement.withInsertHandler { context, _ ->
                        context.document.replaceString(
                            context.startOffset,
                            context.tailOffset,
                            insertText.substringBefore("(")
                        )

                        EditorModificationUtil.insertStringAtCaret(context.editor, "()", false, 1)
                    }

                }

                return lookupElement
            }
        }
}