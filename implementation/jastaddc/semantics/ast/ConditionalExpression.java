
package jastaddc.semantics.ast;



		/**
		 * PARSER-CONSTRAINT: Parser guarantees correct AST construction, e.g.
		 * a ? b ? c : d : e;
		 * will be the tree
		 *
		 *              C E
		 *            /  |  \
		 *         V:a  C E  V:e
		 *             / | \
		 *            /  |  \
		 *          V:b V:c V:d
		 *
		 * with : CE... ConditionalExpression
		 *        V ... Variable
		 * 
		 * REWRITE: The expression type of Result1 and Result2 has to be the
		 * same, thus one or both expressions may be promoted [6.5.15:5,6]
		 * S. 90. Such a promotion will be represented by an explicit type
		 * cast, which will be rewritten into the AST. E.g.:
		 * 
		 * int a; long b; a < b ? a : b;
		 * 
		 * will be rewritten to
		 * 
		 * int a; long b; a < b ? (long)a : b;
		 */
		
public class ConditionalExpression extends TernaryExpression implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public ConditionalExpression clone() throws CloneNotSupportedException {
        ConditionalExpression node = (ConditionalExpression)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ConditionalExpression copy() {
      try {
          ConditionalExpression node = (ConditionalExpression)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ConditionalExpression fullCopy() {
        ConditionalExpression res = (ConditionalExpression)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 664

    public ConditionalExpression() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 664
    public ConditionalExpression(Expression p0, Expression p1, Expression p2) {
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
