
package jastaddc.semantics.ast;



	
public abstract class TagedType extends Type implements Cloneable {
    public void flushCache() {
        super.flushCache();
        buildTypeQualifierCopy_visited = -1;
        IsCorrectLocal_visited = -1;
        FindCompleteTagedType_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public TagedType clone() throws CloneNotSupportedException {
        TagedType node = (TagedType)super.clone();
        node.buildTypeQualifierCopy_visited = -1;
        node.IsCorrectLocal_visited = -1;
        node.FindCompleteTagedType_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 375

    public TagedType() {
        super();

        setChild(new List(), 0);
        setChild(new Opt(), 1);

    }

    // Declared in C99AST.ast at line 12


    // Declared in C99AST.ast line 375
    public TagedType(List<TypeQualifier> p0, Opt<Identifier> p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    // Declared in C99AST.ast at line 17


  protected int numChildren() {
    return 2;
  }

    // Declared in C99AST.ast at line 20

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 214
    public void setTypeQualifierList(List<TypeQualifier> list) {
        setChild(list, 0);
    }

    // Declared in C99AST.ast at line 6


    public int getNumTypeQualifier() {
        return getTypeQualifierList().getNumChild();
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public TypeQualifier getTypeQualifier(int i) {
        return (TypeQualifier)getTypeQualifierList().getChild(i);
    }

    // Declared in C99AST.ast at line 14


    public void addTypeQualifier(TypeQualifier node) {
        List<TypeQualifier> list = getTypeQualifierList();
        list.addChild(node);
    }

    // Declared in C99AST.ast at line 19


    public void setTypeQualifier(TypeQualifier node, int i) {
        List<TypeQualifier> list = getTypeQualifierList();
        list.setChild(node, i);
    }

    // Declared in C99AST.ast at line 23

    public List<TypeQualifier> getTypeQualifiers() {
        return getTypeQualifierList();
    }

    // Declared in C99AST.ast at line 26

    public List<TypeQualifier> getTypeQualifiersNoTransform() {
        return getTypeQualifierListNoTransform();
    }

    // Declared in C99AST.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<TypeQualifier> getTypeQualifierList() {
        return (List<TypeQualifier>)getChild(0);
    }

    // Declared in C99AST.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<TypeQualifier> getTypeQualifierListNoTransform() {
        return (List<TypeQualifier>)getChildNoTransform(0);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 375
    public void setTagOpt(Opt<Identifier> opt) {
        setChild(opt, 1);
    }

    // Declared in C99AST.ast at line 6


    public boolean hasTag() {
        return getTagOpt().getNumChild() != 0;
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Identifier getTag() {
        return (Identifier)getTagOpt().getChild(0);
    }

    // Declared in C99AST.ast at line 14


    public void setTag(Identifier node) {
        getTagOpt().setChild(node, 0);
    }

    // Declared in C99AST.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<Identifier> getTagOpt() {
        return (Opt<Identifier>)getChild(1);
    }

    // Declared in C99AST.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<Identifier> getTagOptNoTransform() {
        return (Opt<Identifier>)getChildNoTransform(1);
    }

    // Declared in CompilerAPI.jrag at line 166
 @SuppressWarnings({"unchecked", "cast"})     public abstract String Name();
/**
	 * Provide functionality to decide whether a TagedType is an
	 * incomplete type or not.
	 
    Declared in CompilerAPI.jrag at line 317
*/
 @SuppressWarnings({"unchecked", "cast"})     public abstract boolean IsIncompleteType();
/**
	 * Support the construction of reference nodes to taged types:
	 
    Declared in CompilerAPI.jrag at line 458
*/
 @SuppressWarnings({"unchecked", "cast"})     public abstract Type buildQualifiedReference();
    protected int buildTypeQualifierCopy_visited = -1;
    // Declared in CompilerAPI.jrag at line 466
 @SuppressWarnings({"unchecked", "cast"})     public List<TypeQualifier> buildTypeQualifierCopy() {
        if(buildTypeQualifierCopy_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: buildTypeQualifierCopy in class: ");
        buildTypeQualifierCopy_visited = state().boundariesCrossed;
        List<TypeQualifier> buildTypeQualifierCopy_value = buildTypeQualifierCopy_compute();
        buildTypeQualifierCopy_visited = -1;
        return buildTypeQualifierCopy_value;
    }

    private List<TypeQualifier> buildTypeQualifierCopy_compute() {
		List<TypeQualifier> result = new List<TypeQualifier>();
		for (int i = 0; i < getNumTypeQualifier(); i++)
			result.add((TypeQualifier)getTypeQualifier(i).copy());
		return result;
	}

    protected int IsCorrectLocal_visited = -1;
/**
	 * This attribute handles the semantic constraint verification for one
	 * AST node, without traversing the tree, thus sub nodes may still be
	 * incorrect when isCorrectLocal() returns true. In this case it's only
	 * guaranteed that this AST node's semantic constraints are satisfied.
	 
    Declared in LocalConstraints.jrag at line 39
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
		if (hasTag()) {
			java.util.List<TagedType> lookedUp =
				LookUpTag(Name());
			// If the same tag name is declared/defined for different
			// types a redeclaration error is given, e.g.
			// struct s;
			// union s; /* redeclaration */
			java.util.List<TagedType> redeclarations =
				ListFilter.filter(lookedUp,
						new TagedTypeTypeFilter(this.getClass().getName(), false));
			if (redeclarations.size() > 0) {
				StringBuilder errorM = new StringBuilder();
				errorM.append("Tag Namespace: [");
				errorM.append(Name());
				errorM.append("] declaration.\n\tTag entity of different type named [");
				errorM.append(Name());
				errorM.append("] allready declared at ");
				errorM.append(redeclarations.get(0).sourceCodeLocation());
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
			// If the same tag entity is defined several times
			// a redeclaration error is given:
			if (!IsIncompleteType()) {
				redeclarations = ListFilter.filter(lookedUp,
						new CompleteTagedTypeFilter());
				if (redeclarations.size() > 1) {
					StringBuilder errorM = new StringBuilder();
					errorM.append("Tag Namespace: [");
					errorM.append(Name());
					errorM.append("] declaration.\n\t[");
					errorM.append(Name());
					errorM.append("] allready declared at ");
					errorM.append(redeclarations.get(0).sourceCodeLocation());
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
			}
		}
		return result;
	}

    protected int FindCompleteTagedType_visited = -1;
/**
	 * Provide functionallity to retrieve for each TagedType its real
	 * type definition.
	 
    Declared in Tags.jrag at line 15
*/
	// If an incomplete type is defined (made complete) this must be
	// in the same block (the type definition may be after or even
	// before the incomplete type declaration in this block).
 @SuppressWarnings({"unchecked", "cast"})     public TagedType FindCompleteTagedType() {
        if(FindCompleteTagedType_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: FindCompleteTagedType in class: ");
        FindCompleteTagedType_visited = state().boundariesCrossed;
        TagedType FindCompleteTagedType_value = FindCompleteTagedType_compute();
        FindCompleteTagedType_visited = -1;
        return FindCompleteTagedType_value;
    }

    private TagedType FindCompleteTagedType_compute() {
		if (!IsIncompleteType())
			return this;
		java.util.List<TagedType> types = ListFilter.filter(
				FindNodeIntroducingThisTagBlock().LocalTagDeclarations(),
				new CompleteTagedTypeFilter(
						new TagedTypeTypeFilter(
								new TagNameFilter(
										new AddressFilter(
												FindNodeIntroducingThisTagBlock().NodeAddress()),
										Name()),
								this.getClass().getName(),
								true)));
		return !types.isEmpty() ? types.get(0) : null;
	}

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

    protected void collect_contributors_ASTNode_LocalTagDeclarations() {
    /**
	 * The ASTNodes adding some tag name to the name space.
	 
    Declared in Tags.jrag at line 74
*/
	// Adding enumeration, structure and union tags:
        if(hasTag()) {
        {
            ASTNode ref = (ASTNode)(FindNodeIntroducingThisTagBlock());
            if(ref != null)
                ref.ASTNode_LocalTagDeclarations_contributors().add(this);
        }
        }
        super.collect_contributors_ASTNode_LocalTagDeclarations();
    }
    protected void contributeTo_ASTNode_ASTNode_LocalTagDeclarations(java.util.List<TagedType> collection) {
        super.contributeTo_ASTNode_ASTNode_LocalTagDeclarations(collection);
        if(hasTag())
            collection.add(this);
    }

}
