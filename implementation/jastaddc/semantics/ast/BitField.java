
package jastaddc.semantics.ast;


			
public class BitField extends UnionOrStructureElement implements Cloneable {
    public void flushCache() {
        super.flushCache();
        Name_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public BitField clone() throws CloneNotSupportedException {
        BitField node = (BitField)super.clone();
        node.Name_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public BitField copy() {
      try {
          BitField node = (BitField)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public BitField fullCopy() {
        BitField res = (BitField)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ReadableTypeNames.jrag at line 127

	protected String readableElementName() {
		StringBuilder result = new StringBuilder();
		if (!hasName())
			result.append("anonymous ");
		result.append("bitfield");
		if (hasName()) {
			result.append(" named [");
			result.append(getName().Name());
			result.append("]");
		}
		return result.toString();
	}

    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 412

    public BitField() {
        super();

        setChild(new Opt(), 1);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 412
    public BitField(_IntermediateType p0, Opt<Identifier> p1, Expression p2) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
    }

    // Declared in C99AST.ast at line 17


  protected int numChildren() {
    return 3;
  }

    // Declared in C99AST.ast at line 20

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
    // Declared in C99AST.ast line 412
    public void setNameOpt(Opt<Identifier> opt) {
        setChild(opt, 1);
    }

    // Declared in C99AST.ast at line 6


    public boolean hasName() {
        return getNameOpt().getNumChild() != 0;
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Identifier getName() {
        return (Identifier)getNameOpt().getChild(0);
    }

    // Declared in C99AST.ast at line 14


    public void setName(Identifier node) {
        getNameOpt().setChild(node, 0);
    }

    // Declared in C99AST.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<Identifier> getNameOpt() {
        return (Opt<Identifier>)getChild(1);
    }

    // Declared in C99AST.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<Identifier> getNameOptNoTransform() {
        return (Opt<Identifier>)getChildNoTransform(1);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 412
    public void setSize(Expression node) {
        setChild(node, 2);
    }

    // Declared in C99AST.ast at line 5

    public Expression getSize() {
        return (Expression)getChild(2);
    }

    // Declared in C99AST.ast at line 9


    public Expression getSizeNoTransform() {
        return (Expression)getChildNoTransform(2);
    }

    protected int Name_visited = -1;
    // Declared in Names.jrag at line 15
 @SuppressWarnings({"unchecked", "cast"})     public String Name() {
        if(Name_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Name in class: ");
        Name_visited = state().boundariesCrossed;
        String Name_value = Name_compute();
        Name_visited = -1;
        return Name_value;
    }

    private String Name_compute() {  return hasName() ? getName().Name(): "§Anonymous Bitfield "+ NodeAddress().toString() +"§";  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
