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

public class WingInflightMethodDefinitionImpl extends WingElementImpl implements WingInflightMethodDefinition {

  public WingInflightMethodDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitInflightMethodDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WingAccessModifier getAccessModifier() {
    return findChildByClass(WingAccessModifier.class);
  }

  @Override
  @Nullable
  public WingBlockStatement getBlockStatement() {
    return findChildByClass(WingBlockStatement.class);
  }

  @Override
  @Nullable
  public WingExternModifier getExternModifier() {
    return findChildByClass(WingExternModifier.class);
  }

  @Override
  @NotNull
  public WingParameterList getParameterList() {
    return findNotNullChildByClass(WingParameterList.class);
  }

  @Override
  @Nullable
  public WingTypeAnnotation getTypeAnnotation() {
    return findChildByClass(WingTypeAnnotation.class);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

}
