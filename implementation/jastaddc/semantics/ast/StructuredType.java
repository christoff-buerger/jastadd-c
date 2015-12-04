
package jastaddc.semantics.ast;


		
		/**
		 * Structures and unions may be incomplete [6.2.5:22] S.36. Incomplete
		 * structures or unions have no Element (the Element:UnionOrStructureElement*
		 * list is empty).
		 * 
		 * Incomplete structure or union types can later be rewritten/semantical
		 * evaluated to become complete.
		 */
		
public abstract class StructuredType extends TagedType implements Cloneable {
    public void flushCache() {
        super.flushCache();
        LookUpMember_String_visited = new java.util.HashMap(4);
        IsIncompleteType_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public StructuredType clone() throws CloneNotSupportedException {
        StructuredType node = (StructuredType)super.clone();
        node.LookUpMember_String_visited = new java.util.HashMap(4);
        node.IsIncompleteType_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 396

    public StructuredType() {
        super();

        setChild(new List(), 0);
        setChild(new Opt(), 1);
        setChild(new List(), 2);

    }

    // Declared in C99AST.ast at line 13


    // Declared in C99AST.ast line 396
    public StructuredType(List<TypeQualifier> p0, Opt<Identifier> p1, List<UnionOrStructureElement> p2) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
    }

    // Declared in C99AST.ast at line 19


  protected int numChildren() {
    return 3;
  }

    // Declared in C99AST.ast at line 22

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

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 375
    public void setTagOpt(Opt<Identifier> opt) {
        setChild(opt, 1);
    }

    // Declared in C99AST.ast at line 6


    public boolean hasTag() {
        return getTagOpt().getNumChild() != 0;
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Identifier getTag() {
        return (Identifier)getTagOpt().getChild(0);
    }

    // Declared in C99AST.ast at line 14


    public void setTag(Identifier node) {
        getTagOpt().setChild(node, 0);
    }

    // Declared in C99AST.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<Identifier> getTagOpt() {
        return (Opt<Identifier>)getChild(1);
    }

    // Declared in C99AST.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<Identifier> getTagOptNoTransform() {
        return (Opt<Identifier>)getChildNoTransform(1);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 396
    public void setElementList(List<UnionOrStructureElement> list) {
        setChild(list, 2);
    }

    // Declared in C99AST.ast at line 6


    public int getNumElement() {
        return getElementList().getNumChild();
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public UnionOrStructureElement getElement(int i) {
        return (UnionOrStructureElement)getElementList().getChild(i);
    }

    // Declared in C99AST.ast at line 14


    public void addElement(UnionOrStructureElement node) {
        List<UnionOrStructureElement> list = getElementList();
        list.addChild(node);
    }

    // Declared in C99AST.ast at line 19


    public void setElement(UnionOrStructureElement node, int i) {
        List<UnionOrStructureElement> list = getElementList();
        list.setChild(node, i);
    }

    // Declared in C99AST.ast at line 23

    public List<UnionOrStructureElement> getElements() {
        return getElementList();
    }

    // Declared in C99AST.ast at line 26

    public List<UnionOrStructureElement> getElementsNoTransform() {
        return getElementListNoTransform();
    }

    // Declared in C99AST.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<UnionOrStructureElement> getElementList() {
        return (List<UnionOrStructureElement>)getChild(2);
    }

    // Declared in C99AST.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<UnionOrStructureElement> getElementListNoTransform() {
        return (List<UnionOrStructureElement>)getChildNoTransform(2);
    }

    protected java.util.Map LookUpMember_String_visited;
/**
	 * Searchs for a member with a given name in a structured type.
	 
    Declared in ComponentNames.jrag at line 5
*/
 @SuppressWarnings({"unchecked", "cast"})     public UnionOrStructureElement LookUpMember(String memberToFind) {
        Object _parameters = memberToFind;
if(LookUpMember_String_visited == null) LookUpMember_String_visited = new java.util.HashMap(4);
        if(new Integer(state().boundariesCrossed).equals(LookUpMember_String_visited.get(_parameters)))
            throw new RuntimeException("Circular definition of attr: LookUpMember in class: ");
        LookUpMember_String_visited.put(_parameters, new Integer(state().boundariesCrossed));
        UnionOrStructureElement LookUpMember_String_value = LookUpMember_compute(memberToFind);
        LookUpMember_String_visited.remove(_parameters);
        return LookUpMember_String_value;
    }

    private UnionOrStructureElement LookUpMember_compute(String memberToFind) {
		if (memberToFind == null)
			return null;
		for (int i = 0; i < getNumElement(); i++) {
			UnionOrStructureElement elem = getElement(i);
			if (elem.Name().equals(memberToFind))
				return elem;
		}
		return null;
	}

    protected int IsIncompleteType_visited = -1;
/**
	 * Provide functionality to decide whether a TagedType is an
	 * incomplete type or not.
	 
    Declared in Tags.jrag at line 36
*/
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsIncompleteType() {
        if(IsIncompleteType_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsIncompleteType in class: ");
        IsIncompleteType_visited = state().boundariesCrossed;
        boolean IsIncompleteType_value = IsIncompleteType_compute();
        IsIncompleteType_visited = -1;
        return IsIncompleteType_value;
    }

    private boolean IsIncompleteType_compute() {  return getNumElement() > 0 ? false : true;  }

    // Declared in ContextInformationAccess.jrag at line 19
    public StructuredType Define_StructuredType_StructuredTypeContainingMember(ASTNode caller, ASTNode child) {
        if(caller == getElementListNoTransform()) {
      int index = caller.getIndexOfChild(child);
            return this;
        }
        return getParent().Define_StructuredType_StructuredTypeContainingMember(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
