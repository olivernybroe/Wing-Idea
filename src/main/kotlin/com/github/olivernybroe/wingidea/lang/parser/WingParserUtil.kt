package com.github.olivernybroe.wingidea.lang.parser

import com.github.olivernybroe.wingidea.WING_BUNDLE
import com.github.olivernybroe.wingidea.WingBundle
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiBuilderUtil
import com.intellij.lang.parser.GeneratedParserUtilBase
import com.intellij.psi.TokenType
import org.jetbrains.annotations.PropertyKey

class WingParserUtil : GeneratedParserUtilBase() {
    companion object {
        @JvmStatic
        fun consumeWithError(
            b: PsiBuilder,
            level: Int,
            rule: Parser,
            @PropertyKey(resourceBundle = WING_BUNDLE) messageKey: String
        ): Boolean {
            val marker = b.mark()
            val result = rule.parse(b, level)
            if (result) {
                marker.error(WingBundle.message(messageKey))
            }
            else {
                marker.rollbackTo()
            }
            return result
        }

        @JvmStatic
        fun isNewLine(b: PsiBuilder, @Suppress("UNUSED_PARAMETER") level: Int): Boolean {
            val step = -1
            val prevTokenType = b.rawLookup(step) ?: return true
            return prevTokenType == TokenType.WHITE_SPACE &&
                    PsiBuilderUtil.rawTokenText(b, step).contains('\n')
        }

        @JvmStatic
        fun isWhiteSpace(b: PsiBuilder, @Suppress("UNUSED_PARAMETER") level: Int): Boolean {
            return b.rawLookup(-1) == TokenType.WHITE_SPACE
        }
    }
}