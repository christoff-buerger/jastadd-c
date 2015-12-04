
package jastaddc.semantics.ast;


			/**
			 * Incomplete structure or unions ([6.2.5:22] S.36) have no
			 *_struct_declaration, thus their _struct_declaration list
			 * is empty.
			 */
			
public class _struct_or_union_specifier extends _type_specifier implements Cloneable {
    public void flushCache() {
        super.flushCache();
        StructuredType_visited = -1;
        StructuredType_computed = false;
        StructuredType_value = null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _struct_or_union_specifier clone() throws CloneNotSupportedException {
        _struct_or_union_specifier node = (_struct_or_union_specifier)super.clone();
        node.StructuredType_visited = -1;
        node.StructuredType_computed = false;
        node.StructuredType_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _struct_or_union_specifier copy() {
      try {
          _struct_or_union_specifier node = (_struct_or_union_specifier)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _struct_or_union_specifier fullCopy() {
        _struct_or_union_specifier res = (_struct_or_union_specifier)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 131

    public _struct_or_union_specifier() {
        super();

        setChild(new List(), 1);

    }

    // Declared in ConcreteToASTMapping.ast at line 11


    // Declared in ConcreteToASTMapping.ast line 131
    public _struct_or_union_specifier(_struct_or_union p0, Opt<Identifier> p1, List<_struct_declaration> p2) {
        setChild(p0, 0);
        setTag(p1);
        setChild(p2, 1);
    }

    // Declared in ConcreteToASTMapping.ast at line 17


  protected int numChildren() {
    return 2;
  }

    // Declared in ConcreteToASTMapping.ast at line 20

  public boolean mayHaveRewrite() { return false; }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 131
    public void set_struct_or_union(_struct_or_union node) {
        setChild(node, 0);
    }

    // Declared in ConcreteToASTMapping.ast at line 5

    public _struct_or_union get_struct_or_union() {
        return (_struct_or_union)getChild(0);
    }

    // Declared in ConcreteToASTMapping.ast at line 9


    public _struct_or_union get_struct_or_unionNoTransform() {
        return (_struct_or_union)getChildNoTransform(0);
    }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 131
    protected Opt<Identifier> tokenOpt_Identifier__Tag;

    // Declared in ConcreteToASTMapping.ast at line 3

    public void setTag(Opt<Identifier> value) {
        tokenOpt_Identifier__Tag = value;
    }

    // Declared in ConcreteToASTMapping.ast at line 6

    public Opt<Identifier> getTag() {
        return tokenOpt_Identifier__Tag;
    }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 131
    public void set_struct_declarationList(List<_struct_declaration> list) {
        setChild(list, 1);
    }

    // Declared in ConcreteToASTMapping.ast at line 6


    public int getNum_struct_declaration() {
        return get_struct_declarationList().getNumChild();
    }

    // Declared in ConcreteToASTMapping.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public _struct_declaration get_struct_declaration(int i) {
        return (_struct_declaration)get_struct_declarationList().getChild(i);
    }

    // Declared in ConcreteToASTMapping.ast at line 14


    public void add_struct_declaration(_struct_declaration node) {
        List<_struct_declaration> list = get_struct_declarationList();
        list.addChild(node);
    }

    // Declared in ConcreteToASTMapping.ast at line 19


    public void set_struct_declaration(_struct_declaration node, int i) {
        List<_struct_declaration> list = get_struct_declarationList();
        list.setChild(node, i);
    }

    // Declared in ConcreteToASTMapping.ast at line 23

    public List<_struct_declaration> get_struct_declarations() {
        return get_struct_declarationList();
    }

    // Declared in ConcreteToASTMapping.ast at line 26

    public List<_struct_declaration> get_struct_declarationsNoTransform() {
        return get_struct_declarationListNoTransform();
    }

    // Declared in ConcreteToASTMapping.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<_struct_declaration> get_struct_declarationList() {
        return (List<_struct_declaration>)getChild(1);
    }

    // Declared in ConcreteToASTMapping.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<_struct_declaration> get_struct_declarationListNoTransform() {
        return (List<_struct_declaration>)getChildNoTransform(1);
    }

    protected int StructuredType_visited = -1;
    protected boolean StructuredType_computed = false;
    protected StructuredType StructuredType_value;
/* ******************************************************** STRUCTURES/UNIONS ******************************************************** 
    Declared in FinalASTNodesComputations.jrag at line 291
*/
	
	/**
	 * Compute the structure or union defined by a _struct_or_union_specifier:
	 */
 @SuppressWarnings({"unchecked", "cast"})     public StructuredType StructuredType() {
        if(StructuredType_computed)
            return StructuredType_value;
        if(StructuredType_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: StructuredType in class: ");
        StructuredType_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        StructuredType_value = StructuredType_compute();
        if(true)
            StructuredType_computed = true;
        StructuredType_visited = -1;
        return StructuredType_value;
    }

    private StructuredType StructuredType_compute() {
		List<UnionOrStructureElement> elements = new List<UnionOrStructureElement>();
		for (int i = 0; i < getNum_struct_declaration(); i++) {
			for (UnionOrStructureElement elem:get_struct_declaration(i).UnionOrStructureElements())
				elements.add(elem);
		}
		if (getTag().getNumChild() == 0)
			getTag().addChild(new Identifier(CompilationRootNode().buildAnonymousTag()));
		if (get_struct_or_union() instanceof _struct) {
			return new Structure(
					TypeQualifier(),
					getTag(),
					elements);
		} else if (get_struct_or_union() instanceof _union) {
			return new Union(
					TypeQualifier(),
					getTag(),
					elements);
		} else throw new jastaddc.semantics.ConcreteToASTFailure(
				get_struct_or_union(),
				null,
				"The structured type ["+ get_struct_or_union().getClass().getName() +
				"] is unknown and can not be mapped to a ["+ StructuredType.class.getName() +"].\n\t"+
				"Complete the [syn StructuredType _struct_or_union_specifier.StructuredType()] attribute.");
	}

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
