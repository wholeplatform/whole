package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.math.model.*;
import org.whole.lang.math.model.Boolean;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class BooleanImpl extends AbstractDataEntity implements Boolean {
	private static final long serialVersionUID = 1;
	private boolean value;

	public boolean isValue() {
		return notifyRequested(value);
	}

	public void setValue(boolean value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.Boolean_ord;
	}

	public EntityDescriptor<Boolean> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Boolean;
	}

	public Object wGetValue() {
		return new java.lang.Boolean(isValue());
	}

	public void wSetValue(Object value) {
		setValue(((java.lang.Boolean) value).booleanValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(java.lang.Boolean.valueOf(value).booleanValue());
		} catch (NumberFormatException e) {
		}
	}

	public boolean wBooleanValue() {
		return isValue();
	}

	public void wSetValue(boolean value) {
		setValue(value);
	}
}
