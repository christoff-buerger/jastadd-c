/*
	This program and the accompanying materials are made available under the
	terms of the MIT license (X11 license) which accompanies this distribution.
	
	Author: Christoff Bürger
*/

import java.util.Iterator;

import jastaddc.SourceError;
import jastaddc.semantics.*;

public class Test {
	public static void main(String[] args) {
		TranslationUnit tunit = new TranslationUnit();
		Compilation compiler = new Compilation(
				tunit,
				new DefaultErrorBuilder());
		
		// void func1(void) {
		PrimitiveType rt = new PrimitiveType(new List(), jastaddc.semantics.PrimitiveTypes._void);
		List<Declaration> paraList = new List<Declaration>();
		Declaration parameter = new Declaration(
				new List(),
				new List(),
				new PrimitiveType(new List(), jastaddc.semantics.PrimitiveTypes._void),
				new Opt(),
				new Opt());
		paraList.add(parameter);
		NormalFunction ft = new NormalFunction(new List(), rt, paraList);
		CompoundStatement cstmt = new CompoundStatement();
		Declaration fd = new Declaration(
				new List(),
				new List(),
				ft,
				new Opt(new Identifier("func1")),
				new Opt(new FunctionDefinitionInitializer(cstmt)));
		DeclarationCollection dc = new DeclarationCollection();
		dc.addDeclaration(fd);
		tunit.addDeclaration(dc);
		
		//Label1_1:;
		Statement stmt = new EmptyStatement();
		ExplicitLabeledStatement lstmt = new ExplicitLabeledStatement(
				stmt,
				new Identifier("Label1_1"));
		cstmt.addStatement(lstmt);
		
		// }
		
		// void func2(void) {
		rt = new PrimitiveType(new List(), jastaddc.semantics.PrimitiveTypes._void);
		ft = new NormalFunction(new List(), rt, new List());
		cstmt = new CompoundStatement();
		fd = new Declaration(
				new List(),
				new List(),
				ft,
				new Opt(new Identifier("func2")),
				new Opt(new FunctionDefinitionInitializer(cstmt)));
		dc = new DeclarationCollection();
		dc.addDeclaration(fd);
		tunit.addDeclaration(dc);
		
		// Label2_1:;
		lstmt = new ExplicitLabeledStatement(
				new EmptyStatement(),
				new Identifier("Label2_1"));
		cstmt.addStatement(lstmt);
		
		// enum enumTag {e1, e2} enumVar;
		List enumEle = new List();
		EnumerationElement elem = new EnumerationElement(
				new Identifier("e1"),
				new Opt());
		enumEle.add(elem);
		elem = new EnumerationElement(
				new Identifier("e2"),
				new Opt());
		enumEle.add(elem);
		Enumeration et = new Enumeration(
				new List(),
				new Opt(new Identifier("enumTag")),
				enumEle);
		cstmt.addStatement(new Declaration(
				new List(),
				new List(),
				et,
				new Opt(new Identifier("enumVar")),
				new Opt()));
		
		// Label2_2:;
		stmt = new EmptyStatement();
		lstmt = new ExplicitLabeledStatement(
				stmt,
				new Identifier("Label2_2"));
		cstmt.addStatement(lstmt);
		
		// struct structTag {int i1; int i2;} structVar;
		StructuredType strucT = new Structure(
				new List(),
				new Opt(new Identifier("structTag")),
				new List());
		UnionOrStructureElement stElem = new NormalUnionOrStructureElement(
				new PrimitiveType(new List(), jastaddc.semantics.PrimitiveTypes._signed_int),
				new Identifier("i1"));
		strucT.addElement(stElem);
		stElem = new NormalUnionOrStructureElement(
				new PrimitiveType(new List(), jastaddc.semantics.PrimitiveTypes._signed_int),
				new Identifier("i2"));
		strucT.addElement(stElem);
		Declaration d = new Declaration(
				new List(),
				new List(),
				strucT,
				new Opt(new Identifier("structVar")),
				new Opt());
		cstmt.addStatement(d);
		// }
		
		/*
		System.out.println(tunit.getDeclaration(1).LookUpOrdinaryName("func1"));
		System.out.println(cstmt.getStatement(0).LookUpLabel("Label1"));
		System.out.println(cstmt.getStatement(0).LookUpOrdinaryName("e"));
		*/
		
		compiler.IsCorrect();
		Iterator<jastaddc.SourceError> iter = compiler.collectAllErrorsOfTree();
		while (iter.hasNext()) {
			SourceError error = (SourceError)iter.next();
			System.out.println(error.getMessage());
		}
		
		//System.out.println(lstmt.LookUpOrdinaryName("structVar"));
		//System.out.println(d.LookUpOrdinaryName("structVar"));
		System.out.println(d.LookUpOrdinaryName("e1"));
		System.out.println(d.LookUpTag("enumTag"));
		System.out.println(d.LookUpTag("structTag"));
	}
}
