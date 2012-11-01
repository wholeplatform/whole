package org.whole.lang.testentities.model.impl;

import org.whole.lang.model.AbstractMapCompositeEntity;
import org.whole.lang.testentities.model.*;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class MapTestEntityImpl extends
		AbstractMapCompositeEntity<ITestEntity, IStructuralEntity> implements
		MapTestEntity {
	private static final long serialVersionUID = 1;

	public void accept(ITestEntitiesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TestEntitiesEntityDescriptorEnum.MapTestEntity_ord;
	}

	public EntityDescriptor<MapTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.MapTestEntity;
	}

	public boolean isContainment() {
		return false;
	}
}
