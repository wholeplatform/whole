package org.whole.lang.scheme.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.scheme.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class SchemeForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<ISchemeVisitor> implements ISchemeVisitor {
	public SchemeForwardStrategyVisitor() {
		this(new SchemeIdentityVisitor());
	}

	public SchemeForwardStrategyVisitor(ISchemeVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((ISchemeEntity) entity).accept(this);
	}

	public void visit(Definitions entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Definition entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Branches entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Branch entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SchemeExpressions entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ApplyExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LambdaExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AndExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(OrExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CondExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LocalExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IdExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ClosureValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BuiltinValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BooleanValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IntValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(StringValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PairValue entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Names entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Name entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SchemeEnvironment entity) {
		wGetStrategy().visit(entity);
	}
}
