package org.whole.lang.testevents.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.testevents.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TestEventsForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<ITestEventsVisitor> implements
		ITestEventsVisitor {
	public TestEventsForwardStrategyVisitor() {
		this(new TestEventsIdentityVisitor());
	}

	public TestEventsForwardStrategyVisitor(
			ITestEventsVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((ITestEventsEntity) entity).accept(this);
	}

	public void visit(TestEvents entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CompositeShape entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Rectangle entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Labels entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Val entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Label entity) {
		wGetStrategy().visit(entity);
	}
}
