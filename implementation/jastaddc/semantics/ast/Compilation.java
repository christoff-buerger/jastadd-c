
package jastaddc.semantics.ast;



/* ************************************************ External Definitions [A.2.4] S.416 ************************************************* */


public class Compilation extends ASTNode<ASTNode> implements Cloneable {
    public void flushCache() {
        super.flushCache();
        NodeAddress_visited = -1;
        CompilationRootNode_visited = -1;
        IsErrorNode_visited = -1;
    collect_contributors_ASTNode_LocalLabelDeclarations = false;
    collect_contributors_ASTNode_LocalOrdinaryNameDeclarations = false;
    collect_contributors_ASTNode_LocalTagDeclarations = false;
    collect_contributors_ErrorBuilder_ErrorNodes = false;
    collect_contributors_FunctionDefinitionInitializer_AssociatedReturnJumps = false;
    collect_contributors_Statement_ControlFlowPredecessor = false;
    collect_contributors_SwitchStatement_AssociatedLabels = false;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Compilation clone() throws CloneNotSupportedException {
        Compilation node = (Compilation)super.clone();
        node.NodeAddress_visited = -1;
        node.CompilationRootNode_visited = -1;
        node.IsErrorNode_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Compilation copy() {
      try {
          Compilation node = (Compilation)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Compilation fullCopy() {
        Compilation res = (Compilation)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMappingSupport.jrag at line 11

	/**
	 * Support the construction of unique tags for anonymous types:
	 */
	private int constructedAnonymousTagsCount = 0;

    // Declared in ConcreteToASTMappingSupport.jrag at line 12

	protected String buildAnonymousTag() {
		constructedAnonymousTagsCount++;
		return "§Anonymous TagedType ["+ constructedAnonymousTagsCount +"]§";
	}

    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 72

    public Compilation() {
        super();

        is$Final(true);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 72
    public Compilation(TranslationUnit p0, ErrorBuilder p1) {
        setChild(p0, 0);
        setChild(p1, 1);
        is$Final(true);
    }

    // Declared in C99AST.ast at line 17


  protected int numChildren() {
    return 2;
  }

    // Declared in C99AST.ast at line 20

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 72
    public void setTranslationUnit(TranslationUnit node) {
        setChild(node, 0);
    }

    // Declared in C99AST.ast at line 5

    public TranslationUnit getTranslationUnit() {
        return (TranslationUnit)getChild(0);
    }

    // Declared in C99AST.ast at line 9


    public TranslationUnit getTranslationUnitNoTransform() {
        return (TranslationUnit)getChildNoTransform(0);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 72
    public void setErrorBuilder(ErrorBuilder node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public ErrorBuilder getErrorBuilder() {
        return (ErrorBuilder)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public ErrorBuilder getErrorBuilderNoTransform() {
        return (ErrorBuilder)getChildNoTransform(1);
    }

    // Declared in Labels.jrag at line 16
    private boolean collect_contributors_ASTNode_LocalLabelDeclarations = false;
    protected void collect_contributors_ASTNode_LocalLabelDeclarations() {
        if(collect_contributors_ASTNode_LocalLabelDeclarations) return;
        super.collect_contributors_ASTNode_LocalLabelDeclarations();
        collect_contributors_ASTNode_LocalLabelDeclarations = true;
    }



    // Declared in OrdinaryNames.jrag at line 18
    private boolean collect_contributors_ASTNode_LocalOrdinaryNameDeclarations = false;
    protected void collect_contributors_ASTNode_LocalOrdinaryNameDeclarations() {
        if(collect_contributors_ASTNode_LocalOrdinaryNameDeclarations) return;
        super.collect_contributors_ASTNode_LocalOrdinaryNameDeclarations();
        collect_contributors_ASTNode_LocalOrdinaryNameDeclarations = true;
    }



    // Declared in Tags.jrag at line 48
    private boolean collect_contributors_ASTNode_LocalTagDeclarations = false;
    protected void collect_contributors_ASTNode_LocalTagDeclarations() {
        if(collect_contributors_ASTNode_LocalTagDeclarations) return;
        super.collect_contributors_ASTNode_LocalTagDeclarations();
        collect_contributors_ASTNode_LocalTagDeclarations = true;
    }



    // Declared in ErrorHandling.jrag at line 24
    private boolean collect_contributors_ErrorBuilder_ErrorNodes = false;
    protected void collect_contributors_ErrorBuilder_ErrorNodes() {
        if(collect_contributors_ErrorBuilder_ErrorNodes) return;
        super.collect_contributors_ErrorBuilder_ErrorNodes();
        collect_contributors_ErrorBuilder_ErrorNodes = true;
    }



    // Declared in CompilerAPI.jrag at line 146
    private boolean collect_contributors_FunctionDefinitionInitializer_AssociatedReturnJumps = false;
    protected void collect_contributors_FunctionDefinitionInitializer_AssociatedReturnJumps() {
        if(collect_contributors_FunctionDefinitionInitializer_AssociatedReturnJumps) return;
        super.collect_contributors_FunctionDefinitionInitializer_AssociatedReturnJumps();
        collect_contributors_FunctionDefinitionInitializer_AssociatedReturnJumps = true;
    }



    // Declared in ControlFlow.jrag at line 24
    private boolean collect_contributors_Statement_ControlFlowPredecessor = false;
    protected void collect_contributors_Statement_ControlFlowPredecessor() {
        if(collect_contributors_Statement_ControlFlowPredecessor) return;
        super.collect_contributors_Statement_ControlFlowPredecessor();
        collect_contributors_Statement_ControlFlowPredecessor = true;
    }



    // Declared in CompilerAPI.jrag at line 139
    private boolean collect_contributors_SwitchStatement_AssociatedLabels = false;
    protected void collect_contributors_SwitchStatement_AssociatedLabels() {
        if(collect_contributors_SwitchStatement_AssociatedLabels) return;
        super.collect_contributors_SwitchStatement_AssociatedLabels();
        collect_contributors_SwitchStatement_AssociatedLabels = true;
    }



    protected int NodeAddress_visited = -1;
    // Declared in ASTNodeAddresses.jrag at line 5
 @SuppressWarnings({"unchecked", "cast"})     public jastaddc.semantics.NodeAddress NodeAddress() {
        if(NodeAddress_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: NodeAddress in class: ");
        NodeAddress_visited = state().boundariesCrossed;
        jastaddc.semantics.NodeAddress NodeAddress_value = NodeAddress_compute();
        NodeAddress_visited = -1;
        return NodeAddress_value;
    }

    private jastaddc.semantics.NodeAddress NodeAddress_compute() {  return new jastaddc.semantics.NodeAddress(1).addAddressPart(1);  }

    protected int CompilationRootNode_visited = -1;
/**
	 * Support the construction of appropriate error nodes.
	 * 
	 * Error nodes are used as mock classes for attributes referencing other AST nodes.
	 * Often semantic constraints for one language construct assume, that
	 * another language construct exists. But for invalid programs the other
	 * language construct may not exists. E.g. a variable may not be declared.
	 * But for the type analysis the declaration of a variable in an expression
	 * is looked up. Error nodes can be used to represent not existing AST references.
	 * For each semantic constraint requiering some node in the AST to exist, an attribute
	 * can be defined returning a reference to the node. If the semantic constraint is not
	 * met, thus no referenced AST node exists, the attribute can instead return an error
	 * node of the requiered type.
	 
    Declared in CompilerAPI.jrag at line 368
*/
 @SuppressWarnings({"unchecked", "cast"})     public Compilation CompilationRootNode() {
        if(CompilationRootNode_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: CompilationRootNode in class: ");
        CompilationRootNode_visited = state().boundariesCrossed;
        Compilation CompilationRootNode_value = CompilationRootNode_compute();
        CompilationRootNode_visited = -1;
        return CompilationRootNode_value;
    }

    private Compilation CompilationRootNode_compute() {  return this;  }

    protected int IsErrorNode_visited = -1;
/**
	 * Specify that nodes in the error tree represent error nodes and deactivate
	 * the AST tree validation and constraint checking for the error tree:
	 
    Declared in ErrorHandling.jrag at line 16
*/
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsErrorNode() {
        if(IsErrorNode_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsErrorNode in class: ");
        IsErrorNode_visited = state().boundariesCrossed;
        boolean IsErrorNode_value = IsErrorNode_compute();
        IsErrorNode_visited = -1;
        return IsErrorNode_value;
    }

    private boolean IsErrorNode_compute() {  return false;  }

    // Declared in ErrorHandling.jrag at line 18
    public boolean Define_boolean_IsErrorNode(ASTNode caller, ASTNode child) {
        if(caller == getTranslationUnitNoTransform()) {
            return false;
        }
        if(caller == getErrorBuilderNoTransform()) {
            return true;
        }
        return getParent().Define_boolean_IsErrorNode(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
