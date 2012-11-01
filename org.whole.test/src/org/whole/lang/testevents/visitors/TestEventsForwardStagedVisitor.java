package org.whole.lang.testevents.visitors;

import org.whole.lang.testevents.model.*;

/** 
 * @generator Whole
 */
public class TestEventsForwardStagedVisitor extends TestEventsIdentityVisitor {
	public void visit(TestEvents entity) {
		stagedVisit(entity);
	}

	public void visit(CompositeShape entity) {
		stagedVisit(entity);
	}

	public void visit(Rectangle entity) {
		stagedVisit(entity);
	}

	public void visit(Labels entity) {
		stagedVisit(entity);
	}

	public void visit(Val entity) {
		stagedVisit(entity);
	}

	public void visit(Label entity) {
		stagedVisit(entity);
	}
}
