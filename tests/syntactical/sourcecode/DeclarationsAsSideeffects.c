void declarationsAsSideEffects1(void) {
	int i = sizeof(enum type {e});
	i = e;
	//struct type {int inner;}; // This line does not work --> OK.
	//int e; // This line does not work --> OK.
	
	int j = sizeof(struct _type1{int k;});
	struct _type1* pt1;
	struct _type1 s1;
	//struct _type1 {int _k;}; // This line does not work -> OK.
	
	void* cpt;
	(struct _type2{int k;}*)cpt;
	struct _type2* pt2;
	struct _type2 s2;
	//struct _type2 {int k;}; // This line does not work -> OK.
	
	struct struc {struct innerStruct {int i;}* pInnerStruct;};
	struct innerStruct stillAvaible;
	struct struc* pt3;
	struct struc s3;
	struct innerStruct* pt4;
	struct innerStruct s4;
	// struct innerStruct {int i;}; // This line does not wok -> OK.
}
