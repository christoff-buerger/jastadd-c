
package jastaddc.semantics.ast;


		
public class Enumeration extends TagedType implements Cloneable {
    public void flushCache() {
        super.flushCache();
        Name_visited = -1;
        ReadableTypeName_visited = -1;
        buildQualifiedReference_visited = -1;
        IsIncompleteType_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Enumeration clone() throws CloneNotSupportedException {
        Enumeration node = (Enumeration)super.clone();
        node.Name_visited = -1;
        node.ReadableTypeName_visited = -1;
        node.buildQualifiedReference_visited = -1;
        node.IsIncompleteType_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Enumeration copy() {
      try {
          Enumeration node = (Enumeration)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Enumeration fullCopy() {
        Enumeration res = (Enumeration)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 376

    public Enumeration() {
        super();

        setChild(new List(), 0);
        setChild(new Opt(), 1);
        setChild(new List(), 2);

    }

    // Declared in C99AST.ast at line 13


    // Declared in C99AST.ast line 376
    public Enumeration(List<TypeQualifier> p0, Opt<Identifier> p1, List<EnumerationElement> p2) {
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
    // Declared in C99AST.ast line 376
    public void setEnumerationElementList(List<EnumerationElement> list) {
        setChild(list, 2);
    }

    // Declared in C99AST.ast at line 6


    public int getNumEnumerationElement() {
        return getEnumerationElementList().getNumChild();
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public EnumerationElement getEnumerationElement(int i) {
        return (EnumerationElement)getEnumerationElementList().getChild(i);
    }

    // Declared in C99AST.ast at line 14


    public void addEnumerationElement(EnumerationElement node) {
        List<EnumerationElement> list = getEnumerationElementList();
        list.addChild(node);
    }

    // Declared in C99AST.ast at line 19


    public void setEnumerationElement(EnumerationElement node, int i) {
        List<EnumerationElement> list = getEnumerationElementList();
        list.setChild(node, i);
    }

    // Declared in C99AST.ast at line 23

    public List<EnumerationElement> getEnumerationElements() {
        return getEnumerationElementList();
    }

    // Declared in C99AST.ast at line 26

    public List<EnumerationElement> getEnumerationElementsNoTransform() {
        return getEnumerationElementListNoTransform();
    }

    // Declared in C99AST.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<EnumerationElement> getEnumerationElementList() {
        return (List<EnumerationElement>)getChild(2);
    }

    // Declared in C99AST.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<EnumerationElement> getEnumerationElementListNoTransform() {
        return (List<EnumerationElement>)getChildNoTransform(2);
    }

    protected int Name_visited = -1;
    // Declared in Names.jrag at line 8
 @SuppressWarnings({"unchecked", "cast"})     public String Name() {
        if(Name_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Name in class: ");
        Name_visited = state().boundariesCrossed;
        String Name_value = Name_compute();
        Name_visited = -1;
        return Name_value;
    }

    private String Name_compute() {  return hasTag() ? getTag().Name() : "§Anonymous Enumeration Type "+ NodeAddress().toString() +"§";  }

    protected int ReadableTypeName_visited = -1;
/**
	 * Provide functionality to print human readable type descriptions.
	 
    Declared in ReadableTypeNames.jrag at line 42
*/
 @SuppressWarnings({"unchecked", "cast"})     public String ReadableTypeName() {
        if(ReadableTypeName_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ReadableTypeName in class: ");
        ReadableTypeName_visited = state().boundariesCrossed;
        String ReadableTypeName_value = ReadableTypeName_compute();
        ReadableTypeName_visited = -1;
        return ReadableTypeName_value;
    }

    private String ReadableTypeName_compute() {
		StringBuilder result = new StringBuilder();
		result.append("enumartion ");
		if (hasTag()) {
			result.append("named [");
			result.append(Name());
			result.append("] ");
		}
		result.append("with [");
		result.append(getNumEnumerationElement());
		result.append("] elements");
		if (getNumEnumerationElement() > 0) {
			result.append(" named {");
			for (int i = 0; i < getNumEnumerationElement(); i++) {
				result.append(getEnumerationElement(i).Name());
				result.append(", ");
			}
			result.deleteCharAt(result.length() - 1);
			result.deleteCharAt(result.length() - 1);
			result.append('}');
		}
		return result.toString();
	}

    protected int buildQualifiedReference_visited = -1;
/**
	 * Support the construction of reference nodes to taged types:
	 
    Declared in CompilerAPI.jrag at line 459
*/
 @SuppressWarnings({"unchecked", "cast"})     public Type buildQualifiedReference() {
        if(buildQualifiedReference_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: buildQualifiedReference in class: ");
        buildQualifiedReference_visited = state().boundariesCrossed;
        Type buildQualifiedReference_value = buildQualifiedReference_compute();
        buildQualifiedReference_visited = -1;
        return buildQualifiedReference_value;
    }

    private Type buildQualifiedReference_compute() {  return new EnumTypeReference(buildTypeQualifierCopy(), new Identifier(Name()));  }

    protected int IsIncompleteType_visited = -1;
/**
	 * Support to decide whether a TagedType is an incomplete type or not.
	 
    Declared in Tags.jrag at line 35
*/
	// Enumerations can never be incomplete [6.7.2.3:7] S 107.
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsIncompleteType() {
        if(IsIncompleteType_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsIncompleteType in class: ");
        IsIncompleteType_visited = state().boundariesCrossed;
        boolean IsIncompleteType_value = IsIncompleteType_compute();
        IsIncompleteType_visited = -1;
        return IsIncompleteType_value;
    }

    private boolean IsIncompleteType_compute() {  return false;  }

    // Declared in ContextInformationAccess.jrag at line 18
    public Enumeration Define_Enumeration_EnumerationContainingElement(ASTNode caller, ASTNode child) {
        if(caller == getEnumerationElementListNoTransform()) {
      int index = caller.getIndexOfChild(child);
            return this;
        }
        return getParent().Define_Enumeration_EnumerationContainingElement(this, caller);
    }

    // Declared in Enumerations.jrag at line 44
    public EnumerationElement Define_EnumerationElement_PreviousElement(ASTNode caller, ASTNode child) {
        if(caller == getEnumerationElementListNoTransform()) {
      int index = caller.getIndexOfChild(child);
            return index > 0 ? getEnumerationElement(index - 1) : null;
        }
        return getParent().Define_EnumerationElement_PreviousElement(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
