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
public class AnyMappingAdapter extends AbstractEntityAdapter implements
		AnyMapping {
	private static final long serialVersionUID = 1;

	public AnyMappingAdapter(IEntity implementor) {
		super(implementor);
	}

	public AnyMappingAdapter() {
	}

	public void accept(IMappingVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AnyMapping> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.AnyMapping;
	}

	public URI getContextEntityType() {
		return wGet(MappingFeatureDescriptorEnum.contextEntityType)
				.wGetAdapter(MappingEntityDescriptorEnum.URI);
	}

	public void setContextEntityType(URI contextEntityType) {
		wSet(MappingFeatureDescriptorEnum.contextEntityType, contextEntityType);
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
