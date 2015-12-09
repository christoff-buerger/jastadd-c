/*
	This program and the accompanying materials are made available under the
	terms of the MIT license (X11 license) which accompanies this distribution.
	
	Author: Christoff Bürger
*/

/**
 * Lexer generated with jflex. This lexer is used to recognize the primitive C99 types:
 *  - void
 *  - char
 *  - _Bool 
 *  - signed char
 *  - signed short int
 *  - signed int
 *  - signed long int
 *  - signed long long int
 *  - unsigned char
 *  - unsigned short int
 *  - unsigned int
 *  - unsigned long int
 *  - unsigned long long int
 *  - float
 *  - double
 *  - long double
 *  - float _Complex
 *  - double _Complex
 *  - long double _Complex
 * from a stream formed of the basic input types:
 *  - void
 *  - char
 *  - int
 *  - long
 *  - float
 *  - unsigned
 *  - signed
 *  - double
 *  - Bool
 *  - _Complex
 * The result is an enumeration constant of type jastaddc.semantics.PrimitiveTypes
 * if the input describes a valid basic type. Otherwise an jastaddc.SourceError
 * is thrown.
 * 
 * IMPORTANT: This lexer is used after parsing a C program to support the
 * construction of an AST from the concrete grammar. In the final AST a primitive type
 * is represented by one node with one terminal of type jastaddc.semantics.PrimitiveTypes.
 * 
 * This lexer is needed, as the C99 grammar ([A.2] S.409) allows the construction
 * of invalid basic types.
 */

package jastaddc.semantics;

import jastaddc.SourceError;

import jastaddc.semantics.PrimitiveTypes;

%% //***************************Options and declarations***************************

//lexer class code
%{
%}

//lexer class configuration
%class PrimitiveTypesLexer
%public
%final
%init{
%init}

//scanning method configuration
%unicode
%function createBasicType
%type PrimitiveTypes
%yylexthrow SourceError
%eofval{
	/* Beware : The lexer has always to be in the initial state
	   when the end of the input stream is reached, as all non initial
	   states suggest, that some special (complicated) token is scanned/
	   constructed at the moment and it's construction isn't finished yet.*/
	if (yystate() != YYINITIAL)
		throw new SourceError(
			"Invalid basic type ["+ yytext() +
			"]. The ["+ this.getClass().getName() +"] is in state ["+
			yystate() +"] and not it's initial state after finishing lexing the type given.");
	return null;
%eofval}
%eofclose

//macro declarations
/* Line termination for full unicode support; (\n == \u000A) (\r == \u000D) (\r\n == \u000D\\u000A) */
LineTerminator = \r|\n|\r\n|\u2028|\u2029|\u000B|\u000C|\u0085
InputCharacter = [^\r\n]
WhiteSpace = {LineTerminator} | [ \t\f\u000B] /* in unicode \u000B is the vertical tabulator \v */

%% //***************************Lexical rules***************************

<YYINITIAL> {
	{WhiteSpace}+
		{}
	
	"void"
		{
			return PrimitiveTypes._void;
		}
	
	("signed"{WhiteSpace}+"char")|("char"{WhiteSpace}+"signed")|
	"char"
		{
			return PrimitiveTypes._signed_char;
		}
	
	("unsigned"{WhiteSpace}+"char")|("char"{WhiteSpace}+"unsigned")
		{
			return PrimitiveTypes._unsigned_char;
		}
	
	"_Bool"
		{
			return PrimitiveTypes.__Bool;
		}
	
	("signed"{WhiteSpace}+"short"{WhiteSpace}+"int")|
	("signed"{WhiteSpace}+"int"{WhiteSpace}+"short")|
	("short"{WhiteSpace}+"signed"{WhiteSpace}+"int")|
	("short"{WhiteSpace}+"int"{WhiteSpace}+"signed")|
	("int"{WhiteSpace}+"signed"{WhiteSpace}+"short")|
	("int"{WhiteSpace}+"short"{WhiteSpace}+"signed")|
	("short")|
	("signed"{WhiteSpace}+"short")|("short"{WhiteSpace}+"signed")|
	("short"{WhiteSpace}+"int")|("int"{WhiteSpace}+"short")
		{
			return PrimitiveTypes._signed_short_int;
		}
	
	("signed"{WhiteSpace}+"int")|("int"{WhiteSpace}+"signed")|
	"int"|
	"signed"
		{
			return PrimitiveTypes._signed_int;
		}
	
	("signed"{WhiteSpace}+"long"{WhiteSpace}+"int")|
	("signed"{WhiteSpace}+"int"{WhiteSpace}+"long")|
	("long"{WhiteSpace}+"signed"{WhiteSpace}+"int")|
	("long"{WhiteSpace}+"int"{WhiteSpace}+"signed")|
	("int"{WhiteSpace}+"long"{WhiteSpace}+"signed")|
	("int"{WhiteSpace}+"signed"{WhiteSpace}+"long")|
	"long"|
	("signed"{WhiteSpace}+"long")|("long"{WhiteSpace}+"signed")|
	("long"{WhiteSpace}+"int")|("int"{WhiteSpace}+"long")
		{
			return PrimitiveTypes._signed_long_int;
		}
	
	("signed"{WhiteSpace}+"long"{WhiteSpace}+"long"{WhiteSpace}+"int")|
	("signed"{WhiteSpace}+"long"{WhiteSpace}+"int"{WhiteSpace}+"long")|
	("signed"{WhiteSpace}+"int"{WhiteSpace}+"long"{WhiteSpace}+"long")|
	("long"{WhiteSpace}+"signed"{WhiteSpace}+"long"{WhiteSpace}+"int")|
	("long"{WhiteSpace}+"signed"{WhiteSpace}+"int"{WhiteSpace}+"long")|
	("long"{WhiteSpace}+"long"{WhiteSpace}+"signed"{WhiteSpace}+"int")|
	("long"{WhiteSpace}+"int"{WhiteSpace}+"signed"{WhiteSpace}+"long")|
	("long"{WhiteSpace}+"long"{WhiteSpace}+"int"{WhiteSpace}+"signed")|
	("long"{WhiteSpace}+"int"{WhiteSpace}+"long"{WhiteSpace}+"signed")|
	("int"{WhiteSpace}+"signed"{WhiteSpace}+"long"{WhiteSpace}+"long")|
	("int"{WhiteSpace}+"long"{WhiteSpace}+"signed"{WhiteSpace}+"long")|
	("int"{WhiteSpace}+"long"{WhiteSpace}+"long"{WhiteSpace}+"signed")|
	("long"{WhiteSpace}+"long")|
	("signed"{WhiteSpace}+"long"{WhiteSpace}+"long")|("long"{WhiteSpace}+"signed"{WhiteSpace}+"long")|("long"{WhiteSpace}+"long"{WhiteSpace}+"signed")|
	("long"{WhiteSpace}+"long"{WhiteSpace}+"int")|("long"{WhiteSpace}+"int"{WhiteSpace}+"long")|("int"{WhiteSpace}+"long"{WhiteSpace}+"long")
		{
			return PrimitiveTypes._signed_long_long_int;
		}
	
	("unsigned"{WhiteSpace}+"short"{WhiteSpace}+"int")|
	("unsigned"{WhiteSpace}+"int"{WhiteSpace}+"short")|
	("short"{WhiteSpace}+"unsigned"{WhiteSpace}+"int")|
	("int"{WhiteSpace}+"unsigned"{WhiteSpace}+"short")|
	("short"{WhiteSpace}+"int"{WhiteSpace}+"unsigned")|
	("int"{WhiteSpace}+"short"{WhiteSpace}+"unsigned")|
	("unsigned"{WhiteSpace}+"short")|("short"{WhiteSpace}+"unsigned")
		{
			return PrimitiveTypes._unsigned_short_int;
		}
	
	("unsigned"{WhiteSpace}+"int")|("int"{WhiteSpace}+"unsigned")|
	"unsigned"
		{
			return PrimitiveTypes._unsigned_int;
		}
	
	("unsigned"{WhiteSpace}+"long"{WhiteSpace}+"int")|
	("unsigned"{WhiteSpace}+"int"{WhiteSpace}+"long")|
	("long"{WhiteSpace}+"unsigned"{WhiteSpace}+"int")|
	("int"{WhiteSpace}+"unsigned"{WhiteSpace}+"long")|
	("long"{WhiteSpace}+"int"{WhiteSpace}+"unsigned")|
	("int"{WhiteSpace}+"long"{WhiteSpace}+"unsigned")|
	("unsigned"{WhiteSpace}+"long")|("long"{WhiteSpace}+"unsigned")
		{
			return PrimitiveTypes._unsigned_long_int;
		}
	
	("unsigned"{WhiteSpace}+"long"{WhiteSpace}+"long"{WhiteSpace}+"int")|
	("unsigned"{WhiteSpace}+"long"{WhiteSpace}+"int"{WhiteSpace}+"long")|
	("unsigned"{WhiteSpace}+"int"{WhiteSpace}+"long"{WhiteSpace}+"long")|
	("long"{WhiteSpace}+"unsigned"{WhiteSpace}+"long"{WhiteSpace}+"int")|
	("long"{WhiteSpace}+"unsigned"{WhiteSpace}+"int"{WhiteSpace}+"long")|
	("int"{WhiteSpace}+"unsigned"{WhiteSpace}+"long"{WhiteSpace}+"long")|
	("long"{WhiteSpace}+"long"{WhiteSpace}+"int"{WhiteSpace}+"unsigned")|
	("long"{WhiteSpace}+"int"{WhiteSpace}+"long"{WhiteSpace}+"unsigned")|
	("int"{WhiteSpace}+"long"{WhiteSpace}+"long"{WhiteSpace}+"unsigned")|
	("unsigned"{WhiteSpace}+"long"{WhiteSpace}+"long")|
	("long"{WhiteSpace}+"unsigned"{WhiteSpace}+"long")|
	("long"{WhiteSpace}+"long"{WhiteSpace}+"unsigned")
		{
			return PrimitiveTypes._unsigned_long_long_int;
		}
	
	"float"
		{return PrimitiveTypes._float;}
	
	"double"
		{return PrimitiveTypes._double;}
	
	("long"{WhiteSpace}+"double")|("double"{WhiteSpace}+"long")
		{return PrimitiveTypes._long_double;}
	
	("float"{WhiteSpace}+"_Complex")|("_Complex"{WhiteSpace}+"float")
		{return PrimitiveTypes._float__Complex;}
	
	("double"{WhiteSpace}+"_Complex")|("_Complex"{WhiteSpace}+"double")
		{return PrimitiveTypes._double__Complex;}
	
	("long"{WhiteSpace}+"double"{WhiteSpace}+"_Complex")|
	("long"{WhiteSpace}+"_Complex"{WhiteSpace}+"double")|
	("double"{WhiteSpace}+"long"{WhiteSpace}+"_Complex")|
	("_Complex"{WhiteSpace}+"long"{WhiteSpace}+"double")|
	("double"{WhiteSpace}+"_Complex"{WhiteSpace}+"long")|
	("_Complex"{WhiteSpace}+"double"{WhiteSpace}+"long")
		{
			return PrimitiveTypes._long_double__Complex;
		}
	
	.|\n
		{
			throw new SourceError("Unknown primitive type ["+ yytext() +"].");
		}
}
