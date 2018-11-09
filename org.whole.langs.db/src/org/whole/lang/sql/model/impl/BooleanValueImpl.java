package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.sql.model.BooleanValue;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class BooleanValueImpl extends AbstractDataEntity implements BooleanValue {
	private static final long serialVersionUID = 1;
	private boolean value;

	public boolean isValue() {
		return notifyRequested(value);
	}

	public void setValue(boolean value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.BooleanValue_ord;
	}

	public EntityDescriptor<BooleanValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.BooleanValue;
	}

	public Object wGetValue() {
		return new Boolean(isValue());
	}

	public void wSetValue(Object value) {
		setValue(((Boolean) value).booleanValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Boolean.valueOf(value).booleanValue());
		} catch (NumberFormatException e) {
		}
	}

	public boolean wBooleanValue() {
		return isValue();
	}

	public void wSetValue(boolean value) {
		setValue(value);
	}
}
