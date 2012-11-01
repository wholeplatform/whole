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
public class EnumDataTypeAdapter extends AbstractEntityAdapter implements
		EnumDataType {
	private static final long serialVersionUID = 1;

	public EnumDataTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public EnumDataTypeAdapter() {
	}

	public void accept(IMappingVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<EnumDataType> wGetEntityDescriptor() {
		return MappingEntityDescriptorEnum.EnumDataType;
	}

	public URI getEntityType() {
		return wGet(MappingFeatureDescriptorEnum.entityType).wGetAdapter(
				MappingEntityDescriptorEnum.URI);
	}

	public void setEntityType(URI entityType) {
		wSet(MappingFeatureDescriptorEnum.entityType, entityType);
	}

	public EnumValues getEnumValues() {
		return wGet(MappingFeatureDescriptorEnum.enumValues).wGetAdapter(
				MappingEntityDescriptorEnum.EnumValues);
	}

	public void setEnumValues(EnumValues enumValues) {
		wSet(MappingFeatureDescriptorEnum.enumValues, enumValues);
	}
}
