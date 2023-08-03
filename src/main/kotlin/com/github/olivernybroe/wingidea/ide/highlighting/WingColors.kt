package com.github.olivernybroe.wingidea.ide.highlighting

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey

/**
 * Defines the color attributes used for syntax highlighting.
 *
 * @see [WingSyntaxHighlighter] for the actual syntax highlighting.
 * @see [WingColorSettingsPage] for the color settings page.
 * @see [WingHighlightAnnotator] for PSI aware syntax highlighting.
 */
object WingColors {
    val BLOCK_COMMENT = createTextAttributesKey("WING_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT)
    val LINE_COMMENT = createTextAttributesKey("WING_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
    val STRING_LITERAL = createTextAttributesKey("WING_STRING_LITERAL", DefaultLanguageHighlighterColors.STRING)
    val KEYWORD = createTextAttributesKey("WING_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
    val IDENTIFIER = createTextAttributesKey("WING_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
    val NUMBER = createTextAttributesKey("WING_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
    val BRACES = createTextAttributesKey("WING_BRACES", DefaultLanguageHighlighterColors.BRACES)
    val PARENTHESES = createTextAttributesKey("WING_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES)
    val BRACKETS = createTextAttributesKey("WING_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
    val METHOD_DEFINITION_NAME = createTextAttributesKey("WING_METHOD_DEFINITION_NAME", DefaultLanguageHighlighterColors.INSTANCE_METHOD)
    val ENUM_FIELD = createTextAttributesKey("WING_ENUM_FIELD", DefaultLanguageHighlighterColors.STATIC_FIELD)
    val CLASS_FIELD = createTextAttributesKey("WING_CLASS_FIELD", DefaultLanguageHighlighterColors.INSTANCE_FIELD)
    val SEMI_COLON = createTextAttributesKey("WING_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON)
}
