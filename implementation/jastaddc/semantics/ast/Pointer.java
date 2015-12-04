
package jastaddc.semantics.ast;



	
public class Pointer extends Type implements Cloneable {
    public void flushCache() {
        super.flushCache();
        IsFunctionPointer_visited = -1;
        IsVoidPointer_visited = -1;
        ReadableTypeName_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Pointer clone() throws CloneNotSupportedException {
        Pointer node = (Pointer)super.clone();
        node.IsFunctionPointer_visited = -1;
        node.IsVoidPointer_visited = -1;
        node.ReadableTypeName_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Pointer copy() {
      try {
          Pointer node = (Pointer)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Pointer fullCopy() {
        Pointer res = (Pointer)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 306

    public Pointer() {
        super();

        setChild(new List(), 0);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 306
    public Pointer(List<TypeQualifier> p0, _IntermediateType p1) {
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
    // Declared in C99AST.ast line 306
    public void setType(_IntermediateType node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public _IntermediateType getType() {
        return (_IntermediateType)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public _IntermediateType getTypeNoTransform() {
        return (_IntermediateType)getChildNoTransform(1);
    }

    protected int IsFunctionPointer_visited = -1;
/**
	 * Provide information about pointers:
	 
    Declared in ContextInformationAccess.jrag at line 8
*/
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsFunctionPointer() {
        if(IsFunctionPointer_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsFunctionPointer in class: ");
        IsFunctionPointer_visited = state().boundariesCrossed;
        boolean IsFunctionPointer_value = IsFunctionPointer_compute();
        IsFunctionPointer_visited = -1;
        return IsFunctionPointer_value;
    }

    private boolean IsFunctionPointer_compute() {  return getType().RetrieveFinalNode() instanceof FunctionType;  }

    protected int IsVoidPointer_visited = -1;
    // Declared in ContextInformationAccess.jrag at line 10
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsVoidPointer() {
        if(IsVoidPointer_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsVoidPointer in class: ");
        IsVoidPointer_visited = state().boundariesCrossed;
        boolean IsVoidPointer_value = IsVoidPointer_compute();
        IsVoidPointer_visited = -1;
        return IsVoidPointer_value;
    }

    private boolean IsVoidPointer_compute() {  return getType().RetrieveFinalNode() instanceof PrimitiveType ?
				((PrimitiveType)getType().RetrieveFinalNode()).getType() == jastaddc.semantics.PrimitiveTypes._void :
				false;  }

    protected int ReadableTypeName_visited = -1;
/**
	 * Provide functionality to print human readable type descriptions.
	 
    Declared in ReadableTypeNames.jrag at line 17
*/
 @SuppressWarnings({"unchecked", "cast"})     public String ReadableTypeName() {
        if(ReadableTypeName_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ReadableTypeName in class: ");
        ReadableTypeName_visited = state().boundariesCrossed;
        String ReadableTypeName_value = ReadableTypeName_compute();
        ReadableTypeName_visited = -1;
        return ReadableTypeName_value;
    }

    private String ReadableTypeName_compute() {  return "pointer to "+ getType().RetrieveFinalNode().ReadableTypeName();  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
