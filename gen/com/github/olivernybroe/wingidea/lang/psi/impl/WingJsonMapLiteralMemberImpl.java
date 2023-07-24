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

public class WingJsonMapLiteralMemberImpl extends WingElementImpl implements WingJsonMapLiteralMember {

  public WingJsonMapLiteralMemberImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitJsonMapLiteralMember(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public WingExpression getExpression() {
    return findNotNullChildByClass(WingExpression.class);
  }

  @Override
  @Nullable
  public WingString getString() {
    return findChildByClass(WingString.class);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

}
