package org.whole.lang.testentities.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.testentities.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TestEntitiesForwardGenericVisitor extends
		AbstractUnaryVisitor<IVisitor> implements ITestEntitiesVisitor {
	public TestEntitiesForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SimpleTestEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ListTestEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(UListTestEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SetTestEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BagTestEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(MapTestEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BooleanTestEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ByteTestEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CharTestEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DoubleTestEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FloatTestEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(IntTestEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LongTestEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ShortTestEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(StringTestEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DateTestEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EnumTestEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ObjectTestEntity entity) {
		wGetVisitor1().visit(entity);
	}
}
