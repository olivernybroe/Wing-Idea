package com.github.olivernybroe.wingidea.ide.formatter

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.formatter.common.AbstractBlock

class WingFormatBlock(
    node: ASTNode,
    wrap: Wrap?,
    alignment: Alignment?,
) : AbstractBlock(node, wrap, alignment) {
    override fun getSpacing(p0: Block?, p1: Block): Spacing? {
        return null
    }

    override fun isLeaf(): Boolean = node.firstChildNode == null

    override fun buildChildren(): MutableList<Block> {
        return mutableListOf()
    }

}