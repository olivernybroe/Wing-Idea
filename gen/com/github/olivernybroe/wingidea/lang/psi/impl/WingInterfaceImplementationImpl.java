// This is a generated file. Not intended for manual editing.
package com.github.olivernybroe.wingidea.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.olivernybroe.wingidea.lang.psi.WingElementTypes.*;
import com.github.olivernybroe.wingidea.lang.psi.*;

public class WingInterfaceImplementationImpl extends WingElementImpl implements WingInterfaceImplementation {

  public WingInterfaceImplementationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitInterfaceImplementation(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<WingClassField> getClassFieldList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingClassField.class);
  }

  @Override
  @NotNull
  public List<WingInflightMethodSignature> getInflightMethodSignatureList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingInflightMethodSignature.class);
  }

  @Override
  @NotNull
  public List<WingMethodSignature> getMethodSignatureList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingMethodSignature.class);
  }

}
