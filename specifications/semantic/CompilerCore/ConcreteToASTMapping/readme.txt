Specifications in this module realize the mapping from the concrete syntax to
the abstract. The concrete syntax is the grammar given in the C99 standard
(Phrase structure grammar [A.2] S.409). The abstract syntax is the one given in
the 'C99AST.ast' specification. The concrete syntax is parsed by a beaver parser.
This parser constructs as far as possible the AST specified in the 'C99AST.ast'
specification (using semantic actions executed while reducing with a concrete
syntax rule). But a few AST nodes (especial declarations) can not be constructed
by semantic actions. In this cases intermediate nodes (together with their subtree)
are constructed. This parts are specified in the 'ConcreteToAST.ast'
specification, which enriches the clean final AST of the 'C99AST.ast' with tree
parts constructed by the parser, which have later to be rewritten. Thus the mapping
from the concrete syntax to the abstract syntax is done by rewrites. The
specifications in this module implement these rewrites.

For the requirements of this module check the sub aspect 'ConcreteToASTMapping' in
the 'CompilerAPI.jrag' specification.
