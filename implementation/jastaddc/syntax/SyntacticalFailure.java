package jastaddc.syntax;

/**
 * Exceptions of this type are thrown, if the compiler implementation itself is
 * erroneous, because some syntactical constraint the compiler has to full fill is not met.
 * 
 * @author C. Bürger
 *
 */
public class SyntacticalFailure extends RuntimeException {
	public static final long serialVersionUID = 1L;
	
	public SyntacticalFailure() {super();}
	public SyntacticalFailure(String message, Exception exc) {
		super(message, exc);
	}
	public SyntacticalFailure(String message) {super(message);}
	public SyntacticalFailure(Exception exc) {super(exc);}
}
