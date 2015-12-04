
package jastaddc.semantics.ast;

/**
 * The following AST parts are intermediate nodes. Their tree corresponds the one
 * of the C99 standard grammar, so the parser can construct it easily. The final
 * AST nodes form much better to understand trees, so they are easy to evaluate
 * semantical. Thus the AST parts described here have to be be rewritten to their
 * final AST nodes (e.g. DeclarationCollection, Type). They only represent an
 * intermediate state of the tree and their rewrites are the mapping of the
 * concrete syntax to the abstract syntax.
 * 
 * Names of AST nodes, which will be rewritten to map the concrete syntax to the
 * abstract one, start with an underscore (_). Their names are identical to the one
 * of the C99 standard grammar rule ([A.2.1] S.409) they represent.
 * 
 * Final AST tree parts, which are easy to construct by the parser (Statements,
 * Expressions, etc.), will be constructed directly, thus a rewrite is not neccessary.
 * 
 * IMPORTANT: If an intermediate node has final AST nodes as child nodes, these final
 * nodes must be terminal nodes of the intermediate node, thus intermediate nodes must
 * not have final AST nodes as subtree. Such "terminals" represent final AST parts
 * allready constructed, which will be used by the final AST node constructed for
 * an intermediate node. The advantages of these strategy are:
 *  - inherited attributes associated with final AST nodes don't need any equation
 *    if the final node is a terminal of an intermediate node. Thus, inherited
 *    attributes are also not avaible for "subtrees" of intermediate nodes (
 *    correct behavior, as their semantics are not specified for intermediate trees).
 *  - the "subtree terminals" of intermediate nodes can be used as child nodes of
 *    the final AST node constructed for the intermediate node. They do not have to
 *    be deeply copied and no malformed intermediate trees are constructed (if
 *    such final "subtrees" would be ordinary tree child nodes of the intermediate
 *    node, always such a "subtree" is setted as child of a newly constructed final
 *    AST node, which represents the mapping from the concrete to the abstract syntax
 *    for an intermediate node, the intermediate node's link to these final "subtree"
 *    child would be broken, resulting into null pointer exceptions or not binary
 *    mappings between intermediate parent node and "subtree" final AST node child
 *    if the "subtree" child is invoken.)
 * 
 * IMPORTANT: The attributes and methods of final AST nodes, which are terminals of
 * intermediate nodes must never be called. Their behavior is undefined (Most times
 * their invocation will result in null pointer exceptions).
 * 
 * For additional informations check the specification of the final AST ('C99AST.ast').
 * 
 * @author C. B\u00c3\u00bcrger
 */

/**
 * Declarations have to be rewritten to collections containing
 * each entity declared explicitly.
 */

public class _declaration extends _IntermediateDeclarationCollection implements Cloneable {
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
     @SuppressWarnings({"unchecked", "cast"})  public _declaration clone() throws CloneNotSupportedException {
        _declaration node = (_declaration)super.clone();
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
     @SuppressWarnings({"unchecked", "cast"})  public _declaration copy() {
      try {
          _declaration node = (_declaration)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _declaration fullCopy() {
        _declaration res = (_declaration)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 50

    public _declaration() {
        super();

        setChild(new List(), 0);
        setChild(new List(), 1);

    }

    // Declared in ConcreteToASTMapping.ast at line 12


    // Declared in ConcreteToASTMapping.ast line 50
    public _declaration(List<_declaration_specifiers> p0, List<_init_declarator> p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    // Declared in ConcreteToASTMapping.ast at line 17


  protected int numChildren() {
    return 2;
  }

    // Declared in ConcreteToASTMapping.ast at line 20

  public boolean mayHaveRewrite() { return true; }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 50
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
    // Declared in ConcreteToASTMapping.ast line 50
    public void set_init_declaratorList(List<_init_declarator> list) {
        setChild(list, 1);
    }

    // Declared in ConcreteToASTMapping.ast at line 6


    public int getNum_init_declarator() {
        return get_init_declaratorList().getNumChild();
    }

    // Declared in ConcreteToASTMapping.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public _init_declarator get_init_declarator(int i) {
        return (_init_declarator)get_init_declaratorList().getChild(i);
    }

    // Declared in ConcreteToASTMapping.ast at line 14


    public void add_init_declarator(_init_declarator node) {
        List<_init_declarator> list = get_init_declaratorList();
        list.addChild(node);
    }

    // Declared in ConcreteToASTMapping.ast at line 19


    public void set_init_declarator(_init_declarator node, int i) {
        List<_init_declarator> list = get_init_declaratorList();
        list.setChild(node, i);
    }

    // Declared in ConcreteToASTMapping.ast at line 23

    public List<_init_declarator> get_init_declarators() {
        return get_init_declaratorList();
    }

    // Declared in ConcreteToASTMapping.ast at line 26

    public List<_init_declarator> get_init_declaratorsNoTransform() {
        return get_init_declaratorListNoTransform();
    }

    // Declared in ConcreteToASTMapping.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<_init_declarator> get_init_declaratorList() {
        return (List<_init_declarator>)getChild(1);
    }

    // Declared in ConcreteToASTMapping.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<_init_declarator> get_init_declaratorListNoTransform() {
        return (List<_init_declarator>)getChildNoTransform(1);
    }

    protected int DeclarationSpecifiersBuilder_visited = -1;
    protected boolean DeclarationSpecifiersBuilder_computed = false;
    protected DeclarationSpecifiersBuilder DeclarationSpecifiersBuilder_value;
/**
	 * Provide a builder extracting all the storage class specifier, function
	 * specifier, type qualifier and type specifier informations of nodes
	 * having lists of such specifiers/qualifiers:
	 
    Declared in DeclarationSpecifiersBuilder.jrag at line 14
*/
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
/* ******************************************************* SPECIFIER/QUALIFIER ******************************************************* 
    Declared in FinalASTNodesComputations.jrag at line 126
*/
	
	/**
	 * Compute the type defined by a node's _declaration_specifiers,
	 * _specifier_qualifier or _type_specifier list:
	 */
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
    // Declared in FinalASTNodesComputations.jrag at line 189
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
/**
	 * Compute the storage class defined by a node's _declaration_specifiers or
	 * _storage_class_specifier list:
	 
    Declared in FinalASTNodesComputations.jrag at line 216
*/
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
/**
	 * Compute the function specifier defined by a node's _declaration_specifiers or
	 * _function_specifier list:
	 
    Declared in FinalASTNodesComputations.jrag at line 235
*/
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
/**
	 * Compute the declarations represented by a _declaration:
	 
    Declared in FinalASTNodesComputations.jrag at line 400
*/
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
		List<Declaration> decls = new List<Declaration>();
		// Only a taged type or an incomplete type may be declared, e.g. the declarations
		// struct {int i;};
		// struct s;
		if (getNum_init_declarator() == 0) {
			decls.add(new Declaration(
					StorageClassSpecifier(),
					FunctionSpecifier(),
					TypeSpecifierType(), /* May be incomplete type, e.g.: struct s; */
					new Opt(),
					new Opt()));
		}
		// Add all the entities declared:
		for (int i = 0; i < getNum_init_declarator(); i++)
			decls.add(get_init_declarator(i).Declaration());
		return new DeclarationCollection(decls);
	}

    // Declared in FinalASTNodesComputations.jrag at line 228
    public List<StorageClassSpecifier> Define_List_StorageClassSpecifier__StorageClassSpecifier(ASTNode caller, ASTNode child) {
        if(caller == get_init_declaratorListNoTransform()) {
      int index = caller.getIndexOfChild(child);
            return StorageClassSpecifier();
        }
        return getParent().Define_List_StorageClassSpecifier__StorageClassSpecifier(this, caller);
    }

    // Declared in FinalASTNodesComputations.jrag at line 142
    public Type Define_Type_TypeSpecifierType(ASTNode caller, ASTNode child) {
        if(caller == get_init_declaratorListNoTransform()) {
      int index = caller.getIndexOfChild(child);
            return TypeSpecifierType() instanceof TagedType ?
				// We have to consider special rules for taged types:
				(index == 0 ?
						(((TagedType)TypeSpecifierType()).IsIncompleteType() ?
								// The C source code
								// struct s e;
								// does not introduce a new incomplete structure s and an entity of this type,
								// instead it introduces a new entity e, which type is the one of a structure
								// defined before:
								((TagedType)TypeSpecifierType()).buildQualifiedReference() :
								// The C source code
								// struct s {int i;} e;
								// introduces a new structured type s and an enity e of type struct s:
								TypeSpecifierType()
						) :
						// Each declarator of a _declaration, except the first one, must only contain
						// taged type references for a tag declared in the _declaration's
						// _declaration_specifiers list. E.g. in
						// struct s {int i;} e1, e2;
						// the entity e2 will be defined using a reference to the structure s,
						// so the source code is normalized to
						// struct s {int i;} e1;
						// struct s e2;
						((TagedType)TypeSpecifierType()).buildQualifiedReference()) :
				// There are no special rules for other types than taged ones:
				TypeSpecifierType();
        }
        return getParent().Define_Type_TypeSpecifierType(this, caller);
    }

    // Declared in FinalASTNodesComputations.jrag at line 247
    public List<FunctionSpecifier> Define_List_FunctionSpecifier__FunctionSpecifier(ASTNode caller, ASTNode child) {
        if(caller == get_init_declaratorListNoTransform()) {
      int index = caller.getIndexOfChild(child);
            return FunctionSpecifier();
        }
        return getParent().Define_List_FunctionSpecifier__FunctionSpecifier(this, caller);
    }

    // Declared in FinalASTNodesComputations.jrag at line 201
    public List<TypeQualifier> Define_List_TypeQualifier__TypeQualifier(ASTNode caller, ASTNode child) {
        if(caller == get_declaration_specifiersListNoTransform()) {
      int index = caller.getIndexOfChild(child);
            return TypeQualifier();
        }
        return getParent().Define_List_TypeQualifier__TypeQualifier(this, caller);
    }

public ASTNode rewriteTo() {
    // Declared in Mapping.jrag at line 8
        state().duringMapping++;
        ASTNode result = rewriteRule0();
        state().duringMapping--;
        return result;
}

    // Declared in Mapping.jrag at line 8
    private _IntermediateDeclarationCollection rewriteRule0() {
{
			return DeclarationCollection();
		}    }
}
