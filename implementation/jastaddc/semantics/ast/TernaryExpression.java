
package jastaddc.semantics.ast;



	
public abstract class TernaryExpression extends Expression implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public TernaryExpression clone() throws CloneNotSupportedException {
        TernaryExpression node = (TernaryExpression)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 636

    public TernaryExpression() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 636
    public TernaryExpression(Expression p0, Expression p1, Expression p2) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
    }

    // Declared in C99AST.ast at line 16


  protected int numChildren() {
    return 3;
  }

    // Declared in C99AST.ast at line 19

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 636
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
    // Declared in C99AST.ast line 636
    public void setResult1(Expression node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public Expression getResult1() {
        return (Expression)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public Expression getResult1NoTransform() {
        return (Expression)getChildNoTransform(1);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 636
    public void setResult2(Expression node) {
        setChild(node, 2);
    }

    // Declared in C99AST.ast at line 5

    public Expression getResult2() {
        return (Expression)getChild(2);
    }

    // Declared in C99AST.ast at line 9


    public Expression getResult2NoTransform() {
        return (Expression)getChildNoTransform(2);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
