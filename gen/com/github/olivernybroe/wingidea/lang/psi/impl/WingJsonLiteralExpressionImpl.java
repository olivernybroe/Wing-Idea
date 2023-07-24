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

public class WingJsonLiteralExpressionImpl extends WingExpressionImpl implements WingJsonLiteralExpression {

  public WingJsonLiteralExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitJsonLiteralExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WingExpression getExpression() {
    return findChildByClass(WingExpression.class);
  }

  @Override
  @Nullable
  public WingJsonContainerType getJsonContainerType() {
    return findChildByClass(WingJsonContainerType.class);
  }

  @Override
  @Nullable
  public WingJsonMapLiteral getJsonMapLiteral() {
    return findChildByClass(WingJsonMapLiteral.class);
  }

}
