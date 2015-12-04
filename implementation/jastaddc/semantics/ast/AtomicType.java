
package jastaddc.semantics.ast;



	/**
	 * AtomicTypes represent "type-specifier" [6.7.2] S.99.
	 * 
	 * All Type implementations are recursive, expect the AtomarType. This guarantees,
	 * that "at least one type specifier shall be given in the declaration specifiers
	 * in each declaration, and in the specifier-qualifier list in each struct
	 * declaration and type name" [6.7.2:2] S.99.
	 * 
	 * The TypeName of AtomarTypes may be :
	 * - A Type created by typedef
	 * - A structure, union or enum tag
	 * - A standard type's name (standard types are listed below)
	 * - void
	 * - char
	 * - _Bool
	 * 
	 * The standard signed integer types [6.2.5:4] S.33 are :
	 * - signed char
	 * - signed short int
	 * - signed int
	 * - signed long int
	 * - signed long long int
	 * 
	 * The standard unsigned integer types [6.2.5:6] S.33 are :
	 * - unsigned char
	 * - unsigned short int
	 * - unsigned int
	 * - unsigned long int
	 * - unsigned long long int
	 * 
	 * The standard real floating types [6.2.5:10] S.34 are :
	 * - float
	 * - double
	 * - long double
	 * 
	 * The standard complex types [6.2.5:11] S.34 are :
	 * - float _Complex
	 * - double _Complex
	 * - long double _Complex
	 * 
	 * PARSER-CONSTRAINT / REWRITE: The parser guarantees following rewrites
	 * [6.7.2:2] S.99:
	 * 1)	short 				--> signed short int
	 * 		signed short 		--> signed short int
	 * 		short int 			--> signed short int
	 * 2)	unsigned short 		--> unsigned short int
	 * 3)	int 				--> signed int
	 * 		signed 				--> signed int
	 * 4)	unsigned 			--> unsigned int
	 * 5)	long 				--> signed long int
	 * 		signed long 		--> signed long int
	 * 		long int 			--> signed long int
	 * 6)	unsigned long 		--> unsigned long int
	 * 7)	long long 			--> signed long long int
	 * 		signed long long 	--> signed long long int
	 * 		long long int 		--> signed long long int
	 * 8)	unsigned long long 	--> unsigned long long int
	 */
	
public abstract class AtomicType extends Type implements Cloneable {
    public void flushCache() {
        super.flushCache();
    }
     @SuppressWarnings({"unchecked", "cast"})  public AtomicType clone() throws CloneNotSupportedException {
        AtomicType node = (AtomicType)super.clone();
        node.in$Circle(false);
        node.is$Final(false);
    return node;
    }
    // Declared in C99AST.ast at line 3
    // Declared in C99AST.ast line 274

    public AtomicType() {
        super();

        setChild(new List(), 0);

    }

    // Declared in C99AST.ast at line 11


    // Declared in C99AST.ast line 274
    public AtomicType(List<TypeQualifier> p0) {
        setChild(p0, 0);
    }

    // Declared in C99AST.ast at line 15


  protected int numChildren() {
    return 1;
  }

    // Declared in C99AST.ast at line 18

  public boolean mayHaveRewrite() { return false; }

    // Declared in C99AST.ast at line 2
    // Declared in C99AST.ast line 214
    public void setTypeQualifierList(List<TypeQualifier> list) {
        setChild(list, 0);
    }

    // Declared in C99AST.ast at line 6


    public int getNumTypeQualifier() {
        return getTypeQualifierList().getNumChild();
    }

    // Declared in C99AST.ast at line 10


     @SuppressWarnings({"unchecked", "cast"})  public TypeQualifier getTypeQualifier(int i) {
        return (TypeQualifier)getTypeQualifierList().getChild(i);
    }

    // Declared in C99AST.ast at line 14


    public void addTypeQualifier(TypeQualifier node) {
        List<TypeQualifier> list = getTypeQualifierList();
        list.addChild(node);
    }

    // Declared in C99AST.ast at line 19


    public void setTypeQualifier(TypeQualifier node, int i) {
        List<TypeQualifier> list = getTypeQualifierList();
        list.setChild(node, i);
    }

    // Declared in C99AST.ast at line 23

    public List<TypeQualifier> getTypeQualifiers() {
        return getTypeQualifierList();
    }

    // Declared in C99AST.ast at line 26

    public List<TypeQualifier> getTypeQualifiersNoTransform() {
        return getTypeQualifierListNoTransform();
    }

    // Declared in C99AST.ast at line 30


     @SuppressWarnings({"unchecked", "cast"})  public List<TypeQualifier> getTypeQualifierList() {
        return (List<TypeQualifier>)getChild(0);
    }

    // Declared in C99AST.ast at line 34


     @SuppressWarnings({"unchecked", "cast"})  public List<TypeQualifier> getTypeQualifierListNoTransform() {
        return (List<TypeQualifier>)getChildNoTransform(0);
    }

    // Declared in CompilerAPI.jrag at line 173
 @SuppressWarnings({"unchecked", "cast"})     public abstract String Name();
public ASTNode rewriteTo() {
    return super.rewriteTo();
}

}
