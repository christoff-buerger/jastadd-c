
package jastaddc.semantics.ast;



/* ***************************************************** Statements [A.2.3] S.415 ****************************************************** */


public abstract class Statement extends ASTNode<ASTNode> implements Cloneable {
    public void flushCache() {
        super.flushCache();
        ControlFlowSuccessor_visited = -1;
        FindEnclosingSwitchStatement_visited = -1;
        FindEnclosingLoopStatement_visited = -1;
        FindEnclosingFunctionDefinition_visited = -1;
        ControlFlowFollowing_visited = -1;
        Statement_ControlFlowPredecessor_visited = -1;
        Statement_ControlFlowPredecessor_computed = false;
        Statement_ControlFlowPredecessor_value = null;
    Statement_ControlFlowPredecessor_contributors = new java.util.HashSet();
    }
     @SuppressWarnings({"unchecked", "cast"})  public Statement clone() throws CloneNotSupportedException {
        Statement node = (Statement)super.clone();
        node.ControlFlowSuccessor_visited = -1;
        node.FindEnclosingSwitchStatement_visited = -1;
        node.FindEnclosingLoopStatement_visited = -1;
        node.FindEnclosingFunctionDefinition_visited = -1;
        node.ControlFlowFollowing_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 416

    public Statement() {
        super();


    }

    // Declared in C99AST.ast at line 9


  protected int numChildren() {
    return 0;
  }

    // Declared in C99AST.ast at line 12

  public boolean mayHaveRewrite() { return false; }

    protected int ControlFlowSuccessor_visited = -1;
    // Declared in ControlFlow.jrag at line 22
 @SuppressWarnings({"unchecked", "cast"})     public java.util.Set<Statement> ControlFlowSuccessor() {
        if(ControlFlowSuccessor_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ControlFlowSuccessor in class: ");
        ControlFlowSuccessor_visited = state().boundariesCrossed;
        java.util.Set<Statement> ControlFlowSuccessor_value = ControlFlowSuccessor_compute();
        ControlFlowSuccessor_visited = -1;
        return ControlFlowSuccessor_value;
    }

    private java.util.Set<Statement> ControlFlowSuccessor_compute() {  return ControlFlowFollowing();  }

    protected int FindEnclosingSwitchStatement_visited = -1;
    // Declared in CompilerAPI.jrag at line 103
 @SuppressWarnings({"unchecked", "cast"})     public SwitchStatement FindEnclosingSwitchStatement() {
        if(FindEnclosingSwitchStatement_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: FindEnclosingSwitchStatement in class: ");
        FindEnclosingSwitchStatement_visited = state().boundariesCrossed;
        SwitchStatement FindEnclosingSwitchStatement_value = getParent().Define_SwitchStatement_FindEnclosingSwitchStatement(this, null);
        FindEnclosingSwitchStatement_visited = -1;
        return FindEnclosingSwitchStatement_value;
    }

    protected int FindEnclosingLoopStatement_visited = -1;
    // Declared in CompilerAPI.jrag at line 105
 @SuppressWarnings({"unchecked", "cast"})     public ConditionalControlFlowStatement FindEnclosingLoopStatement() {
        if(FindEnclosingLoopStatement_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: FindEnclosingLoopStatement in class: ");
        FindEnclosingLoopStatement_visited = state().boundariesCrossed;
        ConditionalControlFlowStatement FindEnclosingLoopStatement_value = getParent().Define_ConditionalControlFlowStatement_FindEnclosingLoopStatement(this, null);
        FindEnclosingLoopStatement_visited = -1;
        return FindEnclosingLoopStatement_value;
    }

    protected int FindEnclosingFunctionDefinition_visited = -1;
    // Declared in CompilerAPI.jrag at line 107
 @SuppressWarnings({"unchecked", "cast"})     public FunctionDefinitionInitializer FindEnclosingFunctionDefinition() {
        if(FindEnclosingFunctionDefinition_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: FindEnclosingFunctionDefinition in class: ");
        FindEnclosingFunctionDefinition_visited = state().boundariesCrossed;
        FunctionDefinitionInitializer FindEnclosingFunctionDefinition_value = getParent().Define_FunctionDefinitionInitializer_FindEnclosingFunctionDefinition(this, null);
        FindEnclosingFunctionDefinition_visited = -1;
        return FindEnclosingFunctionDefinition_value;
    }

    protected int ControlFlowFollowing_visited = -1;
    // Declared in ControlFlow.jrag at line 19
 @SuppressWarnings({"unchecked", "cast"})     public java.util.Set<Statement> ControlFlowFollowing() {
        if(ControlFlowFollowing_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ControlFlowFollowing in class: ");
        ControlFlowFollowing_visited = state().boundariesCrossed;
        java.util.Set<Statement> ControlFlowFollowing_value = getParent().Define_java_util_Set_Statement__ControlFlowFollowing(this, null);
        ControlFlowFollowing_visited = -1;
        return ControlFlowFollowing_value;
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

    protected int Statement_ControlFlowPredecessor_visited = -1;
    protected boolean Statement_ControlFlowPredecessor_computed = false;
    protected java.util.Set<Statement> Statement_ControlFlowPredecessor_value;
    // Declared in ControlFlow.jrag at line 24
 @SuppressWarnings({"unchecked", "cast"})     public java.util.Set<Statement> ControlFlowPredecessor() {
        if(Statement_ControlFlowPredecessor_computed)
            return Statement_ControlFlowPredecessor_value;
        if(Statement_ControlFlowPredecessor_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ControlFlowPredecessor in class: ");
        Statement_ControlFlowPredecessor_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        Statement_ControlFlowPredecessor_value = ControlFlowPredecessor_compute();
        if(isFinal && num == state().boundariesCrossed)
            Statement_ControlFlowPredecessor_computed = true;
        Statement_ControlFlowPredecessor_visited = -1;
        return Statement_ControlFlowPredecessor_value;
    }

    java.util.HashSet Statement_ControlFlowPredecessor_contributors = new java.util.HashSet();
    public java.util.HashSet Statement_ControlFlowPredecessor_contributors() { return Statement_ControlFlowPredecessor_contributors; }
    private java.util.Set<Statement> ControlFlowPredecessor_compute() {
        ASTNode node = this;
        while(node.getParent() != null && !(node instanceof Compilation))
            node = node.getParent();
        Compilation root = (Compilation)node;
        root.collect_contributors_Statement_ControlFlowPredecessor();
        Statement_ControlFlowPredecessor_value = new java.util.HashSet<Statement>();
        for(java.util.Iterator iter = Statement_ControlFlowPredecessor_contributors.iterator(); iter.hasNext(); ) {
            ASTNode contributor = (ASTNode)iter.next();
            contributor.contributeTo_Statement_Statement_ControlFlowPredecessor(Statement_ControlFlowPredecessor_value);
        }
        return Statement_ControlFlowPredecessor_value;
    }

    protected void collect_contributors_Statement_ControlFlowPredecessor() {
        // Declared in ControlFlow.jrag at line 28
        for(java.util.Iterator iter = (ControlFlowSuccessor()).iterator(); iter.hasNext(); ) {
            Statement ref = (Statement)iter.next();
            if(ref != null)
            ref.Statement_ControlFlowPredecessor_contributors().add(this);
        }
        super.collect_contributors_Statement_ControlFlowPredecessor();
    }
    protected void contributeTo_Statement_Statement_ControlFlowPredecessor(java.util.Set<Statement> collection) {
        super.contributeTo_Statement_Statement_ControlFlowPredecessor(collection);
        collection.add(this);
    }

}
