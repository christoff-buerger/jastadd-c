
package jastaddc.semantics.ast;


	
		
public class NormalFunction extends FunctionType implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public NormalFunction clone() throws CloneNotSupportedException {
        NormalFunction node = (NormalFunction)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public NormalFunction copy() {
      try {
          NormalFunction node = (NormalFunction)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public NormalFunction fullCopy() {
        NormalFunction res = (NormalFunction)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 372

    public NormalFunction() {
        super();

        setChild(new List(), 0);
        setChild(new List(), 2);

    }

    // Declared in C99AST.ast at line 12


    // Declared in C99AST.ast line 372
    public NormalFunction(List<TypeQualifier> p0, _IntermediateType p1, List<Declaration> p2) {
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
    // Declared in C99AST.ast line 370
    public void setReturnType(_IntermediateType node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public _IntermediateType getReturnType() {
        return (_IntermediateType)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public _IntermediateType getReturnTypeNoTransform() {
        return (_IntermediateType)getChildNoTransform(1);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 370
    public void setParameterList(List<Declaration> list) {
        setChild(list, 2);
    }

    // Declared in C99AST.ast at line 6


    public int getNumParameter() {
        return getParameterList().getNumChild();
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Declaration getParameter(int i) {
        return (Declaration)getParameterList().getChild(i);
    }

    // Declared in C99AST.ast at line 14


    public void addParameter(Declaration node) {
        List<Declaration> list = getParameterList();
        list.addChild(node);
    }

    // Declared in C99AST.ast at line 19


    public void setParameter(Declaration node, int i) {
        List<Declaration> list = getParameterList();
        list.setChild(node, i);
    }

    // Declared in C99AST.ast at line 23

    public List<Declaration> getParameters() {
        return getParameterList();
    }

    // Declared in C99AST.ast at line 26

    public List<Declaration> getParametersNoTransform() {
        return getParameterListNoTransform();
    }

    // Declared in C99AST.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<Declaration> getParameterList() {
        return (List<Declaration>)getChild(2);
    }

    // Declared in C99AST.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<Declaration> getParameterListNoTransform() {
        return (List<Declaration>)getChildNoTransform(2);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
