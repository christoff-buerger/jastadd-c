/*
 * Check, that function prototypes will not result in
 * redeclaration errors.
 */

extern void func(void);

int main(void) {
	extern void func(void);
	func();
	return 1;
}

void func(void) {}
