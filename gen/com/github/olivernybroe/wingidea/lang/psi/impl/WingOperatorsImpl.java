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

public class WingOperatorsImpl extends WingElementImpl implements WingOperators {

  public WingOperatorsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitOperators(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WingLogicalOperators getLogicalOperators() {
    return findChildByClass(WingLogicalOperators.class);
  }

  @Override
  @Nullable
  public WingMathematicalOperators getMathematicalOperators() {
    return findChildByClass(WingMathematicalOperators.class);
  }

  @Override
  @Nullable
  public WingRelationalOperators getRelationalOperators() {
    return findChildByClass(WingRelationalOperators.class);
  }

}
