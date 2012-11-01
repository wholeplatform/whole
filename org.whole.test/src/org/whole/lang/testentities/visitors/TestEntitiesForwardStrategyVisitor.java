package org.whole.lang.testentities.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.testentities.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TestEntitiesForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<ITestEntitiesVisitor> implements
		ITestEntitiesVisitor {
	public TestEntitiesForwardStrategyVisitor() {
		this(new TestEntitiesIdentityVisitor());
	}

	public TestEntitiesForwardStrategyVisitor(
			ITestEntitiesVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((ITestEntitiesEntity) entity).accept(this);
	}

	public void visit(SimpleTestEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ListTestEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(UListTestEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SetTestEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BagTestEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(MapTestEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BooleanTestEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ByteTestEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CharTestEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DoubleTestEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FloatTestEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IntTestEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LongTestEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ShortTestEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(StringTestEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DateTestEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EnumTestEntity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ObjectTestEntity entity) {
		wGetStrategy().visit(entity);
	}
}
