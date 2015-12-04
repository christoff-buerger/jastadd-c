
package jastaddc.semantics.ast;

/**
	 * Filter a collection of AST nodes by their class type retrieving
	 * only nodes of a given type.
	 * 
	 * @author C. B\u00c3\u00bcrger
	 */
public class ASTNodeTypeFilter extends ListFilter.AFilterCriteria<ASTNode> {
    // Declared in ErrorHandling.jrag at line 41

		private Class typeToFilter;

    // Declared in ErrorHandling.jrag at line 42

		public ASTNodeTypeFilter(ListFilter.AFilterCriteria<ASTNode> filterThisOneDependsOn,
				Class typeToFilter) {
			super(filterThisOneDependsOn);
			this.typeToFilter = typeToFilter;
		}

    // Declared in ErrorHandling.jrag at line 47

		public ASTNodeTypeFilter(Class typeToFilter) {
			super();
			this.typeToFilter = typeToFilter;
		}

    // Declared in ErrorHandling.jrag at line 51

		public boolean _passed(ASTNode elem) {
			return typeToFilter.isInstance(elem);
		}


}
