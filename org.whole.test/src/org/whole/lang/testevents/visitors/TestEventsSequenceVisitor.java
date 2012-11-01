package org.whole.lang.testevents.visitors;

import org.whole.lang.visitors.AbstractBinaryVisitor;
import org.whole.lang.testevents.visitors.ITestEventsVisitor;
import org.whole.lang.testevents.model.*;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TestEventsSequenceVisitor extends
		AbstractBinaryVisitor<ITestEventsVisitor> implements ITestEventsVisitor {
	public TestEventsSequenceVisitor(IVisitor visitor1, IVisitor visitor2) {
		super(visitor1, visitor2);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(TestEvents entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(CompositeShape entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Rectangle entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Labels entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Val entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Label entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}
}
