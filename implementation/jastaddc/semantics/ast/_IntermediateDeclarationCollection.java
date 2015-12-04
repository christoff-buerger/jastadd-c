
package jastaddc.semantics.ast;



/* **************************************************** Declarations [A.2.2] S.411 ***************************************************** */

/**
 * Check the introduction about this node's purpose!
 */

public abstract class _IntermediateDeclarationCollection extends Statement implements Cloneable {
    public void flushCache() {
        super.flushCache();
        RetrieveFinalNode_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _IntermediateDeclarationCollection clone() throws CloneNotSupportedException {
        _IntermediateDeclarationCollection node = (_IntermediateDeclarationCollection)super.clone();
        node.RetrieveFinalNode_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 107

    public _IntermediateDeclarationCollection() {
        super();


    }

    // Declared in C99AST.ast at line 9


  protected int numChildren() {
    return 0;
  }

    // Declared in C99AST.ast at line 12

  public boolean mayHaveRewrite() { return false; }

    protected int RetrieveFinalNode_visited = -1;
/**
	 * Nodes representing Declarations have to be mapped:
	 
    Declared in CompilerAPI.jrag at line 25
*/
 @SuppressWarnings({"unchecked", "cast"})     public DeclarationCollection RetrieveFinalNode() {
        if(RetrieveFinalNode_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: RetrieveFinalNode in class: ");
        RetrieveFinalNode_visited = state().boundariesCrossed;
        DeclarationCollection RetrieveFinalNode_value = RetrieveFinalNode_compute();
        RetrieveFinalNode_visited = -1;
        return RetrieveFinalNode_value;
    }

    private DeclarationCollection RetrieveFinalNode_compute() {
		throw new jastaddc.semantics.ConcreteToASTFailure(
				this, DeclarationCollection.class);
	}

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
