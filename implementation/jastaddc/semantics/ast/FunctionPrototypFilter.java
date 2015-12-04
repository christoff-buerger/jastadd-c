
package jastaddc.semantics.ast;

/**
	 * Filter a collection of ordinary name space entities discarding
	 * all entities which are function prototyps and have an
	 * equal function signature.
	 * 
	 * @author C. B\u00c3\u00bcrger
	 */
public class FunctionPrototypFilter extends ListFilter.AFilterCriteria<IOrdinaryNameDeclaration> {
    // Declared in CompilerAPI.jrag at line 663

		private FunctionType signatureToFilter;

    // Declared in CompilerAPI.jrag at line 664

		public FunctionPrototypFilter(ListFilter.AFilterCriteria<IOrdinaryNameDeclaration> filterThisOneDependsOn,
				FunctionType signatureToFilter) {
			super(filterThisOneDependsOn);
			this.signatureToFilter = signatureToFilter;
		}

    // Declared in CompilerAPI.jrag at line 669

		public FunctionPrototypFilter(FunctionType signatureToFilter) {
			super();
			this.signatureToFilter = signatureToFilter;
		}

    // Declared in CompilerAPI.jrag at line 673

		public boolean _passed(IOrdinaryNameDeclaration elem) {
			return elem instanceof Declaration ?
					(((Declaration)elem).IsFunctionPrototyp() ?
							!((FunctionType)elem.getType().RetrieveFinalNode()).IsIdenticalFunctionType(signatureToFilter) :
							true) :
					true;
		}


}
