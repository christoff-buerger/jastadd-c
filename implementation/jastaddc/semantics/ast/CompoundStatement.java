
package jastaddc.semantics.ast;


	
	/**
	 * Instead to the standard, here a declaration is a statement, thus
	 * Declaration:Statement ::= ...
	 * 
	 * PARSER-CONSTRAINT: The parser guarantees, that declarations do not
	 * occur, where only statements are allowed. E.g.:
	 * 
	 * Label: int a; // not allowed in C99 : a declaration is no statement
	 * 
	 * if (i)
	 *    int i; // not allowed in C99 : a declaration is no statement
	 * 
	 * switch(i)
	 *    case 1:int i=2; // not allowed in C99 : a declaration is no statement
	 * 
	 * switch(i)
	 *    int i=2; // not allowed in C99 : a declaration is no statement
	 * 	
	 * do
	 *    int i=2; // not allowed in C99 : a declaration is no statement
	 * while(!i);
	 * 
	 * while (i--)
	 *    int i=2; // not allowed in C99 : a declaration is no statement
	 * 
	 * for (i=3;i>0;i--)
	 *    int i; // not allowed in C99 : a declaration is no statement
	 * 
	 * will result in parsing errors, as the C99 grammar does not allow such
	 * constructions.
	 */
	
public class CompoundStatement extends Statement implements Cloneable {
    public void flushCache() {
        super.flushCache();
        IsNodeTypeOrdinaryNameBlock_visited = -1;
        ControlFlowSuccessor_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public CompoundStatement clone() throws CloneNotSupportedException {
        CompoundStatement node = (CompoundStatement)super.clone();
        node.IsNodeTypeOrdinaryNameBlock_visited = -1;
        node.ControlFlowSuccessor_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public CompoundStatement copy() {
      try {
          CompoundStatement node = (CompoundStatement)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public CompoundStatement fullCopy() {
        CompoundStatement res = (CompoundStatement)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 452

    public CompoundStatement() {
        super();

        setChild(new List(), 0);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 452
    public CompoundStatement(List<Statement> p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 452
    public void setStatementList(List<Statement> list) {
        setChild(list, 0);
    }

    // Declared in C99AST.ast at line 6


    public int getNumStatement() {
        return getStatementList().getNumChild();
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Statement getStatement(int i) {
        return (Statement)getStatementList().getChild(i);
    }

    // Declared in C99AST.ast at line 14


    public void addStatement(Statement node) {
        List<Statement> list = getStatementList();
        list.addChild(node);
    }

    // Declared in C99AST.ast at line 19


    public void setStatement(Statement node, int i) {
        List<Statement> list = getStatementList();
        list.setChild(node, i);
    }

    // Declared in C99AST.ast at line 23

    public List<Statement> getStatements() {
        return getStatementList();
    }

    // Declared in C99AST.ast at line 26

    public List<Statement> getStatementsNoTransform() {
        return getStatementListNoTransform();
    }

    // Declared in C99AST.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<Statement> getStatementList() {
        return (List<Statement>)getChild(0);
    }

    // Declared in C99AST.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<Statement> getStatementListNoTransform() {
        return (List<Statement>)getChildNoTransform(0);
    }

    protected int IsNodeTypeOrdinaryNameBlock_visited = -1;
    // Declared in OrdinaryNames.jrag at line 45
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsNodeTypeOrdinaryNameBlock() {
        if(IsNodeTypeOrdinaryNameBlock_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsNodeTypeOrdinaryNameBlock in class: ");
        IsNodeTypeOrdinaryNameBlock_visited = state().boundariesCrossed;
        boolean IsNodeTypeOrdinaryNameBlock_value = IsNodeTypeOrdinaryNameBlock_compute();
        IsNodeTypeOrdinaryNameBlock_visited = -1;
        return IsNodeTypeOrdinaryNameBlock_value;
    }

    private boolean IsNodeTypeOrdinaryNameBlock_compute() {  return true;  }

    protected int ControlFlowSuccessor_visited = -1;
/** Specify control flow for nodes different from the default behavior 
    Declared in ControlFlow.jrag at line 45
*/
 @SuppressWarnings({"unchecked", "cast"})     public java.util.Set<Statement> ControlFlowSuccessor() {
        if(ControlFlowSuccessor_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ControlFlowSuccessor in class: ");
        ControlFlowSuccessor_visited = state().boundariesCrossed;
        java.util.Set<Statement> ControlFlowSuccessor_value = ControlFlowSuccessor_compute();
        ControlFlowSuccessor_visited = -1;
        return ControlFlowSuccessor_value;
    }

    private java.util.Set<Statement> ControlFlowSuccessor_compute() {  return getNumStatement() != 0 ?
				SetOp.union(new java.util.HashSet<Statement>(), getStatement(0)) :
				ControlFlowFollowing();  }

    // Declared in ControlFlow.jrag at line 49
    public java.util.Set<Statement> Define_java_util_Set_Statement__ControlFlowFollowing(ASTNode caller, ASTNode child) {
        if(caller == getStatementListNoTransform()) {
      int index = caller.getIndexOfChild(child);
            return index != getNumStatement() - 1 ?
				SetOp.union(new java.util.HashSet<Statement>(), getStatement(index + 1)) :
				ControlFlowFollowing();
        }
        return getParent().Define_java_util_Set_Statement__ControlFlowFollowing(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
