package org.whole.lang.testevents.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.testevents.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TestEventsForwardGenericVisitor extends
		AbstractUnaryVisitor<IVisitor> implements ITestEventsVisitor {
	public TestEventsForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TestEvents entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CompositeShape entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Rectangle entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Labels entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Val entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Label entity) {
		wGetVisitor1().visit(entity);
	}
}
