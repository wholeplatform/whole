package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.math.model.*;
import org.whole.lang.math.model.Integer;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class IntegerImpl extends AbstractDataEntity implements Integer {
	private static final long serialVersionUID = 1;
	private int value;

	public int getValue() {
		return notifyRequested(value);
	}

	public void setValue(int value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.Integer_ord;
	}

	public EntityDescriptor<Integer> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Integer;
	}

	public Object wGetValue() {
		return new java.lang.Integer(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((java.lang.Integer) value).intValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(java.lang.Integer.valueOf(value).intValue());
		} catch (NumberFormatException e) {
		}
	}

	public int wIntValue() {
		return getValue();
	}

	public void wSetValue(int value) {
		setValue(value);
	}
}
