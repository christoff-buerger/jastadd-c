
package jastaddc.semantics.ast;


		
public class UnionTypeReference extends AtomicType implements Cloneable {
    public void flushCache() {
        super.flushCache();
        ReferencedUnionType_visited = -1;
        Name_visited = -1;
        ReadableTypeName_visited = -1;
        IsCorrectLocal_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public UnionTypeReference clone() throws CloneNotSupportedException {
        UnionTypeReference node = (UnionTypeReference)super.clone();
        node.ReferencedUnionType_visited = -1;
        node.Name_visited = -1;
        node.ReadableTypeName_visited = -1;
        node.IsCorrectLocal_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public UnionTypeReference copy() {
      try {
          UnionTypeReference node = (UnionTypeReference)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public UnionTypeReference fullCopy() {
        UnionTypeReference res = (UnionTypeReference)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 284

    public UnionTypeReference() {
        super();

        setChild(new List(), 0);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 284
    public UnionTypeReference(List<TypeQualifier> p0, Identifier p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    // Declared in C99AST.ast at line 16


  protected int numChildren() {
    return 2;
  }

    // Declared in C99AST.ast at line 19

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
    // Declared in C99AST.ast line 284
    public void setReferenceName(Identifier node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public Identifier getReferenceName() {
        return (Identifier)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public Identifier getReferenceNameNoTransform() {
        return (Identifier)getChildNoTransform(1);
    }

    protected int ReferencedUnionType_visited = -1;
    // Declared in ContextInformationAccess.jrag at line 117
 @SuppressWarnings({"unchecked", "cast"})     public Union ReferencedUnionType() {
        if(ReferencedUnionType_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ReferencedUnionType in class: ");
        ReferencedUnionType_visited = state().boundariesCrossed;
        Union ReferencedUnionType_value = ReferencedUnionType_compute();
        ReferencedUnionType_visited = -1;
        return ReferencedUnionType_value;
    }

    private Union ReferencedUnionType_compute() {
		java.util.List<TagedType> lookedUp = LookUpTag(Name());
		if (lookedUp.isEmpty() || !(lookedUp.get(0).RetrieveFinalNode() instanceof Union))
			return (Union)ErrorBuilder().ConstructErrorNode(Union.class);
		return (Union)lookedUp.get(0).RetrieveFinalNode();
	}

    protected int Name_visited = -1;
    // Declared in Names.jrag at line 27
 @SuppressWarnings({"unchecked", "cast"})     public String Name() {
        if(Name_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Name in class: ");
        Name_visited = state().boundariesCrossed;
        String Name_value = Name_compute();
        Name_visited = -1;
        return Name_value;
    }

    private String Name_compute() {  return getReferenceName().Name();  }

    protected int ReadableTypeName_visited = -1;
/**
	 * Provide functionality to print human readable type descriptions.
	 
    Declared in ReadableTypeNames.jrag at line 11
*/
 @SuppressWarnings({"unchecked", "cast"})     public String ReadableTypeName() {
        if(ReadableTypeName_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ReadableTypeName in class: ");
        ReadableTypeName_visited = state().boundariesCrossed;
        String ReadableTypeName_value = ReadableTypeName_compute();
        ReadableTypeName_visited = -1;
        return ReadableTypeName_value;
    }

    private String ReadableTypeName_compute() {  return "union type ["+ getReferenceName().Name() +"]";  }

    protected int IsCorrectLocal_visited = -1;
/**
	 * This attribute handles the semantic constraint verification for one
	 * AST node, without traversing the tree, thus sub nodes may still be
	 * incorrect when isCorrectLocal() returns true. In this case it's only
	 * guaranteed that this AST node's semantic constraints are satisfied.
	 
    Declared in LocalConstraints.jrag at line 505
*/
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsCorrectLocal() {
        if(IsCorrectLocal_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsCorrectLocal in class: ");
        IsCorrectLocal_visited = state().boundariesCrossed;
        boolean IsCorrectLocal_value = IsCorrectLocal_compute();
        IsCorrectLocal_visited = -1;
        return IsCorrectLocal_value;
    }

    private boolean IsCorrectLocal_compute() {
		boolean result = super.IsCorrectLocal();
		if (ReferencedUnionType().IsErrorNode()) {
			StringBuilder errorM = new StringBuilder();
			errorM.append("Tag Namespace: Union [");
			errorM.append(Name());
			errorM.append("] usage.\n\t[");
			errorM.append(Name());
			errorM.append("] not declared.");
			jastaddc.SourceError error =
				new jastaddc.SourceError(errorM.toString());
			error.line = line();
			error.column = column();
			error.sourceName = sourceName();
			error.errorLevel =
				jastaddc.SourceError.ErrorLevel.ERROR;
			error.errorType =
				jastaddc.SourceError.ErrorType.SEMANTICAL;
			addError(error);
			result = false;
		}
		return result;
	}

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
