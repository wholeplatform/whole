package org.whole.lang.testentities.visitors;

import org.whole.lang.testentities.model.*;

/** 
 * @generator Whole
 */
public class TestEntitiesIdentityDefaultVisitor extends
		TestEntitiesIdentityVisitor {
	public void visit(ITestEntitiesEntity entity) {
	}

	public void visit(IStructuralEntity entity) {
	}

	public void visit(SimpleTestEntity entity) {
		visit((ITestEntitiesEntity) entity);
		visit((IStructuralEntity) entity);
		visit((ITestEntity) entity);
	}

	public void visit(ITestEntity entity) {
	}

	public void visit(ICompositeEntity entity) {
	}

	public void visit(ListTestEntity entity) {
		visit((ITestEntitiesEntity) entity);
		visit((ICompositeEntity) entity);
		visit((IStructuralEntity) entity);
		visit((ITestEntity) entity);
	}

	public void visit(UListTestEntity entity) {
		visit((ITestEntitiesEntity) entity);
		visit((ICompositeEntity) entity);
		visit((IStructuralEntity) entity);
		visit((ITestEntity) entity);
	}

	public void visit(SetTestEntity entity) {
		visit((ITestEntitiesEntity) entity);
		visit((ICompositeEntity) entity);
		visit((IStructuralEntity) entity);
		visit((ITestEntity) entity);
	}

	public void visit(BagTestEntity entity) {
		visit((ITestEntitiesEntity) entity);
		visit((ICompositeEntity) entity);
		visit((IStructuralEntity) entity);
		visit((ITestEntity) entity);
	}

	public void visit(MapTestEntity entity) {
		visit((ITestEntitiesEntity) entity);
		visit((ICompositeEntity) entity);
		visit((IStructuralEntity) entity);
		visit((ITestEntity) entity);
	}

	public void visit(IDataEntity entity) {
	}

	public void visit(BooleanTestEntity entity) {
		visit((ITestEntitiesEntity) entity);
		visit((IDataEntity) entity);
		visit((ITestEntity) entity);
	}

	public void visit(ByteTestEntity entity) {
		visit((ITestEntitiesEntity) entity);
		visit((IDataEntity) entity);
		visit((ITestEntity) entity);
	}

	public void visit(CharTestEntity entity) {
		visit((ITestEntitiesEntity) entity);
		visit((IDataEntity) entity);
		visit((ITestEntity) entity);
	}

	public void visit(DoubleTestEntity entity) {
		visit((ITestEntitiesEntity) entity);
		visit((IDataEntity) entity);
		visit((ITestEntity) entity);
	}

	public void visit(FloatTestEntity entity) {
		visit((ITestEntitiesEntity) entity);
		visit((IDataEntity) entity);
		visit((ITestEntity) entity);
	}

	public void visit(IntTestEntity entity) {
		visit((ITestEntitiesEntity) entity);
		visit((IDataEntity) entity);
		visit((ITestEntity) entity);
	}

	public void visit(LongTestEntity entity) {
		visit((ITestEntitiesEntity) entity);
		visit((IDataEntity) entity);
		visit((ITestEntity) entity);
	}

	public void visit(ShortTestEntity entity) {
		visit((ITestEntitiesEntity) entity);
		visit((IDataEntity) entity);
		visit((ITestEntity) entity);
	}

	public void visit(StringTestEntity entity) {
		visit((ITestEntitiesEntity) entity);
		visit((IDataEntity) entity);
		visit((ITestEntity) entity);
	}

	public void visit(DateTestEntity entity) {
		visit((ITestEntitiesEntity) entity);
		visit((IDataEntity) entity);
		visit((ITestEntity) entity);
	}

	public void visit(EnumTestEntity entity) {
		visit((ITestEntitiesEntity) entity);
		visit((IDataEntity) entity);
		visit((ITestEntity) entity);
	}

	public void visit(ObjectTestEntity entity) {
		visit((ITestEntitiesEntity) entity);
		visit((IDataEntity) entity);
		visit((ITestEntity) entity);
	}
}
