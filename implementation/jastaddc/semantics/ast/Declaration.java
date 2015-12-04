
package jastaddc.semantics.ast;



/**
 * In C99 declarations are no statements. See the comments in the "Statements"
 * section.
 * 
 * A declaration binds a name to a type (but a BindedName has not always to be
 * given, e.g. if a structure type is declaraed but no object of the given type
 * is instantiated immediately). Additionally it may allocate
 * memory for the binded name, so an object/function for the given type is
 * constructed and associated with the name. In this case the declaration is a
 * definition. Additionally an object constructed this way may be initialized.
 * In the AST the function definitions of the standard are function declarations
 * with an initializer, representing the function body, thus the initializer is
 * a compound statement. As C99 does not allow nested function definitions, a
 * semantical check has to be done to ensure this.
 * 
 * A function with a body is the definition of the function, thus the
 * initializer of a function is it's body. Function prototypes can later be
 * rewritten/semantical evaluated to be associated with their definition.
 * 
 * Semantic tests, if the Declaration is valid are necessary, e.g. :
 * - Declarations must be checked, that they declare something (declarator,
 *   tag, members of an enumeration) [6.7:2] S.97. EXCEPTION: If the declaration
 *   is a parameter declaration of a function type it may just represent the
 *   type void [6.7.5.3:10] S. 119.
 * - If an Initializer exists, a BindedName must be given as well. The
 *   Initializer must fit to the Type of the Declaration.
 *   Enumerations never have initializer.
 * - The StorageClass must fit in the Declaration's context:
 *      - auto or register are not allowed in external declarations
 *        [6.9:2] S.140.
 *      - If the Declaration Type is a FunctionType: only extern or static
 *        are allowed [6.9.1:4] S.141.
 * - At most one storage class specifier might be given in the declaration
 *   specifiers of a declaration [6.7.1:2] S. 98.
 * - If the Declaration Type is a FunctionType and an Initializer is given:
 *      - each FunctionParameter must have a Name, except only one parameter of
 *        Type void is given [6.9.1:5] S. 141.
 *      - Storage class specifiers of parameters have to be handled. If no
 *        Initializer for a function declaration is given, storage class
 *        specifier of parameters can be ignored [6.7.5.3:13] S. 119.
 */

public class Declaration extends Statement implements Cloneable, IOrdinaryNameDeclaration {
    public void flushCache() {
        super.flushCache();
        IsFunctionDeclaration_visited = -1;
        IsFunctionDefinition_visited = -1;
        IsFunctionPrototyp_visited = -1;
        Name_visited = -1;
        IsSpecifiedBy_StorageClassSpecifier_visited = new java.util.HashMap(4);
        IsSpecifiedBy_FunctionSpecifier_visited = new java.util.HashMap(4);
        IsCorrectLocal_visited = -1;
        IntroducesNewLabelBlock_visited = -1;
        FindNodeToContributeOrdinaryName_visited = -1;
        IsParameterDeclaration_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Declaration clone() throws CloneNotSupportedException {
        Declaration node = (Declaration)super.clone();
        node.IsFunctionDeclaration_visited = -1;
        node.IsFunctionDefinition_visited = -1;
        node.IsFunctionPrototyp_visited = -1;
        node.Name_visited = -1;
        node.IsSpecifiedBy_StorageClassSpecifier_visited = new java.util.HashMap(4);
        node.IsSpecifiedBy_FunctionSpecifier_visited = new java.util.HashMap(4);
        node.IsCorrectLocal_visited = -1;
        node.IntroducesNewLabelBlock_visited = -1;
        node.FindNodeToContributeOrdinaryName_visited = -1;
        node.IsParameterDeclaration_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Declaration copy() {
      try {
          Declaration node = (Declaration)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public Declaration fullCopy() {
        Declaration res = (Declaration)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 159

    public Declaration() {
        super();

        setChild(new List(), 0);
        setChild(new List(), 1);
        setChild(new Opt(), 3);
        setChild(new Opt(), 4);

    }

    // Declared in C99AST.ast at line 14


    // Declared in C99AST.ast line 159
    public Declaration(List<StorageClassSpecifier> p0, List<FunctionSpecifier> p1, _IntermediateType p2, Opt<Identifier> p3, Opt<Initializer> p4) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
        setChild(p3, 3);
        setChild(p4, 4);
    }

    // Declared in C99AST.ast at line 22


  protected int numChildren() {
    return 5;
  }

    // Declared in C99AST.ast at line 25

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 159
    public void setStorageClassSpecifierList(List<StorageClassSpecifier> list) {
        setChild(list, 0);
    }

    // Declared in C99AST.ast at line 6


    public int getNumStorageClassSpecifier() {
        return getStorageClassSpecifierList().getNumChild();
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public StorageClassSpecifier getStorageClassSpecifier(int i) {
        return (StorageClassSpecifier)getStorageClassSpecifierList().getChild(i);
    }

    // Declared in C99AST.ast at line 14


    public void addStorageClassSpecifier(StorageClassSpecifier node) {
        List<StorageClassSpecifier> list = getStorageClassSpecifierList();
        list.addChild(node);
    }

    // Declared in C99AST.ast at line 19


    public void setStorageClassSpecifier(StorageClassSpecifier node, int i) {
        List<StorageClassSpecifier> list = getStorageClassSpecifierList();
        list.setChild(node, i);
    }

    // Declared in C99AST.ast at line 23

    public List<StorageClassSpecifier> getStorageClassSpecifiers() {
        return getStorageClassSpecifierList();
    }

    // Declared in C99AST.ast at line 26

    public List<StorageClassSpecifier> getStorageClassSpecifiersNoTransform() {
        return getStorageClassSpecifierListNoTransform();
    }

    // Declared in C99AST.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<StorageClassSpecifier> getStorageClassSpecifierList() {
        return (List<StorageClassSpecifier>)getChild(0);
    }

    // Declared in C99AST.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<StorageClassSpecifier> getStorageClassSpecifierListNoTransform() {
        return (List<StorageClassSpecifier>)getChildNoTransform(0);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 159
    public void setFunctionSpecifierList(List<FunctionSpecifier> list) {
        setChild(list, 1);
    }

    // Declared in C99AST.ast at line 6


    public int getNumFunctionSpecifier() {
        return getFunctionSpecifierList().getNumChild();
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public FunctionSpecifier getFunctionSpecifier(int i) {
        return (FunctionSpecifier)getFunctionSpecifierList().getChild(i);
    }

    // Declared in C99AST.ast at line 14


    public void addFunctionSpecifier(FunctionSpecifier node) {
        List<FunctionSpecifier> list = getFunctionSpecifierList();
        list.addChild(node);
    }

    // Declared in C99AST.ast at line 19


    public void setFunctionSpecifier(FunctionSpecifier node, int i) {
        List<FunctionSpecifier> list = getFunctionSpecifierList();
        list.setChild(node, i);
    }

    // Declared in C99AST.ast at line 23

    public List<FunctionSpecifier> getFunctionSpecifiers() {
        return getFunctionSpecifierList();
    }

    // Declared in C99AST.ast at line 26

    public List<FunctionSpecifier> getFunctionSpecifiersNoTransform() {
        return getFunctionSpecifierListNoTransform();
    }

    // Declared in C99AST.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<FunctionSpecifier> getFunctionSpecifierList() {
        return (List<FunctionSpecifier>)getChild(1);
    }

    // Declared in C99AST.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<FunctionSpecifier> getFunctionSpecifierListNoTransform() {
        return (List<FunctionSpecifier>)getChildNoTransform(1);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 159
    public void setType(_IntermediateType node) {
        setChild(node, 2);
    }

    // Declared in C99AST.ast at line 5

    public _IntermediateType getType() {
        return (_IntermediateType)getChild(2);
    }

    // Declared in C99AST.ast at line 9


    public _IntermediateType getTypeNoTransform() {
        return (_IntermediateType)getChildNoTransform(2);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 159
    public void setBindedNameOpt(Opt<Identifier> opt) {
        setChild(opt, 3);
    }

    // Declared in C99AST.ast at line 6


    public boolean hasBindedName() {
        return getBindedNameOpt().getNumChild() != 0;
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Identifier getBindedName() {
        return (Identifier)getBindedNameOpt().getChild(0);
    }

    // Declared in C99AST.ast at line 14


    public void setBindedName(Identifier node) {
        getBindedNameOpt().setChild(node, 0);
    }

    // Declared in C99AST.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<Identifier> getBindedNameOpt() {
        return (Opt<Identifier>)getChild(3);
    }

    // Declared in C99AST.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<Identifier> getBindedNameOptNoTransform() {
        return (Opt<Identifier>)getChildNoTransform(3);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 159
    public void setInitializerOpt(Opt<Initializer> opt) {
        setChild(opt, 4);
    }

    // Declared in C99AST.ast at line 6


    public boolean hasInitializer() {
        return getInitializerOpt().getNumChild() != 0;
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Initializer getInitializer() {
        return (Initializer)getInitializerOpt().getChild(0);
    }

    // Declared in C99AST.ast at line 14


    public void setInitializer(Initializer node) {
        getInitializerOpt().setChild(node, 0);
    }

    // Declared in C99AST.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<Initializer> getInitializerOpt() {
        return (Opt<Initializer>)getChild(4);
    }

    // Declared in C99AST.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<Initializer> getInitializerOptNoTransform() {
        return (Opt<Initializer>)getChildNoTransform(4);
    }

    protected int IsFunctionDeclaration_visited = -1;
/**
	 * Support for function declarations:
	 
    Declared in FunctionSupport.jrag at line 8
*/
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsFunctionDeclaration() {
        if(IsFunctionDeclaration_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsFunctionDeclaration in class: ");
        IsFunctionDeclaration_visited = state().boundariesCrossed;
        boolean IsFunctionDeclaration_value = IsFunctionDeclaration_compute();
        IsFunctionDeclaration_visited = -1;
        return IsFunctionDeclaration_value;
    }

    private boolean IsFunctionDeclaration_compute() {  return getType() instanceof FunctionType;  }

    protected int IsFunctionDefinition_visited = -1;
    // Declared in FunctionSupport.jrag at line 9
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsFunctionDefinition() {
        if(IsFunctionDefinition_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsFunctionDefinition in class: ");
        IsFunctionDefinition_visited = state().boundariesCrossed;
        boolean IsFunctionDefinition_value = IsFunctionDefinition_compute();
        IsFunctionDefinition_visited = -1;
        return IsFunctionDefinition_value;
    }

    private boolean IsFunctionDefinition_compute() {  return hasInitializer() ?
				getInitializer() instanceof FunctionDefinitionInitializer :
				false;  }

    protected int IsFunctionPrototyp_visited = -1;
    // Declared in FunctionSupport.jrag at line 13
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsFunctionPrototyp() {
        if(IsFunctionPrototyp_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsFunctionPrototyp in class: ");
        IsFunctionPrototyp_visited = state().boundariesCrossed;
        boolean IsFunctionPrototyp_value = IsFunctionPrototyp_compute();
        IsFunctionPrototyp_visited = -1;
        return IsFunctionPrototyp_value;
    }

    private boolean IsFunctionPrototyp_compute() {  return IsFunctionDeclaration() ?
			!hasInitializer() :
			false;  }

    protected int Name_visited = -1;
    // Declared in Names.jrag at line 18
 @SuppressWarnings({"unchecked", "cast"})     public String Name() {
        if(Name_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Name in class: ");
        Name_visited = state().boundariesCrossed;
        String Name_value = Name_compute();
        Name_visited = -1;
        return Name_value;
    }

    private String Name_compute() {  return hasBindedName() ? getBindedName().Name() : "§Anonymous Declaration "+ NodeAddress().toString() +"§";  }

    protected java.util.Map IsSpecifiedBy_StorageClassSpecifier_visited;
/**
	 * Provide functionality to retrieve informations about specifier/qualifier.
	 
    Declared in SpecifierQualifierInformation.jrag at line 5
*/
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsSpecifiedBy(StorageClassSpecifier spec) {
        Object _parameters = spec;
if(IsSpecifiedBy_StorageClassSpecifier_visited == null) IsSpecifiedBy_StorageClassSpecifier_visited = new java.util.HashMap(4);
        if(new Integer(state().boundariesCrossed).equals(IsSpecifiedBy_StorageClassSpecifier_visited.get(_parameters)))
            throw new RuntimeException("Circular definition of attr: IsSpecifiedBy in class: ");
        IsSpecifiedBy_StorageClassSpecifier_visited.put(_parameters, new Integer(state().boundariesCrossed));
        boolean IsSpecifiedBy_StorageClassSpecifier_value = IsSpecifiedBy_compute(spec);
        IsSpecifiedBy_StorageClassSpecifier_visited.remove(_parameters);
        return IsSpecifiedBy_StorageClassSpecifier_value;
    }

    private boolean IsSpecifiedBy_compute(StorageClassSpecifier spec) {
		if (spec == null)
			return false;
		for (int i = 0; i < getNumStorageClassSpecifier(); i++)
			if (spec.getClass().isInstance(getStorageClassSpecifier(i)))
				return true;
		return false;
	}

    protected java.util.Map IsSpecifiedBy_FunctionSpecifier_visited;
    // Declared in SpecifierQualifierInformation.jrag at line 14
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsSpecifiedBy(FunctionSpecifier spec) {
        Object _parameters = spec;
if(IsSpecifiedBy_FunctionSpecifier_visited == null) IsSpecifiedBy_FunctionSpecifier_visited = new java.util.HashMap(4);
        if(new Integer(state().boundariesCrossed).equals(IsSpecifiedBy_FunctionSpecifier_visited.get(_parameters)))
            throw new RuntimeException("Circular definition of attr: IsSpecifiedBy in class: ");
        IsSpecifiedBy_FunctionSpecifier_visited.put(_parameters, new Integer(state().boundariesCrossed));
        boolean IsSpecifiedBy_FunctionSpecifier_value = IsSpecifiedBy_compute(spec);
        IsSpecifiedBy_FunctionSpecifier_visited.remove(_parameters);
        return IsSpecifiedBy_FunctionSpecifier_value;
    }

    private boolean IsSpecifiedBy_compute(FunctionSpecifier spec) {
		if (spec == null)
			return false;
		for (int i = 0; i < getNumFunctionSpecifier(); i++)
			if (spec.getClass().isInstance(getFunctionSpecifier(i)))
				return true;
		return false;
	}

    protected int IsCorrectLocal_visited = -1;
/**
	 * This attribute handles the semantic constraint verification for one
	 * AST node, without traversing the tree, thus sub nodes may still be
	 * incorrect when isCorrectLocal() returns true. In this case it's only
	 * guaranteed that this AST node's semantic constraints are satisfied.
	 
    Declared in LocalConstraints.jrag at line 211
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
		// At most one storage class specifier may be given [6.7.1;2] S.98:
		if (getNumStorageClassSpecifier() > 1) {
			jastaddc.SourceError error = new jastaddc.SourceError(
					"At most one storage class specifier may be given.");
			error.line = line();
			error.column = column();
			error.sourceName = sourceName();
			error.errorLevel = jastaddc.SourceError.ErrorLevel.ERROR;
			error.errorType = jastaddc.SourceError.ErrorType.SEMANTICAL;
			addError(error);
			result = false;
		}
		if (hasBindedName()) {
			java.util.List<IOrdinaryNameDeclaration> lookedUp =
				LookUpOrdinaryName(Name());
			if (IsFunctionDefinition()) {
				// Remove prototyps of the function from the list:
				lookedUp = ListFilter.filter(
						lookedUp,
						new FunctionPrototypFilter((FunctionType)getType().RetrieveFinalNode()));
			} else if (IsFunctionPrototyp()) {
				// Remove prototyps and definitions of the function from the list:
				lookedUp = ListFilter.filter(
						lookedUp,
						new FunctionDeclarationFilter((FunctionType)getType().RetrieveFinalNode()));
			}
			if (lookedUp.size() > 1) {
				StringBuilder errorM = new StringBuilder();
				errorM.append("Ordinary Namespace: [");
				errorM.append(Name());
				errorM.append("] declaration.\n\t[");
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
		} else if (IsFunctionDeclaration()) {
			final String decDef;
			if (IsFunctionDefinition())
				decDef = "definition";
			else decDef = "declaration";
			StringBuilder errorM = new StringBuilder();
			errorM.append("Ordinary Namespace: Function ");
			errorM.append(decDef);
			errorM.append(".\n\tThe function has no name.");
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
		if (IsFunctionDefinition() && !IsFunctionDeclaration()) {
			StringBuilder errorM = new StringBuilder();
			errorM.append("AST Structure: Defining function implementation (body) for entity [");
			errorM.append(Name());
			errorM.append("].\n\t[");
			errorM.append(Name());
			errorM.append("] has no function type.");
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
		if (IsFunctionDefinition() && IsFunctionDeclaration()) {
			FunctionType funcType = (FunctionType)getType().RetrieveFinalNode();
			// The declaration for each parameter shall contain an identifier,
			// except for the special case of a parameter list consisting of a
			// single parameter of type void (the special case of a function
			// without parameters [6.7.5.3:10] S. 119) [6.9.1:5] S.141.
			if (!funcType.IsParameterlessFunction()) {
				for (int i = 0; i < funcType.getNumParameter(); i++) {
					Declaration para = funcType.getParameter(i);
					if (!para.hasBindedName()) {
						StringBuilder errorM = new StringBuilder();
						errorM.append("Ordinary Namespace: Parameter declaration of function [");
						errorM.append(Name());
						errorM.append("] definition.\n\tThe [");
						errorM.append(i);
						errorM.append("]'th parameter has no name.");
						jastaddc.SourceError error =
							new jastaddc.SourceError(errorM.toString());
						error.line = para.line();
						error.column = para.column();
						error.sourceName = para.sourceName();
						error.errorLevel =
							jastaddc.SourceError.ErrorLevel.ERROR;
						error.errorType =
							jastaddc.SourceError.ErrorType.SEMANTICAL;
						addError(error);
						result = false;
					}
				}
			}
		}
		if (!IsFunctionDeclaration() && getNumFunctionSpecifier() > 0) {
			StringBuilder errorM = new StringBuilder();
			errorM.append("AST Structure: Function specifier in [");
			errorM.append(Name());
			errorM.append("] declaration.\n\t[");
			errorM.append(Name());
			errorM.append("] has no function type.");
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
		if (IsParameterDeclaration() == null && !hasBindedName() && !(getType().RetrieveFinalNode() instanceof TagedType)) {
			// A declaration shall declare at least a declarator, a tag,
			// or the members of an enumeration [6.7:2] p. 97:
			StringBuilder errorM = new StringBuilder();
			errorM.append("AST Structure: Declaration.\n\tThe declaration does not declare something.");
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

    protected int IntroducesNewLabelBlock_visited = -1;
    // Declared in Labels.jrag at line 36
 @SuppressWarnings({"unchecked", "cast"})     public boolean IntroducesNewLabelBlock() {
        if(IntroducesNewLabelBlock_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IntroducesNewLabelBlock in class: ");
        IntroducesNewLabelBlock_visited = state().boundariesCrossed;
        boolean IntroducesNewLabelBlock_value = IntroducesNewLabelBlock_compute();
        IntroducesNewLabelBlock_visited = -1;
        return IntroducesNewLabelBlock_value;
    }

    private boolean IntroducesNewLabelBlock_compute() {  return IsFunctionDefinition();  }

    protected int FindNodeToContributeOrdinaryName_visited = -1;
/** Internal support methods 
    Declared in OrdinaryNames.jrag at line 67
*/
	
	// Return null, if the declaration is not contributing to the ordinary name space:
 @SuppressWarnings({"unchecked", "cast"})     public ASTNode FindNodeToContributeOrdinaryName() {
        if(FindNodeToContributeOrdinaryName_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: FindNodeToContributeOrdinaryName in class: ");
        FindNodeToContributeOrdinaryName_visited = state().boundariesCrossed;
        ASTNode FindNodeToContributeOrdinaryName_value = FindNodeToContributeOrdinaryName_compute();
        FindNodeToContributeOrdinaryName_visited = -1;
        return FindNodeToContributeOrdinaryName_value;
    }

    private ASTNode FindNodeToContributeOrdinaryName_compute() {  return // Does the declaration declare an ordinary name space entity?
		hasBindedName() ?
			(// Is the declaration a parameter declaration or not?
			IsParameterDeclaration() == null ?
					// There are no special rules for declarations, which are no
					// parameter declaration:
					FindNodeIntroducingThisOrdinaryNameBlock() :
					// It is a parameter declaration. Is the parameter declaration only
					// part of a simple function type or is the function type itself
					// part of a function declaration?:
					(IsParameterDeclaration().IsPartOfFunctionDeclaration() == null ?
							// Parameter declarations of function types are not part of the
							// ordinary namespace, they are ignored, e.g. in
							// sizeof(void(*)(int para));
							// para is not declarared in the ordinary namespace:
							null :
							// It is part of a function declaration. Is it a function definition
							// or a prototype?:
							(IsParameterDeclaration().IsPartOfFunctionDeclaration().IsFunctionDefinition() ?
									// Adding function parameter declarations to the function body, as each
									// parameter of a function definition is in effect declared at the head
									// of the compound statement that constitutes the function body [6.9.1:9] S.142:
									((FunctionDefinitionInitializer)IsParameterDeclaration().IsPartOfFunctionDeclaration().getInitializer()).getBody() :
									// Parameter declarations of function prototyps are not part of
									// the ordinary name space, e.g. in
									// void proto(int para);
									// para is not declarared in the ordinary name space:
									null))
			) :
			// The declaration does not declare any entity in the ordinary name space:
			null;  }

    protected int IsParameterDeclaration_visited = -1;
    // Declared in CompilerAPI.jrag at line 101
 @SuppressWarnings({"unchecked", "cast"})     public FunctionType IsParameterDeclaration() {
        if(IsParameterDeclaration_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsParameterDeclaration in class: ");
        IsParameterDeclaration_visited = state().boundariesCrossed;
        FunctionType IsParameterDeclaration_value = getParent().Define_FunctionType_IsParameterDeclaration(this, null);
        IsParameterDeclaration_visited = -1;
        return IsParameterDeclaration_value;
    }

    // Declared in ContextInformationAccess.jrag at line 21
    public Declaration Define_Declaration_IsPartOfFunctionDeclaration(ASTNode caller, ASTNode child) {
        if(caller == getTypeNoTransform()) {
            return IsFunctionDeclaration() ? this : null;
        }
        return super.Define_Declaration_IsPartOfFunctionDeclaration(caller, child);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

    protected void collect_contributors_ASTNode_LocalOrdinaryNameDeclarations() {
    /**
	 * The ASTNodes adding some name to the ordinary name space.
	 
    Declared in OrdinaryNames.jrag at line 59
*/
        if(FindNodeToContributeOrdinaryName() != null) {
        {
            ASTNode ref = (ASTNode)(FindNodeToContributeOrdinaryName());
            if(ref != null)
                ref.ASTNode_LocalOrdinaryNameDeclarations_contributors().add(this);
        }
        }
        super.collect_contributors_ASTNode_LocalOrdinaryNameDeclarations();
    }
    protected void contributeTo_ASTNode_ASTNode_LocalOrdinaryNameDeclarations(java.util.List<IOrdinaryNameDeclaration> collection) {
        super.contributeTo_ASTNode_ASTNode_LocalOrdinaryNameDeclarations(collection);
        if(FindNodeToContributeOrdinaryName() != null)
            collection.add(this);
    }

}
