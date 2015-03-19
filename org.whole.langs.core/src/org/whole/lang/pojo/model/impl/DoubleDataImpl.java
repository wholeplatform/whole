package org.whole.lang.pojo.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.pojo.model.*;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class DoubleDataImpl extends AbstractDataEntity implements DoubleData {
	private static final long serialVersionUID = 1;
	private double value;

	public double getValue() {
		return notifyRequested(value);
	}

	public void setValue(double value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IPojoVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return PojoEntityDescriptorEnum.DoubleData_ord;
	}

	public EntityDescriptor<DoubleData> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.DoubleData;
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
