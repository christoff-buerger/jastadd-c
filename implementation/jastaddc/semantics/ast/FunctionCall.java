
package jastaddc.semantics.ast;


	
public class FunctionCall extends Expression implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public FunctionCall clone() throws CloneNotSupportedException {
        FunctionCall node = (FunctionCall)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public FunctionCall copy() {
      try {
          FunctionCall node = (FunctionCall)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public FunctionCall fullCopy() {
        FunctionCall res = (FunctionCall)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 499

    public FunctionCall() {
        super();

        setChild(new List(), 1);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 499
    public FunctionCall(Expression p0, List<Expression> p1) {
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
    // Declared in C99AST.ast line 499
    public void setFunctionObject(Expression node) {
        setChild(node, 0);
    }

    // Declared in C99AST.ast at line 5

    public Expression getFunctionObject() {
        return (Expression)getChild(0);
    }

    // Declared in C99AST.ast at line 9


    public Expression getFunctionObjectNoTransform() {
        return (Expression)getChildNoTransform(0);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 499
    public void setArgumentsList(List<Expression> list) {
        setChild(list, 1);
    }

    // Declared in C99AST.ast at line 6


    public int getNumArguments() {
        return getArgumentsList().getNumChild();
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Expression getArguments(int i) {
        return (Expression)getArgumentsList().getChild(i);
    }

    // Declared in C99AST.ast at line 14


    public void addArguments(Expression node) {
        List<Expression> list = getArgumentsList();
        list.addChild(node);
    }

    // Declared in C99AST.ast at line 19


    public void setArguments(Expression node, int i) {
        List<Expression> list = getArgumentsList();
        list.setChild(node, i);
    }

    // Declared in C99AST.ast at line 23

    public List<Expression> getArgumentss() {
        return getArgumentsList();
    }

    // Declared in C99AST.ast at line 26

    public List<Expression> getArgumentssNoTransform() {
        return getArgumentsListNoTransform();
    }

    // Declared in C99AST.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<Expression> getArgumentsList() {
        return (List<Expression>)getChild(1);
    }

    // Declared in C99AST.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<Expression> getArgumentsListNoTransform() {
        return (List<Expression>)getChildNoTransform(1);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
