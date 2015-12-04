
package jastaddc.semantics.ast;


	
	
public class CompoundLiteral extends Expression implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public CompoundLiteral clone() throws CloneNotSupportedException {
        CompoundLiteral node = (CompoundLiteral)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public CompoundLiteral copy() {
      try {
          CompoundLiteral node = (CompoundLiteral)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public CompoundLiteral fullCopy() {
        CompoundLiteral res = (CompoundLiteral)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 501

    public CompoundLiteral() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 501
    public CompoundLiteral(_IntermediateType p0, Initializer p1) {
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
    // Declared in C99AST.ast line 501
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

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 501
    public void setValues(Initializer node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public Initializer getValues() {
        return (Initializer)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public Initializer getValuesNoTransform() {
        return (Initializer)getChildNoTransform(1);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
