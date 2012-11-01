package org.whole.lang.testevents.visitors;

import org.whole.lang.testevents.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class TestEventsFailureVisitor extends TestEventsIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(TestEvents entity) {
		throw new VisitException();
	}

	public void visit(CompositeShape entity) {
		throw new VisitException();
	}

	public void visit(Rectangle entity) {
		throw new VisitException();
	}

	public void visit(Labels entity) {
		throw new VisitException();
	}

	public void visit(Val entity) {
		throw new VisitException();
	}

	public void visit(Label entity) {
		throw new VisitException();
	}
}
