This module provides all the error handling functionality needed to associate errors
with an AST node and to construct error nodes. Read the generic error handling module
requirements specified in the 'CompilerAPI.jrag' specification.

To use this error handling module, the user must create an DefaultErrorBuilder AST node,
with one empty optional as parameter (new Opt()) and make it the ErrorBuilder child of
the Compilation node, which is the root node of the JastAddC compiler AST. This error
handling module is initialized automatically.
