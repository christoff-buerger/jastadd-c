
package jastaddc.semantics.ast;



		
public class IfStatement extends ConditionalControlFlowStatement implements Cloneable {
    public void flushCache() {
        super.flushCache();
        IsOrdinaryNameBlockInContext_ASTNode_visited = new java.util.HashMap(4);
        ControlFlowSuccessor_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public IfStatement clone() throws CloneNotSupportedException {
        IfStatement node = (IfStatement)super.clone();
        node.IsOrdinaryNameBlockInContext_ASTNode_visited = new java.util.HashMap(4);
        node.ControlFlowSuccessor_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public IfStatement copy() {
      try {
          IfStatement node = (IfStatement)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public IfStatement fullCopy() {
        IfStatement res = (IfStatement)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 456

    public IfStatement() {
        super();

        setChild(new Opt(), 2);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 456
    public IfStatement(Expression p0, Statement p1, Opt<Statement> p2) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
    }

    // Declared in C99AST.ast at line 17


  protected int numChildren() {
    return 3;
  }

    // Declared in C99AST.ast at line 20

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
    // Declared in C99AST.ast line 456
    public void setAlternativeOpt(Opt<Statement> opt) {
        setChild(opt, 2);
    }

    // Declared in C99AST.ast at line 6


    public boolean hasAlternative() {
        return getAlternativeOpt().getNumChild() != 0;
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Statement getAlternative() {
        return (Statement)getAlternativeOpt().getChild(0);
    }

    // Declared in C99AST.ast at line 14


    public void setAlternative(Statement node) {
        getAlternativeOpt().setChild(node, 0);
    }

    // Declared in C99AST.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<Statement> getAlternativeOpt() {
        return (Opt<Statement>)getChild(2);
    }

    // Declared in C99AST.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<Statement> getAlternativeOptNoTransform() {
        return (Opt<Statement>)getChildNoTransform(2);
    }

    protected java.util.Map IsOrdinaryNameBlockInContext_ASTNode_visited;
/**
	 * The ASTNodes introducing new blocks for ordinary names.
	 
    Declared in OrdinaryNames.jrag at line 53
*/
	// By default a node just asks it's parent node if some node
	// introduces a new ordinary name block because of the nodes context:
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsOrdinaryNameBlockInContext(ASTNode node) {
        Object _parameters = node;
if(IsOrdinaryNameBlockInContext_ASTNode_visited == null) IsOrdinaryNameBlockInContext_ASTNode_visited = new java.util.HashMap(4);
        if(new Integer(state().boundariesCrossed).equals(IsOrdinaryNameBlockInContext_ASTNode_visited.get(_parameters)))
            throw new RuntimeException("Circular definition of attr: IsOrdinaryNameBlockInContext in class: ");
        IsOrdinaryNameBlockInContext_ASTNode_visited.put(_parameters, new Integer(state().boundariesCrossed));
        boolean IsOrdinaryNameBlockInContext_ASTNode_value = IsOrdinaryNameBlockInContext_compute(node);
        IsOrdinaryNameBlockInContext_ASTNode_visited.remove(_parameters);
        return IsOrdinaryNameBlockInContext_ASTNode_value;
    }

    private boolean IsOrdinaryNameBlockInContext_compute(ASTNode node) {  return getAlternative() == node ? true : super.IsOrdinaryNameBlockInContext(node);  }

    protected int ControlFlowSuccessor_visited = -1;
    // Declared in ControlFlow.jrag at line 54
 @SuppressWarnings({"unchecked", "cast"})     public java.util.Set<Statement> ControlFlowSuccessor() {
        if(ControlFlowSuccessor_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ControlFlowSuccessor in class: ");
        ControlFlowSuccessor_visited = state().boundariesCrossed;
        java.util.Set<Statement> ControlFlowSuccessor_value = ControlFlowSuccessor_compute();
        ControlFlowSuccessor_visited = -1;
        return ControlFlowSuccessor_value;
    }

    private java.util.Set<Statement> ControlFlowSuccessor_compute() {  return hasAlternative() ?
			SetOp.union(getBody(), getAlternative()) :
			SetOp.union(getBody(), ControlFlowFollowing());  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
