// This is a generated file. Not intended for manual editing.
package com.github.olivernybroe.wingidea.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.olivernybroe.wingidea.lang.psi.WingElementTypes.*;
import static com.github.olivernybroe.wingidea.lang.parser.WingParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class WingParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return Schema(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ARRAY_LITERAL_EXPRESSION, AWAIT_EXPRESSION, BINARY_EXPRESSION, CALL_EXPRESSION,
      COLLECTION_LITERAL_EXPRESSION, DEFER_EXPRESSION, EXPRESSION, INFLIGHT_CLOSURE_EXPRESSION,
      JSON_LITERAL_EXPRESSION, LITERAL_EXPRESSION, MAP_LITERAL_EXPRESSION, NESTED_IDENTIFIER_EXPRESSION,
      NESTED_IDENTIFIER_JSON_EXPRESSION, NEW_EXPRESSION, OPTIONAL_TEST_EXPRESSION, PARENTHESIZED_EXPRESSION,
      PREFLIGHT_CLOSURE_EXPRESSION, REFERENCE_EXPRESSION, SET_LITERAL_EXPRESSION, STRUCTURED_ACCESS_EXPRESSION,
      STRUCT_LITERAL_EXPRESSION, SUPER_CALL_EXPRESSION, UNARY_EXPRESSION),
  };

  /* ********************************************************** */
  // PUBLIC
  //     | PROTECTED
  public static boolean AccessModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AccessModifier")) return false;
    if (!nextTokenIs(b, "<access modifier>", PROTECTED, PUBLIC)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ACCESS_MODIFIER, "<access modifier>");
    r = consumeToken(b, PUBLIC);
    if (!r) r = consumeToken(b, PROTECTED);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOT
  //     | '?.'
  public static boolean Accessor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Accessor")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ACCESSOR, "<accessor>");
    r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, "?.");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER COLON Expression
  //     | Expression
  public static boolean Argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
    r = Argument_0(b, l + 1);
    if (!r) r = Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER COLON Expression
  private static boolean Argument_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Argument_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, COLON);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_PARENTHESIS (Argument (COMMA Argument)* COMMA?)? RIGHT_PARENTHESIS
  public static boolean ArgumentList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PARENTHESIS);
    r = r && ArgumentList_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESIS);
    exit_section_(b, m, ARGUMENT_LIST, r);
    return r;
  }

  // (Argument (COMMA Argument)* COMMA?)?
  private static boolean ArgumentList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1")) return false;
    ArgumentList_1_0(b, l + 1);
    return true;
  }

  // Argument (COMMA Argument)* COMMA?
  private static boolean ArgumentList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Argument(b, l + 1);
    r = r && ArgumentList_1_0_1(b, l + 1);
    r = r && ArgumentList_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA Argument)*
  private static boolean ArgumentList_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ArgumentList_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ArgumentList_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA Argument
  private static boolean ArgumentList_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Argument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean ArgumentList_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // BuiltInContainerType? LEFT_SQUARE_BRACE (Expression (COMMA Expression)* COMMA?)? RIGHT_SQUARE_BRACE
  public static boolean ArrayLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayLiteralExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_LITERAL_EXPRESSION, "<array literal expression>");
    r = ArrayLiteralExpression_0(b, l + 1);
    r = r && consumeToken(b, LEFT_SQUARE_BRACE);
    r = r && ArrayLiteralExpression_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_SQUARE_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BuiltInContainerType?
  private static boolean ArrayLiteralExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayLiteralExpression_0")) return false;
    BuiltInContainerType(b, l + 1);
    return true;
  }

  // (Expression (COMMA Expression)* COMMA?)?
  private static boolean ArrayLiteralExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayLiteralExpression_2")) return false;
    ArrayLiteralExpression_2_0(b, l + 1);
    return true;
  }

  // Expression (COMMA Expression)* COMMA?
  private static boolean ArrayLiteralExpression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayLiteralExpression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1, -1);
    r = r && ArrayLiteralExpression_2_0_1(b, l + 1);
    r = r && ArrayLiteralExpression_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA Expression)*
  private static boolean ArrayLiteralExpression_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayLiteralExpression_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ArrayLiteralExpression_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ArrayLiteralExpression_2_0_1", c)) break;
    }
    return true;
  }

  // COMMA Expression
  private static boolean ArrayLiteralExpression_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayLiteralExpression_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean ArrayLiteralExpression_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayLiteralExpression_2_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // LEFT_CURLY_BRACE Statement* RIGHT_CURLY_BRACE
  public static boolean BlockStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlockStatement")) return false;
    if (!nextTokenIs(b, LEFT_CURLY_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_CURLY_BRACE);
    r = r && BlockStatement_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY_BRACE);
    exit_section_(b, m, BLOCK_STATEMENT, r);
    return r;
  }

  // Statement*
  private static boolean BlockStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlockStatement_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "BlockStatement_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // BREAK SEMICOLON
  public static boolean BreakStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BreakStatement")) return false;
    if (!nextTokenIs(b, BREAK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BREAK, SEMICOLON);
    exit_section_(b, m, BREAK_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ImmutableContainerType
  //     | MutableContainerType
  static boolean BuiltInContainerType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInContainerType")) return false;
    boolean r;
    r = ImmutableContainerType(b, l + 1);
    if (!r) r = MutableContainerType(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // "bool"
  //     | "num"
  //     | "any"
  //     | "str"
  //     | "void"
  //     | "duration"
  static boolean BuiltInType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInType")) return false;
    boolean r;
    r = consumeToken(b, "bool");
    if (!r) r = consumeToken(b, "num");
    if (!r) r = consumeToken(b, "any");
    if (!r) r = consumeToken(b, "str");
    if (!r) r = consumeToken(b, "void");
    if (!r) r = consumeToken(b, "duration");
    return r;
  }

  /* ********************************************************** */
  // CATCH IDENTIFIER? BlockStatement
  public static boolean CatchBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CatchBlock")) return false;
    if (!nextTokenIs(b, CATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CATCH);
    r = r && CatchBlock_1(b, l + 1);
    r = r && BlockStatement(b, l + 1);
    exit_section_(b, m, CATCH_BLOCK, r);
    return r;
  }

  // IDENTIFIER?
  private static boolean CatchBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CatchBlock_1")) return false;
    consumeToken(b, IDENTIFIER);
    return true;
  }

  /* ********************************************************** */
  // INFLIGHT_SPECIFIER CLASS IDENTIFIER (EXTENDS CustomType)? (IMPLEMENTS CustomType (COMMA CustomType)*)? ClassImplementation
  public static boolean ClassDefinitionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDefinitionStatement")) return false;
    if (!nextTokenIs(b, INFLIGHT_SPECIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CLASS_DEFINITION_STATEMENT, null);
    r = consumeTokens(b, 1, INFLIGHT_SPECIFIER, CLASS, IDENTIFIER);
    p = r; // pin = 1
    r = r && report_error_(b, ClassDefinitionStatement_3(b, l + 1));
    r = p && report_error_(b, ClassDefinitionStatement_4(b, l + 1)) && r;
    r = p && ClassImplementation(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (EXTENDS CustomType)?
  private static boolean ClassDefinitionStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDefinitionStatement_3")) return false;
    ClassDefinitionStatement_3_0(b, l + 1);
    return true;
  }

  // EXTENDS CustomType
  private static boolean ClassDefinitionStatement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDefinitionStatement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    r = r && CustomType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (IMPLEMENTS CustomType (COMMA CustomType)*)?
  private static boolean ClassDefinitionStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDefinitionStatement_4")) return false;
    ClassDefinitionStatement_4_0(b, l + 1);
    return true;
  }

  // IMPLEMENTS CustomType (COMMA CustomType)*
  private static boolean ClassDefinitionStatement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDefinitionStatement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPLEMENTS);
    r = r && CustomType(b, l + 1);
    r = r && ClassDefinitionStatement_4_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA CustomType)*
  private static boolean ClassDefinitionStatement_4_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDefinitionStatement_4_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ClassDefinitionStatement_4_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ClassDefinitionStatement_4_0_2", c)) break;
    }
    return true;
  }

  // COMMA CustomType
  private static boolean ClassDefinitionStatement_4_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDefinitionStatement_4_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && CustomType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AccessModifier? 'static'? INFLIGHT_SPECIFIER? VAR? IDENTIFIER TypeAnnotation (ASSIGNMENT Expression)? SEMICOLON
  public static boolean ClassField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassField")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_FIELD, "<class field>");
    r = ClassField_0(b, l + 1);
    r = r && ClassField_1(b, l + 1);
    r = r && ClassField_2(b, l + 1);
    r = r && ClassField_3(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && TypeAnnotation(b, l + 1);
    r = r && ClassField_6(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // AccessModifier?
  private static boolean ClassField_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassField_0")) return false;
    AccessModifier(b, l + 1);
    return true;
  }

  // 'static'?
  private static boolean ClassField_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassField_1")) return false;
    consumeToken(b, STATIC);
    return true;
  }

  // INFLIGHT_SPECIFIER?
  private static boolean ClassField_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassField_2")) return false;
    consumeToken(b, INFLIGHT_SPECIFIER);
    return true;
  }

  // VAR?
  private static boolean ClassField_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassField_3")) return false;
    consumeToken(b, VAR);
    return true;
  }

  // (ASSIGNMENT Expression)?
  private static boolean ClassField_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassField_6")) return false;
    ClassField_6_0(b, l + 1);
    return true;
  }

  // ASSIGNMENT Expression
  private static boolean ClassField_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassField_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGNMENT);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_CURLY_BRACE (Initializer | ClassField | MethodDefinition | InflightMethodDefinition )* RIGHT_CURLY_BRACE
  public static boolean ClassImplementation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassImplementation")) return false;
    if (!nextTokenIs(b, LEFT_CURLY_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CLASS_IMPLEMENTATION, null);
    r = consumeToken(b, LEFT_CURLY_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, ClassImplementation_1(b, l + 1));
    r = p && consumeToken(b, RIGHT_CURLY_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (Initializer | ClassField | MethodDefinition | InflightMethodDefinition )*
  private static boolean ClassImplementation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassImplementation_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ClassImplementation_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ClassImplementation_1", c)) break;
    }
    return true;
  }

  // Initializer | ClassField | MethodDefinition | InflightMethodDefinition
  private static boolean ClassImplementation_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassImplementation_1_0")) return false;
    boolean r;
    r = Initializer(b, l + 1);
    if (!r) r = ClassField(b, l + 1);
    if (!r) r = MethodDefinition(b, l + 1);
    if (!r) r = InflightMethodDefinition(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // "<" Type ">"
  public static boolean ContainerValueType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerValueType")) return false;
    if (!nextTokenIs(b, LESS_THAN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS_THAN);
    r = r && Type(b, l + 1);
    r = r && consumeToken(b, GREATER_THAN);
    exit_section_(b, m, CONTAINER_VALUE_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // CONTINUE SEMICOLON
  public static boolean ContinueStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContinueStatement")) return false;
    if (!nextTokenIs(b, CONTINUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CONTINUE, SEMICOLON);
    exit_section_(b, m, CONTINUE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (DOT IDENTIFIER)*
  static boolean CustomType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CustomType")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && CustomType_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean CustomType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CustomType_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!CustomType_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CustomType_1", c)) break;
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean CustomType_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CustomType_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Number "ms"
  //     | Number "s"
  //     | Number "m"
  //     | Number "h"
  //     | Number "d"
  //     | Number "mo"
  //     | Number "y"
  public static boolean Duration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Duration")) return false;
    if (!nextTokenIs(b, "<duration>", DECIMAL, INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DURATION, "<duration>");
    r = Duration_0(b, l + 1);
    if (!r) r = Duration_1(b, l + 1);
    if (!r) r = Duration_2(b, l + 1);
    if (!r) r = Duration_3(b, l + 1);
    if (!r) r = Duration_4(b, l + 1);
    if (!r) r = Duration_5(b, l + 1);
    if (!r) r = Duration_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Number "ms"
  private static boolean Duration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Duration_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Number(b, l + 1);
    r = r && consumeToken(b, "ms");
    exit_section_(b, m, null, r);
    return r;
  }

  // Number "s"
  private static boolean Duration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Duration_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Number(b, l + 1);
    r = r && consumeToken(b, "s");
    exit_section_(b, m, null, r);
    return r;
  }

  // Number "m"
  private static boolean Duration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Duration_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Number(b, l + 1);
    r = r && consumeToken(b, "m");
    exit_section_(b, m, null, r);
    return r;
  }

  // Number "h"
  private static boolean Duration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Duration_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Number(b, l + 1);
    r = r && consumeToken(b, "h");
    exit_section_(b, m, null, r);
    return r;
  }

  // Number "d"
  private static boolean Duration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Duration_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Number(b, l + 1);
    r = r && consumeToken(b, "d");
    exit_section_(b, m, null, r);
    return r;
  }

  // Number "mo"
  private static boolean Duration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Duration_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Number(b, l + 1);
    r = r && consumeToken(b, "mo");
    exit_section_(b, m, null, r);
    return r;
  }

  // Number "y"
  private static boolean Duration_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Duration_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Number(b, l + 1);
    r = r && consumeToken(b, "y");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ELIF Expression BlockStatement
  public static boolean ElIfBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ElIfBlock")) return false;
    if (!nextTokenIs(b, ELIF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELIF);
    r = r && Expression(b, l + 1, -1);
    r = r && BlockStatement(b, l + 1);
    exit_section_(b, m, EL_IF_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // ENUM IDENTIFIER LEFT_CURLY_BRACE (EnumField (COMMA EnumField)* COMMA?)? RIGHT_CURLY_BRACE
  public static boolean EnumDefinitionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDefinitionStatement")) return false;
    if (!nextTokenIs(b, ENUM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ENUM, IDENTIFIER, LEFT_CURLY_BRACE);
    r = r && EnumDefinitionStatement_3(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY_BRACE);
    exit_section_(b, m, ENUM_DEFINITION_STATEMENT, r);
    return r;
  }

  // (EnumField (COMMA EnumField)* COMMA?)?
  private static boolean EnumDefinitionStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDefinitionStatement_3")) return false;
    EnumDefinitionStatement_3_0(b, l + 1);
    return true;
  }

  // EnumField (COMMA EnumField)* COMMA?
  private static boolean EnumDefinitionStatement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDefinitionStatement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EnumField(b, l + 1);
    r = r && EnumDefinitionStatement_3_0_1(b, l + 1);
    r = r && EnumDefinitionStatement_3_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA EnumField)*
  private static boolean EnumDefinitionStatement_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDefinitionStatement_3_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!EnumDefinitionStatement_3_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "EnumDefinitionStatement_3_0_1", c)) break;
    }
    return true;
  }

  // COMMA EnumField
  private static boolean EnumDefinitionStatement_3_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDefinitionStatement_3_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && EnumField(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean EnumDefinitionStatement_3_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDefinitionStatement_3_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean EnumField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumField")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, ENUM_FIELD, r);
    return r;
  }

  /* ********************************************************** */
  // Expression SEMICOLON
  public static boolean ExpressionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionStatement")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_STATEMENT, "<expression statement>");
    r = Expression(b, l + 1, -1);
    p = r; // pin = 1
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // EXTERN String
  public static boolean ExternModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExternModifier")) return false;
    if (!nextTokenIs(b, EXTERN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTERN);
    r = r && String(b, l + 1);
    exit_section_(b, m, EXTERN_MODIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // BuiltInType nb
  //     | BuiltInContainerType
  //     | FunctionType
  //     | CustomType
  //     | JsonContainerType
  static boolean FieldType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldType")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FieldType_0(b, l + 1);
    if (!r) r = BuiltInContainerType(b, l + 1);
    if (!r) r = FunctionType(b, l + 1);
    if (!r) r = CustomType(b, l + 1);
    if (!r) r = JsonContainerType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // BuiltInType nb
  private static boolean FieldType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldType_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BuiltInType(b, l + 1);
    r = r && consumeToken(b, NB);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FINALLY BlockStatement
  public static boolean FinallyBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FinallyBlock")) return false;
    if (!nextTokenIs(b, FINALLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FINALLY);
    r = r && BlockStatement(b, l + 1);
    exit_section_(b, m, FINALLY_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // FOR IDENTIFIER IN Expression BlockStatement
  //     | FOR IDENTIFIER IN LoopRange BlockStatement
  public static boolean ForInLoopStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForInLoopStatement")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ForInLoopStatement_0(b, l + 1);
    if (!r) r = ForInLoopStatement_1(b, l + 1);
    exit_section_(b, m, FOR_IN_LOOP_STATEMENT, r);
    return r;
  }

  // FOR IDENTIFIER IN Expression BlockStatement
  private static boolean ForInLoopStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForInLoopStatement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FOR, IDENTIFIER, IN);
    r = r && Expression(b, l + 1, -1);
    r = r && BlockStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FOR IDENTIFIER IN LoopRange BlockStatement
  private static boolean ForInLoopStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForInLoopStatement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FOR, IDENTIFIER, IN);
    r = r && LoopRange(b, l + 1);
    r = r && BlockStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INFLIGHT_SPECIFIER? ParameterTypeList [COLON Type]
  public static boolean FunctionType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType")) return false;
    if (!nextTokenIs(b, "<function type>", INFLIGHT_SPECIFIER, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_TYPE, "<function type>");
    r = FunctionType_0(b, l + 1);
    r = r && ParameterTypeList(b, l + 1);
    r = r && FunctionType_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // INFLIGHT_SPECIFIER?
  private static boolean FunctionType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType_0")) return false;
    consumeToken(b, INFLIGHT_SPECIFIER);
    return true;
  }

  // [COLON Type]
  private static boolean FunctionType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType_2")) return false;
    FunctionType_2_0(b, l + 1);
    return true;
  }

  // COLON Type
  private static boolean FunctionType_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IF LET IDENTIFIER ASSIGNMENT Expression BlockStatement ElIfBlock* (ELSE BlockStatement)?
  public static boolean IfLetStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfLetStatement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF, LET, IDENTIFIER, ASSIGNMENT);
    r = r && Expression(b, l + 1, -1);
    r = r && BlockStatement(b, l + 1);
    r = r && IfLetStatement_6(b, l + 1);
    r = r && IfLetStatement_7(b, l + 1);
    exit_section_(b, m, IF_LET_STATEMENT, r);
    return r;
  }

  // ElIfBlock*
  private static boolean IfLetStatement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfLetStatement_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ElIfBlock(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "IfLetStatement_6", c)) break;
    }
    return true;
  }

  // (ELSE BlockStatement)?
  private static boolean IfLetStatement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfLetStatement_7")) return false;
    IfLetStatement_7_0(b, l + 1);
    return true;
  }

  // ELSE BlockStatement
  private static boolean IfLetStatement_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfLetStatement_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && BlockStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IF Expression BlockStatement ElIfBlock* (ELSE BlockStatement)?
  public static boolean IfStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && Expression(b, l + 1, -1);
    r = r && BlockStatement(b, l + 1);
    r = r && IfStatement_3(b, l + 1);
    r = r && IfStatement_4(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // ElIfBlock*
  private static boolean IfStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ElIfBlock(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "IfStatement_3", c)) break;
    }
    return true;
  }

  // (ELSE BlockStatement)?
  private static boolean IfStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_4")) return false;
    IfStatement_4_0(b, l + 1);
    return true;
  }

  // ELSE BlockStatement
  private static boolean IfStatement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && BlockStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "Array" ContainerValueType
  //     | "Set" ContainerValueType
  //     | "Map" ContainerValueType
  //     | "Promise" ContainerValueType
  static boolean ImmutableContainerType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImmutableContainerType")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ImmutableContainerType_0(b, l + 1);
    if (!r) r = ImmutableContainerType_1(b, l + 1);
    if (!r) r = ImmutableContainerType_2(b, l + 1);
    if (!r) r = ImmutableContainerType_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "Array" ContainerValueType
  private static boolean ImmutableContainerType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImmutableContainerType_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "Array");
    r = r && ContainerValueType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "Set" ContainerValueType
  private static boolean ImmutableContainerType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImmutableContainerType_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "Set");
    r = r && ContainerValueType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "Map" ContainerValueType
  private static boolean ImmutableContainerType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImmutableContainerType_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "Map");
    r = r && ContainerValueType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "Promise" ContainerValueType
  private static boolean ImmutableContainerType_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImmutableContainerType_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "Promise");
    r = r && ContainerValueType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BRING IDENTIFIER SEMICOLON
  //     | BRING IDENTIFIER ALIAS IDENTIFIER SEMICOLON
  public static boolean ImportStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportStatement")) return false;
    if (!nextTokenIs(b, BRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parseTokens(b, 0, BRING, IDENTIFIER, SEMICOLON);
    if (!r) r = parseTokens(b, 0, BRING, IDENTIFIER, ALIAS, IDENTIFIER, SEMICOLON);
    exit_section_(b, m, IMPORT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ImportStatement ImportStatement*
  public static boolean ImportStatementBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportStatementBlock")) return false;
    if (!nextTokenIs(b, BRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ImportStatement(b, l + 1);
    r = r && ImportStatementBlock_1(b, l + 1);
    exit_section_(b, m, IMPORT_STATEMENT_BLOCK, r);
    return r;
  }

  // ImportStatement*
  private static boolean ImportStatementBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportStatementBlock_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ImportStatement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ImportStatementBlock_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ExternModifier? AccessModifier? static? INFLIGHT_SPECIFIER IDENTIFIER ParameterList TypeAnnotation? (BlockStatement | SEMICOLON)
  public static boolean InflightMethodDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InflightMethodDefinition")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INFLIGHT_METHOD_DEFINITION, "<inflight method definition>");
    r = InflightMethodDefinition_0(b, l + 1);
    r = r && InflightMethodDefinition_1(b, l + 1);
    r = r && InflightMethodDefinition_2(b, l + 1);
    r = r && consumeTokens(b, 1, INFLIGHT_SPECIFIER, IDENTIFIER);
    p = r; // pin = 4
    r = r && report_error_(b, ParameterList(b, l + 1));
    r = p && report_error_(b, InflightMethodDefinition_6(b, l + 1)) && r;
    r = p && InflightMethodDefinition_7(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ExternModifier?
  private static boolean InflightMethodDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InflightMethodDefinition_0")) return false;
    ExternModifier(b, l + 1);
    return true;
  }

  // AccessModifier?
  private static boolean InflightMethodDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InflightMethodDefinition_1")) return false;
    AccessModifier(b, l + 1);
    return true;
  }

  // static?
  private static boolean InflightMethodDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InflightMethodDefinition_2")) return false;
    consumeToken(b, STATIC);
    return true;
  }

  // TypeAnnotation?
  private static boolean InflightMethodDefinition_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InflightMethodDefinition_6")) return false;
    TypeAnnotation(b, l + 1);
    return true;
  }

  // BlockStatement | SEMICOLON
  private static boolean InflightMethodDefinition_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InflightMethodDefinition_7")) return false;
    boolean r;
    r = BlockStatement(b, l + 1);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // INFLIGHT_SPECIFIER IDENTIFIER ParameterList TypeAnnotation SEMICOLON
  public static boolean InflightMethodSignature(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InflightMethodSignature")) return false;
    if (!nextTokenIs(b, INFLIGHT_SPECIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, INFLIGHT_SPECIFIER, IDENTIFIER);
    r = r && ParameterList(b, l + 1);
    r = r && TypeAnnotation(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, INFLIGHT_METHOD_SIGNATURE, r);
    return r;
  }

  /* ********************************************************** */
  // INFLIGHT_SPECIFIER? NEW ParameterList BlockStatement
  public static boolean Initializer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Initializer")) return false;
    if (!nextTokenIs(b, "<initializer>", INFLIGHT_SPECIFIER, NEW)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INITIALIZER, "<initializer>");
    r = Initializer_0(b, l + 1);
    r = r && consumeToken(b, NEW);
    r = r && ParameterList(b, l + 1);
    r = r && BlockStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // INFLIGHT_SPECIFIER?
  private static boolean Initializer_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Initializer_0")) return false;
    consumeToken(b, INFLIGHT_SPECIFIER);
    return true;
  }

  /* ********************************************************** */
  // INTERFACE IDENTIFIER (EXTENDS CustomType (COMMA CustomType)*)? InterfaceImplementation
  public static boolean InterfaceDefinitionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceDefinitionStatement")) return false;
    if (!nextTokenIs(b, INTERFACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INTERFACE_DEFINITION_STATEMENT, null);
    r = consumeTokens(b, 1, INTERFACE, IDENTIFIER);
    p = r; // pin = 1
    r = r && report_error_(b, InterfaceDefinitionStatement_2(b, l + 1));
    r = p && InterfaceImplementation(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (EXTENDS CustomType (COMMA CustomType)*)?
  private static boolean InterfaceDefinitionStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceDefinitionStatement_2")) return false;
    InterfaceDefinitionStatement_2_0(b, l + 1);
    return true;
  }

  // EXTENDS CustomType (COMMA CustomType)*
  private static boolean InterfaceDefinitionStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceDefinitionStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    r = r && CustomType(b, l + 1);
    r = r && InterfaceDefinitionStatement_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA CustomType)*
  private static boolean InterfaceDefinitionStatement_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceDefinitionStatement_2_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!InterfaceDefinitionStatement_2_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "InterfaceDefinitionStatement_2_0_2", c)) break;
    }
    return true;
  }

  // COMMA CustomType
  private static boolean InterfaceDefinitionStatement_2_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceDefinitionStatement_2_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && CustomType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_CURLY_BRACE (MethodSignature | InflightMethodSignature | ClassField )* RIGHT_CURLY_BRACE
  public static boolean InterfaceImplementation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceImplementation")) return false;
    if (!nextTokenIs(b, LEFT_CURLY_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INTERFACE_IMPLEMENTATION, null);
    r = consumeToken(b, LEFT_CURLY_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, InterfaceImplementation_1(b, l + 1));
    r = p && consumeToken(b, RIGHT_CURLY_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (MethodSignature | InflightMethodSignature | ClassField )*
  private static boolean InterfaceImplementation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceImplementation_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!InterfaceImplementation_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "InterfaceImplementation_1", c)) break;
    }
    return true;
  }

  // MethodSignature | InflightMethodSignature | ClassField
  private static boolean InterfaceImplementation_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceImplementation_1_0")) return false;
    boolean r;
    r = MethodSignature(b, l + 1);
    if (!r) r = InflightMethodSignature(b, l + 1);
    if (!r) r = ClassField(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // "Json"
  //     | "MutJson"
  static boolean JsonContainerType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonContainerType")) return false;
    boolean r;
    r = consumeToken(b, "Json");
    if (!r) r = consumeToken(b, "MutJson");
    return r;
  }

  /* ********************************************************** */
  // LEFT_CURLY_BRACE (JsonMapLiteralMember (COMMA JsonMapLiteralMember)* COMMA?)? RIGHT_CURLY_BRACE
  public static boolean JsonMapLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonMapLiteral")) return false;
    if (!nextTokenIs(b, LEFT_CURLY_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_CURLY_BRACE);
    r = r && JsonMapLiteral_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY_BRACE);
    exit_section_(b, m, JSON_MAP_LITERAL, r);
    return r;
  }

  // (JsonMapLiteralMember (COMMA JsonMapLiteralMember)* COMMA?)?
  private static boolean JsonMapLiteral_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonMapLiteral_1")) return false;
    JsonMapLiteral_1_0(b, l + 1);
    return true;
  }

  // JsonMapLiteralMember (COMMA JsonMapLiteralMember)* COMMA?
  private static boolean JsonMapLiteral_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonMapLiteral_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = JsonMapLiteralMember(b, l + 1);
    r = r && JsonMapLiteral_1_0_1(b, l + 1);
    r = r && JsonMapLiteral_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA JsonMapLiteralMember)*
  private static boolean JsonMapLiteral_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonMapLiteral_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!JsonMapLiteral_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "JsonMapLiteral_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA JsonMapLiteralMember
  private static boolean JsonMapLiteral_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonMapLiteral_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && JsonMapLiteralMember(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean JsonMapLiteral_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonMapLiteral_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // (String | IDENTIFIER) COLON Expression
  public static boolean JsonMapLiteralMember(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonMapLiteralMember")) return false;
    if (!nextTokenIs(b, "<json map literal member>", IDENTIFIER, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JSON_MAP_LITERAL_MEMBER, "<json map literal member>");
    r = JsonMapLiteralMember_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // String | IDENTIFIER
  private static boolean JsonMapLiteralMember_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonMapLiteralMember_0")) return false;
    boolean r;
    r = String(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  /* ********************************************************** */
  // AND
  //     | OR
  //     | NOT
  public static boolean LogicalOperators(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LogicalOperators")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOGICAL_OPERATORS, "<logical operators>");
    r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, OR);
    if (!r) r = consumeToken(b, NOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Expression '..' '='? Expression
  public static boolean LoopRange(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LoopRange")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOOP_RANGE, "<loop range>");
    r = Expression(b, l + 1, -1);
    r = r && consumeToken(b, "..");
    r = r && LoopRange_2(b, l + 1);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '='?
  private static boolean LoopRange_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LoopRange_2")) return false;
    consumeToken(b, ASSIGNMENT);
    return true;
  }

  /* ********************************************************** */
  // BuiltInContainerType? LEFT_CURLY_BRACE MapLiteralMember (COMMA MapLiteralMember)* COMMA? RIGHT_CURLY_BRACE
  public static boolean MapLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapLiteralExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAP_LITERAL_EXPRESSION, "<map literal expression>");
    r = MapLiteralExpression_0(b, l + 1);
    r = r && consumeToken(b, LEFT_CURLY_BRACE);
    r = r && MapLiteralMember(b, l + 1);
    r = r && MapLiteralExpression_3(b, l + 1);
    r = r && MapLiteralExpression_4(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BuiltInContainerType?
  private static boolean MapLiteralExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapLiteralExpression_0")) return false;
    BuiltInContainerType(b, l + 1);
    return true;
  }

  // (COMMA MapLiteralMember)*
  private static boolean MapLiteralExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapLiteralExpression_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!MapLiteralExpression_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MapLiteralExpression_3", c)) break;
    }
    return true;
  }

  // COMMA MapLiteralMember
  private static boolean MapLiteralExpression_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapLiteralExpression_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && MapLiteralMember(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean MapLiteralExpression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapLiteralExpression_4")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // String ARROW Expression
  public static boolean MapLiteralMember(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapLiteralMember")) return false;
    if (!nextTokenIs(b, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = String(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, MAP_LITERAL_MEMBER, r);
    return r;
  }

  /* ********************************************************** */
  // ADDITION
  //     | SUBTRACTION
  //     | MULTIPLY
  //     | DIVIDE
  //     | MODULO
  //     | FLOOR_DIVIDE
  //     | POWER
  public static boolean MathematicalOperators(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathematicalOperators")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATHEMATICAL_OPERATORS, "<mathematical operators>");
    r = consumeToken(b, ADDITION);
    if (!r) r = consumeToken(b, SUBTRACTION);
    if (!r) r = consumeToken(b, MULTIPLY);
    if (!r) r = consumeToken(b, DIVIDE);
    if (!r) r = consumeToken(b, MODULO);
    if (!r) r = consumeToken(b, FLOOR_DIVIDE);
    if (!r) r = consumeToken(b, POWER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ExternModifier? AccessModifier? static? 'async'? IDENTIFIER ParameterList TypeAnnotation? (BlockStatement | SEMICOLON)
  public static boolean MethodDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodDefinition")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, METHOD_DEFINITION, "<method definition>");
    r = MethodDefinition_0(b, l + 1);
    r = r && MethodDefinition_1(b, l + 1);
    r = r && MethodDefinition_2(b, l + 1);
    r = r && MethodDefinition_3(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    p = r; // pin = 5
    r = r && report_error_(b, ParameterList(b, l + 1));
    r = p && report_error_(b, MethodDefinition_6(b, l + 1)) && r;
    r = p && MethodDefinition_7(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ExternModifier?
  private static boolean MethodDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodDefinition_0")) return false;
    ExternModifier(b, l + 1);
    return true;
  }

  // AccessModifier?
  private static boolean MethodDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodDefinition_1")) return false;
    AccessModifier(b, l + 1);
    return true;
  }

  // static?
  private static boolean MethodDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodDefinition_2")) return false;
    consumeToken(b, STATIC);
    return true;
  }

  // 'async'?
  private static boolean MethodDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodDefinition_3")) return false;
    consumeToken(b, ASYNC);
    return true;
  }

  // TypeAnnotation?
  private static boolean MethodDefinition_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodDefinition_6")) return false;
    TypeAnnotation(b, l + 1);
    return true;
  }

  // BlockStatement | SEMICOLON
  private static boolean MethodDefinition_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodDefinition_7")) return false;
    boolean r;
    r = BlockStatement(b, l + 1);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ASYNC? IDENTIFIER ParameterList TypeAnnotation SEMICOLON
  public static boolean MethodSignature(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodSignature")) return false;
    if (!nextTokenIs(b, "<method signature>", ASYNC, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_SIGNATURE, "<method signature>");
    r = MethodSignature_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && ParameterList(b, l + 1);
    r = r && TypeAnnotation(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ASYNC?
  private static boolean MethodSignature_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodSignature_0")) return false;
    consumeToken(b, ASYNC);
    return true;
  }

  /* ********************************************************** */
  // "MutSet" ContainerValueType
  //     | "MutMap" ContainerValueType
  //     | "MutArray" ContainerValueType
  static boolean MutableContainerType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MutableContainerType")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MutableContainerType_0(b, l + 1);
    if (!r) r = MutableContainerType_1(b, l + 1);
    if (!r) r = MutableContainerType_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "MutSet" ContainerValueType
  private static boolean MutableContainerType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MutableContainerType_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "MutSet");
    r = r && ContainerValueType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "MutMap" ContainerValueType
  private static boolean MutableContainerType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MutableContainerType_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "MutMap");
    r = r && ContainerValueType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "MutArray" ContainerValueType
  private static boolean MutableContainerType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MutableContainerType_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "MutArray");
    r = r && ContainerValueType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INTEGER
  //     | DECIMAL
  public static boolean Number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Number")) return false;
    if (!nextTokenIs(b, "<number>", DECIMAL, INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER, "<number>");
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, DECIMAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // MathematicalOperators
  //     | LogicalOperators
  //     | RelationalOperators
  //     | UNWRAP_OR
  public static boolean Operators(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operators")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERATORS, "<operators>");
    r = MathematicalOperators(b, l + 1);
    if (!r) r = LogicalOperators(b, l + 1);
    if (!r) r = RelationalOperators(b, l + 1);
    if (!r) r = consumeToken(b, UNWRAP_OR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FieldType QUESTION_MARK
  static boolean OptionalType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OptionalType")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FieldType(b, l + 1);
    r = r && consumeToken(b, QUESTION_MARK);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VAR? IDENTIFIER TypeAnnotation
  public static boolean ParameterDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterDefinition")) return false;
    if (!nextTokenIs(b, "<parameter definition>", IDENTIFIER, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER_DEFINITION, "<parameter definition>");
    r = ParameterDefinition_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && TypeAnnotation(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VAR?
  private static boolean ParameterDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterDefinition_0")) return false;
    consumeToken(b, VAR);
    return true;
  }

  /* ********************************************************** */
  // LEFT_PARENTHESIS [ParameterDefinition (COMMA ParameterDefinition)* COMMA?] RIGHT_PARENTHESIS
  public static boolean ParameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PARENTHESIS);
    r = r && ParameterList_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESIS);
    exit_section_(b, m, PARAMETER_LIST, r);
    return r;
  }

  // [ParameterDefinition (COMMA ParameterDefinition)* COMMA?]
  private static boolean ParameterList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1")) return false;
    ParameterList_1_0(b, l + 1);
    return true;
  }

  // ParameterDefinition (COMMA ParameterDefinition)* COMMA?
  private static boolean ParameterList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ParameterDefinition(b, l + 1);
    r = r && ParameterList_1_0_1(b, l + 1);
    r = r && ParameterList_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA ParameterDefinition)*
  private static boolean ParameterList_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ParameterList_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ParameterList_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA ParameterDefinition
  private static boolean ParameterList_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ParameterDefinition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean ParameterList_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // LEFT_PARENTHESIS [Type (COMMA Type)* COMMA?] RIGHT_PARENTHESIS
  public static boolean ParameterTypeList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterTypeList")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PARENTHESIS);
    r = r && ParameterTypeList_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESIS);
    exit_section_(b, m, PARAMETER_TYPE_LIST, r);
    return r;
  }

  // [Type (COMMA Type)* COMMA?]
  private static boolean ParameterTypeList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterTypeList_1")) return false;
    ParameterTypeList_1_0(b, l + 1);
    return true;
  }

  // Type (COMMA Type)* COMMA?
  private static boolean ParameterTypeList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterTypeList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Type(b, l + 1);
    r = r && ParameterTypeList_1_0_1(b, l + 1);
    r = r && ParameterTypeList_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA Type)*
  private static boolean ParameterTypeList_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterTypeList_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ParameterTypeList_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ParameterTypeList_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA Type
  private static boolean ParameterTypeList_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterTypeList_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean ParameterTypeList_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterTypeList_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // EQUAL
  //     | NOT_EQUAL
  //     | LESS_THAN
  //     | LESS_THAN_OR_EQUAL
  //     | GREATER_THAN
  //     | GREATER_THAN_OR_EQUAL
  public static boolean RelationalOperators(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalOperators")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATIONAL_OPERATORS, "<relational operators>");
    r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, NOT_EQUAL);
    if (!r) r = consumeToken(b, LESS_THAN);
    if (!r) r = consumeToken(b, LESS_THAN_OR_EQUAL);
    if (!r) r = consumeToken(b, GREATER_THAN);
    if (!r) r = consumeToken(b, GREATER_THAN_OR_EQUAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CLASS IDENTIFIER (EXTENDS CustomType)? (IMPLEMENTS CustomType (COMMA CustomType)*)?  ResourceImplementation
  public static boolean ResourceDefinitionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ResourceDefinitionStatement")) return false;
    if (!nextTokenIs(b, CLASS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RESOURCE_DEFINITION_STATEMENT, null);
    r = consumeTokens(b, 1, CLASS, IDENTIFIER);
    p = r; // pin = 1
    r = r && report_error_(b, ResourceDefinitionStatement_2(b, l + 1));
    r = p && report_error_(b, ResourceDefinitionStatement_3(b, l + 1)) && r;
    r = p && ResourceImplementation(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (EXTENDS CustomType)?
  private static boolean ResourceDefinitionStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ResourceDefinitionStatement_2")) return false;
    ResourceDefinitionStatement_2_0(b, l + 1);
    return true;
  }

  // EXTENDS CustomType
  private static boolean ResourceDefinitionStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ResourceDefinitionStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    r = r && CustomType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (IMPLEMENTS CustomType (COMMA CustomType)*)?
  private static boolean ResourceDefinitionStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ResourceDefinitionStatement_3")) return false;
    ResourceDefinitionStatement_3_0(b, l + 1);
    return true;
  }

  // IMPLEMENTS CustomType (COMMA CustomType)*
  private static boolean ResourceDefinitionStatement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ResourceDefinitionStatement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPLEMENTS);
    r = r && CustomType(b, l + 1);
    r = r && ResourceDefinitionStatement_3_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA CustomType)*
  private static boolean ResourceDefinitionStatement_3_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ResourceDefinitionStatement_3_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ResourceDefinitionStatement_3_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ResourceDefinitionStatement_3_0_2", c)) break;
    }
    return true;
  }

  // COMMA CustomType
  private static boolean ResourceDefinitionStatement_3_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ResourceDefinitionStatement_3_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && CustomType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_CURLY_BRACE (Initializer | ClassField | MethodDefinition | InflightMethodDefinition )* RIGHT_CURLY_BRACE
  public static boolean ResourceImplementation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ResourceImplementation")) return false;
    if (!nextTokenIs(b, LEFT_CURLY_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RESOURCE_IMPLEMENTATION, null);
    r = consumeToken(b, LEFT_CURLY_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, ResourceImplementation_1(b, l + 1));
    r = p && consumeToken(b, RIGHT_CURLY_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (Initializer | ClassField | MethodDefinition | InflightMethodDefinition )*
  private static boolean ResourceImplementation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ResourceImplementation_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ResourceImplementation_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ResourceImplementation_1", c)) break;
    }
    return true;
  }

  // Initializer | ClassField | MethodDefinition | InflightMethodDefinition
  private static boolean ResourceImplementation_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ResourceImplementation_1_0")) return false;
    boolean r;
    r = Initializer(b, l + 1);
    if (!r) r = ClassField(b, l + 1);
    if (!r) r = MethodDefinition(b, l + 1);
    if (!r) r = InflightMethodDefinition(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // RETURN Expression SEMICOLON
  public static boolean ReturnStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStatement")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, RETURN_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // Statement*
  static boolean Schema(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Schema")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Schema", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // BuiltInContainerType? LEFT_CURLY_BRACE( Expression (COMMA Expression)* COMMA?)? RIGHT_CURLY_BRACE
  public static boolean SetLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetLiteralExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SET_LITERAL_EXPRESSION, "<set literal expression>");
    r = SetLiteralExpression_0(b, l + 1);
    r = r && consumeToken(b, LEFT_CURLY_BRACE);
    r = r && SetLiteralExpression_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BuiltInContainerType?
  private static boolean SetLiteralExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetLiteralExpression_0")) return false;
    BuiltInContainerType(b, l + 1);
    return true;
  }

  // ( Expression (COMMA Expression)* COMMA?)?
  private static boolean SetLiteralExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetLiteralExpression_2")) return false;
    SetLiteralExpression_2_0(b, l + 1);
    return true;
  }

  // Expression (COMMA Expression)* COMMA?
  private static boolean SetLiteralExpression_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetLiteralExpression_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1, -1);
    r = r && SetLiteralExpression_2_0_1(b, l + 1);
    r = r && SetLiteralExpression_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA Expression)*
  private static boolean SetLiteralExpression_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetLiteralExpression_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!SetLiteralExpression_2_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SetLiteralExpression_2_0_1", c)) break;
    }
    return true;
  }

  // COMMA Expression
  private static boolean SetLiteralExpression_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetLiteralExpression_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean SetLiteralExpression_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SetLiteralExpression_2_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // ImportStatementBlock
  //     | TestStatement
  //     | ExpressionStatement
  //     | ForInLoopStatement
  //     | IfStatement
  //     | BreakStatement
  //     | ContinueStatement
  //     | WhileStatement
  //     | ClassDefinitionStatement
  //     | VariableAssignmentStatement
  //     | VariableDefinitionStatement
  //     | ResourceDefinitionStatement
  //     | ReturnStatement
  //     | InterfaceDefinitionStatement
  //     | StructDefinitionStatement
  //     | EnumDefinitionStatement
  //     | IfLetStatement
  //     | TryCatchStatement
  //     | SuperConstructorStatement
  static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    r = ImportStatementBlock(b, l + 1);
    if (!r) r = TestStatement(b, l + 1);
    if (!r) r = ExpressionStatement(b, l + 1);
    if (!r) r = ForInLoopStatement(b, l + 1);
    if (!r) r = IfStatement(b, l + 1);
    if (!r) r = BreakStatement(b, l + 1);
    if (!r) r = ContinueStatement(b, l + 1);
    if (!r) r = WhileStatement(b, l + 1);
    if (!r) r = ClassDefinitionStatement(b, l + 1);
    if (!r) r = VariableAssignmentStatement(b, l + 1);
    if (!r) r = VariableDefinitionStatement(b, l + 1);
    if (!r) r = ResourceDefinitionStatement(b, l + 1);
    if (!r) r = ReturnStatement(b, l + 1);
    if (!r) r = InterfaceDefinitionStatement(b, l + 1);
    if (!r) r = StructDefinitionStatement(b, l + 1);
    if (!r) r = EnumDefinitionStatement(b, l + 1);
    if (!r) r = IfLetStatement(b, l + 1);
    if (!r) r = TryCatchStatement(b, l + 1);
    if (!r) r = SuperConstructorStatement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // STRING_LITERAL
  public static boolean String(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "String")) return false;
    if (!nextTokenIs(b, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_LITERAL);
    exit_section_(b, m, STRING, r);
    return r;
  }

  /* ********************************************************** */
  // STRUCT IDENTIFIER (EXTENDS CustomType (COMMA CustomType)*)? StructImplementation
  public static boolean StructDefinitionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructDefinitionStatement")) return false;
    if (!nextTokenIs(b, STRUCT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_DEFINITION_STATEMENT, null);
    r = consumeTokens(b, 1, STRUCT, IDENTIFIER);
    p = r; // pin = 1
    r = r && report_error_(b, StructDefinitionStatement_2(b, l + 1));
    r = p && StructImplementation(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (EXTENDS CustomType (COMMA CustomType)*)?
  private static boolean StructDefinitionStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructDefinitionStatement_2")) return false;
    StructDefinitionStatement_2_0(b, l + 1);
    return true;
  }

  // EXTENDS CustomType (COMMA CustomType)*
  private static boolean StructDefinitionStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructDefinitionStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    r = r && CustomType(b, l + 1);
    r = r && StructDefinitionStatement_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA CustomType)*
  private static boolean StructDefinitionStatement_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructDefinitionStatement_2_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!StructDefinitionStatement_2_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StructDefinitionStatement_2_0_2", c)) break;
    }
    return true;
  }

  // COMMA CustomType
  private static boolean StructDefinitionStatement_2_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructDefinitionStatement_2_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && CustomType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER TypeAnnotation SEMICOLON
  public static boolean StructField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructField")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_FIELD, null);
    r = consumeToken(b, IDENTIFIER);
    p = r; // pin = 1
    r = r && report_error_(b, TypeAnnotation(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // LEFT_CURLY_BRACE StructField* RIGHT_CURLY_BRACE
  static boolean StructImplementation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructImplementation")) return false;
    if (!nextTokenIs(b, LEFT_CURLY_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, LEFT_CURLY_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, StructImplementation_1(b, l + 1));
    r = p && consumeToken(b, RIGHT_CURLY_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // StructField*
  private static boolean StructImplementation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructImplementation_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!StructField(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StructImplementation_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER COLON Expression
  public static boolean StructLiteralMember(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructLiteralMember")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, COLON);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, STRUCT_LITERAL_MEMBER, r);
    return r;
  }

  /* ********************************************************** */
  // SUPER ArgumentList SEMICOLON
  public static boolean SuperConstructorStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuperConstructorStatement")) return false;
    if (!nextTokenIs(b, SUPER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUPER);
    r = r && ArgumentList(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, SUPER_CONSTRUCTOR_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // TEST String BlockStatement
  public static boolean TestStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TestStatement")) return false;
    if (!nextTokenIs(b, TEST)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TEST);
    r = r && String(b, l + 1);
    r = r && BlockStatement(b, l + 1);
    exit_section_(b, m, TEST_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // TRY BlockStatement CatchBlock? FinallyBlock?
  public static boolean TryCatchStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryCatchStatement")) return false;
    if (!nextTokenIs(b, TRY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRY);
    r = r && BlockStatement(b, l + 1);
    r = r && TryCatchStatement_2(b, l + 1);
    r = r && TryCatchStatement_3(b, l + 1);
    exit_section_(b, m, TRY_CATCH_STATEMENT, r);
    return r;
  }

  // CatchBlock?
  private static boolean TryCatchStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryCatchStatement_2")) return false;
    CatchBlock(b, l + 1);
    return true;
  }

  // FinallyBlock?
  private static boolean TryCatchStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryCatchStatement_3")) return false;
    FinallyBlock(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // OptionalType
  //     | FieldType
  public static boolean Type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = OptionalType(b, l + 1);
    if (!r) r = FieldType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COLON Type
  public static boolean TypeAnnotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeAnnotation")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Type(b, l + 1);
    exit_section_(b, m, TYPE_ANNOTATION, r);
    return r;
  }

  /* ********************************************************** */
  // NOT
  //     | SUBTRACTION
  public static boolean UnaryOperators(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryOperators")) return false;
    if (!nextTokenIs(b, "<unary operators>", NOT, SUBTRACTION)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_OPERATORS, "<unary operators>");
    r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, SUBTRACTION);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ReferenceExpression ASSIGNMENT Expression SEMICOLON
  //     | StructuredAccessExpression ASSIGNMENT Expression SEMICOLON
  //     | NestedIdentifierExpression ASSIGNMENT Expression SEMICOLON
  //     | NestedIdentifierJsonExpression ASSIGNMENT Expression SEMICOLON
  public static boolean VariableAssignmentStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableAssignmentStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_ASSIGNMENT_STATEMENT, "<variable assignment statement>");
    r = VariableAssignmentStatement_0(b, l + 1);
    if (!r) r = VariableAssignmentStatement_1(b, l + 1);
    if (!r) r = VariableAssignmentStatement_2(b, l + 1);
    if (!r) r = VariableAssignmentStatement_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ReferenceExpression ASSIGNMENT Expression SEMICOLON
  private static boolean VariableAssignmentStatement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableAssignmentStatement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ReferenceExpression(b, l + 1);
    r = r && consumeToken(b, ASSIGNMENT);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // StructuredAccessExpression ASSIGNMENT Expression SEMICOLON
  private static boolean VariableAssignmentStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableAssignmentStatement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1, 9);
    r = r && consumeToken(b, ASSIGNMENT);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // NestedIdentifierExpression ASSIGNMENT Expression SEMICOLON
  private static boolean VariableAssignmentStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableAssignmentStatement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1, 6);
    r = r && consumeToken(b, ASSIGNMENT);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // NestedIdentifierJsonExpression ASSIGNMENT Expression SEMICOLON
  private static boolean VariableAssignmentStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableAssignmentStatement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = NestedIdentifierJsonExpression(b, l + 1);
    r = r && consumeToken(b, ASSIGNMENT);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LET VAR? IDENTIFIER TypeAnnotation? ASSIGNMENT Expression SEMICOLON
  public static boolean VariableDefinitionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinitionStatement")) return false;
    if (!nextTokenIs(b, LET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LET);
    r = r && VariableDefinitionStatement_1(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && VariableDefinitionStatement_3(b, l + 1);
    r = r && consumeToken(b, ASSIGNMENT);
    r = r && Expression(b, l + 1, -1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, VARIABLE_DEFINITION_STATEMENT, r);
    return r;
  }

  // VAR?
  private static boolean VariableDefinitionStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinitionStatement_1")) return false;
    consumeToken(b, VAR);
    return true;
  }

  // TypeAnnotation?
  private static boolean VariableDefinitionStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinitionStatement_3")) return false;
    TypeAnnotation(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // WHILE Expression BlockStatement
  public static boolean WhileStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && Expression(b, l + 1, -1);
    r = r && BlockStatement(b, l + 1);
    exit_section_(b, m, WHILE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // Expression root: Expression
  // Operator priority table:
  // 0: BINARY(BinaryExpression)
  // 1: PREFIX(UnaryExpression)
  // 2: ATOM(NewExpression)
  // 3: ATOM(StructLiteralExpression)
  // 4: ATOM(JsonLiteralExpression)
  // 5: ATOM(LiteralExpression)
  // 6: ATOM(ReferenceExpression)
  // 7: POSTFIX(NestedIdentifierExpression)
  // 8: ATOM(NestedIdentifierJsonExpression)
  // 9: POSTFIX(CallExpression)
  // 10: BINARY(StructuredAccessExpression)
  // 11: ATOM(SuperCallExpression)
  // 12: ATOM(PreflightClosureExpression)
  // 13: ATOM(InflightClosureExpression)
  // 14: PREFIX(AwaitExpression)
  // 15: PREFIX(DeferExpression)
  // 16: ATOM(CollectionLiteralExpression)
  // 17: PREFIX(ParenthesizedExpression)
  // 18: POSTFIX(OptionalTestExpression)
  public static boolean Expression(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    addVariant(b, "<expression>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expression>");
    r = UnaryExpression(b, l + 1);
    if (!r) r = NewExpression(b, l + 1);
    if (!r) r = StructLiteralExpression(b, l + 1);
    if (!r) r = JsonLiteralExpression(b, l + 1);
    if (!r) r = LiteralExpression(b, l + 1);
    if (!r) r = ReferenceExpression(b, l + 1);
    if (!r) r = NestedIdentifierJsonExpression(b, l + 1);
    if (!r) r = SuperCallExpression(b, l + 1);
    if (!r) r = PreflightClosureExpression(b, l + 1);
    if (!r) r = InflightClosureExpression(b, l + 1);
    if (!r) r = AwaitExpression(b, l + 1);
    if (!r) r = DeferExpression(b, l + 1);
    if (!r) r = CollectionLiteralExpression(b, l + 1);
    if (!r) r = ParenthesizedExpression(b, l + 1);
    p = r;
    r = r && Expression_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean Expression_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "Expression_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 0 && Operators(b, l + 1)) {
        r = Expression(b, l, 0);
        exit_section_(b, l, m, BINARY_EXPRESSION, r, true, null);
      }
      else if (g < 7 && NestedIdentifierExpression_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, NESTED_IDENTIFIER_EXPRESSION, r, true, null);
      }
      else if (g < 9 && ArgumentList(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, CALL_EXPRESSION, r, true, null);
      }
      else if (g < 10 && consumeTokenSmart(b, LEFT_SQUARE_BRACE)) {
        r = report_error_(b, Expression(b, l, 10));
        r = consumeToken(b, RIGHT_SQUARE_BRACE) && r;
        exit_section_(b, l, m, STRUCTURED_ACCESS_EXPRESSION, r, true, null);
      }
      else if (g < 18 && consumeTokenSmart(b, QUESTION_MARK)) {
        r = true;
        exit_section_(b, l, m, OPTIONAL_TEST_EXPRESSION, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  public static boolean UnaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryExpression")) return false;
    if (!nextTokenIsSmart(b, NOT, SUBTRACTION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = UnaryOperators(b, l + 1);
    p = r;
    r = p && Expression(b, l, 1);
    exit_section_(b, l, m, UNARY_EXPRESSION, r, p, null);
    return r || p;
  }

  // NEW (CustomType | MutableContainerType) ArgumentList (ALIAS Expression)? (IN Expression)?
  public static boolean NewExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NewExpression")) return false;
    if (!nextTokenIsSmart(b, NEW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, NEW);
    r = r && NewExpression_1(b, l + 1);
    r = r && ArgumentList(b, l + 1);
    r = r && NewExpression_3(b, l + 1);
    r = r && NewExpression_4(b, l + 1);
    exit_section_(b, m, NEW_EXPRESSION, r);
    return r;
  }

  // CustomType | MutableContainerType
  private static boolean NewExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NewExpression_1")) return false;
    boolean r;
    r = CustomType(b, l + 1);
    if (!r) r = MutableContainerType(b, l + 1);
    return r;
  }

  // (ALIAS Expression)?
  private static boolean NewExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NewExpression_3")) return false;
    NewExpression_3_0(b, l + 1);
    return true;
  }

  // ALIAS Expression
  private static boolean NewExpression_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NewExpression_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, ALIAS);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (IN Expression)?
  private static boolean NewExpression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NewExpression_4")) return false;
    NewExpression_4_0(b, l + 1);
    return true;
  }

  // IN Expression
  private static boolean NewExpression_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NewExpression_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, IN);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CustomType LEFT_CURLY_BRACE StructLiteralMember* (COMMA StructLiteralMember)* COMMA? RIGHT_CURLY_BRACE
  public static boolean StructLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructLiteralExpression")) return false;
    if (!nextTokenIsSmart(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CustomType(b, l + 1);
    r = r && consumeToken(b, LEFT_CURLY_BRACE);
    r = r && StructLiteralExpression_2(b, l + 1);
    r = r && StructLiteralExpression_3(b, l + 1);
    r = r && StructLiteralExpression_4(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY_BRACE);
    exit_section_(b, m, STRUCT_LITERAL_EXPRESSION, r);
    return r;
  }

  // StructLiteralMember*
  private static boolean StructLiteralExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructLiteralExpression_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!StructLiteralMember(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StructLiteralExpression_2", c)) break;
    }
    return true;
  }

  // (COMMA StructLiteralMember)*
  private static boolean StructLiteralExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructLiteralExpression_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!StructLiteralExpression_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StructLiteralExpression_3", c)) break;
    }
    return true;
  }

  // COMMA StructLiteralMember
  private static boolean StructLiteralExpression_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructLiteralExpression_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, COMMA);
    r = r && StructLiteralMember(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean StructLiteralExpression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructLiteralExpression_4")) return false;
    consumeTokenSmart(b, COMMA);
    return true;
  }

  // JsonContainerType Expression
  //     | JsonMapLiteral
  public static boolean JsonLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonLiteralExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, JSON_LITERAL_EXPRESSION, "<json literal expression>");
    r = JsonLiteralExpression_0(b, l + 1);
    if (!r) r = JsonMapLiteral(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // JsonContainerType Expression
  private static boolean JsonLiteralExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonLiteralExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = JsonContainerType(b, l + 1);
    r = r && Expression(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // String
  //     | BOOL
  //     | Duration
  //     | Number
  //     | NIL
  public static boolean LiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPRESSION, "<literal expression>");
    r = String(b, l + 1);
    if (!r) r = consumeTokenSmart(b, BOOL);
    if (!r) r = Duration(b, l + 1);
    if (!r) r = Number(b, l + 1);
    if (!r) r = consumeTokenSmart(b, NIL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER (Accessor IDENTIFIER)*
  //     | IDENTIFIER
  public static boolean ReferenceExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReferenceExpression")) return false;
    if (!nextTokenIsSmart(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ReferenceExpression_0(b, l + 1);
    if (!r) r = consumeTokenSmart(b, IDENTIFIER);
    exit_section_(b, m, REFERENCE_EXPRESSION, r);
    return r;
  }

  // IDENTIFIER (Accessor IDENTIFIER)*
  private static boolean ReferenceExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReferenceExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, IDENTIFIER);
    r = r && ReferenceExpression_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (Accessor IDENTIFIER)*
  private static boolean ReferenceExpression_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReferenceExpression_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ReferenceExpression_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ReferenceExpression_0_1", c)) break;
    }
    return true;
  }

  // Accessor IDENTIFIER
  private static boolean ReferenceExpression_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReferenceExpression_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Accessor(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // Accessor IDENTIFIER?
  private static boolean NestedIdentifierExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NestedIdentifierExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Accessor(b, l + 1);
    r = r && NestedIdentifierExpression_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER?
  private static boolean NestedIdentifierExpression_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NestedIdentifierExpression_0_1")) return false;
    consumeTokenSmart(b, IDENTIFIER);
    return true;
  }

  // JsonContainerType Accessor IDENTIFIER?
  public static boolean NestedIdentifierJsonExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NestedIdentifierJsonExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NESTED_IDENTIFIER_JSON_EXPRESSION, "<nested identifier json expression>");
    r = JsonContainerType(b, l + 1);
    r = r && Accessor(b, l + 1);
    r = r && NestedIdentifierJsonExpression_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER?
  private static boolean NestedIdentifierJsonExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NestedIdentifierJsonExpression_2")) return false;
    consumeTokenSmart(b, IDENTIFIER);
    return true;
  }

  // 'super' DOT IDENTIFIER ArgumentList
  public static boolean SuperCallExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuperCallExpression")) return false;
    if (!nextTokenIsSmart(b, SUPER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokensSmart(b, 0, SUPER, DOT, IDENTIFIER);
    r = r && ArgumentList(b, l + 1);
    exit_section_(b, m, SUPER_CALL_EXPRESSION, r);
    return r;
  }

  // ParameterList TypeAnnotation? ARROW BlockStatement
  public static boolean PreflightClosureExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PreflightClosureExpression")) return false;
    if (!nextTokenIsSmart(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ParameterList(b, l + 1);
    r = r && PreflightClosureExpression_1(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && BlockStatement(b, l + 1);
    exit_section_(b, m, PREFLIGHT_CLOSURE_EXPRESSION, r);
    return r;
  }

  // TypeAnnotation?
  private static boolean PreflightClosureExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PreflightClosureExpression_1")) return false;
    TypeAnnotation(b, l + 1);
    return true;
  }

  // INFLIGHT_SPECIFIER ParameterList TypeAnnotation? ARROW BlockStatement
  public static boolean InflightClosureExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InflightClosureExpression")) return false;
    if (!nextTokenIsSmart(b, INFLIGHT_SPECIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, INFLIGHT_SPECIFIER);
    r = r && ParameterList(b, l + 1);
    r = r && InflightClosureExpression_2(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && BlockStatement(b, l + 1);
    exit_section_(b, m, INFLIGHT_CLOSURE_EXPRESSION, r);
    return r;
  }

  // TypeAnnotation?
  private static boolean InflightClosureExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InflightClosureExpression_2")) return false;
    TypeAnnotation(b, l + 1);
    return true;
  }

  public static boolean AwaitExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AwaitExpression")) return false;
    if (!nextTokenIsSmart(b, AWAIT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, AWAIT);
    p = r;
    r = p && Expression(b, l, 14);
    exit_section_(b, l, m, AWAIT_EXPRESSION, r, p, null);
    return r || p;
  }

  public static boolean DeferExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DeferExpression")) return false;
    if (!nextTokenIsSmart(b, DEFER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, DEFER);
    p = r;
    r = p && Expression(b, l, 15);
    exit_section_(b, l, m, DEFER_EXPRESSION, r, p, null);
    return r || p;
  }

  // ArrayLiteralExpression
  //     | SetLiteralExpression
  //     | MapLiteralExpression
  public static boolean CollectionLiteralExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CollectionLiteralExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, COLLECTION_LITERAL_EXPRESSION, "<collection literal expression>");
    r = ArrayLiteralExpression(b, l + 1);
    if (!r) r = SetLiteralExpression(b, l + 1);
    if (!r) r = MapLiteralExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  public static boolean ParenthesizedExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParenthesizedExpression")) return false;
    if (!nextTokenIsSmart(b, LEFT_PARENTHESIS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, LEFT_PARENTHESIS);
    p = r;
    r = p && Expression(b, l, 17);
    r = p && report_error_(b, consumeToken(b, RIGHT_PARENTHESIS)) && r;
    exit_section_(b, l, m, PARENTHESIZED_EXPRESSION, r, p, null);
    return r || p;
  }

}
