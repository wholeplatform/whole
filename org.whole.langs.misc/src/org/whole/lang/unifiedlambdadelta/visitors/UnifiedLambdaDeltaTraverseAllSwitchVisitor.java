package org.whole.lang.unifiedlambdadelta.visitors;

import org.whole.lang.unifiedlambdadelta.visitors.UnifiedLambdaDeltaIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.unifiedlambdadelta.model.*;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaTraverseAllSwitchVisitor extends
		UnifiedLambdaDeltaIdentityUnaryVisitor<IVisitor> {
	public UnifiedLambdaDeltaTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Binder entity) {
		wGetVisitor1().visit(entity.getName());
	}

	public void visit(BinaryItem entity) {
		wGetVisitor1().visit(entity.getPolarity());
		wGetVisitor1().visit(entity.getFront());
	}

	public void visit(BinaryContextBinder entity) {
		wGetVisitor1().visit(entity.getPolarity());
		wGetVisitor1().visit(entity.getFront());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getBack());
	}

	public void visit(Declaration entity) {
		wGetVisitor1().visit(entity.getPolarity());
		wGetVisitor1().visit(entity.getFront());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getBack());
	}

	public void visit(Definition entity) {
		wGetVisitor1().visit(entity.getPolarity());
		wGetVisitor1().visit(entity.getFront());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getBack());
	}

	public void visit(BinaryTerm entity) {
		wGetVisitor1().visit(entity.getPolarity());
		wGetVisitor1().visit(entity.getFront());
		wGetVisitor1().visit(entity.getBack());
	}

	public void visit(Application entity) {
		wGetVisitor1().visit(entity.getPolarity());
		wGetVisitor1().visit(entity.getFront());
		wGetVisitor1().visit(entity.getBack());
	}

	public void visit(Cast entity) {
		wGetVisitor1().visit(entity.getPolarity());
		wGetVisitor1().visit(entity.getFront());
		wGetVisitor1().visit(entity.getBack());
	}

	public void visit(BinaryTermBinder entity) {
		wGetVisitor1().visit(entity.getPolarity());
		wGetVisitor1().visit(entity.getFront());
		wGetVisitor1().visit(entity.getBack());
		wGetVisitor1().visit(entity.getName());
	}

	public void visit(Abstraction entity) {
		wGetVisitor1().visit(entity.getPolarity());
		wGetVisitor1().visit(entity.getFront());
		wGetVisitor1().visit(entity.getBack());
		wGetVisitor1().visit(entity.getName());
	}

	public void visit(Abbreviation entity) {
		wGetVisitor1().visit(entity.getPolarity());
		wGetVisitor1().visit(entity.getFront());
		wGetVisitor1().visit(entity.getBack());
		wGetVisitor1().visit(entity.getName());
	}

	public void visit(Local entity) {
		wGetVisitor1().visit(entity.getIndex());
	}

	public void visit(Sort entity) {
		wGetVisitor1().visit(entity.getLevel());
	}

	public void visit(Name entity) {
		wGetVisitor1().visit(entity.getAccess());
		wGetVisitor1().visit(entity.getPrefix());
		wGetVisitor1().visit(entity.getPostfix());
	}
}
