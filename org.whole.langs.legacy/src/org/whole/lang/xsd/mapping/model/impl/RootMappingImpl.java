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
public class RootMappingImpl extends AbstractSimpleEntity implements
		RootMapping {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<RootMapping> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.RootMapping;
	}

	public int wGetEntityOrd() {
		return MappingEntityDescriptorEnum.RootMapping_ord;
	}

	public void accept(IMappingVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private NCName name;

	public NCName getName() {
		return notifyRequested(MappingFeatureDescriptorEnum.name, name);
	}

	public void setName(NCName name) {
		notifyChanged(MappingFeatureDescriptorEnum.name, this.name,
				this.name = name);
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

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getEntityType().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(MappingEntityDescriptorEnum.NCName));
			break;
		case 1:
			setEntityType(value.wGetAdapter(MappingEntityDescriptorEnum.URI));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
