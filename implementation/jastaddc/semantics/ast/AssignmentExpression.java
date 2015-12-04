
package jastaddc.semantics.ast;



	/**
	 * PARSER-CONSTRAINT: Parser guarantees correct AST construction, e.g.
	 * a = b = c;
	 * will be the tree
	 *
	 *      AE
	 *     /  \
	 *   V:a  AE
	 *       /  \
	 *     V:b  V:c
	 *
	 * and not
	 *
	 *      AE
	 *     /  \
	 *    AE  V:c
	 *   /  \
	 * V:a  V:b
	 *
	 * with : AE... AssignmentExpression
	 *        V ... Variable
	 */
	
public abstract class AssignmentExpression extends Expression implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public AssignmentExpression clone() throws CloneNotSupportedException {
        AssignmentExpression node = (AssignmentExpression)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 588

    public AssignmentExpression() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 588
    public AssignmentExpression(Expression p0, Expression p1) {
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
    // Declared in C99AST.ast line 588
    public void setlValue(Expression node) {
        setChild(node, 0);
    }

    // Declared in C99AST.ast at line 5

    public Expression getlValue() {
        return (Expression)getChild(0);
    }

    // Declared in C99AST.ast at line 9


    public Expression getlValueNoTransform() {
        return (Expression)getChildNoTransform(0);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 588
    public void setrValue(Expression node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public Expression getrValue() {
        return (Expression)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public Expression getrValueNoTransform() {
        return (Expression)getChildNoTransform(1);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
