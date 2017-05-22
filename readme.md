**Software:** _JastAdd-C_ (an extensible, specification-driven generated _C99_ compiler front end)

**Public Git Repository:** https://github.com/christoff-buerger/jastadd-c

**Author:** Christoff Bürger (`christoff.buerger@gmail.com`)

# Introduction

The _JastAdd-C_ _C99_-compiler front was developed by Christoff Bürger for his master thesis titled _Specification-Driven Generation of an Extensible C Compiler_. The objective was an extensible _C99_ front end that can be used as foundation for user-specified program analyses and language extensions. To achieve this goal, specification-driven techniques are used; all compiler components are generated using compiler-compiler techniques like regular expression, LALR(1)-grammars, attribute grammars and graph rewriting. User-specified analyses and extensions are "just" further declarative specifications. To that end, general, specification-driven concepts for compiler modularisation, error handling, name analysis, well-formedness analysis, type representation and type transformation were developed, eventually resulting in _JastAdd-C_. The developed concepts are well documented in the thesis (cf. `documentation/jastadd-c-thesis.pdf`), making it a design document, manual and prerequisite for _JastAdd-C_ developers.

# License

This program and the accompanying materials are made available under the terms of the MIT license (X11 license) which accompanies this distribution (`./license.txt`).

# Comments

For any questions or comments don't hesitate to write me an e-mail (`christoff.buerger@gmail.com`). I appreciate any feedback.
