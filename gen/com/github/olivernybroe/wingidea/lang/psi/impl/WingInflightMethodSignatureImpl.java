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

public class WingInflightMethodSignatureImpl extends WingElementImpl implements WingInflightMethodSignature {

  public WingInflightMethodSignatureImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitInflightMethodSignature(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public WingParameterList getParameterList() {
    return findNotNullChildByClass(WingParameterList.class);
  }

  @Override
  @NotNull
  public WingTypeAnnotation getTypeAnnotation() {
    return findNotNullChildByClass(WingTypeAnnotation.class);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

}
