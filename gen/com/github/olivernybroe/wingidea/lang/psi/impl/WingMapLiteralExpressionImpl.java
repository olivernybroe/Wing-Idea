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

public class WingMapLiteralExpressionImpl extends WingExpressionImpl implements WingMapLiteralExpression {

  public WingMapLiteralExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitMapLiteralExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WingBuiltInContainerType getBuiltInContainerType() {
    return findChildByClass(WingBuiltInContainerType.class);
  }

  @Override
  @NotNull
  public List<WingMapLiteralMember> getMapLiteralMemberList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingMapLiteralMember.class);
  }

}
