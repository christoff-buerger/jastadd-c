
package jastaddc.semantics.ast;


		
		
public class PrimitiveType extends AtomicType implements Cloneable {
    public void flushCache() {
        super.flushCache();
        Name_visited = -1;
        ReadableTypeName_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public PrimitiveType clone() throws CloneNotSupportedException {
        PrimitiveType node = (PrimitiveType)super.clone();
        node.Name_visited = -1;
        node.ReadableTypeName_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public PrimitiveType copy() {
      try {
          PrimitiveType node = (PrimitiveType)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public PrimitiveType fullCopy() {
        PrimitiveType res = (PrimitiveType)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 276

    public PrimitiveType() {
        super();

        setChild(new List(), 0);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 276
    public PrimitiveType(List<TypeQualifier> p0, jastaddc.semantics.PrimitiveTypes p1) {
        setChild(p0, 0);
        setType(p1);
    }

    // Declared in C99AST.ast at line 16


  protected int numChildren() {
    return 1;
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
    // Declared in C99AST.ast line 276
    protected jastaddc.semantics.PrimitiveTypes tokenjastaddc_semantics_PrimitiveTypes_Type;

    // Declared in C99AST.ast at line 3

    public void setType(jastaddc.semantics.PrimitiveTypes value) {
        tokenjastaddc_semantics_PrimitiveTypes_Type = value;
    }

    // Declared in C99AST.ast at line 6

    public jastaddc.semantics.PrimitiveTypes getType() {
        return tokenjastaddc_semantics_PrimitiveTypes_Type;
    }

    protected int Name_visited = -1;
    // Declared in Names.jrag at line 24
 @SuppressWarnings({"unchecked", "cast"})     public String Name() {
        if(Name_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Name in class: ");
        Name_visited = state().boundariesCrossed;
        String Name_value = Name_compute();
        Name_visited = -1;
        return Name_value;
    }

    private String Name_compute() {  return getType().typeName();  }

    protected int ReadableTypeName_visited = -1;
/**
	 * Provide functionality to print human readable type descriptions.
	 
    Declared in ReadableTypeNames.jrag at line 5
*/
 @SuppressWarnings({"unchecked", "cast"})     public String ReadableTypeName() {
        if(ReadableTypeName_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ReadableTypeName in class: ");
        ReadableTypeName_visited = state().boundariesCrossed;
        String ReadableTypeName_value = ReadableTypeName_compute();
        ReadableTypeName_visited = -1;
        return ReadableTypeName_value;
    }

    private String ReadableTypeName_compute() {  return getType().typeName();  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
