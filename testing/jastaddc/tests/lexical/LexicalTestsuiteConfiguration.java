/*
	This program and the accompanying materials are made available under the
	terms of the MIT license (X11 license) which accompanies this distribution.
	
	Author: Christoff Bürger
*/

package jastaddc.tests.lexical;

import java.io.Reader;
import java.io.IOException;

import org.lexicaltestsuite.AConfiguration;
import org.lexicaltestsuite.ILexerAdapter;
import org.lexicaltestsuite.ConfigurationException;

import beaver.Scanner;
import beaver.Symbol;

import jastaddc.symbols.lexicalanalyse.CLexicalAnalyser;
import jastaddc.symbols.lexicalanalyse.CUnknownTokenException;

import jastaddc.syntax.syntacticalanalyse.CParser;

import jastaddc.semantics.ast.Constant;
import jastaddc.semantics.ast.Identifier;

/**
 * The JastAddC lexical test suite configuration. The generated JastAddC lexer
 * is wrapped and used for testing purposes.
 */
public class LexicalTestsuiteConfiguration extends AConfiguration {
	private ILexerAdapter lexerAdapter;
	
	/**
	 * Instantiates this lexical test suite configuration, adapting and
	 * using the JastAddC lexer.
	 */
	public LexicalTestsuiteConfiguration() {
		super();
		lexerAdapter = new LexerAdapter();
	}
	
	public ILexerAdapter getLexerAdapter() {
		return lexerAdapter;
	}
	
	private static class LexerAdapter implements ILexerAdapter {
		private final static CLexicalAnalyser lexer = new CLexicalAnalyser(null);
		
		private LexerAdapter() {}
		
		public void initialize(Reader inputSourceCode) throws ConfigurationException {
			lexer.initialize(inputSourceCode);
		}
		
		public TestToken nextToken() throws ConfigurationException, LexingError {
			try {
				TestToken result = new TestToken();
				Symbol read = lexer.nextToken();
				result.type = getTerminalName(read.getId());
				if (read.value instanceof Identifier)
					result.lexem = ((Identifier)read.value).getValue();
				else if (read.value instanceof Constant)
					result.lexem = ((Constant)read.value).getLexem();
				else result.lexem = (String)read.value;
				return result;
			} catch (CUnknownTokenException exception) {
				throw new LexingError(
						exception.line,
						exception.column,
						((CUnknownTokenException)exception).unknownLexem);
			} catch (Scanner.Exception exception) {
				//should never be thrown, as all Scanner.Exception are CUnknownTokenException
				throw new ConfigurationException(
						"Unexpected implementation behaviour : Lexer throwed " +
						Scanner.Exception.class.getName() + " while trying to recognize next token.",
						exception);
			} catch (IOException exception) {
				throw new ConfigurationException(
						"Not able to execute lexer. Lexer throwed " + IOException.class.getName() +
						" while trying to recognize next token.",
						exception);
			}
		}
		
		public TestToken getEOFToken() throws ConfigurationException {
			TestToken result = new TestToken();
			result.type = "EOF";
			result.lexem = "end-of-file";
			return result;
		}
		
		private static String getTerminalName (short id) throws ConfigurationException {
			java.lang.reflect.Field[] fields = CParser.Terminals.class.getFields();
			
			try {
				for (int i = 0; i < fields.length; i++) {
					if (fields[i].getShort(null) == id)
							return fields[i].getName();
				}
			} catch (IllegalAccessException exception) {
				throw new ConfigurationException(
						"Error in lexical test case : Access to terminal field denied.",
						exception);
			}
			
			throw new ConfigurationException(
					"Error in lexical test case : The expected terminal id " +
					id + " does not exist.");
		}
	}
}
