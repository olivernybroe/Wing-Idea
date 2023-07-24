package com.github.olivernybroe.wingidea.lang.psi

import com.github.olivernybroe.wingidea.lang.WingLanguage
import com.github.olivernybroe.wingidea.lang.psi.WingElementTypes.*
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet.create

class WingTokenType(debugName: String): IElementType(debugName, WingLanguage)

val WING_STRINGS = create(STRING_LITERAL)
val WING_COMMENTS = create(COMMENT, MULTI_LINE_COMMENT)
val WING_KEYWORDS = create(LET, NEW, INFLIGHT_SPECIFIER, INTERFACE, CLASS, ELSE, DEFER, IF, ELIF, BRING, CATCH, BREAK, CONTINUE, FOR, IN, RETURN, STATIC, VAR, WHILE, TRY, FINALLY, EXTENDS, IMPLEMENTS)
val WING_BRACES = create(LEFT_CURLY_BRACE, RIGHT_CURLY_BRACE)
val WING_BRACKETS = create(LEFT_SQUARE_BRACE, RIGHT_SQUARE_BRACE)
val WING_PARENTHESIS = create(LEFT_PARENTHESIS, RIGHT_PARENTHESIS)