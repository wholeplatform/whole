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
public class CustomDataTypeAdapter extends AbstractEntityAdapter implements
		CustomDataType {
	private static final long serialVersionUID = 1;

	public CustomDataTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public CustomDataTypeAdapter() {
	}

	public void accept(IMappingVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CustomDataType> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.CustomDataType;
	}

	public URI getEntityType() {
		return wGet(MappingFeatureDescriptorEnum.entityType).wGetAdapter(
				MappingEntityDescriptorEnum.URI);
	}

	public void setEntityType(URI entityType) {
		wSet(MappingFeatureDescriptorEnum.entityType, entityType);
	}

	public BuiltInType getBuiltInType() {
		return wGet(MappingFeatureDescriptorEnum.builtInType).wGetAdapter(
				MappingEntityDescriptorEnum.BuiltInType);
	}

	public void setBuiltInType(BuiltInType builtInType) {
		wSet(MappingFeatureDescriptorEnum.builtInType, builtInType);
	}
}
