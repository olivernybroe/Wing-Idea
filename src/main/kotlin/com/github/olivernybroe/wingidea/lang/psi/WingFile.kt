package com.github.olivernybroe.wingidea.lang.psi

import com.github.olivernybroe.wingidea.lang.WingFileType
import com.github.olivernybroe.wingidea.lang.WingLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

/**
 * Defines the wrapper for Wing files.
 */
class WingFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, WingLanguage) {
    override fun getFileType(): FileType = WingFileType
}