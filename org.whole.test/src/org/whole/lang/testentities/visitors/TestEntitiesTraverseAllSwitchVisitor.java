package org.whole.lang.testentities.visitors;

import org.whole.lang.testentities.visitors.TestEntitiesIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.testentities.model.*;

/** 
 * @generator Whole
 */
public class TestEntitiesTraverseAllSwitchVisitor extends
		TestEntitiesIdentityUnaryVisitor<IVisitor> {
	public TestEntitiesTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(SimpleTestEntity entity) {
		wGetVisitor1().visit(entity.getAnyEntityValue());
		wGetVisitor1().visit(entity.getStructuralEntityValue());
		wGetVisitor1().visit(entity.getCompositeEntityValue());
		wGetVisitor1().visit(entity.getDataEntityValue());
		wGetVisitor1().visit(entity.getBooleanValue());
		wGetVisitor1().visit(entity.getByteValue());
		wGetVisitor1().visit(entity.getCharValue());
		wGetVisitor1().visit(entity.getDoubleValue());
		wGetVisitor1().visit(entity.getFloatValue());
		wGetVisitor1().visit(entity.getIntValue());
		wGetVisitor1().visit(entity.getLongValue());
		wGetVisitor1().visit(entity.getShortValue());
		wGetVisitor1().visit(entity.getStringValue());
		wGetVisitor1().visit(entity.getDateValue());
		wGetVisitor1().visit(entity.getEnumValue());
		wGetVisitor1().visit(entity.getObjectValue());
	}

	public void visit(ListTestEntity entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(UListTestEntity entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(SetTestEntity entity) {
		for (ITestEntity child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(BagTestEntity entity) {
		for (ITestEntity child : entity)
			wGetVisitor1().visit(child);
	}
}
