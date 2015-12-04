
package jastaddc.semantics.ast;


	
public class NumeralSystemHexadecimal extends NumeralSystemRadix implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public NumeralSystemHexadecimal clone() throws CloneNotSupportedException {
        NumeralSystemHexadecimal node = (NumeralSystemHexadecimal)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public NumeralSystemHexadecimal copy() {
      try {
          NumeralSystemHexadecimal node = (NumeralSystemHexadecimal)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public NumeralSystemHexadecimal fullCopy() {
        NumeralSystemHexadecimal res = (NumeralSystemHexadecimal)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 47

    public NumeralSystemHexadecimal() {
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
