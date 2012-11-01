package org.whole.lang.scheme.visitors;

import org.whole.lang.scheme.visitors.SchemeIdentityUnaryVisitor;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.scheme.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class SchemeTraverseAllVisitor extends
		SchemeIdentityUnaryVisitor<ISchemeVisitor> {
	public SchemeTraverseAllVisitor() {
		wSetVisitor1(this);
	}

	public SchemeTraverseAllVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Definitions entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Definition entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getExpression().accept(wGetVisitor1());
	}

	public void visit(Branches entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Branch entity) {
		entity.getTest().accept(wGetVisitor1());
		entity.getBody().accept(wGetVisitor1());
	}

	public void visit(SchemeExpressions entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ApplyExpression entity) {
		entity.getExpressions().accept(wGetVisitor1());
	}

	public void visit(LambdaExpression entity) {
		entity.getArgs().accept(wGetVisitor1());
		entity.getBody().accept(wGetVisitor1());
	}

	public void visit(AndExpression entity) {
		entity.getExpressions().accept(wGetVisitor1());
	}

	public void visit(OrExpression entity) {
		entity.getExpressions().accept(wGetVisitor1());
	}

	public void visit(CondExpression entity) {
		entity.getBranches().accept(wGetVisitor1());
		entity.getElseBody().accept(wGetVisitor1());
	}

	public void visit(LocalExpression entity) {
		entity.getDefinitions().accept(wGetVisitor1());
		entity.getBody().accept(wGetVisitor1());
	}

	public void visit(ClosureValue entity) {
		entity.getArgs().accept(wGetVisitor1());
		entity.getBody().accept(wGetVisitor1());
		entity.getEnv().accept(wGetVisitor1());
	}

	public void visit(PairValue entity) {
		entity.getCar().accept(wGetVisitor1());
		entity.getCdr().accept(wGetVisitor1());
	}

	public void visit(Names entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}
}
