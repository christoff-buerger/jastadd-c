
package jastaddc.semantics.ast;



/**
 * PARSER-CONSTRAINT: The declarator must not be an abstract declarator.
 */

public class _init_declarator extends ASTNode<ASTNode> implements Cloneable {
    public void flushCache() {
        super.flushCache();
        Declaration_visited = -1;
        Declaration_computed = false;
        Declaration_value = null;
        TypeSpecifierType_visited = -1;
        TypeSpecifierType_computed = false;
        TypeSpecifierType_value = null;
        StorageClassSpecifier_visited = -1;
        FunctionSpecifier_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _init_declarator clone() throws CloneNotSupportedException {
        _init_declarator node = (_init_declarator)super.clone();
        node.Declaration_visited = -1;
        node.Declaration_computed = false;
        node.Declaration_value = null;
        node.TypeSpecifierType_visited = -1;
        node.TypeSpecifierType_computed = false;
        node.TypeSpecifierType_value = null;
        node.StorageClassSpecifier_visited = -1;
        node.FunctionSpecifier_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _init_declarator copy() {
      try {
          _init_declarator node = (_init_declarator)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _init_declarator fullCopy() {
        _init_declarator res = (_init_declarator)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 103

    public _init_declarator() {
        super();


    }

    // Declared in ConcreteToASTMapping.ast at line 10


    // Declared in ConcreteToASTMapping.ast line 103
    public _init_declarator(_declarator p0, Opt<Initializer> p1) {
        setChild(p0, 0);
        setInitializer(p1);
    }

    // Declared in ConcreteToASTMapping.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in ConcreteToASTMapping.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 103
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

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 103
    protected Opt<Initializer> tokenOpt_Initializer__Initializer;

    // Declared in ConcreteToASTMapping.ast at line 3

    public void setInitializer(Opt<Initializer> value) {
        tokenOpt_Initializer__Initializer = value;
    }

    // Declared in ConcreteToASTMapping.ast at line 6

    public Opt<Initializer> getInitializer() {
        return tokenOpt_Initializer__Initializer;
    }

    protected int Declaration_visited = -1;
    protected boolean Declaration_computed = false;
    protected Declaration Declaration_value;
/* *********************************************************** DECLARATIONS ********************************************************** 
    Declared in FinalASTNodesComputations.jrag at line 384
*/
	
	/**
	 * Compute the declaration represented by an _init_declarator:
	 */
 @SuppressWarnings({"unchecked", "cast"})     public Declaration Declaration() {
        if(Declaration_computed)
            return Declaration_value;
        if(Declaration_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Declaration in class: ");
        Declaration_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        Declaration_value = Declaration_compute();
        if(true)
            Declaration_computed = true;
        Declaration_visited = -1;
        return Declaration_value;
    }

    private Declaration Declaration_compute() {
		if (get_declarator().IsAbstractDeclarator())
			throw new jastaddc.syntax.SyntacticalFailure(
					"PARSER-CONSTRAINT: The intermediate _init_declarator child node of a _declaration must not represent an abstract declarator.\n\t"+
					"Check your parser implementation.");
		return new Declaration(
					StorageClassSpecifier(),
					FunctionSpecifier(),
					get_declarator().TypeOfDeclaratorTree(),
					new Opt<Identifier>(get_declarator().BindedNameOfDeclaratorTree()),
					getInitializer());
	}

    protected int TypeSpecifierType_visited = -1;
    protected boolean TypeSpecifierType_computed = false;
    protected Type TypeSpecifierType_value;
/**
	 * Distribute type parts specified by a node's declaration_specifiers,
	 * _specifier_qualifier or _type_specifier list:
	 
    Declared in FinalASTNodesComputations.jrag at line 141
*/
 @SuppressWarnings({"unchecked", "cast"})     public Type TypeSpecifierType() {
        if(TypeSpecifierType_computed)
            return TypeSpecifierType_value;
        if(TypeSpecifierType_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: TypeSpecifierType in class: ");
        TypeSpecifierType_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        TypeSpecifierType_value = getParent().Define_Type_TypeSpecifierType(this, null);
        if(true)
            TypeSpecifierType_computed = true;
        TypeSpecifierType_visited = -1;
        return TypeSpecifierType_value;
    }

    protected int StorageClassSpecifier_visited = -1;
/**
	 * Distribute the storage class defined by a node's _declaration_specifiers or
	 * _storage_class_specifier list:
	 
    Declared in FinalASTNodesComputations.jrag at line 227
*/
 @SuppressWarnings({"unchecked", "cast"})     public List<StorageClassSpecifier> StorageClassSpecifier() {
        if(StorageClassSpecifier_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: StorageClassSpecifier in class: ");
        StorageClassSpecifier_visited = state().boundariesCrossed;
        List<StorageClassSpecifier> StorageClassSpecifier_value = getParent().Define_List_StorageClassSpecifier__StorageClassSpecifier(this, null);
        StorageClassSpecifier_visited = -1;
        return StorageClassSpecifier_value;
    }

    protected int FunctionSpecifier_visited = -1;
/**
	 * Distribute the function specifier defined by a node's _declaration_specifiers or
	 * _function_specifier list:
	 
    Declared in FinalASTNodesComputations.jrag at line 246
*/
 @SuppressWarnings({"unchecked", "cast"})     public List<FunctionSpecifier> FunctionSpecifier() {
        if(FunctionSpecifier_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: FunctionSpecifier in class: ");
        FunctionSpecifier_visited = state().boundariesCrossed;
        List<FunctionSpecifier> FunctionSpecifier_value = getParent().Define_List_FunctionSpecifier__FunctionSpecifier(this, null);
        FunctionSpecifier_visited = -1;
        return FunctionSpecifier_value;
    }

    // Declared in FinalASTNodesComputations.jrag at line 104
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
