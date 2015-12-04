/* The following code was generated by JFlex 1.4.2 on 19.08.08 03:29 */

/**
* Lexer for C99 floating constants (6.4.4.2) generated with JFlex.
* 
* Can be used to determine a floating constants whole part, fractional part,
* exponent and suffixes. It returns a {@link jastaddc.semantics.ast.FloatingConstant}.
* 
* @author C. Bürger
* 
*/

package jastaddc.symbols.lexicalanalyse;

import jastaddc.symbols.lexicalanalyse.CUnknownTokenException;

import jastaddc.semantics.PrimitiveTypes;
import jastaddc.semantics.ast.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.2
 * on 19.08.08 03:29 from the specification file
 * <tt>D:/Development/Java/JastAddC/JastAddC/specifications/lexical/CFloatingConstantLexer.jflex</tt>
 */
public final class CFloatingConstantLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int HEXADECIMAL_FLOATING_NUMBER = 2;
  public static final int EXPONENT_DECIMAL = 10;
  public static final int DONE = 16;
  public static final int OPTIONAL_FRACTIONAL_PART_HEXADECIMAL = 4;
  public static final int OPTIONAL_FRACTIONAL_PART_DECIMAL = 8;
  public static final int YYINITIAL = 0;
  public static final int OPTIONAL_EXPONENT_DECIMAL = 12;
  public static final int EXPONENT_BINARY = 6;
  public static final int OPTIONAL_SUFFIX = 14;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  7,  7, 
     8, 8
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\12\0\1\0\40\0\1\7\1\0\1\10\1\5\1\0\1\3\11\1"+
    "\7\0\4\2\1\11\1\12\5\0\1\13\3\0\1\6\7\0\1\4"+
    "\10\0\4\2\1\11\1\12\5\0\1\13\3\0\1\6\7\0\1\4"+
    "\uff87\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\11\0\6\1\2\2\1\1\1\3\1\4\2\5\1\6"+
    "\1\7\1\10\1\11\2\12\1\13\1\12\1\14\3\15"+
    "\1\0\2\16\1\17\2\0\1\20\1\21\2\22\1\23";

  private static int [] zzUnpackAction() {
    int [] result = new int[45];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\14\0\30\0\44\0\60\0\74\0\110\0\124"+
    "\0\140\0\154\0\170\0\204\0\220\0\234\0\250\0\154"+
    "\0\264\0\300\0\154\0\314\0\154\0\300\0\154\0\154"+
    "\0\154\0\154\0\154\0\170\0\154\0\330\0\220\0\154"+
    "\0\234\0\344\0\360\0\154\0\264\0\374\0\u0108\0\374"+
    "\0\154\0\154\0\154\0\360\0\u0108";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[45];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\12\1\13\1\12\1\14\1\12\1\15\7\12\3\16"+
    "\1\12\1\17\3\12\2\16\1\12\1\20\3\21\5\20"+
    "\2\21\1\20\6\12\1\22\5\12\1\23\1\24\1\23"+
    "\1\24\10\23\11\12\1\22\2\12\11\25\1\26\2\25"+
    "\12\27\1\30\1\31\14\32\14\0\1\33\1\34\1\33"+
    "\1\34\1\33\1\35\7\33\1\34\1\33\1\34\1\36"+
    "\1\35\6\33\1\0\1\37\1\0\1\37\10\0\1\40"+
    "\3\41\1\40\1\42\3\40\2\41\1\40\1\0\3\43"+
    "\5\0\2\43\1\0\1\44\3\45\5\44\2\45\1\44"+
    "\1\0\1\46\1\0\1\46\3\0\1\47\1\50\4\0"+
    "\1\24\1\0\1\24\10\0\14\51\14\52\1\53\3\54"+
    "\5\53\2\54\1\53\1\0\1\46\1\0\1\46\11\0"+
    "\1\55\1\0\1\55\10\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[276];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\11\0\1\11\5\1\1\11\2\1\1\11\1\1\1\11"+
    "\1\1\5\11\1\1\1\11\2\1\1\11\2\1\1\0"+
    "\1\11\2\1\2\0\3\11\2\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[45];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
	private int embedded_Line;
	private int embedded_Column;
	
	private StringBuffer lexem;
	private String wholeNumberPart;
	private String fractionalPart;
	private String exponent;
	private NumeralSystemRadix radix;
	private PrimitiveType type;
	
	public void initialize(int embedded_Line, int embedded_Column, java.io.Reader reader) {
		this.embedded_Line = embedded_Line;
		this.embedded_Column = embedded_Column;
		
		lexem = new StringBuffer(128);
		wholeNumberPart = null;
		fractionalPart = null;
		exponent = null;
		radix = null;
		type = null;
		yyreset(reader);
	}


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public CFloatingConstantLexer(java.io.Reader in) {
  	lexem = new StringBuffer(128);
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public CFloatingConstantLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 62) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public FloatingConstant createFloatingPointConstant() throws java.io.IOException, CUnknownTokenException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 7: 
          { lexem.append(yytext());
										type = new PrimitiveType(new List(), PrimitiveTypes._float);
										yybegin(DONE);
          }
        case 20: break;
        case 11: 
          { lexem.append(yytext());
										radix = new NumeralSystemDecimal();
										wholeNumberPart = yytext().substring(0, yytext().length() - 1);
										yybegin(OPTIONAL_FRACTIONAL_PART_DECIMAL);
          }
        case 21: break;
        case 18: 
          { yypushback(1);
										lexem.append(yytext());
										wholeNumberPart = "";
										fractionalPart = yytext().substring(1);
										yybegin(EXPONENT_BINARY);
          }
        case 22: break;
        case 3: 
          { yypushback(1);
										fractionalPart = "";
										yybegin(OPTIONAL_EXPONENT_DECIMAL);
          }
        case 23: break;
        case 17: 
          { yypushback(1);
										lexem.append(yytext());
										wholeNumberPart = yytext().substring(0, yytext().length() - 1);
										yybegin(OPTIONAL_FRACTIONAL_PART_HEXADECIMAL);
          }
        case 24: break;
        case 12: 
          { lexem.append(yytext());
										radix = new NumeralSystemDecimal();
										fractionalPart = yytext().substring(1);
										wholeNumberPart = "";
										yybegin(OPTIONAL_EXPONENT_DECIMAL);
          }
        case 25: break;
        case 19: 
          { lexem.append(yytext());
										exponent = yytext().substring(2);
										yybegin(OPTIONAL_SUFFIX);
          }
        case 26: break;
        case 8: 
          { lexem.append(yytext());
										type = new PrimitiveType(new List(), PrimitiveTypes._long_double);
										yybegin(DONE);
          }
        case 27: break;
        case 4: 
          { lexem.append(yytext());
										fractionalPart = yytext();
										yybegin(OPTIONAL_EXPONENT_DECIMAL);
          }
        case 28: break;
        case 5: 
          { yypushback(1);
										yybegin(OPTIONAL_SUFFIX);
          }
        case 29: break;
        case 16: 
          { yypushback(1);
										lexem.append(yytext());
										radix = new NumeralSystemHexadecimal();
										yybegin(HEXADECIMAL_FLOATING_NUMBER);
          }
        case 30: break;
        case 10: 
          { yypushback(1);
										lexem.append(yytext());
										radix = new NumeralSystemDecimal();
										wholeNumberPart = yytext();
										fractionalPart = "";
										yybegin(EXPONENT_DECIMAL);
          }
        case 31: break;
        case 2: 
          { fractionalPart = "";
										yypushback(1);
										yybegin(EXPONENT_BINARY);
          }
        case 32: break;
        case 14: 
          { yypushback(1);
										lexem.append(yytext());
										fractionalPart = yytext();
										yybegin(EXPONENT_BINARY);
          }
        case 33: break;
        case 1: 
          { throw new CUnknownTokenException(embedded_Line,
									embedded_Column,
									lexem.toString(),
									"No valid floating constant lexem at ("+ embedded_Line +";"+ embedded_Column +").");
          }
        case 34: break;
        case 15: 
          { lexem.append(yytext());
										exponent = yytext().substring(1);
										yybegin(OPTIONAL_SUFFIX);
          }
        case 35: break;
        case 9: 
          { throw new CUnknownTokenException(embedded_Line,
											embedded_Column,
											lexem.toString(),
											"No valid floating constant lexem at ("+ embedded_Line +";"+ embedded_Column +").");
          }
        case 36: break;
        case 13: 
          { yypushback(1);
										lexem.append(yytext());
										wholeNumberPart = yytext();
										fractionalPart = "";
										yybegin(EXPONENT_BINARY);
          }
        case 37: break;
        case 6: 
          { yypushback(1);
										yybegin(DONE);
          }
        case 38: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { 	if (fractionalPart == null)
		fractionalPart = "";
	if (exponent == null)
		exponent = "";
	if (type == null)
		type = new PrimitiveType(new List(), PrimitiveTypes._double);
	return new FloatingConstant(
			lexem.toString(),
			wholeNumberPart,
			fractionalPart,
			exponent,
			radix,
			type);
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
