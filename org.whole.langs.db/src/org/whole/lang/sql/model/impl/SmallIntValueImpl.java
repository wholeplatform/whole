package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.sql.model.SmallIntValue;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class SmallIntValueImpl extends AbstractDataEntity implements SmallIntValue {
	private static final long serialVersionUID = 1;
	private short value;

	public short getValue() {
		return notifyRequested(value);
	}

	public void setValue(short value) {
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
		return SQLEntityDescriptorEnum.SmallIntValue_ord;
	}

	public EntityDescriptor<SmallIntValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.SmallIntValue;
	}

	public Object wGetValue() {
		return new Short(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((Short) value).shortValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Short.valueOf(value).shortValue());
		} catch (NumberFormatException e) {
		}
	}

	public short wShortValue() {
		return getValue();
	}

	public void wSetValue(short value) {
		setValue(value);
	}
}
