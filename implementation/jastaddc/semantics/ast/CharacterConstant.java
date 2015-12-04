
package jastaddc.semantics.ast;


	
public class CharacterConstant extends Constant implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public CharacterConstant clone() throws CloneNotSupportedException {
        CharacterConstant node = (CharacterConstant)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public CharacterConstant copy() {
      try {
          CharacterConstant node = (CharacterConstant)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public CharacterConstant fullCopy() {
        CharacterConstant res = (CharacterConstant)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 41

    public CharacterConstant() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 41
    public CharacterConstant(String p0, String p1, boolean p2) {
        setLexem(p0);
        setCharacterValue(p1);
        setIsWideCharacter(p2);
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
    // Declared in C99AST.ast line 41
    protected String tokenString_CharacterValue;

    // Declared in C99AST.ast at line 3

    public void setCharacterValue(String value) {
        tokenString_CharacterValue = value;
    }

    // Declared in C99AST.ast at line 6

    public String getCharacterValue() {
        return tokenString_CharacterValue != null ? tokenString_CharacterValue : "";
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 41
    protected boolean tokenboolean_IsWideCharacter;

    // Declared in C99AST.ast at line 3

    public void setIsWideCharacter(boolean value) {
        tokenboolean_IsWideCharacter = value;
    }

    // Declared in C99AST.ast at line 6

    public boolean getIsWideCharacter() {
        return tokenboolean_IsWideCharacter;
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
