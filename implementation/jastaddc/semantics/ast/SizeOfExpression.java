
package jastaddc.semantics.ast;



	/**
	 * The sizeof operator shall not be applied to a function type, a
	 * incomplete type or a bit field [6.5.3.4:1] S.80.
	 * 
	 * The operand of the sizeof operator is only evaluated, if it is a
	 * variable length array (otherwise it is not evaluated) [6.5.3.4:2] S.80.
	 */
	
public abstract class SizeOfExpression extends Expression implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public SizeOfExpression clone() throws CloneNotSupportedException {
        SizeOfExpression node = (SizeOfExpression)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 561

    public SizeOfExpression() {
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
