package com.github.olivernybroe.wingidea.lang.lexer

import com.github.olivernybroe.wingidea.lang.parser.WingParserDefinition
import com.intellij.testFramework.ParsingTestCase

class WingStructParsingTest : ParsingTestCase("", "w", WingParserDefinition()) {
    fun testParser() = doTest(true)
    override fun getTestDataPath() = "src/test/testData/parser/struct"
    override fun skipSpaces() = true
    override fun includeRanges() = true
}