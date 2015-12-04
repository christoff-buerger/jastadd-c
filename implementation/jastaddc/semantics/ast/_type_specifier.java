
package jastaddc.semantics.ast;


			
		
public abstract class _type_specifier extends _specifier_qualifier implements Cloneable {
    public void flushCache() {
        super.flushCache();
        TypeQualifier_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _type_specifier clone() throws CloneNotSupportedException {
        _type_specifier node = (_type_specifier)super.clone();
        node.TypeQualifier_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 109

    public _type_specifier() {
        super();


    }

    // Declared in ConcreteToASTMapping.ast at line 9


  protected int numChildren() {
    return 0;
  }

    // Declared in ConcreteToASTMapping.ast at line 12

  public boolean mayHaveRewrite() { return false; }

    protected int TypeQualifier_visited = -1;
/**
	 * Distribute type qualifiers defined by a node's _declaration_specifiers,
	 * _specifier_qualifier or _type_qualifier list:
	 
    Declared in FinalASTNodesComputations.jrag at line 200
*/
 @SuppressWarnings({"unchecked", "cast"})     public List<TypeQualifier> TypeQualifier() {
        if(TypeQualifier_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: TypeQualifier in class: ");
        TypeQualifier_visited = state().boundariesCrossed;
        List<TypeQualifier> TypeQualifier_value = getParent().Define_List_TypeQualifier__TypeQualifier(this, null);
        TypeQualifier_visited = -1;
        return TypeQualifier_value;
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
