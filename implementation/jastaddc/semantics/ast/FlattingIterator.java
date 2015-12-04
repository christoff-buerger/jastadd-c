
package jastaddc.semantics.ast;

/**
	 * Class used to flatten a collection and iterate above all the non
	 * collection elements contained in it. To flatten a collection means, to
	 * treat the set of elements in the collection as the set containing all
	 * the non collection elements in this collection unified with all the
	 * non collection elements contained in this collection's collection
	 * elements. This pattern is recursively applied. Here all the collections
	 * forming the final flat set are represented by an iterator. The
	 * {@link FlattingIterator} than iterates above all the added iterator's
	 * elements. By adding {@link FlattingIterator}s the nesting of collections
	 * can be handeled.
	 * 
	 * @author C. B\u00c3\u00bcrger
	 */
public class FlattingIterator<E> extends java.lang.Object implements java.util.Iterator<E> {
    // Declared in ErrorHandling.jrag at line 105

		private int listPosition;

    // Declared in ErrorHandling.jrag at line 106

		private java.util.List<java.util.Iterator<E>> iteratorsToProceed;

    // Declared in ErrorHandling.jrag at line 108

		
		public FlattingIterator(java.util.Iterator<E> thisErrors, int initSize) {
			iteratorsToProceed =
				new java.util.ArrayList<java.util.Iterator<E>>(initSize);
			iteratorsToProceed.add(thisErrors);
			listPosition = 0;
		}

    // Declared in ErrorHandling.jrag at line 115

		
		public void addIterator(java.util.Iterator<E> iter) {
			iteratorsToProceed.add(iter);
		}

    // Declared in ErrorHandling.jrag at line 119

		
		public boolean hasNext() {
			if (listPosition >= iteratorsToProceed.size())
				return false;
			while (!iteratorsToProceed.get(listPosition).hasNext()) {
				listPosition++;
				if (listPosition >= iteratorsToProceed.size())
					return false;
			}
			return true;
		}

    // Declared in ErrorHandling.jrag at line 130

		
		public E next() {
			E result = iteratorsToProceed.get(listPosition).next();
			if (!iteratorsToProceed.get(listPosition).hasNext())
				listPosition++;
			return result;
		}

    // Declared in ErrorHandling.jrag at line 137

		
		public void remove() {
			iteratorsToProceed.get(listPosition).remove();
		}


}
