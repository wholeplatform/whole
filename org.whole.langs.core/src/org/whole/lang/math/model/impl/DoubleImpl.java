package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.math.model.*;
import org.whole.lang.math.model.Double;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class DoubleImpl extends AbstractDataEntity implements Double {
	private static final long serialVersionUID = 1;
	private double value;

	public double getValue() {
		return notifyRequested(value);
	}

	public void setValue(double value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IMathVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return MathEntityDescriptorEnum.Double_ord;
	}

	public EntityDescriptor<Double> wGetEntityDescriptor() {
		return MathEntityDescriptorEnum.Double;
	}

	public Object wGetValue() {
		return new java.lang.Double(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((java.lang.Double) value).doubleValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(java.lang.Double.valueOf(value).doubleValue());
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
