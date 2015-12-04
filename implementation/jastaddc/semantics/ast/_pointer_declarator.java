
package jastaddc.semantics.ast;


	/**
	 * PARSER-CONSTRAINT: Only for abstract declarator the _declarator may be left.
	 */
	
public class _pointer_declarator extends _declarator implements Cloneable {
    public void flushCache() {
        super.flushCache();
        BindedNameOfDeclaratorTree_visited = -1;
        TypeOfDeclaratorTree_visited = -1;
        Type_visited = -1;
        Type_computed = false;
        Type_value = null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _pointer_declarator clone() throws CloneNotSupportedException {
        _pointer_declarator node = (_pointer_declarator)super.clone();
        node.BindedNameOfDeclaratorTree_visited = -1;
        node.TypeOfDeclaratorTree_visited = -1;
        node.Type_visited = -1;
        node.Type_computed = false;
        node.Type_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _pointer_declarator copy() {
      try {
          _pointer_declarator node = (_pointer_declarator)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _pointer_declarator fullCopy() {
        _pointer_declarator res = (_pointer_declarator)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 89

    public _pointer_declarator() {
        super();

        setChild(new Opt(), 1);

    }

    // Declared in ConcreteToASTMapping.ast at line 11


    // Declared in ConcreteToASTMapping.ast line 89
    public _pointer_declarator(_pointer p0, Opt<_declarator> p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    // Declared in ConcreteToASTMapping.ast at line 16


  protected int numChildren() {
    return 2;
  }

    // Declared in ConcreteToASTMapping.ast at line 19

  public boolean mayHaveRewrite() { return false; }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 89
    public void set_pointer(_pointer node) {
        setChild(node, 0);
    }

    // Declared in ConcreteToASTMapping.ast at line 5

    public _pointer get_pointer() {
        return (_pointer)getChild(0);
    }

    // Declared in ConcreteToASTMapping.ast at line 9


    public _pointer get_pointerNoTransform() {
        return (_pointer)getChildNoTransform(0);
    }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 89
    public void set_declaratorOpt(Opt<_declarator> opt) {
        setChild(opt, 1);
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
        return (Opt<_declarator>)getChild(1);
    }

    // Declared in ConcreteToASTMapping.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<_declarator> get_declaratorOptNoTransform() {
        return (Opt<_declarator>)getChildNoTransform(1);
    }

    protected int BindedNameOfDeclaratorTree_visited = -1;
    // Declared in FinalASTNodesComputations.jrag at line 26
 @SuppressWarnings({"unchecked", "cast"})     public Identifier BindedNameOfDeclaratorTree() {
        if(BindedNameOfDeclaratorTree_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: BindedNameOfDeclaratorTree in class: ");
        BindedNameOfDeclaratorTree_visited = state().boundariesCrossed;
        Identifier BindedNameOfDeclaratorTree_value = BindedNameOfDeclaratorTree_compute();
        BindedNameOfDeclaratorTree_visited = -1;
        return BindedNameOfDeclaratorTree_value;
    }

    private Identifier BindedNameOfDeclaratorTree_compute() {  return has_declarator() ? get_declarator().BindedNameOfDeclaratorTree() : null;  }

    protected int TypeOfDeclaratorTree_visited = -1;
/**
	 * Each declarator has a type and may be part of another declarator,
	 * but as no infinite types exist there must be a "root type" not being part
	 * of any other type:
	 
    Declared in FinalASTNodesComputations.jrag at line 40
*/
 @SuppressWarnings({"unchecked", "cast"})     public Type TypeOfDeclaratorTree() {
        if(TypeOfDeclaratorTree_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: TypeOfDeclaratorTree in class: ");
        TypeOfDeclaratorTree_visited = state().boundariesCrossed;
        Type TypeOfDeclaratorTree_value = TypeOfDeclaratorTree_compute();
        TypeOfDeclaratorTree_visited = -1;
        return TypeOfDeclaratorTree_value;
    }

    private Type TypeOfDeclaratorTree_compute() {  return has_declarator() ? get_declarator().TypeOfDeclaratorTree() : Type();  }

    protected int Type_visited = -1;
    protected boolean Type_computed = false;
    protected Type Type_value;
/**
	 * Each declarator represents a type:
	 
    Declared in FinalASTNodesComputations.jrag at line 52
*/
 @SuppressWarnings({"unchecked", "cast"})     public Type Type() {
        if(Type_computed)
            return Type_value;
        if(Type_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Type in class: ");
        Type_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        Type_value = Type_compute();
        if(true)
            Type_computed = true;
        Type_visited = -1;
        return Type_value;
    }

    private Type Type_compute() {  return get_pointer().TypeOfPointerTree();  }

    // Declared in FinalASTNodesComputations.jrag at line 110
    public Type Define_Type_PreviousTypePart(ASTNode caller, ASTNode child) {
        if(caller == get_declaratorOptNoTransform()) {
            return Type();
        }
        return getParent().Define_Type_PreviousTypePart(this, caller);
    }

    // Declared in FinalASTNodesComputations.jrag at line 81
    public Pointer Define_Pointer_Type(ASTNode caller, ASTNode child) {
        if(caller == get_pointerNoTransform()) {
            return new Pointer(
			get_pointer().getTypeQualifier(),
			PreviousTypePart());
        }
        return getParent().Define_Pointer_Type(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
