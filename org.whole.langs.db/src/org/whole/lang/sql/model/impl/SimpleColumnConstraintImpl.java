package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.sql.model.SimpleColumnConstraint;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.model.SimpleColumnConstraintEnum;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class SimpleColumnConstraintImpl extends AbstractDataEntity implements SimpleColumnConstraint {
	private static final long serialVersionUID = 1;
	private org.whole.lang.sql.model.SimpleColumnConstraintEnum.Value value;

	public org.whole.lang.sql.model.SimpleColumnConstraintEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(org.whole.lang.sql.model.SimpleColumnConstraintEnum.Value value) {
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
		return SQLEntityDescriptorEnum.SimpleColumnConstraint_ord;
	}

	public EntityDescriptor<SimpleColumnConstraint> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.SimpleColumnConstraint;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.sql.model.SimpleColumnConstraintEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(SimpleColumnConstraintEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.sql.model.SimpleColumnConstraintEnum.Value) value);
	}
}
