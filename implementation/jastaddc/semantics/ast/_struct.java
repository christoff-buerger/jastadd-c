
package jastaddc.semantics.ast;



	
public class _struct extends _struct_or_union implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public _struct clone() throws CloneNotSupportedException {
        _struct node = (_struct)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _struct copy() {
      try {
          _struct node = (_struct)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _struct fullCopy() {
        _struct res = (_struct)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 137

    public _struct() {
        super();


    }

    // Declared in ConcreteToASTMapping.ast at line 9


  protected int numChildren() {
    return 0;
  }

    // Declared in ConcreteToASTMapping.ast at line 12

  public boolean mayHaveRewrite() { return false; }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
