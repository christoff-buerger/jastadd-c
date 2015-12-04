
package jastaddc.semantics.ast;


		
public class CompoundInitializer extends NormalInitializer implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public CompoundInitializer clone() throws CloneNotSupportedException {
        CompoundInitializer node = (CompoundInitializer)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public CompoundInitializer copy() {
      try {
          CompoundInitializer node = (CompoundInitializer)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public CompoundInitializer fullCopy() {
        CompoundInitializer res = (CompoundInitializer)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 170

    public CompoundInitializer() {
        super();

        setChild(new List(), 0);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 170
    public CompoundInitializer(List<InitializerElement> p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 170
    public void setInitializerElementList(List<InitializerElement> list) {
        setChild(list, 0);
    }

    // Declared in C99AST.ast at line 6


    public int getNumInitializerElement() {
        return getInitializerElementList().getNumChild();
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public InitializerElement getInitializerElement(int i) {
        return (InitializerElement)getInitializerElementList().getChild(i);
    }

    // Declared in C99AST.ast at line 14


    public void addInitializerElement(InitializerElement node) {
        List<InitializerElement> list = getInitializerElementList();
        list.addChild(node);
    }

    // Declared in C99AST.ast at line 19


    public void setInitializerElement(InitializerElement node, int i) {
        List<InitializerElement> list = getInitializerElementList();
        list.setChild(node, i);
    }

    // Declared in C99AST.ast at line 23

    public List<InitializerElement> getInitializerElements() {
        return getInitializerElementList();
    }

    // Declared in C99AST.ast at line 26

    public List<InitializerElement> getInitializerElementsNoTransform() {
        return getInitializerElementListNoTransform();
    }

    // Declared in C99AST.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<InitializerElement> getInitializerElementList() {
        return (List<InitializerElement>)getChild(0);
    }

    // Declared in C99AST.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<InitializerElement> getInitializerElementListNoTransform() {
        return (List<InitializerElement>)getChildNoTransform(0);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
