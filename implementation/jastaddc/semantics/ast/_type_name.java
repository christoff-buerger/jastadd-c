
package jastaddc.semantics.ast;



/**
 * type_name's represent C99 types (e.g. in cast or sizeof expressions).
 * A type_name has to be rewritten to represent a Type node.
 * 
 * PARSER-CONSTRAINT: The declarator must be an abstract_declarator.
 */

public class _type_name extends _IntermediateType implements Cloneable {
    public void flushCache() {
        super.flushCache();
        DeclarationSpecifiersBuilder_visited = -1;
        DeclarationSpecifiersBuilder_computed = false;
        DeclarationSpecifiersBuilder_value = null;
        TypeSpecifierType_visited = -1;
        TypeQualifier_visited = -1;
        Type_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _type_name clone() throws CloneNotSupportedException {
        _type_name node = (_type_name)super.clone();
        node.DeclarationSpecifiersBuilder_visited = -1;
        node.DeclarationSpecifiersBuilder_computed = false;
        node.DeclarationSpecifiersBuilder_value = null;
        node.TypeSpecifierType_visited = -1;
        node.TypeQualifier_visited = -1;
        node.Type_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _type_name copy() {
      try {
          _type_name node = (_type_name)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _type_name fullCopy() {
        _type_name res = (_type_name)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 156

    public _type_name() {
        super();

        setChild(new List(), 0);
        setChild(new Opt(), 1);

    }

    // Declared in ConcreteToASTMapping.ast at line 12


    // Declared in ConcreteToASTMapping.ast line 156
    public _type_name(List<_specifier_qualifier> p0, Opt<_declarator> p1) {
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
    // Declared in ConcreteToASTMapping.ast line 156
    public void set_specifier_qualifierList(List<_specifier_qualifier> list) {
        setChild(list, 0);
    }

    // Declared in ConcreteToASTMapping.ast at line 6


    public int getNum_specifier_qualifier() {
        return get_specifier_qualifierList().getNumChild();
    }

    // Declared in ConcreteToASTMapping.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public _specifier_qualifier get_specifier_qualifier(int i) {
        return (_specifier_qualifier)get_specifier_qualifierList().getChild(i);
    }

    // Declared in ConcreteToASTMapping.ast at line 14


    public void add_specifier_qualifier(_specifier_qualifier node) {
        List<_specifier_qualifier> list = get_specifier_qualifierList();
        list.addChild(node);
    }

    // Declared in ConcreteToASTMapping.ast at line 19


    public void set_specifier_qualifier(_specifier_qualifier node, int i) {
        List<_specifier_qualifier> list = get_specifier_qualifierList();
        list.setChild(node, i);
    }

    // Declared in ConcreteToASTMapping.ast at line 23

    public List<_specifier_qualifier> get_specifier_qualifiers() {
        return get_specifier_qualifierList();
    }

    // Declared in ConcreteToASTMapping.ast at line 26

    public List<_specifier_qualifier> get_specifier_qualifiersNoTransform() {
        return get_specifier_qualifierListNoTransform();
    }

    // Declared in ConcreteToASTMapping.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<_specifier_qualifier> get_specifier_qualifierList() {
        return (List<_specifier_qualifier>)getChild(0);
    }

    // Declared in ConcreteToASTMapping.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<_specifier_qualifier> get_specifier_qualifierListNoTransform() {
        return (List<_specifier_qualifier>)getChildNoTransform(0);
    }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 156
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
    // Declared in DeclarationSpecifiersBuilder.jrag at line 20
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

    private DeclarationSpecifiersBuilder DeclarationSpecifiersBuilder_compute() {  return new DeclarationSpecifiersBuilder(get_specifier_qualifierList());  }

    protected int TypeSpecifierType_visited = -1;
    // Declared in FinalASTNodesComputations.jrag at line 134
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
    // Declared in FinalASTNodesComputations.jrag at line 187
 @SuppressWarnings({"unchecked", "cast"})     public List<TypeQualifier> TypeQualifier() {
        if(TypeQualifier_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: TypeQualifier in class: ");
        TypeQualifier_visited = state().boundariesCrossed;
        List<TypeQualifier> TypeQualifier_value = TypeQualifier_compute();
        TypeQualifier_visited = -1;
        return TypeQualifier_value;
    }

    private List<TypeQualifier> TypeQualifier_compute() {  return DeclarationSpecifiersBuilder().buildTypeQualifier();  }

    protected int Type_visited = -1;
/* ************************************************************ TYPE NAMES *********************************************************** 
    Declared in FinalASTNodesComputations.jrag at line 376
*/
	
	/**
	 * Compute the type represented by a _type_name:
	 */
 @SuppressWarnings({"unchecked", "cast"})     public Type Type() {
        if(Type_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Type in class: ");
        Type_visited = state().boundariesCrossed;
        Type Type_value = Type_compute();
        Type_visited = -1;
        return Type_value;
    }

    private Type Type_compute() {  return has_declarator() ? get_declarator().TypeOfDeclaratorTree() : TypeSpecifierType();  }

    // Declared in FinalASTNodesComputations.jrag at line 117
    public Type Define_Type_PreviousTypePart(ASTNode caller, ASTNode child) {
        if(caller == get_declaratorOptNoTransform()) {
            return TypeSpecifierType();
        }
        return getParent().Define_Type_PreviousTypePart(this, caller);
    }

    // Declared in FinalASTNodesComputations.jrag at line 209
    public List<TypeQualifier> Define_List_TypeQualifier__TypeQualifier(ASTNode caller, ASTNode child) {
        if(caller == get_specifier_qualifierListNoTransform()) {
      int index = caller.getIndexOfChild(child);
            return TypeQualifier();
        }
        return getParent().Define_List_TypeQualifier__TypeQualifier(this, caller);
    }

public ASTNode rewriteTo() {
    // Declared in Mapping.jrag at line 20
        state().duringMapping++;
        ASTNode result = rewriteRule0();
        state().duringMapping--;
        return result;
}

    // Declared in Mapping.jrag at line 20
    private _IntermediateType rewriteRule0() {
{
			return Type();
		}    }
}
