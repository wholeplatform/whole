package org.whole.lang.testentities.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.testentities.model.*;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.StringUtils;
import java.util.Date;

/** 
 * @generator Whole
 */
public class DateTestEntityImpl extends AbstractDataEntity implements
		DateTestEntity {
	private static final long serialVersionUID = 1;
	private java.util.Date value;

	public java.util.Date getValue() {
		return notifyRequested(value);
	}

	public void setValue(java.util.Date value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ITestEntitiesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TestEntitiesEntityDescriptorEnum.DateTestEntity_ord;
	}

	public EntityDescriptor<DateTestEntity> wGetEntityDescriptor() {
		return TestEntitiesEntityDescriptorEnum.DateTestEntity;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((java.util.Date) value);
	}

	public String wStringValue() {
		return StringUtils.toExtendedISO8601DateTime(value);
	}

	public void wSetValue(String value) {
		try {
			setValue(StringUtils.fromExtendedISO8601DateTime(value));
		} catch (IllegalArgumentException e) {
		}
	}

	public Date wDateValue() {
		return value;
	}

	public void wSetValue(Date value) {
		setValue((Date) value);
	}
}
