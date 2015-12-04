
package jastaddc.semantics.ast;



		
public class GotoJump extends JumpStatement implements Cloneable {
    public void flushCache() {
        super.flushCache();
        ReferencedStatement_visited = -1;
        DestinationName_visited = -1;
        IsCorrectLocal_visited = -1;
        ControlFlowSuccessor_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public GotoJump clone() throws CloneNotSupportedException {
        GotoJump node = (GotoJump)super.clone();
        node.ReferencedStatement_visited = -1;
        node.DestinationName_visited = -1;
        node.IsCorrectLocal_visited = -1;
        node.ControlFlowSuccessor_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public GotoJump copy() {
      try {
          GotoJump node = (GotoJump)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public GotoJump fullCopy() {
        GotoJump res = (GotoJump)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 476

    public GotoJump() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 476
    public GotoJump(Identifier p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 14


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 17

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 476
    public void setLabel(Identifier node) {
        setChild(node, 0);
    }

    // Declared in C99AST.ast at line 5

    public Identifier getLabel() {
        return (Identifier)getChild(0);
    }

    // Declared in C99AST.ast at line 9


    public Identifier getLabelNoTransform() {
        return (Identifier)getChildNoTransform(0);
    }

    protected int ReferencedStatement_visited = -1;
    // Declared in ContextInformationAccess.jrag at line 124
 @SuppressWarnings({"unchecked", "cast"})     public LabeledStatement ReferencedStatement() {
        if(ReferencedStatement_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ReferencedStatement in class: ");
        ReferencedStatement_visited = state().boundariesCrossed;
        LabeledStatement ReferencedStatement_value = ReferencedStatement_compute();
        ReferencedStatement_visited = -1;
        return ReferencedStatement_value;
    }

    private LabeledStatement ReferencedStatement_compute() {  return LookUpLabel(DestinationName()).size() == 1 ?
			LookUpLabel(DestinationName()).get(0) :
			(LabeledStatement)ErrorBuilder().ConstructErrorNode(LabeledStatement.class);  }

    protected int DestinationName_visited = -1;
    // Declared in Names.jrag at line 20
 @SuppressWarnings({"unchecked", "cast"})     public String DestinationName() {
        if(DestinationName_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: DestinationName in class: ");
        DestinationName_visited = state().boundariesCrossed;
        String DestinationName_value = DestinationName_compute();
        DestinationName_visited = -1;
        return DestinationName_value;
    }

    private String DestinationName_compute() {  return getLabel().Name();  }

    protected int IsCorrectLocal_visited = -1;
/**
	 * This attribute handles the semantic constraint verification for one
	 * AST node, without traversing the tree, thus sub nodes may still be
	 * incorrect when isCorrectLocal() returns true. In this case it's only
	 * guaranteed that this AST node's semantic constraints are satisfied.
	 
    Declared in LocalConstraints.jrag at line 561
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
		if (LookUpLabel(DestinationName()).size() < 1) {
			StringBuilder errorM = new StringBuilder();
			errorM.append("Control Flow: Jump to [");
			errorM.append(DestinationName());
			errorM.append("].\n\t[");
			errorM.append(DestinationName());
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
		} // else if (LookUpLabel(DestinationName()).size() > 1)
			// Label redeclaration error handeled in ExplicitLabeledStatement
		return result;
	}

    protected int ControlFlowSuccessor_visited = -1;
    // Declared in ControlFlow.jrag at line 85
 @SuppressWarnings({"unchecked", "cast"})     public java.util.Set<Statement> ControlFlowSuccessor() {
        if(ControlFlowSuccessor_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ControlFlowSuccessor in class: ");
        ControlFlowSuccessor_visited = state().boundariesCrossed;
        java.util.Set<Statement> ControlFlowSuccessor_value = ControlFlowSuccessor_compute();
        ControlFlowSuccessor_visited = -1;
        return ControlFlowSuccessor_value;
    }

    private java.util.Set<Statement> ControlFlowSuccessor_compute() {  return SetOp.union(new java.util.HashSet<Statement>(), ReferencedStatement());  }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
