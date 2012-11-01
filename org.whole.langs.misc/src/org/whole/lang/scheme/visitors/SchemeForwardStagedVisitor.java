package org.whole.lang.scheme.visitors;

import org.whole.lang.scheme.model.*;

/** 
 * @generator Whole
 */
public class SchemeForwardStagedVisitor extends SchemeIdentityVisitor {
	public void visit(Definitions entity) {
		stagedVisit(entity);
	}

	public void visit(Definition entity) {
		stagedVisit(entity);
	}

	public void visit(Branches entity) {
		stagedVisit(entity);
	}

	public void visit(Branch entity) {
		stagedVisit(entity);
	}

	public void visit(SchemeExpressions entity) {
		stagedVisit(entity);
	}

	public void visit(ApplyExpression entity) {
		stagedVisit(entity);
	}

	public void visit(LambdaExpression entity) {
		stagedVisit(entity);
	}

	public void visit(AndExpression entity) {
		stagedVisit(entity);
	}

	public void visit(OrExpression entity) {
		stagedVisit(entity);
	}

	public void visit(CondExpression entity) {
		stagedVisit(entity);
	}

	public void visit(LocalExpression entity) {
		stagedVisit(entity);
	}

	public void visit(IdExpression entity) {
		stagedVisit(entity);
	}

	public void visit(ClosureValue entity) {
		stagedVisit(entity);
	}

	public void visit(BuiltinValue entity) {
		stagedVisit(entity);
	}

	public void visit(BooleanValue entity) {
		stagedVisit(entity);
	}

	public void visit(IntValue entity) {
		stagedVisit(entity);
	}

	public void visit(StringValue entity) {
		stagedVisit(entity);
	}

	public void visit(PairValue entity) {
		stagedVisit(entity);
	}

	public void visit(Names entity) {
		stagedVisit(entity);
	}

	public void visit(Name entity) {
		stagedVisit(entity);
	}

	public void visit(SchemeEnvironment entity) {
		stagedVisit(entity);
	}
}
