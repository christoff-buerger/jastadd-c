
package jastaddc.semantics.ast;


	
public class StringLiteral extends Constant implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public StringLiteral clone() throws CloneNotSupportedException {
        StringLiteral node = (StringLiteral)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public StringLiteral copy() {
      try {
          StringLiteral node = (StringLiteral)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public StringLiteral fullCopy() {
        StringLiteral res = (StringLiteral)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 42

    public StringLiteral() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 42
    public StringLiteral(String p0, String p1, boolean p2) {
        setLexem(p0);
        setStringValue(p1);
        setIsWideString(p2);
    }

    // Declared in C99AST.ast at line 16


  protected int numChildren() {
    return 0;
  }

    // Declared in C99AST.ast at line 19

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
    // Declared in C99AST.ast line 42
    protected String tokenString_StringValue;

    // Declared in C99AST.ast at line 3

    public void setStringValue(String value) {
        tokenString_StringValue = value;
    }

    // Declared in C99AST.ast at line 6

    public String getStringValue() {
        return tokenString_StringValue != null ? tokenString_StringValue : "";
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 42
    protected boolean tokenboolean_IsWideString;

    // Declared in C99AST.ast at line 3

    public void setIsWideString(boolean value) {
        tokenboolean_IsWideString = value;
    }

    // Declared in C99AST.ast at line 6

    public boolean getIsWideString() {
        return tokenboolean_IsWideString;
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
