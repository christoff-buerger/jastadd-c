
package jastaddc.semantics.ast;


/**
 * Function definitions have to be rewritten to a DeclarationCollection containing one
 * FunctionDeclaration.
 * 
 * PARSER-CONSTRAINT: The declarator must not be an abstract_declarator.
 */

public class _function_definition extends _IntermediateDeclarationCollection implements Cloneable {
    public void flushCache() {
        super.flushCache();
        DeclarationSpecifiersBuilder_visited = -1;
        DeclarationSpecifiersBuilder_computed = false;
        DeclarationSpecifiersBuilder_value = null;
        TypeSpecifierType_visited = -1;
        TypeQualifier_visited = -1;
        StorageClassSpecifier_visited = -1;
        FunctionSpecifier_visited = -1;
        DeclarationCollection_visited = -1;
        DeclarationCollection_computed = false;
        DeclarationCollection_value = null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _function_definition clone() throws CloneNotSupportedException {
        _function_definition node = (_function_definition)super.clone();
        node.DeclarationSpecifiersBuilder_visited = -1;
        node.DeclarationSpecifiersBuilder_computed = false;
        node.DeclarationSpecifiersBuilder_value = null;
        node.TypeSpecifierType_visited = -1;
        node.TypeQualifier_visited = -1;
        node.StorageClassSpecifier_visited = -1;
        node.FunctionSpecifier_visited = -1;
        node.DeclarationCollection_visited = -1;
        node.DeclarationCollection_computed = false;
        node.DeclarationCollection_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _function_definition copy() {
      try {
          _function_definition node = (_function_definition)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _function_definition fullCopy() {
        _function_definition res = (_function_definition)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 57

    public _function_definition() {
        super();

        setChild(new List(), 0);

    }

    // Declared in ConcreteToASTMapping.ast at line 11


    // Declared in ConcreteToASTMapping.ast line 57
    public _function_definition(List<_declaration_specifiers> p0, _declarator p1, CompoundStatement p2) {
        setChild(p0, 0);
        setChild(p1, 1);
        setBody(p2);
    }

    // Declared in ConcreteToASTMapping.ast at line 17


  protected int numChildren() {
    return 2;
  }

    // Declared in ConcreteToASTMapping.ast at line 20

  public boolean mayHaveRewrite() { return true; }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 57
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
    // Declared in ConcreteToASTMapping.ast line 57
    public void set_declarator(_declarator node) {
        setChild(node, 1);
    }

    // Declared in ConcreteToASTMapping.ast at line 5

    public _declarator get_declarator() {
        return (_declarator)getChild(1);
    }

    // Declared in ConcreteToASTMapping.ast at line 9


    public _declarator get_declaratorNoTransform() {
        return (_declarator)getChildNoTransform(1);
    }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 57
    protected CompoundStatement tokenCompoundStatement_Body;

    // Declared in ConcreteToASTMapping.ast at line 3

    public void setBody(CompoundStatement value) {
        tokenCompoundStatement_Body = value;
    }

    // Declared in ConcreteToASTMapping.ast at line 6

    public CompoundStatement getBody() {
        return tokenCompoundStatement_Body;
    }

    protected int DeclarationSpecifiersBuilder_visited = -1;
    protected boolean DeclarationSpecifiersBuilder_computed = false;
    protected DeclarationSpecifiersBuilder DeclarationSpecifiersBuilder_value;
    // Declared in DeclarationSpecifiersBuilder.jrag at line 16
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
    // Declared in FinalASTNodesComputations.jrag at line 128
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
    // Declared in FinalASTNodesComputations.jrag at line 191
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
    // Declared in FinalASTNodesComputations.jrag at line 218
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
    // Declared in FinalASTNodesComputations.jrag at line 237
 @SuppressWarnings({"unchecked", "cast"})     public List<FunctionSpecifier> FunctionSpecifier() {
        if(FunctionSpecifier_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: FunctionSpecifier in class: ");
        FunctionSpecifier_visited = state().boundariesCrossed;
        List<FunctionSpecifier> FunctionSpecifier_value = FunctionSpecifier_compute();
        FunctionSpecifier_visited = -1;
        return FunctionSpecifier_value;
    }

    private List<FunctionSpecifier> FunctionSpecifier_compute() {  return DeclarationSpecifiersBuilder().buildFunctionSpecifier();  }

    protected int DeclarationCollection_visited = -1;
    protected boolean DeclarationCollection_computed = false;
    protected DeclarationCollection DeclarationCollection_value;
    // Declared in FinalASTNodesComputations.jrag at line 421
 @SuppressWarnings({"unchecked", "cast"})     public DeclarationCollection DeclarationCollection() {
        if(DeclarationCollection_computed)
            return DeclarationCollection_value;
        if(DeclarationCollection_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: DeclarationCollection in class: ");
        DeclarationCollection_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        DeclarationCollection_value = DeclarationCollection_compute();
        if(true)
            DeclarationCollection_computed = true;
        DeclarationCollection_visited = -1;
        return DeclarationCollection_value;
    }

    private DeclarationCollection DeclarationCollection_compute() {
		if (get_declarator().IsAbstractDeclarator())
			throw new jastaddc.syntax.SyntacticalFailure(
					"PARSER-CONSTRAINT: The intermediate _declarator child node of a _function_definition must not represent an abstract declarator.\n\t"+
					"Check your parser implementation.");
		return new DeclarationCollection(new List<Declaration>().add(
				new Declaration(
						StorageClassSpecifier(),
						FunctionSpecifier(),
						get_declarator().TypeOfDeclaratorTree(),
						new Opt(get_declarator().BindedNameOfDeclaratorTree()),
						new Opt(new FunctionDefinitionInitializer(getBody())))));
	}

    // Declared in FinalASTNodesComputations.jrag at line 106
    public Type Define_Type_PreviousTypePart(ASTNode caller, ASTNode child) {
        if(caller == get_declaratorNoTransform()) {
            return TypeSpecifierType();
        }
        return getParent().Define_Type_PreviousTypePart(this, caller);
    }

    // Declared in FinalASTNodesComputations.jrag at line 203
    public List<TypeQualifier> Define_List_TypeQualifier__TypeQualifier(ASTNode caller, ASTNode child) {
        if(caller == get_declaration_specifiersListNoTransform()) {
      int index = caller.getIndexOfChild(child);
            return TypeQualifier();
        }
        return getParent().Define_List_TypeQualifier__TypeQualifier(this, caller);
    }

public ASTNode rewriteTo() {
    // Declared in Mapping.jrag at line 14
        state().duringMapping++;
        ASTNode result = rewriteRule0();
        state().duringMapping--;
        return result;
}

    // Declared in Mapping.jrag at line 14
    private _IntermediateDeclarationCollection rewriteRule0() {
{
			return DeclarationCollection();
		}    }
}
