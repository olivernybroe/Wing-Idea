package com.github.olivernybroe.wingidea.ide

import com.github.olivernybroe.wingidea.ide.services.WingConsoleManager
import com.intellij.openapi.components.service
import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity

class WingFileChangedStartupActivity: ProjectActivity {
    override suspend fun execute(project: Project) {
        val consoleManager = project.service<WingConsoleManager>()
        val fileChangedListener = WingFileChangedListener(consoleManager)

        val messageBus = project.messageBus.connect(fileChangedListener)
        messageBus.subscribe<FileEditorManagerListener>(
            FileEditorManagerListener.FILE_EDITOR_MANAGER,
            fileChangedListener
        )
    }
}