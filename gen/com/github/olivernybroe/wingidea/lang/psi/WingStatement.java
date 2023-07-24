// This is a generated file. Not intended for manual editing.
package com.github.olivernybroe.wingidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WingStatement extends WingElement {

  @Nullable
  WingBreakStatement getBreakStatement();

  @Nullable
  WingClassDefinitionStatement getClassDefinitionStatement();

  @Nullable
  WingContinueStatement getContinueStatement();

  @Nullable
  WingEnumDefinitionStatement getEnumDefinitionStatement();

  @Nullable
  WingExpressionStatement getExpressionStatement();

  @Nullable
  WingForInLoopStatement getForInLoopStatement();

  @Nullable
  WingIfLetStatement getIfLetStatement();

  @Nullable
  WingIfStatement getIfStatement();

  @Nullable
  WingImportStatement getImportStatement();

  @Nullable
  WingInterfaceDefinitionStatement getInterfaceDefinitionStatement();

  @Nullable
  WingResourceDefinitionStatement getResourceDefinitionStatement();

  @Nullable
  WingReturnStatement getReturnStatement();

  @Nullable
  WingStructDefinitionStatement getStructDefinitionStatement();

  @Nullable
  WingSuperConstructorStatement getSuperConstructorStatement();

  @Nullable
  WingTestStatement getTestStatement();

  @Nullable
  WingTryCatchStatement getTryCatchStatement();

  @Nullable
  WingVariableAssignmentStatement getVariableAssignmentStatement();

  @Nullable
  WingVariableDefinitionStatement getVariableDefinitionStatement();

  @Nullable
  WingWhileStatement getWhileStatement();

}
