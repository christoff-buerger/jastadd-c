
package jastaddc.semantics.ast;


		
			/**
			 * REWRITE: The value of an enumeration is given implicit [6.7.2.2;3] S.105.
			 * 
			 * REWRITE: The type of enumeration elements is implicitly given to be int
			 * [6.7.2.2:3] S.105. It must be ensured, that this implicit type is made
			 * explicit, by guaranteeing, that the enumeration element's type node
			 * represents an int.
			 */
			
public class EnumerationElement extends ASTNode<ASTNode> implements Cloneable, IOrdinaryNameDeclaration {
    public void flushCache() {
        super.flushCache();
        Name_visited = -1;
        IsCorrectLocal_visited = -1;
        getType_visited = -1;
        getType_computed = false;
        getType_value = null;
        EnumerationContainingElement_visited = -1;
        PreviousElement_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public EnumerationElement clone() throws CloneNotSupportedException {
        EnumerationElement node = (EnumerationElement)super.clone();
        node.Name_visited = -1;
        node.IsCorrectLocal_visited = -1;
        node.getType_visited = -1;
        node.getType_computed = false;
        node.getType_value = null;
        node.EnumerationContainingElement_visited = -1;
        node.PreviousElement_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public EnumerationElement copy() {
      try {
          EnumerationElement node = (EnumerationElement)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public EnumerationElement fullCopy() {
        EnumerationElement res = (EnumerationElement)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in CompilerAPI.jrag at line 334

	public boolean hasBindedName() {return true;}

    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 386

    public EnumerationElement() {
        super();

        setChild(new Opt(), 1);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 386
    public EnumerationElement(Identifier p0, Opt<Expression> p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }

    // Declared in C99AST.ast at line 16


  protected int numChildren() {
    return 2;
  }

    // Declared in C99AST.ast at line 19

  public boolean mayHaveRewrite() { return true; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 386
    public void setBindedName(Identifier node) {
        setChild(node, 0);
    }

    // Declared in C99AST.ast at line 5

    public Identifier getBindedName() {
        return (Identifier)getChild(0);
    }

    // Declared in C99AST.ast at line 9


    public Identifier getBindedNameNoTransform() {
        return (Identifier)getChildNoTransform(0);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 386
    public void setValueOpt(Opt<Expression> opt) {
        setChild(opt, 1);
    }

    // Declared in C99AST.ast at line 6


    public boolean hasValue() {
        return getValueOpt().getNumChild() != 0;
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Expression getValue() {
        return (Expression)getValueOpt().getChild(0);
    }

    // Declared in C99AST.ast at line 14


    public void setValue(Expression node) {
        getValueOpt().setChild(node, 0);
    }

    // Declared in C99AST.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<Expression> getValueOpt() {
        return (Opt<Expression>)getChild(1);
    }

    // Declared in C99AST.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<Expression> getValueOptNoTransform() {
        return (Opt<Expression>)getChildNoTransform(1);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 386
    public void setType(_IntermediateType node) {
        setChild(node, 2);
    }

    // Declared in C99AST.ast at line 5

    public _IntermediateType getTypeNoTransform() {
        return (_IntermediateType)getChildNoTransform(2);
    }

    // Declared in C99AST.ast at line 9


    protected int getTypeChildPosition() {
        return 2;
    }

    protected int Name_visited = -1;
    // Declared in Names.jrag at line 6
 @SuppressWarnings({"unchecked", "cast"})     public String Name() {
        if(Name_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Name in class: ");
        Name_visited = state().boundariesCrossed;
        String Name_value = Name_compute();
        Name_visited = -1;
        return Name_value;
    }

    private String Name_compute() {  return getBindedName().Name();  }

    protected int IsCorrectLocal_visited = -1;
/**
	 * This attribute handles the semantic constraint verification for one
	 * AST node, without traversing the tree, thus sub nodes may still be
	 * incorrect when isCorrectLocal() returns true. In this case it's only
	 * guaranteed that this AST node's semantic constraints are satisfied.
	 
    Declared in LocalConstraints.jrag at line 9
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
		java.util.List<IOrdinaryNameDeclaration> lookedUp =
			LookUpOrdinaryName(Name());
		if (lookedUp.size() > 1) {
			StringBuilder errorM = new StringBuilder();
			errorM.append("Ordinary Namespace: Enumeration element [");
			errorM.append(Name());
			errorM.append("] declaration in [");
			errorM.append(EnumerationContainingElement().Name());
			errorM.append("].\n\t[");
			errorM.append(Name());
			errorM.append("] allready declared at ");
			errorM.append(((ASTNode)lookedUp.get(0)).sourceCodeLocation());
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

    protected int getType_visited = -1;
    protected boolean getType_computed = false;
    protected _IntermediateType getType_value;
/** Enumerations 
    Declared in Enumerations.jrag at line 8
*/
	
	// Enumeration members have type int [6.7.2.2;3] S.105.
 @SuppressWarnings({"unchecked", "cast"})     public _IntermediateType getType() {
        if(getType_computed)
            return (_IntermediateType)ASTNode.getChild(this, getTypeChildPosition());
        if(getType_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: getType in class: ");
        getType_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        getType_value = getType_compute();
            setType(getType_value);
        if(isFinal && num == state().boundariesCrossed)
            getType_computed = true;
        getType_visited = -1;
        return (_IntermediateType)ASTNode.getChild(this, getTypeChildPosition());
    }

    private _IntermediateType getType_compute() {  return new PrimitiveType(
			new List(),
			jastaddc.semantics.PrimitiveTypes._signed_int);  }

    protected int EnumerationContainingElement_visited = -1;
/**
	 * Provide functionallity to access certain ancestor nodes, important for
	 * needed context informations.
	 
    Declared in CompilerAPI.jrag at line 96
*/
 @SuppressWarnings({"unchecked", "cast"})     public Enumeration EnumerationContainingElement() {
        if(EnumerationContainingElement_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: EnumerationContainingElement in class: ");
        EnumerationContainingElement_visited = state().boundariesCrossed;
        Enumeration EnumerationContainingElement_value = getParent().Define_Enumeration_EnumerationContainingElement(this, null);
        EnumerationContainingElement_visited = -1;
        return EnumerationContainingElement_value;
    }

    protected int PreviousElement_visited = -1;
/** Internal support methods 
    Declared in Enumerations.jrag at line 43
*/
 @SuppressWarnings({"unchecked", "cast"})     public EnumerationElement PreviousElement() {
        if(PreviousElement_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: PreviousElement in class: ");
        PreviousElement_visited = state().boundariesCrossed;
        EnumerationElement PreviousElement_value = getParent().Define_EnumerationElement_PreviousElement(this, null);
        PreviousElement_visited = -1;
        return PreviousElement_value;
    }

public ASTNode rewriteTo() {
    // Declared in Enumerations.jrag at line 16
    if(!hasValue()) {
        state().duringEnumerations++;
        ASTNode result = rewriteRule0();
        state().duringEnumerations--;
        return result;
    }

    return super.rewriteTo();
}

    // Declared in Enumerations.jrag at line 16
    private EnumerationElement rewriteRule0() {
{
			EnumerationElement elem = PreviousElement();
			if (elem == null) {
				IntegerConstant value = new IntegerConstant(
						"0",
						"0",
						new NumeralSystemOctal(),
						new PrimitiveType(new List(), jastaddc.semantics.PrimitiveTypes._signed_int));
				setValue(value);
			} else {
				IntegerConstant value = new IntegerConstant(
						"1",
						"1",
						new NumeralSystemOctal(),
						new PrimitiveType(new List(), jastaddc.semantics.PrimitiveTypes._signed_int));
				Addition valueExpr = new Addition(
						new Variable(new Identifier(elem.Name())),
						value);
				setValue(valueExpr);
			}
			return this;
		}    }
    protected void collect_contributors_ASTNode_LocalOrdinaryNameDeclarations() {
        // Declared in OrdinaryNames.jrag at line 61
        {
            ASTNode ref = (ASTNode)(FindNodeIntroducingThisOrdinaryNameBlock());
            if(ref != null)
                ref.ASTNode_LocalOrdinaryNameDeclarations_contributors().add(this);
        }
        super.collect_contributors_ASTNode_LocalOrdinaryNameDeclarations();
    }
    protected void contributeTo_ASTNode_ASTNode_LocalOrdinaryNameDeclarations(java.util.List<IOrdinaryNameDeclaration> collection) {
        super.contributeTo_ASTNode_ASTNode_LocalOrdinaryNameDeclarations(collection);
        collection.add(this);
    }

}
