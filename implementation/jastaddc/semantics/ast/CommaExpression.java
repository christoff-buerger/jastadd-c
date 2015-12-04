
package jastaddc.semantics.ast;


	
	// Constant expressions are defined above under the "Terminals" section.
	
	
public class CommaExpression extends Expression implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public CommaExpression clone() throws CloneNotSupportedException {
        CommaExpression node = (CommaExpression)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public CommaExpression copy() {
      try {
          CommaExpression node = (CommaExpression)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public CommaExpression fullCopy() {
        CommaExpression res = (CommaExpression)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 496

    public CommaExpression() {
        super();

        setChild(new List(), 0);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 496
    public CommaExpression(List<Expression> p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 496
    public void setExpressionList(List<Expression> list) {
        setChild(list, 0);
    }

    // Declared in C99AST.ast at line 6


    public int getNumExpression() {
        return getExpressionList().getNumChild();
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Expression getExpression(int i) {
        return (Expression)getExpressionList().getChild(i);
    }

    // Declared in C99AST.ast at line 14


    public void addExpression(Expression node) {
        List<Expression> list = getExpressionList();
        list.addChild(node);
    }

    // Declared in C99AST.ast at line 19


    public void setExpression(Expression node, int i) {
        List<Expression> list = getExpressionList();
        list.setChild(node, i);
    }

    // Declared in C99AST.ast at line 23

    public List<Expression> getExpressions() {
        return getExpressionList();
    }

    // Declared in C99AST.ast at line 26

    public List<Expression> getExpressionsNoTransform() {
        return getExpressionListNoTransform();
    }

    // Declared in C99AST.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<Expression> getExpressionList() {
        return (List<Expression>)getChild(0);
    }

    // Declared in C99AST.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<Expression> getExpressionListNoTransform() {
        return (List<Expression>)getChildNoTransform(0);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
