
int main(void) {
	int i = 3, ii = 4, iii = 5;
	struct _struct {int i; double d; struct _struct* s;} myS = {.d = 3.0 + i, 0};
	struct _struct myS2 = {i + ii + iii, .s = &myS};
	
	return 1;
}
