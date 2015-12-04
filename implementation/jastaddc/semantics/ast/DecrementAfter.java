
package jastaddc.semantics.ast;


		
public class DecrementAfter extends UnaryExpression implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public DecrementAfter clone() throws CloneNotSupportedException {
        DecrementAfter node = (DecrementAfter)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public DecrementAfter copy() {
      try {
          DecrementAfter node = (DecrementAfter)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public DecrementAfter fullCopy() {
        DecrementAfter res = (DecrementAfter)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 613

    public DecrementAfter() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 613
    public DecrementAfter(Expression p0) {
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
