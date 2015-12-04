
package jastaddc.semantics.ast;



		
public abstract class UnionOrStructureElement extends ASTNode<ASTNode> implements Cloneable {
    public void flushCache() {
        super.flushCache();
        IsCorrectLocal_visited = -1;
        StructuredTypeContainingMember_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public UnionOrStructureElement clone() throws CloneNotSupportedException {
        UnionOrStructureElement node = (UnionOrStructureElement)super.clone();
        node.IsCorrectLocal_visited = -1;
        node.StructuredTypeContainingMember_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in ReadableTypeNames.jrag at line 118

	
	/** Internal support methods */
	
	protected abstract String readableElementName();

    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 401

    public UnionOrStructureElement() {
        super();


    }

    // Declared in C99AST.ast at line 10


    // Declared in C99AST.ast line 401
    public UnionOrStructureElement(_IntermediateType p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 14


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 17

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 401
    public void setType(_IntermediateType node) {
        setChild(node, 0);
    }

    // Declared in C99AST.ast at line 5

    public _IntermediateType getType() {
        return (_IntermediateType)getChild(0);
    }

    // Declared in C99AST.ast at line 9


    public _IntermediateType getTypeNoTransform() {
        return (_IntermediateType)getChildNoTransform(0);
    }

    // Declared in CompilerAPI.jrag at line 168
 @SuppressWarnings({"unchecked", "cast"})     public abstract String Name();
    protected int IsCorrectLocal_visited = -1;
/**
	 * This attribute handles the semantic constraint verification for one
	 * AST node, without traversing the tree, thus sub nodes may still be
	 * incorrect when isCorrectLocal() returns true. In this case it's only
	 * guaranteed that this AST node's semantic constraints are satisfied.
	 
    Declared in LocalConstraints.jrag at line 103
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
		UnionOrStructureElement lookedUp =
			StructuredTypeContainingMember().LookUpMember(Name());
		if (lookedUp != this) {
			StringBuilder errorM = new StringBuilder();
			errorM.append("Component Namespace: Member [");
			errorM.append(Name());
			errorM.append("] declaration in [");
			errorM.append(StructuredTypeContainingMember().Name());
			errorM.append("].\n\t[");
			errorM.append(Name());
			errorM.append("] allready declared at ");
			errorM.append(lookedUp.sourceCodeLocation());
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

    protected int StructuredTypeContainingMember_visited = -1;
    // Declared in CompilerAPI.jrag at line 97
 @SuppressWarnings({"unchecked", "cast"})     public StructuredType StructuredTypeContainingMember() {
        if(StructuredTypeContainingMember_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: StructuredTypeContainingMember in class: ");
        StructuredTypeContainingMember_visited = state().boundariesCrossed;
        StructuredType StructuredTypeContainingMember_value = getParent().Define_StructuredType_StructuredTypeContainingMember(this, null);
        StructuredTypeContainingMember_visited = -1;
        return StructuredTypeContainingMember_value;
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
