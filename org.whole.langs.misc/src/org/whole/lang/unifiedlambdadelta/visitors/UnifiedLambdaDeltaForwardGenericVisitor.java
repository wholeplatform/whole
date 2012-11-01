package org.whole.lang.unifiedlambdadelta.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.unifiedlambdadelta.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaForwardGenericVisitor extends
		AbstractUnaryVisitor<IVisitor> implements IUnifiedLambdaDeltaVisitor {
	public UnifiedLambdaDeltaForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Declaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Definition entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Top entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Application entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Cast entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Abstraction entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Abbreviation entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Local entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Sort entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Polarity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Index entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Level entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Name entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Access entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Prefix entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Postfix entity) {
		wGetVisitor1().visit(entity);
	}
}
