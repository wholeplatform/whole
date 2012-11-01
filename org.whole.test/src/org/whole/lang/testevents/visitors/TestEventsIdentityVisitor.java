package org.whole.lang.testevents.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.testevents.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TestEventsIdentityVisitor extends AbstractVisitor implements
		ITestEventsVisitor {
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
