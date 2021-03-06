package org.whole.lang.testentities.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.testentities.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TestEntitiesIdentityUnaryVisitor<V extends IVisitor> extends
		AbstractUnaryVisitor<V> implements ITestEntitiesVisitor {
	public TestEntitiesIdentityUnaryVisitor() {
		super(null);
	}

	public TestEntitiesIdentityUnaryVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		((ITestEntitiesEntity) entity).accept(this);
	}

	public void visit(SimpleTestEntity entity) {
	}

	public void visit(ListTestEntity entity) {
	}

	public void visit(UListTestEntity entity) {
	}

	public void visit(SetTestEntity entity) {
	}

	public void visit(BagTestEntity entity) {
	}

	public void visit(MapTestEntity entity) {
	}

	public void visit(BooleanTestEntity entity) {
	}

	public void visit(ByteTestEntity entity) {
	}

	public void visit(CharTestEntity entity) {
	}

	public void visit(DoubleTestEntity entity) {
	}

	public void visit(FloatTestEntity entity) {
	}

	public void visit(IntTestEntity entity) {
	}

	public void visit(LongTestEntity entity) {
	}

	public void visit(ShortTestEntity entity) {
	}

	public void visit(StringTestEntity entity) {
	}

	public void visit(DateTestEntity entity) {
	}

	public void visit(EnumTestEntity entity) {
	}

	public void visit(ObjectTestEntity entity) {
	}
}
