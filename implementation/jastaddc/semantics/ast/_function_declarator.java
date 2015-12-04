
package jastaddc.semantics.ast;


	/**
	 * PARSER-CONSTRAINT: Only for abstract declarator the _parameter_type_list
	 * and/or _declarator may be left.
	 */
	
public class _function_declarator extends _declarator implements Cloneable {
    public void flushCache() {
        super.flushCache();
        BindedNameOfDeclaratorTree_visited = -1;
        TypeOfDeclaratorTree_visited = -1;
        Type_visited = -1;
        Type_computed = false;
        Type_value = null;
        Parameters_visited = -1;
        Parameters_computed = false;
        Parameters_value = null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _function_declarator clone() throws CloneNotSupportedException {
        _function_declarator node = (_function_declarator)super.clone();
        node.BindedNameOfDeclaratorTree_visited = -1;
        node.TypeOfDeclaratorTree_visited = -1;
        node.Type_visited = -1;
        node.Type_computed = false;
        node.Type_value = null;
        node.Parameters_visited = -1;
        node.Parameters_computed = false;
        node.Parameters_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _function_declarator copy() {
      try {
          _function_declarator node = (_function_declarator)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _function_declarator fullCopy() {
        _function_declarator res = (_function_declarator)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 98

    public _function_declarator() {
        super();

        setChild(new Opt(), 0);
        setChild(new Opt(), 1);

    }

    // Declared in ConcreteToASTMapping.ast at line 12


    // Declared in ConcreteToASTMapping.ast line 98
    public _function_declarator(Opt<_declarator> p0, Opt<_parameter_type_list> p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    // Declared in ConcreteToASTMapping.ast at line 17


  protected int numChildren() {
    return 2;
  }

    // Declared in ConcreteToASTMapping.ast at line 20

  public boolean mayHaveRewrite() { return false; }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 98
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
    // Declared in ConcreteToASTMapping.ast line 98
    public void set_parameter_type_listOpt(Opt<_parameter_type_list> opt) {
        setChild(opt, 1);
    }

    // Declared in ConcreteToASTMapping.ast at line 6


    public boolean has_parameter_type_list() {
        return get_parameter_type_listOpt().getNumChild() != 0;
    }

    // Declared in ConcreteToASTMapping.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public _parameter_type_list get_parameter_type_list() {
        return (_parameter_type_list)get_parameter_type_listOpt().getChild(0);
    }

    // Declared in ConcreteToASTMapping.ast at line 14


    public void set_parameter_type_list(_parameter_type_list node) {
        get_parameter_type_listOpt().setChild(node, 0);
    }

    // Declared in ConcreteToASTMapping.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<_parameter_type_list> get_parameter_type_listOpt() {
        return (Opt<_parameter_type_list>)getChild(1);
    }

    // Declared in ConcreteToASTMapping.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<_parameter_type_list> get_parameter_type_listOptNoTransform() {
        return (Opt<_parameter_type_list>)getChildNoTransform(1);
    }

    protected int BindedNameOfDeclaratorTree_visited = -1;
    // Declared in FinalASTNodesComputations.jrag at line 30
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
	 
    Declared in FinalASTNodesComputations.jrag at line 44
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
	 
    Declared in FinalASTNodesComputations.jrag at line 57
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

    private Type Type_compute() {  return (has_parameter_type_list() ? (
			get_parameter_type_list().getIsVariadicFunction() ?
					new VariadicFunction(
							new List(), // Function types itself are never qualified.
							/**return type:*/PreviousTypePart(),
							Parameters()) :
					new NormalFunction(
							new List(), // Function types itself are never qualified.
							/**return type:*/PreviousTypePart(),
							Parameters())) :
			new NormalFunction(
					new List(), // Function types itself are never qualified.
					/**return type:*/PreviousTypePart(),
					Parameters()));  }

    protected int Parameters_visited = -1;
    protected boolean Parameters_computed = false;
    protected List<Declaration> Parameters_value;
/* ******************************************************** FUNCTION PARAMETERS ****************************************************** 
    Declared in FinalASTNodesComputations.jrag at line 255
*/
	
	/**
	 * Compute the parameters of a function type:
	 */
 @SuppressWarnings({"unchecked", "cast"})     public List<Declaration> Parameters() {
        if(Parameters_computed)
            return Parameters_value;
        if(Parameters_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Parameters in class: ");
        Parameters_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        Parameters_value = Parameters_compute();
        if(true)
            Parameters_computed = true;
        Parameters_visited = -1;
        return Parameters_value;
    }

    private List<Declaration> Parameters_compute() {  return has_parameter_type_list() ?
				get_parameter_type_list().Parameters() :
				new List<Declaration>();  }

    // Declared in FinalASTNodesComputations.jrag at line 112
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
