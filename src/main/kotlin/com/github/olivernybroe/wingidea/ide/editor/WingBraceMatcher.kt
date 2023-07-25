package com.github.olivernybroe.wingidea.ide.editor

import com.github.olivernybroe.wingidea.lang.psi.WingElementTypes
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

/**
 * Defines the brace matching for the Wing language.
 *
 * Makes sure that the correct brace is highlighted when the cursor is next to a brace.
 */
class WingBraceMatcher: PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> = braces

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean = true

    override fun getCodeConstructStart(file: PsiFile, openingBraceOffset: Int): Int = openingBraceOffset

    companion object {
        private val braces = arrayOf(
            BracePair(WingElementTypes.LEFT_CURLY_BRACE, WingElementTypes.RIGHT_CURLY_BRACE, true),
            BracePair(WingElementTypes.LEFT_SQUARE_BRACE, WingElementTypes.RIGHT_SQUARE_BRACE, false),
            BracePair(WingElementTypes.LEFT_PARENTHESIS, WingElementTypes.RIGHT_PARENTHESIS, false),
        )
    }
}