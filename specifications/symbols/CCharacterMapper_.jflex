/*
	This program and the accompanying materials are made available under the
	terms of the MIT license (X11 license) which accompanies this distribution.
	
	Author: Christoff Bürger
*/

/**
 * Source character set mapper for C99 generated with JFlex.
 * The mapper is used for a C front end developed with JastAdd.
 * 
 * The mapper realizes translation phase 5 :
 *  - each source character set member and escape sequence in character
 *    constants and string literals is converted to the corresponding member
 *    of the execution character set
 * 
 * To do so, the mapper accepts arbitrary Strings as input and transforms these
 * to Strings representing the execution character set as output. So the mapper
 * has to be invoken for every String to transform and expects, that the caller
 * knows which Strings to transform.
 * 
 * This class has to be treated like an inner class of the
 * {@link lexer.CCharacterMapper CCharacterMapper}-class and is used by it.
 * 
 * TODO : A much better solution would be the following, which can't be done as
 * unfortunately JFlex doesn't allow to have an arbitrary type of objects as
 * input stream. Otherwise we could use token symbols as input and create token
 * symbols as output again. This way the mapper could be just another lexer in the
 * chain of C99 translation phases and it has not to be called for every String to
 * transform. Instead it could use a basic lexer to recognize the lexems (the
 * mappers input) and transform these if they are string literals or character
 * constants.
 */

package jastaddc.symbols;

%% //***************************Options and declarations***************************

//reader class code
%{
	private StringBuffer lexem;
	
	public void initialize(java.io.Reader reader) {
		lexem = new StringBuffer(256);
		
		yyreset(reader);
	}
%}

//reader class configuration
%class CCharacterMapper_
%public
%final
%init{
	initialize(in);
%init}

//scanning method configuration
%unicode
%function transformSourceString
%type String
%yylexthrow CUnknownTokenException
%eofval{
	return lexem.toString();
%eofval}
%eofclose

//macro declarations
OctalDigit = [0-7]
HexadecimalDigit = [0-9]|[A-F]|[a-f]

%% //***************************Lexical rules***************************

/* escape sequences */
"\\'"						{lexem.append('\'');}
"\\\""						{lexem.append('\"');}
"\\?"						{lexem.append('\u003F');} /* unicode question mark ? */
"\\\\"						{lexem.append('\\');}
"\\a"						{lexem.append('\u0007');} /* unicode bell \a */
"\\b"						{lexem.append('\b');}
"\\f"						{lexem.append('\f');}
"\\n"						{lexem.append('\n');}
"\\r"						{lexem.append('\r');}
"\\t"						{lexem.append('\t');}
"\\v"						{lexem.append('\u000B');} /* unicode vertical tab \v */

"\\"({OctalDigit}|{OctalDigit}{OctalDigit}|{OctalDigit}{OctalDigit}{OctalDigit})	{
			try {
				lexem.append(Character.toChars(Integer.parseInt(yytext().substring(1), 8)));
			} catch (java.lang.IllegalArgumentException exception) {
				throw new CUnknownTokenException(yyline,
					yycolumn,
					lexem.toString(),
					"No valid octal escape sequence : "+ yytext());
			}
}

"\\x"{HexadecimalDigit}+	{
			try {
				lexem.append(Character.toChars(Integer.parseInt(yytext().substring(2), 16)));
			} catch (java.lang.IllegalArgumentException exception) {
				throw new CUnknownTokenException(yyline,
					yycolumn,
					lexem.toString(),
					"No valid hexadecimal escape sequence : "+ yytext());
			}
}

"\\u"{HexadecimalDigit}{HexadecimalDigit}{HexadecimalDigit}{HexadecimalDigit}	{
			try {
				lexem.append(Character.toChars(Integer.parseInt(yytext().substring(2), 16)));
			} catch (java.lang.IllegalArgumentException exception) {
				throw new CUnknownTokenException(yyline,
					yycolumn,
					lexem.toString(),
					"No valid unicode escape sequence : "+ yytext());
			}
}

"\\U"{HexadecimalDigit}{HexadecimalDigit}{HexadecimalDigit}{HexadecimalDigit}{HexadecimalDigit}{HexadecimalDigit}{HexadecimalDigit}{HexadecimalDigit}	{
			try {
				lexem.append(Character.toChars(Integer.parseInt(yytext().substring(2), 16)));
			} catch (java.lang.IllegalArgumentException exception) {
				throw new CUnknownTokenException(yyline,
					yycolumn,
					lexem.toString(),
					"No valid unicode escape sequence : "+ yytext());
			}
}

/* all other signs are just their corresponding unicode sign,
   except we don't allow an escape sign (\) to occur */
[^\\]						{lexem.append(yytext());}

.|\n			{
					throw new CUnknownTokenException(yyline,
							yycolumn,
							yytext(),
							"Unknown source character set member or escape sequence ["+
							yytext() +
							"] in character constant or string literal");
				}
