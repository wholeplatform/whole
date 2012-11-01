package org.whole.lang.xsd.mapping.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class MappingIdentitySwitchVisitor extends AbstractVisitor
		implements IMappingVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case MappingEntityDescriptorEnum.MappingStrategy_ord:
			visit((MappingStrategy) entity);
			break;
		case MappingEntityDescriptorEnum.Mappings_ord:
			visit((Mappings) entity);
			break;
		case MappingEntityDescriptorEnum.Types_ord:
			visit((Types) entity);
			break;
		case MappingEntityDescriptorEnum.RootMapping_ord:
			visit((RootMapping) entity);
			break;
		case MappingEntityDescriptorEnum.ContentMapping_ord:
			visit((ContentMapping) entity);
			break;
		case MappingEntityDescriptorEnum.MixedStructuralMapping_ord:
			visit((MixedStructuralMapping) entity);
			break;
		case MappingEntityDescriptorEnum.AnyStructuralMapping_ord:
			visit((AnyStructuralMapping) entity);
			break;
		case MappingEntityDescriptorEnum.AnyElementMapping_ord:
			visit((AnyElementMapping) entity);
			break;
		case MappingEntityDescriptorEnum.AnyAttributeMapping_ord:
			visit((AnyAttributeMapping) entity);
			break;
		case MappingEntityDescriptorEnum.StructuralMapping_ord:
			visit((StructuralMapping) entity);
			break;
		case MappingEntityDescriptorEnum.ElementMapping_ord:
			visit((ElementMapping) entity);
			break;
		case MappingEntityDescriptorEnum.AttributeMapping_ord:
			visit((AttributeMapping) entity);
			break;
		case MappingEntityDescriptorEnum.UnionMapping_ord:
			visit((UnionMapping) entity);
			break;
		case MappingEntityDescriptorEnum.DataTypes_ord:
			visit((DataTypes) entity);
			break;
		case MappingEntityDescriptorEnum.EnumDataType_ord:
			visit((EnumDataType) entity);
			break;
		case MappingEntityDescriptorEnum.EnumValues_ord:
			visit((EnumValues) entity);
			break;
		case MappingEntityDescriptorEnum.EnumValue_ord:
			visit((EnumValue) entity);
			break;
		case MappingEntityDescriptorEnum.CustomDataType_ord:
			visit((CustomDataType) entity);
			break;
		case MappingEntityDescriptorEnum.URI_ord:
			visit((URI) entity);
			break;
		case MappingEntityDescriptorEnum.BooleanType_ord:
			visit((BooleanType) entity);
			break;
		case MappingEntityDescriptorEnum.NCName_ord:
			visit((NCName) entity);
			break;
		case MappingEntityDescriptorEnum.Value_ord:
			visit((Value) entity);
			break;
		case MappingEntityDescriptorEnum.BuiltInType_ord:
			visit((BuiltInType) entity);
			break;
		}
	}
}
