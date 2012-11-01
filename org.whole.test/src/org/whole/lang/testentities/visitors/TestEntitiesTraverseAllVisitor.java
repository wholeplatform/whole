package org.whole.lang.testentities.visitors;

import org.whole.lang.testentities.visitors.TestEntitiesIdentityUnaryVisitor;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.testentities.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class TestEntitiesTraverseAllVisitor extends
		TestEntitiesIdentityUnaryVisitor<ITestEntitiesVisitor> {
	public TestEntitiesTraverseAllVisitor() {
		wSetVisitor1(this);
	}

	public TestEntitiesTraverseAllVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(SimpleTestEntity entity) {
		entity.getAnyEntityValue().accept(wGetVisitor1());
		entity.getStructuralEntityValue().accept(wGetVisitor1());
		entity.getCompositeEntityValue().accept(wGetVisitor1());
		entity.getDataEntityValue().accept(wGetVisitor1());
		entity.getBooleanValue().accept(wGetVisitor1());
		entity.getByteValue().accept(wGetVisitor1());
		entity.getCharValue().accept(wGetVisitor1());
		entity.getDoubleValue().accept(wGetVisitor1());
		entity.getFloatValue().accept(wGetVisitor1());
		entity.getIntValue().accept(wGetVisitor1());
		entity.getLongValue().accept(wGetVisitor1());
		entity.getShortValue().accept(wGetVisitor1());
		entity.getStringValue().accept(wGetVisitor1());
		entity.getDateValue().accept(wGetVisitor1());
		entity.getEnumValue().accept(wGetVisitor1());
		entity.getObjectValue().accept(wGetVisitor1());
	}

	public void visit(ListTestEntity entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(UListTestEntity entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(SetTestEntity entity) {
		for (ITestEntity child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(BagTestEntity entity) {
		for (ITestEntity child : entity)
			child.accept(wGetVisitor1());
	}
}
