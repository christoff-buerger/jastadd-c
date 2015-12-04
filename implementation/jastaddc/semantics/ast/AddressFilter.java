
package jastaddc.semantics.ast;

/**
	 * Support filters for lists of looked up entities:
	 */
	
	/**
	 * Filter a collection of AST nodes by their location retrieving
	 * only the nodes located before the given address.
	 * 
	 * @author C. B\u00c3\u00bcrger
	 */
public class AddressFilter<T extends ASTNode> extends ListFilter.AFilterCriteria<ASTNode<T>> {
    // Declared in CompilerAPI.jrag at line 530

		private jastaddc.semantics.NodeAddress upToAddress;

    // Declared in CompilerAPI.jrag at line 531

		public AddressFilter(ListFilter.AFilterCriteria<ASTNode<T>> filterThisOneDependsOn,
				jastaddc.semantics.NodeAddress upToAddress) {
			super(filterThisOneDependsOn);
			this.upToAddress = upToAddress;
		}

    // Declared in CompilerAPI.jrag at line 536

		public AddressFilter(jastaddc.semantics.NodeAddress upToAddress) {
			super();
			this.upToAddress = upToAddress;
		}

    // Declared in CompilerAPI.jrag at line 540

		public boolean _passed(ASTNode elem) {
			return elem.NodeAddress().compareTo(upToAddress) > 0 ||
				elem.NodeAddress().isSuccessor(upToAddress) ||
				elem.NodeAddress().equals(upToAddress) ;
		}


}
