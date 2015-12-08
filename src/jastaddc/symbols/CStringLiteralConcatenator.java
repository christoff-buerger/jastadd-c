/*
	This program and the accompanying materials are made available under the
	terms of the MIT license (X11 license) which accompanies this distribution.
	
	Author: Christoff Bürger
*/

package jastaddc.symbols;

import java.io.IOException;

import beaver.Scanner;
import beaver.Symbol;

import jastaddc.syntax.CParser;

import jastaddc.semantics.StringLiteral;

/**
 * String literal concatenator for C99. The String literal concatenator is
 * used for a C front end developed with JastAdd.
 *
 * The String literal concatenator expects, that translation phases 1 till 5 are done.
 * It realizes translation phase 6 :
 *  - the concatenation of adjacent string literal token
 *  
 * It extends beaver's Scanner class, so it can be used as scanner for
 * a beaver parser. It's constructor accepts a beaver scanner,
 * which the CStringLiteralConcatenator will use to recognize
 * lexems. It only checks for string literal lexems (all other lexems
 * are just forwarded) and concatenates them, returning one concatenated
 * string literal lexem for each sequence of string literal lexems.
 * 
 * TODO : A much better solution would be the following, which can't be done as
 * unfortunately JFlex doesn't allow to have an arbitrary type of objects as
 * input stream. Otherwise we could use token symbols as input and create token
 * symbols as output again and the string literal concatenator could be generated
 * using a JFlex specification.
 */
public class CStringLiteralConcatenator extends Scanner {
	protected Scanner lexer;
	private Symbol cachedNextLexem;
	
	/**
	 * Creates a new string literal concatenator for translation phase 6 of an
	 * C99 compiler. The string literal concatenator will depend on the lexical
	 * informations delivered by an C99 lexer, which executes all tasks of
	 * translation phase 1 to 5.
	 * 
	 * @param lexer The input lexer, delivering token of the input stream.
	 */
	public CStringLiteralConcatenator(Scanner lexer) {
		this.lexer = lexer;
		cachedNextLexem = null;
	}
	
	/**
	 * Computes the next token, thus just forwards the token of the underlying lexer,
	 * if they are no string literal token. If the underlying lexer recognises as next
	 * token a string literal, this literal will be merged with all directly following
	 * string literals to form one big new multibyte character sequence. The type of a resulting
	 * concatenated multibyte character sequence is a wide string literal, if any of the concatenated
	 * part string literals has been a wide string literal (6.4.5;4).
	 * 
	 * The lexem of the concatenated new Token is the concatenation of the lexems
	 * of the original token, e.g.
	 *  - the lexems L"word" and "another word" result in the lexem L"word""another word"
	 *  - "word" and L"word" result in the lexem "word"L"word"
	 * 
	 * @return The next token.
	 */
	public Symbol nextToken() throws Scanner.Exception, IOException {
		Symbol nextSymbol;
		if (cachedNextLexem != null) {
			nextSymbol = cachedNextLexem;
			cachedNextLexem = null;
			return nextSymbol;
		}
		
		nextSymbol = lexer.nextToken();
		
		if (nextSymbol.getId() == CParser.Terminals.STRING_LITERAL) {
			int line = Symbol.getLine(nextSymbol.getStart());
			int column = Symbol.getColumn(nextSymbol.getEnd());
			int length = Symbol.getColumn(nextSymbol.getEnd()) - column;
			
			StringLiteral sl = (StringLiteral)nextSymbol.value;
			boolean isWideString = !sl.getIsWideString();
			StringBuilder lexem = new StringBuilder();
			lexem.append(sl.getLexem());
			StringBuilder value = new StringBuilder();
			value.append(sl.getStringValue());
			
			cachedNextLexem = lexer.nextToken();
			while (true) {
				if (cachedNextLexem.getId() != CParser.Terminals.STRING_LITERAL) {
					sl = new StringLiteral();
					sl.setLexem(lexem.toString());
					sl.setStringValue(value.toString());
					sl.setIsWideString(isWideString);
					
					Symbol result = new Symbol(CParser.Terminals.STRING_LITERAL, line, column, length, sl);
					return result;
				}
				
				sl = (StringLiteral)cachedNextLexem.value;
				isWideString = isWideString || sl.getIsWideString();
				lexem.append(sl.getLexem());
				value.append(sl.getStringValue());
				length = length + (Symbol.getColumn(cachedNextLexem.getEnd()) - Symbol.getColumn(cachedNextLexem.getStart()));
				cachedNextLexem = lexer.nextToken();
			}
		}
		
		return nextSymbol;
	}
}
