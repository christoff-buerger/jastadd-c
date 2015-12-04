
package jastaddc.semantics.ast;


	
public class Variable extends Expression implements Cloneable {
    public void flushCache() {
        super.flushCache();
        VariableDeclaration_visited = -1;
        Name_visited = -1;
        IsCorrectLocal_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Variable clone() throws CloneNotSupportedException {
        Variable node = (Variable)super.clone();
        node.VariableDeclaration_visited = -1;
        node.Name_visited = -1;
        node.IsCorrectLocal_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Variable copy() {
      try {
          Variable node = (Variable)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Variable fullCopy() {
        Variable res = (Variable)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 497

    public Variable() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 497
    public Variable(Identifier p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 14


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 17

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 497
    public void setName(Identifier node) {
        setChild(node, 0);
    }

    // Declared in C99AST.ast at line 5

    public Identifier getName() {
        return (Identifier)getChild(0);
    }

    // Declared in C99AST.ast at line 9


    public Identifier getNameNoTransform() {
        return (Identifier)getChildNoTransform(0);
    }

    protected int VariableDeclaration_visited = -1;
    // Declared in ContextInformationAccess.jrag at line 94
 @SuppressWarnings({"unchecked", "cast"})     public IOrdinaryNameDeclaration VariableDeclaration() {
        if(VariableDeclaration_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: VariableDeclaration in class: ");
        VariableDeclaration_visited = state().boundariesCrossed;
        IOrdinaryNameDeclaration VariableDeclaration_value = VariableDeclaration_compute();
        VariableDeclaration_visited = -1;
        return VariableDeclaration_value;
    }

    private IOrdinaryNameDeclaration VariableDeclaration_compute() {  return LookUpOrdinaryName(Name()).isEmpty() ?
			(Declaration)ErrorBuilder().ConstructErrorNode(Declaration.class) :
			LookUpOrdinaryName(Name()).get(0);  }

    protected int Name_visited = -1;
    // Declared in Names.jrag at line 17
 @SuppressWarnings({"unchecked", "cast"})     public String Name() {
        if(Name_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Name in class: ");
        Name_visited = state().boundariesCrossed;
        String Name_value = Name_compute();
        Name_visited = -1;
        return Name_value;
    }

    private String Name_compute() {  return getName().Name();  }

    protected int IsCorrectLocal_visited = -1;
/**
	 * This attribute handles the semantic constraint verification for one
	 * AST node, without traversing the tree, thus sub nodes may still be
	 * incorrect when isCorrectLocal() returns true. In this case it's only
	 * guaranteed that this AST node's semantic constraints are satisfied.
	 
    Declared in LocalConstraints.jrag at line 409
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
		if (VariableDeclaration().IsErrorNode()) {
			StringBuilder errorM = new StringBuilder();
			errorM.append("Ordinary Namespace: [");
			errorM.append(Name());
			errorM.append("] usage.\n\t[");
			errorM.append(Name());
			errorM.append("] not declared.");
			jastaddc.SourceError error =
				new jastaddc.SourceError(errorM.toString());
			error.line = line();
			error.column = column();
			error.sourceName = sourceName();
			error.errorLevel =
				jastaddc.SourceError.ErrorLevel.ERROR;
			error.errorType =
				jastaddc.SourceError.ErrorType.SEMANTICAL;
			addError(error);
			result = false;
		}
		return result;
	}

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
