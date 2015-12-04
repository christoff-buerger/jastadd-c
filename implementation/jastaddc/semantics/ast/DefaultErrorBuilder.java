
package jastaddc.semantics.ast;

/**
 * This specification adds the error handling specific nodes
 * supported by this error handling module.
 *
 * @author C. B\u00c3\u00bcrger
 */


public class DefaultErrorBuilder extends ErrorBuilder implements Cloneable {
    public void flushCache() {
        super.flushCache();
        IsCorrect_visited = -1;
        ConstructErrorNode_Class_visited = new java.util.HashMap(4);
        ConstructErrorNode_Class_values = null;
        ConstructErrorTree_visited = -1;
        ConstructErrorTree_computed = false;
        ConstructErrorTree_value = null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public DefaultErrorBuilder clone() throws CloneNotSupportedException {
        DefaultErrorBuilder node = (DefaultErrorBuilder)super.clone();
        node.IsCorrect_visited = -1;
        node.ConstructErrorNode_Class_visited = new java.util.HashMap(4);
        node.ConstructErrorNode_Class_values = null;
        node.ConstructErrorTree_visited = -1;
        node.ConstructErrorTree_computed = false;
        node.ConstructErrorTree_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public DefaultErrorBuilder copy() {
      try {
          DefaultErrorBuilder node = (DefaultErrorBuilder)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public DefaultErrorBuilder fullCopy() {
        DefaultErrorBuilder res = (DefaultErrorBuilder)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in DefaultErrorHandling.ast at line 3
    // Declared in DefaultErrorHandling.ast line 8

    public DefaultErrorBuilder() {
        super();

        setChild(new Opt(), 0);

    }

    // Declared in DefaultErrorHandling.ast at line 11


    // Declared in DefaultErrorHandling.ast line 8
    public DefaultErrorBuilder(Opt<TranslationUnit> p0) {
        setChild(p0, 0);
    }

    // Declared in DefaultErrorHandling.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in DefaultErrorHandling.ast at line 18

  public boolean mayHaveRewrite() { return true; }

    // Declared in DefaultErrorHandling.ast at line 2
    // Declared in DefaultErrorHandling.ast line 8
    public void setTranslationUnitOpt(Opt<TranslationUnit> opt) {
        setChild(opt, 0);
    }

    // Declared in DefaultErrorHandling.ast at line 6


    public boolean hasTranslationUnit() {
        return getTranslationUnitOpt().getNumChild() != 0;
    }

    // Declared in DefaultErrorHandling.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public TranslationUnit getTranslationUnit() {
        return (TranslationUnit)getTranslationUnitOpt().getChild(0);
    }

    // Declared in DefaultErrorHandling.ast at line 14


    public void setTranslationUnit(TranslationUnit node) {
        getTranslationUnitOpt().setChild(node, 0);
    }

    // Declared in DefaultErrorHandling.ast at line 17

     @SuppressWarnings({"unchecked", "cast"})  public Opt<TranslationUnit> getTranslationUnitOpt() {
        return (Opt<TranslationUnit>)getChild(0);
    }

    // Declared in DefaultErrorHandling.ast at line 21


     @SuppressWarnings({"unchecked", "cast"})  public Opt<TranslationUnit> getTranslationUnitOptNoTransform() {
        return (Opt<TranslationUnit>)getChildNoTransform(0);
    }

    protected int IsCorrect_visited = -1;
/**
	 * Handles the traversion of the AST to verify all constraints for a given
	 * node AND it's sub nodes.
	 
    Declared in ErrorHandling.jrag at line 19
*/
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsCorrect() {
        if(IsCorrect_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsCorrect in class: ");
        IsCorrect_visited = state().boundariesCrossed;
        boolean IsCorrect_value = IsCorrect_compute();
        IsCorrect_visited = -1;
        return IsCorrect_value;
    }

    private boolean IsCorrect_compute() {  return true;  }

    protected java.util.Map ConstructErrorNode_Class_visited;
    protected java.util.Map ConstructErrorNode_Class_values;
/**
	 * IMPORTANT: Do NEVER add the error node returned to any AST, thus
	 * it must not become an AST part. The construction process is specified
	 * to be lazy, thus caching is used and the same node may be returned
	 * several times instead of constructing each time a new node!
	 
    Declared in ErrorHandling.jrag at line 29
*/
 @SuppressWarnings({"unchecked", "cast"})     public ASTNode ConstructErrorNode(Class nodeType) {
        Object _parameters = nodeType;
if(ConstructErrorNode_Class_visited == null) ConstructErrorNode_Class_visited = new java.util.HashMap(4);
if(ConstructErrorNode_Class_values == null) ConstructErrorNode_Class_values = new java.util.HashMap(4);
        if(ConstructErrorNode_Class_values.containsKey(_parameters))
            return (ASTNode)ConstructErrorNode_Class_values.get(_parameters);
        if(new Integer(state().boundariesCrossed).equals(ConstructErrorNode_Class_visited.get(_parameters)))
            throw new RuntimeException("Circular definition of attr: ConstructErrorNode in class: ");
        ConstructErrorNode_Class_visited.put(_parameters, new Integer(state().boundariesCrossed));
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        ASTNode ConstructErrorNode_Class_value = ConstructErrorNode_compute(nodeType);
        if(isFinal && num == state().boundariesCrossed)
            ConstructErrorNode_Class_values.put(_parameters, ConstructErrorNode_Class_value);
        ConstructErrorNode_Class_visited.remove(_parameters);
        return ConstructErrorNode_Class_value;
    }

    private ASTNode ConstructErrorNode_compute(Class nodeType) {  return ListFilter.filter(
				ErrorNodes(),
				new ASTNodeTypeFilter(nodeType)).get(0);  }

    protected int ConstructErrorTree_visited = -1;
    protected boolean ConstructErrorTree_computed = false;
    protected TranslationUnit ConstructErrorTree_value;
    // Declared in ErrorHandlingInitialization.jrag at line 25
 @SuppressWarnings({"unchecked", "cast"})     public TranslationUnit ConstructErrorTree() {
        if(ConstructErrorTree_computed)
            return ConstructErrorTree_value;
        if(ConstructErrorTree_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ConstructErrorTree in class: ");
        ConstructErrorTree_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        ConstructErrorTree_value = ConstructErrorTree_compute();
        if(isFinal && num == state().boundariesCrossed)
            ConstructErrorTree_computed = true;
        ConstructErrorTree_visited = -1;
        return ConstructErrorTree_value;
    }

    private TranslationUnit ConstructErrorTree_compute() {  return new TranslationUnit(
				new List().add(new DeclarationCollection(new List().add(new Declaration(
						new List(),
						new List(),
						new PrimitiveType(new List(), jastaddc.semantics.PrimitiveTypes._error_type),
						new Opt(),
						new Opt(new FunctionDefinitionInitializer(new CompoundStatement(new List().add(
								new ExplicitLabeledStatement (
										new SwitchStatement(new Variable(new Identifier("§ERROR TREE VARIABLE§")), new EmptyStatement()),
										new Identifier("§ERROR TREE LABEL§"))).add(
								new Declaration(
										new List(),
										new List(),
										new Structure(new List(), new Opt(), new List().add(new NormalUnionOrStructureElement(new PrimitiveType(new List(), jastaddc.semantics.PrimitiveTypes._error_type), new Identifier("§ERROR TREE STRUCTURE MEMBER§")))),
										new Opt(),
										new Opt())).add(
								new Declaration(
										new List(),
										new List(),
										new Union(new List(), new Opt(), new List()),
										new Opt(),
										new Opt())).add(
								new Declaration(
										new List(),
										new List(),
										new Enumeration(new List(), new Opt(), new List()),
										new Opt(),
										new Opt())).add(
								new Declaration(
										new List(),
										new List(),
										new Array(new List(), new PrimitiveType(new List(), jastaddc.semantics.PrimitiveTypes._error_type), new Opt()),
										new Opt(),
										new Opt()))))))))));  }

public ASTNode rewriteTo() {
    // Declared in ErrorHandlingInitialization.jrag at line 15
    if(!hasTranslationUnit()) {
        state().duringErrorHandlingInitialization++;
        ASTNode result = rewriteRule0();
        state().duringErrorHandlingInitialization--;
        return result;
    }

    return super.rewriteTo();
}

    // Declared in ErrorHandlingInitialization.jrag at line 15
    private DefaultErrorBuilder rewriteRule0() {
{
			setTranslationUnit(ConstructErrorTree());
			return this;
		}    }
}
