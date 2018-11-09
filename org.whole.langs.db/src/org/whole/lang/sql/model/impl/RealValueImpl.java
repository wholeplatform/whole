package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.sql.model.RealValue;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class RealValueImpl extends AbstractDataEntity implements RealValue {
	private static final long serialVersionUID = 1;
	private float value;

	public float getValue() {
		return notifyRequested(value);
	}

	public void setValue(float value) {
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
		return SQLEntityDescriptorEnum.RealValue_ord;
	}

	public EntityDescriptor<RealValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.RealValue;
	}

	public Object wGetValue() {
		return new Float(getValue());
	}

	public void wSetValue(Object value) {
		setValue(((Float) value).floatValue());
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(Float.valueOf(value).floatValue());
		} catch (NumberFormatException e) {
		}
	}

	public float wFloatValue() {
		return getValue();
	}

	public void wSetValue(float value) {
		setValue(value);
	}
}
