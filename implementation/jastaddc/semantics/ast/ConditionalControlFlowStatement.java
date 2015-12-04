
package jastaddc.semantics.ast;



	
public abstract class ConditionalControlFlowStatement extends Statement implements Cloneable {
    public void flushCache() {
        super.flushCache();
        IsNodeTypeOrdinaryNameBlock_visited = -1;
        IsOrdinaryNameBlockInContext_ASTNode_visited = new java.util.HashMap(4);
    }
     @SuppressWarnings({"unchecked", "cast"})  public ConditionalControlFlowStatement clone() throws CloneNotSupportedException {
        ConditionalControlFlowStatement node = (ConditionalControlFlowStatement)super.clone();
        node.IsNodeTypeOrdinaryNameBlock_visited = -1;
        node.IsOrdinaryNameBlockInContext_ASTNode_visited = new java.util.HashMap(4);
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 454

    public ConditionalControlFlowStatement() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 454
    public ConditionalControlFlowStatement(Expression p0, Statement p1) {
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

    protected int IsNodeTypeOrdinaryNameBlock_visited = -1;
    // Declared in OrdinaryNames.jrag at line 48
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsNodeTypeOrdinaryNameBlock() {
        if(IsNodeTypeOrdinaryNameBlock_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsNodeTypeOrdinaryNameBlock in class: ");
        IsNodeTypeOrdinaryNameBlock_visited = state().boundariesCrossed;
        boolean IsNodeTypeOrdinaryNameBlock_value = IsNodeTypeOrdinaryNameBlock_compute();
        IsNodeTypeOrdinaryNameBlock_visited = -1;
        return IsNodeTypeOrdinaryNameBlock_value;
    }

    private boolean IsNodeTypeOrdinaryNameBlock_compute() {  return true;  }

    protected java.util.Map IsOrdinaryNameBlockInContext_ASTNode_visited;
    // Declared in OrdinaryNames.jrag at line 51
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

    private boolean IsOrdinaryNameBlockInContext_compute(ASTNode node) {  return getBody() == node ? true : super.IsOrdinaryNameBlockInContext(node);  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
