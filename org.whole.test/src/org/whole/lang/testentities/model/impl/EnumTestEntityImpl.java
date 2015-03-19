package org.whole.lang.testentities.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.testentities.model.*;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class EnumTestEntityImpl extends AbstractDataEntity implements
		EnumTestEntity {
	private static final long serialVersionUID = 1;
	private org.whole.lang.testentities.model.EnumTestEntityEnum.Value value;

	public org.whole.lang.testentities.model.EnumTestEntityEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(
			org.whole.lang.testentities.model.EnumTestEntityEnum.Value value) {
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
		return TestEntitiesEntityDescriptorEnum.EnumTestEntity_ord;
	}

	public EntityDescriptor<EnumTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.EnumTestEntity;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.testentities.model.EnumTestEntityEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(EnumTestEntityEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.testentities.model.EnumTestEntityEnum.Value) value);
	}
}
