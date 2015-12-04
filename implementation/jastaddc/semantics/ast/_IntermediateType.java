
package jastaddc.semantics.ast;



/* ******************************************************** Types [A.2.2] S.411 ******************************************************** */

/**
 * Check the introduction about this node's purpose!
 */

public abstract class _IntermediateType extends ASTNode<ASTNode> implements Cloneable {
    public void flushCache() {
        super.flushCache();
        RetrieveFinalNode_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _IntermediateType clone() throws CloneNotSupportedException {
        _IntermediateType node = (_IntermediateType)super.clone();
        node.RetrieveFinalNode_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 204

    public _IntermediateType() {
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
	 * Nodes representing Types have to be mapped:
	 
    Declared in CompilerAPI.jrag at line 35
*/
 @SuppressWarnings({"unchecked", "cast"})     public Type RetrieveFinalNode() {
        if(RetrieveFinalNode_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: RetrieveFinalNode in class: ");
        RetrieveFinalNode_visited = state().boundariesCrossed;
        Type RetrieveFinalNode_value = RetrieveFinalNode_compute();
        RetrieveFinalNode_visited = -1;
        return RetrieveFinalNode_value;
    }

    private Type RetrieveFinalNode_compute() {
		throw new jastaddc.semantics.ConcreteToASTFailure(
				this, Type.class);
	}

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
