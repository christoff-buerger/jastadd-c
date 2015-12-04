
package jastaddc.semantics.ast;


	
	/**
	 * A DesignatorAccess's designation of an InitializerElement is implicit given,
	 * thus no designation child will be added.
	 * 
	 * REWRITE: Computing and adding the implicit given designation of
	 * DesignatorAccess nodes of InitializerElements.
	 * 
	 * PARSER CONSTRAINT: The parser guarantees, that the designation is only left
	 * for the DesignatorAccess's of InitializerElements. All other
	 * DesignatorAccess's must have a designation.
	 */
	
public abstract class DesignatorAccess extends Expression implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public DesignatorAccess clone() throws CloneNotSupportedException {
        DesignatorAccess node = (DesignatorAccess)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 514

    public DesignatorAccess() {
        super();

        setChild(new Opt(), 0);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 514
    public DesignatorAccess(Opt<Expression> p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 514
    public void setDesignationOpt(Opt<Expression> opt) {
        setChild(opt, 0);
    }

    // Declared in C99AST.ast at line 6


    public boolean hasDesignation() {
        return getDesignationOpt().getNumChild() != 0;
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Expression getDesignation() {
        return (Expression)getDesignationOpt().getChild(0);
    }

    // Declared in C99AST.ast at line 14


    public void setDesignation(Expression node) {
        getDesignationOpt().setChild(node, 0);
    }

    // Declared in C99AST.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<Expression> getDesignationOpt() {
        return (Opt<Expression>)getChild(0);
    }

    // Declared in C99AST.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<Expression> getDesignationOptNoTransform() {
        return (Opt<Expression>)getChildNoTransform(0);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
