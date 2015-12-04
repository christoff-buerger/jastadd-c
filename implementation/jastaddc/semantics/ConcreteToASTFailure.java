package jastaddc.semantics;

import jastaddc.semantics.ast.ASTNode;

/**
 * This execptions are thrown, if a JastAddC AST has not been mapped to it's final
 * AST correctly. Thus the compiler is erroneous.
 * 
 * @author C. Bürger
 */
public class ConcreteToASTFailure extends SemanticalFailure {
	public static final long serialVersionUID = 1L;
	
	/**
	 * The tree node not mapped correctly to it's final AST node.
	 */
	public ASTNode<?> erroneousNode;
	/**
	 * The node type of the final AST the erroneousNode should have been mapped to.
	 */
	public Class<? extends ASTNode<?>> exspectedNodeType;
	
	public ConcreteToASTFailure(
			ASTNode<?> erroneousNode,
			Class<? extends ASTNode<?>> exspectedNodeType,
			String message, Exception exc) {
		super(message, exc);
		this.erroneousNode = erroneousNode;
		this.exspectedNodeType = exspectedNodeType;
	}
	public ConcreteToASTFailure(
			ASTNode<?> erroneousNode,
			Class<? extends ASTNode<?>> exspectedNodeType,
			String message) {
		super(message);
		this.erroneousNode = erroneousNode;
		this.exspectedNodeType = exspectedNodeType;
	}
	public ConcreteToASTFailure(
			ASTNode<?> erroneousNode,
			Class<? extends ASTNode<?>> exspectedNodeType,
			Exception exc) {
		super(exc);
		this.erroneousNode = erroneousNode;
		this.exspectedNodeType = exspectedNodeType;
	}
	public ConcreteToASTFailure(
			ASTNode<?> erroneousNode,
			Class<? extends ASTNode<?>> exspectedNodeType) {
		super();
		this.erroneousNode = erroneousNode;
		this.exspectedNodeType = exspectedNodeType;
	}
	public ConcreteToASTFailure(
			ASTNode<?> erroneousNode) {
		super();
		this.erroneousNode = erroneousNode;
		this.exspectedNodeType = null;
	}
	
	public String getMessage() {
		StringBuilder errorM = new StringBuilder();
		errorM.append("IMPLEMENTATION ERROR: Encountered intermediate node of type [");
		errorM.append(erroneousNode.getClass().getName());
		errorM.append("] in the AST representing the source ");
		errorM.append(erroneousNode.sourceCodeLocation());
		errorM.append(".\nExspected node of type [");
		if (exspectedNodeType != null)
			errorM.append(exspectedNodeType.getName());
		else errorM.append("§Unspecified Node Type§");
		errorM.append("].\nCorrect the concrete to abstract syntax mapping to ensure that the tree is always rewritten to it's final version.");
		String cause = super.getMessage();
		if (cause != null && cause.length() > 0) {
			errorM.append("\nMapping error cause: ");
			errorM.append(cause);
		}
		return errorM.toString();
	}
}
