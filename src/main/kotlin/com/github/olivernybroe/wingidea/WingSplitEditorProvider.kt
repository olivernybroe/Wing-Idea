package com.github.olivernybroe.wingidea

import com.github.olivernybroe.wingidea.lang.WingFileType
import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorPolicy
import com.intellij.openapi.fileEditor.FileEditorProvider
import com.intellij.openapi.fileEditor.TextEditor
import com.intellij.openapi.fileEditor.TextEditorWithPreview
import com.intellij.openapi.fileEditor.impl.text.PsiAwareTextEditorProvider
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile


class WingSplitEditorProvider: FileEditorProvider, DumbAware {
    override fun accept(project: Project, virtualFile: VirtualFile): Boolean {
        return virtualFile.fileType is WingFileType
    }

    override fun createEditor(project: Project, virtualFile: VirtualFile): FileEditor {
        val textEditor = PsiAwareTextEditorProvider().createEditor(project, virtualFile) as TextEditor
        val wingPreview = WingPreviewEditorProvider().createEditor(project, virtualFile)
        return TextEditorWithPreview(textEditor, wingPreview)
    }

    override fun getEditorTypeId(): String {
        return "Wing Editor"
    }

    override fun getPolicy(): FileEditorPolicy {
        return FileEditorPolicy.HIDE_DEFAULT_EDITOR
    }
}
