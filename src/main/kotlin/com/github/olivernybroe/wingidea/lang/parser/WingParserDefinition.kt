package com.github.olivernybroe.wingidea.lang.parser

import com.github.olivernybroe.wingidea.lang.lexer.WingLexer
import com.github.olivernybroe.wingidea.lang.psi.*
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

/**
 * Defines the parser definition for the Wing language.
 */
class WingParserDefinition: ParserDefinition {
    override fun createLexer(project: Project?): Lexer = WingLexer()

    override fun createParser(project: Project?): PsiParser = WingParser()

    override fun getFileNodeType(): IFileElementType = WingFileElementType

    override fun getCommentTokens(): TokenSet = WING_COMMENTS

    override fun getStringLiteralElements(): TokenSet = WING_STRINGS

    override fun createElement(node: ASTNode?): PsiElement = WingElementTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = WingFile(viewProvider)

}