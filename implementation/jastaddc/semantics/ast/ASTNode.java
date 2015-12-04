
package jastaddc.semantics.ast;


// Generated with JastAdd II (http://jastadd.cs.lth.se) version R20080901

public class ASTNode<T extends ASTNode> implements Cloneable, org.astregressiontestsuite.ICompilerAdapter.IASTNode, Iterable<T> {
    public void flushCache() {
        CompilationRootNode_visited = -1;
        ErrorBuilder_visited = -1;
        IsCorrect_visited = -1;
        IsCorrectLocal_visited = -1;
        addError_jastaddc_SourceError_visited = new java.util.HashMap(4);
        findNodeInSubtreeErrorIsAssociatedWith_jastaddc_SourceError_visited = new java.util.HashMap(4);
        collectAllErrorsOfTree_visited = -1;
        collectAllErrorsOfNode_visited = -1;
        FindNodeIntroducingThisLabelBlock_visited = -1;
        LookUpLabel_String_visited = new java.util.HashMap(4);
        IntroducesNewLabelBlock_visited = -1;
        IntroducesNewOrdinaryNameBlock_visited = -1;
        FindNodeIntroducingThisOrdinaryNameBlock_visited = -1;
        LookUpOrdinaryName_String_visited = new java.util.HashMap(4);
        LookUpOrdinaryName_String_jastaddc_semantics_NodeAddress_visited = new java.util.HashMap(4);
        IsOrdinaryNameBlockInContext_ASTNode_visited = new java.util.HashMap(4);
        IsNodeTypeOrdinaryNameBlock_visited = -1;
        IntroducesNewTagBlock_visited = -1;
        FindNodeIntroducingThisTagBlock_visited = -1;
        LookUpTag_String_visited = new java.util.HashMap(4);
        LookUpTag_String_jastaddc_semantics_NodeAddress_visited = new java.util.HashMap(4);
        IsTagBlockInContext_ASTNode_visited = new java.util.HashMap(4);
        IsNodeTypeTagBlock_visited = -1;
        NodeAddress_visited = -1;
        IsErrorNode_visited = -1;
        ASTNode_LocalLabelDeclarations_visited = -1;
        ASTNode_LocalLabelDeclarations_computed = false;
        ASTNode_LocalLabelDeclarations_value = null;
    ASTNode_LocalLabelDeclarations_contributors = new java.util.HashSet();
        ASTNode_LocalOrdinaryNameDeclarations_visited = -1;
        ASTNode_LocalOrdinaryNameDeclarations_computed = false;
        ASTNode_LocalOrdinaryNameDeclarations_value = null;
    ASTNode_LocalOrdinaryNameDeclarations_contributors = new java.util.HashSet();
        ASTNode_LocalTagDeclarations_visited = -1;
        ASTNode_LocalTagDeclarations_computed = false;
        ASTNode_LocalTagDeclarations_value = null;
    ASTNode_LocalTagDeclarations_contributors = new java.util.HashSet();
    }
     @SuppressWarnings({"unchecked", "cast"})  public ASTNode<T> clone() throws CloneNotSupportedException {
        ASTNode node = (ASTNode)super.clone();
        node.CompilationRootNode_visited = -1;
        node.ErrorBuilder_visited = -1;
        node.IsCorrect_visited = -1;
        node.IsCorrectLocal_visited = -1;
        node.addError_jastaddc_SourceError_visited = new java.util.HashMap(4);
        node.findNodeInSubtreeErrorIsAssociatedWith_jastaddc_SourceError_visited = new java.util.HashMap(4);
        node.collectAllErrorsOfTree_visited = -1;
        node.collectAllErrorsOfNode_visited = -1;
        node.FindNodeIntroducingThisLabelBlock_visited = -1;
        node.LookUpLabel_String_visited = new java.util.HashMap(4);
        node.IntroducesNewLabelBlock_visited = -1;
        node.IntroducesNewOrdinaryNameBlock_visited = -1;
        node.FindNodeIntroducingThisOrdinaryNameBlock_visited = -1;
        node.LookUpOrdinaryName_String_visited = new java.util.HashMap(4);
        node.LookUpOrdinaryName_String_jastaddc_semantics_NodeAddress_visited = new java.util.HashMap(4);
        node.IsOrdinaryNameBlockInContext_ASTNode_visited = new java.util.HashMap(4);
        node.IsNodeTypeOrdinaryNameBlock_visited = -1;
        node.IntroducesNewTagBlock_visited = -1;
        node.FindNodeIntroducingThisTagBlock_visited = -1;
        node.LookUpTag_String_visited = new java.util.HashMap(4);
        node.LookUpTag_String_jastaddc_semantics_NodeAddress_visited = new java.util.HashMap(4);
        node.IsTagBlockInContext_ASTNode_visited = new java.util.HashMap(4);
        node.IsNodeTypeTagBlock_visited = -1;
        node.NodeAddress_visited = -1;
        node.IsErrorNode_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ASTNode<T> copy() {
      try {
          ASTNode node = (ASTNode)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public ASTNode<T> fullCopy() {
        ASTNode res = (ASTNode)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in CompilerAPI.jrag at line 184

	
	/**
	 * Provide functionality to associate with each AST node a line and column
	 * position in the source code.
	 */
	public Integer line = null;

    // Declared in CompilerAPI.jrag at line 185

	public Integer column = null;

    // Declared in CompilerAPI.jrag at line 186

	public String sourceName = null;

    // Declared in CompilerAPI.jrag at line 187

	public int line() {
		if (line != null)
			return line;
		if (getParent() != null)
			return getParent().line();
		return 0;
	}

    // Declared in CompilerAPI.jrag at line 194

	public int column() {
		if (column != null)
			return column;
		if (getParent() != null)
			return getParent().column();
		return 0;
	}

    // Declared in CompilerAPI.jrag at line 201

	public String sourceName() {
		if (sourceName != null)
			return sourceName;
		if (getParent() != null)
			return getParent().sourceName();
		return "§UNKNOWN SOURCE§";
	}

    // Declared in CompilerAPI.jrag at line 208

	public String sourceCodeLocation() {
		return "(" + sourceName() +":"+ line() +";"+ column() +")";
	}

    // Declared in ErrorHandling.jrag at line 59

	
	/**
	 * Implementation of the error traversing and association methods:
	 */
	protected java.util.ArrayList<jastaddc.SourceError> errors =
		new java.util.ArrayList<jastaddc.SourceError>();

    // Declared in ASTRegressionTestSuite.jrag at line 21

	
	/**
	 * Returns an XML document representing the complete subtree of this
	 * AST node as well as the node itself.
	 */
	public org.jdom.Document createXMLRepresentationOfTree() {
		org.jdom.Document result =
			new org.jdom.Document(createXMLElementForTree());
		return result;
	}

    // Declared in ASTRegressionTestSuite.jrag at line 31

	
	/**
	 * Returns an XML Element representing the complete subtree of this
	 * AST node as well as the node itself.
	 */
	public org.jdom.Element createXMLElementForTree() {
		org.jdom.Element result =
			new org.jdom.Element("Node");
		org.jdom.Attribute name =
			new org.jdom.Attribute("Name", this.getClass().getName());
		result.setAttribute(name);
		org.jdom.Attribute address =
			new org.jdom.Attribute("Address", NodeAddress().toString());
		result.setAttribute(address);
		for (org.jdom.Attribute att:createXMLNodeAttributes())
			result.setAttribute(att);
		for (int i = 0; i < getNumChild(); i++) {
			result.addContent(getChild(i).createXMLElementForTree());
		}
		return result;
	}

    // Declared in ASTRegressionTestSuite.jrag at line 54

	
	/**
	 * Returns a list containing all the attributes to add to the XML node
	 * representing this AST node. To tailor the XML AST representation generated
	 * by the ASTRegressionTestSuite the user can overload this method for specific
	 * AST nodes.
	 */
	public java.util.List<org.jdom.Attribute> createXMLNodeAttributes() {
		return new java.util.LinkedList<org.jdom.Attribute>();
	}

    // Declared in ASTNode.ast at line 3
    // Declared in ASTNode.ast line 0

    public ASTNode() {
        super();


    }

    // Declared in ASTNode.ast at line 9


   public static final boolean generatedWithCircularEnabled = true;

    // Declared in ASTNode.ast at line 10

   public static final boolean generatedWithCacheCycle = true;

    // Declared in ASTNode.ast at line 11

   public static final boolean generatedWithComponentCheck = false;

    // Declared in ASTNode.ast at line 12

   private static ASTNode$State state = new ASTNode$State();

    // Declared in ASTNode.ast at line 13

   public final ASTNode$State state() { return state; }

    // Declared in ASTNode.ast at line 14

  public boolean in$Circle = false;

    // Declared in ASTNode.ast at line 15

  public boolean in$Circle() { return in$Circle; }

    // Declared in ASTNode.ast at line 16

  public void in$Circle(boolean b) { in$Circle = b; }

    // Declared in ASTNode.ast at line 17

  public boolean is$Final = false;

    // Declared in ASTNode.ast at line 18

  public boolean is$Final() { return is$Final; }

    // Declared in ASTNode.ast at line 19

  public void is$Final(boolean b) { is$Final = b; }

    // Declared in ASTNode.ast at line 20

  @SuppressWarnings("cast") public T getChild(int i) {
    return (T)ASTNode.getChild(this, i);
  }

    // Declared in ASTNode.ast at line 23

  public static ASTNode getChild(ASTNode that, int i) {
    ASTNode node = that.getChildNoTransform(i);
    if(node.is$Final()) return node;
    if(!node.mayHaveRewrite()) {
      node.is$Final(that.is$Final());
      return node;
    }
    if(!node.in$Circle()) {
      int rewriteState;
      int num = that.state().boundariesCrossed;
      do {
        that.state().push(ASTNode$State.REWRITE_CHANGE);
        ASTNode oldNode = node;
        oldNode.in$Circle(true);
        node = node.rewriteTo();
        if(node != oldNode)
          that.setChild(node, i);
        oldNode.in$Circle(false);
        rewriteState = that.state().pop();
      } while(rewriteState == ASTNode$State.REWRITE_CHANGE);
      if(rewriteState == ASTNode$State.REWRITE_NOCHANGE && that.is$Final()) {
        node.is$Final(true);
        that.state().boundariesCrossed = num;
      }
    }
    else if(that.is$Final() != node.is$Final()) that.state().boundariesCrossed++;
    return node;
  }

    // Declared in ASTNode.ast at line 51

  private int childIndex;

    // Declared in ASTNode.ast at line 52

  public int getIndexOfChild(ASTNode node) {
    if(node != null && node.childIndex < getNumChildNoTransform() && node == getChildNoTransform(node.childIndex))
      return node.childIndex;
    for(int i = 0; i < getNumChildNoTransform(); i++)
      if(getChildNoTransform(i) == node) {
        node.childIndex = i;
        return i;
      }
    return -1;
  }

    // Declared in ASTNode.ast at line 63


  public void addChild(T node) {
    setChild(node, getNumChildNoTransform());
  }

    // Declared in ASTNode.ast at line 66

  @SuppressWarnings("cast") public final T getChildNoTransform(int i) {
    return (T)children[i];
  }

    // Declared in ASTNode.ast at line 69

  protected ASTNode parent;

    // Declared in ASTNode.ast at line 70

  protected ASTNode[] children;

    // Declared in ASTNode.ast at line 71

  protected int numChildren;

    // Declared in ASTNode.ast at line 72

  protected int numChildren() {
    return numChildren;
  }

    // Declared in ASTNode.ast at line 75

  public int getNumChild() {
    return numChildren();
  }

    // Declared in ASTNode.ast at line 78

  public final int getNumChildNoTransform() {
    return numChildren();
  }

    // Declared in ASTNode.ast at line 81

  public void setChild(T node, int i) {
    if(children == null) {
      children = new ASTNode[i + 1];
    } else if (i >= children.length) {
      ASTNode c[] = new ASTNode[i << 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = node;
    if(i >= numChildren) numChildren = i+1;
    if(node != null) { node.setParent(this); node.childIndex = i; }
  }

    // Declared in ASTNode.ast at line 93

  public void insertChild(T node, int i) {
    if(children == null) {
      children = new ASTNode[i + 1];
      children[i] = node;
    } else {
      ASTNode c[] = new ASTNode[children.length + 1];
      System.arraycopy(children, 0, c, 0, i);
      c[i] = node;
      if(i < children.length)
        System.arraycopy(children, i, c, i+1, children.length-i);
      children = c;
    }
    numChildren++;
    if(node != null) { node.setParent(this); node.childIndex = i; }
  }

    // Declared in ASTNode.ast at line 108

  public void removeChild(int i) {
    if(children != null) {
      ASTNode child = children[i];
      if(child != null) {
        child.setParent(null);
        child.childIndex = -1;
      }
      System.arraycopy(children, i+1, children, i, children.length-i-1);
      numChildren--;
    }
  }

    // Declared in ASTNode.ast at line 119

  public ASTNode getParent() {
    if(parent != null && parent.is$Final() != is$Final()) {
      state().boundariesCrossed++;
    }
    return parent;
  }

    // Declared in ASTNode.ast at line 125

  public void setParent(ASTNode node) {
    parent = node;
  }

    // Declared in ASTNode.ast at line 129

    protected boolean duringEnumerations() {
        if(state().duringEnumerations == 0) {
            return false;
        }
        else {
            state().pop();
            state().push(ASTNode$State.REWRITE_INTERRUPT);
            return true;
        }
    }

    // Declared in ASTNode.ast at line 140

    protected boolean duringMapping() {
        if(state().duringMapping == 0) {
            return false;
        }
        else {
            state().pop();
            state().push(ASTNode$State.REWRITE_INTERRUPT);
            return true;
        }
    }

    // Declared in ASTNode.ast at line 151

    protected boolean duringErrorHandlingInitialization() {
        if(state().duringErrorHandlingInitialization == 0) {
            return false;
        }
        else {
            state().pop();
            state().push(ASTNode$State.REWRITE_INTERRUPT);
            return true;
        }
    }

    // Declared in ASTNode.ast at line 180

    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private int counter = 0;
            public boolean hasNext() {
                return counter < getNumChild();
            }
            @SuppressWarnings("unchecked") public T next() {
                if(hasNext())
                    return (T)getChild(counter++);
                else
                    return null;
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // Declared in ASTNode.ast at line 197

  public boolean mayHaveRewrite() { return false; }

    // Declared in Labels.jrag at line 16
    protected void collect_contributors_ASTNode_LocalLabelDeclarations() {
        for(int i = 0; i < getNumChild(); i++)
            getChild(i).collect_contributors_ASTNode_LocalLabelDeclarations();
    }

    protected void contributeTo_ASTNode_ASTNode_LocalLabelDeclarations(java.util.List<LabeledStatement> collection) {
    }


    // Declared in OrdinaryNames.jrag at line 18
    protected void collect_contributors_ASTNode_LocalOrdinaryNameDeclarations() {
        for(int i = 0; i < getNumChild(); i++)
            getChild(i).collect_contributors_ASTNode_LocalOrdinaryNameDeclarations();
    }

    protected void contributeTo_ASTNode_ASTNode_LocalOrdinaryNameDeclarations(java.util.List<IOrdinaryNameDeclaration> collection) {
    }


    // Declared in Tags.jrag at line 48
    protected void collect_contributors_ASTNode_LocalTagDeclarations() {
        for(int i = 0; i < getNumChild(); i++)
            getChild(i).collect_contributors_ASTNode_LocalTagDeclarations();
    }

    protected void contributeTo_ASTNode_ASTNode_LocalTagDeclarations(java.util.List<TagedType> collection) {
    }


    // Declared in CompilerAPI.jrag at line 146
    protected void collect_contributors_FunctionDefinitionInitializer_AssociatedReturnJumps() {
        for(int i = 0; i < getNumChild(); i++)
            getChild(i).collect_contributors_FunctionDefinitionInitializer_AssociatedReturnJumps();
    }

    protected void contributeTo_FunctionDefinitionInitializer_FunctionDefinitionInitializer_AssociatedReturnJumps(java.util.List<ReturnJump> collection) {
    }


    // Declared in ControlFlow.jrag at line 24
    protected void collect_contributors_Statement_ControlFlowPredecessor() {
        for(int i = 0; i < getNumChild(); i++)
            getChild(i).collect_contributors_Statement_ControlFlowPredecessor();
    }

    protected void contributeTo_Statement_Statement_ControlFlowPredecessor(java.util.Set<Statement> collection) {
    }


    // Declared in CompilerAPI.jrag at line 139
    protected void collect_contributors_SwitchStatement_AssociatedLabels() {
        for(int i = 0; i < getNumChild(); i++)
            getChild(i).collect_contributors_SwitchStatement_AssociatedLabels();
    }

    protected void contributeTo_SwitchStatement_SwitchStatement_AssociatedLabels(java.util.List<LabeledStatement> collection) {
    }


    protected int CompilationRootNode_visited = -1;
/**
	 * Support the construction of appropriate error nodes.
	 * 
	 * Error nodes are used as mock classes for attributes referencing other AST nodes.
	 * Often semantic constraints for one language construct assume, that
	 * another language construct exists. But for invalid programs the other
	 * language construct may not exists. E.g. a variable may not be declared.
	 * But for the type analysis the declaration of a variable in an expression
	 * is looked up. Error nodes can be used to represent not existing AST references.
	 * For each semantic constraint requiering some node in the AST to exist, an attribute
	 * can be defined returning a reference to the node. If the semantic constraint is not
	 * met, thus no referenced AST node exists, the attribute can instead return an error
	 * node of the requiered type.
	 
    Declared in CompilerAPI.jrag at line 366
*/
 @SuppressWarnings({"unchecked", "cast"})     public Compilation CompilationRootNode() {
        if(CompilationRootNode_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: CompilationRootNode in class: ");
        CompilationRootNode_visited = state().boundariesCrossed;
        Compilation CompilationRootNode_value = CompilationRootNode_compute();
        CompilationRootNode_visited = -1;
        return CompilationRootNode_value;
    }

    private Compilation CompilationRootNode_compute() {  return getParent().CompilationRootNode();  }

    protected int ErrorBuilder_visited = -1;
    // Declared in CompilerAPI.jrag at line 369
 @SuppressWarnings({"unchecked", "cast"})     public ErrorBuilder ErrorBuilder() {
        if(ErrorBuilder_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: ErrorBuilder in class: ");
        ErrorBuilder_visited = state().boundariesCrossed;
        ErrorBuilder ErrorBuilder_value = ErrorBuilder_compute();
        ErrorBuilder_visited = -1;
        return ErrorBuilder_value;
    }

    private ErrorBuilder ErrorBuilder_compute() {  return CompilationRootNode().getErrorBuilder();  }

    protected int IsCorrect_visited = -1;
/**
	 * Handles the traversion of the AST to verify all constraints for a given
	 * node AND it's sub nodes.
	 
    Declared in ConstraintVerification.jrag at line 5
*/
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsCorrect() {
        if(IsCorrect_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsCorrect in class: ");
        IsCorrect_visited = state().boundariesCrossed;
        boolean IsCorrect_value = IsCorrect_compute();
        IsCorrect_visited = -1;
        return IsCorrect_value;
    }

    private boolean IsCorrect_compute() {
		boolean result = true;
		
		if (!IsCorrectLocal())
			result = false;
		
		for (int i = 0; i < getNumChild(); i++) {
			if (!getChild(i).IsCorrect())
				result = false;
		}
		
		return result;
	}

    protected int IsCorrectLocal_visited = -1;
/**
	 * This attribute handles the semantic constraint verification for one
	 * AST node, without traversing the tree, thus sub nodes may still be
	 * incorrect when isCorrectLocal() returns true. In this case it's only
	 * guaranteed that this AST node's semantic constraints are satisfied.
	 
    Declared in ConstraintVerification.jrag at line 18
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
		// If the ASTNode is an intermediate node, the compiler implementation is erroneus:
		String[] name = this.getClass().getName().split("\\.");
		if (name[name.length - 1].startsWith("_"))
			throw new jastaddc.semantics.ConcreteToASTFailure(this);
		// If the AST is broken the compiler implementation is erroneus:
		for (int i = 0; i < getNumChild(); i++) {
			if (getChild(i) == null)
				throw new jastaddc.semantics.SemanticalFailure("IMPLEMENTATION ERROR: AST node has 'null' child ["+
						"\n\tNode: "+ this +
						"\n\tChild number: "+ i +
						"\n]");
			if (getChild(i).getParent() != this)
				throw new jastaddc.semantics.SemanticalFailure("IMPLEMENTATION ERROR: AST node has child but is not parent ["+
						"\n\tNode: "+ this.getClass().getName() +
						"\n\tChild number: "+ i +
						"\n\tChild: "+ getChild(i) +
						"\n\tChild's parent: "+ getChild(i).getParent() +
						"\n]");
		}
		// Otherwise everything is fine if there are no errors added:
		return collectAllErrorsOfNode().size() == 0;
	}

    protected java.util.Map addError_jastaddc_SourceError_visited;
/**
	 * Adds an error to the list of errors associated with this AST node.
	 
    Declared in ErrorHandling.jrag at line 61
*/
 @SuppressWarnings({"unchecked", "cast"})     public boolean addError(jastaddc.SourceError error) {
        Object _parameters = error;
if(addError_jastaddc_SourceError_visited == null) addError_jastaddc_SourceError_visited = new java.util.HashMap(4);
        if(new Integer(state().boundariesCrossed).equals(addError_jastaddc_SourceError_visited.get(_parameters)))
            throw new RuntimeException("Circular definition of attr: addError in class: ");
        addError_jastaddc_SourceError_visited.put(_parameters, new Integer(state().boundariesCrossed));
        boolean addError_jastaddc_SourceError_value = addError_compute(error);
        addError_jastaddc_SourceError_visited.remove(_parameters);
        return addError_jastaddc_SourceError_value;
    }

    private boolean addError_compute(jastaddc.SourceError error) {
		if (error == null)
			return false;
		if (!errors.contains(error)) { // Has the error been encountered before?
			errors.add(error);
			return true;
		}
		return false;
	}

    protected java.util.Map findNodeInSubtreeErrorIsAssociatedWith_jastaddc_SourceError_visited;
/**
	 * Returns the AST node the given error is associated with, if the AST node
	 * is this node or a node of this nodes subtree. If the associated AST node
	 * is not found, null is returned.
	 
    Declared in ErrorHandling.jrag at line 70
*/
 @SuppressWarnings({"unchecked", "cast"})     public ASTNode findNodeInSubtreeErrorIsAssociatedWith(jastaddc.SourceError error) {
        Object _parameters = error;
if(findNodeInSubtreeErrorIsAssociatedWith_jastaddc_SourceError_visited == null) findNodeInSubtreeErrorIsAssociatedWith_jastaddc_SourceError_visited = new java.util.HashMap(4);
        if(new Integer(state().boundariesCrossed).equals(findNodeInSubtreeErrorIsAssociatedWith_jastaddc_SourceError_visited.get(_parameters)))
            throw new RuntimeException("Circular definition of attr: findNodeInSubtreeErrorIsAssociatedWith in class: ");
        findNodeInSubtreeErrorIsAssociatedWith_jastaddc_SourceError_visited.put(_parameters, new Integer(state().boundariesCrossed));
        ASTNode findNodeInSubtreeErrorIsAssociatedWith_jastaddc_SourceError_value = findNodeInSubtreeErrorIsAssociatedWith_compute(error);
        findNodeInSubtreeErrorIsAssociatedWith_jastaddc_SourceError_visited.remove(_parameters);
        return findNodeInSubtreeErrorIsAssociatedWith_jastaddc_SourceError_value;
    }

    private ASTNode findNodeInSubtreeErrorIsAssociatedWith_compute(jastaddc.SourceError error) {
		if (errors.contains(error))
			return this;
		for (int i = 0; i < getNumChild(); i++) {
			ASTNode result = getChild(i).findNodeInSubtreeErrorIsAssociatedWith(error);
			if (result != null)
				return result;
		}
		return null;
	}

    protected int collectAllErrorsOfTree_visited = -1;
/**
	 * Returns an iterator above all the errors of this complete (sub)tree,
	 * thus the errors of this AST node and it's sub nodes.
	 
    Declared in ErrorHandling.jrag at line 80
*/
 @SuppressWarnings({"unchecked", "cast"})     public java.util.Iterator<jastaddc.SourceError> collectAllErrorsOfTree() {
        if(collectAllErrorsOfTree_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: collectAllErrorsOfTree in class: ");
        collectAllErrorsOfTree_visited = state().boundariesCrossed;
        java.util.Iterator<jastaddc.SourceError> collectAllErrorsOfTree_value = collectAllErrorsOfTree_compute();
        collectAllErrorsOfTree_visited = -1;
        return collectAllErrorsOfTree_value;
    }

    private java.util.Iterator<jastaddc.SourceError> collectAllErrorsOfTree_compute() {
		FlattingIterator result =
			new FlattingIterator<jastaddc.SourceError>(errors.iterator(), getNumChild() + 1);
		for (int i = 0; i < getNumChild(); i++) {
			result.addIterator(getChild(i).collectAllErrorsOfTree());
		}
		return result;
	}

    protected int collectAllErrorsOfNode_visited = -1;
/**
	 * Returns a collection of all the errors for this node.
	 
    Declared in ErrorHandling.jrag at line 88
*/
 @SuppressWarnings({"unchecked", "cast"})     public java.util.Collection<jastaddc.SourceError> collectAllErrorsOfNode() {
        if(collectAllErrorsOfNode_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: collectAllErrorsOfNode in class: ");
        collectAllErrorsOfNode_visited = state().boundariesCrossed;
        java.util.Collection<jastaddc.SourceError> collectAllErrorsOfNode_value = collectAllErrorsOfNode_compute();
        collectAllErrorsOfNode_visited = -1;
        return collectAllErrorsOfNode_value;
    }

    private java.util.Collection<jastaddc.SourceError> collectAllErrorsOfNode_compute() {  return errors;  }

    protected int FindNodeIntroducingThisLabelBlock_visited = -1;
/**
	 * Generic name analysis algorithm:
	 
    Declared in Labels.jrag at line 11
*/
 @SuppressWarnings({"unchecked", "cast"})     public ASTNode FindNodeIntroducingThisLabelBlock() {
        if(FindNodeIntroducingThisLabelBlock_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: FindNodeIntroducingThisLabelBlock in class: ");
        FindNodeIntroducingThisLabelBlock_visited = state().boundariesCrossed;
        ASTNode FindNodeIntroducingThisLabelBlock_value = FindNodeIntroducingThisLabelBlock_compute();
        FindNodeIntroducingThisLabelBlock_visited = -1;
        return FindNodeIntroducingThisLabelBlock_value;
    }

    private ASTNode FindNodeIntroducingThisLabelBlock_compute() {  return IntroducesNewLabelBlock() ? this : getParent().FindNodeIntroducingThisLabelBlock();  }

    protected java.util.Map LookUpLabel_String_visited;
    // Declared in Labels.jrag at line 19
 @SuppressWarnings({"unchecked", "cast"})     public java.util.List<LabeledStatement> LookUpLabel(String name) {
        Object _parameters = name;
if(LookUpLabel_String_visited == null) LookUpLabel_String_visited = new java.util.HashMap(4);
        if(new Integer(state().boundariesCrossed).equals(LookUpLabel_String_visited.get(_parameters)))
            throw new RuntimeException("Circular definition of attr: LookUpLabel in class: ");
        LookUpLabel_String_visited.put(_parameters, new Integer(state().boundariesCrossed));
        java.util.List<LabeledStatement> LookUpLabel_String_value = LookUpLabel_compute(name);
        LookUpLabel_String_visited.remove(_parameters);
        return LookUpLabel_String_value;
    }

    private java.util.List<LabeledStatement> LookUpLabel_compute(String name) {
		ASTNode blockNode = FindNodeIntroducingThisLabelBlock();
		java.util.List<LabeledStatement> result = ListFilter.filter(
				blockNode.LocalLabelDeclarations(),
				new LabelNameFilter(name));
		return !result.isEmpty() ? result : (blockNode.getParent() == null ?
					new java.util.ArrayList<LabeledStatement>(0) :
					blockNode.getParent().LookUpLabel(name));
	}

    protected int IntroducesNewLabelBlock_visited = -1;
/**
	 * The ASTNodes introducting new blocks for label names.
	 
    Declared in Labels.jrag at line 33
*/
	// By default no nodes introduce new label blocks, except the root node:
 @SuppressWarnings({"unchecked", "cast"})     public boolean IntroducesNewLabelBlock() {
        if(IntroducesNewLabelBlock_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IntroducesNewLabelBlock in class: ");
        IntroducesNewLabelBlock_visited = state().boundariesCrossed;
        boolean IntroducesNewLabelBlock_value = IntroducesNewLabelBlock_compute();
        IntroducesNewLabelBlock_visited = -1;
        return IntroducesNewLabelBlock_value;
    }

    private boolean IntroducesNewLabelBlock_compute() {  return getParent() == null ? true : false;  }

    protected int IntroducesNewOrdinaryNameBlock_visited = -1;
/**
	 * Generic name analysis algorithm:
	 
    Declared in OrdinaryNames.jrag at line 11
*/
 @SuppressWarnings({"unchecked", "cast"})     public boolean IntroducesNewOrdinaryNameBlock() {
        if(IntroducesNewOrdinaryNameBlock_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IntroducesNewOrdinaryNameBlock in class: ");
        IntroducesNewOrdinaryNameBlock_visited = state().boundariesCrossed;
        boolean IntroducesNewOrdinaryNameBlock_value = IntroducesNewOrdinaryNameBlock_compute();
        IntroducesNewOrdinaryNameBlock_visited = -1;
        return IntroducesNewOrdinaryNameBlock_value;
    }

    private boolean IntroducesNewOrdinaryNameBlock_compute() {  return IsNodeTypeOrdinaryNameBlock() || IsOrdinaryNameBlockInContext(this);  }

    protected int FindNodeIntroducingThisOrdinaryNameBlock_visited = -1;
    // Declared in OrdinaryNames.jrag at line 13
 @SuppressWarnings({"unchecked", "cast"})     public ASTNode FindNodeIntroducingThisOrdinaryNameBlock() {
        if(FindNodeIntroducingThisOrdinaryNameBlock_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: FindNodeIntroducingThisOrdinaryNameBlock in class: ");
        FindNodeIntroducingThisOrdinaryNameBlock_visited = state().boundariesCrossed;
        ASTNode FindNodeIntroducingThisOrdinaryNameBlock_value = FindNodeIntroducingThisOrdinaryNameBlock_compute();
        FindNodeIntroducingThisOrdinaryNameBlock_visited = -1;
        return FindNodeIntroducingThisOrdinaryNameBlock_value;
    }

    private ASTNode FindNodeIntroducingThisOrdinaryNameBlock_compute() {  return IntroducesNewOrdinaryNameBlock() ? this : getParent().FindNodeIntroducingThisOrdinaryNameBlock();  }

    protected java.util.Map LookUpOrdinaryName_String_visited;
    // Declared in OrdinaryNames.jrag at line 21
 @SuppressWarnings({"unchecked", "cast"})     public java.util.List<IOrdinaryNameDeclaration> LookUpOrdinaryName(String name) {
        Object _parameters = name;
if(LookUpOrdinaryName_String_visited == null) LookUpOrdinaryName_String_visited = new java.util.HashMap(4);
        if(new Integer(state().boundariesCrossed).equals(LookUpOrdinaryName_String_visited.get(_parameters)))
            throw new RuntimeException("Circular definition of attr: LookUpOrdinaryName in class: ");
        LookUpOrdinaryName_String_visited.put(_parameters, new Integer(state().boundariesCrossed));
        java.util.List<IOrdinaryNameDeclaration> LookUpOrdinaryName_String_value = LookUpOrdinaryName_compute(name);
        LookUpOrdinaryName_String_visited.remove(_parameters);
        return LookUpOrdinaryName_String_value;
    }

    private java.util.List<IOrdinaryNameDeclaration> LookUpOrdinaryName_compute(String name) {  return LookUpOrdinaryName(name, NodeAddress());  }

    protected java.util.Map LookUpOrdinaryName_String_jastaddc_semantics_NodeAddress_visited;
    // Declared in OrdinaryNames.jrag at line 22
 @SuppressWarnings({"unchecked", "cast"})     public java.util.List<IOrdinaryNameDeclaration> LookUpOrdinaryName(String name, jastaddc.semantics.NodeAddress upToAddress) {
        java.util.List _parameters = new java.util.ArrayList(2);
        _parameters.add(name);
        _parameters.add(upToAddress);
if(LookUpOrdinaryName_String_jastaddc_semantics_NodeAddress_visited == null) LookUpOrdinaryName_String_jastaddc_semantics_NodeAddress_visited = new java.util.HashMap(4);
        if(new Integer(state().boundariesCrossed).equals(LookUpOrdinaryName_String_jastaddc_semantics_NodeAddress_visited.get(_parameters)))
            throw new RuntimeException("Circular definition of attr: LookUpOrdinaryName in class: ");
        LookUpOrdinaryName_String_jastaddc_semantics_NodeAddress_visited.put(_parameters, new Integer(state().boundariesCrossed));
        java.util.List<IOrdinaryNameDeclaration> LookUpOrdinaryName_String_jastaddc_semantics_NodeAddress_value = LookUpOrdinaryName_compute(name, upToAddress);
        LookUpOrdinaryName_String_jastaddc_semantics_NodeAddress_visited.remove(_parameters);
        return LookUpOrdinaryName_String_jastaddc_semantics_NodeAddress_value;
    }

    private java.util.List<IOrdinaryNameDeclaration> LookUpOrdinaryName_compute(String name, jastaddc.semantics.NodeAddress upToAddress) {
		ASTNode blockNode = FindNodeIntroducingThisOrdinaryNameBlock();
		java.util.List<IOrdinaryNameDeclaration> result = ListFilter.filter(
				blockNode.LocalOrdinaryNameDeclarations(),
				new AddressFilter((ListFilter.AFilterCriteria)new OrdinaryNameFilter(name), upToAddress));
		return !result.isEmpty() ? result : (blockNode.getParent() == null ?
					new java.util.ArrayList<TagedType>(0) :
					blockNode.getParent().LookUpOrdinaryName(name, upToAddress));
	}

    protected java.util.Map IsOrdinaryNameBlockInContext_ASTNode_visited;
/**
	 * The ASTNodes introducing new blocks for ordinary names.
	 
    Declared in OrdinaryNames.jrag at line 37
*/
	// By default a node just asks it's parent node if some node
	// introduces a new ordinary name block because of the nodes context:
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsOrdinaryNameBlockInContext(ASTNode node) {
        Object _parameters = node;
if(IsOrdinaryNameBlockInContext_ASTNode_visited == null) IsOrdinaryNameBlockInContext_ASTNode_visited = new java.util.HashMap(4);
        if(new Integer(state().boundariesCrossed).equals(IsOrdinaryNameBlockInContext_ASTNode_visited.get(_parameters)))
            throw new RuntimeException("Circular definition of attr: IsOrdinaryNameBlockInContext in class: ");
        IsOrdinaryNameBlockInContext_ASTNode_visited.put(_parameters, new Integer(state().boundariesCrossed));
        boolean IsOrdinaryNameBlockInContext_ASTNode_value = IsOrdinaryNameBlockInContext_compute(node);
        IsOrdinaryNameBlockInContext_ASTNode_visited.remove(_parameters);
        return IsOrdinaryNameBlockInContext_ASTNode_value;
    }

    private boolean IsOrdinaryNameBlockInContext_compute(ASTNode node) {  return getParent() == null ? false : getParent().IsOrdinaryNameBlockInContext(node);  }

    protected int IsNodeTypeOrdinaryNameBlock_visited = -1;
    // Declared in OrdinaryNames.jrag at line 40
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsNodeTypeOrdinaryNameBlock() {
        if(IsNodeTypeOrdinaryNameBlock_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsNodeTypeOrdinaryNameBlock in class: ");
        IsNodeTypeOrdinaryNameBlock_visited = state().boundariesCrossed;
        boolean IsNodeTypeOrdinaryNameBlock_value = IsNodeTypeOrdinaryNameBlock_compute();
        IsNodeTypeOrdinaryNameBlock_visited = -1;
        return IsNodeTypeOrdinaryNameBlock_value;
    }

    private boolean IsNodeTypeOrdinaryNameBlock_compute() {  return getParent() == null ? true : false;  }

    protected int IntroducesNewTagBlock_visited = -1;
/**
	 * Generic name analysis algorithm:
	 
    Declared in Tags.jrag at line 41
*/
 @SuppressWarnings({"unchecked", "cast"})     public boolean IntroducesNewTagBlock() {
        if(IntroducesNewTagBlock_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IntroducesNewTagBlock in class: ");
        IntroducesNewTagBlock_visited = state().boundariesCrossed;
        boolean IntroducesNewTagBlock_value = IntroducesNewTagBlock_compute();
        IntroducesNewTagBlock_visited = -1;
        return IntroducesNewTagBlock_value;
    }

    private boolean IntroducesNewTagBlock_compute() {  return IsNodeTypeTagBlock() || IsTagBlockInContext(this);  }

    protected int FindNodeIntroducingThisTagBlock_visited = -1;
    // Declared in Tags.jrag at line 43
 @SuppressWarnings({"unchecked", "cast"})     public ASTNode FindNodeIntroducingThisTagBlock() {
        if(FindNodeIntroducingThisTagBlock_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: FindNodeIntroducingThisTagBlock in class: ");
        FindNodeIntroducingThisTagBlock_visited = state().boundariesCrossed;
        ASTNode FindNodeIntroducingThisTagBlock_value = FindNodeIntroducingThisTagBlock_compute();
        FindNodeIntroducingThisTagBlock_visited = -1;
        return FindNodeIntroducingThisTagBlock_value;
    }

    private ASTNode FindNodeIntroducingThisTagBlock_compute() {  return IntroducesNewTagBlock() ? this : getParent().FindNodeIntroducingThisTagBlock();  }

    protected java.util.Map LookUpTag_String_visited;
    // Declared in Tags.jrag at line 51
 @SuppressWarnings({"unchecked", "cast"})     public java.util.List<TagedType> LookUpTag(String name) {
        Object _parameters = name;
if(LookUpTag_String_visited == null) LookUpTag_String_visited = new java.util.HashMap(4);
        if(new Integer(state().boundariesCrossed).equals(LookUpTag_String_visited.get(_parameters)))
            throw new RuntimeException("Circular definition of attr: LookUpTag in class: ");
        LookUpTag_String_visited.put(_parameters, new Integer(state().boundariesCrossed));
        java.util.List<TagedType> LookUpTag_String_value = LookUpTag_compute(name);
        LookUpTag_String_visited.remove(_parameters);
        return LookUpTag_String_value;
    }

    private java.util.List<TagedType> LookUpTag_compute(String name) {  return LookUpTag(name, NodeAddress());  }

    protected java.util.Map LookUpTag_String_jastaddc_semantics_NodeAddress_visited;
    // Declared in Tags.jrag at line 52
 @SuppressWarnings({"unchecked", "cast"})     public java.util.List<TagedType> LookUpTag(String name, jastaddc.semantics.NodeAddress upToAddress) {
        java.util.List _parameters = new java.util.ArrayList(2);
        _parameters.add(name);
        _parameters.add(upToAddress);
if(LookUpTag_String_jastaddc_semantics_NodeAddress_visited == null) LookUpTag_String_jastaddc_semantics_NodeAddress_visited = new java.util.HashMap(4);
        if(new Integer(state().boundariesCrossed).equals(LookUpTag_String_jastaddc_semantics_NodeAddress_visited.get(_parameters)))
            throw new RuntimeException("Circular definition of attr: LookUpTag in class: ");
        LookUpTag_String_jastaddc_semantics_NodeAddress_visited.put(_parameters, new Integer(state().boundariesCrossed));
        java.util.List<TagedType> LookUpTag_String_jastaddc_semantics_NodeAddress_value = LookUpTag_compute(name, upToAddress);
        LookUpTag_String_jastaddc_semantics_NodeAddress_visited.remove(_parameters);
        return LookUpTag_String_jastaddc_semantics_NodeAddress_value;
    }

    private java.util.List<TagedType> LookUpTag_compute(String name, jastaddc.semantics.NodeAddress upToAddress) {
		ASTNode blockNode = FindNodeIntroducingThisTagBlock();
		java.util.List<TagedType> result = ListFilter.filter(
				blockNode.LocalTagDeclarations(),
				new TagNameFilter(new AddressFilter(upToAddress), name));
		return !result.isEmpty() ? result : (blockNode.getParent() == null ?
					new java.util.ArrayList<TagedType>(0) :
					blockNode.getParent().LookUpTag(name, upToAddress));
	}

    protected java.util.Map IsTagBlockInContext_ASTNode_visited;
/**
	 * The ASTNodes introducing new blocks for tags.
	 
    Declared in Tags.jrag at line 65
*/
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsTagBlockInContext(ASTNode node) {
        Object _parameters = node;
if(IsTagBlockInContext_ASTNode_visited == null) IsTagBlockInContext_ASTNode_visited = new java.util.HashMap(4);
        if(new Integer(state().boundariesCrossed).equals(IsTagBlockInContext_ASTNode_visited.get(_parameters)))
            throw new RuntimeException("Circular definition of attr: IsTagBlockInContext in class: ");
        IsTagBlockInContext_ASTNode_visited.put(_parameters, new Integer(state().boundariesCrossed));
        boolean IsTagBlockInContext_ASTNode_value = IsTagBlockInContext_compute(node);
        IsTagBlockInContext_ASTNode_visited.remove(_parameters);
        return IsTagBlockInContext_ASTNode_value;
    }

    private boolean IsTagBlockInContext_compute(ASTNode node) {  return IsOrdinaryNameBlockInContext(node);  }

    protected int IsNodeTypeTagBlock_visited = -1;
    // Declared in Tags.jrag at line 67
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsNodeTypeTagBlock() {
        if(IsNodeTypeTagBlock_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsNodeTypeTagBlock in class: ");
        IsNodeTypeTagBlock_visited = state().boundariesCrossed;
        boolean IsNodeTypeTagBlock_value = IsNodeTypeTagBlock_compute();
        IsNodeTypeTagBlock_visited = -1;
        return IsNodeTypeTagBlock_value;
    }

    private boolean IsNodeTypeTagBlock_compute() {  return IsNodeTypeOrdinaryNameBlock();  }

    protected int NodeAddress_visited = -1;
/**
	 * The NodeAddress() attribute represents an AST node's unique Dewey notation
	 * address. Hence, NodeAddresse objects are comparable, so it can be decided whether:
	 *  - a node is an ancestor node of another node
	 *  - a node is a successor node of another node
	 *  - a node is in a subtree left to another node
	 *  - a node is in a subtree right to another node
	 
    Declared in CompilerAPI.jrag at line 157
*/
 @SuppressWarnings({"unchecked", "cast"})     public jastaddc.semantics.NodeAddress NodeAddress() {
        if(NodeAddress_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: NodeAddress in class: ");
        NodeAddress_visited = state().boundariesCrossed;
        jastaddc.semantics.NodeAddress NodeAddress_value = getParent().Define_jastaddc_semantics_NodeAddress_NodeAddress(this, null);
        NodeAddress_visited = -1;
        return NodeAddress_value;
    }

    protected int IsErrorNode_visited = -1;
    // Declared in CompilerAPI.jrag at line 372
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsErrorNode() {
        if(IsErrorNode_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsErrorNode in class: ");
        IsErrorNode_visited = state().boundariesCrossed;
        boolean IsErrorNode_value = getParent().Define_boolean_IsErrorNode(this, null);
        IsErrorNode_visited = -1;
        return IsErrorNode_value;
    }

    // Declared in ContextInformationAccess.jrag at line 20
    public Declaration Define_Declaration_IsPartOfFunctionDeclaration(ASTNode caller, ASTNode child) {
        if(true) {
      int index = this.getIndexOfChild(caller);
            return null;
        }
        return getParent().Define_Declaration_IsPartOfFunctionDeclaration(this, caller);
    }

    // Declared in ASTNodeAddresses.jrag at line 8
    public jastaddc.semantics.NodeAddress Define_jastaddc_semantics_NodeAddress_NodeAddress(ASTNode caller, ASTNode child) {
        if(true) {
      int index = this.getIndexOfChild(caller);
            return NodeAddress().clone().addAddressPart(index + 1);
        }
        return getParent().Define_jastaddc_semantics_NodeAddress_NodeAddress(this, caller);
    }

public ASTNode rewriteTo() {
    if(state().peek() == ASTNode$State.REWRITE_CHANGE) {
        state().pop();
        state().push(ASTNode$State.REWRITE_NOCHANGE);
    }
    return this;
}

    protected int ASTNode_LocalLabelDeclarations_visited = -1;
    protected boolean ASTNode_LocalLabelDeclarations_computed = false;
    protected java.util.List<LabeledStatement> ASTNode_LocalLabelDeclarations_value;
    // Declared in Labels.jrag at line 16
 @SuppressWarnings({"unchecked", "cast"})     public java.util.List<LabeledStatement> LocalLabelDeclarations() {
        if(ASTNode_LocalLabelDeclarations_computed)
            return ASTNode_LocalLabelDeclarations_value;
        if(ASTNode_LocalLabelDeclarations_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: LocalLabelDeclarations in class: ");
        ASTNode_LocalLabelDeclarations_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        ASTNode_LocalLabelDeclarations_value = LocalLabelDeclarations_compute();
        if(isFinal && num == state().boundariesCrossed)
            ASTNode_LocalLabelDeclarations_computed = true;
        ASTNode_LocalLabelDeclarations_visited = -1;
        return ASTNode_LocalLabelDeclarations_value;
    }

    java.util.HashSet ASTNode_LocalLabelDeclarations_contributors = new java.util.HashSet();
    public java.util.HashSet ASTNode_LocalLabelDeclarations_contributors() { return ASTNode_LocalLabelDeclarations_contributors; }
    private java.util.List<LabeledStatement> LocalLabelDeclarations_compute() {
        ASTNode node = this;
        while(node.getParent() != null && !(node instanceof Compilation))
            node = node.getParent();
        Compilation root = (Compilation)node;
        root.collect_contributors_ASTNode_LocalLabelDeclarations();
        ASTNode_LocalLabelDeclarations_value = new java.util.ArrayList<LabeledStatement>();
        for(java.util.Iterator iter = ASTNode_LocalLabelDeclarations_contributors.iterator(); iter.hasNext(); ) {
            ASTNode contributor = (ASTNode)iter.next();
            contributor.contributeTo_ASTNode_ASTNode_LocalLabelDeclarations(ASTNode_LocalLabelDeclarations_value);
        }
        return ASTNode_LocalLabelDeclarations_value;
    }

    protected int ASTNode_LocalOrdinaryNameDeclarations_visited = -1;
    protected boolean ASTNode_LocalOrdinaryNameDeclarations_computed = false;
    protected java.util.List<IOrdinaryNameDeclaration> ASTNode_LocalOrdinaryNameDeclarations_value;
    // Declared in OrdinaryNames.jrag at line 18
 @SuppressWarnings({"unchecked", "cast"})     public java.util.List<IOrdinaryNameDeclaration> LocalOrdinaryNameDeclarations() {
        if(ASTNode_LocalOrdinaryNameDeclarations_computed)
            return ASTNode_LocalOrdinaryNameDeclarations_value;
        if(ASTNode_LocalOrdinaryNameDeclarations_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: LocalOrdinaryNameDeclarations in class: ");
        ASTNode_LocalOrdinaryNameDeclarations_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        ASTNode_LocalOrdinaryNameDeclarations_value = LocalOrdinaryNameDeclarations_compute();
        if(isFinal && num == state().boundariesCrossed)
            ASTNode_LocalOrdinaryNameDeclarations_computed = true;
        ASTNode_LocalOrdinaryNameDeclarations_visited = -1;
        return ASTNode_LocalOrdinaryNameDeclarations_value;
    }

    java.util.HashSet ASTNode_LocalOrdinaryNameDeclarations_contributors = new java.util.HashSet();
    public java.util.HashSet ASTNode_LocalOrdinaryNameDeclarations_contributors() { return ASTNode_LocalOrdinaryNameDeclarations_contributors; }
    private java.util.List<IOrdinaryNameDeclaration> LocalOrdinaryNameDeclarations_compute() {
        ASTNode node = this;
        while(node.getParent() != null && !(node instanceof Compilation))
            node = node.getParent();
        Compilation root = (Compilation)node;
        root.collect_contributors_ASTNode_LocalOrdinaryNameDeclarations();
        ASTNode_LocalOrdinaryNameDeclarations_value = new java.util.ArrayList<IOrdinaryNameDeclaration>();
        for(java.util.Iterator iter = ASTNode_LocalOrdinaryNameDeclarations_contributors.iterator(); iter.hasNext(); ) {
            ASTNode contributor = (ASTNode)iter.next();
            contributor.contributeTo_ASTNode_ASTNode_LocalOrdinaryNameDeclarations(ASTNode_LocalOrdinaryNameDeclarations_value);
        }
        return ASTNode_LocalOrdinaryNameDeclarations_value;
    }

    protected int ASTNode_LocalTagDeclarations_visited = -1;
    protected boolean ASTNode_LocalTagDeclarations_computed = false;
    protected java.util.List<TagedType> ASTNode_LocalTagDeclarations_value;
    // Declared in Tags.jrag at line 48
 @SuppressWarnings({"unchecked", "cast"})     public java.util.List<TagedType> LocalTagDeclarations() {
        if(ASTNode_LocalTagDeclarations_computed)
            return ASTNode_LocalTagDeclarations_value;
        if(ASTNode_LocalTagDeclarations_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: LocalTagDeclarations in class: ");
        ASTNode_LocalTagDeclarations_visited = state().boundariesCrossed;
        int num = state().boundariesCrossed;
        boolean isFinal = this.is$Final();
        ASTNode_LocalTagDeclarations_value = LocalTagDeclarations_compute();
        if(isFinal && num == state().boundariesCrossed)
            ASTNode_LocalTagDeclarations_computed = true;
        ASTNode_LocalTagDeclarations_visited = -1;
        return ASTNode_LocalTagDeclarations_value;
    }

    java.util.HashSet ASTNode_LocalTagDeclarations_contributors = new java.util.HashSet();
    public java.util.HashSet ASTNode_LocalTagDeclarations_contributors() { return ASTNode_LocalTagDeclarations_contributors; }
    private java.util.List<TagedType> LocalTagDeclarations_compute() {
        ASTNode node = this;
        while(node.getParent() != null && !(node instanceof Compilation))
            node = node.getParent();
        Compilation root = (Compilation)node;
        root.collect_contributors_ASTNode_LocalTagDeclarations();
        ASTNode_LocalTagDeclarations_value = new java.util.ArrayList<TagedType>();
        for(java.util.Iterator iter = ASTNode_LocalTagDeclarations_contributors.iterator(); iter.hasNext(); ) {
            ASTNode contributor = (ASTNode)iter.next();
            contributor.contributeTo_ASTNode_ASTNode_LocalTagDeclarations(ASTNode_LocalTagDeclarations_value);
        }
        return ASTNode_LocalTagDeclarations_value;
    }

    protected void collect_contributors_ErrorBuilder_ErrorNodes() {
    /**
	 * Provide the different error node building functionalities:
	 
    Declared in ErrorHandling.jrag at line 26
*/
        if(IsErrorNode()) {
        {
            ErrorBuilder ref = (ErrorBuilder)(ErrorBuilder());
            if(ref != null)
                ref.ErrorBuilder_ErrorNodes_contributors().add(this);
        }
        }
        for(int i = 0; i < getNumChild(); i++)
            getChild(i).collect_contributors_ErrorBuilder_ErrorNodes();
    }
    protected void contributeTo_ErrorBuilder_ErrorBuilder_ErrorNodes(java.util.List<ASTNode> collection) {
        if(IsErrorNode())
            collection.add(this);
    }

    public Type Define_Type_PreviousTypePart(ASTNode caller, ASTNode child) {
        return getParent().Define_Type_PreviousTypePart(this, caller);
    }
    public Pointer Define_Pointer_Type(ASTNode caller, ASTNode child) {
        return getParent().Define_Pointer_Type(this, caller);
    }
    public Type Define_Type_TypeSpecifierType(ASTNode caller, ASTNode child) {
        return getParent().Define_Type_TypeSpecifierType(this, caller);
    }
    public boolean Define_boolean_IsErrorNode(ASTNode caller, ASTNode child) {
        return getParent().Define_boolean_IsErrorNode(this, caller);
    }
    public List<TypeQualifier> Define_List_TypeQualifier__TypeQualifier(ASTNode caller, ASTNode child) {
        return getParent().Define_List_TypeQualifier__TypeQualifier(this, caller);
    }
    public FunctionDefinitionInitializer Define_FunctionDefinitionInitializer_FindEnclosingFunctionDefinition(ASTNode caller, ASTNode child) {
        return getParent().Define_FunctionDefinitionInitializer_FindEnclosingFunctionDefinition(this, caller);
    }
    public Enumeration Define_Enumeration_EnumerationContainingElement(ASTNode caller, ASTNode child) {
        return getParent().Define_Enumeration_EnumerationContainingElement(this, caller);
    }
    public EnumerationElement Define_EnumerationElement_PreviousElement(ASTNode caller, ASTNode child) {
        return getParent().Define_EnumerationElement_PreviousElement(this, caller);
    }
    public java.util.Set<Statement> Define_java_util_Set_Statement__ControlFlowFollowing(ASTNode caller, ASTNode child) {
        return getParent().Define_java_util_Set_Statement__ControlFlowFollowing(this, caller);
    }
    public StructuredType Define_StructuredType_StructuredTypeContainingMember(ASTNode caller, ASTNode child) {
        return getParent().Define_StructuredType_StructuredTypeContainingMember(this, caller);
    }
    public ConditionalControlFlowStatement Define_ConditionalControlFlowStatement_FindEnclosingLoopStatement(ASTNode caller, ASTNode child) {
        return getParent().Define_ConditionalControlFlowStatement_FindEnclosingLoopStatement(this, caller);
    }
    public List<StorageClassSpecifier> Define_List_StorageClassSpecifier__StorageClassSpecifier(ASTNode caller, ASTNode child) {
        return getParent().Define_List_StorageClassSpecifier__StorageClassSpecifier(this, caller);
    }
    public FunctionType Define_FunctionType_IsParameterDeclaration(ASTNode caller, ASTNode child) {
        return getParent().Define_FunctionType_IsParameterDeclaration(this, caller);
    }
    public SwitchStatement Define_SwitchStatement_FindEnclosingSwitchStatement(ASTNode caller, ASTNode child) {
        return getParent().Define_SwitchStatement_FindEnclosingSwitchStatement(this, caller);
    }
    public List<FunctionSpecifier> Define_List_FunctionSpecifier__FunctionSpecifier(ASTNode caller, ASTNode child) {
        return getParent().Define_List_FunctionSpecifier__FunctionSpecifier(this, caller);
    }
}
