
package jastaddc.semantics.ast;


		
		
public abstract class SwitchLabelStatement extends LabeledStatement implements Cloneable {
    public void flushCache() {
        super.flushCache();
        AssociatedSwitchStatement_visited = -1;
        IsCorrectLocal_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public SwitchLabelStatement clone() throws CloneNotSupportedException {
        SwitchLabelStatement node = (SwitchLabelStatement)super.clone();
        node.AssociatedSwitchStatement_visited = -1;
        node.IsCorrectLocal_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 485

    public SwitchLabelStatement() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 485
    public SwitchLabelStatement(Statement p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 14


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 17

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

    protected int AssociatedSwitchStatement_visited = -1;
    // Declared in ContextInformationAccess.jrag at line 152
 @SuppressWarnings({"unchecked", "cast"})     public SwitchStatement AssociatedSwitchStatement() {
        if(AssociatedSwitchStatement_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: AssociatedSwitchStatement in class: ");
        AssociatedSwitchStatement_visited = state().boundariesCrossed;
        SwitchStatement AssociatedSwitchStatement_value = AssociatedSwitchStatement_compute();
        AssociatedSwitchStatement_visited = -1;
        return AssociatedSwitchStatement_value;
    }

    private SwitchStatement AssociatedSwitchStatement_compute() {  return FindEnclosingSwitchStatement() != null ?
			FindEnclosingSwitchStatement() :
			(SwitchStatement)ErrorBuilder().ConstructErrorNode(SwitchStatement.class);  }

    protected int IsCorrectLocal_visited = -1;
/**
	 * This attribute handles the semantic constraint verification for one
	 * AST node, without traversing the tree, thus sub nodes may still be
	 * incorrect when isCorrectLocal() returns true. In this case it's only
	 * guaranteed that this AST node's semantic constraints are satisfied.
	 
    Declared in LocalConstraints.jrag at line 646
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
		if (AssociatedSwitchStatement().IsErrorNode()) {
			StringBuilder errorM = new StringBuilder();
			errorM.append("Control Flow: Switch label.\n\tThere exists no enclosing switch statement.");
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

    protected void collect_contributors_SwitchStatement_AssociatedLabels() {
    /**
	 * Provide functionality to find all case and default labels of
	 * a switch statement.
	 
    Declared in SwitchSupport.jrag at line 8
*/
        {
            SwitchStatement ref = (SwitchStatement)(AssociatedSwitchStatement());
            if(ref != null)
                ref.SwitchStatement_AssociatedLabels_contributors().add(this);
        }
        super.collect_contributors_SwitchStatement_AssociatedLabels();
    }
    protected void contributeTo_SwitchStatement_SwitchStatement_AssociatedLabels(java.util.List<LabeledStatement> collection) {
        super.contributeTo_SwitchStatement_SwitchStatement_AssociatedLabels(collection);
        collection.add(this);
    }

}
