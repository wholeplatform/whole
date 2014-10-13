package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class BooleanLiteralImpl extends AbstractDataEntity implements
		BooleanLiteral {
	private static final long serialVersionUID = 1;
	private boolean value;

	public boolean isValue() {
		return notifyRequested(value);
	}

	public void setValue(boolean value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.BooleanLiteral_ord;
	}

	public EntityDescriptor<BooleanLiteral> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.BooleanLiteral;
	}

	public Object wGetValue() {
		return new Boolean(isValue());
	}

	public void wSetValue(Object value) {
		setValue(((Boolean) value).booleanValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Boolean.valueOf(value).booleanValue());
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
