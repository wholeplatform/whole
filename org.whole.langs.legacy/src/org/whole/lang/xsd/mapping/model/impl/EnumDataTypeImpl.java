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
public class EnumDataTypeImpl extends AbstractSimpleEntity implements
		EnumDataType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<EnumDataType> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.EnumDataType;
	}

	public int wGetEntityOrd() {
		return MappingEntityDescriptorEnum.EnumDataType_ord;
	}

	public void accept(IMappingVisitor visitor) {
		visitor.visit(this);
	}

	private URI entityType;

	public URI getEntityType() {
		return notifyRequested(MappingFeatureDescriptorEnum.entityType,
				entityType);
	}

	public void setEntityType(URI entityType) {
		notifyChanged(MappingFeatureDescriptorEnum.entityType, this.entityType,
				this.entityType = entityType);
	}

	private EnumValues enumValues;

	public EnumValues getEnumValues() {
		return notifyRequested(MappingFeatureDescriptorEnum.enumValues,
				enumValues);
	}

	public void setEnumValues(EnumValues enumValues) {
		notifyChanged(MappingFeatureDescriptorEnum.enumValues, this.enumValues,
				this.enumValues = enumValues);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getEntityType().wGetAdaptee(false);
		case 1:
			return getEnumValues().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setEntityType(value.wGetAdapter(MappingEntityDescriptorEnum.URI));
			break;
		case 1:
			setEnumValues(value
					.wGetAdapter(MappingEntityDescriptorEnum.EnumValues));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
