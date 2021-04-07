package com.cesar31.imggenerator.parser;

import static com.cesar31.imggenerator.parser.ImageParserSym.*;
import java_cup.runtime.*;

%%

%class ImageLex
%type java_cup.runtime.Symbol
%public
%unicode
%cup
%line
%column
//%cupdebug

%{
	private Symbol symbol(int type) {
		return new Symbol(type, yyline + 1, yycolumn + 1);
	}

	private Symbol symbol(int type, Object value) {
		return new Symbol(type, yyline + 1, yycolumn + 1, value);
	}
%}

%eofval{
	return new java_cup.runtime.Symbol(ImageParserSym.EOF);
%eofval}
%eofclose

Integer = 0|[1-9][0-9]*

LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator}|[ \t\f]

UserName = \w+

HexColor = #?([0-9a-fA-F]{3,3}|[0-9a-fA-F]{6,6})

%%

<YYINITIAL> {

	{Integer}
	{ return symbol(INTEGER, Integer.valueOf(yytext())); }

	{UserName}
	{ return symbol(USER_NAME, String.valueOf(yytext())); }

	{HexColor}
	{ return symbol(COLOR, String.valueOf(yytext())); }

	":"
	{ return symbol(COLON); }

	","
	{ return symbol(COMMA); }

	";"
	{ return symbol(SEMI_COLON); }

	"}"
	{ return symbol(RBRACE); }

	"{"
	{ return symbol(LBRACE); }

	{WhiteSpace}
	{/* Ignore */}

}

[^]
{
	return symbol(ERROR, yytext());
	// throw new Error("Ilegal character: <" + yytext() + ">");
}
