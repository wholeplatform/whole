package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.examples.lang.imp.model.PrimitiveType;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.model.PrimitiveTypeEnum;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class PrimitiveTypeImpl extends AbstractDataEntity implements PrimitiveType {
	private static final long serialVersionUID = 1;
	private org.whole.examples.lang.imp.model.PrimitiveTypeEnum.Value value;

	public org.whole.examples.lang.imp.model.PrimitiveTypeEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(org.whole.examples.lang.imp.model.PrimitiveTypeEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IImpVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.PrimitiveType_ord;
	}

	public EntityDescriptor<PrimitiveType> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.PrimitiveType;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.examples.lang.imp.model.PrimitiveTypeEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(PrimitiveTypeEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.examples.lang.imp.model.PrimitiveTypeEnum.Value) value);
	}
}
