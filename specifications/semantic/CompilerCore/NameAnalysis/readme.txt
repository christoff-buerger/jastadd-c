The name analysis handles
 - scoping rules (visibility of declarations)
 - extent (lifetime of variables and functions)
 - overloading classes (name space sets)

For details about it's requirements check the sub aspect 'NameAnalysis'
in the 'CompilerAPI.jrag' specification.

There exists a general name analysis concept for this module, which is described in the
following JavaDoc-Comment:

	/**
	 * In the following we like to introduce a general strategy to search for
	 * a name in a given name space. We like to perform such searches on any
	 * AST node by an attribute called LookUp*(String nameToLookUp), where *
	 * is a place holder for the name space the name is part of. We define blocks
	 * in a more general way than the C99 standard, where blocks are defined with
	 * the ordinary name space in mind. Here we consider blocks for any name space,
	 * but when we search for the name in a given name space only the blocks of this
	 * space have to be considered during a search. Thus, if we search for an
	 * ordinary name our blocks will be exactly the blocks of the C99 standard. We
	 * define that our blocks must be nested, thus if we can not find our name to
	 * look up in a block, we keep on searching in the parent block.
	 * 
	 * Main idea: Always prolong the searching for names until a new block
	 * 		is defined, than search the complete block for the name. To search the
	 * 		complete block, do recursive searches in each child node reachable from
	 *      this node, which is in the same block on the same block level. If the
	 *      name to search for is declared several times an error is given. If it
	 *      is declared exactly one time this declaration is the result. If it isn't
	 *      declared in the block, search in the block of the parent node.
	 * 
	 * We can implement the block search using JastAdd's collection attributes, thus
	 * instead of recursively searching all nodes of one block (which are on the same
	 * block level) by manual traversing them we can just have a collection attribute
	 * containing all entities declared in the block the node, the collection attribute
	 * is associated with, introduces. So each node introducing a new block supports
	 * a collection attribute containing all the entities declared in this block
	 * and the nodes block level. Now, instead of doing a local search in a block to
	 * gather declarations, we simple have to write down contribution equations for
	 * nodes contributing some entity to a name space.
	 * 
	 * The final search for some entity in a name space must coordinate the search
	 * across blocks. If the search method is called on an arbitrary node, the node
	 * introducing the block this node is contained in will be accessed and it's
	 * collection attribute is searched for the entity. If a fitting entity is found
	 * it is returned. If not, the final search method is called recursively for
	 * the ancestor node of the node introducing the block. If no such ancestor node
	 * exists the entity can not be found.
	 * 
	 * To decide whether an entity in a collection fits or not filters are used.
	 * Filters can be combined to express, that some filter has to be executed before
	 * another filter. Only if all filters pass, thus accept an entity of the collection,
	 * the entity will be part of the result, otherwise it will be discarded for
	 * the result.
	 * 
	 * Sometimes it is necessary to respect a rule know as "Declare before use", which
	 * is more restrictive than "a used entity must be declare in the same block or
	 * the block this one is nested in". The "declare before use" rule requires
	 * additionally to the block restrictions, that only the AST parts being lexical
	 * before the AST part where the entity is used have to be checked for a declaration.
	 * We say, that this parts are on the left of the AST part where the entity is used.
	 * If we search for an entity at some node, we will prolong the search until
	 * we reach some ancestor node introducing a new block, from which we than start
	 * the search for the complete block, represented by the collection attribute
	 * associated with the node and containing all entities declared in the block.
	 * But now we have to know up to which child nodes
	 * to do the block search and for each child node for which of it's child nodes to
	 * do the block search recursively. To support the necessary information we introduce
	 * unique node addresses, which can be compared to decide
	 *  - if a node is left or right from another node
	 *  - if a node is an ancestor or successor of another node
	 * The address mechanism used is the Dewey notation. Each node has an attribute
	 * NodeAddress(), retrieving an NodeAdress object representing the nodes address in
	 * Dewey notation. When some name is looked up, the address of the node where the
	 * search is started is used as filter criterion to filter certain entities from
	 * the collection attribute containing all entities declared in the block.
	 * 
	 * The main attributes/methods/classes used are:
	 *  - IntroducesNew*Block() : decision, whether a node introduces a new block for
	 *    the name space * or not.
	 *  - FindNodeIntroducingThis*Block() : Returns the node introducing the block
	 *    this node is part of. The result may be this node itself.
	 *  - Local*Declarations() : Collection attribute containing all entities of the
	 *    name space * declared in the block this node introduces. The collection only
	 *    contains the entities on the same block level, thus no entities declared
	 *    in blocks nested in this block are contained. The collection attribute will
	 *    always be empty for nodes not introducing a block in the name space *.
	 *  - LookUpOrdinaryName(String name, jastaddc.semantics.NodeAddress upToAddress) :
	 *    Returns a collection of all entities named 'name', which are declared before
	 *    the node, at the node or in the nodes subtree (the node has the unique address
	 *    'upToAddress').
	 *  - ListFilter : Class to execute filters on collections.
	 *  - ListFilter.AFilterCriterion : Class forming the base class for all filters.
	 */
