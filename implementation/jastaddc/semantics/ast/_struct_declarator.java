
package jastaddc.semantics.ast;



/**
 * PARSER-CONSTRAINT: The declarator must not be an abstract_declarator.
 */

public abstract class _struct_declarator extends ASTNode<ASTNode> implements Cloneable {
    public void flushCache() {
        super.flushCache();
        TypeSpecifierType_visited = -1;
        TypeSpecifierType_computed = false;
        TypeSpecifierType_value = null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _struct_declarator clone() throws CloneNotSupportedException {
        _struct_declarator node = (_struct_declarator)super.clone();
        node.TypeSpecifierType_visited = -1;
        node.TypeSpecifierType_computed = false;
        node.TypeSpecifierType_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 145

    public _struct_declarator() {
        super();


    }

    // Declared in ConcreteToASTMapping.ast at line 9


  protected int numChildren() {
    return 0;
  }

    // Declared in ConcreteToASTMapping.ast at line 12

  public boolean mayHaveRewrite() { return false; }

/**
	 * Compute the type and binding of a structure or union element:
	 
    Declared in FinalASTNodesComputations.jrag at line 331
*/
 @SuppressWarnings({"unchecked", "cast"})     public abstract UnionOrStructureElement UnionOrStructureElement();
    protected int TypeSpecifierType_visited = -1;
    protected boolean TypeSpecifierType_computed = false;
    protected Type TypeSpecifierType_value;
    // Declared in FinalASTNodesComputations.jrag at line 170
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

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
