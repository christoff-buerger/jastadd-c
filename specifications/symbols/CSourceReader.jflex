/*
	This program and the accompanying materials are made available under the
	terms of the MIT license (X11 license) which accompanies this distribution.
	
	Author: Christoff Bürger
*/

/**
 * Source code reader for C99 generated with JFlex. The reader is used for a C front
 * end developed with JastAdd.
 * 
 * The reader realizes translation phase 1 :
 *  - mapping of physical source file multibyte
 *    characters to the source character set (to realize this, the
 *    {@link #CSourceReader(InputStream,Charset) constructor}
 *    taking an input stream and a java.nio.charset.Charset parameter can be used)
 *  - transformation of trigraph sequences to single character representations
 * 
 * It implements the Reader interface, so it can be used by further lexical analyze
 * automata generated with JFlex.
 */

package jastaddc.symbols;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.nio.charset.Charset;

%% //***************************Options and declarations***************************

//reader class code
%{
	public CSourceReader (InputStream in, Charset SOURCE_CHARACTER_CODING) {
		this(new BufferedReader(new InputStreamReader(in, SOURCE_CHARACTER_CODING)));
	}
	
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
%class CSourceReader
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

%% //***************************Lexical rules***************************

"??="			{return (int)'#';}
"??("			{return (int)'[';}
"??/"			{return (int)'\\';}
"??)"			{return (int)']';}
"??'"			{return (int)'^';}
"??<"			{return (int)'{';}
"??!"			{return (int)'|';}
"??>"			{return (int)'}';}
"??-"			{return (int)'~';}

.|\n			{return yytext().codePointAt(0);}
