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

public class WingStatementImpl extends WingElementImpl implements WingStatement {

  public WingStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WingBreakStatement getBreakStatement() {
    return findChildByClass(WingBreakStatement.class);
  }

  @Override
  @Nullable
  public WingClassDefinitionStatement getClassDefinitionStatement() {
    return findChildByClass(WingClassDefinitionStatement.class);
  }

  @Override
  @Nullable
  public WingContinueStatement getContinueStatement() {
    return findChildByClass(WingContinueStatement.class);
  }

  @Override
  @Nullable
  public WingEnumDefinitionStatement getEnumDefinitionStatement() {
    return findChildByClass(WingEnumDefinitionStatement.class);
  }

  @Override
  @Nullable
  public WingExpressionStatement getExpressionStatement() {
    return findChildByClass(WingExpressionStatement.class);
  }

  @Override
  @Nullable
  public WingForInLoopStatement getForInLoopStatement() {
    return findChildByClass(WingForInLoopStatement.class);
  }

  @Override
  @Nullable
  public WingIfLetStatement getIfLetStatement() {
    return findChildByClass(WingIfLetStatement.class);
  }

  @Override
  @Nullable
  public WingIfStatement getIfStatement() {
    return findChildByClass(WingIfStatement.class);
  }

  @Override
  @Nullable
  public WingImportStatement getImportStatement() {
    return findChildByClass(WingImportStatement.class);
  }

  @Override
  @Nullable
  public WingInterfaceDefinitionStatement getInterfaceDefinitionStatement() {
    return findChildByClass(WingInterfaceDefinitionStatement.class);
  }

  @Override
  @Nullable
  public WingResourceDefinitionStatement getResourceDefinitionStatement() {
    return findChildByClass(WingResourceDefinitionStatement.class);
  }

  @Override
  @Nullable
  public WingReturnStatement getReturnStatement() {
    return findChildByClass(WingReturnStatement.class);
  }

  @Override
  @Nullable
  public WingStructDefinitionStatement getStructDefinitionStatement() {
    return findChildByClass(WingStructDefinitionStatement.class);
  }

  @Override
  @Nullable
  public WingSuperConstructorStatement getSuperConstructorStatement() {
    return findChildByClass(WingSuperConstructorStatement.class);
  }

  @Override
  @Nullable
  public WingTestStatement getTestStatement() {
    return findChildByClass(WingTestStatement.class);
  }

  @Override
  @Nullable
  public WingTryCatchStatement getTryCatchStatement() {
    return findChildByClass(WingTryCatchStatement.class);
  }

  @Override
  @Nullable
  public WingVariableAssignmentStatement getVariableAssignmentStatement() {
    return findChildByClass(WingVariableAssignmentStatement.class);
  }

  @Override
  @Nullable
  public WingVariableDefinitionStatement getVariableDefinitionStatement() {
    return findChildByClass(WingVariableDefinitionStatement.class);
  }

  @Override
  @Nullable
  public WingWhileStatement getWhileStatement() {
    return findChildByClass(WingWhileStatement.class);
  }

}
