
package jastaddc.semantics.ast;


	
 	/**
 	 * A _simple_declarator represents a binded name, thus it never
 	 * represents an abstract declarator.
 	 */
	
public class _simple_declarator extends _declarator implements Cloneable {
    public void flushCache() {
        super.flushCache();
        BindedNameOfDeclaratorTree_visited = -1;
        TypeOfDeclaratorTree_visited = -1;
        Type_visited = -1;
        Type_computed = false;
        Type_value = null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _simple_declarator clone() throws CloneNotSupportedException {
        _simple_declarator node = (_simple_declarator)super.clone();
        node.BindedNameOfDeclaratorTree_visited = -1;
        node.TypeOfDeclaratorTree_visited = -1;
        node.Type_visited = -1;
        node.Type_computed = false;
        node.Type_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _simple_declarator copy() {
      try {
          _simple_declarator node = (_simple_declarator)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _simple_declarator fullCopy() {
        _simple_declarator res = (_simple_declarator)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 85

    public _simple_declarator() {
        super();


    }

    // Declared in ConcreteToASTMapping.ast at line 10


    // Declared in ConcreteToASTMapping.ast line 85
    public _simple_declarator(Identifier p0) {
        setName(p0);
    }

    // Declared in ConcreteToASTMapping.ast at line 14


  protected int numChildren() {
    return 0;
  }

    // Declared in ConcreteToASTMapping.ast at line 17

  public boolean mayHaveRewrite() { return false; }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 85
    protected Identifier tokenIdentifier_Name;

    // Declared in ConcreteToASTMapping.ast at line 3

    public void setName(Identifier value) {
        tokenIdentifier_Name = value;
    }

    // Declared in ConcreteToASTMapping.ast at line 6

    public Identifier getName() {
        return tokenIdentifier_Name;
    }

    protected int BindedNameOfDeclaratorTree_visited = -1;
    // Declared in FinalASTNodesComputations.jrag at line 25
 @SuppressWarnings({"unchecked", "cast"})     public Identifier BindedNameOfDeclaratorTree() {
        if(BindedNameOfDeclaratorTree_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: BindedNameOfDeclaratorTree in class: ");
        BindedNameOfDeclaratorTree_visited = state().boundariesCrossed;
        Identifier BindedNameOfDeclaratorTree_value = BindedNameOfDeclaratorTree_compute();
        BindedNameOfDeclaratorTree_visited = -1;
        return BindedNameOfDeclaratorTree_value;
    }

    private Identifier BindedNameOfDeclaratorTree_compute() {  return getName();  }

    protected int TypeOfDeclaratorTree_visited = -1;
/**
	 * Each declarator has a type and may be part of another declarator,
	 * but as no infinite types exist there must be a "root type" not being part
	 * of any other type:
	 
    Declared in FinalASTNodesComputations.jrag at line 39
*/
 @SuppressWarnings({"unchecked", "cast"})     public Type TypeOfDeclaratorTree() {
        if(TypeOfDeclaratorTree_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: TypeOfDeclaratorTree in class: ");
        TypeOfDeclaratorTree_visited = state().boundariesCrossed;
        Type TypeOfDeclaratorTree_value = TypeOfDeclaratorTree_compute();
        TypeOfDeclaratorTree_visited = -1;
        return TypeOfDeclaratorTree_value;
    }

    private Type TypeOfDeclaratorTree_compute() {  return Type();  }

    protected int Type_visited = -1;
    protected boolean Type_computed = false;
    protected Type Type_value;
/**
	 * Each declarator represents a type:
	 
    Declared in FinalASTNodesComputations.jrag at line 51
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

    private Type Type_compute() {  return PreviousTypePart();  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
