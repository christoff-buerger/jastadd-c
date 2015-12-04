
package jastaddc.semantics.ast;



		/**
		 * A CommaExpression is not permitted as Value.
		 */
		
public class AtomicInitializer extends NormalInitializer implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public AtomicInitializer clone() throws CloneNotSupportedException {
        AtomicInitializer node = (AtomicInitializer)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public AtomicInitializer copy() {
      try {
          AtomicInitializer node = (AtomicInitializer)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public AtomicInitializer fullCopy() {
        AtomicInitializer res = (AtomicInitializer)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 169

    public AtomicInitializer() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 169
    public AtomicInitializer(Expression p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 14


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 17

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 169
    public void setValue(Expression node) {
        setChild(node, 0);
    }

    // Declared in C99AST.ast at line 5

    public Expression getValue() {
        return (Expression)getChild(0);
    }

    // Declared in C99AST.ast at line 9


    public Expression getValueNoTransform() {
        return (Expression)getChildNoTransform(0);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
