
package jastaddc.semantics.ast;




public class Identifier extends ASTNode<ASTNode> implements Cloneable {
    public void flushCache() {
        super.flushCache();
        Name_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Identifier clone() throws CloneNotSupportedException {
        Identifier node = (Identifier)super.clone();
        node.Name_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Identifier copy() {
      try {
          Identifier node = (Identifier)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Identifier fullCopy() {
        Identifier res = (Identifier)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ASTNodeXMLAttributes.jrag at line 8

	public java.util.List<org.jdom.Attribute> createXMLNodeAttributes() {
		java.util.List<org.jdom.Attribute> result =
			new java.util.LinkedList<org.jdom.Attribute>();
		result.add(new org.jdom.Attribute("Value", Name()));
		return result;
	}

    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 68

    public Identifier() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 68
    public Identifier(String p0) {
        setValue(p0);
    }

    // Declared in C99AST.ast at line 14


  protected int numChildren() {
    return 0;
  }

    // Declared in C99AST.ast at line 17

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 68
    protected String tokenString_Value;

    // Declared in C99AST.ast at line 3

    public void setValue(String value) {
        tokenString_Value = value;
    }

    // Declared in C99AST.ast at line 6

    public String getValue() {
        return tokenString_Value != null ? tokenString_Value : "";
    }

    protected int Name_visited = -1;
/**
	 * Provide names for special ast nodes (e.g. structures, unions, enumerations),
	 * even when the node has no explicit name in the source code, e.g. a structure
	 * has no Tag:
	 
    Declared in Names.jrag at line 5
*/
 @SuppressWarnings({"unchecked", "cast"})     public String Name() {
        if(Name_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Name in class: ");
        Name_visited = state().boundariesCrossed;
        String Name_value = Name_compute();
        Name_visited = -1;
        return Name_value;
    }

    private String Name_compute() {  return getValue() == null ? "" : getValue();  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
