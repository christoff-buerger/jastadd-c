
package jastaddc.semantics.ast;




public abstract class StorageClassSpecifier extends _declaration_specifiers implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public StorageClassSpecifier clone() throws CloneNotSupportedException {
        StorageClassSpecifier node = (StorageClassSpecifier)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 50

    public StorageClassSpecifier() {
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
