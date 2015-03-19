package org.whole.lang.testentities.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.testentities.model.*;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class FloatTestEntityImpl extends AbstractDataEntity implements
		FloatTestEntity {
	private static final long serialVersionUID = 1;
	private float value;

	public float getValue() {
		return notifyRequested(value);
	}

	public void setValue(float value) {
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
		return TestEntitiesEntityDescriptorEnum.FloatTestEntity_ord;
	}

	public EntityDescriptor<FloatTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.FloatTestEntity;
	}

	public Object wGetValue() {
		return new Float(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((Float) value).floatValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Float.valueOf(value).floatValue());
		} catch (NumberFormatException e) {
		}
	}

	public float wFloatValue() {
		return getValue();
	}

	public void wSetValue(float value) {
		setValue(value);
	}
}
