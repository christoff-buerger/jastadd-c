
package jastaddc.semantics.ast;



/* ***************************************************** Expressions [A.2.1] S.409 ***************************************************** */


public abstract class Expression extends ASTNode<ASTNode> implements Cloneable {
    public void flushCache() {
        super.flushCache();
        Type_visited = -1;
        IsConstantExpression_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Expression clone() throws CloneNotSupportedException {
        Expression node = (Expression)super.clone();
        node.Type_visited = -1;
        node.IsConstantExpression_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 492

    public Expression() {
        super();


    }

    // Declared in C99AST.ast at line 9


  protected int numChildren() {
    return 0;
  }

    // Declared in C99AST.ast at line 12

  public boolean mayHaveRewrite() { return false; }

    protected int Type_visited = -1;
    // Declared in basics.jrag at line 5
 @SuppressWarnings({"unchecked", "cast"})     public Type Type() {
        if(Type_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Type in class: ");
        Type_visited = state().boundariesCrossed;
        Type Type_value = Type_compute();
        Type_visited = -1;
        return Type_value;
    }

    private Type Type_compute() {  return (Type)ErrorBuilder().ConstructErrorNode(Type.class);  }

    protected int IsConstantExpression_visited = -1;
    // Declared in basics.jrag at line 6
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsConstantExpression() {
        if(IsConstantExpression_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsConstantExpression in class: ");
        IsConstantExpression_visited = state().boundariesCrossed;
        boolean IsConstantExpression_value = IsConstantExpression_compute();
        IsConstantExpression_visited = -1;
        return IsConstantExpression_value;
    }

    private boolean IsConstantExpression_compute() {  return false;  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
