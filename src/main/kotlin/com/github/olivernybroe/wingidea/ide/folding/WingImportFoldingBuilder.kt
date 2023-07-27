package com.github.olivernybroe.wingidea.ide.folding

import com.github.olivernybroe.wingidea.lang.psi.WingImportStatementBlock
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class WingImportFoldingBuilder : FoldingBuilderEx(), DumbAware {
    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        val blocks = PsiTreeUtil.findChildrenOfAnyType(
            root,
            WingImportStatementBlock::class.java,
        )
        return blocks.map { FoldingDescriptor(it, it.textRange) }.toTypedArray()
    }

    override fun getPlaceholderText(node: ASTNode): String = "bring ..."

    override fun isCollapsedByDefault(node: ASTNode): Boolean = true

}