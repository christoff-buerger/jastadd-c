
package jastaddc.semantics.ast;


	
	/**
	 * To represent multidimensional arrays an Array type can have another
	 * Array type as ElementType. In such a case the first dimension Expression
	 * object may be null, so the array is an incomplete array type
	 * [6.2.5:22] S.36, [6.7.5.2:4] S.116.
	 * 
	 * REWRITE: If an incomplete array type is declared and an initialization
	 * is given, a rewrite will be executed, setting the arrays first dimension
	 * to the appropriate size (only the first dimension can be left out).
	 * E.g.:
	 * 
	 * int a[] = {0,0,0}; --> int a[3] = {0,0,0};
	 * 
	 * and
	 * 
	 * int a[][2] = {1,2,3}; --> int a[2][2] = {{1,2},{3,0}};
	 */
	
public class Array extends Type implements Cloneable {
    public void flushCache() {
        super.flushCache();
        ReadableTypeName_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Array clone() throws CloneNotSupportedException {
        Array node = (Array)super.clone();
        node.ReadableTypeName_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Array copy() {
      try {
          Array node = (Array)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Array fullCopy() {
        Array res = (Array)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 304

    public Array() {
        super();

        setChild(new List(), 0);
        setChild(new Opt(), 2);

    }

    // Declared in C99AST.ast at line 12


    // Declared in C99AST.ast line 304
    public Array(List<TypeQualifier> p0, _IntermediateType p1, Opt<Expression> p2) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
    }

    // Declared in C99AST.ast at line 18


  protected int numChildren() {
    return 3;
  }

    // Declared in C99AST.ast at line 21

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
    // Declared in C99AST.ast line 304
    public void setElementType(_IntermediateType node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public _IntermediateType getElementType() {
        return (_IntermediateType)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public _IntermediateType getElementTypeNoTransform() {
        return (_IntermediateType)getChildNoTransform(1);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 304
    public void setDimensionOpt(Opt<Expression> opt) {
        setChild(opt, 2);
    }

    // Declared in C99AST.ast at line 6


    public boolean hasDimension() {
        return getDimensionOpt().getNumChild() != 0;
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Expression getDimension() {
        return (Expression)getDimensionOpt().getChild(0);
    }

    // Declared in C99AST.ast at line 14


    public void setDimension(Expression node) {
        getDimensionOpt().setChild(node, 0);
    }

    // Declared in C99AST.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<Expression> getDimensionOpt() {
        return (Opt<Expression>)getChild(2);
    }

    // Declared in C99AST.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<Expression> getDimensionOptNoTransform() {
        return (Opt<Expression>)getChildNoTransform(2);
    }

    protected int ReadableTypeName_visited = -1;
/**
	 * Provide functionality to print human readable type descriptions.
	 
    Declared in ReadableTypeNames.jrag at line 15
*/
 @SuppressWarnings({"unchecked", "cast"})     public String ReadableTypeName() {
        if(ReadableTypeName_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ReadableTypeName in class: ");
        ReadableTypeName_visited = state().boundariesCrossed;
        String ReadableTypeName_value = ReadableTypeName_compute();
        ReadableTypeName_visited = -1;
        return ReadableTypeName_value;
    }

    private String ReadableTypeName_compute() {  return "array of "+ getElementType().RetrieveFinalNode().ReadableTypeName();  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
