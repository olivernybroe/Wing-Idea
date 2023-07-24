package com.github.olivernybroe.wingidea.lang.psi

import com.github.olivernybroe.wingidea.lang.WingLanguage
import com.github.olivernybroe.wingidea.lang.psi.WingElementTypes.*
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet.create

class WingTokenType(debugName: String): IElementType(debugName, WingLanguage)

val WING_STRINGS = create(STRING_LITERAL)
val WING_COMMENTS = create(COMMENT, MULTI_LINE_COMMENT)