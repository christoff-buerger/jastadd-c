
package jastaddc.semantics.ast;


	
	
public class _normal_struct_declarator extends _struct_declarator implements Cloneable {
    public void flushCache() {
        super.flushCache();
        UnionOrStructureElement_visited = -1;
        UnionOrStructureElement_computed = false;
        UnionOrStructureElement_value = null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _normal_struct_declarator clone() throws CloneNotSupportedException {
        _normal_struct_declarator node = (_normal_struct_declarator)super.clone();
        node.UnionOrStructureElement_visited = -1;
        node.UnionOrStructureElement_computed = false;
        node.UnionOrStructureElement_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _normal_struct_declarator copy() {
      try {
          _normal_struct_declarator node = (_normal_struct_declarator)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _normal_struct_declarator fullCopy() {
        _normal_struct_declarator res = (_normal_struct_declarator)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 147

    public _normal_struct_declarator() {
        super();


    }

    // Declared in ConcreteToASTMapping.ast at line 10


    // Declared in ConcreteToASTMapping.ast line 147
    public _normal_struct_declarator(_declarator p0) {
        setChild(p0, 0);
    }

    // Declared in ConcreteToASTMapping.ast at line 14


  protected int numChildren() {
    return 1;
  }

    // Declared in ConcreteToASTMapping.ast at line 17

  public boolean mayHaveRewrite() { return false; }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 147
    public void set_declarator(_declarator node) {
        setChild(node, 0);
    }

    // Declared in ConcreteToASTMapping.ast at line 5

    public _declarator get_declarator() {
        return (_declarator)getChild(0);
    }

    // Declared in ConcreteToASTMapping.ast at line 9


    public _declarator get_declaratorNoTransform() {
        return (_declarator)getChildNoTransform(0);
    }

    protected int UnionOrStructureElement_visited = -1;
    protected boolean UnionOrStructureElement_computed = false;
    protected UnionOrStructureElement UnionOrStructureElement_value;
/**
	 * Compute the type and binding of a structure or union element:
	 
    Declared in FinalASTNodesComputations.jrag at line 332
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
		if (get_declarator().IsAbstractDeclarator())
			throw new jastaddc.syntax.SyntacticalFailure(
					"PARSER-CONSTRAINT: The intermediate _declarator child node of a _struct_declarator must not represent an abstract declarator.\n\t"+
					"Check your parser implementation.");
		return new NormalUnionOrStructureElement(
				get_declarator().TypeOfDeclaratorTree(),
				get_declarator().BindedNameOfDeclaratorTree());
	}

    // Declared in FinalASTNodesComputations.jrag at line 113
    public Type Define_Type_PreviousTypePart(ASTNode caller, ASTNode child) {
        if(caller == get_declaratorNoTransform()) {
            return TypeSpecifierType();
        }
        return getParent().Define_Type_PreviousTypePart(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
