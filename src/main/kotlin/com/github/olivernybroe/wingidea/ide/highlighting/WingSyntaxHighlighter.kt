package com.github.olivernybroe.wingidea.ide.highlighting

import com.github.olivernybroe.wingidea.lang.lexer.WingLexer
import com.github.olivernybroe.wingidea.lang.psi.*
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import com.github.olivernybroe.wingidea.lang.psi.WingElementTypes

/**
 * Defines the syntax highlighting for the Wing language.
 * Only allows for basic syntax highlighting, for PSI aware syntax highlighting see [WingHighlightAnnotator].
 */
class WingSyntaxHighlighter: SyntaxHighlighterBase() {

    override fun getHighlightingLexer() = WingLexer()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> =
        pack(attributes[tokenType])

    companion object {
        private val attributes = buildMap<IElementType, TextAttributesKey> {
            put(WingElementTypes.STRING_LITERAL, WingColors.STRING_LITERAL)
            put(WingElementTypes.IDENTIFIER, WingColors.IDENTIFIER)
            put(WingElementTypes.NUMBER, WingColors.NUMBER)
            put(WingElementTypes.COMMENT, WingColors.LINE_COMMENT)
            put(WingElementTypes.MULTI_LINE_COMMENT, WingColors.BLOCK_COMMENT)
            put(WingElementTypes.SEMICOLON, WingColors.SEMI_COLON)

            fillMap(this, WING_KEYWORDS, WingColors.KEYWORD)
            fillMap(this, WING_BRACES, WingColors.BRACES)
            fillMap(this, WING_BRACKETS, WingColors.BRACKETS)
            fillMap(this, WING_PARENTHESIS, WingColors.PARENTHESES)
        }
    }
}