
package jastaddc.semantics.ast;




public class TranslationUnit extends ASTNode<ASTNode> implements Cloneable {
    public void flushCache() {
        super.flushCache();
        IsNodeTypeOrdinaryNameBlock_visited = -1;
    }
     @SuppressWarnings({"unchecked", "cast"})  public TranslationUnit clone() throws CloneNotSupportedException {
        TranslationUnit node = (TranslationUnit)super.clone();
        node.IsNodeTypeOrdinaryNameBlock_visited = -1;
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
     @SuppressWarnings({"unchecked", "cast"})  public TranslationUnit copy() {
      try {
          TranslationUnit node = (TranslationUnit)clone();
          if(children != null) node.children = (ASTNode[])children.clone();
          return node;
      } catch (CloneNotSupportedException e) {
      }
      System.err.println("Error: Could not clone node of type " + getClass().getName() + "!");
      return null;
    }
     @SuppressWarnings({"unchecked", "cast"})  public TranslationUnit fullCopy() {
        TranslationUnit res = (TranslationUnit)copy();
        for(int i = 0; i < getNumChildNoTransform(); i++) {
          ASTNode node = getChildNoTransform(i);
          if(node != null) node = node.fullCopy();
          res.setChild(node, i);
        }
        return res;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 100

    public TranslationUnit() {
        super();

        setChild(new List(), 0);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 100
    public TranslationUnit(List<_IntermediateDeclarationCollection> p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 100
    public void setDeclarationList(List<_IntermediateDeclarationCollection> list) {
        setChild(list, 0);
    }

    // Declared in C99AST.ast at line 6


    public int getNumDeclaration() {
        return getDeclarationList().getNumChild();
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public _IntermediateDeclarationCollection getDeclaration(int i) {
        return (_IntermediateDeclarationCollection)getDeclarationList().getChild(i);
    }

    // Declared in C99AST.ast at line 14


    public void addDeclaration(_IntermediateDeclarationCollection node) {
        List<_IntermediateDeclarationCollection> list = getDeclarationList();
        list.addChild(node);
    }

    // Declared in C99AST.ast at line 19


    public void setDeclaration(_IntermediateDeclarationCollection node, int i) {
        List<_IntermediateDeclarationCollection> list = getDeclarationList();
        list.setChild(node, i);
    }

    // Declared in C99AST.ast at line 23

    public List<_IntermediateDeclarationCollection> getDeclarations() {
        return getDeclarationList();
    }

    // Declared in C99AST.ast at line 26

    public List<_IntermediateDeclarationCollection> getDeclarationsNoTransform() {
        return getDeclarationListNoTransform();
    }

    // Declared in C99AST.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<_IntermediateDeclarationCollection> getDeclarationList() {
        return (List<_IntermediateDeclarationCollection>)getChild(0);
    }

    // Declared in C99AST.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<_IntermediateDeclarationCollection> getDeclarationListNoTransform() {
        return (List<_IntermediateDeclarationCollection>)getChildNoTransform(0);
    }

    protected int IsNodeTypeOrdinaryNameBlock_visited = -1;
    // Declared in OrdinaryNames.jrag at line 43
 @SuppressWarnings({"unchecked", "cast"})     public boolean IsNodeTypeOrdinaryNameBlock() {
        if(IsNodeTypeOrdinaryNameBlock_visited == state().boundariesCrossed)
            throw new RuntimeException("Circular definition of attr: IsNodeTypeOrdinaryNameBlock in class: ");
        IsNodeTypeOrdinaryNameBlock_visited = state().boundariesCrossed;
        boolean IsNodeTypeOrdinaryNameBlock_value = IsNodeTypeOrdinaryNameBlock_compute();
        IsNodeTypeOrdinaryNameBlock_visited = -1;
        return IsNodeTypeOrdinaryNameBlock_value;
    }

    private boolean IsNodeTypeOrdinaryNameBlock_compute() {  return true;  }

    // Declared in ContextInformationAccess.jrag at line 35
    public ConditionalControlFlowStatement Define_ConditionalControlFlowStatement_FindEnclosingLoopStatement(ASTNode caller, ASTNode child) {
        if(caller == getDeclarationListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return null;
        }
        return getParent().Define_ConditionalControlFlowStatement_FindEnclosingLoopStatement(this, caller);
    }

    // Declared in ContextInformationAccess.jrag at line 24
    public FunctionType Define_FunctionType_IsParameterDeclaration(ASTNode caller, ASTNode child) {
        if(caller == getDeclarationListNoTransform()) {
      int index = caller.getIndexOfChild(child);
            return null;
        }
        return getParent().Define_FunctionType_IsParameterDeclaration(this, caller);
    }

    // Declared in ContextInformationAccess.jrag at line 28
    public SwitchStatement Define_SwitchStatement_FindEnclosingSwitchStatement(ASTNode caller, ASTNode child) {
        if(caller == getDeclarationListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return null;
        }
        return getParent().Define_SwitchStatement_FindEnclosingSwitchStatement(this, caller);
    }

    // Declared in ContextInformationAccess.jrag at line 39
    public FunctionDefinitionInitializer Define_FunctionDefinitionInitializer_FindEnclosingFunctionDefinition(ASTNode caller, ASTNode child) {
        if(caller == getDeclarationListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
            return null;
        }
        return getParent().Define_FunctionDefinitionInitializer_FindEnclosingFunctionDefinition(this, caller);
    }

public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
