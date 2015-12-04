package jastaddc.symbols;

/**
 * Exceptions of this type are thrown, if the compiler implementation itself is
 * erroneous, because some lexical constraint the compiler has to full fill is not met.
 * 
 * @author C. Bürger
 *
 */
public class LexicalFailure extends RuntimeException {
	public static final long serialVersionUID = 1L;
	
	public LexicalFailure() {super();}
	public LexicalFailure(String message, Exception exc) {
		super(message, exc);
	}
	public LexicalFailure(String message) {super(message);}
	public LexicalFailure(Exception exc) {super(exc);}
}
