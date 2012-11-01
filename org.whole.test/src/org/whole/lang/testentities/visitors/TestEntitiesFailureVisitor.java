package org.whole.lang.testentities.visitors;

import org.whole.lang.testentities.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class TestEntitiesFailureVisitor extends TestEntitiesIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(SimpleTestEntity entity) {
		throw new VisitException();
	}

	public void visit(ListTestEntity entity) {
		throw new VisitException();
	}

	public void visit(UListTestEntity entity) {
		throw new VisitException();
	}

	public void visit(SetTestEntity entity) {
		throw new VisitException();
	}

	public void visit(BagTestEntity entity) {
		throw new VisitException();
	}

	public void visit(MapTestEntity entity) {
		throw new VisitException();
	}

	public void visit(BooleanTestEntity entity) {
		throw new VisitException();
	}

	public void visit(ByteTestEntity entity) {
		throw new VisitException();
	}

	public void visit(CharTestEntity entity) {
		throw new VisitException();
	}

	public void visit(DoubleTestEntity entity) {
		throw new VisitException();
	}

	public void visit(FloatTestEntity entity) {
		throw new VisitException();
	}

	public void visit(IntTestEntity entity) {
		throw new VisitException();
	}

	public void visit(LongTestEntity entity) {
		throw new VisitException();
	}

	public void visit(ShortTestEntity entity) {
		throw new VisitException();
	}

	public void visit(StringTestEntity entity) {
		throw new VisitException();
	}

	public void visit(DateTestEntity entity) {
		throw new VisitException();
	}

	public void visit(EnumTestEntity entity) {
		throw new VisitException();
	}

	public void visit(ObjectTestEntity entity) {
		throw new VisitException();
	}
}
