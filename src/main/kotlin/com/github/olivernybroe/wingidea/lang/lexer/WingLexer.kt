package com.github.olivernybroe.wingidea.lang.lexer

import com.github.olivernybroe.wingidea.lang.parser._WingLexer
import com.intellij.lexer.FlexAdapter

/**
 * Defines the lexer for the Wing language.
 *
 * For the actual lexer, see [grammars/Wing.flex] and [grammars/Wing.bnf]
 */
class WingLexer : FlexAdapter(_WingLexer())