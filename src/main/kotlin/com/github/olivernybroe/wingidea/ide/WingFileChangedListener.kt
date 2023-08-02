package com.github.olivernybroe.wingidea.ide

import com.github.olivernybroe.wingidea.ide.services.WingConsoleManager
import com.github.olivernybroe.wingidea.lang.WingFileType
import com.intellij.openapi.Disposable
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.fileEditor.FileEditorManagerEvent
import com.intellij.openapi.fileEditor.FileEditorManagerListener

class WingFileChangedListener(private val consoleManager: WingConsoleManager): Disposable, FileEditorManagerListener {
    var editor: Editor? = null
    override fun dispose() {
        // consoleManager.dispose()
    }

    override fun selectionChanged(event: FileEditorManagerEvent) {
        val newFile = event.newFile ?: return

        if (newFile.fileType !is WingFileType) return

        val path = newFile.path

        if (consoleManager.isRunningForPath(path)) {
            return
        }

        consoleManager.startForPath(path)
    }
}