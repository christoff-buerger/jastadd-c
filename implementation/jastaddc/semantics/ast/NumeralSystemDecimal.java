
package jastaddc.semantics.ast;


	
public class NumeralSystemDecimal extends NumeralSystemRadix implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public NumeralSystemDecimal clone() throws CloneNotSupportedException {
        NumeralSystemDecimal node = (NumeralSystemDecimal)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public NumeralSystemDecimal copy() {
      try {
          NumeralSystemDecimal node = (NumeralSystemDecimal)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public NumeralSystemDecimal fullCopy() {
        NumeralSystemDecimal res = (NumeralSystemDecimal)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 48

    public NumeralSystemDecimal() {
        super();


    }

    // Declared in C99AST.ast at line 9


  protected int numChildren() {
    return 0;
  }

    // Declared in C99AST.ast at line 12

  public boolean mayHaveRewrite() { return false; }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
