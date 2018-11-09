package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.sql.model.RawValue;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class RawValueImpl extends AbstractDataEntity implements RawValue {
	private static final long serialVersionUID = 1;
	private Object value;

	public Object getValue() {
		return notifyRequested(value);
	}

	public void setValue(Object value) {
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
		return SQLEntityDescriptorEnum.RawValue_ord;
	}

	public EntityDescriptor<RawValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.RawValue;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue(value);
	}
}
