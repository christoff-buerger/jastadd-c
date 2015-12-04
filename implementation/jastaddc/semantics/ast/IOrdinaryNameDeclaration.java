
package jastaddc.semantics.ast;

/**
	 * This interface is used to represent results of ordinary name look
	 * ups. Ordinary names may be declared in Declaration nodes and
	 * EnumerationElement nodes. Each node type, which might represent
	 * an ordinary name declaration must implement this interface.
	 * 
	 * @author C. B\u00c3\u00bcrger
	 */
public interface IOrdinaryNameDeclaration {
    // Declared in CompilerAPI.jrag at line 328

		boolean IsErrorNode();

    // Declared in CompilerAPI.jrag at line 329

		boolean hasBindedName();

    // Declared in CompilerAPI.jrag at line 330

		Identifier getBindedName();

    // Declared in CompilerAPI.jrag at line 331

		String Name();

    // Declared in CompilerAPI.jrag at line 332

		_IntermediateType getType();

}
