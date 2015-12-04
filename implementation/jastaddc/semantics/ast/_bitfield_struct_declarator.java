
package jastaddc.semantics.ast;


	
public class _bitfield_struct_declarator extends _struct_declarator implements Cloneable {
    public void flushCache() {
        super.flushCache();
        UnionOrStructureElement_visited = -1;
        UnionOrStructureElement_computed = false;
        UnionOrStructureElement_value = null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _bitfield_struct_declarator clone() throws CloneNotSupportedException {
        _bitfield_struct_declarator node = (_bitfield_struct_declarator)super.clone();
        node.UnionOrStructureElement_visited = -1;
        node.UnionOrStructureElement_computed = false;
        node.UnionOrStructureElement_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _bitfield_struct_declarator copy() {
      try {
          _bitfield_struct_declarator node = (_bitfield_struct_declarator)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _bitfield_struct_declarator fullCopy() {
        _bitfield_struct_declarator res = (_bitfield_struct_declarator)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 148

    public _bitfield_struct_declarator() {
        super();

        setChild(new Opt(), 0);

    }

    // Declared in ConcreteToASTMapping.ast at line 11


    // Declared in ConcreteToASTMapping.ast line 148
    public _bitfield_struct_declarator(Opt<_declarator> p0, Expression p1) {
        setChild(p0, 0);
        setBitFieldSize(p1);
    }

    // Declared in ConcreteToASTMapping.ast at line 16


  protected int numChildren() {
    return 1;
  }

    // Declared in ConcreteToASTMapping.ast at line 19

  public boolean mayHaveRewrite() { return false; }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 148
    public void set_declaratorOpt(Opt<_declarator> opt) {
        setChild(opt, 0);
    }

    // Declared in ConcreteToASTMapping.ast at line 6


    public boolean has_declarator() {
        return get_declaratorOpt().getNumChild() != 0;
    }

    // Declared in ConcreteToASTMapping.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public _declarator get_declarator() {
        return (_declarator)get_declaratorOpt().getChild(0);
    }

    // Declared in ConcreteToASTMapping.ast at line 14


    public void set_declarator(_declarator node) {
        get_declaratorOpt().setChild(node, 0);
    }

    // Declared in ConcreteToASTMapping.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<_declarator> get_declaratorOpt() {
        return (Opt<_declarator>)getChild(0);
    }

    // Declared in ConcreteToASTMapping.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<_declarator> get_declaratorOptNoTransform() {
        return (Opt<_declarator>)getChildNoTransform(0);
    }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 148
    protected Expression tokenExpression_BitFieldSize;

    // Declared in ConcreteToASTMapping.ast at line 3

    public void setBitFieldSize(Expression value) {
        tokenExpression_BitFieldSize = value;
    }

    // Declared in ConcreteToASTMapping.ast at line 6

    public Expression getBitFieldSize() {
        return tokenExpression_BitFieldSize;
    }

    protected int UnionOrStructureElement_visited = -1;
    protected boolean UnionOrStructureElement_computed = false;
    protected UnionOrStructureElement UnionOrStructureElement_value;
/**
	 * Compute the type and binding of a structure or union element:
	 
    Declared in FinalASTNodesComputations.jrag at line 341
*/
 @SuppressWarnings({"unchecked", "cast"})     public UnionOrStructureElement UnionOrStructureElement() {
        if(UnionOrStructureElement_computed)
            return UnionOrStructureElement_value;
        if(UnionOrStructureElement_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: UnionOrStructureElement in class: ");
        UnionOrStructureElement_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        UnionOrStructureElement_value = UnionOrStructureElement_compute();
        if(true)
            UnionOrStructureElement_computed = true;
        UnionOrStructureElement_visited = -1;
        return UnionOrStructureElement_value;
    }

    private UnionOrStructureElement UnionOrStructureElement_compute() {
		Opt bindedName;
		if (has_declarator() && !get_declarator().IsAbstractDeclarator())
			bindedName = new Opt(get_declarator().BindedNameOfDeclaratorTree());
		else bindedName = new Opt();
		Type type;
		if (has_declarator())
			type = get_declarator().TypeOfDeclaratorTree();
		else type = TypeSpecifierType();
		return new BitField(type, bindedName, getBitFieldSize());
	}

    // Declared in FinalASTNodesComputations.jrag at line 115
    public Type Define_Type_PreviousTypePart(ASTNode caller, ASTNode child) {
        if(caller == get_declaratorOptNoTransform()) {
            return TypeSpecifierType();
        }
        return getParent().Define_Type_PreviousTypePart(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
