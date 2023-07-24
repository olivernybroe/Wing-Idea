package com.github.olivernybroe.wingidea.lang.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.olivernybroe.wingidea.lang.psi.WingElementTypes.*;

%%

%{
  public _WingLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _WingLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

BOOL=true|false
INTEGER=0|[1-9][0-9]*
DECIMAL=0\.[0-9]+|[1-9][0-9]*\.[0-9]+
COMMENT="//".*
MULTI_LINE_COMMENT="/"\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+"/"
STRING_LITERAL=\"([^\\\"\r\n]|\\[^\r\n])*\"?
IDENTIFIER=[A-Za-z_$][A-Za-z_$0-9]*|[A-Z][A-Z0-9_]*
WHITE_SPACE=[ \t\n\x0B\f\r]+

%%
<YYINITIAL> {
  {WHITE_SPACE}             { return WHITE_SPACE; }

  "inflight"                { return INFLIGHT_SPECIFIER; }
  "static"                  { return STATIC; }
  "nil"                     { return NIL; }
  "bring"                   { return BRING; }
  "test"                    { return TEST; }
  "+"                       { return ADDITION; }
  "-"                       { return SUBTRACTION; }
  "*"                       { return MULTIPLY; }
  "/"                       { return DIVIDE; }
  "%"                       { return MODULO; }
  "\\"                      { return FLOOR_DIVIDE; }
  "**"                      { return POWER; }
  "&&"                      { return AND; }
  "||"                      { return OR; }
  "!"                       { return NOT; }
  "="                       { return ASSIGNMENT; }
  "=="                      { return EQUAL; }
  "!="                      { return NOT_EQUAL; }
  "<"                       { return LESS_THAN; }
  "<="                      { return LESS_THAN_OR_EQUAL; }
  ">"                       { return GREATER_THAN; }
  ">="                      { return GREATER_THAN_OR_EQUAL; }
  "??"                      { return UNWRAP_OR; }
  "as"                      { return ALIAS; }
  "new"                     { return NEW; }
  "let"                     { return LET; }
  "var"                     { return VAR; }
  "for"                     { return FOR; }
  "in"                      { return IN; }
  "if"                      { return IF; }
  "else"                    { return ELSE; }
  "elif"                    { return ELIF; }
  "while"                   { return WHILE; }
  "class"                   { return CLASS; }
  "enum"                    { return ENUM; }
  "extends"                 { return EXTENDS; }
  "impl"                    { return IMPLEMENTS; }
  "interface"               { return INTERFACE; }
  "async"                   { return ASYNC; }
  "struct"                  { return STRUCT; }
  "try"                     { return TRY; }
  "catch"                   { return CATCH; }
  "finally"                 { return FINALLY; }
  "{"                       { return LEFT_CURLY_BRACE; }
  "}"                       { return RIGHT_CURLY_BRACE; }
  "["                       { return LEFT_SQUARE_BRACE; }
  "]"                       { return RIGHT_SQUARE_BRACE; }
  "("                       { return LEFT_PARENTHESIS; }
  ")"                       { return RIGHT_PARENTHESIS; }
  "break"                   { return BREAK; }
  "continue"                { return CONTINUE; }
  "return"                  { return RETURN; }
  "."                       { return DOT; }
  ","                       { return COMMA; }
  ";"                       { return SEMICOLON; }
  ":"                       { return COLON; }
  "=>"                      { return ARROW; }
  "super"                   { return SUPER; }
  "?"                       { return QUESTION_MARK; }
  "await"                   { return AWAIT; }
  "defer"                   { return DEFER; }

  {BOOL}                    { return BOOL; }
  {INTEGER}                 { return INTEGER; }
  {DECIMAL}                 { return DECIMAL; }
  {COMMENT}                 { return COMMENT; }
  {MULTI_LINE_COMMENT}      { return MULTI_LINE_COMMENT; }
  {STRING_LITERAL}          { return STRING_LITERAL; }
  {IDENTIFIER}              { return IDENTIFIER; }
  {WHITE_SPACE}             { return WHITE_SPACE; }

}

[^] { return BAD_CHARACTER; }
