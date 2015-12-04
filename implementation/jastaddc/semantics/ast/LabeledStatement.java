
package jastaddc.semantics.ast;



	
public abstract class LabeledStatement extends Statement implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public LabeledStatement clone() throws CloneNotSupportedException {
        LabeledStatement node = (LabeledStatement)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 481

    public LabeledStatement() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 481
    public LabeledStatement(Statement p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 14


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 17

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

    // Declared in CompilerAPI.jrag at line 171
 @SuppressWarnings({"unchecked", "cast"})     public abstract String Name();
public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
