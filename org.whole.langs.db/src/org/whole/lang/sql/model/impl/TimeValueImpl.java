package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class TimeValueImpl extends AbstractDataEntity implements TimeValue {
	private static final long serialVersionUID = 1;
	private java.sql.Time value;

	public java.sql.Time getValue() {
		return notifyRequested(value);
	}

	public void setValue(java.sql.Time value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.TimeValue_ord;
	}

	public EntityDescriptor<TimeValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.TimeValue;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((java.sql.Time) value);
	}
}
