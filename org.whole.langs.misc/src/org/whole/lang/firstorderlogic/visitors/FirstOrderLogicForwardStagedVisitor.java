package org.whole.lang.firstorderlogic.visitors;

import org.whole.lang.firstorderlogic.model.*;

/** 
 * @generator Whole
 */
public class FirstOrderLogicForwardStagedVisitor extends
		FirstOrderLogicIdentityVisitor {
	public void visit(Theory entity) {
		stagedVisit(entity);
	}

	public void visit(ImportTheories entity) {
		stagedVisit(entity);
	}

	public void visit(ImportDeclaration entity) {
		stagedVisit(entity);
	}

	public void visit(Declarations entity) {
		stagedVisit(entity);
	}

	public void visit(Assertions entity) {
		stagedVisit(entity);
	}

	public void visit(EntityName entity) {
		stagedVisit(entity);
	}

	public void visit(FeatureName entity) {
		stagedVisit(entity);
	}

	public void visit(LanguageName entity) {
		stagedVisit(entity);
	}

	public void visit(SimpleFeature entity) {
		stagedVisit(entity);
	}

	public void visit(QualifiedFeature entity) {
		stagedVisit(entity);
	}

	public void visit(SubtypeDeclaration entity) {
		stagedVisit(entity);
	}

	public void visit(NameDeclaration entity) {
		stagedVisit(entity);
	}

	public void visit(SortType entity) {
		stagedVisit(entity);
	}

	public void visit(VariableType entity) {
		stagedVisit(entity);
	}

	public void visit(FunctionType entity) {
		stagedVisit(entity);
	}

	public void visit(PredicateType entity) {
		stagedVisit(entity);
	}

	public void visit(Parameters entity) {
		stagedVisit(entity);
	}

	public void visit(VariableDeclaration entity) {
		stagedVisit(entity);
	}

	public void visit(PredicateDefinition entity) {
		stagedVisit(entity);
	}

	public void visit(FunctionDefinition entity) {
		stagedVisit(entity);
	}

	public void visit(Axiom entity) {
		stagedVisit(entity);
	}

	public void visit(Theorem entity) {
		stagedVisit(entity);
	}

	public void visit(Formulae entity) {
		stagedVisit(entity);
	}

	public void visit(PredicateApplication entity) {
		stagedVisit(entity);
	}

	public void visit(EqualityPredicateApplication entity) {
		stagedVisit(entity);
	}

	public void visit(Implication entity) {
		stagedVisit(entity);
	}

	public void visit(Coimplication entity) {
		stagedVisit(entity);
	}

	public void visit(Xor entity) {
		stagedVisit(entity);
	}

	public void visit(And entity) {
		stagedVisit(entity);
	}

	public void visit(Or entity) {
		stagedVisit(entity);
	}

	public void visit(Not entity) {
		stagedVisit(entity);
	}

	public void visit(ForAll entity) {
		stagedVisit(entity);
	}

	public void visit(Exist entity) {
		stagedVisit(entity);
	}

	public void visit(ExistUnique entity) {
		stagedVisit(entity);
	}

	public void visit(Arguments entity) {
		stagedVisit(entity);
	}

	public void visit(SimplePredicate entity) {
		stagedVisit(entity);
	}

	public void visit(QualifiedPredicate entity) {
		stagedVisit(entity);
	}

	public void visit(TheoryName entity) {
		stagedVisit(entity);
	}

	public void visit(Constant entity) {
		stagedVisit(entity);
	}

	public void visit(Variable entity) {
		stagedVisit(entity);
	}

	public void visit(FunctionApplication entity) {
		stagedVisit(entity);
	}

	public void visit(SimpleFunction entity) {
		stagedVisit(entity);
	}

	public void visit(QualifiedFunction entity) {
		stagedVisit(entity);
	}

	public void visit(Name entity) {
		stagedVisit(entity);
	}
}
