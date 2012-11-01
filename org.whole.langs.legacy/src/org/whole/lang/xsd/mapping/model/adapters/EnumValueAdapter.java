package org.whole.lang.xsd.mapping.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.mapping.visitors.IMappingVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;
import org.whole.lang.xsd.mapping.reflect.MappingFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class EnumValueAdapter extends AbstractEntityAdapter implements
		EnumValue {
	private static final long serialVersionUID = 1;

	public EnumValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public EnumValueAdapter() {
	}

	public void accept(IMappingVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<EnumValue> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.EnumValue;
	}

	public Value getEnumValue() {
		return wGet(MappingFeatureDescriptorEnum.enumValue).wGetAdapter(
				MappingEntityDescriptorEnum.Value);
	}

	public void setEnumValue(Value enumValue) {
		wSet(MappingFeatureDescriptorEnum.enumValue, enumValue);
	}

	public Value getValue() {
		return wGet(MappingFeatureDescriptorEnum.value).wGetAdapter(
				MappingEntityDescriptorEnum.Value);
	}

	public void setValue(Value value) {
		wSet(MappingFeatureDescriptorEnum.value, value);
	}
}
