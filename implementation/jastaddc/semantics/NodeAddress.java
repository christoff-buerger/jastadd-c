package jastaddc.semantics;

/**
 * NodeAddress's are comparable addresses in Dewey notation for
 * abstract syntax tree nodes.<br>
 * <br>
 * If a node A and a node B are compared (A.compareTo(B)) it is decided,
 * whether A is on the LEFT of B or not. If A is in the subtree of B, we
 * define A to be on the RIGHT of B. If B is in the subtree of A, we define
 * that A is on the LEFT of B. If neither, A is in the subtree of B or B is
 * in the subtree of A, A and B must have one nearest ancestor node ANC. Let
 * ANC_CHILD_A and ANC_CHILD_B be child nodes of ANC. In this case A is on
 * the LEFT of B, if
 *  - the path from A to the AST root contains the node ANC_CHILD_A
 *  - the path from B to the AST root contains the node ANC_CHILD_B
 *  - ANC_CHILD_A is LEFT of ANC_CHILD_B
 *    (thus ANC_CHILD_A.compareTo(ANC_CHILD_B) == 1).
 * If A is not B and A is not on the RIGHT of B, B must be on the RIGHT of A.
 * If A is not B and A is not on the LEFT of B, B must be on the LEFT of A.
 * If A is on the RIGHT of B, B must be on the LEFT of A.
 * 
 * @author C. Bürger
 *
 */
public class NodeAddress implements java.lang.Comparable<NodeAddress>, java.lang.Cloneable {
	private java.util.List<Integer> address;
	
	public NodeAddress() {
		address = new java.util.ArrayList<Integer>();
	}
	
	public NodeAddress(int nodeDeepth) {
		address = new java.util.ArrayList<Integer>(nodeDeepth);
	}
	
	public NodeAddress addAddressPart(int part) {
		address.add(part);
		return this;
	}
	
	/**
	 * Is this node an ancestor of the other node. If this node is an ancestor,
	 * it must be left of the other node.
	 * 
	 * @param otherAddress The other node to compare to.
	 * @return True, if the other node is a successor of this node.
	 */
	public boolean isAncestor(NodeAddress otherAddress) {
		if (address.size() >= otherAddress.address.size())
			return false;
		java.util.Iterator<Integer> iter2 = otherAddress.address.iterator();
		for (Integer part1:address) {
			int part2 = iter2.next();
			if (part1 > part2)
				return false;
		}
		return true;
	}
	
	/**
	 * Is this node a successor of the other node. If this node is a
	 * successor, it must be right of the other node.
	 * 
	 * @param otherAddress The other node to compare to.
	 * @return True, if the other node is an ancestor of this node.
	 */
	public boolean isSuccessor(NodeAddress otherAddress) {
		return otherAddress.isAncestor(this);
	}
	
	public int compareTo(NodeAddress otherAddress) {
		java.util.Iterator<Integer> iter = otherAddress.address.iterator();
		for (Integer part1:address) {
			if (!iter.hasNext())
				return -1;
			int part2 = iter.next();
			if (part1 < part2)
				return 1;
			if (part1 > part2)
				return -1;
		}
		if (iter.hasNext())
			return 1;
		return 0;
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof NodeAddress))
			return false;
		return ((NodeAddress)o).compareTo(this) == 0;
	}
	
	public NodeAddress clone() {
		NodeAddress result = new NodeAddress();
		result.address = new java.util.ArrayList<Integer>(address);
		return result;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder(3*address.size());
		for (Integer part:address) {
			result.append(part);
			result.append('.');
		}
		result.deleteCharAt(result.length() - 1);
		return result.toString();
	}
	
	public int hashCode() {
		return address.size();
	}
}
