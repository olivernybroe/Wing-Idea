package com.github.olivernybroe.wingidea.ide

import com.github.olivernybroe.wingidea.ide.services.WingConsoleManager
import com.github.olivernybroe.wingidea.lang.WingFileType
import com.intellij.openapi.Disposable
import com.intellij.openapi.components.service
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.FileEditorManagerEvent
import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class WingFileChangedListener: Disposable, FileEditorManagerListener {
    var editor: Editor? = null
    override fun dispose() {
    }

    override fun selectionChanged(event: FileEditorManagerEvent) {
        val newFile = event.newFile ?: return

        startConsole(newFile, event.manager.project)
    }

    private fun startConsole(file: VirtualFile, project: Project) {
        val consoleManager = project.service<WingConsoleManager>()
        if (file.fileType !is WingFileType) return

        val path = file.path

        CoroutineScope(Dispatchers.Default).launch {
            if (consoleManager.path == path) {
                return@launch
            }

            consoleManager.startForPath(path)
        }
    }
}