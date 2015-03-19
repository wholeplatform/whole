package org.whole.lang.javascript.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.javascript.model.*;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class NumberLiteralImpl extends AbstractDataEntity implements
		NumberLiteral {
	private static final long serialVersionUID = 1;
	private double value;

	public double getValue() {
		return notifyRequested(value);
	}

	public void setValue(double value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IJavaScriptVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.NumberLiteral_ord;
	}

	public EntityDescriptor<NumberLiteral> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.NumberLiteral;
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
