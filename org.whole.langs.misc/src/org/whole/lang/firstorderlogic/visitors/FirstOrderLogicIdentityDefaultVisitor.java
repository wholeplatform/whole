package org.whole.lang.firstorderlogic.visitors;

import org.whole.lang.firstorderlogic.model.*;

/** 
 * @generator Whole
 */
public class FirstOrderLogicIdentityDefaultVisitor extends
		FirstOrderLogicIdentityVisitor {
	public void visit(IFirstOrderLogicEntity entity) {
	}

	public void visit(Theory entity) {
		visit((IFirstOrderLogicEntity) entity);
	}

	public void visit(ImportTheories entity) {
		visit((IFirstOrderLogicEntity) entity);
	}

	public void visit(ImportDeclaration entity) {
		visit((IFirstOrderLogicEntity) entity);
	}

	public void visit(Declarations entity) {
		visit((IFirstOrderLogicEntity) entity);
	}

	public void visit(Assertions entity) {
		visit((IFirstOrderLogicEntity) entity);
	}

	public void visit(Path entity) {
	}

	public void visit(EntityName entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Path) entity);
	}

	public void visit(FeatureName entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Path) entity);
	}

	public void visit(LanguageName entity) {
		visit((IFirstOrderLogicEntity) entity);
	}

	public void visit(FeaturePath entity) {
	}

	public void visit(SimpleFeature entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((FeaturePath) entity);
	}

	public void visit(QualifiedFeature entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((FeaturePath) entity);
	}

	public void visit(Declaration entity) {
	}

	public void visit(SubtypeDeclaration entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Declaration) entity);
	}

	public void visit(NameDeclaration entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Declaration) entity);
	}

	public void visit(Type entity) {
	}

	public void visit(SortType entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Type) entity);
	}

	public void visit(VariableType entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Type) entity);
	}

	public void visit(FunctionType entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Type) entity);
	}

	public void visit(PredicateType entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Type) entity);
	}

	public void visit(Parameters entity) {
		visit((IFirstOrderLogicEntity) entity);
	}

	public void visit(VariableDeclaration entity) {
		visit((IFirstOrderLogicEntity) entity);
	}

	public void visit(Assertion entity) {
	}

	public void visit(PredicateDefinition entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Assertion) entity);
	}

	public void visit(FunctionDefinition entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Assertion) entity);
	}

	public void visit(Axiom entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Assertion) entity);
	}

	public void visit(Theorem entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Assertion) entity);
	}

	public void visit(Formulae entity) {
		visit((IFirstOrderLogicEntity) entity);
	}

	public void visit(Formula entity) {
	}

	public void visit(PredicateApplication entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Formula) entity);
	}

	public void visit(EqualityPredicateApplication entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Formula) entity);
	}

	public void visit(Implication entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Formula) entity);
	}

	public void visit(Coimplication entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Formula) entity);
	}

	public void visit(Xor entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Formula) entity);
	}

	public void visit(And entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Formula) entity);
	}

	public void visit(Or entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Formula) entity);
	}

	public void visit(Not entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Formula) entity);
	}

	public void visit(ForAll entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Formula) entity);
	}

	public void visit(Exist entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Formula) entity);
	}

	public void visit(ExistUnique entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Formula) entity);
	}

	public void visit(Arguments entity) {
		visit((IFirstOrderLogicEntity) entity);
	}

	public void visit(Predicate entity) {
	}

	public void visit(SimplePredicate entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Predicate) entity);
	}

	public void visit(QualifiedPredicate entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Predicate) entity);
	}

	public void visit(TheoryName entity) {
		visit((IFirstOrderLogicEntity) entity);
	}

	public void visit(Term entity) {
	}

	public void visit(Constant entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Term) entity);
	}

	public void visit(Variable entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Term) entity);
	}

	public void visit(FunctionApplication entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Term) entity);
	}

	public void visit(Function entity) {
	}

	public void visit(SimpleFunction entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Function) entity);
	}

	public void visit(QualifiedFunction entity) {
		visit((IFirstOrderLogicEntity) entity);
		visit((Function) entity);
	}

	public void visit(Name entity) {
		visit((IFirstOrderLogicEntity) entity);
	}
}
