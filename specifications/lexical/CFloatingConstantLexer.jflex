/**
* Lexer for C99 floating constants (6.4.4.2) generated with JFlex.
* 
* Can be used to determine a floating constants whole part, fractional part,
* exponent and suffixes. It returns a {@link jastaddc.semantics.ast.FloatingConstant}.
* 
* @author C. Bürger
* 
*/

package jastaddc.symbols.lexicalanalyse;

import jastaddc.symbols.lexicalanalyse.CUnknownTokenException;

import jastaddc.semantics.PrimitiveTypes;
import jastaddc.semantics.ast.*;

%% //***************************Options and declarations***************************

//lexer class code
%{
	private int embedded_Line;
	private int embedded_Column;
	
	private StringBuffer lexem;
	private String wholeNumberPart;
	private String fractionalPart;
	private String exponent;
	private NumeralSystemRadix radix;
	private PrimitiveType type;
	
	public void initialize(int embedded_Line, int embedded_Column, java.io.Reader reader) {
		this.embedded_Line = embedded_Line;
		this.embedded_Column = embedded_Column;
		
		lexem = new StringBuffer(128);
		wholeNumberPart = null;
		fractionalPart = null;
		exponent = null;
		radix = null;
		type = null;
		yyreset(reader);
	}
%}

//reader class configuration
%class CFloatingConstantLexer
%public
%final
%init{
	lexem = new StringBuffer(128);
%init}

//scanning method configuration
%unicode
%function createFloatingPointConstant
%type FloatingConstant
%yylexthrow CUnknownTokenException
%eofval{
	if (fractionalPart == null)
		fractionalPart = "";
	if (exponent == null)
		exponent = "";
	if (type == null)
		type = new PrimitiveType(new List(), PrimitiveTypes._double);
	return new FloatingConstant(
			lexem.toString(),
			wholeNumberPart,
			fractionalPart,
			exponent,
			radix,
			type);
%eofval}
%eofclose

//macro declarations
digit = [0-9]
hexadecimalDigit = [0-9]|[A-F]|[a-f]

%state HEXADECIMAL_FLOATING_NUMBER, OPTIONAL_FRACTIONAL_PART_HEXADECIMAL, EXPONENT_BINARY
%state OPTIONAL_FRACTIONAL_PART_DECIMAL, EXPONENT_DECIMAL, OPTIONAL_EXPONENT_DECIMAL
%state OPTIONAL_SUFFIX
%state DONE

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
* 
* The standard for floating point numbers (6.4.4.2) has a few possible pitfalls :
*  - if a decimal floating point number has no . (thus also has no fractional part),
*    the exponent must be there
*  - hexadecimal floating point numbers must always have a binary exponent
*  - decimal floating point number's exponent must be decimal, if they have any at
*    all, thus they may have no exponent
*/

<YYINITIAL> {
	("0x"|"0X")(.|\n)				{
										yypushback(1);
										lexem.append(yytext());
										radix = new NumeralSystemHexadecimal();
										yybegin(HEXADECIMAL_FLOATING_NUMBER);
									}
	{digit}+\.						{
										lexem.append(yytext());
										radix = new NumeralSystemDecimal();
										wholeNumberPart = yytext().substring(0, yytext().length() - 1);
										yybegin(OPTIONAL_FRACTIONAL_PART_DECIMAL);
									}
	\.{digit}+						{
										lexem.append(yytext());
										radix = new NumeralSystemDecimal();
										fractionalPart = yytext().substring(1);
										wholeNumberPart = "";
										yybegin(OPTIONAL_EXPONENT_DECIMAL);
									}
	{digit}+(.|\n)					{
										yypushback(1);
										lexem.append(yytext());
										radix = new NumeralSystemDecimal();
										wholeNumberPart = yytext();
										fractionalPart = "";
										yybegin(EXPONENT_DECIMAL);
									}
}

<HEXADECIMAL_FLOATING_NUMBER> {
	{hexadecimalDigit}+\.(.|\n)		{
										yypushback(1);
										lexem.append(yytext());
										wholeNumberPart = yytext().substring(0, yytext().length() - 1);
										yybegin(OPTIONAL_FRACTIONAL_PART_HEXADECIMAL);
									}
	\.{hexadecimalDigit}+(.|\n)		{
										yypushback(1);
										lexem.append(yytext());
										wholeNumberPart = "";
										fractionalPart = yytext().substring(1);
										yybegin(EXPONENT_BINARY);
									}
	{hexadecimalDigit}+(.|\n)		{
										yypushback(1);
										lexem.append(yytext());
										wholeNumberPart = yytext();
										fractionalPart = "";
										yybegin(EXPONENT_BINARY);
									}
}

<OPTIONAL_FRACTIONAL_PART_HEXADECIMAL> {
	{hexadecimalDigit}+(.|\n)		{
										yypushback(1);
										lexem.append(yytext());
										fractionalPart = yytext();
										yybegin(EXPONENT_BINARY);
									}
	.|\n							{
										fractionalPart = "";
										yypushback(1);
										yybegin(EXPONENT_BINARY);
									}
}

<EXPONENT_BINARY> {
	"P+"{digit}+					{
										lexem.append(yytext());
										exponent = yytext().substring(2);
										yybegin(OPTIONAL_SUFFIX);
									}
	"P-"{digit}+					{
										lexem.append(yytext());
										exponent = yytext().substring(1);
										yybegin(OPTIONAL_SUFFIX);
									}
	"P"{digit}+						{
										lexem.append(yytext());
										exponent = yytext().substring(1);
										yybegin(OPTIONAL_SUFFIX);
									}
	"p+"{digit}+					{
										lexem.append(yytext());
										exponent = yytext().substring(2);
										yybegin(OPTIONAL_SUFFIX);
									}
	"p-"{digit}+					{
										lexem.append(yytext());
										exponent = yytext().substring(1);
										yybegin(OPTIONAL_SUFFIX);
									}
	"p"{digit}+						{
										lexem.append(yytext());
										exponent = yytext().substring(1);
										yybegin(OPTIONAL_SUFFIX);
									}
}

<OPTIONAL_FRACTIONAL_PART_DECIMAL> {
	{digit}+						{
										lexem.append(yytext());
										fractionalPart = yytext();
										yybegin(OPTIONAL_EXPONENT_DECIMAL);
									}
	.|\n							{
										yypushback(1);
										fractionalPart = "";
										yybegin(OPTIONAL_EXPONENT_DECIMAL);
									}
}

<OPTIONAL_EXPONENT_DECIMAL> {
	"e+"{digit}+					{
										lexem.append(yytext());
										exponent = yytext().substring(2);
										yybegin(OPTIONAL_SUFFIX);
									}
	"e-"{digit}+					{
										lexem.append(yytext());
										exponent = yytext().substring(1);
										yybegin(OPTIONAL_SUFFIX);
									}
	"e"{digit}+						{
										lexem.append(yytext());
										exponent = yytext().substring(1);
										yybegin(OPTIONAL_SUFFIX);
									}
	"E+"{digit}+					{
										lexem.append(yytext());
										exponent = yytext().substring(2);
										yybegin(OPTIONAL_SUFFIX);
									}
	"E-"{digit}+					{
										lexem.append(yytext());
										exponent = yytext().substring(1);
										yybegin(OPTIONAL_SUFFIX);
									}
	"E"{digit}+						{
										lexem.append(yytext());
										exponent = yytext().substring(1);
										yybegin(OPTIONAL_SUFFIX);
									}
	.|\n							{
										yypushback(1);
										yybegin(OPTIONAL_SUFFIX);
									}
}

<EXPONENT_DECIMAL> {
	"e+"{digit}+					{
										lexem.append(yytext());
										exponent = yytext().substring(2);
										yybegin(OPTIONAL_SUFFIX);
									}
	"e-"{digit}+					{
										lexem.append(yytext());
										exponent = yytext().substring(1);
										yybegin(OPTIONAL_SUFFIX);
									}
	"e"{digit}+						{
										lexem.append(yytext());
										exponent = yytext().substring(1);
										yybegin(OPTIONAL_SUFFIX);
									}
	"E+"{digit}+					{
										lexem.append(yytext());
										exponent = yytext().substring(2);
										yybegin(OPTIONAL_SUFFIX);
									}
	"E-"{digit}+					{
										lexem.append(yytext());
										exponent = yytext().substring(1);
										yybegin(OPTIONAL_SUFFIX);
									}
	"E"{digit}+						{
										lexem.append(yytext());
										exponent = yytext().substring(1);
										yybegin(OPTIONAL_SUFFIX);
									}
}

<OPTIONAL_SUFFIX> {
	"f"|"F"							{
										lexem.append(yytext());
										type = new PrimitiveType(new List(), PrimitiveTypes._float);
										yybegin(DONE);
									}
	"l"|"L"							{
										lexem.append(yytext());
										type = new PrimitiveType(new List(), PrimitiveTypes._long_double);
										yybegin(DONE);
									}
	.|\n							{
										yypushback(1);
										yybegin(DONE);
									}
}

<DONE> {
	.|\n							{
										throw new CUnknownTokenException(embedded_Line,
											embedded_Column,
											lexem.toString(),
											"No valid floating constant lexem at ("+ embedded_Line +";"+ embedded_Column +").");
									}
}

.|\n						{
								throw new CUnknownTokenException(embedded_Line,
									embedded_Column,
									lexem.toString(),
									"No valid floating constant lexem at ("+ embedded_Line +";"+ embedded_Column +").");
							}
