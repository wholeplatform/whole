package org.whole.lang.types.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.types.model.*;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.model.EnumValue;

/** 
 * @generator Whole
 */
public class LegacyTypeImpl extends AbstractDataEntity implements LegacyType {
	private static final long serialVersionUID = 1;
	private org.whole.lang.types.model.LegacyTypeEnum.Value value;

	public org.whole.lang.types.model.LegacyTypeEnum.Value getValue() {
		return notifyRequested(value);
	}

	public void setValue(org.whole.lang.types.model.LegacyTypeEnum.Value value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(ITypesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return TypesEntityDescriptorEnum.LegacyType_ord;
	}

	public EntityDescriptor<LegacyType> wGetEntityDescriptor() {
		return TypesEntityDescriptorEnum.LegacyType;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((org.whole.lang.types.model.LegacyTypeEnum.Value) value);
	}

	public String wStringValue() {
		return toString();
	}

	public void wSetValue(String value) {
		try {
			setValue(LegacyTypeEnum.instance.valueOf(value));
		} catch (NumberFormatException e) {
		}
	}

	public EnumValue wEnumValue() {
		return value;
	}

	public void wSetValue(EnumValue value) {
		setValue((org.whole.lang.types.model.LegacyTypeEnum.Value) value);
	}
}
