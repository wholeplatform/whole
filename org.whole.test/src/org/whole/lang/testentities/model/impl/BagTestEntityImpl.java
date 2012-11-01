package org.whole.lang.testentities.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.testentities.model.*;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class BagTestEntityImpl extends
		AbstractCollectionCompositeEntity<ITestEntity> implements BagTestEntity {
	private static final long serialVersionUID = 1;

	public void accept(ITestEntitiesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TestEntitiesEntityDescriptorEnum.BagTestEntity_ord;
	}

	public EntityDescriptor<BagTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.BagTestEntity;
	}
}
