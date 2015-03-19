package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import java.util.Date;

/** 
 * @generator Whole
 */
public class DateValueImpl extends AbstractDataEntity implements DateValue {
	private static final long serialVersionUID = 1;
	private java.sql.Date value;

	public java.sql.Date getValue() {
		return notifyRequested(value);
	}

	public void setValue(java.sql.Date value) {
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
		return SQLEntityDescriptorEnum.DateValue_ord;
	}

	public EntityDescriptor<DateValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.DateValue;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((java.sql.Date) value);
	}

	public void wSetValue(Date value) {
		setValue((java.sql.Date) value);
	}
}
