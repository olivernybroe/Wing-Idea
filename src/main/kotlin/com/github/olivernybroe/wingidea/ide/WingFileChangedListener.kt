package com.github.olivernybroe.wingidea.ide

import com.github.olivernybroe.wingidea.ide.services.WingConsoleManager
import com.github.olivernybroe.wingidea.lang.WingFileType
import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.invokeLater
import com.intellij.openapi.application.runReadAction
import com.intellij.openapi.components.service
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.FileEditorManagerEvent
import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.progress.runBackgroundableTask
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.concurrency.executeOnPooledIoThread
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


        ApplicationManager.getApplication().executeOnPooledThread {
            if (consoleManager.path == path) {
                return@executeOnPooledThread
            }

            runBlocking {
                consoleManager.startForPath(path)
            }
        }
    }
}