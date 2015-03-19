package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class TinyIntValueImpl extends AbstractDataEntity implements
		TinyIntValue {
	private static final long serialVersionUID = 1;
	private byte value;

	public byte getValue() {
		return notifyRequested(value);
	}

	public void setValue(byte value) {
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
		return SQLEntityDescriptorEnum.TinyIntValue_ord;
	}

	public EntityDescriptor<TinyIntValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.TinyIntValue;
	}

	public Object wGetValue() {
		return new Byte(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((Byte) value).byteValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Byte.valueOf(value).byteValue());
		} catch (NumberFormatException e) {
		}
	}

	public byte wByteValue() {
		return getValue();
	}

	public void wSetValue(byte value) {
		setValue(value);
	}
}
