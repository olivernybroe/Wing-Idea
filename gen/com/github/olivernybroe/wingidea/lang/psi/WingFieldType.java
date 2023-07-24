// This is a generated file. Not intended for manual editing.
package com.github.olivernybroe.wingidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WingFieldType extends WingElement {

  @Nullable
  WingBuiltInContainerType getBuiltInContainerType();

  @Nullable
  WingBuiltInType getBuiltInType();

  @Nullable
  WingCustomType getCustomType();

  @Nullable
  WingFunctionType getFunctionType();

  @Nullable
  WingJsonContainerType getJsonContainerType();

}
