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
public class CustomDataTypeImpl extends AbstractSimpleEntity implements
		CustomDataType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<CustomDataType> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.CustomDataType;
	}

	public int wGetEntityOrd() {
		return MappingEntityDescriptorEnum.CustomDataType_ord;
	}

	public void accept(IMappingVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
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

	private BuiltInType builtInType;

	public BuiltInType getBuiltInType() {
		return notifyRequested(MappingFeatureDescriptorEnum.builtInType,
				builtInType);
	}

	public void setBuiltInType(BuiltInType builtInType) {
		notifyChanged(MappingFeatureDescriptorEnum.builtInType,
				this.builtInType, this.builtInType = builtInType);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getEntityType().wGetAdaptee(false);
		case 1:
			return getBuiltInType().wGetAdaptee(false);
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
			setBuiltInType(value
					.wGetAdapter(MappingEntityDescriptorEnum.BuiltInType));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
