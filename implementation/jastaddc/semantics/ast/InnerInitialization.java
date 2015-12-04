
package jastaddc.semantics.ast;



			
public class InnerInitialization extends InitializerElement implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public InnerInitialization clone() throws CloneNotSupportedException {
        InnerInitialization node = (InnerInitialization)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public InnerInitialization copy() {
      try {
          InnerInitialization node = (InnerInitialization)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public InnerInitialization fullCopy() {
        InnerInitialization res = (InnerInitialization)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 196

    public InnerInitialization() {
        super();

        setChild(new Opt(), 0);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 196
    public InnerInitialization(Opt<DesignatorAccess> p0, CompoundInitializer p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    // Declared in C99AST.ast at line 16


  protected int numChildren() {
    return 2;
  }

    // Declared in C99AST.ast at line 19

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

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 196
    public void setCompoundInitializer(CompoundInitializer node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public CompoundInitializer getCompoundInitializer() {
        return (CompoundInitializer)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public CompoundInitializer getCompoundInitializerNoTransform() {
        return (CompoundInitializer)getChildNoTransform(1);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
