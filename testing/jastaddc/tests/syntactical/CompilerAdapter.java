package jastaddc.tests.syntactical;

import java.io.File;

import java.util.Iterator;

import org.testsuites.ConfigurationException;
import org.astregressiontestsuite.ICompilerAdapter;

import jastaddc.Compiler;

import jastaddc.semantics.ast.ASTNode;

/**
 * Adapter for the AST-RegressionTestSuite to use the JastAddC compiler to
 * construct AST's for validation/to create validators.
 * 
 * @author C. Bürger
 *
 */
public class CompilerAdapter implements ICompilerAdapter {
	/**
	 * For details check the IASTRegressionTestSuiteCompiler.compile(File) method.
	 */
	public IASTNode compile(File source)
	throws ConfigurationException, ICompilerAdapter.CompilationError {
		Compiler compiler = new Compiler();
		ASTNode result;
		try {
			result = compiler.compile(source);
			result.IsCorrect();
			Iterator<jastaddc.SourceError> iter =
				result.CompilationRootNode().collectAllErrorsOfTree();
			if (iter.hasNext()) {
				StringBuilder errorM = new StringBuilder();
				errorM.append("\t");
				while (iter.hasNext()) {
					errorM.append(iter.next().getMessage());
					if (iter.hasNext())
						errorM.append("\n\t");
				}
				throw new ICompilerAdapter.CompilationError(
						source,
						errorM.toString());
			}
		} catch (jastaddc.Compiler.ConfigurationException exc) {
			throw new ConfigurationException(exc);
		}
		return (IASTNode)result;
	}
}
