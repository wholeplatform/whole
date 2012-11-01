package org.whole.lang.testentities.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.testentities.model.*;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class LongTestEntityImpl extends AbstractDataEntity implements
		LongTestEntity {
	private static final long serialVersionUID = 1;
	private long value;

	public long getValue() {
		return notifyRequested(value);
	}

	public void setValue(long value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ITestEntitiesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TestEntitiesEntityDescriptorEnum.LongTestEntity_ord;
	}

	public EntityDescriptor<LongTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.LongTestEntity;
	}

	public Object wGetValue() {
		return new Long(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((Long) value).longValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Long.valueOf(value).longValue());
		} catch (NumberFormatException e) {
		}
	}

	public long wLongValue() {
		return getValue();
	}

	public void wSetValue(long value) {
		setValue(value);
	}
}
