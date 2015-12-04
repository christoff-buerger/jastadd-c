
package jastaddc.semantics.ast;


			
public class _enum_specifier extends _type_specifier implements Cloneable {
    public void flushCache() {
        super.flushCache();
        Enumeration_visited = -1;
        Enumeration_computed = false;
        Enumeration_value = null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _enum_specifier clone() throws CloneNotSupportedException {
        _enum_specifier node = (_enum_specifier)super.clone();
        node.Enumeration_visited = -1;
        node.Enumeration_computed = false;
        node.Enumeration_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _enum_specifier copy() {
      try {
          _enum_specifier node = (_enum_specifier)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _enum_specifier fullCopy() {
        _enum_specifier res = (_enum_specifier)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 132

    public _enum_specifier() {
        super();


    }

    // Declared in ConcreteToASTMapping.ast at line 10


    // Declared in ConcreteToASTMapping.ast line 132
    public _enum_specifier(Opt<Identifier> p0, List<EnumerationElement> p1) {
        setTag(p0);
        set_enumerators(p1);
    }

    // Declared in ConcreteToASTMapping.ast at line 15


  protected int numChildren() {
    return 0;
  }

    // Declared in ConcreteToASTMapping.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 132
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
    // Declared in ConcreteToASTMapping.ast line 132
    protected List<EnumerationElement> tokenList_EnumerationElement___enumerators;

    // Declared in ConcreteToASTMapping.ast at line 3

    public void set_enumerators(List<EnumerationElement> value) {
        tokenList_EnumerationElement___enumerators = value;
    }

    // Declared in ConcreteToASTMapping.ast at line 6

    public List<EnumerationElement> get_enumerators() {
        return tokenList_EnumerationElement___enumerators;
    }

    protected int Enumeration_visited = -1;
    protected boolean Enumeration_computed = false;
    protected Enumeration Enumeration_value;
/* *********************************************************** ENUMERATIONS ********************************************************** 
    Declared in FinalASTNodesComputations.jrag at line 358
*/
	
	/**
	 * Compute the enumeration represented by an _enum_specifier:
	 */
 @SuppressWarnings({"unchecked", "cast"})     public Enumeration Enumeration() {
        if(Enumeration_computed)
            return Enumeration_value;
        if(Enumeration_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Enumeration in class: ");
        Enumeration_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        Enumeration_value = Enumeration_compute();
        if(true)
            Enumeration_computed = true;
        Enumeration_visited = -1;
        return Enumeration_value;
    }

    private Enumeration Enumeration_compute() {
		if (getTag().getNumChild() == 0)
			getTag().addChild(new Identifier(CompilationRootNode().buildAnonymousTag()));
		return new Enumeration(TypeQualifier(), getTag(), get_enumerators());
	}

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
