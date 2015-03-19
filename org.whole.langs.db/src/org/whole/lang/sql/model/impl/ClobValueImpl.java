package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ClobValueImpl extends AbstractDataEntity implements ClobValue {
	private static final long serialVersionUID = 1;
	private java.sql.Clob value;

	public java.sql.Clob getValue() {
		return notifyRequested(value);
	}

	public void setValue(java.sql.Clob value) {
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
		return SQLEntityDescriptorEnum.ClobValue_ord;
	}

	public EntityDescriptor<ClobValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ClobValue;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((java.sql.Clob) value);
	}
}
