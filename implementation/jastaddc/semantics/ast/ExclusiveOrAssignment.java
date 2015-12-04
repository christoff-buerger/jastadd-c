
package jastaddc.semantics.ast;


		
public class ExclusiveOrAssignment extends AssignmentExpression implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public ExclusiveOrAssignment clone() throws CloneNotSupportedException {
        ExclusiveOrAssignment node = (ExclusiveOrAssignment)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ExclusiveOrAssignment copy() {
      try {
          ExclusiveOrAssignment node = (ExclusiveOrAssignment)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ExclusiveOrAssignment fullCopy() {
        ExclusiveOrAssignment res = (ExclusiveOrAssignment)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 599

    public ExclusiveOrAssignment() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 599
    public ExclusiveOrAssignment(Expression p0, Expression p1) {
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
