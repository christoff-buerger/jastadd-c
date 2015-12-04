
package jastaddc.semantics.ast;

/**
	 * Filter a collection of ordinary name space entities discarding
	 * all entities which are function declarations and have an
	 * equal function signature.
	 * 
	 * @author C. B\u00c3\u00bcrger
	 */
public class FunctionDeclarationFilter extends ListFilter.AFilterCriteria<IOrdinaryNameDeclaration> {
    // Declared in CompilerAPI.jrag at line 690

		private FunctionType signatureToFilter;

    // Declared in CompilerAPI.jrag at line 691

		public FunctionDeclarationFilter(ListFilter.AFilterCriteria<IOrdinaryNameDeclaration> filterThisOneDependsOn,
				FunctionType signatureToFilter) {
			super(filterThisOneDependsOn);
			this.signatureToFilter = signatureToFilter;
		}

    // Declared in CompilerAPI.jrag at line 696

		public FunctionDeclarationFilter(FunctionType signatureToFilter) {
			super();
			this.signatureToFilter = signatureToFilter;
		}

    // Declared in CompilerAPI.jrag at line 700

		public boolean _passed(IOrdinaryNameDeclaration elem) {
			return elem instanceof Declaration ?
					(((Declaration)elem).IsFunctionDeclaration() ?
							!((FunctionType)elem.getType().RetrieveFinalNode()).IsIdenticalFunctionType(signatureToFilter) :
							true) :
					true;
		}


}
