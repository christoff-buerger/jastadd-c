
package jastaddc.semantics.ast;




public class _struct_declaration extends ASTNode<ASTNode> implements Cloneable {
    public void flushCache() {
        super.flushCache();
        DeclarationSpecifiersBuilder_visited = -1;
        DeclarationSpecifiersBuilder_computed = false;
        DeclarationSpecifiersBuilder_value = null;
        TypeSpecifierType_visited = -1;
        TypeQualifier_visited = -1;
        UnionOrStructureElements_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _struct_declaration clone() throws CloneNotSupportedException {
        _struct_declaration node = (_struct_declaration)super.clone();
        node.DeclarationSpecifiersBuilder_visited = -1;
        node.DeclarationSpecifiersBuilder_computed = false;
        node.DeclarationSpecifiersBuilder_value = null;
        node.TypeSpecifierType_visited = -1;
        node.TypeQualifier_visited = -1;
        node.UnionOrStructureElements_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _struct_declaration copy() {
      try {
          _struct_declaration node = (_struct_declaration)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _struct_declaration fullCopy() {
        _struct_declaration res = (_struct_declaration)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 140

    public _struct_declaration() {
        super();

        setChild(new List(), 0);
        setChild(new List(), 1);

    }

    // Declared in ConcreteToASTMapping.ast at line 12


    // Declared in ConcreteToASTMapping.ast line 140
    public _struct_declaration(List<_specifier_qualifier> p0, List<_struct_declarator> p1) {
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
    // Declared in ConcreteToASTMapping.ast line 140
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
    // Declared in ConcreteToASTMapping.ast line 140
    public void set_struct_declaratorList(List<_struct_declarator> list) {
        setChild(list, 1);
    }

    // Declared in ConcreteToASTMapping.ast at line 6


    public int getNum_struct_declarator() {
        return get_struct_declaratorList().getNumChild();
    }

    // Declared in ConcreteToASTMapping.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public _struct_declarator get_struct_declarator(int i) {
        return (_struct_declarator)get_struct_declaratorList().getChild(i);
    }

    // Declared in ConcreteToASTMapping.ast at line 14


    public void add_struct_declarator(_struct_declarator node) {
        List<_struct_declarator> list = get_struct_declaratorList();
        list.addChild(node);
    }

    // Declared in ConcreteToASTMapping.ast at line 19


    public void set_struct_declarator(_struct_declarator node, int i) {
        List<_struct_declarator> list = get_struct_declaratorList();
        list.setChild(node, i);
    }

    // Declared in ConcreteToASTMapping.ast at line 23

    public List<_struct_declarator> get_struct_declarators() {
        return get_struct_declaratorList();
    }

    // Declared in ConcreteToASTMapping.ast at line 26

    public List<_struct_declarator> get_struct_declaratorsNoTransform() {
        return get_struct_declaratorListNoTransform();
    }

    // Declared in ConcreteToASTMapping.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<_struct_declarator> get_struct_declaratorList() {
        return (List<_struct_declarator>)getChild(1);
    }

    // Declared in ConcreteToASTMapping.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<_struct_declarator> get_struct_declaratorListNoTransform() {
        return (List<_struct_declarator>)getChildNoTransform(1);
    }

    protected int DeclarationSpecifiersBuilder_visited = -1;
    protected boolean DeclarationSpecifiersBuilder_computed = false;
    protected DeclarationSpecifiersBuilder DeclarationSpecifiersBuilder_value;
    // Declared in DeclarationSpecifiersBuilder.jrag at line 22
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
    // Declared in FinalASTNodesComputations.jrag at line 132
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
/**
	 * Compute the type qualifiers defined by a node's _declaration_specifiers,
	 * _specifier_qualifier or _type_qualifier list:
	 
    Declared in FinalASTNodesComputations.jrag at line 185
*/
 @SuppressWarnings({"unchecked", "cast"})     public List<TypeQualifier> TypeQualifier() {
        if(TypeQualifier_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: TypeQualifier in class: ");
        TypeQualifier_visited = state().boundariesCrossed;
        List<TypeQualifier> TypeQualifier_value = TypeQualifier_compute();
        TypeQualifier_visited = -1;
        return TypeQualifier_value;
    }

    private List<TypeQualifier> TypeQualifier_compute() {  return DeclarationSpecifiersBuilder().buildTypeQualifier();  }

    protected int UnionOrStructureElements_visited = -1;
/**
	 * Compute the members declared in a declaration being part of a structure or union:
	 
    Declared in FinalASTNodesComputations.jrag at line 320
*/
 @SuppressWarnings({"unchecked", "cast"})     public java.util.List<UnionOrStructureElement> UnionOrStructureElements() {
        if(UnionOrStructureElements_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: UnionOrStructureElements in class: ");
        UnionOrStructureElements_visited = state().boundariesCrossed;
        java.util.List<UnionOrStructureElement> UnionOrStructureElements_value = UnionOrStructureElements_compute();
        UnionOrStructureElements_visited = -1;
        return UnionOrStructureElements_value;
    }

    private java.util.List<UnionOrStructureElement> UnionOrStructureElements_compute() {
		java.util.List<UnionOrStructureElement> result =
			new java.util.LinkedList<UnionOrStructureElement>();
		for (int i = 0; i < getNum_struct_declarator(); i++)
			result.add(get_struct_declarator(i).UnionOrStructureElement());
		return result;
	}

    // Declared in FinalASTNodesComputations.jrag at line 171
    public Type Define_Type_TypeSpecifierType(ASTNode caller, ASTNode child) {
        if(caller == get_struct_declaratorListNoTransform()) {
      int index = caller.getIndexOfChild(child);
            return TypeSpecifierType() instanceof TagedType ?
				(index == 0 ?
						(((TagedType)TypeSpecifierType()).IsIncompleteType() ?
								((TagedType)TypeSpecifierType()).buildQualifiedReference() :
								TypeSpecifierType()
						) :
						((TagedType)TypeSpecifierType()).buildQualifiedReference()) :
				TypeSpecifierType();
        }
        return getParent().Define_Type_TypeSpecifierType(this, caller);
    }

    // Declared in FinalASTNodesComputations.jrag at line 207
    public List<TypeQualifier> Define_List_TypeQualifier__TypeQualifier(ASTNode caller, ASTNode child) {
        if(caller == get_specifier_qualifierListNoTransform()) {
      int index = caller.getIndexOfChild(child);
            return TypeQualifier();
        }
        return getParent().Define_List_TypeQualifier__TypeQualifier(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
