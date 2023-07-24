package com.github.olivernybroe.wingidea.ide.highlighting

import com.github.olivernybroe.wingidea.lang.lexer.WingLexer
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import com.github.olivernybroe.wingidea.lang.psi.WingElementTypes

class WingSyntaxHighlighter: SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer = WingLexer()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> =
        pack(attributes[tokenType])

    companion object {
        private val attributes = buildMap<IElementType, TextAttributesKey> {
            put(WingElementTypes.STRING_LITERAL, WingColors.STRING_LITERAL)
            put(WingElementTypes.IDENTIFIER, WingColors.IDENTIFIER)
            put(WingElementTypes.NUMBER, WingColors.NUMBER)
            put(WingElementTypes.COMMENT, WingColors.LINE_COMMENT)
            put(WingElementTypes.MULTI_LINE_COMMENT, WingColors.BLOCK_COMMENT)
        }
    }
}