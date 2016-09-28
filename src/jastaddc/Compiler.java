/*
	This program and the accompanying materials are made available under the
	terms of the MIT license (X11 license) which accompanies this distribution.
	
	Author: Christoff Bürger
*/

package jastaddc;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import jastaddc.symbols.CLexicalAnalyser;
import jastaddc.syntax.CParser;
import jastaddc.semantics.Compilation;

/**
 * Class representing a C99 compiler front end, realizing the lexical, syntactical
 * and semantical analysis. The result of a successful compilation is an AST (to be exact
 * the root node Compilation), annotated with attributes, which can be evaluated on
 * demand. No attribute of the AST has been demanded yet, thus no semantic evaluation has
 * been executed yet. It is up to the user of the AST to ask the attributes he's interested
 * in about their values, which will automatically trigger the appropriate evaluations. If
 * the source code contains lexical or syntactical errors they will be annotated to the AST.
 * Lexical and syntactical errors are annotated to the root node. Semantical errors are not
 * annotated yet, but the user can call the IsCorrect() attribute to trigger their annotation.
 */
public class Compiler {
	/**
	 * Print the errors of a source file on standard out.
	 *
	 * @param args Singleton array containing the source file to compile.
	 */
	public static void main(String[] args) {
		try {
			if (args.length == 0) {
				throw new ConfigurationException(
					"No source file to compile specified.");
			} else if (args.length > 1) {
				throw new ConfigurationException(
					"Unknown arguments; expected single source file to compile.");
			} else {
				Compilation ast = compile(new File(args[0]));
				ast.IsCorrect();
				java.util.Iterator<SourceError> errors = ast.collectAllErrorsOfTree();
				if (!errors.hasNext())
					System.out.println("No errors found.");
				while (errors.hasNext()) {
					System.out.println(errors.next().getMessage());
				}
			}
		} catch (ConfigurationException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Executes the compilation of a source code file with the goal to retrieve an AST
	 * and return the AST's root node. Check the description of the {@link jastaddc.Compiler}
	 * class for details.
	 * 
	 * @param source The source code to compile.
	 * @return The root node of the AST. The node may be annotated with lexical and
	 * syntactical errors.
	 * @throws ConfigurationException Is thrown, if the source code file can not be read or other
	 * technical errors occurred, thus the compiler can not be executed. It is never thrown
	 * if the compiler has been executed successful, even if the source code contains errors.
	 */
	public static Compilation compile(File source) throws ConfigurationException {
		if (source == null)
			throw new ConfigurationException("No source file to compile specified.");
		
		Compilation result;
		try {
			final String sourceName = source.getName();
			CLexicalAnalyser lexer = new CLexicalAnalyser(new FileReader(source));
			CParser parser = new CParser();
			result = parser.parse(lexer, sourceName);
		} catch (IOException exc) {
			throw new ConfigurationException(exc);
		}
		
		return result;
	}
	
	/**
	 * {@link ConfigurationException}s are thrown, if the compiler can not be
	 * executed successful. They are technical issue related. They are never thrown
	 * because of erroneous source code.
	 */
	public static class ConfigurationException extends Exception {
		public static final long serialVersionUID = 1L;
		
		public ConfigurationException(String message) {
			super(message);
		}
		
		public ConfigurationException(String message, Exception exception) {
			super(message, exception);
		}
		
		public ConfigurationException(Exception exception) {
			super(exception);
		}
		
		public String getMessage() {
			return "Couldn't execute compiler. Cause:\n\t"+ super.getMessage();
		}
	}
}
