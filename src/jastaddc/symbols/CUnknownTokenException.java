/*
	This program and the accompanying materials are made available under the
	terms of the MIT license (X11 license) which accompanies this distribution.
	
	Author: Christoff Bürger
*/

package jastaddc.symbols;

import beaver.Scanner;

/**
 * CUnknownTokenException's are thrown, if while lexing unknown lexems are
 * encountered. It's important to distinguish this type of error while parsing
 * from others, because it's the only possible lexical error caused by faulty
 * source code. Other errors during the lexical analyze are technical based,
 * like trying to read not existing source code files, not being allowed to
 * read a source code file, buffer problem etc. Exceptions like this should
 * never be instances of CUnknownTokenException, so this class is final.<br>
 * <br>
 * Technical based exceptions are represented by {@link java.io.IOException}s.
 */
final public class CUnknownTokenException extends Scanner.Exception {
	final public static long serialVersionUID = 1L;
	
	public String unknownLexem;
	
	public CUnknownTokenException(int line, int column, String unknownLexem, String message) {
		super(line, column, message);
		this.unknownLexem = unknownLexem;
	}
	
	public CUnknownTokenException(int line, int column, String unknownLexem) {
		super(line, column, "Unknown lexical element ["+ unknownLexem +"].");
		this.unknownLexem = unknownLexem;
	}
}
