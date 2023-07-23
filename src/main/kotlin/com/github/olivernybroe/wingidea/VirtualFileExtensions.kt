package com.github.olivernybroe.wingidea

import com.intellij.openapi.vfs.VirtualFile

val VirtualFile.isWingFile: Boolean
    get() {
        return this.extension == "w"
    }