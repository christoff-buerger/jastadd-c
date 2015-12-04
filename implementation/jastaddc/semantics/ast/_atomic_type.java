
package jastaddc.semantics.ast;


		
			/**
			 * Atomic types are:
			 *  - void
			 *  - char
			 *  - int
			 *  - long
			 *  - float
			 *  - double
			 *  - signed
			 *  - unsigned
			 *  - _Bool
			 *  - _Complex
			 *  - _Imaginary
			 */
			
public class _atomic_type extends _type_specifier implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public _atomic_type clone() throws CloneNotSupportedException {
        _atomic_type node = (_atomic_type)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _atomic_type copy() {
      try {
          _atomic_type node = (_atomic_type)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _atomic_type fullCopy() {
        _atomic_type res = (_atomic_type)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 125

    public _atomic_type() {
        super();


    }

    // Declared in ConcreteToASTMapping.ast at line 10


    // Declared in ConcreteToASTMapping.ast line 125
    public _atomic_type(String p0) {
        setTypeName(p0);
    }

    // Declared in ConcreteToASTMapping.ast at line 14


  protected int numChildren() {
    return 0;
  }

    // Declared in ConcreteToASTMapping.ast at line 17

  public boolean mayHaveRewrite() { return false; }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 125
    protected String tokenString_TypeName;

    // Declared in ConcreteToASTMapping.ast at line 3

    public void setTypeName(String value) {
        tokenString_TypeName = value;
    }

    // Declared in ConcreteToASTMapping.ast at line 6

    public String getTypeName() {
        return tokenString_TypeName != null ? tokenString_TypeName : "";
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
