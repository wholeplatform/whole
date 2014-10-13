package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class FloatLiteralImpl extends AbstractDataEntity implements
		FloatLiteral {
	private static final long serialVersionUID = 1;
	private float value;

	public float getValue() {
		return notifyRequested(value);
	}

	public void setValue(float value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.FloatLiteral_ord;
	}

	public EntityDescriptor<FloatLiteral> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.FloatLiteral;
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
