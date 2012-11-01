package org.whole.lang.scheme.visitors;

import org.whole.lang.scheme.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class SchemeFailureVisitor extends SchemeIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(Definitions entity) {
		throw new VisitException();
	}

	public void visit(Definition entity) {
		throw new VisitException();
	}

	public void visit(Branches entity) {
		throw new VisitException();
	}

	public void visit(Branch entity) {
		throw new VisitException();
	}

	public void visit(SchemeExpressions entity) {
		throw new VisitException();
	}

	public void visit(ApplyExpression entity) {
		throw new VisitException();
	}

	public void visit(LambdaExpression entity) {
		throw new VisitException();
	}

	public void visit(AndExpression entity) {
		throw new VisitException();
	}

	public void visit(OrExpression entity) {
		throw new VisitException();
	}

	public void visit(CondExpression entity) {
		throw new VisitException();
	}

	public void visit(LocalExpression entity) {
		throw new VisitException();
	}

	public void visit(IdExpression entity) {
		throw new VisitException();
	}

	public void visit(ClosureValue entity) {
		throw new VisitException();
	}

	public void visit(BuiltinValue entity) {
		throw new VisitException();
	}

	public void visit(BooleanValue entity) {
		throw new VisitException();
	}

	public void visit(IntValue entity) {
		throw new VisitException();
	}

	public void visit(StringValue entity) {
		throw new VisitException();
	}

	public void visit(PairValue entity) {
		throw new VisitException();
	}

	public void visit(Names entity) {
		throw new VisitException();
	}

	public void visit(Name entity) {
		throw new VisitException();
	}

	public void visit(SchemeEnvironment entity) {
		throw new VisitException();
	}
}
