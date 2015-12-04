
package jastaddc.semantics.ast;



	/**
	 * A function type's parameter may have no name, e.g. function prototype's.
	 * 
	 * If no parameter declarations are specified (empty list) the function
	 * has no parameter specification. If the function has no parameters,
	 * the parameter declarations list contains one element, the declaration
	 * of a nameless parameter of type void ([6.7.5.3:10] S. 119).
	 * 
	 * The only StorageClass specifier that shall occur for a FunctionParameter
	 * is register [6.7.5.3:2] S. 118.
	 * 
	 * PARSER-CONSTRAINT / REWRITE: Array parameters of type T will be
	 * rewritten to qualified pointer to T [6.7.5.3:7] S.119. The type
	 * qualifiers are those within the arrays brackets ([ and ]). Type
	 * qualifiers and/or the static keyword in array brackets are only
	 * permitted in declarations of function parameters with array type
	 * [6.7.5.2:1] S. 116. E.g.:
	 *
	 * void f (int* array[const]); --> void f (int** const array);
	 * 
	 * thus, array is a constant pointer to a pointer to integer. Represented
	 * as tree:
	 * 
	 *                  D
	 *                /   \
	 *              F T  BN:f
	 *             /   \
	 *           A T    D
	 *            |     | \
	 *         TN:void  |  \
	 *                  | N:array
	 *                  P
	 *                 / \
	 *                P   \
	 *                | TQ:{const}
	 *               A T
	 *                |
	 *              TN:int
	 * 
	 * with : D ...Declaration
	 *        FT...FunctionType
	 *        BN...BindedName
	 *        AT...AtomarType
	 *        TN...TypeName
	 *        P ...Pointer
	 *        TQ...TypeQualifier
	 * 
	 * REWRITE: Old style function definitions have to be rewritten by the
	 * parser. E.g.:
	 * 
	 * void func(a,b,c) 
	 *    int a, b;
	 *    double c; {
	 *    // the function body
	 * }
	 * 
	 * will become
	 * 
	 * void func(int a, int b, double c) {
	 *    // the function body
	 * }
	 */
	
public abstract class FunctionType extends Type implements Cloneable {
    public void flushCache() {
        super.flushCache();
        IsParameterlessFunction_visited = -1;
        IsWithoutParameterSpecification_visited = -1;
        ReadableTypeName_visited = -1;
        IsIdenticalFunctionType_Type_visited = new java.util.HashMap(4);
        IsPartOfFunctionDeclaration_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public FunctionType clone() throws CloneNotSupportedException {
        FunctionType node = (FunctionType)super.clone();
        node.IsParameterlessFunction_visited = -1;
        node.IsWithoutParameterSpecification_visited = -1;
        node.ReadableTypeName_visited = -1;
        node.IsIdenticalFunctionType_Type_visited = new java.util.HashMap(4);
        node.IsPartOfFunctionDeclaration_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 370

    public FunctionType() {
        super();

        setChild(new List(), 0);
        setChild(new List(), 2);

    }

    // Declared in C99AST.ast at line 12


    // Declared in C99AST.ast line 370
    public FunctionType(List<TypeQualifier> p0, _IntermediateType p1, List<Declaration> p2) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
    }

    // Declared in C99AST.ast at line 18


  protected int numChildren() {
    return 3;
  }

    // Declared in C99AST.ast at line 21

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
    // Declared in C99AST.ast line 370
    public void setReturnType(_IntermediateType node) {
        setChild(node, 1);
    }

    // Declared in C99AST.ast at line 5

    public _IntermediateType getReturnType() {
        return (_IntermediateType)getChild(1);
    }

    // Declared in C99AST.ast at line 9


    public _IntermediateType getReturnTypeNoTransform() {
        return (_IntermediateType)getChildNoTransform(1);
    }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 370
    public void setParameterList(List<Declaration> list) {
        setChild(list, 2);
    }

    // Declared in C99AST.ast at line 6


    public int getNumParameter() {
        return getParameterList().getNumChild();
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public Declaration getParameter(int i) {
        return (Declaration)getParameterList().getChild(i);
    }

    // Declared in C99AST.ast at line 14


    public void addParameter(Declaration node) {
        List<Declaration> list = getParameterList();
        list.addChild(node);
    }

    // Declared in C99AST.ast at line 19


    public void setParameter(Declaration node, int i) {
        List<Declaration> list = getParameterList();
        list.setChild(node, i);
    }

    // Declared in C99AST.ast at line 23

    public List<Declaration> getParameters() {
        return getParameterList();
    }

    // Declared in C99AST.ast at line 26

    public List<Declaration> getParametersNoTransform() {
        return getParameterListNoTransform();
    }

    // Declared in C99AST.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<Declaration> getParameterList() {
        return (List<Declaration>)getChild(2);
    }

    // Declared in C99AST.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<Declaration> getParameterListNoTransform() {
        return (List<Declaration>)getChildNoTransform(2);
    }

    protected int IsParameterlessFunction_visited = -1;
/**
	 * Support for informations about a function types parameters:
	 
    Declared in FunctionSupport.jrag at line 20
*/
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsParameterlessFunction() {
        if(IsParameterlessFunction_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsParameterlessFunction in class: ");
        IsParameterlessFunction_visited = state().boundariesCrossed;
        boolean IsParameterlessFunction_value = IsParameterlessFunction_compute();
        IsParameterlessFunction_visited = -1;
        return IsParameterlessFunction_value;
    }

    private boolean IsParameterlessFunction_compute() {  return getNumParameter() == 1 && !getParameter(0).hasBindedName() &&
		(getParameter(0).getType().RetrieveFinalNode() instanceof PrimitiveType) &&
		((PrimitiveType)getParameter(0).getType().RetrieveFinalNode()).getType() == jastaddc.semantics.PrimitiveTypes._void;  }

    protected int IsWithoutParameterSpecification_visited = -1;
    // Declared in FunctionSupport.jrag at line 24
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsWithoutParameterSpecification() {
        if(IsWithoutParameterSpecification_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsWithoutParameterSpecification in class: ");
        IsWithoutParameterSpecification_visited = state().boundariesCrossed;
        boolean IsWithoutParameterSpecification_value = IsWithoutParameterSpecification_compute();
        IsWithoutParameterSpecification_visited = -1;
        return IsWithoutParameterSpecification_value;
    }

    private boolean IsWithoutParameterSpecification_compute() {  return getNumParameter() == 0;  }

    protected int ReadableTypeName_visited = -1;
/**
	 * Provide functionality to print human readable type descriptions.
	 
    Declared in ReadableTypeNames.jrag at line 19
*/
 @SuppressWarnings({"unchecked", "cast"})     public String ReadableTypeName() {
        if(ReadableTypeName_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ReadableTypeName in class: ");
        ReadableTypeName_visited = state().boundariesCrossed;
        String ReadableTypeName_value = ReadableTypeName_compute();
        ReadableTypeName_visited = -1;
        return ReadableTypeName_value;
    }

    private String ReadableTypeName_compute() {
		StringBuilder result = new StringBuilder();
		result.append("function ");
		if (getNumParameter() > 0) {
			result.append(" with following parameters {");
			for (int i = 0; i < getNumParameter(); i++) {
				result.append(i);
				result.append(") ");
				result.append(getParameter(i).getType().RetrieveFinalNode().ReadableTypeName());
				result.append(", ");
			}
			result.deleteCharAt(result.length() - 1);
			result.deleteCharAt(result.length() - 1);
			result.append("} ");
		} else {
			result.append("without parameters ");
		}
		result.append("returning ");
		result.append(getReturnType().RetrieveFinalNode().ReadableTypeName());
		return result.toString();
	}

    protected java.util.Map IsIdenticalFunctionType_Type_visited;
    // Declared in basics.jrag at line 4
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsIdenticalFunctionType(Type otherType) {
        Object _parameters = otherType;
if(IsIdenticalFunctionType_Type_visited == null) IsIdenticalFunctionType_Type_visited = new java.util.HashMap(4);
        if(new Integer(state().boundariesCrossed).equals(IsIdenticalFunctionType_Type_visited.get(_parameters)))
            throw new RuntimeException("Circular definition of attr: IsIdenticalFunctionType in class: ");
        IsIdenticalFunctionType_Type_visited.put(_parameters, new Integer(state().boundariesCrossed));
        boolean IsIdenticalFunctionType_Type_value = IsIdenticalFunctionType_compute(otherType);
        IsIdenticalFunctionType_Type_visited.remove(_parameters);
        return IsIdenticalFunctionType_Type_value;
    }

    private boolean IsIdenticalFunctionType_compute(Type otherType) {  return true;  }

    protected int IsPartOfFunctionDeclaration_visited = -1;
    // Declared in CompilerAPI.jrag at line 99
 @SuppressWarnings({"unchecked", "cast"})     public Declaration IsPartOfFunctionDeclaration() {
        if(IsPartOfFunctionDeclaration_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsPartOfFunctionDeclaration in class: ");
        IsPartOfFunctionDeclaration_visited = state().boundariesCrossed;
        Declaration IsPartOfFunctionDeclaration_value = getParent().Define_Declaration_IsPartOfFunctionDeclaration(this, null);
        IsPartOfFunctionDeclaration_visited = -1;
        return IsPartOfFunctionDeclaration_value;
    }

    // Declared in ContextInformationAccess.jrag at line 23
    public FunctionType Define_FunctionType_IsParameterDeclaration(ASTNode caller, ASTNode child) {
        if(caller == getParameterListNoTransform()) {
      int index = caller.getIndexOfChild(child);
            return this;
        }
        return getParent().Define_FunctionType_IsParameterDeclaration(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
