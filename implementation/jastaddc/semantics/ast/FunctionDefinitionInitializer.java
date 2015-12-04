
package jastaddc.semantics.ast;


	
	
public class FunctionDefinitionInitializer extends Initializer implements Cloneable {
    public void flushCache() {
        super.flushCache();
        ControlFlowEntryNode_visited = -1;
        ControlFlowEntryNode_computed = false;
        ControlFlowEntryNode_value = null;
        ControlFlowExitNode_visited = -1;
        ControlFlowExitNode_computed = false;
        ControlFlowExitNode_value = null;
        FunctionDefinitionInitializer_AssociatedReturnJumps_visited = -1;
        FunctionDefinitionInitializer_AssociatedReturnJumps_computed = false;
        FunctionDefinitionInitializer_AssociatedReturnJumps_value = null;
    FunctionDefinitionInitializer_AssociatedReturnJumps_contributors = new java.util.HashSet();
    }
     @SuppressWarnings({"unchecked", "cast"})  public FunctionDefinitionInitializer clone() throws CloneNotSupportedException {
        FunctionDefinitionInitializer node = (FunctionDefinitionInitializer)super.clone();
        node.ControlFlowEntryNode_visited = -1;
        node.ControlFlowEntryNode_computed = false;
        node.ControlFlowEntryNode_value = null;
        node.ControlFlowExitNode_visited = -1;
        node.ControlFlowExitNode_computed = false;
        node.ControlFlowExitNode_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public FunctionDefinitionInitializer copy() {
      try {
          FunctionDefinitionInitializer node = (FunctionDefinitionInitializer)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public FunctionDefinitionInitializer fullCopy() {
        FunctionDefinitionInitializer res = (FunctionDefinitionInitializer)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 163

    public FunctionDefinitionInitializer() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 163
    public FunctionDefinitionInitializer(CompoundStatement p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 14


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 17

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 163
    public void setBody(CompoundStatement node) {
        setChild(node, 0);
    }

    // Declared in C99AST.ast at line 5

    public CompoundStatement getBody() {
        return (CompoundStatement)getChild(0);
    }

    // Declared in C99AST.ast at line 9


    public CompoundStatement getBodyNoTransform() {
        return (CompoundStatement)getChildNoTransform(0);
    }

    protected int ControlFlowEntryNode_visited = -1;
    protected boolean ControlFlowEntryNode_computed = false;
    protected Statement ControlFlowEntryNode_value;
    // Declared in ControlFlow.jrag at line 32
 @SuppressWarnings({"unchecked", "cast"})     public Statement ControlFlowEntryNode() {
        if(ControlFlowEntryNode_computed)
            return ControlFlowEntryNode_value;
        if(ControlFlowEntryNode_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ControlFlowEntryNode in class: ");
        ControlFlowEntryNode_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        ControlFlowEntryNode_value = ControlFlowEntryNode_compute();
        ControlFlowEntryNode_value.setParent(this);
        ControlFlowEntryNode_value.is$Final = true;
        if(true)
            ControlFlowEntryNode_computed = true;
        ControlFlowEntryNode_visited = -1;
        return ControlFlowEntryNode_value;
    }

    private Statement ControlFlowEntryNode_compute() {  return new EmptyStatement();  }

    protected int ControlFlowExitNode_visited = -1;
    protected boolean ControlFlowExitNode_computed = false;
    protected Statement ControlFlowExitNode_value;
    // Declared in ControlFlow.jrag at line 34
 @SuppressWarnings({"unchecked", "cast"})     public Statement ControlFlowExitNode() {
        if(ControlFlowExitNode_computed)
            return ControlFlowExitNode_value;
        if(ControlFlowExitNode_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ControlFlowExitNode in class: ");
        ControlFlowExitNode_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        ControlFlowExitNode_value = ControlFlowExitNode_compute();
        ControlFlowExitNode_value.setParent(this);
        ControlFlowExitNode_value.is$Final = true;
        if(true)
            ControlFlowExitNode_computed = true;
        ControlFlowExitNode_visited = -1;
        return ControlFlowExitNode_value;
    }

    private Statement ControlFlowExitNode_compute() {  return new EmptyStatement();  }

    // Declared in ControlFlow.jrag at line 40
    public java.util.Set<Statement> Define_java_util_Set_Statement__ControlFlowFollowing(ASTNode caller, ASTNode child) {
        if(caller == getBodyNoTransform()) {
            return SetOp.union(new java.util.HashSet<Statement>(), ControlFlowExitNode());
        }
        if(caller == ControlFlowEntryNode_value){
            return SetOp.union(new java.util.HashSet<Statement>(), getBody());
        }
        return getParent().Define_java_util_Set_Statement__ControlFlowFollowing(this, caller);
    }

    // Declared in ContextInformationAccess.jrag at line 36
    public ConditionalControlFlowStatement Define_ConditionalControlFlowStatement_FindEnclosingLoopStatement(ASTNode caller, ASTNode child) {
        if(caller == getBodyNoTransform()) {
            return null;
        }
        return getParent().Define_ConditionalControlFlowStatement_FindEnclosingLoopStatement(this, caller);
    }

    // Declared in ContextInformationAccess.jrag at line 25
    public FunctionType Define_FunctionType_IsParameterDeclaration(ASTNode caller, ASTNode child) {
        if(caller == getBodyNoTransform()) {
            return null;
        }
        return getParent().Define_FunctionType_IsParameterDeclaration(this, caller);
    }

    // Declared in ContextInformationAccess.jrag at line 29
    public SwitchStatement Define_SwitchStatement_FindEnclosingSwitchStatement(ASTNode caller, ASTNode child) {
        if(caller == getBodyNoTransform()) {
            return null;
        }
        return getParent().Define_SwitchStatement_FindEnclosingSwitchStatement(this, caller);
    }

    // Declared in ContextInformationAccess.jrag at line 38
    public FunctionDefinitionInitializer Define_FunctionDefinitionInitializer_FindEnclosingFunctionDefinition(ASTNode caller, ASTNode child) {
        if(caller == getBodyNoTransform()) {
            return this;
        }
        return getParent().Define_FunctionDefinitionInitializer_FindEnclosingFunctionDefinition(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

    protected int FunctionDefinitionInitializer_AssociatedReturnJumps_visited = -1;
    protected boolean FunctionDefinitionInitializer_AssociatedReturnJumps_computed = false;
    protected java.util.List<ReturnJump> FunctionDefinitionInitializer_AssociatedReturnJumps_value;
/**
	 * Provide functionality to find all return statements of a function
	 * definition.
	 
    Declared in CompilerAPI.jrag at line 146
*/
 @SuppressWarnings({"unchecked", "cast"})     public java.util.List<ReturnJump> AssociatedReturnJumps() {
        if(FunctionDefinitionInitializer_AssociatedReturnJumps_computed)
            return FunctionDefinitionInitializer_AssociatedReturnJumps_value;
        if(FunctionDefinitionInitializer_AssociatedReturnJumps_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: AssociatedReturnJumps in class: ");
        FunctionDefinitionInitializer_AssociatedReturnJumps_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        FunctionDefinitionInitializer_AssociatedReturnJumps_value = AssociatedReturnJumps_compute();
        if(isFinal && num == state().boundariesCrossed)
            FunctionDefinitionInitializer_AssociatedReturnJumps_computed = true;
        FunctionDefinitionInitializer_AssociatedReturnJumps_visited = -1;
        return FunctionDefinitionInitializer_AssociatedReturnJumps_value;
    }

    java.util.HashSet FunctionDefinitionInitializer_AssociatedReturnJumps_contributors = new java.util.HashSet();
    public java.util.HashSet FunctionDefinitionInitializer_AssociatedReturnJumps_contributors() { return FunctionDefinitionInitializer_AssociatedReturnJumps_contributors; }
    private java.util.List<ReturnJump> AssociatedReturnJumps_compute() {
        ASTNode node = this;
        while(node.getParent() != null && !(node instanceof Compilation))
            node = node.getParent();
        Compilation root = (Compilation)node;
        root.collect_contributors_FunctionDefinitionInitializer_AssociatedReturnJumps();
        FunctionDefinitionInitializer_AssociatedReturnJumps_value = new java.util.LinkedList<ReturnJump>();
        for(java.util.Iterator iter = FunctionDefinitionInitializer_AssociatedReturnJumps_contributors.iterator(); iter.hasNext(); ) {
            ASTNode contributor = (ASTNode)iter.next();
            contributor.contributeTo_FunctionDefinitionInitializer_FunctionDefinitionInitializer_AssociatedReturnJumps(FunctionDefinitionInitializer_AssociatedReturnJumps_value);
        }
        return FunctionDefinitionInitializer_AssociatedReturnJumps_value;
    }

}
