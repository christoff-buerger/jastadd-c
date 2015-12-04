
package jastaddc.semantics.ast;

/**
	 * This class allows to filter collections by a given criteria.
	 * The result is a new collection containing only elements which
	 * passed the given criteria.
	 * 
	 * This class is useful in combination with collection attributes.
	 * 
	 * @author C. B\u00c3\u00bcrger
	 */
public class ListFilter extends java.lang.Object {
    // Declared in CompilerAPI.jrag at line 483

		public static <E> java.util.List<E> filter(
				java.util.List<E> toFilter, AFilterCriteria<E> filterToUse) {
			java.util.List<E> result =
				new java.util.ArrayList<E>();
			for (E elem:toFilter) {
				if (filterToUse.passed(elem))
					result.add(elem);
			}
			return result;
		}

    // Declared in CompilerAPI.jrag at line 501

		/**
		 * Instances of this interface represent collection filter
		 * criteria. A collection filter may depend on another collection
		 * filter, thus for an element to pass this filter it has to pass
		 * the filter this one depends on also.
		 * 
		 * @author C. B\u00c3\u00bcrger
		 */
		public static abstract class AFilterCriteria<T> {
			protected AFilterCriteria<T> additionalFilter;
			public AFilterCriteria() {additionalFilter = null;}
			public AFilterCriteria(AFilterCriteria<T> additionalFilter) {
				this.additionalFilter = additionalFilter;
			}
			public boolean isBasedOnOtherFilter() {return additionalFilter != null;}
			public void setAdditionalFilter(AFilterCriteria<T> criteria) {
				additionalFilter = criteria;
			}
			public boolean passed(T elem) {
				return additionalFilter != null ?
						additionalFilter.passed(elem) && _passed(elem) : _passed(elem);
			}
			public abstract boolean _passed(T elem);
		}


}
