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
public class AnyStructuralMappingImpl extends AbstractSimpleEntity implements
		AnyStructuralMapping {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<AnyStructuralMapping> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.AnyStructuralMapping;
	}

	public int wGetEntityOrd() {
		return MappingEntityDescriptorEnum.AnyStructuralMapping_ord;
	}

	public void accept(IMappingVisitor visitor) {
		visitor.visit(this);
	}

	private URI contextEntityType;

	public URI getContextEntityType() {
		return notifyRequested(MappingFeatureDescriptorEnum.contextEntityType,
				contextEntityType);
	}

	public void setContextEntityType(URI contextEntityType) {
		notifyChanged(MappingFeatureDescriptorEnum.contextEntityType,
				this.contextEntityType,
				this.contextEntityType = contextEntityType);
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

	private URI featureType;

	public URI getFeatureType() {
		return notifyRequested(MappingFeatureDescriptorEnum.featureType,
				featureType);
	}

	public void setFeatureType(URI featureType) {
		notifyChanged(MappingFeatureDescriptorEnum.featureType,
				this.featureType, this.featureType = featureType);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getContextEntityType().wGetAdaptee(false);
		case 1:
			return getEntityType().wGetAdaptee(false);
		case 2:
			return getFeatureType().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setContextEntityType(value
					.wGetAdapter(MappingEntityDescriptorEnum.URI));
			break;
		case 1:
			setEntityType(value.wGetAdapter(MappingEntityDescriptorEnum.URI));
			break;
		case 2:
			setFeatureType(value.wGetAdapter(MappingEntityDescriptorEnum.URI));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
