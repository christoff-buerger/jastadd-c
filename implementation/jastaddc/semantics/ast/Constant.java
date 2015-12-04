
package jastaddc.semantics.ast;

/**
 * Abstract syntax tree (AST) specification for the JastAddC C99 compiler. The
 * AST is the basis for all semantic analysis. It models the "Phrase structure
 * grammar" [A.2] S.409.
 * 
 * BEWARE :
 *  - Variable array lengths are not modeled ([*]).
 *  - static storage class specifier in function array parameters are not
 *    supported. E.g.: void func(int array[static])
 *
 * IMPORTANT: all abstract nodes, which name starts with '_Intermediate' exist
 * for rewriting purposes, supporting the mapping from the concrete to the
 * abstract syntax. They have an attribute RetrieveFinalNode(), which returns
 * a node type of the final AST. For the intermediate nodes, which have to be
 * rewritten to the nodes they represent, this attribute will cause a
 * ConcreteToAbstractSyntaxMappingError exception, which is a RuntimeException,
 * and "kill" the compiler. This behavior is appropriate, as
 * such intermediate nodes should never ever occur. They have always (without
 * any condition restricting this rule) to be rewritten to final AST nodes.
 * If this is not the case, the compiler implementation is erroneouse.
 * Intermediate nodes may have only attributes, whichs task
 * is to support the rewriting process! Other attributes are not permitted!
 * The same holds for intertype declarations or imperative methods woven.
 * If some final node type inherits from an intermediate node type the final
 * node type must NOT occurr on the right hand side of any rule. Instead always
 * the intermediate node type is used.
 * 
 * @author C. B\u00c3\u00bcrger
 */

/* ************************************************************* Terminals ************************************************************* */

/**
 * In contrast to the C99 standard JastAddC's string literals are constants.
 * In the C99 standard they form their own lexem class.
 */

public abstract class Constant extends Expression implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public Constant clone() throws CloneNotSupportedException {
        Constant node = (Constant)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in ASTNodeXMLAttributes.jrag at line 14

	public java.util.List<org.jdom.Attribute> createXMLNodeAttributes() {
		java.util.List<org.jdom.Attribute> result =
			new java.util.LinkedList<org.jdom.Attribute>();
		result.add(new org.jdom.Attribute("Lexem", getLexem()));
		return result;
	}

    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 37

    public Constant() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 37
    public Constant(String p0) {
        setLexem(p0);
    }

    // Declared in C99AST.ast at line 14


  protected int numChildren() {
    return 0;
  }

    // Declared in C99AST.ast at line 17

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 37
    protected String tokenString_Lexem;

    // Declared in C99AST.ast at line 3

    public void setLexem(String value) {
        tokenString_Lexem = value;
    }

    // Declared in C99AST.ast at line 6

    public String getLexem() {
        return tokenString_Lexem != null ? tokenString_Lexem : "";
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
