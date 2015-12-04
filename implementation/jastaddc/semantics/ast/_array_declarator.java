
package jastaddc.semantics.ast;


	/**
	 * PARSER-CONSTRAINT: Only for abstract declarator the _declarator may be left.
	 */
	
public class _array_declarator extends _declarator implements Cloneable {
    public void flushCache() {
        super.flushCache();
        BindedNameOfDeclaratorTree_visited = -1;
        TypeOfDeclaratorTree_visited = -1;
        Type_visited = -1;
        Type_computed = false;
        Type_value = null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _array_declarator clone() throws CloneNotSupportedException {
        _array_declarator node = (_array_declarator)super.clone();
        node.BindedNameOfDeclaratorTree_visited = -1;
        node.TypeOfDeclaratorTree_visited = -1;
        node.Type_visited = -1;
        node.Type_computed = false;
        node.Type_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _array_declarator copy() {
      try {
          _array_declarator node = (_array_declarator)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _array_declarator fullCopy() {
        _array_declarator res = (_array_declarator)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 93

    public _array_declarator() {
        super();

        setChild(new Opt(), 0);

    }

    // Declared in ConcreteToASTMapping.ast at line 11


    // Declared in ConcreteToASTMapping.ast line 93
    public _array_declarator(Opt<_declarator> p0, List<TypeQualifier> p1, Opt<Expression> p2) {
        setChild(p0, 0);
        setTypeQualifier(p1);
        setDimension(p2);
    }

    // Declared in ConcreteToASTMapping.ast at line 17


  protected int numChildren() {
    return 1;
  }

    // Declared in ConcreteToASTMapping.ast at line 20

  public boolean mayHaveRewrite() { return false; }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 93
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
    // Declared in ConcreteToASTMapping.ast line 93
    protected List<TypeQualifier> tokenList_TypeQualifier__TypeQualifier;

    // Declared in ConcreteToASTMapping.ast at line 3

    public void setTypeQualifier(List<TypeQualifier> value) {
        tokenList_TypeQualifier__TypeQualifier = value;
    }

    // Declared in ConcreteToASTMapping.ast at line 6

    public List<TypeQualifier> getTypeQualifier() {
        return tokenList_TypeQualifier__TypeQualifier;
    }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 93
    protected Opt<Expression> tokenOpt_Expression__Dimension;

    // Declared in ConcreteToASTMapping.ast at line 3

    public void setDimension(Opt<Expression> value) {
        tokenOpt_Expression__Dimension = value;
    }

    // Declared in ConcreteToASTMapping.ast at line 6

    public Opt<Expression> getDimension() {
        return tokenOpt_Expression__Dimension;
    }

    protected int BindedNameOfDeclaratorTree_visited = -1;
    // Declared in FinalASTNodesComputations.jrag at line 28
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
	 
    Declared in FinalASTNodesComputations.jrag at line 42
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
	 
    Declared in FinalASTNodesComputations.jrag at line 53
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

    private Type Type_compute() {  return new Array(
			getTypeQualifier(),
			/**element type:*/PreviousTypePart(),
			getDimension());  }

    // Declared in FinalASTNodesComputations.jrag at line 111
    public Type Define_Type_PreviousTypePart(ASTNode caller, ASTNode child) {
        if(caller == get_declaratorOptNoTransform()) {
            return Type();
        }
        return getParent().Define_Type_PreviousTypePart(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
