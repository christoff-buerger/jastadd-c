
package jastaddc.semantics.ast;

/**
	 * Support class for set operations.
	 * 
	 * @author C. B\u00c3\u00bcrger
	 */
public class SetOp extends java.lang.Object {
    // Declared in Support.jrag at line 14

		public static <T> java.util.Set<T> union(java.util.Set<T> set1, java.util.Set<T> set2){
			java.util.HashSet<T> union = new java.util.HashSet<T>(set1);
			union.addAll(set2);
			return union;
		}

    // Declared in Support.jrag at line 19

		public static <T> java.util.Set<T> union(java.util.Set<T> set1, T elem){
			java.util.HashSet<T> union = new java.util.HashSet<T>(set1);
			if (elem != null)
				union.add(elem);
			return union;
		}

    // Declared in Support.jrag at line 25

		public static <T> java.util.Set<T> union(T elem, java.util.Set<T> set1){
			java.util.HashSet<T> union = new java.util.HashSet<T>(set1);
			if (elem != null)
				union.add(elem);
			return union;
		}

    // Declared in Support.jrag at line 31

		public static <T> java.util.Set<T> union(T elem1, T elem2){
			java.util.HashSet<T> union = new java.util.HashSet<T>();
			if (elem1 != null)
				union.add(elem1);
			if (elem2 != null)
				union.add(elem2);
			return union;
		}


}
