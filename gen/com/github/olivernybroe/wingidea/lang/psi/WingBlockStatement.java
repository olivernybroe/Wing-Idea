// This is a generated file. Not intended for manual editing.
package com.github.olivernybroe.wingidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WingBlockStatement extends WingElement {

  @NotNull
  List<WingBreakStatement> getBreakStatementList();

  @NotNull
  List<WingClassDefinitionStatement> getClassDefinitionStatementList();

  @NotNull
  List<WingContinueStatement> getContinueStatementList();

  @NotNull
  List<WingEnumDefinitionStatement> getEnumDefinitionStatementList();

  @NotNull
  List<WingExpressionStatement> getExpressionStatementList();

  @NotNull
  List<WingForInLoopStatement> getForInLoopStatementList();

  @NotNull
  List<WingIfLetStatement> getIfLetStatementList();

  @NotNull
  List<WingIfStatement> getIfStatementList();

  @NotNull
  List<WingImportStatement> getImportStatementList();

  @NotNull
  List<WingInterfaceDefinitionStatement> getInterfaceDefinitionStatementList();

  @NotNull
  List<WingResourceDefinitionStatement> getResourceDefinitionStatementList();

  @NotNull
  List<WingReturnStatement> getReturnStatementList();

  @NotNull
  List<WingStructDefinitionStatement> getStructDefinitionStatementList();

  @NotNull
  List<WingSuperConstructorStatement> getSuperConstructorStatementList();

  @NotNull
  List<WingTestStatement> getTestStatementList();

  @NotNull
  List<WingTryCatchStatement> getTryCatchStatementList();

  @NotNull
  List<WingVariableAssignmentStatement> getVariableAssignmentStatementList();

  @NotNull
  List<WingVariableDefinitionStatement> getVariableDefinitionStatementList();

  @NotNull
  List<WingWhileStatement> getWhileStatementList();

}
