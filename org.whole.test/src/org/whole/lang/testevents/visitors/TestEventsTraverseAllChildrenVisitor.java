package org.whole.lang.testevents.visitors;

import org.whole.lang.testevents.visitors.TestEventsIdentityUnaryVisitor;
import org.whole.lang.testevents.visitors.ITestEventsVisitor;
import org.whole.lang.testevents.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class TestEventsTraverseAllChildrenVisitor extends
		TestEventsIdentityUnaryVisitor<ITestEventsVisitor> {
	public TestEventsTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public TestEventsTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(TestEvents entity) {
		entity.getMaxBase().accept(wGetVisitor1());
		entity.getMaxHeight().accept(wGetVisitor1());
		entity.getNumShapes().accept(wGetVisitor1());
		entity.getShape().accept(wGetVisitor1());
	}

	public void visit(CompositeShape entity) {
		for (Shape child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(Rectangle entity) {
		entity.getBase().accept(wGetVisitor1());
		entity.getHeight().accept(wGetVisitor1());
		entity.getArea().accept(wGetVisitor1());
		entity.getPerimeter().accept(wGetVisitor1());
	}

	public void visit(Labels entity) {
		entity.getSimple().accept(wGetVisitor1());
		entity.getSimpleDerived().accept(wGetVisitor1());
		entity.getSimpleDerivedDerived().accept(wGetVisitor1());
	}
}
