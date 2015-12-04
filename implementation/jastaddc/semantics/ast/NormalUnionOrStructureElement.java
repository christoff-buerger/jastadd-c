
package jastaddc.semantics.ast;



			/**
			 * The Size expression of bit fields must be a constant, non
			 * negative integer expression [6.7.2.1:3] S.101.
			 * 
			 * BEWARE: The non negative part can not be evaluated machine
			 * independent, thus the same constant expression may have
			 * different results in different C99 implementations.
			 */
			
public class NormalUnionOrStructureElement extends UnionOrStructureElement implements Cloneable {
    public void flushCache() {
        super.flushCache();
        Name_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public NormalUnionOrStructureElement clone() throws CloneNotSupportedException {
        NormalUnionOrStructureElement node = (NormalUnionOrStructureElement)super.clone();
        node.Name_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public NormalUnionOrStructureElement copy() {
      try {
          NormalUnionOrStructureElement node = (NormalUnionOrStructureElement)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public NormalUnionOrStructureElement fullCopy() {
        NormalUnionOrStructureElement res = (NormalUnionOrStructureElement)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ReadableTypeNames.jrag at line 119

	protected String readableElementName() {
		StringBuilder result = new StringBuilder();
		result.append ("element named [");
		result.append(getName().Name());
		result.append("] of type ");
		result.append(getType().RetrieveFinalNode().ReadableTypeName());
		return result.toString();
	}

    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 411

    public NormalUnionOrStructureElement() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 411
    public NormalUnionOrStructureElement(_IntermediateType p0, Identifier p1) {
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
    // Declared in C99AST.ast line 401
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
    // Declared in C99AST.ast line 411
    public void setName(Identifier node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public Identifier getName() {
        return (Identifier)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public Identifier getNameNoTransform() {
        return (Identifier)getChildNoTransform(1);
    }

    protected int Name_visited = -1;
    // Declared in Names.jrag at line 14
 @SuppressWarnings({"unchecked", "cast"})     public String Name() {
        if(Name_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Name in class: ");
        Name_visited = state().boundariesCrossed;
        String Name_value = Name_compute();
        Name_visited = -1;
        return Name_value;
    }

    private String Name_compute() {  return getName().Name();  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
