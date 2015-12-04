
package jastaddc.semantics.ast;


	
	
public class IntegerConstant extends Constant implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public IntegerConstant clone() throws CloneNotSupportedException {
        IntegerConstant node = (IntegerConstant)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public IntegerConstant copy() {
      try {
          IntegerConstant node = (IntegerConstant)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public IntegerConstant fullCopy() {
        IntegerConstant res = (IntegerConstant)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 39

    public IntegerConstant() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 39
    public IntegerConstant(String p0, String p1, NumeralSystemRadix p2, PrimitiveType p3) {
        setLexem(p0);
        setNumericValue(p1);
        setChild(p2, 0);
        setChild(p3, 1);
    }

    // Declared in C99AST.ast at line 17


  protected int numChildren() {
    return 2;
  }

    // Declared in C99AST.ast at line 20

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 37
    public void setLexem(String value) {
        tokenString_Lexem = value;
    }

    // Declared in C99AST.ast at line 5

    public String getLexem() {
        return tokenString_Lexem != null ? tokenString_Lexem : "";
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 39
    protected String tokenString_NumericValue;

    // Declared in C99AST.ast at line 3

    public void setNumericValue(String value) {
        tokenString_NumericValue = value;
    }

    // Declared in C99AST.ast at line 6

    public String getNumericValue() {
        return tokenString_NumericValue != null ? tokenString_NumericValue : "";
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 39
    public void setRadix(NumeralSystemRadix node) {
        setChild(node, 0);
    }

    // Declared in C99AST.ast at line 5

    public NumeralSystemRadix getRadix() {
        return (NumeralSystemRadix)getChild(0);
    }

    // Declared in C99AST.ast at line 9


    public NumeralSystemRadix getRadixNoTransform() {
        return (NumeralSystemRadix)getChildNoTransform(0);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 39
    public void setType(PrimitiveType node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public PrimitiveType getType() {
        return (PrimitiveType)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public PrimitiveType getTypeNoTransform() {
        return (PrimitiveType)getChildNoTransform(1);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
