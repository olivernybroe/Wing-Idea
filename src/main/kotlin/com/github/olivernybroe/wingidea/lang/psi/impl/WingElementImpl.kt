package com.github.olivernybroe.wingidea.lang.psi.impl

import com.github.olivernybroe.wingidea.lang.psi.WingElement
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

open class WingElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), WingElement