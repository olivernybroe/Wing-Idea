// This is a generated file. Not intended for manual editing.
package com.github.olivernybroe.wingidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WingIfLetStatement extends WingElement {

  @NotNull
  List<WingBlockStatement> getBlockStatementList();

  @NotNull
  List<WingElIfBlock> getElIfBlockList();

  @NotNull
  WingExpression getExpression();

  @NotNull
  PsiElement getIdentifier();

}
