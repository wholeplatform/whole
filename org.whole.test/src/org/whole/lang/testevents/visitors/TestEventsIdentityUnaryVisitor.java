package org.whole.lang.testevents.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.testevents.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TestEventsIdentityUnaryVisitor<V extends IVisitor> extends
		AbstractUnaryVisitor<V> implements ITestEventsVisitor {
	public TestEventsIdentityUnaryVisitor() {
		super(null);
	}

	public TestEventsIdentityUnaryVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		((ITestEventsEntity) entity).accept(this);
	}

	public void visit(TestEvents entity) {
	}

	public void visit(CompositeShape entity) {
	}

	public void visit(Rectangle entity) {
	}

	public void visit(Labels entity) {
	}

	public void visit(Val entity) {
	}

	public void visit(Label entity) {
	}
}
