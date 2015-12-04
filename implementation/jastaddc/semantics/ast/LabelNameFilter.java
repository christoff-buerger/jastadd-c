
package jastaddc.semantics.ast;

/**
	 * Filter a collection of label entities discarding all entities
	 * with unequal name.
	 * 
	 * @author C. B\u00c3\u00bcrger
	 */
public class LabelNameFilter extends ListFilter.AFilterCriteria<LabeledStatement> {
    // Declared in CompilerAPI.jrag at line 618

		private String name;

    // Declared in CompilerAPI.jrag at line 619

		public LabelNameFilter(ListFilter.AFilterCriteria<LabeledStatement> filterThisOneDependsOn,
				String name) {
			super(filterThisOneDependsOn);
			this.name = name;
		}

    // Declared in CompilerAPI.jrag at line 624

		public LabelNameFilter(String name) {
			super();
			this.name = name;
		}

    // Declared in CompilerAPI.jrag at line 628

		public boolean _passed(LabeledStatement elem) {
			return elem.Name().equals(name);
		}


}
