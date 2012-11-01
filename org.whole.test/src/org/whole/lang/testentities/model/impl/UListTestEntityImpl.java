package org.whole.lang.testentities.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.testentities.model.*;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class UListTestEntityImpl extends
		AbstractCollectionCompositeEntity<IStructuralEntity> implements
		UListTestEntity {
	private static final long serialVersionUID = 1;

	public void accept(ITestEntitiesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TestEntitiesEntityDescriptorEnum.UListTestEntity_ord;
	}

	public EntityDescriptor<UListTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.UListTestEntity;
	}
}
