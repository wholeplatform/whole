package org.whole.lang.testevents.visitors;

import org.whole.lang.testevents.visitors.TestEventsIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.testevents.model.*;

/** 
 * @generator Whole
 */
public class TestEventsTraverseAllSwitchVisitor extends
		TestEventsIdentityUnaryVisitor<IVisitor> {
	public TestEventsTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(TestEvents entity) {
		wGetVisitor1().visit(entity.getMaxBase());
		wGetVisitor1().visit(entity.getMaxHeight());
		wGetVisitor1().visit(entity.getNumShapes());
		wGetVisitor1().visit(entity.getShape());
	}

	public void visit(CompositeShape entity) {
		for (Shape child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(Rectangle entity) {
		wGetVisitor1().visit(entity.getBase());
		wGetVisitor1().visit(entity.getHeight());
		wGetVisitor1().visit(entity.getArea());
		wGetVisitor1().visit(entity.getPerimeter());
	}

	public void visit(Labels entity) {
		wGetVisitor1().visit(entity.getSimple());
		wGetVisitor1().visit(entity.getSimpleDerived());
		wGetVisitor1().visit(entity.getSimpleDerivedDerived());
	}
}
