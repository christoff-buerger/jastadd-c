
package jastaddc.semantics.ast;


/**
 * Types represent "type-names" [6.7.6] S. 122.
 * 
 * Each type may be qualified with an arbitrary combination of qualifiers [6.2.5:25] S.36,
 * [6.7.3] S.108, thus a TypeQualifier may specify several qualifications. The order of
 * the qualifications doesn't matter [6.7.3:9] S. 109. If the same qualifier appears
 * more than once, the behavior is the same as if it appeared only once [6.7.3:4] S. 108.
 * A type may have no type qualifiers at all.
 */

public abstract class Type extends _IntermediateType implements Cloneable {
    public void flushCache() {
        super.flushCache();
        IsQualifiedBy_TypeQualifier_visited = new java.util.HashMap(4);
        RetrieveFinalNode_visited = -1;
        IsIntegerType_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Type clone() throws CloneNotSupportedException {
        Type node = (Type)super.clone();
        node.IsQualifiedBy_TypeQualifier_visited = new java.util.HashMap(4);
        node.RetrieveFinalNode_visited = -1;
        node.IsIntegerType_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 214

    public Type() {
        super();

        setChild(new List(), 0);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 214
    public Type(List<TypeQualifier> p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 214
    public void setTypeQualifierList(List<TypeQualifier> list) {
        setChild(list, 0);
    }

    // Declared in C99AST.ast at line 6


    public int getNumTypeQualifier() {
        return getTypeQualifierList().getNumChild();
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public TypeQualifier getTypeQualifier(int i) {
        return (TypeQualifier)getTypeQualifierList().getChild(i);
    }

    // Declared in C99AST.ast at line 14


    public void addTypeQualifier(TypeQualifier node) {
        List<TypeQualifier> list = getTypeQualifierList();
        list.addChild(node);
    }

    // Declared in C99AST.ast at line 19


    public void setTypeQualifier(TypeQualifier node, int i) {
        List<TypeQualifier> list = getTypeQualifierList();
        list.setChild(node, i);
    }

    // Declared in C99AST.ast at line 23

    public List<TypeQualifier> getTypeQualifiers() {
        return getTypeQualifierList();
    }

    // Declared in C99AST.ast at line 26

    public List<TypeQualifier> getTypeQualifiersNoTransform() {
        return getTypeQualifierListNoTransform();
    }

    // Declared in C99AST.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<TypeQualifier> getTypeQualifierList() {
        return (List<TypeQualifier>)getChild(0);
    }

    // Declared in C99AST.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<TypeQualifier> getTypeQualifierListNoTransform() {
        return (List<TypeQualifier>)getChildNoTransform(0);
    }

/**
	 * Provide functionality to print human readable type descriptions.
	 
    Declared in CompilerAPI.jrag at line 178
*/
 @SuppressWarnings({"unchecked", "cast"})     public abstract String ReadableTypeName();
    protected java.util.Map IsQualifiedBy_TypeQualifier_visited;
    // Declared in SpecifierQualifierInformation.jrag at line 23
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsQualifiedBy(TypeQualifier qual) {
        Object _parameters = qual;
if(IsQualifiedBy_TypeQualifier_visited == null) IsQualifiedBy_TypeQualifier_visited = new java.util.HashMap(4);
        if(new Integer(state().boundariesCrossed).equals(IsQualifiedBy_TypeQualifier_visited.get(_parameters)))
            throw new RuntimeException("Circular definition of attr: IsQualifiedBy in class: ");
        IsQualifiedBy_TypeQualifier_visited.put(_parameters, new Integer(state().boundariesCrossed));
        boolean IsQualifiedBy_TypeQualifier_value = IsQualifiedBy_compute(qual);
        IsQualifiedBy_TypeQualifier_visited.remove(_parameters);
        return IsQualifiedBy_TypeQualifier_value;
    }

    private boolean IsQualifiedBy_compute(TypeQualifier qual) {
		if (qual == null)
			return false;
		for (int i = 0; i < getNumTypeQualifier(); i++)
			if (qual.getClass().isInstance(getTypeQualifier(i)))
				return true;
		return false;
	}

    protected int RetrieveFinalNode_visited = -1;
/**
	 * Nodes representing Types have to be mapped:
	 
    Declared in CompilerAPI.jrag at line 39
*/
 @SuppressWarnings({"unchecked", "cast"})     public Type RetrieveFinalNode() {
        if(RetrieveFinalNode_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: RetrieveFinalNode in class: ");
        RetrieveFinalNode_visited = state().boundariesCrossed;
        Type RetrieveFinalNode_value = RetrieveFinalNode_compute();
        RetrieveFinalNode_visited = -1;
        return RetrieveFinalNode_value;
    }

    private Type RetrieveFinalNode_compute() {  return this;  }

    protected int IsIntegerType_visited = -1;
    // Declared in basics.jrag at line 3
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsIntegerType() {
        if(IsIntegerType_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsIntegerType in class: ");
        IsIntegerType_visited = state().boundariesCrossed;
        boolean IsIntegerType_value = IsIntegerType_compute();
        IsIntegerType_visited = -1;
        return IsIntegerType_value;
    }

    private boolean IsIntegerType_compute() {  return false;  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
