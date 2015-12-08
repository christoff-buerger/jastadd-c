/*
	This program and the accompanying materials are made available under the
	terms of the MIT license (X11 license) which accompanies this distribution.
	
	Author: Christoff Bürger
*/

package jastaddc.symbols;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import java.nio.charset.Charset;

import beaver.Scanner;
import beaver.Symbol;

/**
 * This class represents and executes all lexical tasks of an C99 compiler.
 * It's phases correspond to the translation phases of the C99 standard (5.1.1.2).
 * 
 * The lexical tasks are the translation phases 1 to 7 (of phase 7 only parts).
 * For each translation phase of the standard this C99 lexer executes a
 * corresponding component representing and executing the semantics of this phase :
 *  1) Mapping of physical source file characters and translation of trigraphs.
 *     The {@link jastaddc.symbols.lexicalanalyse.CSourceReader CSourceReader}-class is used to do so.
 *  2) Concatenation of spliced lines. The {@link jastaddc.symbols.lexicalanalyse.CSplicer CSplicer}-
 *     class is used to do so.
 *  3) Recognition of preprocessor token. Preprocessing is not done using this
 *     C99 lexer, but the preprocessing token also occuring to the parser are
 *     recognized (this are the preprocessing token which are in translation
 *     phase 7 converted into token; token are all symbols of the C99 grammar).
 *     The {@link jastaddc.symbols.lexicalanalyse.CLexer CLexer} is used to recognize C99 grammar symbols.
 *  4) Processing of preprocessor directives. <b>Not done here<b>.
 *  5) Transformation of source character set members and escape sequences. The
 *     {@link jastaddc.symbols.lexicalanalyse.CCharacterMapper CCharacterMapper} is used to perform this task.
 *  6) Concatenation of adjacent string literal token. The
 *     {@link jastaddc.symbols.lexicalanalyse.CStringLiteralConcatenator CStringLiteralConcatenator} is used
 *     to perform this task.
 *  7) Converting preprocessor token to token. The {@link jastaddc.symbols.lexicalanalyse.CLexer CLexer} is
 *     used to recognize C99 grammar symbols and it is already executed in this
 *     C99 lexer's phase 3, which corresponds to translation phase 3 of the standard.
 */
public class CLexicalAnalyser extends Scanner {
	protected Scanner lexerStack;
	
	/**
	 * Creates and initializes a C99 lexical analyzer. For parameter semantics check the
	 * {@link #initialize(Reader) initialize(Reader)}-method.
	 */
	public CLexicalAnalyser(Reader inputTextStream) {
		initialize(inputTextStream);
	}
	
	/**
	 * Creates and initializes a C99 lexical analyzer. For parameter semantics check the
	 * {@link #initialize(InputStream, Charset) initialize(InputStream, Charset)}-method.
	 */
	public CLexicalAnalyser(InputStream inputTextStream, Charset ENCODING) {
		initialize(inputTextStream, ENCODING);
	}
	
	/**
	 * Initializes this C99 lexical analyzer with the source code to analyze.
	 * All preprocessor directives, especial the import preprocessor directives have
	 * already to be executed. It is also expected, that the inputTextStream reader
	 * used the correct character encoding to read the source file. If special charcater
	 * sets have to be used, for example a new Charset has been developed, the
	 * {@link #initialize(InputStream, Charset) initialize(InputStream, Charset)}
	 * should be used instead.
	 * 
	 * @param inputTextStream The reader representing the complete source code to analyze.
	 */
	public void initialize (Reader inputTextStream) {
		lexerStack = new CStringLiteralConcatenator(
				new CCharacterMapper(
						new CLexer(
								new CSplicer(
										new CSourceReader(inputTextStream)))));
	}
	
	/**
	 * Performs exactly the same semantics as the
	 * {@link #initialize(Reader) initialize(Reader)}-method, expect that the user
	 * can use his own source file character set encoding. So the source file is "read" as
	 * input stream and a Charset can be used to interpret this input stream.
	 * 
	 * @param inputTextStream The input stream representing the complete source code to analyze.
	 * @param ENCODING The character encoding to use, to interpret the source file as text.
	 */
	public void initialize (InputStream inputTextStream, Charset ENCODING) {
		lexerStack = new CStringLiteralConcatenator(
				new CCharacterMapper(
						new CLexer(
								new CSplicer(
										new CSourceReader(inputTextStream, ENCODING)))));
	}
	
	/**
	 * Returns the next Symbol of the source file. Possible symbols are all C99
	 * grammar terminal symbols.
	 * 
	 * @return Next symbol of the source code to analyze.
	 */
	public Symbol nextToken () throws Scanner.Exception, IOException {
		return lexerStack.nextToken();
	}
}
