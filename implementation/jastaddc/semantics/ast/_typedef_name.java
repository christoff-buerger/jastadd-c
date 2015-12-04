
package jastaddc.semantics.ast;


			
public class _typedef_name extends _type_specifier implements Cloneable {
    public void flushCache() {
        super.flushCache();
        TypedefTypeReference_visited = -1;
        TypedefTypeReference_computed = false;
        TypedefTypeReference_value = null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _typedef_name clone() throws CloneNotSupportedException {
        _typedef_name node = (_typedef_name)super.clone();
        node.TypedefTypeReference_visited = -1;
        node.TypedefTypeReference_computed = false;
        node.TypedefTypeReference_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _typedef_name copy() {
      try {
          _typedef_name node = (_typedef_name)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _typedef_name fullCopy() {
        _typedef_name res = (_typedef_name)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 133

    public _typedef_name() {
        super();


    }

    // Declared in ConcreteToASTMapping.ast at line 10


    // Declared in ConcreteToASTMapping.ast line 133
    public _typedef_name(Identifier p0) {
        setName(p0);
    }

    // Declared in ConcreteToASTMapping.ast at line 14


  protected int numChildren() {
    return 0;
  }

    // Declared in ConcreteToASTMapping.ast at line 17

  public boolean mayHaveRewrite() { return false; }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 133
    protected Identifier tokenIdentifier_Name;

    // Declared in ConcreteToASTMapping.ast at line 3

    public void setName(Identifier value) {
        tokenIdentifier_Name = value;
    }

    // Declared in ConcreteToASTMapping.ast at line 6

    public Identifier getName() {
        return tokenIdentifier_Name;
    }

    protected int TypedefTypeReference_visited = -1;
    protected boolean TypedefTypeReference_computed = false;
    protected TypedefTypeReference TypedefTypeReference_value;
/* *********************************************************** TYPEDEF NAMES ********************************************************* 
    Declared in FinalASTNodesComputations.jrag at line 368
*/
	/**
	 * Compute the type represented by a _typedef_name:
	 */
 @SuppressWarnings({"unchecked", "cast"})     public TypedefTypeReference TypedefTypeReference() {
        if(TypedefTypeReference_computed)
            return TypedefTypeReference_value;
        if(TypedefTypeReference_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: TypedefTypeReference in class: ");
        TypedefTypeReference_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        TypedefTypeReference_value = TypedefTypeReference_compute();
        if(true)
            TypedefTypeReference_computed = true;
        TypedefTypeReference_visited = -1;
        return TypedefTypeReference_value;
    }

    private TypedefTypeReference TypedefTypeReference_compute() {  return new TypedefTypeReference(TypeQualifier(), getName());  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
