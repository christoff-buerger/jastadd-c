
package jastaddc.semantics.ast;



/**
 * An error builder is used to construct all the different error nodes. Such error
 * nodes can be used to represent attribute or method computation results of
 * attributes referencing AST nodes. For each node depending on another node to
 * compute it's semantics, but the other node may be an arbitrary node in the AST,
 * thus to find it complex computations have to be done, which have their own semantic
 * constraints, an attribute method providing save access for the needed
 * node has to be supported. If any of the semantic constraints specifying
 * which node this one depends on are not met, the access attribute will
 * return an appropriate error node of the type of the node needed.
 * 
 * If attributes/methods of error nodes are called (because the final
 * AST node type they inherit has such ones) the computations have to be harmless
 * and well defined. This means:
 *  - no exceptions are thrown
 *  - but the result may be an error node again.
 * 
 * The ErrorBuilder node supports an ErrorBuilder() method to make it
 * accessible from anywhere of the tree, so appropriate error results can be
 * constructed during any attribute/method evaluation.
 * 
 * The error handling module implementation has to specify this node, providing
 * functionality to construct error nodes.
 */

public abstract class ErrorBuilder extends ASTNode<ASTNode> implements Cloneable {
    public void flushCache() {
        super.flushCache();
        ErrorBuilder_ErrorNodes_visited = -1;
        ErrorBuilder_ErrorNodes_computed = false;
        ErrorBuilder_ErrorNodes_value = null;
    ErrorBuilder_ErrorNodes_contributors = new java.util.HashSet();
    }
     @SuppressWarnings({"unchecked", "cast"})  public ErrorBuilder clone() throws CloneNotSupportedException {
        ErrorBuilder node = (ErrorBuilder)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 98

    public ErrorBuilder() {
        super();


    }

    // Declared in C99AST.ast at line 9


  protected int numChildren() {
    return 0;
  }

    // Declared in C99AST.ast at line 12

  public boolean mayHaveRewrite() { return false; }

/**
	 * IMPORTANT: Do NEVER add the error node returned to any AST, thus
	 * it must not become an AST part. The construction process is specified
	 * to be lazy, thus caching is used and the same node may be returned
	 * several times instead of constructing each time a new node!
	 
    Declared in CompilerAPI.jrag at line 380
*/
 @SuppressWarnings({"unchecked", "cast"})     public abstract ASTNode ConstructErrorNode(Class nodeType);
public ASTNode rewriteTo() {
    return super.rewriteTo();
}

    protected int ErrorBuilder_ErrorNodes_visited = -1;
    protected boolean ErrorBuilder_ErrorNodes_computed = false;
    protected java.util.List<ASTNode> ErrorBuilder_ErrorNodes_value;
/**
	 * Provide the different error node building functionalities:
	 
    Declared in ErrorHandling.jrag at line 24
*/
 @SuppressWarnings({"unchecked", "cast"})     public java.util.List<ASTNode> ErrorNodes() {
        if(ErrorBuilder_ErrorNodes_computed)
            return ErrorBuilder_ErrorNodes_value;
        if(ErrorBuilder_ErrorNodes_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ErrorNodes in class: ");
        ErrorBuilder_ErrorNodes_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        ErrorBuilder_ErrorNodes_value = ErrorNodes_compute();
        if(isFinal && num == state().boundariesCrossed)
            ErrorBuilder_ErrorNodes_computed = true;
        ErrorBuilder_ErrorNodes_visited = -1;
        return ErrorBuilder_ErrorNodes_value;
    }

    java.util.HashSet ErrorBuilder_ErrorNodes_contributors = new java.util.HashSet();
    public java.util.HashSet ErrorBuilder_ErrorNodes_contributors() { return ErrorBuilder_ErrorNodes_contributors; }
    private java.util.List<ASTNode> ErrorNodes_compute() {
        ASTNode node = this;
        while(node.getParent() != null && !(node instanceof Compilation))
            node = node.getParent();
        Compilation root = (Compilation)node;
        root.collect_contributors_ErrorBuilder_ErrorNodes();
        ErrorBuilder_ErrorNodes_value = new java.util.LinkedList<ASTNode>();
        for(java.util.Iterator iter = ErrorBuilder_ErrorNodes_contributors.iterator(); iter.hasNext(); ) {
            ASTNode contributor = (ASTNode)iter.next();
            contributor.contributeTo_ErrorBuilder_ErrorBuilder_ErrorNodes(ErrorBuilder_ErrorNodes_value);
        }
        return ErrorBuilder_ErrorNodes_value;
    }

}
