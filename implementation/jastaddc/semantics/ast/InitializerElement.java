
package jastaddc.semantics.ast;



		/**
		 * After parsing the DesignatorAccess will have no Designation.
		 * The C99 standard defines the current object of initializer implicitly
		 * [6.7.8] S.125.
		 * 
		 * REWRITE: If a DesignatorAccess is given it's Designation will be
		 * rewritten to an expression/an expression will be simulated, so that
		 * the type of the DesignatorAccess is the type of the object initialized
		 * and the Designation is the implicitly defined object [6.7.8] S.125.
		 * E.g.: in
		 * 
		 * struct s1 {int i;};
		 * struct s2 {double d; struct s1 s;} so = {3.0, .s = {.i = 3}};
		 * 
		 * the Designation for the MemberAccess '.s' will be the result of the
		 * expression 'so', which is of type 's2', thus 'so.s' is of type 's1'.
		 * The Designation for the MemberAccess '.i' will be the result of the
		 * expression 'so.s', which is of type 's1', thus 'so.s.i' is of  type int.
		 * 
		 * REWRITE: If no DesignatorAccess is given, the implicit accessed Element
		 * is made explicit by adding the corresponding DesignatorAccess.
		 */
		
public abstract class InitializerElement extends ASTNode<ASTNode> implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public InitializerElement clone() throws CloneNotSupportedException {
        InitializerElement node = (InitializerElement)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 194

    public InitializerElement() {
        super();

        setChild(new Opt(), 0);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 194
    public InitializerElement(Opt<DesignatorAccess> p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 194
    public void setDesignatorAccessOpt(Opt<DesignatorAccess> opt) {
        setChild(opt, 0);
    }

    // Declared in C99AST.ast at line 6


    public boolean hasDesignatorAccess() {
        return getDesignatorAccessOpt().getNumChild() != 0;
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public DesignatorAccess getDesignatorAccess() {
        return (DesignatorAccess)getDesignatorAccessOpt().getChild(0);
    }

    // Declared in C99AST.ast at line 14


    public void setDesignatorAccess(DesignatorAccess node) {
        getDesignatorAccessOpt().setChild(node, 0);
    }

    // Declared in C99AST.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<DesignatorAccess> getDesignatorAccessOpt() {
        return (Opt<DesignatorAccess>)getChild(0);
    }

    // Declared in C99AST.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<DesignatorAccess> getDesignatorAccessOptNoTransform() {
        return (Opt<DesignatorAccess>)getChildNoTransform(0);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
