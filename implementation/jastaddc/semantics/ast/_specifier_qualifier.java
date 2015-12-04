
package jastaddc.semantics.ast;


	
	
public abstract class _specifier_qualifier extends _declaration_specifiers implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public _specifier_qualifier clone() throws CloneNotSupportedException {
        _specifier_qualifier node = (_specifier_qualifier)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 107

    public _specifier_qualifier() {
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
