package org.whole.lang.environment.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.environment.model.*;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class FloatDataImpl extends AbstractDataEntity implements FloatData {
	private static final long serialVersionUID = 1;
	private float value;

	public float getValue() {
		return notifyRequested(value);
	}

	public void setValue(float value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IEnvironmentVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return EnvironmentEntityDescriptorEnum.FloatData_ord;
	}

	public EntityDescriptor<FloatData> wGetEntityDescriptor() {
		return EnvironmentEntityDescriptorEnum.FloatData;
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
