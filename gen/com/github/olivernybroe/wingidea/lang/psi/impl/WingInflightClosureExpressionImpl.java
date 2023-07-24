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

public class WingInflightClosureExpressionImpl extends WingExpressionImpl implements WingInflightClosureExpression {

  public WingInflightClosureExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitInflightClosureExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public WingBlockStatement getBlockStatement() {
    return findNotNullChildByClass(WingBlockStatement.class);
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

}
