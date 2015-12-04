
package jastaddc.semantics.ast;

/**
	 * Filter a collection of tag entities, retrieving only the entities
	 * being not incomplete.
	 * 
	 * @author C. B\u00c3\u00bcrger
	 */
public class CompleteTagedTypeFilter extends ListFilter.AFilterCriteria<TagedType> {
    // Declared in CompilerAPI.jrag at line 576

		public CompleteTagedTypeFilter(ListFilter.AFilterCriteria<TagedType> filterThisOneDependsOn) {
			super(filterThisOneDependsOn);
		}

    // Declared in CompilerAPI.jrag at line 579

		public CompleteTagedTypeFilter() {super();}

    // Declared in CompilerAPI.jrag at line 580

		public boolean _passed(TagedType elem) {
			return !elem.IsIncompleteType();
		}


}
