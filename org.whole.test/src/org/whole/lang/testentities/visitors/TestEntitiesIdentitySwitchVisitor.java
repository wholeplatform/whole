package org.whole.lang.testentities.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.testentities.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class TestEntitiesIdentitySwitchVisitor extends AbstractVisitor
		implements ITestEntitiesVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case TestEntitiesEntityDescriptorEnum.SimpleTestEntity_ord:
			visit((SimpleTestEntity) entity);
			break;
		case TestEntitiesEntityDescriptorEnum.ListTestEntity_ord:
			visit((ListTestEntity) entity);
			break;
		case TestEntitiesEntityDescriptorEnum.UListTestEntity_ord:
			visit((UListTestEntity) entity);
			break;
		case TestEntitiesEntityDescriptorEnum.SetTestEntity_ord:
			visit((SetTestEntity) entity);
			break;
		case TestEntitiesEntityDescriptorEnum.BagTestEntity_ord:
			visit((BagTestEntity) entity);
			break;
		case TestEntitiesEntityDescriptorEnum.MapTestEntity_ord:
			visit((MapTestEntity) entity);
			break;
		case TestEntitiesEntityDescriptorEnum.BooleanTestEntity_ord:
			visit((BooleanTestEntity) entity);
			break;
		case TestEntitiesEntityDescriptorEnum.ByteTestEntity_ord:
			visit((ByteTestEntity) entity);
			break;
		case TestEntitiesEntityDescriptorEnum.CharTestEntity_ord:
			visit((CharTestEntity) entity);
			break;
		case TestEntitiesEntityDescriptorEnum.DoubleTestEntity_ord:
			visit((DoubleTestEntity) entity);
			break;
		case TestEntitiesEntityDescriptorEnum.FloatTestEntity_ord:
			visit((FloatTestEntity) entity);
			break;
		case TestEntitiesEntityDescriptorEnum.IntTestEntity_ord:
			visit((IntTestEntity) entity);
			break;
		case TestEntitiesEntityDescriptorEnum.LongTestEntity_ord:
			visit((LongTestEntity) entity);
			break;
		case TestEntitiesEntityDescriptorEnum.ShortTestEntity_ord:
			visit((ShortTestEntity) entity);
			break;
		case TestEntitiesEntityDescriptorEnum.StringTestEntity_ord:
			visit((StringTestEntity) entity);
			break;
		case TestEntitiesEntityDescriptorEnum.DateTestEntity_ord:
			visit((DateTestEntity) entity);
			break;
		case TestEntitiesEntityDescriptorEnum.EnumTestEntity_ord:
			visit((EnumTestEntity) entity);
			break;
		case TestEntitiesEntityDescriptorEnum.ObjectTestEntity_ord:
			visit((ObjectTestEntity) entity);
			break;
		}
	}
}
