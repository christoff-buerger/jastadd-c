
package jastaddc.semantics.ast;




public abstract class _declaration_specifiers extends ASTNode<ASTNode> implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public _declaration_specifiers clone() throws CloneNotSupportedException {
        _declaration_specifiers node = (_declaration_specifiers)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 105

    public _declaration_specifiers() {
        super();


    }

    // Declared in ConcreteToASTMapping.ast at line 9


  protected int numChildren() {
    return 0;
  }

    // Declared in ConcreteToASTMapping.ast at line 12

  public boolean mayHaveRewrite() { return false; }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
