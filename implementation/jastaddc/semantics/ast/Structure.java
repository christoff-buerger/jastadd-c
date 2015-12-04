
package jastaddc.semantics.ast;



			
public class Structure extends StructuredType implements Cloneable {
    public void flushCache() {
        super.flushCache();
        Name_visited = -1;
        ReadableTypeName_visited = -1;
        buildQualifiedReference_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Structure clone() throws CloneNotSupportedException {
        Structure node = (Structure)super.clone();
        node.Name_visited = -1;
        node.ReadableTypeName_visited = -1;
        node.buildQualifiedReference_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Structure copy() {
      try {
          Structure node = (Structure)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Structure fullCopy() {
        Structure res = (Structure)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 398

    public Structure() {
        super();

        setChild(new List(), 0);
        setChild(new Opt(), 1);
        setChild(new List(), 2);

    }

    // Declared in C99AST.ast at line 13


    // Declared in C99AST.ast line 398
    public Structure(List<TypeQualifier> p0, Opt<Identifier> p1, List<UnionOrStructureElement> p2) {
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

    protected int Name_visited = -1;
    // Declared in Names.jrag at line 10
 @SuppressWarnings({"unchecked", "cast"})     public String Name() {
        if(Name_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Name in class: ");
        Name_visited = state().boundariesCrossed;
        String Name_value = Name_compute();
        Name_visited = -1;
        return Name_value;
    }

    private String Name_compute() {  return hasTag() ? getTag().Name() : "§Anonymous Structure Type "+ NodeAddress().toString() +"§";  }

    protected int ReadableTypeName_visited = -1;
/**
	 * Provide functionality to print human readable type descriptions.
	 
    Declared in ReadableTypeNames.jrag at line 65
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
		result.append("structure ");
		if (hasTag()) {
			result.append("named [");
			result.append(Name());
			result.append("] ");
		}
		result.append("with [");
		result.append(getNumElement());
		result.append("] member elements");
		if (getNumElement() > 0) {
			result.append(" {");
			for (int i = 0; i < getNumElement(); i++) {
				result.append(i);
				result.append(") ");
				result.append(getElement(i).readableElementName());
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
	 
    Declared in CompilerAPI.jrag at line 461
*/
 @SuppressWarnings({"unchecked", "cast"})     public Type buildQualifiedReference() {
        if(buildQualifiedReference_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: buildQualifiedReference in class: ");
        buildQualifiedReference_visited = state().boundariesCrossed;
        Type buildQualifiedReference_value = buildQualifiedReference_compute();
        buildQualifiedReference_visited = -1;
        return buildQualifiedReference_value;
    }

    private Type buildQualifiedReference_compute() {  return new StructureTypeReference(buildTypeQualifierCopy(), new Identifier(Name()));  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
