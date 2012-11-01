package org.whole.lang.testevents.visitors;

import org.whole.lang.testevents.model.*;

/** 
 * @generator Whole
 */
public class TestEventsIdentityDefaultVisitor extends TestEventsIdentityVisitor {
	public void visit(ITestEventsEntity entity) {
	}

	public void visit(TestEvents entity) {
		visit((ITestEventsEntity) entity);
	}

	public void visit(Shape entity) {
	}

	public void visit(CompositeShape entity) {
		visit((ITestEventsEntity) entity);
		visit((Shape) entity);
	}

	public void visit(Rectangle entity) {
		visit((ITestEventsEntity) entity);
		visit((Shape) entity);
	}

	public void visit(Labels entity) {
		visit((ITestEventsEntity) entity);
		visit((Shape) entity);
	}

	public void visit(Val entity) {
		visit((ITestEventsEntity) entity);
	}

	public void visit(Label entity) {
		visit((ITestEventsEntity) entity);
	}
}
