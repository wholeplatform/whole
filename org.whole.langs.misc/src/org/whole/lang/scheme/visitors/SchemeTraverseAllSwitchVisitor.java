package org.whole.lang.scheme.visitors;

import org.whole.lang.scheme.visitors.SchemeIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.scheme.model.*;

/** 
 * @generator Whole
 */
public class SchemeTraverseAllSwitchVisitor extends
		SchemeIdentityUnaryVisitor<IVisitor> {
	public SchemeTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Definitions entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Definition entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getExpression());
	}

	public void visit(Branches entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Branch entity) {
		wGetVisitor1().visit(entity.getTest());
		wGetVisitor1().visit(entity.getBody());
	}

	public void visit(SchemeExpressions entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(ApplyExpression entity) {
		wGetVisitor1().visit(entity.getExpressions());
	}

	public void visit(LambdaExpression entity) {
		wGetVisitor1().visit(entity.getArgs());
		wGetVisitor1().visit(entity.getBody());
	}

	public void visit(AndExpression entity) {
		wGetVisitor1().visit(entity.getExpressions());
	}

	public void visit(OrExpression entity) {
		wGetVisitor1().visit(entity.getExpressions());
	}

	public void visit(CondExpression entity) {
		wGetVisitor1().visit(entity.getBranches());
		wGetVisitor1().visit(entity.getElseBody());
	}

	public void visit(LocalExpression entity) {
		wGetVisitor1().visit(entity.getDefinitions());
		wGetVisitor1().visit(entity.getBody());
	}

	public void visit(ClosureValue entity) {
		wGetVisitor1().visit(entity.getArgs());
		wGetVisitor1().visit(entity.getBody());
		wGetVisitor1().visit(entity.getEnv());
	}

	public void visit(PairValue entity) {
		wGetVisitor1().visit(entity.getCar());
		wGetVisitor1().visit(entity.getCdr());
	}

	public void visit(Names entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}
}
