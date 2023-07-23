package com.github.olivernybroe.wingidea

import com.intellij.ide.FileIconProvider
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

class WingFileIconProvider: FileIconProvider {
    override fun getIcon(virtualFile: VirtualFile, flags: Int, project: Project?): Icon? {
        if (virtualFile.isWingFile) {
            return WingIcons.FILE
        }

        return null
    }
}