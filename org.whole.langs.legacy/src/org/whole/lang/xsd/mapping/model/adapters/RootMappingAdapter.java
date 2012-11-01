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
public class RootMappingAdapter extends AbstractEntityAdapter implements
		RootMapping {
	private static final long serialVersionUID = 1;

	public RootMappingAdapter(IEntity implementor) {
		super(implementor);
	}

	public RootMappingAdapter() {
	}

	public void accept(IMappingVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<RootMapping> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.RootMapping;
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
}
