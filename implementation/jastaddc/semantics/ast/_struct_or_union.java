
package jastaddc.semantics.ast;


			

public abstract class _struct_or_union extends ASTNode<ASTNode> implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public _struct_or_union clone() throws CloneNotSupportedException {
        _struct_or_union node = (_struct_or_union)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 135

    public _struct_or_union() {
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
