package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class IntLiteralImpl extends AbstractDataEntity implements IntLiteral {
	private static final long serialVersionUID = 1;
	private int value;

	public int getValue() {
		return notifyRequested(value);
	}

	public void setValue(int value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.IntLiteral_ord;
	}

	public EntityDescriptor<IntLiteral> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.IntLiteral;
	}

	public Object wGetValue() {
		return new Integer(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((Integer) value).intValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Integer.valueOf(value).intValue());
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
