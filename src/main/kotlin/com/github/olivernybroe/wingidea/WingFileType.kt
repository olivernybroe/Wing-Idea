package com.github.olivernybroe.wingidea

import com.intellij.openapi.fileTypes.LanguageFileType

class WingFileType: LanguageFileType(WingLanguage()) {
    override fun getName() = "Wing"
    override fun getDescription() = "Wing language file"
    override fun getDefaultExtension() = "w"
    override fun getIcon() = WingIcons.FILE

    companion object {
        val INSTANCE = WingFileType()
    }
}