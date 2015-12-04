
package jastaddc.semantics.ast;

/**
	 * Filter a collection of tag entities discarding all entities
	 * with unequal name.
	 * 
	 * @author C. B\u00c3\u00bcrger
	 */
public class TagNameFilter extends ListFilter.AFilterCriteria<TagedType> {
    // Declared in CompilerAPI.jrag at line 554

		private String name;

    // Declared in CompilerAPI.jrag at line 555

		public TagNameFilter(ListFilter.AFilterCriteria<TagedType> filterThisOneDependsOn,
				String name) {
			super(filterThisOneDependsOn);
			this.name = name;
		}

    // Declared in CompilerAPI.jrag at line 560

		public TagNameFilter(String name) {
			super();
			this.name = name;
		}

    // Declared in CompilerAPI.jrag at line 564

		public boolean _passed(TagedType elem) {
			return elem.Name().equals(name);
		}


}
