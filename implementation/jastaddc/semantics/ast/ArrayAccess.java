
package jastaddc.semantics.ast;


		/**
		 * One of the designation expressions shall have type "pointer to object type"
		 * the other shall have integer type [6.5.2.1:1] p.70.
		 */
		
public class ArrayAccess extends DesignatorAccess implements Cloneable {
    public void flushCache() {
        super.flushCache();
        DesignationExpression_visited = -1;
        IndexExpression_visited = -1;
        IsCorrectLocal_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ArrayAccess clone() throws CloneNotSupportedException {
        ArrayAccess node = (ArrayAccess)super.clone();
        node.DesignationExpression_visited = -1;
        node.IndexExpression_visited = -1;
        node.IsCorrectLocal_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ArrayAccess copy() {
      try {
          ArrayAccess node = (ArrayAccess)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ArrayAccess fullCopy() {
        ArrayAccess res = (ArrayAccess)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 552

    public ArrayAccess() {
        super();

        setChild(new Opt(), 0);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 552
    public ArrayAccess(Opt<Expression> p0, Expression p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    // Declared in C99AST.ast at line 16


  protected int numChildren() {
    return 2;
  }

    // Declared in C99AST.ast at line 19

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 514
    public void setDesignationOpt(Opt<Expression> opt) {
        setChild(opt, 0);
    }

    // Declared in C99AST.ast at line 6


    public boolean hasDesignation() {
        return getDesignationOpt().getNumChild() != 0;
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Expression getDesignation() {
        return (Expression)getDesignationOpt().getChild(0);
    }

    // Declared in C99AST.ast at line 14


    public void setDesignation(Expression node) {
        getDesignationOpt().setChild(node, 0);
    }

    // Declared in C99AST.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<Expression> getDesignationOpt() {
        return (Opt<Expression>)getChild(0);
    }

    // Declared in C99AST.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<Expression> getDesignationOptNoTransform() {
        return (Opt<Expression>)getChildNoTransform(0);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 552
    public void setDesignation2(Expression node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public Expression getDesignation2() {
        return (Expression)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public Expression getDesignation2NoTransform() {
        return (Expression)getChildNoTransform(1);
    }

    protected int DesignationExpression_visited = -1;
/**
	 * Access support for remote nodes in the AST, this node depends on, but
	 * the computation for the reference may fail because semantic constraints are
	 * not met.
	 
    Declared in ContextInformationAccess.jrag at line 49
*/
	
	// One of the ArrayAccess expressions shall have type "pointer to object type",
	// the other expression shall have integer type [6.5.2.1:1] p.70:
 @SuppressWarnings({"unchecked", "cast"})     public Expression DesignationExpression() {
        if(DesignationExpression_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: DesignationExpression in class: ");
        DesignationExpression_visited = state().boundariesCrossed;
        Expression DesignationExpression_value = DesignationExpression_compute();
        DesignationExpression_visited = -1;
        return DesignationExpression_value;
    }

    private Expression DesignationExpression_compute() {  return hasDesignation() && getDesignation().Type().RetrieveFinalNode() instanceof Pointer &&
		!((Pointer)getDesignation().Type().RetrieveFinalNode()).IsFunctionPointer() &&
		!((Pointer)getDesignation().Type().RetrieveFinalNode()).IsVoidPointer() ?
				(getDesignation2().Type().RetrieveFinalNode() instanceof Pointer &&
				!((Pointer)getDesignation2().Type().RetrieveFinalNode()).IsFunctionPointer() &&
				!((Pointer)getDesignation2().Type().RetrieveFinalNode()).IsVoidPointer() ?
						(Expression)ErrorBuilder().ConstructErrorNode(Expression.class) :
						getDesignation()) :
				(getDesignation2().Type().RetrieveFinalNode() instanceof Pointer &&
				!((Pointer)getDesignation2().Type().RetrieveFinalNode()).IsFunctionPointer() &&
				!((Pointer)getDesignation2().Type().RetrieveFinalNode()).IsVoidPointer() ?
						getDesignation2() :
						(Expression)ErrorBuilder().ConstructErrorNode(Expression.class));  }

    protected int IndexExpression_visited = -1;
    // Declared in ContextInformationAccess.jrag at line 64
 @SuppressWarnings({"unchecked", "cast"})     public Expression IndexExpression() {
        if(IndexExpression_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IndexExpression in class: ");
        IndexExpression_visited = state().boundariesCrossed;
        Expression IndexExpression_value = IndexExpression_compute();
        IndexExpression_visited = -1;
        return IndexExpression_value;
    }

    private Expression IndexExpression_compute() {  return hasDesignation() && getDesignation().Type().RetrieveFinalNode().IsIntegerType() ?
				(getDesignation2().Type().RetrieveFinalNode().IsIntegerType() ?
						(Expression)ErrorBuilder().ConstructErrorNode(Expression.class) :
						getDesignation()) :
				(getDesignation2().Type().RetrieveFinalNode().IsIntegerType() ?
						getDesignation2() :
						(Expression)ErrorBuilder().ConstructErrorNode(Expression.class));  }

    protected int IsCorrectLocal_visited = -1;
/**
	 * This attribute handles the semantic constraint verification for one
	 * AST node, without traversing the tree, thus sub nodes may still be
	 * incorrect when isCorrectLocal() returns true. In this case it's only
	 * guaranteed that this AST node's semantic constraints are satisfied.
	 
    Declared in LocalConstraints.jrag at line 176
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
		if (DesignationExpression().IsErrorNode()) {
			StringBuilder errorM = new StringBuilder();
			errorM.append("Type: Array access.\n\tNo array designation expression given (pointer to object type).");
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
		if (IndexExpression().IsErrorNode()) {
			StringBuilder errorM = new StringBuilder();
			errorM.append("Type: Array access.\n\tNo index expression given (integer type).");
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
