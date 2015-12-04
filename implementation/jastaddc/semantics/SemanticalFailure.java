package jastaddc.semantics;

/**
 * Exceptions of this type are thrown, if the compiler implementation itself is
 * erroneous, because some semantic constraint the compiler has to full fill is not met.
 * 
 * @author C. Bürger
 *
 */
public class SemanticalFailure extends RuntimeException {
	public static final long serialVersionUID = 1L;
	
	public SemanticalFailure() {super();}
	public SemanticalFailure(String message, Exception exc) {
		super(message, exc);
	}
	public SemanticalFailure(String message) {super(message);}
	public SemanticalFailure(Exception exc) {super(exc);}
}
