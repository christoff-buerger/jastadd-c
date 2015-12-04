
package jastaddc.semantics.ast;



		/**
		 * REWRITE: If for statements have an empty condition, the condition is
		 * true [6.8.5.3:2] S.136. E.g.:
		 * 
		 * for(expr1;;expr2) --> for(expr1; 1 ;expr2)
		 *
		 * and
		 * 
		 * for(decl;;expr) --> for(decl; 1 ;expr)
		 */
		
public class ForStatement extends ConditionalControlFlowStatement implements Cloneable {
    public void flushCache() {
        super.flushCache();
        ControlFlowSuccessor_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ForStatement clone() throws CloneNotSupportedException {
        ForStatement node = (ForStatement)super.clone();
        node.ControlFlowSuccessor_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ForStatement copy() {
      try {
          ForStatement node = (ForStatement)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ForStatement fullCopy() {
        ForStatement res = (ForStatement)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 471

    public ForStatement() {
        super();

        setChild(new Opt(), 2);
        setChild(new Opt(), 3);

    }

    // Declared in C99AST.ast at line 12


    // Declared in C99AST.ast line 471
    public ForStatement(Expression p0, Statement p1, Opt<Expression> p2, Opt<Expression> p3) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
        setChild(p3, 3);
    }

    // Declared in C99AST.ast at line 19


  protected int numChildren() {
    return 4;
  }

    // Declared in C99AST.ast at line 22

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

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 471
    public void setInitializationOpt(Opt<Expression> opt) {
        setChild(opt, 2);
    }

    // Declared in C99AST.ast at line 6


    public boolean hasInitialization() {
        return getInitializationOpt().getNumChild() != 0;
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Expression getInitialization() {
        return (Expression)getInitializationOpt().getChild(0);
    }

    // Declared in C99AST.ast at line 14


    public void setInitialization(Expression node) {
        getInitializationOpt().setChild(node, 0);
    }

    // Declared in C99AST.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<Expression> getInitializationOpt() {
        return (Opt<Expression>)getChild(2);
    }

    // Declared in C99AST.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<Expression> getInitializationOptNoTransform() {
        return (Opt<Expression>)getChildNoTransform(2);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 471
    public void setIterationOpt(Opt<Expression> opt) {
        setChild(opt, 3);
    }

    // Declared in C99AST.ast at line 6


    public boolean hasIteration() {
        return getIterationOpt().getNumChild() != 0;
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Expression getIteration() {
        return (Expression)getIterationOpt().getChild(0);
    }

    // Declared in C99AST.ast at line 14


    public void setIteration(Expression node) {
        getIterationOpt().setChild(node, 0);
    }

    // Declared in C99AST.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<Expression> getIterationOpt() {
        return (Opt<Expression>)getChild(3);
    }

    // Declared in C99AST.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<Expression> getIterationOptNoTransform() {
        return (Opt<Expression>)getChildNoTransform(3);
    }

    protected int ControlFlowSuccessor_visited = -1;
    // Declared in ControlFlow.jrag at line 75
 @SuppressWarnings({"unchecked", "cast"})     public java.util.Set<Statement> ControlFlowSuccessor() {
        if(ControlFlowSuccessor_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ControlFlowSuccessor in class: ");
        ControlFlowSuccessor_visited = state().boundariesCrossed;
        java.util.Set<Statement> ControlFlowSuccessor_value = ControlFlowSuccessor_compute();
        ControlFlowSuccessor_visited = -1;
        return ControlFlowSuccessor_value;
    }

    private java.util.Set<Statement> ControlFlowSuccessor_compute() {  return SetOp.union(getBody(), ControlFlowFollowing());  }

    // Declared in ControlFlow.jrag at line 77
    public java.util.Set<Statement> Define_java_util_Set_Statement__ControlFlowFollowing(ASTNode caller, ASTNode child) {
        if(caller == getBodyNoTransform()) {
            return SetOp.union(new java.util.HashSet<Statement>(), this);
        }
        return getParent().Define_java_util_Set_Statement__ControlFlowFollowing(this, caller);
    }

    // Declared in ContextInformationAccess.jrag at line 33
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
