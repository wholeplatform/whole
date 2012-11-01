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
public class UnionMappingAdapter extends AbstractEntityAdapter implements
		UnionMapping {
	private static final long serialVersionUID = 1;

	public UnionMappingAdapter(IEntity implementor) {
		super(implementor);
	}

	public UnionMappingAdapter() {
	}

	public void accept(IMappingVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<UnionMapping> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.UnionMapping;
	}

	public URI getContextEntityType() {
		return wGet(MappingFeatureDescriptorEnum.contextEntityType)
				.wGetAdapter(MappingEntityDescriptorEnum.URI);
	}

	public void setContextEntityType(URI contextEntityType) {
		wSet(MappingFeatureDescriptorEnum.contextEntityType, contextEntityType);
	}

	public Types getUnionTypes() {
		return wGet(MappingFeatureDescriptorEnum.unionTypes).wGetAdapter(
				MappingEntityDescriptorEnum.Types);
	}

	public void setUnionTypes(Types unionTypes) {
		wSet(MappingFeatureDescriptorEnum.unionTypes, unionTypes);
	}
}
