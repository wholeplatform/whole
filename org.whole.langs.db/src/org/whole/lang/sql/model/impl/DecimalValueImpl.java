package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class DecimalValueImpl extends AbstractDataEntity implements
		DecimalValue {
	private static final long serialVersionUID = 1;
	private java.math.BigDecimal value;

	public java.math.BigDecimal getValue() {
		return notifyRequested(value);
	}

	public void setValue(java.math.BigDecimal value) {
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
		return SQLEntityDescriptorEnum.DecimalValue_ord;
	}

	public EntityDescriptor<DecimalValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.DecimalValue;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((java.math.BigDecimal) value);
	}
}
