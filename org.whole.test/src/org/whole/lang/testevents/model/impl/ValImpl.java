package org.whole.lang.testevents.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.testevents.model.*;
import org.whole.lang.testevents.visitors.ITestEventsVisitor;
import org.whole.lang.testevents.reflect.TestEventsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ValImpl extends AbstractDataEntity implements Val {
	private static final long serialVersionUID = 1;
	private int value;

	public int getValue() {
		return notifyRequested(value);
	}

	public void setValue(int value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ITestEventsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return TestEventsEntityDescriptorEnum.Val_ord;
	}

	public EntityDescriptor<Val> wGetEntityDescriptor() {
		return TestEventsEntityDescriptorEnum.Val;
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
