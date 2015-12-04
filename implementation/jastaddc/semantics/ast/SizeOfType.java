
package jastaddc.semantics.ast;


		
public class SizeOfType extends SizeOfExpression implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public SizeOfType clone() throws CloneNotSupportedException {
        SizeOfType node = (SizeOfType)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public SizeOfType copy() {
      try {
          SizeOfType node = (SizeOfType)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public SizeOfType fullCopy() {
        SizeOfType res = (SizeOfType)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 564

    public SizeOfType() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 564
    public SizeOfType(_IntermediateType p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 14


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 17

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 564
    public void setType(_IntermediateType node) {
        setChild(node, 0);
    }

    // Declared in C99AST.ast at line 5

    public _IntermediateType getType() {
        return (_IntermediateType)getChild(0);
    }

    // Declared in C99AST.ast at line 9


    public _IntermediateType getTypeNoTransform() {
        return (_IntermediateType)getChildNoTransform(0);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
