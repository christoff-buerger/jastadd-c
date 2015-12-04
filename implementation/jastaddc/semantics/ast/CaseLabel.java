
package jastaddc.semantics.ast;


		
			
public class CaseLabel extends SwitchLabelStatement implements Cloneable {
    public void flushCache() {
        super.flushCache();
        Name_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public CaseLabel clone() throws CloneNotSupportedException {
        CaseLabel node = (CaseLabel)super.clone();
        node.Name_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public CaseLabel copy() {
      try {
          CaseLabel node = (CaseLabel)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public CaseLabel fullCopy() {
        CaseLabel res = (CaseLabel)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 487

    public CaseLabel() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 487
    public CaseLabel(Statement p0, Expression p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    // Declared in C99AST.ast at line 15


  protected int numChildren() {
    return 2;
  }

    // Declared in C99AST.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 481
    public void setContinuation(Statement node) {
        setChild(node, 0);
    }

    // Declared in C99AST.ast at line 5

    public Statement getContinuation() {
        return (Statement)getChild(0);
    }

    // Declared in C99AST.ast at line 9


    public Statement getContinuationNoTransform() {
        return (Statement)getChildNoTransform(0);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 487
    public void setCondition(Expression node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public Expression getCondition() {
        return (Expression)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public Expression getConditionNoTransform() {
        return (Expression)getChildNoTransform(1);
    }

    protected int Name_visited = -1;
    // Declared in Names.jrag at line 22
 @SuppressWarnings({"unchecked", "cast"})     public String Name() {
        if(Name_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Name in class: ");
        Name_visited = state().boundariesCrossed;
        String Name_value = Name_compute();
        Name_visited = -1;
        return Name_value;
    }

    private String Name_compute() {  return "case";  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
