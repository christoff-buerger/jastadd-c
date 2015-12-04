
package jastaddc.semantics.ast;

/**
	 * Filter a collection of ordinary name space entities discarding
	 * all entities with unequal name.
	 * 
	 * @author C. B\u00c3\u00bcrger
	 */
public class OrdinaryNameFilter extends ListFilter.AFilterCriteria<IOrdinaryNameDeclaration> {
    // Declared in CompilerAPI.jrag at line 640

		private String name;

    // Declared in CompilerAPI.jrag at line 641

		public OrdinaryNameFilter(ListFilter.AFilterCriteria<IOrdinaryNameDeclaration> filterThisOneDependsOn,
				String name) {
			super(filterThisOneDependsOn);
			this.name = name;
		}

    // Declared in CompilerAPI.jrag at line 646

		public OrdinaryNameFilter(String name) {
			super();
			this.name = name;
		}

    // Declared in CompilerAPI.jrag at line 650

		public boolean _passed(IOrdinaryNameDeclaration elem) {
			return elem.Name().equals(name);
		}


}
