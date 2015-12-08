This module integrates flow analysis into the JastAddC compiler.

Control flow analysis provide attributes specifying for each statement,
which statements might be executed after this statement. One of the statements
contained in a statements successor set will be executed next. For each function
definition an entry and exit statement will be added, representing the function's
control flow graph root and terminal node. Thus a control flow graph is imposed
on top of the AST for each function definition.
