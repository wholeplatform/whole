package org.whole.lang.scheme.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.scheme.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class SchemeForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor>
		implements ISchemeVisitor {
	public SchemeForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Definitions entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Definition entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Branches entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Branch entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SchemeExpressions entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ApplyExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LambdaExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(AndExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(OrExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CondExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LocalExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(IdExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ClosureValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BuiltinValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BooleanValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(IntValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(StringValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PairValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Names entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Name entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SchemeEnvironment entity) {
		wGetVisitor1().visit(entity);
	}
}
