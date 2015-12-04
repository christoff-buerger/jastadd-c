
package jastaddc.semantics.ast;




public abstract class FunctionSpecifier extends _declaration_specifiers implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public FunctionSpecifier clone() throws CloneNotSupportedException {
        FunctionSpecifier node = (FunctionSpecifier)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 58

    public FunctionSpecifier() {
        super();


    }

    // Declared in C99AST.ast at line 9


  protected int numChildren() {
    return 0;
  }

    // Declared in C99AST.ast at line 12

  public boolean mayHaveRewrite() { return false; }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
