/*
	This program and the accompanying materials are made available under the
	terms of the MIT license (X11 license) which accompanies this distribution.
	
	Author: Christoff Bürger
*/

package jastaddc;

/**
 * Class representing source specification errors. SourceError's are
 * no exception in the sense that the compiler doesn't work
 * properly or it's configuration is false (Such errors are represented by
 * {@link jastaddc.Compiler.ConfigurationException}s). {@link SourceError}s
 * represent errors in specification files the compiler has/tried to compile
 * and even it has been successful executed the compilation failed because of
 * errors in the source code.
 */
public class SourceError extends Exception implements Comparable<SourceError> {
	public static final long serialVersionUID = 1L;
	
	private static int errorNumberCounter = 0;
	/**
	 * Each SourceError is associated with a compilation phase the error occurred.
	 * 
	 * @author C. Bürger
	 * 
	 */
	public enum ErrorType {LEXICAL, SYNTACTICAL, SEMANTICAL};
	/**
	 * The different error levels are:
	 *  - HARMLESS: The {@link SourceError} is no error at all (e.g. if a
	 *    declaration for some ordinary name is searched and not found, but
	 *    the ordinary name is not declared.)
	 *  - WARNING: The {@link SourceError} is no error, but it represents
	 *    a source code construct which is strange, thus in most cases such
	 *    programs are going to behave in a way the programmer did not expect.
	 *  - ERROR: The {@link SourceError} represents some violation against
	 *    the language specification, thus the source code is no valid program.
	 * 
	 * @author C. Bürger
	 *
	 */
	public enum ErrorLevel {HARMLESS, WARNING, ERROR};
	
	private int errorNumber;
	public ErrorType errorType;
	public ErrorLevel errorLevel;
	public SourceError dependsOnError;
	public Integer line;
	public Integer column;
	public String sourceName;
	
	public SourceError(String message) {
		super(message);
		errorNumberCounter++;
		errorNumber = errorNumberCounter;
		dependsOnError = null;
		line = null;
		column = null;
		sourceName = null;
	}
	
	public SourceError(String message, Exception exception) {
		super(message, exception);
		errorNumberCounter++;
		errorNumber = errorNumberCounter;
		dependsOnError = null;
		line = null;
		column = null;
		sourceName = null;
	}
	
	public SourceError(Exception exception) {
		super(exception);
		errorNumberCounter++;
		errorNumber = errorNumberCounter;
		dependsOnError = null;
		line = null;
		column = null;
		sourceName = null;
	}
	
	public int getErrorNumber() {return errorNumber;}
	
	public String getMessage() {
		StringBuilder errorM = new StringBuilder();
		errorM.append('[');
		errorM.append(errorNumber);
		if (dependsOnError != null) {
			errorM.append("/");
			errorM.append(dependsOnError.errorNumber);
		}
		errorM.append(']');
		if (errorType == ErrorType.LEXICAL)
			errorM.append(" Lexical ");
		else if (errorType == ErrorType.SYNTACTICAL)
			errorM.append(" Syntactical ");
		else if (errorType == ErrorType.SEMANTICAL)
			errorM.append(" Semantical ");
		else errorM.append("§Unknown Error Class§ ");
		if (errorLevel == ErrorLevel.HARMLESS)
			errorM.append("Note (");
		else if (errorLevel == ErrorLevel.WARNING)
			errorM.append("Warning (");
		else if (errorLevel == ErrorLevel.ERROR)
			errorM.append("Error (");
		else errorM.append("§Unknown Level§ (");
		if (sourceName != null && sourceName.length() > 0)
			errorM.append(sourceName);
		else errorM.append("§Unknown Source§");
		errorM.append(':');
		if (line != null)
			errorM.append(line);
		else errorM.append("§Unknown Line§");
		errorM.append(';');
		if (column != null)
			errorM.append(column);
		else errorM.append("§Unknown Column§");
		errorM.append("): ");
		errorM.append(super.getMessage());
		return errorM.toString();
	}
	
	public int compareTo(SourceError o) {
		// Comparison by error level:
		if (errorLevel == ErrorLevel.HARMLESS) {
			if (o.errorLevel == ErrorLevel.WARNING ||
					o.errorLevel == ErrorLevel.ERROR)
				return -1;
		} else if (errorLevel == ErrorLevel.WARNING) {
			if (o.errorLevel == ErrorLevel.HARMLESS)
				return 1;
			else if (o.errorLevel == ErrorLevel.ERROR)
				return -1;
		} else {
			if (o.errorLevel == ErrorLevel.HARMLESS ||
					o.errorLevel == ErrorLevel.WARNING)
				return 1;
		}
		
		// Comparison by error type:
		if (errorType == ErrorType.LEXICAL) {
			if (o.errorType == ErrorType.SEMANTICAL ||
					o.errorType == ErrorType.SYNTACTICAL)
				return -1;
		} else if (errorType ==  ErrorType.SYNTACTICAL) {
			if (o.errorType == ErrorType.LEXICAL)
				return 1;
			else if (o.errorType == ErrorType.SEMANTICAL)
				return -1;
		} else {
			if (o.errorType == ErrorType.LEXICAL ||
					o.errorType ==  ErrorType.SYNTACTICAL)
				return 1;
		}
		
		// Comparison by source:
		int compSource = sourceName.compareTo(o.sourceName);
		if (compSource != 0)
			return compSource;
		
		// Comparison by associated source code position:
		if (line != o.line && line != null && o.line != null)
			return line - o.line;
		if (column != o.column && column != null && o.column != null)
			return column - o.column;
		
		// Comparison by error message:
		return getMessage().compareTo(o.getMessage());
	}
	
	public int hashCode() {
		return errorNumber;
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof SourceError))
			return false;
		if (((SourceError)o).errorNumber == errorNumber)
			return true;
		return compareTo((SourceError)o) == 0;
	}
}
