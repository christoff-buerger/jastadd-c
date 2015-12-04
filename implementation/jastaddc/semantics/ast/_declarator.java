
package jastaddc.semantics.ast;



/**
 * For more convenient concrete trees abstract declarators are also modeled
 * by declarators having no binded name, thus declarators constructed without
 * using the rule "direct_declarator -> identifier".
 * 
 * BEWARE :
 *  - Variable array lengths are not modeled ([*]).
 *  - static storage class specifier in function array parameters are not
 *    supported. E.g.: void func(int array[static])
 *  - old style function definitions are not supported
 */

public abstract class _declarator extends ASTNode<ASTNode> implements Cloneable {
    public void flushCache() {
        super.flushCache();
        IsAbstractDeclarator_visited = -1;
        PreviousTypePart_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _declarator clone() throws CloneNotSupportedException {
        _declarator node = (_declarator)super.clone();
        node.IsAbstractDeclarator_visited = -1;
        node.PreviousTypePart_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 79

    public _declarator() {
        super();


    }

    // Declared in ConcreteToASTMapping.ast at line 9


  protected int numChildren() {
    return 0;
  }

    // Declared in ConcreteToASTMapping.ast at line 12

  public boolean mayHaveRewrite() { return false; }

    // Declared in FinalASTNodesComputations.jrag at line 24
 @SuppressWarnings({"unchecked", "cast"})     public abstract Identifier BindedNameOfDeclaratorTree();
/**
	 * Each declarator has a type and may be part of another declarator,
	 * but as no infinite types exist there must be a "root type" not being part
	 * of any other type:
	 
    Declared in FinalASTNodesComputations.jrag at line 38
*/
 @SuppressWarnings({"unchecked", "cast"})     public abstract Type TypeOfDeclaratorTree();
/**
	 * Each declarator represents a type:
	 
    Declared in FinalASTNodesComputations.jrag at line 50
*/
 @SuppressWarnings({"unchecked", "cast"})     public abstract Type Type();
    protected int IsAbstractDeclarator_visited = -1;
/* *********************************************** DECLARATORS: TYPES AND BINDED NAMES *********************************************** 
    Declared in FinalASTNodesComputations.jrag at line 22
*/
	
	/**
	 * Decide whether a declarator is an abstract declarator or not and find
	 * the name binded with a non abstract declarator:
	 */
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsAbstractDeclarator() {
        if(IsAbstractDeclarator_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsAbstractDeclarator in class: ");
        IsAbstractDeclarator_visited = state().boundariesCrossed;
        boolean IsAbstractDeclarator_value = IsAbstractDeclarator_compute();
        IsAbstractDeclarator_visited = -1;
        return IsAbstractDeclarator_value;
    }

    private boolean IsAbstractDeclarator_compute() {  return BindedNameOfDeclaratorTree() == null ? true : false;  }

    protected int PreviousTypePart_visited = -1;
/**
	 * Compute types, which are specified before a declarator, but are still
	 * part of a declarators type.
	 * 
	 * IMPORTANT: To prevent redeclaration errors of tags, it is important to
	 * transform taged types (enumeration, structure or union) defined in a list
	 * of _declaration_specifiers, _specifier_qualifier or _type_specifier to
	 * references to the type (EnumTypeReference, StructureTypeReference,
	 * UnionTypeReference) if such a taged type is the previous type part of a
	 * construct which may declare more than one entity. E.g. a declaration or a
	 * _struct_declaration may contain an arbitrary number of declarators, which
	 * all share the same _specifier_qualifier list. If each declarator's type would
	 * have a copy of the real taged type defined in the _specifier_qualifier list,
	 * a redeclaration error for the tag would result.
	 
    Declared in FinalASTNodesComputations.jrag at line 103
*/
 @SuppressWarnings({"unchecked", "cast"})     public Type PreviousTypePart() {
        if(PreviousTypePart_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: PreviousTypePart in class: ");
        PreviousTypePart_visited = state().boundariesCrossed;
        Type PreviousTypePart_value = getParent().Define_Type_PreviousTypePart(this, null);
        PreviousTypePart_visited = -1;
        return PreviousTypePart_value;
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
