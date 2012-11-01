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
public class ElementMappingAdapter extends AbstractEntityAdapter implements
		ElementMapping {
	private static final long serialVersionUID = 1;

	public ElementMappingAdapter(IEntity implementor) {
		super(implementor);
	}

	public ElementMappingAdapter() {
	}

	public void accept(IMappingVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ElementMapping> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.ElementMapping;
	}

	public URI getContextEntityType() {
		return wGet(MappingFeatureDescriptorEnum.contextEntityType)
				.wGetAdapter(MappingEntityDescriptorEnum.URI);
	}

	public void setContextEntityType(URI contextEntityType) {
		wSet(MappingFeatureDescriptorEnum.contextEntityType, contextEntityType);
	}

	public NCName getName() {
		return wGet(MappingFeatureDescriptorEnum.name).wGetAdapter(
				MappingEntityDescriptorEnum.NCName);
	}

	public void setName(NCName name) {
		wSet(MappingFeatureDescriptorEnum.name, name);
	}

	public URI getEntityType() {
		return wGet(MappingFeatureDescriptorEnum.entityType).wGetAdapter(
				MappingEntityDescriptorEnum.URI);
	}

	public void setEntityType(URI entityType) {
		wSet(MappingFeatureDescriptorEnum.entityType, entityType);
	}

	public URI getFeatureType() {
		return wGet(MappingFeatureDescriptorEnum.featureType).wGetAdapter(
				MappingEntityDescriptorEnum.URI);
	}

	public void setFeatureType(URI featureType) {
		wSet(MappingFeatureDescriptorEnum.featureType, featureType);
	}
}
