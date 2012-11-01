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
public class ElementMappingImpl extends AbstractSimpleEntity implements
		ElementMapping {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ElementMapping> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.ElementMapping;
	}

	public int wGetEntityOrd() {
		return MappingEntityDescriptorEnum.ElementMapping_ord;
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
			return getName().wGetAdaptee(false);
		case 2:
			return getEntityType().wGetAdaptee(false);
		case 3:
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
			setName(value.wGetAdapter(MappingEntityDescriptorEnum.NCName));
			break;
		case 2:
			setEntityType(value.wGetAdapter(MappingEntityDescriptorEnum.URI));
			break;
		case 3:
			setFeatureType(value.wGetAdapter(MappingEntityDescriptorEnum.URI));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
