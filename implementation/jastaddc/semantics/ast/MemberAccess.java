
package jastaddc.semantics.ast;


		/**
		 * The Designation of a MemberAccess must be an expression of type Structure,
		 * Union or Enum.
		 * 
		 * PARSER-CONSTRAINT / REWRITE: Parser rewrites the structure pointer
		 * operator [->]. It does not occur in the AST. Instead it is rewritten to
		 * an indirection operation and a member access. E.g.:
		 *
		 * sp1->sp2->m
		 *
		 * is / will become
		 *
		 * (*((*sp1).sp2)).m
		 * 
		 *        MA
		 *       /  \
		 *      I   M:m
		 *      |
		 *     M A
		 *    /   \
		 *   I    M:sp2
		 *   |
		 *   V
		 *   |
		 *  N:sp1
		 *
		 * with : MA... MemberAccess
		 *        I ... Indirection
		 *        V ... Variable
		 *        N ... Name
		 *        M ... Member
		 */
		
public class MemberAccess extends DesignatorAccess implements Cloneable {
    public void flushCache() {
        super.flushCache();
        DesignationType_visited = -1;
        MemberDeclaration_visited = -1;
        MemberName_visited = -1;
        IsCorrectLocal_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public MemberAccess clone() throws CloneNotSupportedException {
        MemberAccess node = (MemberAccess)super.clone();
        node.DesignationType_visited = -1;
        node.MemberDeclaration_visited = -1;
        node.MemberName_visited = -1;
        node.IsCorrectLocal_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public MemberAccess copy() {
      try {
          MemberAccess node = (MemberAccess)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public MemberAccess fullCopy() {
        MemberAccess res = (MemberAccess)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 547

    public MemberAccess() {
        super();

        setChild(new Opt(), 0);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 547
    public MemberAccess(Opt<Expression> p0, Identifier p1) {
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
    // Declared in C99AST.ast line 547
    public void setMember(Identifier node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public Identifier getMember() {
        return (Identifier)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public Identifier getMemberNoTransform() {
        return (Identifier)getChildNoTransform(1);
    }

    protected int DesignationType_visited = -1;
/**
	 * Always a node's semantics depend on another node, but the computation
	 * on which node may fail because semantic constraints are not met
	 * provide an attribute to access the node this node depends on. If
	 * the node this one depends on does not exist, an error node of the
	 * required type is returned.
	 
    Declared in ContextInformationAccess.jrag at line 73
*/
 @SuppressWarnings({"unchecked", "cast"})     public StructuredType DesignationType() {
        if(DesignationType_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: DesignationType in class: ");
        DesignationType_visited = state().boundariesCrossed;
        StructuredType DesignationType_value = DesignationType_compute();
        DesignationType_visited = -1;
        return DesignationType_value;
    }

    private StructuredType DesignationType_compute() {
		if (!hasDesignation())
			return (StructuredType)ErrorBuilder().ConstructErrorNode(StructuredType.class);
		Type possibleIncompleteType = getDesignation().Type();
		// We can only access structured types:
		if (!(possibleIncompleteType instanceof StructuredType))
			return (StructuredType)ErrorBuilder().ConstructErrorNode(StructuredType.class);
		// Which must be defined, thus must not be incomplete:
		TagedType type = ((StructuredType)possibleIncompleteType).FindCompleteTagedType();
		if (type == null)
			return (StructuredType)ErrorBuilder().ConstructErrorNode(StructuredType.class);
		// And their definition must not be after this member access:
		if (type.NodeAddress().compareTo(NodeAddress()) < 0 && !type.NodeAddress().isSuccessor(NodeAddress()))
			return (StructuredType)ErrorBuilder().ConstructErrorNode(StructuredType.class);
		return (StructuredType)type;
	}

    protected int MemberDeclaration_visited = -1;
    // Declared in ContextInformationAccess.jrag at line 90
 @SuppressWarnings({"unchecked", "cast"})     public UnionOrStructureElement MemberDeclaration() {
        if(MemberDeclaration_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: MemberDeclaration in class: ");
        MemberDeclaration_visited = state().boundariesCrossed;
        UnionOrStructureElement MemberDeclaration_value = MemberDeclaration_compute();
        MemberDeclaration_visited = -1;
        return MemberDeclaration_value;
    }

    private UnionOrStructureElement MemberDeclaration_compute() {  return DesignationType().LookUpMember(MemberName()) != null ?
			DesignationType().LookUpMember(MemberName()) :
			(UnionOrStructureElement)ErrorBuilder().ConstructErrorNode(UnionOrStructureElement.class);  }

    protected int MemberName_visited = -1;
    // Declared in Names.jrag at line 7
 @SuppressWarnings({"unchecked", "cast"})     public String MemberName() {
        if(MemberName_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: MemberName in class: ");
        MemberName_visited = state().boundariesCrossed;
        String MemberName_value = MemberName_compute();
        MemberName_visited = -1;
        return MemberName_value;
    }

    private String MemberName_compute() {  return getMember().Name();  }

    protected int IsCorrectLocal_visited = -1;
/**
	 * This attribute handles the semantic constraint verification for one
	 * AST node, without traversing the tree, thus sub nodes may still be
	 * incorrect when isCorrectLocal() returns true. In this case it's only
	 * guaranteed that this AST node's semantic constraints are satisfied.
	 
    Declared in LocalConstraints.jrag at line 133
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
		if (DesignationType().IsErrorNode()) {
			StringBuilder errorM = new StringBuilder();
			errorM.append("Type: Member [");
			errorM.append(MemberName());
			errorM.append("] access.\n\tThe designation is no structured type.");
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
		else if (MemberDeclaration().IsErrorNode()) {
			StringBuilder errorM = new StringBuilder();
			errorM.append("Component Namespace: Member [");
			errorM.append(MemberName());
			errorM.append("] access.\n\tThe structured type [");
			errorM.append(DesignationType().Name());
			errorM.append("] does not contain the member [");
			errorM.append(MemberName());
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

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
