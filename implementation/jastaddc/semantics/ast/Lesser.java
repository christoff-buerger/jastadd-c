
package jastaddc.semantics.ast;


		
public class Lesser extends BinaryExpression implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public Lesser clone() throws CloneNotSupportedException {
        Lesser node = (Lesser)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Lesser copy() {
      try {
          Lesser node = (Lesser)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Lesser fullCopy() {
        Lesser res = (Lesser)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 624

    public Lesser() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 624
    public Lesser(Expression p0, Expression p1) {
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
    // Declared in C99AST.ast line 615
    public void setOperand1(Expression node) {
        setChild(node, 0);
    }

    // Declared in C99AST.ast at line 5

    public Expression getOperand1() {
        return (Expression)getChild(0);
    }

    // Declared in C99AST.ast at line 9


    public Expression getOperand1NoTransform() {
        return (Expression)getChildNoTransform(0);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 615
    public void setOperand2(Expression node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public Expression getOperand2() {
        return (Expression)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public Expression getOperand2NoTransform() {
        return (Expression)getChildNoTransform(1);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
