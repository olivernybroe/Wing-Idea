// This is a generated file. Not intended for manual editing.
package com.github.olivernybroe.wingidea.lang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.olivernybroe.wingidea.lang.psi.impl.*;

public interface WingElementTypes {

  IElementType ACCESSOR = new WingElementType("ACCESSOR");
  IElementType ACCESS_MODIFIER = new WingElementType("ACCESS_MODIFIER");
  IElementType ARGUMENT = new WingElementType("ARGUMENT");
  IElementType ARGUMENT_LIST = new WingElementType("ARGUMENT_LIST");
  IElementType ARRAY_LITERAL_EXPRESSION = new WingElementType("ARRAY_LITERAL_EXPRESSION");
  IElementType AWAIT_EXPRESSION = new WingElementType("AWAIT_EXPRESSION");
  IElementType BINARY_EXPRESSION = new WingElementType("BINARY_EXPRESSION");
  IElementType BLOCK_STATEMENT = new WingElementType("BLOCK_STATEMENT");
  IElementType BREAK_STATEMENT = new WingElementType("BREAK_STATEMENT");
  IElementType CALL_EXPRESSION = new WingElementType("CALL_EXPRESSION");
  IElementType CATCH_BLOCK = new WingElementType("CATCH_BLOCK");
  IElementType CLASS_DEFINITION_STATEMENT = new WingElementType("CLASS_DEFINITION_STATEMENT");
  IElementType CLASS_FIELD = new WingElementType("CLASS_FIELD");
  IElementType CLASS_IMPLEMENTATION = new WingElementType("CLASS_IMPLEMENTATION");
  IElementType COLLECTION_LITERAL_EXPRESSION = new WingElementType("COLLECTION_LITERAL_EXPRESSION");
  IElementType CONTAINER_VALUE_TYPE = new WingElementType("CONTAINER_VALUE_TYPE");
  IElementType CONTINUE_STATEMENT = new WingElementType("CONTINUE_STATEMENT");
  IElementType DEFER_EXPRESSION = new WingElementType("DEFER_EXPRESSION");
  IElementType DURATION = new WingElementType("DURATION");
  IElementType EL_IF_BLOCK = new WingElementType("EL_IF_BLOCK");
  IElementType ENUM_DEFINITION_STATEMENT = new WingElementType("ENUM_DEFINITION_STATEMENT");
  IElementType ENUM_FIELD = new WingElementType("ENUM_FIELD");
  IElementType EXPRESSION = new WingElementType("EXPRESSION");
  IElementType EXPRESSION_STATEMENT = new WingElementType("EXPRESSION_STATEMENT");
  IElementType EXTERN_MODIFIER = new WingElementType("EXTERN_MODIFIER");
  IElementType FINALLY_BLOCK = new WingElementType("FINALLY_BLOCK");
  IElementType FOR_IN_LOOP_STATEMENT = new WingElementType("FOR_IN_LOOP_STATEMENT");
  IElementType FUNCTION_TYPE = new WingElementType("FUNCTION_TYPE");
  IElementType IF_LET_STATEMENT = new WingElementType("IF_LET_STATEMENT");
  IElementType IF_STATEMENT = new WingElementType("IF_STATEMENT");
  IElementType IMPORT_STATEMENT = new WingElementType("IMPORT_STATEMENT");
  IElementType IMPORT_STATEMENT_BLOCK = new WingElementType("IMPORT_STATEMENT_BLOCK");
  IElementType INFLIGHT_CLOSURE_EXPRESSION = new WingElementType("INFLIGHT_CLOSURE_EXPRESSION");
  IElementType INFLIGHT_METHOD_DEFINITION = new WingElementType("INFLIGHT_METHOD_DEFINITION");
  IElementType INFLIGHT_METHOD_SIGNATURE = new WingElementType("INFLIGHT_METHOD_SIGNATURE");
  IElementType INITIALIZER = new WingElementType("INITIALIZER");
  IElementType INTERFACE_DEFINITION_STATEMENT = new WingElementType("INTERFACE_DEFINITION_STATEMENT");
  IElementType INTERFACE_IMPLEMENTATION = new WingElementType("INTERFACE_IMPLEMENTATION");
  IElementType JSON_LITERAL_EXPRESSION = new WingElementType("JSON_LITERAL_EXPRESSION");
  IElementType JSON_MAP_LITERAL = new WingElementType("JSON_MAP_LITERAL");
  IElementType JSON_MAP_LITERAL_MEMBER = new WingElementType("JSON_MAP_LITERAL_MEMBER");
  IElementType LITERAL_EXPRESSION = new WingElementType("LITERAL_EXPRESSION");
  IElementType LOGICAL_OPERATORS = new WingElementType("LOGICAL_OPERATORS");
  IElementType LOOP_RANGE = new WingElementType("LOOP_RANGE");
  IElementType MAP_LITERAL_EXPRESSION = new WingElementType("MAP_LITERAL_EXPRESSION");
  IElementType MAP_LITERAL_MEMBER = new WingElementType("MAP_LITERAL_MEMBER");
  IElementType MATHEMATICAL_OPERATORS = new WingElementType("MATHEMATICAL_OPERATORS");
  IElementType METHOD_DEFINITION = new WingElementType("METHOD_DEFINITION");
  IElementType METHOD_SIGNATURE = new WingElementType("METHOD_SIGNATURE");
  IElementType NESTED_IDENTIFIER_EXPRESSION = new WingElementType("NESTED_IDENTIFIER_EXPRESSION");
  IElementType NESTED_IDENTIFIER_JSON_EXPRESSION = new WingElementType("NESTED_IDENTIFIER_JSON_EXPRESSION");
  IElementType NEW_EXPRESSION = new WingElementType("NEW_EXPRESSION");
  IElementType NUMBER = new WingElementType("NUMBER");
  IElementType OPERATORS = new WingElementType("OPERATORS");
  IElementType OPTIONAL_TEST_EXPRESSION = new WingElementType("OPTIONAL_TEST_EXPRESSION");
  IElementType PARAMETER_DEFINITION = new WingElementType("PARAMETER_DEFINITION");
  IElementType PARAMETER_LIST = new WingElementType("PARAMETER_LIST");
  IElementType PARAMETER_TYPE_LIST = new WingElementType("PARAMETER_TYPE_LIST");
  IElementType PARENTHESIZED_EXPRESSION = new WingElementType("PARENTHESIZED_EXPRESSION");
  IElementType PREFLIGHT_CLOSURE_EXPRESSION = new WingElementType("PREFLIGHT_CLOSURE_EXPRESSION");
  IElementType REFERENCE_EXPRESSION = new WingElementType("REFERENCE_EXPRESSION");
  IElementType RELATIONAL_OPERATORS = new WingElementType("RELATIONAL_OPERATORS");
  IElementType RESOURCE_DEFINITION_STATEMENT = new WingElementType("RESOURCE_DEFINITION_STATEMENT");
  IElementType RESOURCE_IMPLEMENTATION = new WingElementType("RESOURCE_IMPLEMENTATION");
  IElementType RETURN_STATEMENT = new WingElementType("RETURN_STATEMENT");
  IElementType SET_LITERAL_EXPRESSION = new WingElementType("SET_LITERAL_EXPRESSION");
  IElementType STRING = new WingElementType("STRING");
  IElementType STRUCTURED_ACCESS_EXPRESSION = new WingElementType("STRUCTURED_ACCESS_EXPRESSION");
  IElementType STRUCT_DEFINITION_STATEMENT = new WingElementType("STRUCT_DEFINITION_STATEMENT");
  IElementType STRUCT_FIELD = new WingElementType("STRUCT_FIELD");
  IElementType STRUCT_IMPLEMENTATION = new WingElementType("STRUCT_IMPLEMENTATION");
  IElementType STRUCT_LITERAL_EXPRESSION = new WingElementType("STRUCT_LITERAL_EXPRESSION");
  IElementType STRUCT_LITERAL_MEMBER = new WingElementType("STRUCT_LITERAL_MEMBER");
  IElementType SUPER_CALL_EXPRESSION = new WingElementType("SUPER_CALL_EXPRESSION");
  IElementType SUPER_CONSTRUCTOR_STATEMENT = new WingElementType("SUPER_CONSTRUCTOR_STATEMENT");
  IElementType TEST_STATEMENT = new WingElementType("TEST_STATEMENT");
  IElementType TRY_CATCH_STATEMENT = new WingElementType("TRY_CATCH_STATEMENT");
  IElementType TYPE = new WingElementType("TYPE");
  IElementType TYPE_ANNOTATION = new WingElementType("TYPE_ANNOTATION");
  IElementType UNARY_EXPRESSION = new WingElementType("UNARY_EXPRESSION");
  IElementType UNARY_OPERATORS = new WingElementType("UNARY_OPERATORS");
  IElementType VARIABLE_ASSIGNMENT_STATEMENT = new WingElementType("VARIABLE_ASSIGNMENT_STATEMENT");
  IElementType VARIABLE_DEFINITION_STATEMENT = new WingElementType("VARIABLE_DEFINITION_STATEMENT");
  IElementType WHILE_STATEMENT = new WingElementType("WHILE_STATEMENT");

  IElementType ADDITION = new WingTokenType("+");
  IElementType ALIAS = new WingTokenType("as");
  IElementType AND = new WingTokenType("&&");
  IElementType ARROW = new WingTokenType("=>");
  IElementType ASSIGNMENT = new WingTokenType("=");
  IElementType ASYNC = new WingTokenType("async");
  IElementType AWAIT = new WingTokenType("await");
  IElementType BOOL = new WingTokenType("BOOL");
  IElementType BREAK = new WingTokenType("break");
  IElementType BRING = new WingTokenType("bring");
  IElementType CATCH = new WingTokenType("catch");
  IElementType CLASS = new WingTokenType("class");
  IElementType COLON = new WingTokenType(":");
  IElementType COMMA = new WingTokenType(",");
  IElementType COMMENT = new WingTokenType("COMMENT");
  IElementType CONTINUE = new WingTokenType("continue");
  IElementType DECIMAL = new WingTokenType("DECIMAL");
  IElementType DEFER = new WingTokenType("defer");
  IElementType DIVIDE = new WingTokenType("/");
  IElementType DOT = new WingTokenType(".");
  IElementType ELIF = new WingTokenType("elif");
  IElementType ELSE = new WingTokenType("else");
  IElementType ENUM = new WingTokenType("enum");
  IElementType EQUAL = new WingTokenType("==");
  IElementType EXTENDS = new WingTokenType("extends");
  IElementType EXTERN = new WingTokenType("extern");
  IElementType FINALLY = new WingTokenType("finally");
  IElementType FLOOR_DIVIDE = new WingTokenType("\\");
  IElementType FOR = new WingTokenType("for");
  IElementType GREATER_THAN = new WingTokenType(">");
  IElementType GREATER_THAN_OR_EQUAL = new WingTokenType(">=");
  IElementType IDENTIFIER = new WingTokenType("IDENTIFIER");
  IElementType IF = new WingTokenType("if");
  IElementType IMPLEMENTS = new WingTokenType("impl");
  IElementType IN = new WingTokenType("in");
  IElementType INFLIGHT_SPECIFIER = new WingTokenType("inflight");
  IElementType INIT = new WingTokenType("init");
  IElementType INTEGER = new WingTokenType("INTEGER");
  IElementType INTERFACE = new WingTokenType("interface");
  IElementType LEFT_CURLY_BRACE = new WingTokenType("{");
  IElementType LEFT_PARENTHESIS = new WingTokenType("(");
  IElementType LEFT_SQUARE_BRACE = new WingTokenType("[");
  IElementType LESS_THAN = new WingTokenType("<");
  IElementType LESS_THAN_OR_EQUAL = new WingTokenType("<=");
  IElementType LET = new WingTokenType("let");
  IElementType MODULO = new WingTokenType("%");
  IElementType MULTIPLY = new WingTokenType("*");
  IElementType MULTI_LINE_COMMENT = new WingTokenType("MULTI_LINE_COMMENT");
  IElementType NB = new WingTokenType("nb");
  IElementType NEW = new WingTokenType("new");
  IElementType NIL = new WingTokenType("nil");
  IElementType NOT = new WingTokenType("!");
  IElementType NOT_EQUAL = new WingTokenType("!=");
  IElementType OR = new WingTokenType("||");
  IElementType POWER = new WingTokenType("**");
  IElementType QUESTION_MARK = new WingTokenType("?");
  IElementType RETURN = new WingTokenType("return");
  IElementType RIGHT_CURLY_BRACE = new WingTokenType("}");
  IElementType RIGHT_PARENTHESIS = new WingTokenType(")");
  IElementType RIGHT_SQUARE_BRACE = new WingTokenType("]");
  IElementType SEMICOLON = new WingTokenType(";");
  IElementType STATIC = new WingTokenType("static");
  IElementType STRING_LITERAL = new WingTokenType("STRING_LITERAL");
  IElementType STRUCT = new WingTokenType("struct");
  IElementType SUBTRACTION = new WingTokenType("-");
  IElementType SUPER = new WingTokenType("super");
  IElementType TEST = new WingTokenType("test");
  IElementType TRY = new WingTokenType("try");
  IElementType UNWRAP_OR = new WingTokenType("??");
  IElementType VAR = new WingTokenType("var");
  IElementType WHILE = new WingTokenType("while");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ACCESSOR) {
        return new WingAccessorImpl(node);
      }
      else if (type == ACCESS_MODIFIER) {
        return new WingAccessModifierImpl(node);
      }
      else if (type == ARGUMENT) {
        return new WingArgumentImpl(node);
      }
      else if (type == ARGUMENT_LIST) {
        return new WingArgumentListImpl(node);
      }
      else if (type == ARRAY_LITERAL_EXPRESSION) {
        return new WingArrayLiteralExpressionImpl(node);
      }
      else if (type == AWAIT_EXPRESSION) {
        return new WingAwaitExpressionImpl(node);
      }
      else if (type == BINARY_EXPRESSION) {
        return new WingBinaryExpressionImpl(node);
      }
      else if (type == BLOCK_STATEMENT) {
        return new WingBlockStatementImpl(node);
      }
      else if (type == BREAK_STATEMENT) {
        return new WingBreakStatementImpl(node);
      }
      else if (type == CALL_EXPRESSION) {
        return new WingCallExpressionImpl(node);
      }
      else if (type == CATCH_BLOCK) {
        return new WingCatchBlockImpl(node);
      }
      else if (type == CLASS_DEFINITION_STATEMENT) {
        return new WingClassDefinitionStatementImpl(node);
      }
      else if (type == CLASS_FIELD) {
        return new WingClassFieldImpl(node);
      }
      else if (type == CLASS_IMPLEMENTATION) {
        return new WingClassImplementationImpl(node);
      }
      else if (type == CONTAINER_VALUE_TYPE) {
        return new WingContainerValueTypeImpl(node);
      }
      else if (type == CONTINUE_STATEMENT) {
        return new WingContinueStatementImpl(node);
      }
      else if (type == DEFER_EXPRESSION) {
        return new WingDeferExpressionImpl(node);
      }
      else if (type == DURATION) {
        return new WingDurationImpl(node);
      }
      else if (type == EL_IF_BLOCK) {
        return new WingElIfBlockImpl(node);
      }
      else if (type == ENUM_DEFINITION_STATEMENT) {
        return new WingEnumDefinitionStatementImpl(node);
      }
      else if (type == ENUM_FIELD) {
        return new WingEnumFieldImpl(node);
      }
      else if (type == EXPRESSION_STATEMENT) {
        return new WingExpressionStatementImpl(node);
      }
      else if (type == EXTERN_MODIFIER) {
        return new WingExternModifierImpl(node);
      }
      else if (type == FINALLY_BLOCK) {
        return new WingFinallyBlockImpl(node);
      }
      else if (type == FOR_IN_LOOP_STATEMENT) {
        return new WingForInLoopStatementImpl(node);
      }
      else if (type == FUNCTION_TYPE) {
        return new WingFunctionTypeImpl(node);
      }
      else if (type == IF_LET_STATEMENT) {
        return new WingIfLetStatementImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new WingIfStatementImpl(node);
      }
      else if (type == IMPORT_STATEMENT) {
        return new WingImportStatementImpl(node);
      }
      else if (type == IMPORT_STATEMENT_BLOCK) {
        return new WingImportStatementBlockImpl(node);
      }
      else if (type == INFLIGHT_CLOSURE_EXPRESSION) {
        return new WingInflightClosureExpressionImpl(node);
      }
      else if (type == INFLIGHT_METHOD_DEFINITION) {
        return new WingInflightMethodDefinitionImpl(node);
      }
      else if (type == INFLIGHT_METHOD_SIGNATURE) {
        return new WingInflightMethodSignatureImpl(node);
      }
      else if (type == INITIALIZER) {
        return new WingInitializerImpl(node);
      }
      else if (type == INTERFACE_DEFINITION_STATEMENT) {
        return new WingInterfaceDefinitionStatementImpl(node);
      }
      else if (type == INTERFACE_IMPLEMENTATION) {
        return new WingInterfaceImplementationImpl(node);
      }
      else if (type == JSON_LITERAL_EXPRESSION) {
        return new WingJsonLiteralExpressionImpl(node);
      }
      else if (type == JSON_MAP_LITERAL) {
        return new WingJsonMapLiteralImpl(node);
      }
      else if (type == JSON_MAP_LITERAL_MEMBER) {
        return new WingJsonMapLiteralMemberImpl(node);
      }
      else if (type == LITERAL_EXPRESSION) {
        return new WingLiteralExpressionImpl(node);
      }
      else if (type == LOGICAL_OPERATORS) {
        return new WingLogicalOperatorsImpl(node);
      }
      else if (type == LOOP_RANGE) {
        return new WingLoopRangeImpl(node);
      }
      else if (type == MAP_LITERAL_EXPRESSION) {
        return new WingMapLiteralExpressionImpl(node);
      }
      else if (type == MAP_LITERAL_MEMBER) {
        return new WingMapLiteralMemberImpl(node);
      }
      else if (type == MATHEMATICAL_OPERATORS) {
        return new WingMathematicalOperatorsImpl(node);
      }
      else if (type == METHOD_DEFINITION) {
        return new WingMethodDefinitionImpl(node);
      }
      else if (type == METHOD_SIGNATURE) {
        return new WingMethodSignatureImpl(node);
      }
      else if (type == NESTED_IDENTIFIER_EXPRESSION) {
        return new WingNestedIdentifierExpressionImpl(node);
      }
      else if (type == NESTED_IDENTIFIER_JSON_EXPRESSION) {
        return new WingNestedIdentifierJsonExpressionImpl(node);
      }
      else if (type == NEW_EXPRESSION) {
        return new WingNewExpressionImpl(node);
      }
      else if (type == NUMBER) {
        return new WingNumberImpl(node);
      }
      else if (type == OPERATORS) {
        return new WingOperatorsImpl(node);
      }
      else if (type == OPTIONAL_TEST_EXPRESSION) {
        return new WingOptionalTestExpressionImpl(node);
      }
      else if (type == PARAMETER_DEFINITION) {
        return new WingParameterDefinitionImpl(node);
      }
      else if (type == PARAMETER_LIST) {
        return new WingParameterListImpl(node);
      }
      else if (type == PARAMETER_TYPE_LIST) {
        return new WingParameterTypeListImpl(node);
      }
      else if (type == PARENTHESIZED_EXPRESSION) {
        return new WingParenthesizedExpressionImpl(node);
      }
      else if (type == PREFLIGHT_CLOSURE_EXPRESSION) {
        return new WingPreflightClosureExpressionImpl(node);
      }
      else if (type == REFERENCE_EXPRESSION) {
        return new WingReferenceExpressionImpl(node);
      }
      else if (type == RELATIONAL_OPERATORS) {
        return new WingRelationalOperatorsImpl(node);
      }
      else if (type == RESOURCE_DEFINITION_STATEMENT) {
        return new WingResourceDefinitionStatementImpl(node);
      }
      else if (type == RESOURCE_IMPLEMENTATION) {
        return new WingResourceImplementationImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new WingReturnStatementImpl(node);
      }
      else if (type == SET_LITERAL_EXPRESSION) {
        return new WingSetLiteralExpressionImpl(node);
      }
      else if (type == STRING) {
        return new WingStringImpl(node);
      }
      else if (type == STRUCTURED_ACCESS_EXPRESSION) {
        return new WingStructuredAccessExpressionImpl(node);
      }
      else if (type == STRUCT_DEFINITION_STATEMENT) {
        return new WingStructDefinitionStatementImpl(node);
      }
      else if (type == STRUCT_FIELD) {
        return new WingStructFieldImpl(node);
      }
      else if (type == STRUCT_IMPLEMENTATION) {
        return new WingStructImplementationImpl(node);
      }
      else if (type == STRUCT_LITERAL_EXPRESSION) {
        return new WingStructLiteralExpressionImpl(node);
      }
      else if (type == STRUCT_LITERAL_MEMBER) {
        return new WingStructLiteralMemberImpl(node);
      }
      else if (type == SUPER_CALL_EXPRESSION) {
        return new WingSuperCallExpressionImpl(node);
      }
      else if (type == SUPER_CONSTRUCTOR_STATEMENT) {
        return new WingSuperConstructorStatementImpl(node);
      }
      else if (type == TEST_STATEMENT) {
        return new WingTestStatementImpl(node);
      }
      else if (type == TRY_CATCH_STATEMENT) {
        return new WingTryCatchStatementImpl(node);
      }
      else if (type == TYPE) {
        return new WingTypeImpl(node);
      }
      else if (type == TYPE_ANNOTATION) {
        return new WingTypeAnnotationImpl(node);
      }
      else if (type == UNARY_EXPRESSION) {
        return new WingUnaryExpressionImpl(node);
      }
      else if (type == UNARY_OPERATORS) {
        return new WingUnaryOperatorsImpl(node);
      }
      else if (type == VARIABLE_ASSIGNMENT_STATEMENT) {
        return new WingVariableAssignmentStatementImpl(node);
      }
      else if (type == VARIABLE_DEFINITION_STATEMENT) {
        return new WingVariableDefinitionStatementImpl(node);
      }
      else if (type == WHILE_STATEMENT) {
        return new WingWhileStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
