
package jastaddc.semantics.ast;




public class _pointer extends ASTNode<ASTNode> implements Cloneable {
    public void flushCache() {
        super.flushCache();
        TypeOfPointerTree_visited = -1;
        Type_visited = -1;
        Type_computed = false;
        Type_value = null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _pointer clone() throws CloneNotSupportedException {
        _pointer node = (_pointer)super.clone();
        node.TypeOfPointerTree_visited = -1;
        node.Type_visited = -1;
        node.Type_computed = false;
        node.Type_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _pointer copy() {
      try {
          _pointer node = (_pointer)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _pointer fullCopy() {
        _pointer res = (_pointer)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 59

    public _pointer() {
        super();

        setChild(new Opt(), 0);

    }

    // Declared in ConcreteToASTMapping.ast at line 11


    // Declared in ConcreteToASTMapping.ast line 59
    public _pointer(List<TypeQualifier> p0, Opt<_pointer> p1) {
        setTypeQualifier(p0);
        setChild(p1, 0);
    }

    // Declared in ConcreteToASTMapping.ast at line 16


  protected int numChildren() {
    return 1;
  }

    // Declared in ConcreteToASTMapping.ast at line 19

  public boolean mayHaveRewrite() { return false; }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 59
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
    // Declared in ConcreteToASTMapping.ast line 59
    public void set_pointerOpt(Opt<_pointer> opt) {
        setChild(opt, 0);
    }

    // Declared in ConcreteToASTMapping.ast at line 6


    public boolean has_pointer() {
        return get_pointerOpt().getNumChild() != 0;
    }

    // Declared in ConcreteToASTMapping.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public _pointer get_pointer() {
        return (_pointer)get_pointerOpt().getChild(0);
    }

    // Declared in ConcreteToASTMapping.ast at line 14


    public void set_pointer(_pointer node) {
        get_pointerOpt().setChild(node, 0);
    }

    // Declared in ConcreteToASTMapping.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<_pointer> get_pointerOpt() {
        return (Opt<_pointer>)getChild(0);
    }

    // Declared in ConcreteToASTMapping.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<_pointer> get_pointerOptNoTransform() {
        return (Opt<_pointer>)getChildNoTransform(0);
    }

    protected int TypeOfPointerTree_visited = -1;
/**
	 * Compute the type represented by a pointer:
	 
    Declared in FinalASTNodesComputations.jrag at line 76
*/
 @SuppressWarnings({"unchecked", "cast"})     public Pointer TypeOfPointerTree() {
        if(TypeOfPointerTree_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: TypeOfPointerTree in class: ");
        TypeOfPointerTree_visited = state().boundariesCrossed;
        Pointer TypeOfPointerTree_value = TypeOfPointerTree_compute();
        TypeOfPointerTree_visited = -1;
        return TypeOfPointerTree_value;
    }

    private Pointer TypeOfPointerTree_compute() {  return has_pointer() ?
			get_pointer().TypeOfPointerTree() :
			Type();  }

    protected int Type_visited = -1;
    protected boolean Type_computed = false;
    protected Pointer Type_value;
    // Declared in FinalASTNodesComputations.jrag at line 80
 @SuppressWarnings({"unchecked", "cast"})     public Pointer Type() {
        if(Type_computed)
            return Type_value;
        if(Type_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Type in class: ");
        Type_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        Type_value = getParent().Define_Pointer_Type(this, null);
        if(true)
            Type_computed = true;
        Type_visited = -1;
        return Type_value;
    }

    // Declared in FinalASTNodesComputations.jrag at line 84
    public Pointer Define_Pointer_Type(ASTNode caller, ASTNode child) {
        if(caller == get_pointerOptNoTransform()) {
            return new Pointer(
			get_pointer().getTypeQualifier(),
			Type());
        }
        return getParent().Define_Pointer_Type(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
