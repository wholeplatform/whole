package org.whole.lang.scheme.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.scheme.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class SchemeIdentityUnaryVisitor<V extends IVisitor> extends
		AbstractUnaryVisitor<V> implements ISchemeVisitor {
	public SchemeIdentityUnaryVisitor() {
		super(null);
	}

	public SchemeIdentityUnaryVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		((ISchemeEntity) entity).accept(this);
	}

	public void visit(Definitions entity) {
	}

	public void visit(Definition entity) {
	}

	public void visit(Branches entity) {
	}

	public void visit(Branch entity) {
	}

	public void visit(SchemeExpressions entity) {
	}

	public void visit(ApplyExpression entity) {
	}

	public void visit(LambdaExpression entity) {
	}

	public void visit(AndExpression entity) {
	}

	public void visit(OrExpression entity) {
	}

	public void visit(CondExpression entity) {
	}

	public void visit(LocalExpression entity) {
	}

	public void visit(IdExpression entity) {
	}

	public void visit(ClosureValue entity) {
	}

	public void visit(BuiltinValue entity) {
	}

	public void visit(BooleanValue entity) {
	}

	public void visit(IntValue entity) {
	}

	public void visit(StringValue entity) {
	}

	public void visit(PairValue entity) {
	}

	public void visit(Names entity) {
	}

	public void visit(Name entity) {
	}

	public void visit(SchemeEnvironment entity) {
	}
}
