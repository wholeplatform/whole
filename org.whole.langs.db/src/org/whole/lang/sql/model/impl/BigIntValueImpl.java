package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class BigIntValueImpl extends AbstractDataEntity implements BigIntValue {
	private static final long serialVersionUID = 1;
	private long value;

	public long getValue() {
		return notifyRequested(value);
	}

	public void setValue(long value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.BigIntValue_ord;
	}

	public EntityDescriptor<BigIntValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.BigIntValue;
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
