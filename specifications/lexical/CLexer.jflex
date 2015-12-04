/**
 * Lexer for C99 generated with JFlex. The lexer is used for a C
 * front-end developed with JastAdd.
 * 
 * The lexer expects, that translation phases 1 and 2 are done.
 * 
 * It realizes :
 *  - transformation of comments to whitespace, by ignoring them
 *    (part of translation phase 3)
 *  - lexical parts of translation phase 7: ignoring whitespace
 *    (discarding them) and the recognition and creation of token
 * 
 * The lexer does not analyse or execute preprocessing directives :
 *  - translation phase 4 is not executed
 * 
 * Translation phase 5 is not executed and has to be done :
 *  - the translation of source character set members and
 *    escape sequences in constants and string literals to members
 *    of the execution character set
 * Translation phase 6 is not executed and has to be done :
 *  - concatenation of adjacent string literals
 * 
 * The lexer specification is based on the Lex specification by Jeff
 * Lee (1985), which is the base for his grammar specification. Jeff
 * Lee's grammar specification is the base for the C99 grammar
 * (further developed since it's first release in 1985 by the
 * standard committee.). The lexer specification this one is based
 * on can be found at http://www.quut.com/c/ANSI-C-grammar-l-1998.html.
 * 
 * @author C. Bürger
 * 
 */

package jastaddc.symbols.lexicalanalyse;

import java.io.Reader;
import java.io.StringReader;

import beaver.Symbol;

import jastaddc.symbols.lexicalanalyse.CIntegerConstantLexer;
import jastaddc.symbols.lexicalanalyse.CFloatingConstantLexer;

import jastaddc.syntax.syntacticalanalyse.CParser.Terminals;

import jastaddc.semantics.ast.CharacterConstant;
import jastaddc.semantics.ast.StringLiteral;
import jastaddc.semantics.ast.Identifier;

%% //***************************Options and declarations***************************

%line
%column

//lexer class code
%{
	private CIntegerConstantLexer integerLexer;
	private CFloatingConstantLexer floatLexer;
	
	private Symbol createPrimitiveToken(short id) {
		return new Symbol(id, yyline, yycolumn, yylength(), yytext());
	}

	private Symbol createPrimitiveToken(short id, Object value) {
		return new Symbol(id, yyline, yycolumn, yylength(), value);
	}
%}

//lexer class configuration
%class CLexer
%extends beaver.Scanner
%public
%final
%init{
	integerLexer = new CIntegerConstantLexer((Reader)null);
	floatLexer = new CFloatingConstantLexer((Reader)null);
%init}

//scanning method configuration
%unicode
%function nextToken
%type Symbol
%yylexthrow CUnknownTokenException
%eofval{
	/* Beware : The lexer has always to be in the initial state
	   when the end of the input stream is reached, as all non
	   initial states suggest, that some special (complicated)
	   token is scanned/constructed at the moment and it's
	   construction isn't finished yet.*/
	if (yystate() != YYINITIAL)
		throw new CUnknownTokenException(yyline,
			yycolumn,
			null,
			"Lexer error: Lexer is not in initial state (current lexer state : "+
			yystate() +
			"), but input stream doesn't contain further signs (EOF reached).");
	
	return createPrimitiveToken(Terminals.EOF, "end-of-file");
%eofval}
%eofclose

//macro declarations
// Line termination for full unicode support:
// (\n == \u000A) (\r == \u000D) (\r\n == \u000D\\u000A)
LineTerminator = \r|\n|\r\n|\u2028|\u2029|\u000B|\u000C|\u0085
InputCharacter = [^\r\n]
// in unicode \u000B is the vertical tabulator \v
WhiteSpace = {LineTerminator} | [ \t\f\u000B]

Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment = "/*" ~"*/"
EndOfLineComment = "//" {InputCharacter}*

LatinLetter = [a-z]|[A-Z]
NonNullDecimalDigit = [1-9]
DecimalDigit = [0-9]
OctalDigit = [0-7]
HexadecimalDigit = [0-9]|[A-F]|[a-f]

StringCharacter = [^\r|\n|\r\n|\u2028|\u2029|\u000B|\u000C|\u0085\"]
SingleCharacter = [^\r|\n|\r\n|\u2028|\u2029|\u000B|\u000C|\u0085\']

DecimalExponent = ("e"|"E")("+"|"-")?{DecimalDigit}+
BinaryExponent = ("p"|"P")("+"|"-")?{DecimalDigit}+
FloatingConstantSuffix = "f"|"F"|"l"|"L"
IntegerConstantSuffix = (("u"|"U")("ll"|"LL")) 	|
						(("ll"|"LL")("u"|"U")) 	|
						(("u"|"U")("l"|"L")) 	|
						(("l"|"L")("u"|"U")) 	|
						("u"|"U") 				|
						("ll"|"LL") 			|
						("l"|"L")

Identifier = ({LatinLetter} | "_")({LatinLetter} | "_" | {DecimalDigit})*

%% //***************************Lexical rules***************************

<YYINITIAL> {
	{Comment}		{}
	
	/* keywords */
	
	"auto"			{return createPrimitiveToken(Terminals.kAUTO);}
	"break"			{return createPrimitiveToken(Terminals.kBREAK);}
	"case"			{return createPrimitiveToken(Terminals.kCASE);}
	"char"			{return createPrimitiveToken(Terminals.kCHAR);}
	"const"			{return createPrimitiveToken(Terminals.kCONST);}
	"continue"		{return createPrimitiveToken(Terminals.kCONTINUE);}
	"default"		{return createPrimitiveToken(Terminals.kDEFAULT);}
	"do"			{return createPrimitiveToken(Terminals.kDO);}
	"double"		{return createPrimitiveToken(Terminals.kDOUBLE);}
	"else"			{return createPrimitiveToken(Terminals.kELSE);}
	"enum"			{return createPrimitiveToken(Terminals.kENUM);}
	"extern"		{return createPrimitiveToken(Terminals.kEXTERN);}
	"float"			{return createPrimitiveToken(Terminals.kFLOAT);}
	"for"			{return createPrimitiveToken(Terminals.kFOR);}
	"goto"			{return createPrimitiveToken(Terminals.kGOTO);}
	"if"			{return createPrimitiveToken(Terminals.kIF);}
	"inline"		{return createPrimitiveToken(Terminals.kINLINE);}
	"int"			{return createPrimitiveToken(Terminals.kINT);}
	"long"			{return createPrimitiveToken(Terminals.kLONG);}
	"register"		{return createPrimitiveToken(Terminals.kREGISTER);}
	"restrict"		{return createPrimitiveToken(Terminals.kRESTRICT);}
	"return"		{return createPrimitiveToken(Terminals.kRETURN);}
	"short"			{return createPrimitiveToken(Terminals.kSHORT);}
	"signed"		{return createPrimitiveToken(Terminals.kSIGNED);}
	"sizeof"		{return createPrimitiveToken(Terminals.kSIZEOF);}
	"static"		{return createPrimitiveToken(Terminals.kSTATIC);}
	"struct"		{return createPrimitiveToken(Terminals.kSTRUCT);}
	"switch"		{return createPrimitiveToken(Terminals.kSWITCH);}
	"typedef"		{return createPrimitiveToken(Terminals.kTYPEDEF);}
	"union"			{return createPrimitiveToken(Terminals.kUNION);}
	"unsigned"		{return createPrimitiveToken(Terminals.kUNSIGNED);}
	"void"			{return createPrimitiveToken(Terminals.kVOID);}
	"volatile"		{return createPrimitiveToken(Terminals.kVOLATILE);}
	"while"			{return createPrimitiveToken(Terminals.kWHILE);}
	
	/* integer constants */
	
	"0"("x"|"X"){HexadecimalDigit}+{IntegerConstantSuffix}? 										|
	"0"{OctalDigit}*{IntegerConstantSuffix}? 														|
	{NonNullDecimalDigit}{DecimalDigit}*{IntegerConstantSuffix}?									{
						integerLexer.initialize(yyline, yycolumn, new StringReader(yytext()));
						return createPrimitiveToken(
								Terminals.CONSTANT, integerLexer.createIntegerConstant());
					}
	
	/* floating point constants */
	
	{DecimalDigit}+{DecimalExponent}{FloatingConstantSuffix}? 										|
	{DecimalDigit}*"."{DecimalDigit}+{DecimalExponent}?{FloatingConstantSuffix}? 					|
	{DecimalDigit}+"."{DecimalDigit}*{DecimalExponent}?{FloatingConstantSuffix}? 					|
	"0"("x"|"X"){HexadecimalDigit}+{BinaryExponent}{FloatingConstantSuffix}? 						|
	"0"("x"|"X"){HexadecimalDigit}+"."{HexadecimalDigit}*{BinaryExponent}{FloatingConstantSuffix}? 	|
	"0"("x"|"X"){HexadecimalDigit}*"."{HexadecimalDigit}+{BinaryExponent}{FloatingConstantSuffix}?	{
						floatLexer.initialize(yyline, yycolumn, new StringReader(yytext()));
						return createPrimitiveToken(
								Terminals.CONSTANT, floatLexer.createFloatingPointConstant());
					}
	
	/* character constants */
	
	"L'"({SingleCharacter}|"\\'")*"'"		{
						return createPrimitiveToken(
								Terminals.CONSTANT,
								new CharacterConstant(
										yytext(),
										yytext().substring(2, yytext().length() - 1),
										true));
					}
	"'"({SingleCharacter}|"\\'")*"'"		{
						return createPrimitiveToken(
								Terminals.CONSTANT,
								new CharacterConstant(
										yytext(),
										yytext().substring(1, yytext().length() - 1),
										false));
					}
	
	/* string literal constants */
	
	"L\""({StringCharacter}|"\\\"")*"\""	{
						return createPrimitiveToken(
								Terminals.STRING_LITERAL,
								new StringLiteral(
										yytext(),
										yytext().substring(2, yytext().length() - 1),
										true));
					}
	"\""({StringCharacter}|"\\\"")*"\""		{
						return createPrimitiveToken(
								Terminals.STRING_LITERAL,
								new StringLiteral(
										yytext(),
										yytext().substring(1, yytext().length() - 1),
										false));
					}
	
	/* identifier */
	
	{Identifier}	{
						return createPrimitiveToken(
								Terminals.IDENTIFIER,
								new Identifier(yytext()));
					}
	
	/* typedef name */
	
	"$"{Identifier}	{
						return createPrimitiveToken(
								Terminals.TYPEDEF_NAME,
								new Identifier(yytext().substring(1)));
					}
	
	/* punctuators */
	
	("["|"<:")		{return createPrimitiveToken(Terminals.pBRACKETOPENSQUARE);}
	("]"|":>")		{return createPrimitiveToken(Terminals.pBRACKETCLOSESQUARE);}
	"("				{return createPrimitiveToken(Terminals.pBRACKETOPENROUND);}
	")"				{return createPrimitiveToken(Terminals.pBRACKETCLOSEROUND);}
	("{"|"<%")		{return createPrimitiveToken(Terminals.pBRACKETOPENCURLY);}
	("}"|"%>")		{return createPrimitiveToken(Terminals.pBRACKETCLOSECURLY);}
	"."				{return createPrimitiveToken(Terminals.pPOINT);}
	"->"			{return createPrimitiveToken(Terminals.pMINUS_GREATER);}
	
	"++"			{return createPrimitiveToken(Terminals.pPLUS_PLUS);}
	"--"			{return createPrimitiveToken(Terminals.pMINUS_MINUS);}
	"&"				{return createPrimitiveToken(Terminals.pAND);}
	"*"				{return createPrimitiveToken(Terminals.pSTAR);}
	"+"				{return createPrimitiveToken(Terminals.pPLUS);}
	"-"				{return createPrimitiveToken(Terminals.pMINUS);}
	"~"				{return createPrimitiveToken(Terminals.pTILDE);}
	"!"				{return createPrimitiveToken(Terminals.pEXCLAMATIONMARK);}
	
	"/"				{return createPrimitiveToken(Terminals.pSLASH);}
	"%"				{return createPrimitiveToken(Terminals.pPRECENT);}
	"<<"			{return createPrimitiveToken(Terminals.pLESSER_LESSER);}
	">>"			{return createPrimitiveToken(Terminals.pGREATER_GREATER);}
	"<"				{return createPrimitiveToken(Terminals.pLESSER);}
	">"				{return createPrimitiveToken(Terminals.pGREATER);}
	"<="			{return createPrimitiveToken(Terminals.pLESSER_EQUALS);}
	">="			{return createPrimitiveToken(Terminals.pGREATER_EQUALS);}
	"=="			{return createPrimitiveToken(Terminals.pEQUALS_EQUALS);}
	"!="			{return createPrimitiveToken(Terminals.pEXCLAMATIONMARK_EQUALS);}
	"^"				{return createPrimitiveToken(Terminals.pARROWUP);}
	"|"				{return createPrimitiveToken(Terminals.pLINEVERTICAL);}
	"&&"			{return createPrimitiveToken(Terminals.pAND_AND);}
	"||"			{return createPrimitiveToken(Terminals.pLINEVERTICAL_LINEVERTICAL);}
	
	"?"				{return createPrimitiveToken(Terminals.pQUESTIONMARK);}
	":"				{return createPrimitiveToken(Terminals.pCOLON);}
	";"				{return createPrimitiveToken(Terminals.pSEMICOLON);}
	"..."			{return createPrimitiveToken(Terminals.pPOINT_POINT_POINT);}
	
	"="				{return createPrimitiveToken(Terminals.pEQUALS);}
	"*="			{return createPrimitiveToken(Terminals.pSTAR_EQUALS);}
	"/="			{return createPrimitiveToken(Terminals.pSLASH_EQUALS);}
	"%="			{return createPrimitiveToken(Terminals.pPRECENT_EQUALS);}
	"+="			{return createPrimitiveToken(Terminals.pPLUS_EQUALS);}
	"-="			{return createPrimitiveToken(Terminals.pMINUS_EQUALS);}
	"<<="			{return createPrimitiveToken(Terminals.pLESSER_LESSER_EQUALS);}
	">>="			{return createPrimitiveToken(Terminals.pGREATER_GREATER_EQUALS);}
	"&="			{return createPrimitiveToken(Terminals.pAND_EQUALS);}
	"^="			{return createPrimitiveToken(Terminals.pARROWUP_EQUALS);}
	"|="			{return createPrimitiveToken(Terminals.pLINEVERTICAL_EQUALS);}
	
	","				{return createPrimitiveToken(Terminals.pCOMMA);}
	
	{WhiteSpace}	{/* Ignore whitespace */}
}

.|\n			{
					throw new CUnknownTokenException(yyline,
							yycolumn,
							yytext());
				}
