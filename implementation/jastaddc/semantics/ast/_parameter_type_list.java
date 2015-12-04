
package jastaddc.semantics.ast;




public class _parameter_type_list extends ASTNode<ASTNode> implements Cloneable {
    public void flushCache() {
        super.flushCache();
        Parameters_visited = -1;
        Parameters_computed = false;
        Parameters_value = null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _parameter_type_list clone() throws CloneNotSupportedException {
        _parameter_type_list node = (_parameter_type_list)super.clone();
        node.Parameters_visited = -1;
        node.Parameters_computed = false;
        node.Parameters_value = null;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _parameter_type_list copy() {
      try {
          _parameter_type_list node = (_parameter_type_list)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public _parameter_type_list fullCopy() {
        _parameter_type_list res = (_parameter_type_list)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in ConcreteToASTMapping.ast at line 3
    // Declared in ConcreteToASTMapping.ast line 66

    public _parameter_type_list() {
        super();

        setChild(new List(), 0);

    }

    // Declared in ConcreteToASTMapping.ast at line 11


    // Declared in ConcreteToASTMapping.ast line 66
    public _parameter_type_list(List<_parameter_declaration> p0, boolean p1) {
        setChild(p0, 0);
        setIsVariadicFunction(p1);
    }

    // Declared in ConcreteToASTMapping.ast at line 16


  protected int numChildren() {
    return 1;
  }

    // Declared in ConcreteToASTMapping.ast at line 19

  public boolean mayHaveRewrite() { return false; }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 66
    public void set_parameter_declarationList(List<_parameter_declaration> list) {
        setChild(list, 0);
    }

    // Declared in ConcreteToASTMapping.ast at line 6


    public int getNum_parameter_declaration() {
        return get_parameter_declarationList().getNumChild();
    }

    // Declared in ConcreteToASTMapping.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public _parameter_declaration get_parameter_declaration(int i) {
        return (_parameter_declaration)get_parameter_declarationList().getChild(i);
    }

    // Declared in ConcreteToASTMapping.ast at line 14


    public void add_parameter_declaration(_parameter_declaration node) {
        List<_parameter_declaration> list = get_parameter_declarationList();
        list.addChild(node);
    }

    // Declared in ConcreteToASTMapping.ast at line 19


    public void set_parameter_declaration(_parameter_declaration node, int i) {
        List<_parameter_declaration> list = get_parameter_declarationList();
        list.setChild(node, i);
    }

    // Declared in ConcreteToASTMapping.ast at line 23

    public List<_parameter_declaration> get_parameter_declarations() {
        return get_parameter_declarationList();
    }

    // Declared in ConcreteToASTMapping.ast at line 26

    public List<_parameter_declaration> get_parameter_declarationsNoTransform() {
        return get_parameter_declarationListNoTransform();
    }

    // Declared in ConcreteToASTMapping.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<_parameter_declaration> get_parameter_declarationList() {
        return (List<_parameter_declaration>)getChild(0);
    }

    // Declared in ConcreteToASTMapping.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<_parameter_declaration> get_parameter_declarationListNoTransform() {
        return (List<_parameter_declaration>)getChildNoTransform(0);
    }

    // Declared in ConcreteToASTMapping.ast at line 2
    // Declared in ConcreteToASTMapping.ast line 66
    protected boolean tokenboolean_IsVariadicFunction;

    // Declared in ConcreteToASTMapping.ast at line 3

    public void setIsVariadicFunction(boolean value) {
        tokenboolean_IsVariadicFunction = value;
    }

    // Declared in ConcreteToASTMapping.ast at line 6

    public boolean getIsVariadicFunction() {
        return tokenboolean_IsVariadicFunction;
    }

    protected int Parameters_visited = -1;
    protected boolean Parameters_computed = false;
    protected List<Declaration> Parameters_value;
    // Declared in FinalASTNodesComputations.jrag at line 259
 @SuppressWarnings({"unchecked", "cast"})     public List<Declaration> Parameters() {
        if(Parameters_computed)
            return Parameters_value;
        if(Parameters_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: Parameters in class: ");
        Parameters_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        Parameters_value = Parameters_compute();
        if(true)
            Parameters_computed = true;
        Parameters_visited = -1;
        return Parameters_value;
    }

    private List<Declaration> Parameters_compute() {
		List<Declaration> result = new List<Declaration>();
		for (int i = 0; i < getNum_parameter_declaration(); i++)
			result.add(get_parameter_declaration(i).Declaration());
		return result;
	}

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
