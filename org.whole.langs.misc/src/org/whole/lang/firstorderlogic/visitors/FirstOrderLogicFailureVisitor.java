package org.whole.lang.firstorderlogic.visitors;

import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class FirstOrderLogicFailureVisitor extends
		FirstOrderLogicIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(Theory entity) {
		throw new VisitException();
	}

	public void visit(ImportTheories entity) {
		throw new VisitException();
	}

	public void visit(ImportDeclaration entity) {
		throw new VisitException();
	}

	public void visit(Declarations entity) {
		throw new VisitException();
	}

	public void visit(Assertions entity) {
		throw new VisitException();
	}

	public void visit(EntityName entity) {
		throw new VisitException();
	}

	public void visit(FeatureName entity) {
		throw new VisitException();
	}

	public void visit(LanguageName entity) {
		throw new VisitException();
	}

	public void visit(SimpleFeature entity) {
		throw new VisitException();
	}

	public void visit(QualifiedFeature entity) {
		throw new VisitException();
	}

	public void visit(SubtypeDeclaration entity) {
		throw new VisitException();
	}

	public void visit(NameDeclaration entity) {
		throw new VisitException();
	}

	public void visit(SortType entity) {
		throw new VisitException();
	}

	public void visit(VariableType entity) {
		throw new VisitException();
	}

	public void visit(FunctionType entity) {
		throw new VisitException();
	}

	public void visit(PredicateType entity) {
		throw new VisitException();
	}

	public void visit(Parameters entity) {
		throw new VisitException();
	}

	public void visit(VariableDeclaration entity) {
		throw new VisitException();
	}

	public void visit(PredicateDefinition entity) {
		throw new VisitException();
	}

	public void visit(FunctionDefinition entity) {
		throw new VisitException();
	}

	public void visit(Axiom entity) {
		throw new VisitException();
	}

	public void visit(Theorem entity) {
		throw new VisitException();
	}

	public void visit(Formulae entity) {
		throw new VisitException();
	}

	public void visit(PredicateApplication entity) {
		throw new VisitException();
	}

	public void visit(EqualityPredicateApplication entity) {
		throw new VisitException();
	}

	public void visit(Implication entity) {
		throw new VisitException();
	}

	public void visit(Coimplication entity) {
		throw new VisitException();
	}

	public void visit(Xor entity) {
		throw new VisitException();
	}

	public void visit(And entity) {
		throw new VisitException();
	}

	public void visit(Or entity) {
		throw new VisitException();
	}

	public void visit(Not entity) {
		throw new VisitException();
	}

	public void visit(ForAll entity) {
		throw new VisitException();
	}

	public void visit(Exist entity) {
		throw new VisitException();
	}

	public void visit(ExistUnique entity) {
		throw new VisitException();
	}

	public void visit(Arguments entity) {
		throw new VisitException();
	}

	public void visit(SimplePredicate entity) {
		throw new VisitException();
	}

	public void visit(QualifiedPredicate entity) {
		throw new VisitException();
	}

	public void visit(TheoryName entity) {
		throw new VisitException();
	}

	public void visit(Constant entity) {
		throw new VisitException();
	}

	public void visit(Variable entity) {
		throw new VisitException();
	}

	public void visit(FunctionApplication entity) {
		throw new VisitException();
	}

	public void visit(SimpleFunction entity) {
		throw new VisitException();
	}

	public void visit(QualifiedFunction entity) {
		throw new VisitException();
	}

	public void visit(Name entity) {
		throw new VisitException();
	}
}
