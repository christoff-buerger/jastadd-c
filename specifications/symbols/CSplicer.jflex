/*
	This program and the accompanying materials are made available under the
	terms of the MIT license (X11 license) which accompanies this distribution.
	
	Author: Christoff Bürger
*/

/**
 * Splicer for C99 generated with JFlex. The reader is used for a C front end developed with JastAdd.
 * 
 * The splicer realizes translation phase 2 :
 *  - each instance of a backslash character immediately followed by a
 *    new-line character is deleted, splicing physical source lines
 *    to form logical source lines
 * 
 * It implements the Reader interface, so it can be used by further lexical analyze
 * automata generated with JFlex.
 */

package jastaddc.symbols;

import java.io.Reader;

%% //***************************Options and declarations***************************

//reader class code
%{
	public void close() throws java.io.IOException {
		zzReader.close();
	}
	
	public int read(char[] cbuf, int off, int len) throws java.io.IOException {
		int charactersRead = 0;
		while (charactersRead < len && off < cbuf.length) {			
			int read = read();
			if (read == -1) {
				if (charactersRead == 0)
					return -1;
				return charactersRead;
			}
			
			cbuf[off++] = (char)read;
			charactersRead++;
		}
		
		return charactersRead;
	}
%}

//reader class configuration
%class CSplicer
%extends Reader
%public
%final

//scanning method configuration
%unicode
%function read
%type int
%eofval{
	return -1;
%eofval}
%eofclose

//macro declarations
LineTerminator = \r|\n|\r\n|\u2028|\u2029|\u000B|\u000C|\u0085 /* line termination for full unicode support; (\n == \u000A) (\r == \u000D) (\r\n == \u000D\\u000A) */

%% //***************************Lexical rules***************************

"\\"{LineTerminator}		{}
.|\n						{return yytext().codePointAt(0);}
