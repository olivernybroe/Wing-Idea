package com.github.olivernybroe.wingidea.lang.lexer

import com.intellij.lexer.Lexer
import com.intellij.testFramework.LexerTestCase

class WingLexerTest: LexerTestCase() {
    override fun createLexer(): Lexer {
        return WingLexer()
    }

    override fun getDirPath(): String = "src/test/testData/lexer"

    fun testLexer() = doFileTest("wing")
    fun testLexer2() = doTest("struct MyStruct {\n" +
            "  field1: num;\n" +
            "  field2: str;\n" +
            "}")
}