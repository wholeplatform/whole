package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.math.model.*;
import org.whole.lang.math.model.Float;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class FloatImpl extends AbstractDataEntity implements Float {
	private static final long serialVersionUID = 1;
	private float value;

	public float getValue() {
		return notifyRequested(value);
	}

	public void setValue(float value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.Float_ord;
	}

	public EntityDescriptor<Float> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Float;
	}

	public Object wGetValue() {
		return new java.lang.Float(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((java.lang.Float) value).floatValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(java.lang.Float.valueOf(value).floatValue());
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
