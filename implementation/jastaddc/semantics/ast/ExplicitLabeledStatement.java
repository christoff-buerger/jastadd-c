
package jastaddc.semantics.ast;


	
		
public class ExplicitLabeledStatement extends LabeledStatement implements Cloneable {
    public void flushCache() {
        super.flushCache();
        Name_visited = -1;
        IsCorrectLocal_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ExplicitLabeledStatement clone() throws CloneNotSupportedException {
        ExplicitLabeledStatement node = (ExplicitLabeledStatement)super.clone();
        node.Name_visited = -1;
        node.IsCorrectLocal_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ExplicitLabeledStatement copy() {
      try {
          ExplicitLabeledStatement node = (ExplicitLabeledStatement)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ExplicitLabeledStatement fullCopy() {
        ExplicitLabeledStatement res = (ExplicitLabeledStatement)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 483

    public ExplicitLabeledStatement() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 483
    public ExplicitLabeledStatement(Statement p0, Identifier p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    // Declared in C99AST.ast at line 15


  protected int numChildren() {
    return 2;
  }

    // Declared in C99AST.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 481
    public void setContinuation(Statement node) {
        setChild(node, 0);
    }

    // Declared in C99AST.ast at line 5

    public Statement getContinuation() {
        return (Statement)getChild(0);
    }

    // Declared in C99AST.ast at line 9


    public Statement getContinuationNoTransform() {
        return (Statement)getChildNoTransform(0);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 483
    public void setLabel(Identifier node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public Identifier getLabel() {
        return (Identifier)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public Identifier getLabelNoTransform() {
        return (Identifier)getChildNoTransform(1);
    }

    protected int Name_visited = -1;
    // Declared in Names.jrag at line 21
 @SuppressWarnings({"unchecked", "cast"})     public String Name() {
        if(Name_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Name in class: ");
        Name_visited = state().boundariesCrossed;
        String Name_value = Name_compute();
        Name_visited = -1;
        return Name_value;
    }

    private String Name_compute() {  return getLabel().Name();  }

    protected int IsCorrectLocal_visited = -1;
/**
	 * This attribute handles the semantic constraint verification for one
	 * AST node, without traversing the tree, thus sub nodes may still be
	 * incorrect when isCorrectLocal() returns true. In this case it's only
	 * guaranteed that this AST node's semantic constraints are satisfied.
	 
    Declared in LocalConstraints.jrag at line 381
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
		java.util.List<LabeledStatement> lookedUp =
			LookUpLabel(Name());
		if (lookedUp.size() > 1) {
			StringBuilder errorM = new StringBuilder();
			errorM.append("Label Namespace: [");
			errorM.append(Name());
			errorM.append("] declaration.\n\t[");
			errorM.append(Name());
			errorM.append("] allready declared at ");
			errorM.append(lookedUp.get(0).sourceCodeLocation());
			errorM.append('.');
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

    protected void collect_contributors_ASTNode_LocalLabelDeclarations() {
    /**
	 * The ASTNodes adding some name to the label name space.
	 
    Declared in Labels.jrag at line 41
*/
        {
            ASTNode ref = (ASTNode)(FindNodeIntroducingThisLabelBlock());
            if(ref != null)
                ref.ASTNode_LocalLabelDeclarations_contributors().add(this);
        }
        super.collect_contributors_ASTNode_LocalLabelDeclarations();
    }
    protected void contributeTo_ASTNode_ASTNode_LocalLabelDeclarations(java.util.List<LabeledStatement> collection) {
        super.contributeTo_ASTNode_ASTNode_LocalLabelDeclarations(collection);
        collection.add(this);
    }

}
