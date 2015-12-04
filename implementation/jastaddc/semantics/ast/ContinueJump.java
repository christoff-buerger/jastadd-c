
package jastaddc.semantics.ast;


		
public class ContinueJump extends JumpStatement implements Cloneable {
    public void flushCache() {
        super.flushCache();
        ReferencedLoop_visited = -1;
        IsCorrectLocal_visited = -1;
        ControlFlowSuccessor_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ContinueJump clone() throws CloneNotSupportedException {
        ContinueJump node = (ContinueJump)super.clone();
        node.ReferencedLoop_visited = -1;
        node.IsCorrectLocal_visited = -1;
        node.ControlFlowSuccessor_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ContinueJump copy() {
      try {
          ContinueJump node = (ContinueJump)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ContinueJump fullCopy() {
        ContinueJump res = (ContinueJump)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 477

    public ContinueJump() {
        super();


    }

    // Declared in C99AST.ast at line 9


  protected int numChildren() {
    return 0;
  }

    // Declared in C99AST.ast at line 12

  public boolean mayHaveRewrite() { return false; }

    protected int ReferencedLoop_visited = -1;
    // Declared in ContextInformationAccess.jrag at line 128
 @SuppressWarnings({"unchecked", "cast"})     public ConditionalControlFlowStatement ReferencedLoop() {
        if(ReferencedLoop_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ReferencedLoop in class: ");
        ReferencedLoop_visited = state().boundariesCrossed;
        ConditionalControlFlowStatement ReferencedLoop_value = ReferencedLoop_compute();
        ReferencedLoop_visited = -1;
        return ReferencedLoop_value;
    }

    private ConditionalControlFlowStatement ReferencedLoop_compute() {  return FindEnclosingLoopStatement() != null ?
			FindEnclosingLoopStatement() :
			(ConditionalControlFlowStatement)ErrorBuilder().ConstructErrorNode(ConditionalControlFlowStatement.class);  }

    protected int IsCorrectLocal_visited = -1;
/**
	 * This attribute handles the semantic constraint verification for one
	 * AST node, without traversing the tree, thus sub nodes may still be
	 * incorrect when isCorrectLocal() returns true. In this case it's only
	 * guaranteed that this AST node's semantic constraints are satisfied.
	 
    Declared in LocalConstraints.jrag at line 586
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
		if (ReferencedLoop().IsErrorNode()) {
			StringBuilder errorM = new StringBuilder();
			errorM.append("Control Flow: Continue jump.\n\tThere exists no enclosing loop.");
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
    // Declared in ControlFlow.jrag at line 88
 @SuppressWarnings({"unchecked", "cast"})     public java.util.Set<Statement> ControlFlowSuccessor() {
        if(ControlFlowSuccessor_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ControlFlowSuccessor in class: ");
        ControlFlowSuccessor_visited = state().boundariesCrossed;
        java.util.Set<Statement> ControlFlowSuccessor_value = ControlFlowSuccessor_compute();
        ControlFlowSuccessor_visited = -1;
        return ControlFlowSuccessor_value;
    }

    private java.util.Set<Statement> ControlFlowSuccessor_compute() {  return SetOp.union(new java.util.HashSet<Statement>(), ReferencedLoop());  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
