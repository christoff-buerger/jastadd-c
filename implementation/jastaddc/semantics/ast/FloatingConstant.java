
package jastaddc.semantics.ast;


	
public class FloatingConstant extends Constant implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public FloatingConstant clone() throws CloneNotSupportedException {
        FloatingConstant node = (FloatingConstant)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public FloatingConstant copy() {
      try {
          FloatingConstant node = (FloatingConstant)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public FloatingConstant fullCopy() {
        FloatingConstant res = (FloatingConstant)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 40

    public FloatingConstant() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 40
    public FloatingConstant(String p0, String p1, String p2, String p3, NumeralSystemRadix p4, PrimitiveType p5) {
        setLexem(p0);
        setWholeNumberPart(p1);
        setFractionalPart(p2);
        setExponent(p3);
        setChild(p4, 0);
        setChild(p5, 1);
    }

    // Declared in C99AST.ast at line 19


  protected int numChildren() {
    return 2;
  }

    // Declared in C99AST.ast at line 22

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
    // Declared in C99AST.ast line 40
    protected String tokenString_WholeNumberPart;

    // Declared in C99AST.ast at line 3

    public void setWholeNumberPart(String value) {
        tokenString_WholeNumberPart = value;
    }

    // Declared in C99AST.ast at line 6

    public String getWholeNumberPart() {
        return tokenString_WholeNumberPart != null ? tokenString_WholeNumberPart : "";
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 40
    protected String tokenString_FractionalPart;

    // Declared in C99AST.ast at line 3

    public void setFractionalPart(String value) {
        tokenString_FractionalPart = value;
    }

    // Declared in C99AST.ast at line 6

    public String getFractionalPart() {
        return tokenString_FractionalPart != null ? tokenString_FractionalPart : "";
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 40
    protected String tokenString_Exponent;

    // Declared in C99AST.ast at line 3

    public void setExponent(String value) {
        tokenString_Exponent = value;
    }

    // Declared in C99AST.ast at line 6

    public String getExponent() {
        return tokenString_Exponent != null ? tokenString_Exponent : "";
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 40
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
    // Declared in C99AST.ast line 40
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
