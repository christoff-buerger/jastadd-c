/*
	This program and the accompanying materials are made available under the
	terms of the MIT license (X11 license) which accompanies this distribution.
	
	Author: Christoff Bürger
*/

package jastaddc.semantics;

/**
 * This enumeration represents all the basic types of the JastAddC compiler.
 */
public enum PrimitiveTypes {
	_error_type {public String typeName() {return "error_type";}},
	_void {public String typeName() {return "void";}},
	_char {public String typeName() {return "char";}},
	__Bool {public String typeName() {return "_Bool";}},
	_signed_char {public String typeName() {return "signed char";}},
	_signed_short_int {public String typeName() {return "signed short int";}},
	_signed_int {public String typeName() {return "signed int";}},
	_signed_long_int {public String typeName() {return "signed long int";}},
	_signed_long_long_int {public String typeName() {return "signed long long int";}},
	_unsigned_char {public String typeName() {return "unsigned char";}},
	_unsigned_short_int {public String typeName() {return "unsigned short int";}},
	_unsigned_int {public String typeName() {return "unsigned int";}},
	_unsigned_long_int {public String typeName() {return "unsigned long int";}},
	_unsigned_long_long_int {public String typeName() {return "unsigned long long int";}},
	_float {public String typeName() {return "float";}},
	_double {public String typeName() {return "double";}},
	_long_double {public String typeName() {return "long double";}},
	_float__Complex {public String typeName() {return "float _Complex";}},
	_double__Complex {public String typeName() {return "double _Complex";}},
	_long_double__Complex {public String typeName() {return "long double _Complex";}};
	abstract public String typeName();
}
