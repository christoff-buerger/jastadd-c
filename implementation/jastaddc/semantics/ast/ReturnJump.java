
package jastaddc.semantics.ast;


		
public class ReturnJump extends JumpStatement implements Cloneable {
    public void flushCache() {
        super.flushCache();
        ReferencedFunctionDefinition_visited = -1;
        IsCorrectLocal_visited = -1;
        ControlFlowSuccessor_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ReturnJump clone() throws CloneNotSupportedException {
        ReturnJump node = (ReturnJump)super.clone();
        node.ReferencedFunctionDefinition_visited = -1;
        node.IsCorrectLocal_visited = -1;
        node.ControlFlowSuccessor_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ReturnJump copy() {
      try {
          ReturnJump node = (ReturnJump)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ReturnJump fullCopy() {
        ReturnJump res = (ReturnJump)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 479

    public ReturnJump() {
        super();

        setChild(new Opt(), 0);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 479
    public ReturnJump(Opt<Expression> p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 479
    public void setResultOpt(Opt<Expression> opt) {
        setChild(opt, 0);
    }

    // Declared in C99AST.ast at line 6


    public boolean hasResult() {
        return getResultOpt().getNumChild() != 0;
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Expression getResult() {
        return (Expression)getResultOpt().getChild(0);
    }

    // Declared in C99AST.ast at line 14


    public void setResult(Expression node) {
        getResultOpt().setChild(node, 0);
    }

    // Declared in C99AST.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<Expression> getResultOpt() {
        return (Opt<Expression>)getChild(0);
    }

    // Declared in C99AST.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<Expression> getResultOptNoTransform() {
        return (Opt<Expression>)getChildNoTransform(0);
    }

    protected int ReferencedFunctionDefinition_visited = -1;
    // Declared in ContextInformationAccess.jrag at line 148
 @SuppressWarnings({"unchecked", "cast"})     public FunctionDefinitionInitializer ReferencedFunctionDefinition() {
        if(ReferencedFunctionDefinition_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ReferencedFunctionDefinition in class: ");
        ReferencedFunctionDefinition_visited = state().boundariesCrossed;
        FunctionDefinitionInitializer ReferencedFunctionDefinition_value = ReferencedFunctionDefinition_compute();
        ReferencedFunctionDefinition_visited = -1;
        return ReferencedFunctionDefinition_value;
    }

    private FunctionDefinitionInitializer ReferencedFunctionDefinition_compute() {  return FindEnclosingFunctionDefinition() != null ?
			FindEnclosingFunctionDefinition() :
			(FunctionDefinitionInitializer)ErrorBuilder().ConstructErrorNode(FunctionDefinitionInitializer.class);  }

    protected int IsCorrectLocal_visited = -1;
/**
	 * This attribute handles the semantic constraint verification for one
	 * AST node, without traversing the tree, thus sub nodes may still be
	 * incorrect when isCorrectLocal() returns true. In this case it's only
	 * guaranteed that this AST node's semantic constraints are satisfied.
	 
    Declared in LocalConstraints.jrag at line 626
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
		if (ReferencedFunctionDefinition().IsErrorNode()) {
			StringBuilder errorM = new StringBuilder();
			errorM.append("Control Flow: Return jump.\n\tThere exists no enclosing function definition.");
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
    // Declared in ControlFlow.jrag at line 94
 @SuppressWarnings({"unchecked", "cast"})     public java.util.Set<Statement> ControlFlowSuccessor() {
        if(ControlFlowSuccessor_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ControlFlowSuccessor in class: ");
        ControlFlowSuccessor_visited = state().boundariesCrossed;
        java.util.Set<Statement> ControlFlowSuccessor_value = ControlFlowSuccessor_compute();
        ControlFlowSuccessor_visited = -1;
        return ControlFlowSuccessor_value;
    }

    private java.util.Set<Statement> ControlFlowSuccessor_compute() {  return SetOp.union(new java.util.HashSet<Statement>(),
				ReferencedFunctionDefinition().ControlFlowExitNode());  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

    protected void collect_contributors_FunctionDefinitionInitializer_AssociatedReturnJumps() {
    /**
	 * Support for function return statements:
	 
    Declared in FunctionSupport.jrag at line 30
*/
        if((!(ReferencedFunctionDefinition().IsErrorNode()))) {
        {
            FunctionDefinitionInitializer ref = (FunctionDefinitionInitializer)(ReferencedFunctionDefinition());
            if(ref != null)
                ref.FunctionDefinitionInitializer_AssociatedReturnJumps_contributors().add(this);
        }
        }
        super.collect_contributors_FunctionDefinitionInitializer_AssociatedReturnJumps();
    }
    protected void contributeTo_FunctionDefinitionInitializer_FunctionDefinitionInitializer_AssociatedReturnJumps(java.util.List<ReturnJump> collection) {
        super.contributeTo_FunctionDefinitionInitializer_FunctionDefinitionInitializer_AssociatedReturnJumps(collection);
        if((!(ReferencedFunctionDefinition().IsErrorNode())))
            collection.add(this);
    }

}
