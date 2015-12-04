
package jastaddc.semantics.ast;

/**
	 * Filter a collection of tag entities, retrieving only the entities
	 * being of some special type (qualified class name) or not being of the
	 * given type (depending on the boolean value of the constructors equal parameter).
	 * 
	 * @author C. B\u00c3\u00bcrger
	 */
public class TagedTypeTypeFilter extends ListFilter.AFilterCriteria<TagedType> {
    // Declared in CompilerAPI.jrag at line 593

		private String classNameOfTypeToFilter;

    // Declared in CompilerAPI.jrag at line 594

		private boolean equal;

    // Declared in CompilerAPI.jrag at line 595

		public TagedTypeTypeFilter(ListFilter.AFilterCriteria<TagedType> filterThisOneDependsOn,
				String classNameOfTypeToFilter, boolean equal) {
			super(filterThisOneDependsOn);
			this.classNameOfTypeToFilter = classNameOfTypeToFilter;
			this.equal = equal;
		}

    // Declared in CompilerAPI.jrag at line 601

		public TagedTypeTypeFilter(String classNameOfTypeToFilter, boolean equal) {
			super();
			this.classNameOfTypeToFilter = classNameOfTypeToFilter;
			this.equal = equal;
		}

    // Declared in CompilerAPI.jrag at line 606

		public boolean _passed(TagedType elem) {
			return elem.getClass().getName().equals(classNameOfTypeToFilter) == equal;
		}


}
