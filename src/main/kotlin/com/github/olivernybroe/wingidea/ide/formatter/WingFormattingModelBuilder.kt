package com.github.olivernybroe.wingidea.ide.formatter

import com.intellij.formatting.FormattingContext
import com.intellij.formatting.FormattingModel
import com.intellij.formatting.FormattingModelBuilder
import com.intellij.formatting.FormattingModelProvider

class WingFormattingModelBuilder: FormattingModelBuilder {
    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val file = formattingContext.containingFile
        val settings = formattingContext.codeStyleSettings
        val block = WingFormatBlock(formattingContext.node, null, null)
        return FormattingModelProvider.createFormattingModelForPsiFile(file, block, settings)
    }
}