
package jastaddc.semantics.ast;


		
public class BreakJump extends JumpStatement implements Cloneable {
    public void flushCache() {
        super.flushCache();
        ReferencedConditionalControlFlowStatement_visited = -1;
        IsCorrectLocal_visited = -1;
        ControlFlowSuccessor_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public BreakJump clone() throws CloneNotSupportedException {
        BreakJump node = (BreakJump)super.clone();
        node.ReferencedConditionalControlFlowStatement_visited = -1;
        node.IsCorrectLocal_visited = -1;
        node.ControlFlowSuccessor_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public BreakJump copy() {
      try {
          BreakJump node = (BreakJump)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public BreakJump fullCopy() {
        BreakJump res = (BreakJump)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 478

    public BreakJump() {
        super();


    }

    // Declared in C99AST.ast at line 9


  protected int numChildren() {
    return 0;
  }

    // Declared in C99AST.ast at line 12

  public boolean mayHaveRewrite() { return false; }

    protected int ReferencedConditionalControlFlowStatement_visited = -1;
    // Declared in ContextInformationAccess.jrag at line 132
 @SuppressWarnings({"unchecked", "cast"})     public ConditionalControlFlowStatement ReferencedConditionalControlFlowStatement() {
        if(ReferencedConditionalControlFlowStatement_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ReferencedConditionalControlFlowStatement in class: ");
        ReferencedConditionalControlFlowStatement_visited = state().boundariesCrossed;
        ConditionalControlFlowStatement ReferencedConditionalControlFlowStatement_value = ReferencedConditionalControlFlowStatement_compute();
        ReferencedConditionalControlFlowStatement_visited = -1;
        return ReferencedConditionalControlFlowStatement_value;
    }

    private ConditionalControlFlowStatement ReferencedConditionalControlFlowStatement_compute() {  return FindEnclosingLoopStatement() != null ?
				(FindEnclosingSwitchStatement() != null ?
						// Is the loop statement before the switch statement:
						(FindEnclosingLoopStatement().NodeAddress().compareTo(FindEnclosingSwitchStatement().NodeAddress()) > 0 || FindEnclosingSwitchStatement().NodeAddress().isSuccessor(FindEnclosingLoopStatement().NodeAddress()) ?
								// The switch statement is nearer to the break:
								FindEnclosingSwitchStatement() :
								// The loop statement is nearer to the break:
								FindEnclosingLoopStatement()) :
						// There exists only an enclosing loop statement, but no enclosing switch:
						FindEnclosingLoopStatement()) :
				// There exists no enclosing loop statement, but a switch may exist:
				(FindEnclosingSwitchStatement() != null ?
						FindEnclosingSwitchStatement() :
						(ConditionalControlFlowStatement)ErrorBuilder().ConstructErrorNode(ConditionalControlFlowStatement.class));  }

    protected int IsCorrectLocal_visited = -1;
/**
	 * This attribute handles the semantic constraint verification for one
	 * AST node, without traversing the tree, thus sub nodes may still be
	 * incorrect when isCorrectLocal() returns true. In this case it's only
	 * guaranteed that this AST node's semantic constraints are satisfied.
	 
    Declared in LocalConstraints.jrag at line 606
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
		if (ReferencedConditionalControlFlowStatement().IsErrorNode()) {
			StringBuilder errorM = new StringBuilder();
			errorM.append("Control Flow: Break jump.\n\tThere exists no enclosing loop or switch statement.");
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
    // Declared in ControlFlow.jrag at line 91
 @SuppressWarnings({"unchecked", "cast"})     public java.util.Set<Statement> ControlFlowSuccessor() {
        if(ControlFlowSuccessor_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ControlFlowSuccessor in class: ");
        ControlFlowSuccessor_visited = state().boundariesCrossed;
        java.util.Set<Statement> ControlFlowSuccessor_value = ControlFlowSuccessor_compute();
        ControlFlowSuccessor_visited = -1;
        return ControlFlowSuccessor_value;
    }

    private java.util.Set<Statement> ControlFlowSuccessor_compute() {  return ReferencedConditionalControlFlowStatement().ControlFlowFollowing();  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
