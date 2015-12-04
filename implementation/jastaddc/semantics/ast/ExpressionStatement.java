
package jastaddc.semantics.ast;


	
public class ExpressionStatement extends Statement implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public ExpressionStatement clone() throws CloneNotSupportedException {
        ExpressionStatement node = (ExpressionStatement)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ExpressionStatement copy() {
      try {
          ExpressionStatement node = (ExpressionStatement)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ExpressionStatement fullCopy() {
        ExpressionStatement res = (ExpressionStatement)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 419

    public ExpressionStatement() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 419
    public ExpressionStatement(Expression p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 14


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 17

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 419
    public void setExpression(Expression node) {
        setChild(node, 0);
    }

    // Declared in C99AST.ast at line 5

    public Expression getExpression() {
        return (Expression)getChild(0);
    }

    // Declared in C99AST.ast at line 9


    public Expression getExpressionNoTransform() {
        return (Expression)getChildNoTransform(0);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
