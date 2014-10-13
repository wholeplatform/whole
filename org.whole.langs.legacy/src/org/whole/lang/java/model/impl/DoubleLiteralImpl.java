package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class DoubleLiteralImpl extends AbstractDataEntity implements
		DoubleLiteral {
	private static final long serialVersionUID = 1;
	private double value;

	public double getValue() {
		return notifyRequested(value);
	}

	public void setValue(double value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.DoubleLiteral_ord;
	}

	public EntityDescriptor<DoubleLiteral> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.DoubleLiteral;
	}

	public Object wGetValue() {
		return new Double(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((Double) value).doubleValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Double.valueOf(value).doubleValue());
		} catch (NumberFormatException e) {
		}
	}

	public double wDoubleValue() {
		return getValue();
	}

	public void wSetValue(double value) {
		setValue(value);
	}
}
