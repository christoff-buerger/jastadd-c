
package jastaddc.semantics.ast;


		
public class ForStatement_Decl extends ConditionalControlFlowStatement implements Cloneable {
    public void flushCache() {
        super.flushCache();
        ControlFlowSuccessor_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ForStatement_Decl clone() throws CloneNotSupportedException {
        ForStatement_Decl node = (ForStatement_Decl)super.clone();
        node.ControlFlowSuccessor_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ForStatement_Decl copy() {
      try {
          ForStatement_Decl node = (ForStatement_Decl)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ForStatement_Decl fullCopy() {
        ForStatement_Decl res = (ForStatement_Decl)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 472

    public ForStatement_Decl() {
        super();

        setChild(new Opt(), 2);
        setChild(new Opt(), 3);

    }

    // Declared in C99AST.ast at line 12


    // Declared in C99AST.ast line 472
    public ForStatement_Decl(Expression p0, Statement p1, Opt<_IntermediateDeclarationCollection> p2, Opt<Expression> p3) {
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
    // Declared in C99AST.ast line 472
    public void setInitializationOpt(Opt<_IntermediateDeclarationCollection> opt) {
        setChild(opt, 2);
    }

    // Declared in C99AST.ast at line 6


    public boolean hasInitialization() {
        return getInitializationOpt().getNumChild() != 0;
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public _IntermediateDeclarationCollection getInitialization() {
        return (_IntermediateDeclarationCollection)getInitializationOpt().getChild(0);
    }

    // Declared in C99AST.ast at line 14


    public void setInitialization(_IntermediateDeclarationCollection node) {
        getInitializationOpt().setChild(node, 0);
    }

    // Declared in C99AST.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<_IntermediateDeclarationCollection> getInitializationOpt() {
        return (Opt<_IntermediateDeclarationCollection>)getChild(2);
    }

    // Declared in C99AST.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<_IntermediateDeclarationCollection> getInitializationOptNoTransform() {
        return (Opt<_IntermediateDeclarationCollection>)getChildNoTransform(2);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 472
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
    // Declared in ControlFlow.jrag at line 80
 @SuppressWarnings({"unchecked", "cast"})     public java.util.Set<Statement> ControlFlowSuccessor() {
        if(ControlFlowSuccessor_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ControlFlowSuccessor in class: ");
        ControlFlowSuccessor_visited = state().boundariesCrossed;
        java.util.Set<Statement> ControlFlowSuccessor_value = ControlFlowSuccessor_compute();
        ControlFlowSuccessor_visited = -1;
        return ControlFlowSuccessor_value;
    }

    private java.util.Set<Statement> ControlFlowSuccessor_compute() {  return SetOp.union(getBody(), ControlFlowFollowing());  }

    // Declared in ControlFlow.jrag at line 82
    public java.util.Set<Statement> Define_java_util_Set_Statement__ControlFlowFollowing(ASTNode caller, ASTNode child) {
        if(caller == getBodyNoTransform()) {
            return SetOp.union(new java.util.HashSet<Statement>(), this);
        }
        return getParent().Define_java_util_Set_Statement__ControlFlowFollowing(this, caller);
    }

    // Declared in ContextInformationAccess.jrag at line 34
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
