package org.whole.lang.firstorderlogic.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class FirstOrderLogicForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IFirstOrderLogicVisitor> implements
		IFirstOrderLogicVisitor {
	public FirstOrderLogicForwardStrategyVisitor() {
		this(new FirstOrderLogicIdentityVisitor());
	}

	public FirstOrderLogicForwardStrategyVisitor(
			IFirstOrderLogicVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IFirstOrderLogicEntity) entity).accept(this);
	}

	public void visit(Theory entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ImportTheories entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ImportDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Declarations entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Assertions entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EntityName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FeatureName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LanguageName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SimpleFeature entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(QualifiedFeature entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SubtypeDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(NameDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SortType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(VariableType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FunctionType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PredicateType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Parameters entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(VariableDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PredicateDefinition entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FunctionDefinition entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Axiom entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Theorem entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Formulae entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PredicateApplication entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EqualityPredicateApplication entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Implication entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Coimplication entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Xor entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(And entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Or entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Not entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ForAll entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Exist entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ExistUnique entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Arguments entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SimplePredicate entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(QualifiedPredicate entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(TheoryName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Constant entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Variable entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FunctionApplication entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SimpleFunction entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(QualifiedFunction entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Name entity) {
		wGetStrategy().visit(entity);
	}
}
