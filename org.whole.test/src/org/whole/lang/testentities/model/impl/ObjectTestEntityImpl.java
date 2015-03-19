package org.whole.lang.testentities.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.testentities.model.*;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ObjectTestEntityImpl extends AbstractDataEntity implements
		ObjectTestEntity {
	private static final long serialVersionUID = 1;
	private Object value;

	public Object getValue() {
		return notifyRequested(value);
	}

	public void setValue(Object value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ITestEntitiesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return TestEntitiesEntityDescriptorEnum.ObjectTestEntity_ord;
	}

	public EntityDescriptor<ObjectTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.ObjectTestEntity;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue(value);
	}
}
