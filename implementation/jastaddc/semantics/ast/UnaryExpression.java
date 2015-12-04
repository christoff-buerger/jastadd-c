
package jastaddc.semantics.ast;



	
public abstract class UnaryExpression extends Expression implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public UnaryExpression clone() throws CloneNotSupportedException {
        UnaryExpression node = (UnaryExpression)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 602

    public UnaryExpression() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 602
    public UnaryExpression(Expression p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 14


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 17

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 602
    public void setOperand(Expression node) {
        setChild(node, 0);
    }

    // Declared in C99AST.ast at line 5

    public Expression getOperand() {
        return (Expression)getChild(0);
    }

    // Declared in C99AST.ast at line 9


    public Expression getOperandNoTransform() {
        return (Expression)getChildNoTransform(0);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
