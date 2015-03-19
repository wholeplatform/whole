package org.whole.lang.scheme.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.scheme.model.*;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class BuiltinValueImpl extends AbstractDataEntity implements
		BuiltinValue {
	private static final long serialVersionUID = 1;
	private org.whole.lang.scheme.model.BuiltinValueEnum.Value value;

	public org.whole.lang.scheme.model.BuiltinValueEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(
			org.whole.lang.scheme.model.BuiltinValueEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ISchemeVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return SchemeEntityDescriptorEnum.BuiltinValue_ord;
	}

	public EntityDescriptor<BuiltinValue> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.BuiltinValue;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.scheme.model.BuiltinValueEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(BuiltinValueEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.scheme.model.BuiltinValueEnum.Value) value);
	}
}
