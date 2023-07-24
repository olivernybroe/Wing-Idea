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

public class WingBlockStatementImpl extends WingElementImpl implements WingBlockStatement {

  public WingBlockStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitBlockStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<WingBreakStatement> getBreakStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingBreakStatement.class);
  }

  @Override
  @NotNull
  public List<WingClassDefinitionStatement> getClassDefinitionStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingClassDefinitionStatement.class);
  }

  @Override
  @NotNull
  public List<WingContinueStatement> getContinueStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingContinueStatement.class);
  }

  @Override
  @NotNull
  public List<WingEnumDefinitionStatement> getEnumDefinitionStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingEnumDefinitionStatement.class);
  }

  @Override
  @NotNull
  public List<WingExpressionStatement> getExpressionStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingExpressionStatement.class);
  }

  @Override
  @NotNull
  public List<WingForInLoopStatement> getForInLoopStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingForInLoopStatement.class);
  }

  @Override
  @NotNull
  public List<WingIfLetStatement> getIfLetStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingIfLetStatement.class);
  }

  @Override
  @NotNull
  public List<WingIfStatement> getIfStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingIfStatement.class);
  }

  @Override
  @NotNull
  public List<WingImportStatement> getImportStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingImportStatement.class);
  }

  @Override
  @NotNull
  public List<WingInterfaceDefinitionStatement> getInterfaceDefinitionStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingInterfaceDefinitionStatement.class);
  }

  @Override
  @NotNull
  public List<WingResourceDefinitionStatement> getResourceDefinitionStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingResourceDefinitionStatement.class);
  }

  @Override
  @NotNull
  public List<WingReturnStatement> getReturnStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingReturnStatement.class);
  }

  @Override
  @NotNull
  public List<WingStructDefinitionStatement> getStructDefinitionStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingStructDefinitionStatement.class);
  }

  @Override
  @NotNull
  public List<WingSuperConstructorStatement> getSuperConstructorStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingSuperConstructorStatement.class);
  }

  @Override
  @NotNull
  public List<WingTestStatement> getTestStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingTestStatement.class);
  }

  @Override
  @NotNull
  public List<WingTryCatchStatement> getTryCatchStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingTryCatchStatement.class);
  }

  @Override
  @NotNull
  public List<WingVariableAssignmentStatement> getVariableAssignmentStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingVariableAssignmentStatement.class);
  }

  @Override
  @NotNull
  public List<WingVariableDefinitionStatement> getVariableDefinitionStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingVariableDefinitionStatement.class);
  }

  @Override
  @NotNull
  public List<WingWhileStatement> getWhileStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingWhileStatement.class);
  }

}
