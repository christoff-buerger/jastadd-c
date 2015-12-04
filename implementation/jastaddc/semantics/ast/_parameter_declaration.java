
package jastaddc.semantics.ast;



/**
 * The declarator can only be left, if it is an abstract_declarator.
 */

public class _parameter_declaration extends ASTNode<ASTNode> implements Cloneable {
    public void flushCache() {
        super.flushCache();
        DeclarationSpecifiersBuilder_visited = -1;
        DeclarationSpecifiersBuilder_computed = false;
        DeclarationSpecifiersBuilder_value = null;
        TypeSpecifierType_visited = -1;
        TypeQualifier_visited = -1;
        StorageClassSpecifier_visited = -1;
        FunctionSpecifier_visited = -1;
        Declaration_visited = -1;
        Declaration_computed = false;
        Declaration_value = null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _parameter_declaration clone() throws CloneNotSupportedException {
        _parameter_declaration node = (_parameter_declaration)super.clone();
        node.DeclarationSpecifiersBuilder_visited = -1;
        node.DeclarationSpecifiersBuilder_computed = false;
        node.DeclarationSpecifiersBuilder_value = null;
        node.TypeSpecifierType_visited = -1;
        node.TypeQualifier_visited = -1;
        node.StorageClassSpecifier_visited = -1;
        node.FunctionSpecifier_visited = -1;
        node.Declaration_visited = -1;
        node.Declaration_computed = false;
        node.Declaration_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _parameter_declaration copy() {
      try {
          _parameter_declaration node = (_parameter_declaration)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _parameter_declaration fullCopy() {
        _parameter_declaration res = (_parameter_declaration)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 64

    public _parameter_declaration() {
        super();

        setChild(new List(), 0);
        setChild(new Opt(), 1);

    }

    // Declared in ConcreteToASTMapping.ast at line 12


    // Declared in ConcreteToASTMapping.ast line 64
    public _parameter_declaration(List<_declaration_specifiers> p0, Opt<_declarator> p1) {
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
    // Declared in ConcreteToASTMapping.ast line 64
    public void set_declaration_specifiersList(List<_declaration_specifiers> list) {
        setChild(list, 0);
    }

    // Declared in ConcreteToASTMapping.ast at line 6


    public int getNum_declaration_specifiers() {
        return get_declaration_specifiersList().getNumChild();
    }

    // Declared in ConcreteToASTMapping.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public _declaration_specifiers get_declaration_specifiers(int i) {
        return (_declaration_specifiers)get_declaration_specifiersList().getChild(i);
    }

    // Declared in ConcreteToASTMapping.ast at line 14


    public void add_declaration_specifiers(_declaration_specifiers node) {
        List<_declaration_specifiers> list = get_declaration_specifiersList();
        list.addChild(node);
    }

    // Declared in ConcreteToASTMapping.ast at line 19


    public void set_declaration_specifiers(_declaration_specifiers node, int i) {
        List<_declaration_specifiers> list = get_declaration_specifiersList();
        list.setChild(node, i);
    }

    // Declared in ConcreteToASTMapping.ast at line 23

    public List<_declaration_specifiers> get_declaration_specifierss() {
        return get_declaration_specifiersList();
    }

    // Declared in ConcreteToASTMapping.ast at line 26

    public List<_declaration_specifiers> get_declaration_specifierssNoTransform() {
        return get_declaration_specifiersListNoTransform();
    }

    // Declared in ConcreteToASTMapping.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<_declaration_specifiers> get_declaration_specifiersList() {
        return (List<_declaration_specifiers>)getChild(0);
    }

    // Declared in ConcreteToASTMapping.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<_declaration_specifiers> get_declaration_specifiersListNoTransform() {
        return (List<_declaration_specifiers>)getChildNoTransform(0);
    }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 64
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

    protected int DeclarationSpecifiersBuilder_visited = -1;
    protected boolean DeclarationSpecifiersBuilder_computed = false;
    protected DeclarationSpecifiersBuilder DeclarationSpecifiersBuilder_value;
    // Declared in DeclarationSpecifiersBuilder.jrag at line 18
 @SuppressWarnings({"unchecked", "cast"})     public DeclarationSpecifiersBuilder DeclarationSpecifiersBuilder() {
        if(DeclarationSpecifiersBuilder_computed)
            return DeclarationSpecifiersBuilder_value;
        if(DeclarationSpecifiersBuilder_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: DeclarationSpecifiersBuilder in class: ");
        DeclarationSpecifiersBuilder_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        DeclarationSpecifiersBuilder_value = DeclarationSpecifiersBuilder_compute();
        if(isFinal && num == state().boundariesCrossed)
            DeclarationSpecifiersBuilder_computed = true;
        DeclarationSpecifiersBuilder_visited = -1;
        return DeclarationSpecifiersBuilder_value;
    }

    private DeclarationSpecifiersBuilder DeclarationSpecifiersBuilder_compute() {  return new DeclarationSpecifiersBuilder(get_declaration_specifiersList());  }

    protected int TypeSpecifierType_visited = -1;
    // Declared in FinalASTNodesComputations.jrag at line 130
 @SuppressWarnings({"unchecked", "cast"})     public Type TypeSpecifierType() {
        if(TypeSpecifierType_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: TypeSpecifierType in class: ");
        TypeSpecifierType_visited = state().boundariesCrossed;
        Type TypeSpecifierType_value = TypeSpecifierType_compute();
        TypeSpecifierType_visited = -1;
        return TypeSpecifierType_value;
    }

    private Type TypeSpecifierType_compute() {  return DeclarationSpecifiersBuilder().buildType();  }

    protected int TypeQualifier_visited = -1;
    // Declared in FinalASTNodesComputations.jrag at line 193
 @SuppressWarnings({"unchecked", "cast"})     public List<TypeQualifier> TypeQualifier() {
        if(TypeQualifier_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: TypeQualifier in class: ");
        TypeQualifier_visited = state().boundariesCrossed;
        List<TypeQualifier> TypeQualifier_value = TypeQualifier_compute();
        TypeQualifier_visited = -1;
        return TypeQualifier_value;
    }

    private List<TypeQualifier> TypeQualifier_compute() {  return DeclarationSpecifiersBuilder().buildTypeQualifier();  }

    protected int StorageClassSpecifier_visited = -1;
    // Declared in FinalASTNodesComputations.jrag at line 220
 @SuppressWarnings({"unchecked", "cast"})     public List<StorageClassSpecifier> StorageClassSpecifier() {
        if(StorageClassSpecifier_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: StorageClassSpecifier in class: ");
        StorageClassSpecifier_visited = state().boundariesCrossed;
        List<StorageClassSpecifier> StorageClassSpecifier_value = StorageClassSpecifier_compute();
        StorageClassSpecifier_visited = -1;
        return StorageClassSpecifier_value;
    }

    private List<StorageClassSpecifier> StorageClassSpecifier_compute() {  return DeclarationSpecifiersBuilder().buildStorageClassSpecifier();  }

    protected int FunctionSpecifier_visited = -1;
    // Declared in FinalASTNodesComputations.jrag at line 239
 @SuppressWarnings({"unchecked", "cast"})     public List<FunctionSpecifier> FunctionSpecifier() {
        if(FunctionSpecifier_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: FunctionSpecifier in class: ");
        FunctionSpecifier_visited = state().boundariesCrossed;
        List<FunctionSpecifier> FunctionSpecifier_value = FunctionSpecifier_compute();
        FunctionSpecifier_visited = -1;
        return FunctionSpecifier_value;
    }

    private List<FunctionSpecifier> FunctionSpecifier_compute() {  return DeclarationSpecifiersBuilder().buildFunctionSpecifier();  }

    protected int Declaration_visited = -1;
    protected boolean Declaration_computed = false;
    protected Declaration Declaration_value;
/**
	 * Compute the declaration represented by a _parameter_declaration:
	 
    Declared in FinalASTNodesComputations.jrag at line 269
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
		Opt name;
		if (has_declarator() && !get_declarator().IsAbstractDeclarator())
			name = new Opt(get_declarator().BindedNameOfDeclaratorTree());
		else name = new Opt();
		Type type;
		if (has_declarator())
			type = get_declarator().TypeOfDeclaratorTree();
		else type = TypeSpecifierType();
		return new Declaration(
				StorageClassSpecifier(),
				FunctionSpecifier(),
				type,
				name,
				new Opt());
	}

    // Declared in FinalASTNodesComputations.jrag at line 108
    public Type Define_Type_PreviousTypePart(ASTNode caller, ASTNode child) {
        if(caller == get_declaratorOptNoTransform()) {
            return TypeSpecifierType();
        }
        return getParent().Define_Type_PreviousTypePart(this, caller);
    }

    // Declared in FinalASTNodesComputations.jrag at line 205
    public List<TypeQualifier> Define_List_TypeQualifier__TypeQualifier(ASTNode caller, ASTNode child) {
        if(caller == get_declaration_specifiersListNoTransform()) {
      int index = caller.getIndexOfChild(child);
            return TypeQualifier();
        }
        return getParent().Define_List_TypeQualifier__TypeQualifier(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
