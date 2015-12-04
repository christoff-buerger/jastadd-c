
package jastaddc.semantics.ast;

/**
	 * This class is internally used to construct appropriate function specifier,
	 * storage class specifier, type qualifier and type terminals for the following
	 * C99 grammar constructs:
	 *  - declaration_specifiers
	 *  - specifier_qualifier_list
	 *  - type_qualifier_list
	 * These grammar constructs represent lists of
	 *  - storage_class_specifier
	 *  - type_specifier
	 *  - function_specifier
	 *  - type_qualifier
	 * or even a list of mixed elements of all the four types above. The order of the
	 * elements in such a list is unimportant and even elements
	 * may occur several times (except for type_specifier and storage_class_specifier)
	 * they are always treated like they occured exactly one time.
	 * Thus, to make the AST much more read and semantical evaluable each
	 * specifier/qualifier type is represented by a different terminal class. Such a terminal
	 * class describes a set of specifier/qualifier. Only the type_specifier is represented
	 * by a tree, which root node is an instance of the Type class.
	 * 
	 * @author C. B\u00c3\u00bcrger
	 */
public class DeclarationSpecifiersBuilder extends java.lang.Object {
    // Declared in DeclarationSpecifiersBuilder.jrag at line 49

		private List<? extends _declaration_specifiers> specifiers;

    // Declared in DeclarationSpecifiersBuilder.jrag at line 51

		
		protected DeclarationSpecifiersBuilder(List<? extends _declaration_specifiers> specifiers) {
			this.specifiers = specifiers;
		}

    // Declared in DeclarationSpecifiersBuilder.jrag at line 55

		
		protected Type buildType() {
			java.util.List<Type> types = new java.util.LinkedList<Type>();
			StringBuilder primitiveTypeLexem = new StringBuilder();
			
			Type errorType = new PrimitiveType(
					buildTypeQualifier(),
					jastaddc.semantics.PrimitiveTypes._error_type);
			
			for (int i = 0; i < specifiers.getNumChild(); i++) {
				_declaration_specifiers spec = specifiers.getChild(i);
				if (spec instanceof _type_specifier) {
					if (spec instanceof _atomic_type) {
						primitiveTypeLexem.append(' ');
						primitiveTypeLexem.append(((_atomic_type)spec).getTypeName());
					} else if (spec instanceof _struct_or_union_specifier) {
						types.add(((_struct_or_union_specifier)spec).StructuredType());
					} else if (spec instanceof _enum_specifier) {
						types.add(((_enum_specifier)spec).Enumeration());
					} else if (spec instanceof _typedef_name) {
						types.add(((_typedef_name)spec).TypedefTypeReference());
					} else throw new jastaddc.semantics.ConcreteToASTFailure(
							spec,
							null,
							"The _type_specifier ["+ spec.getClass().getName() +
							"] is unknown and can not be mapped to a ["+ Type.class.getName() +"].\n\t"+
							"Complete the ["+ DeclarationSpecifiersBuilder.class.getName() +"] implementation.");
				}
			}
			PrimitiveTypesLexer primitiveTypeLexer =
				new PrimitiveTypesLexer(
						new java.io.StringBufferInputStream(primitiveTypeLexem.toString()));
			while (true) {
				try {
					jastaddc.semantics.PrimitiveTypes primitiveType = primitiveTypeLexer.createBasicType();
					if (primitiveType == null)
						break;
					types.add(new PrimitiveType(buildTypeQualifier(), primitiveType));
				} catch (jastaddc.SourceError error) {
					error.line = specifiers.line;
					error.column = specifiers.column;
					error.sourceName = specifiers.sourceName;
					error.errorLevel = jastaddc.SourceError.ErrorLevel.ERROR;
					error.errorType = jastaddc.SourceError.ErrorType.SYNTACTICAL;
					errorType.addError(error);
					
					return errorType;
				} catch (Exception exc) {
					throw new RuntimeException(exc);
				}
			}
			if (types.size() > 1) {
				StringBuilder errorM = new StringBuilder();
				errorM.append("Type: The type specified in the [");
				errorM.append(specifiers.getClass().getName());
				errorM.append("] at the source code location [");
				errorM.append(specifiers.sourceCodeLocation());
				errorM.append("] is unknown.");
				jastaddc.SourceError error =
					new jastaddc.SourceError(errorM.toString());
				error.line = specifiers.line();
				error.column = specifiers.column();
				error.sourceName = specifiers.sourceName();
				error.errorLevel =
					jastaddc.SourceError.ErrorLevel.ERROR;
				error.errorType =
					jastaddc.SourceError.ErrorType.SYNTACTICAL;
				errorType.addError(error);
				
				return errorType;
			}
			if (types.size() < 1) {
				StringBuilder errorM = new StringBuilder();
				errorM.append("Type: No type specified in the [");
				errorM.append(specifiers.getClass().getName());
				errorM.append("] at the source code location [");
				errorM.append(specifiers.sourceCodeLocation());
				errorM.append("].");
				jastaddc.SourceError error =
					new jastaddc.SourceError(errorM.toString());
				error.line = specifiers.line();
				error.column = specifiers.column();
				error.sourceName = specifiers.sourceName();
				error.errorLevel =
					jastaddc.SourceError.ErrorLevel.ERROR;
				error.errorType =
					jastaddc.SourceError.ErrorType.SYNTACTICAL;
				errorType.addError(error);
				
				return errorType;
			}
			return types.get(0);
		}

    // Declared in DeclarationSpecifiersBuilder.jrag at line 148

		
		protected List<TypeQualifier> buildTypeQualifier() {
			List<TypeQualifier> qualifier = new List<TypeQualifier>();
			for (int i = 0; i < specifiers.getNumChild(); i++) {
				_declaration_specifiers spec = specifiers.getChild(i);
				if (spec instanceof TypeQualifier)
					qualifier.add((TypeQualifier)spec.copy());
			}
			return qualifier;
		}

    // Declared in DeclarationSpecifiersBuilder.jrag at line 158

		
		protected List<StorageClassSpecifier> buildStorageClassSpecifier() {
			List<StorageClassSpecifier> storage = new List<StorageClassSpecifier>();
			for (int i = 0; i < specifiers.getNumChild(); i++) {
				_declaration_specifiers spec = specifiers.getChild(i);
				if (spec instanceof StorageClassSpecifier)
					storage.add((StorageClassSpecifier)spec.copy());
			}
			return storage;
		}

    // Declared in DeclarationSpecifiersBuilder.jrag at line 168

		
		protected List<FunctionSpecifier> buildFunctionSpecifier() {
			List<FunctionSpecifier> funcSpec = new List<FunctionSpecifier>();
			for (int i = 0; i < specifiers.getNumChild(); i++) {
				_declaration_specifiers spec = specifiers.getChild(i);
				if (spec instanceof FunctionSpecifier)
					funcSpec.add((FunctionSpecifier)spec.copy());
			}
			return funcSpec;
		}


}
