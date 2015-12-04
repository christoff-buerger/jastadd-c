
package jastaddc.semantics.ast;


		
public class WhileStatement extends ConditionalControlFlowStatement implements Cloneable {
    public void flushCache() {
        super.flushCache();
        ControlFlowSuccessor_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public WhileStatement clone() throws CloneNotSupportedException {
        WhileStatement node = (WhileStatement)super.clone();
        node.ControlFlowSuccessor_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public WhileStatement copy() {
      try {
          WhileStatement node = (WhileStatement)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public WhileStatement fullCopy() {
        WhileStatement res = (WhileStatement)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 458

    public WhileStatement() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 458
    public WhileStatement(Expression p0, Statement p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    // Declared in C99AST.ast at line 15


  protected int numChildren() {
    return 2;
  }

    // Declared in C99AST.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 454
    public void setCondition(Expression node) {
        setChild(node, 0);
    }

    // Declared in C99AST.ast at line 5

    public Expression getCondition() {
        return (Expression)getChild(0);
    }

    // Declared in C99AST.ast at line 9


    public Expression getConditionNoTransform() {
        return (Expression)getChildNoTransform(0);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 454
    public void setBody(Statement node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public Statement getBody() {
        return (Statement)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public Statement getBodyNoTransform() {
        return (Statement)getChildNoTransform(1);
    }

    protected int ControlFlowSuccessor_visited = -1;
    // Declared in ControlFlow.jrag at line 65
 @SuppressWarnings({"unchecked", "cast"})     public java.util.Set<Statement> ControlFlowSuccessor() {
        if(ControlFlowSuccessor_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ControlFlowSuccessor in class: ");
        ControlFlowSuccessor_visited = state().boundariesCrossed;
        java.util.Set<Statement> ControlFlowSuccessor_value = ControlFlowSuccessor_compute();
        ControlFlowSuccessor_visited = -1;
        return ControlFlowSuccessor_value;
    }

    private java.util.Set<Statement> ControlFlowSuccessor_compute() {  return SetOp.union(getBody(), ControlFlowFollowing());  }

    // Declared in ControlFlow.jrag at line 67
    public java.util.Set<Statement> Define_java_util_Set_Statement__ControlFlowFollowing(ASTNode caller, ASTNode child) {
        if(caller == getBodyNoTransform()) {
            return SetOp.union(new java.util.HashSet<Statement>(), this);
        }
        return getParent().Define_java_util_Set_Statement__ControlFlowFollowing(this, caller);
    }

    // Declared in ContextInformationAccess.jrag at line 31
    public ConditionalControlFlowStatement Define_ConditionalControlFlowStatement_FindEnclosingLoopStatement(ASTNode caller, ASTNode child) {
        if(caller == getBodyNoTransform()) {
            return this;
        }
        return getParent().Define_ConditionalControlFlowStatement_FindEnclosingLoopStatement(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
