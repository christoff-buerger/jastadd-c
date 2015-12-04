
package jastaddc.semantics.ast;


	
	/**
	 * One C99 declaration can declare several entities. For much more convenient
	 * AST's each entity declared will be represented by it's own Declaration node.
	 * 
	 * REWRITE: Thus there must be some mapping from the concrete syntax to the
	 * abstract one mapping a C99 declaration to a collection of AST declarations.
	 */
	
public class DeclarationCollection extends _IntermediateDeclarationCollection implements Cloneable {
    public void flushCache() {
        super.flushCache();
        RetrieveFinalNode_visited = -1;
        IsCorrectLocal_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public DeclarationCollection clone() throws CloneNotSupportedException {
        DeclarationCollection node = (DeclarationCollection)super.clone();
        node.RetrieveFinalNode_visited = -1;
        node.IsCorrectLocal_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public DeclarationCollection copy() {
      try {
          DeclarationCollection node = (DeclarationCollection)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public DeclarationCollection fullCopy() {
        DeclarationCollection res = (DeclarationCollection)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 116

    public DeclarationCollection() {
        super();

        setChild(new List(), 0);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 116
    public DeclarationCollection(List<Declaration> p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 116
    public void setDeclarationList(List<Declaration> list) {
        setChild(list, 0);
    }

    // Declared in C99AST.ast at line 6


    public int getNumDeclaration() {
        return getDeclarationList().getNumChild();
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Declaration getDeclaration(int i) {
        return (Declaration)getDeclarationList().getChild(i);
    }

    // Declared in C99AST.ast at line 14


    public void addDeclaration(Declaration node) {
        List<Declaration> list = getDeclarationList();
        list.addChild(node);
    }

    // Declared in C99AST.ast at line 19


    public void setDeclaration(Declaration node, int i) {
        List<Declaration> list = getDeclarationList();
        list.setChild(node, i);
    }

    // Declared in C99AST.ast at line 23

    public List<Declaration> getDeclarations() {
        return getDeclarationList();
    }

    // Declared in C99AST.ast at line 26

    public List<Declaration> getDeclarationsNoTransform() {
        return getDeclarationListNoTransform();
    }

    // Declared in C99AST.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<Declaration> getDeclarationList() {
        return (List<Declaration>)getChild(0);
    }

    // Declared in C99AST.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<Declaration> getDeclarationListNoTransform() {
        return (List<Declaration>)getChildNoTransform(0);
    }

    protected int RetrieveFinalNode_visited = -1;
/**
	 * Nodes representing Declarations have to be mapped:
	 
    Declared in CompilerAPI.jrag at line 29
*/
 @SuppressWarnings({"unchecked", "cast"})     public DeclarationCollection RetrieveFinalNode() {
        if(RetrieveFinalNode_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: RetrieveFinalNode in class: ");
        RetrieveFinalNode_visited = state().boundariesCrossed;
        DeclarationCollection RetrieveFinalNode_value = RetrieveFinalNode_compute();
        RetrieveFinalNode_visited = -1;
        return RetrieveFinalNode_value;
    }

    private DeclarationCollection RetrieveFinalNode_compute() {  return this;  }

    protected int IsCorrectLocal_visited = -1;
/**
	 * This attribute handles the semantic constraint verification for one
	 * AST node, without traversing the tree, thus sub nodes may still be
	 * incorrect when isCorrectLocal() returns true. In this case it's only
	 * guaranteed that this AST node's semantic constraints are satisfied.
	 
    Declared in LocalConstraints.jrag at line 370
*/
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsCorrectLocal() {
        if(IsCorrectLocal_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsCorrectLocal in class: ");
        IsCorrectLocal_visited = state().boundariesCrossed;
        boolean IsCorrectLocal_value = IsCorrectLocal_compute();
        IsCorrectLocal_visited = -1;
        return IsCorrectLocal_value;
    }

    private boolean IsCorrectLocal_compute() {
		boolean result = super.IsCorrectLocal();
		if (getNumDeclaration() < 1) {
			throw new jastaddc.syntax.SyntacticalFailure(
					"AST Structure: A "+ this.getClass().getName() +" contains no Declaration."+
					"\n\tCheck the parser and concrete to AST mapping implementation."+
					"\n\tIt must not permit such a construct.");
		}
		return result;
	}

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
