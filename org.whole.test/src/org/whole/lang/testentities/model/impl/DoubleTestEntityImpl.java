package org.whole.lang.testentities.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.testentities.model.*;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class DoubleTestEntityImpl extends AbstractDataEntity implements
		DoubleTestEntity {
	private static final long serialVersionUID = 1;
	private double value;

	public double getValue() {
		return notifyRequested(value);
	}

	public void setValue(double value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ITestEntitiesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return TestEntitiesEntityDescriptorEnum.DoubleTestEntity_ord;
	}

	public EntityDescriptor<DoubleTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.DoubleTestEntity;
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
