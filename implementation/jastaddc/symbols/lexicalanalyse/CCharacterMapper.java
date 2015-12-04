package jastaddc.symbols.lexicalanalyse;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import beaver.Scanner;
import beaver.Symbol;

import jastaddc.syntax.syntacticalanalyse.CParser;

import jastaddc.semantics.ast.*;

/**
* The mapper is used for a C front end developed with JastAdd.
*
* The mapper realizes translation phase 5 :
*  - each source character set member and escape sequence in character
*    constants and string literals is converted to the corresponding member
*    of the execution character set
* 
* It extends beaver's Scanner class, so it can be used as scanner for
* a beaver parser. It's constructor accepts a beaver scanner,
* which the CCharacterMapper will use to recognize lexems. It only checks
* for string literal lexem and character constant token (all other token
* are just forwarded) and transforms their value to the execution
* character set before forwarding them.
* 
* To perform this task the CCharacterMapper is using a JFlex generated
* helper class, the {@link jastaddc.symbols.lexicalanalyse.CCharacterMapper_ CCharacterMapper_}, which
* can be treated like an inner class of the CCharacterMapper.
* 
* TODO : A much better solution would be the following, which can't be done as
* unfortunately JFlex doesn't allow to have an arbitrary type of objects as
* input stream. In this case the mapper could be generated using a JFlex
* specification instead of a manual implementation using a lexer generated
* by a JFlex specification.
* 
* @author C. Bürger
* 
*/
public class CCharacterMapper extends Scanner {
	protected Scanner sourceLexer;
	protected CCharacterMapper_ transformer;
	
	/**
	 * Creates a new mapper for translation phase 5 of an C99 compiler. The
	 * mapper will depend on the lexical informations delivered by an C99 lexer,
	 * which executes all tasks of translation phase 1 to 4.
	 * 
	 * @param lexer The input lexer, delivering token of the input stream.
	 */
	public CCharacterMapper(Scanner lexer) {
		this.sourceLexer = lexer;
		transformer = new CCharacterMapper_((Reader)null);
	}
	
	/**
	 * Computes the next token, thus just forwards the token of the underlying lexer,
	 * if they are no string literal or character constant token. If the underlying
	 * lexer recognizes as next token a string literal or character constant its current
	 * value is read and transformed using a JFlex lexer (the
	 * {@link jastaddc.symbols.lexicalanalyse.CCharacterMapper_ CCharacterMapper_}), specifically generated for this task.
	 * 
	 * @return The next token.
	 */
	public Symbol nextToken() throws Scanner.Exception, IOException {
		Symbol nextSymbol = sourceLexer.nextToken();
		
		if (nextSymbol.getId() == CParser.Terminals.STRING_LITERAL) {
			StringLiteral sl = (StringLiteral)nextSymbol.value;
			transformer.initialize(new StringReader(sl.getStringValue()));
			sl.setStringValue(transformer.transformSourceString());
		} else if (nextSymbol.getId() == CParser.Terminals.CONSTANT && nextSymbol.value instanceof CharacterConstant) {
			CharacterConstant cons = (CharacterConstant)nextSymbol.value;
			transformer.initialize(new StringReader(cons.getCharacterValue()));
			cons.setCharacterValue(transformer.transformSourceString());
		}
		
		return nextSymbol;
	}
}
