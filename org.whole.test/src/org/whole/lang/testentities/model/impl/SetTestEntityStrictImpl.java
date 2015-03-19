package org.whole.lang.testentities.model.impl;

import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.testentities.model.*;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class SetTestEntityStrictImpl extends
		AbstractSetCompositeEntity<ITestEntity> implements SetTestEntity {
	private static final long serialVersionUID = 1;

	public void accept(ITestEntitiesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return TestEntitiesEntityDescriptorEnum.SetTestEntity_ord;
	}

	public EntityDescriptor<SetTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.SetTestEntity;
	}
}
