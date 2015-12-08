/*
	This program and the accompanying materials are made available under the
	terms of the MIT license (X11 license) which accompanies this distribution.
	
	Author: Christoff Bürger
*/

/**
 * Lexer for C99 integer constants (6.4.4.1) generated with JFlex.
 * 
 * Can be used to determine an integer constants suffixes and its base.
 * It returns a {@link jastaddc.semantics.ast.IntegerConstant}.
 */

package jastaddc.symbols;

import jastaddc.semantics.*;

%% //***************************Options and declarations***************************

//lexer class code
%{
	private int embedded_Line;
	private int embedded_Column;
	
	private StringBuffer lexem;
	private String numericValue;
	private NumeralSystemRadix radix;
	private PrimitiveType type;
	
	public void initialize(int embedded_Line, int embedded_Column, java.io.Reader reader) {
		this.embedded_Line = embedded_Line;
		this.embedded_Column = embedded_Column;
		
		lexem = new StringBuffer(128);
		numericValue = null;
		radix = null;
		type = null;
		yyreset(reader);
	}
%}

//reader class configuration
%class CIntegerConstantLexer
%public
%final
%init{
	lexem = new StringBuffer(128);
%init}

//scanning method configuration
%unicode
%function createIntegerConstant
%type IntegerConstant
%yylexthrow CUnknownTokenException
%eofval{
	if (type == null)
		type = new PrimitiveType(new List(), PrimitiveTypes._signed_int);
	return new IntegerConstant(lexem.toString(), numericValue, radix, type);
%eofval}
%eofclose

//macro declarations
digit = [0-9]
noZeroDigit = [1-9]
octalDigit = [0-7]
hexadecimalDigit = [0-9]|[A-F]|[a-f]

%state HEX_VALUE, OPTIONAL_OCTAL_VALUE, SUFFIX, DONE

%% //***************************Lexical rules***************************

/**
* States starting with OPTIONAL_ may be skipped, thus they have an alternative rule
* .|\n accepting every input sign, which they push back into the input and instead do
* a state transition to the next lexer state.
*
* If input signs are successful matched in a state and the input is empty afterwards,
* the complete lexing has been successful. To force, that additional input signs have
* to follow successful matched input signs, rules with REGULEXPRESSION(.|\n) and
* yypushback(1); can be used. These rules only match, if additional input follows
* REGULEXPRESSION.
*/

<YYINITIAL> {
	("0x"(.|\n))|("0X"(.|\n))	{
									yypushback(1);
									lexem.append(yytext());
									radix = new NumeralSystemHexadecimal();
									yybegin(HEX_VALUE);
								}
	"0"(.|\n)					{
									yypushback(1);
									lexem.append(yytext());
									radix = new NumeralSystemOctal();
									yybegin(OPTIONAL_OCTAL_VALUE);
								}
	"0"							{
									lexem.append(yytext());
									radix = new NumeralSystemOctal(); /*integer constant 0 is octal (6.4.4;3)*/
									numericValue = "0";
									yybegin(DONE);
								}
	{noZeroDigit}{digit}*		{
									lexem.append(yytext());
									radix = new NumeralSystemDecimal();
									numericValue = yytext();
									yybegin(SUFFIX);
								}
}

<HEX_VALUE> {
	{hexadecimalDigit}+			{
									lexem.append(yytext());
									numericValue = yytext();
									yybegin(SUFFIX);
								}
}

<OPTIONAL_OCTAL_VALUE> {
	{octalDigit}+				{
									lexem.append(yytext());
									numericValue = yytext();
									yybegin(SUFFIX);
								}
	.|\n						{
									yypushback(1);
									numericValue = "0";
									yybegin(SUFFIX);
								}
}

<SUFFIX> {
	"LLu"|"llu"|"LLU"|"llU"|
	"uLL"|"ull"|"ULL"|"Ull"		{
									lexem.append(yytext());
									type = new PrimitiveType(new List(), PrimitiveTypes._unsigned_long_long_int);
									yybegin(DONE);
								}
	"Lu"|"lu"|"LU"|"lU"|
	"uL"|"ul"|"UL"|"Ul"			{
									lexem.append(yytext());
									type = new PrimitiveType(new List(), PrimitiveTypes._unsigned_long_int);
									yybegin(DONE);
								}
	"LL"|"ll"					{
									lexem.append(yytext());
									type = new PrimitiveType(new List(), PrimitiveTypes._signed_long_long_int);
									yybegin(DONE);
								}
	"L"|"l"						{
									lexem.append(yytext());
									type = new PrimitiveType(new List(), PrimitiveTypes._signed_long_int);
									yybegin(DONE);
								}
	"U"|"u"						{
									lexem.append(yytext());
									type = new PrimitiveType(new List(), PrimitiveTypes._unsigned_int);
									yybegin(DONE);
								}
}

<DONE> {
	.|\n						{
									throw new CUnknownTokenException(embedded_Line,
										embedded_Column,
										lexem.toString(),
										"No valid integer constant lexem at ("+ embedded_Line +";"+ embedded_Column +").");
								}
}

.|\n						{
								throw new CUnknownTokenException(embedded_Line,
									embedded_Column,
									lexem.toString(),
									"No valid integer constant lexem at ("+ embedded_Line +";"+ embedded_Column +").");
							}
