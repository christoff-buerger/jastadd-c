
package jastaddc.semantics.ast;


		
public class SwitchStatement extends ConditionalControlFlowStatement implements Cloneable {
    public void flushCache() {
        super.flushCache();
        IsCorrectLocal_visited = -1;
        ControlFlowSuccessor_visited = -1;
        SwitchStatement_AssociatedLabels_visited = -1;
        SwitchStatement_AssociatedLabels_computed = false;
        SwitchStatement_AssociatedLabels_value = null;
    SwitchStatement_AssociatedLabels_contributors = new java.util.HashSet();
    }
     @SuppressWarnings({"unchecked", "cast"})  public SwitchStatement clone() throws CloneNotSupportedException {
        SwitchStatement node = (SwitchStatement)super.clone();
        node.IsCorrectLocal_visited = -1;
        node.ControlFlowSuccessor_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public SwitchStatement copy() {
      try {
          SwitchStatement node = (SwitchStatement)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public SwitchStatement fullCopy() {
        SwitchStatement res = (SwitchStatement)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 457

    public SwitchStatement() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 457
    public SwitchStatement(Expression p0, Statement p1) {
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
    // Declared in C99AST.ast line 454
    public void setCondition(Expression node) {
        setChild(node, 0);
    }

    // Declared in C99AST.ast at line 5

    public Expression getCondition() {
        return (Expression)getChild(0);
    }

    // Declared in C99AST.ast at line 9


    public Expression getConditionNoTransform() {
        return (Expression)getChildNoTransform(0);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 454
    public void setBody(Statement node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public Statement getBody() {
        return (Statement)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public Statement getBodyNoTransform() {
        return (Statement)getChildNoTransform(1);
    }

    protected int IsCorrectLocal_visited = -1;
    // Declared in LocalConstraints.jrag at line 530
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
		java.util.List<Statement> defaults =
			new java.util.LinkedList<Statement>();
		for (Statement stmt:AssociatedLabels()) {
			if (stmt instanceof DefaultLabel)
				defaults.add(stmt);
		}
		if (defaults.size() > 1) {
			StringBuilder errorM = new StringBuilder();
			errorM.append("Labeled Namespace: Switch statement.\n\tThe switch statement has several default labels [");
			for (Statement stmt:defaults) {
				errorM.append(stmt.sourceCodeLocation());
				errorM.append(",");
			}
			errorM.append("].");
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

    protected int ControlFlowSuccessor_visited = -1;
    // Declared in ControlFlow.jrag at line 58
 @SuppressWarnings({"unchecked", "cast"})     public java.util.Set<Statement> ControlFlowSuccessor() {
        if(ControlFlowSuccessor_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ControlFlowSuccessor in class: ");
        ControlFlowSuccessor_visited = state().boundariesCrossed;
        java.util.Set<Statement> ControlFlowSuccessor_value = ControlFlowSuccessor_compute();
        ControlFlowSuccessor_visited = -1;
        return ControlFlowSuccessor_value;
    }

    private java.util.Set<Statement> ControlFlowSuccessor_compute() {
		java.util.Set<Statement> result = new java.util.HashSet<Statement>();
		for (Statement stmt:AssociatedLabels())
			result = SetOp.union(result, stmt);
		return SetOp.union(result, ControlFlowFollowing());
	}

    // Declared in ContextInformationAccess.jrag at line 27
    public SwitchStatement Define_SwitchStatement_FindEnclosingSwitchStatement(ASTNode caller, ASTNode child) {
        if(caller == getBodyNoTransform()) {
            return this;
        }
        return getParent().Define_SwitchStatement_FindEnclosingSwitchStatement(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

    protected int SwitchStatement_AssociatedLabels_visited = -1;
    protected boolean SwitchStatement_AssociatedLabels_computed = false;
    protected java.util.List<LabeledStatement> SwitchStatement_AssociatedLabels_value;
/**
	 * Provide functionality to find all case and default labels of
	 * a switch statement.
	 
    Declared in CompilerAPI.jrag at line 139
*/
 @SuppressWarnings({"unchecked", "cast"})     public java.util.List<LabeledStatement> AssociatedLabels() {
        if(SwitchStatement_AssociatedLabels_computed)
            return SwitchStatement_AssociatedLabels_value;
        if(SwitchStatement_AssociatedLabels_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: AssociatedLabels in class: ");
        SwitchStatement_AssociatedLabels_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        SwitchStatement_AssociatedLabels_value = AssociatedLabels_compute();
        if(isFinal && num == state().boundariesCrossed)
            SwitchStatement_AssociatedLabels_computed = true;
        SwitchStatement_AssociatedLabels_visited = -1;
        return SwitchStatement_AssociatedLabels_value;
    }

    java.util.HashSet SwitchStatement_AssociatedLabels_contributors = new java.util.HashSet();
    public java.util.HashSet SwitchStatement_AssociatedLabels_contributors() { return SwitchStatement_AssociatedLabels_contributors; }
    private java.util.List<LabeledStatement> AssociatedLabels_compute() {
        ASTNode node = this;
        while(node.getParent() != null && !(node instanceof Compilation))
            node = node.getParent();
        Compilation root = (Compilation)node;
        root.collect_contributors_SwitchStatement_AssociatedLabels();
        SwitchStatement_AssociatedLabels_value = new java.util.LinkedList<LabeledStatement>();
        for(java.util.Iterator iter = SwitchStatement_AssociatedLabels_contributors.iterator(); iter.hasNext(); ) {
            ASTNode contributor = (ASTNode)iter.next();
            contributor.contributeTo_SwitchStatement_SwitchStatement_AssociatedLabels(SwitchStatement_AssociatedLabels_value);
        }
        return SwitchStatement_AssociatedLabels_value;
    }

}
