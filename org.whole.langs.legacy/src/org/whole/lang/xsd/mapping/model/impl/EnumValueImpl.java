package org.whole.lang.xsd.mapping.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;
import org.whole.lang.xsd.mapping.visitors.IMappingVisitor;
import org.whole.lang.xsd.mapping.reflect.MappingFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class EnumValueImpl extends AbstractSimpleEntity implements EnumValue {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<EnumValue> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.EnumValue;
	}

	public int wGetEntityOrd() {
		return MappingEntityDescriptorEnum.EnumValue_ord;
	}

	public void accept(IMappingVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Value enumValue;

	public Value getEnumValue() {
		return notifyRequested(MappingFeatureDescriptorEnum.enumValue,
				enumValue);
	}

	public void setEnumValue(Value enumValue) {
		notifyChanged(MappingFeatureDescriptorEnum.enumValue, this.enumValue,
				this.enumValue = enumValue);
	}

	private Value value;

	public Value getValue() {
		return notifyRequested(MappingFeatureDescriptorEnum.value, value);
	}

	public void setValue(Value value) {
		notifyChanged(MappingFeatureDescriptorEnum.value, this.value,
				this.value = value);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getEnumValue().wGetAdaptee(false);
		case 1:
			return getValue().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setEnumValue(value.wGetAdapter(MappingEntityDescriptorEnum.Value));
			break;
		case 1:
			setValue(value.wGetAdapter(MappingEntityDescriptorEnum.Value));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
