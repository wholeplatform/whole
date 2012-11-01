package org.whole.lang.xsd.mapping.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.xsd.mapping.reflect.MappingFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class MappingGenericBuilderAdapter extends GenericIdentityBuilder {
	private IMappingBuilder specificBuilder;

	public MappingGenericBuilderAdapter(IMappingBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public MappingGenericBuilderAdapter(IMappingBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case MappingFeatureDescriptorEnum.namespace_ord:
			specificBuilder.namespace();
			break;
		case MappingFeatureDescriptorEnum.schemaLocation_ord:
			specificBuilder.schemaLocation();
			break;
		case MappingFeatureDescriptorEnum.synthesized_ord:
			specificBuilder.synthesized();
			break;
		case MappingFeatureDescriptorEnum.elementsFormQualified_ord:
			specificBuilder.elementsFormQualified();
			break;
		case MappingFeatureDescriptorEnum.attributesFormQualified_ord:
			specificBuilder.attributesFormQualified();
			break;
		case MappingFeatureDescriptorEnum.mixedDataType_ord:
			specificBuilder.mixedDataType();
			break;
		case MappingFeatureDescriptorEnum.mixedTypes_ord:
			specificBuilder.mixedTypes();
			break;
		case MappingFeatureDescriptorEnum.mappings_ord:
			specificBuilder.mappings();
			break;
		case MappingFeatureDescriptorEnum.dataTypes_ord:
			specificBuilder.dataTypes();
			break;
		case MappingFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case MappingFeatureDescriptorEnum.entityType_ord:
			specificBuilder.entityType();
			break;
		case MappingFeatureDescriptorEnum.contextEntityType_ord:
			specificBuilder.contextEntityType();
			break;
		case MappingFeatureDescriptorEnum.featureType_ord:
			specificBuilder.featureType();
			break;
		case MappingFeatureDescriptorEnum.unionTypes_ord:
			specificBuilder.unionTypes();
			break;
		case MappingFeatureDescriptorEnum.enumValues_ord:
			specificBuilder.enumValues();
			break;
		case MappingFeatureDescriptorEnum.enumValue_ord:
			specificBuilder.enumValue();
			break;
		case MappingFeatureDescriptorEnum.value_ord:
			specificBuilder.value();
			break;
		case MappingFeatureDescriptorEnum.builtInType_ord:
			specificBuilder.builtInType();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case MappingEntityDescriptorEnum.MappingStrategy_ord:
			specificBuilder.MappingStrategy();
			break;
		case MappingEntityDescriptorEnum.Mappings_ord:
			specificBuilder.Mappings();
			break;
		case MappingEntityDescriptorEnum.Types_ord:
			specificBuilder.Types();
			break;
		case MappingEntityDescriptorEnum.RootMapping_ord:
			specificBuilder.RootMapping();
			break;
		case MappingEntityDescriptorEnum.ContentMapping_ord:
			specificBuilder.ContentMapping();
			break;
		case MappingEntityDescriptorEnum.MixedStructuralMapping_ord:
			specificBuilder.MixedStructuralMapping();
			break;
		case MappingEntityDescriptorEnum.AnyStructuralMapping_ord:
			specificBuilder.AnyStructuralMapping();
			break;
		case MappingEntityDescriptorEnum.AnyElementMapping_ord:
			specificBuilder.AnyElementMapping();
			break;
		case MappingEntityDescriptorEnum.AnyAttributeMapping_ord:
			specificBuilder.AnyAttributeMapping();
			break;
		case MappingEntityDescriptorEnum.StructuralMapping_ord:
			specificBuilder.StructuralMapping();
			break;
		case MappingEntityDescriptorEnum.ElementMapping_ord:
			specificBuilder.ElementMapping();
			break;
		case MappingEntityDescriptorEnum.AttributeMapping_ord:
			specificBuilder.AttributeMapping();
			break;
		case MappingEntityDescriptorEnum.UnionMapping_ord:
			specificBuilder.UnionMapping();
			break;
		case MappingEntityDescriptorEnum.DataTypes_ord:
			specificBuilder.DataTypes();
			break;
		case MappingEntityDescriptorEnum.EnumDataType_ord:
			specificBuilder.EnumDataType();
			break;
		case MappingEntityDescriptorEnum.EnumValues_ord:
			specificBuilder.EnumValues();
			break;
		case MappingEntityDescriptorEnum.EnumValue_ord:
			specificBuilder.EnumValue();
			break;
		case MappingEntityDescriptorEnum.CustomDataType_ord:
			specificBuilder.CustomDataType();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case MappingEntityDescriptorEnum.MappingStrategy_ord:
			specificBuilder.MappingStrategy_();
			break;
		case MappingEntityDescriptorEnum.Mappings_ord:
			specificBuilder.Mappings_();
			break;
		case MappingEntityDescriptorEnum.Types_ord:
			specificBuilder.Types_();
			break;
		case MappingEntityDescriptorEnum.RootMapping_ord:
			specificBuilder.RootMapping_();
			break;
		case MappingEntityDescriptorEnum.ContentMapping_ord:
			specificBuilder.ContentMapping_();
			break;
		case MappingEntityDescriptorEnum.MixedStructuralMapping_ord:
			specificBuilder.MixedStructuralMapping_();
			break;
		case MappingEntityDescriptorEnum.AnyStructuralMapping_ord:
			specificBuilder.AnyStructuralMapping_();
			break;
		case MappingEntityDescriptorEnum.AnyElementMapping_ord:
			specificBuilder.AnyElementMapping_();
			break;
		case MappingEntityDescriptorEnum.AnyAttributeMapping_ord:
			specificBuilder.AnyAttributeMapping_();
			break;
		case MappingEntityDescriptorEnum.StructuralMapping_ord:
			specificBuilder.StructuralMapping_();
			break;
		case MappingEntityDescriptorEnum.ElementMapping_ord:
			specificBuilder.ElementMapping_();
			break;
		case MappingEntityDescriptorEnum.AttributeMapping_ord:
			specificBuilder.AttributeMapping_();
			break;
		case MappingEntityDescriptorEnum.UnionMapping_ord:
			specificBuilder.UnionMapping_();
			break;
		case MappingEntityDescriptorEnum.DataTypes_ord:
			specificBuilder.DataTypes_();
			break;
		case MappingEntityDescriptorEnum.EnumDataType_ord:
			specificBuilder.EnumDataType_();
			break;
		case MappingEntityDescriptorEnum.EnumValues_ord:
			specificBuilder.EnumValues_();
			break;
		case MappingEntityDescriptorEnum.EnumValue_ord:
			specificBuilder.EnumValue_();
			break;
		case MappingEntityDescriptorEnum.CustomDataType_ord:
			specificBuilder.CustomDataType_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case MappingEntityDescriptorEnum.MappingStrategy_ord:
			specificBuilder._MappingStrategy();
			break;
		case MappingEntityDescriptorEnum.Mappings_ord:
			specificBuilder._Mappings();
			break;
		case MappingEntityDescriptorEnum.Types_ord:
			specificBuilder._Types();
			break;
		case MappingEntityDescriptorEnum.RootMapping_ord:
			specificBuilder._RootMapping();
			break;
		case MappingEntityDescriptorEnum.ContentMapping_ord:
			specificBuilder._ContentMapping();
			break;
		case MappingEntityDescriptorEnum.MixedStructuralMapping_ord:
			specificBuilder._MixedStructuralMapping();
			break;
		case MappingEntityDescriptorEnum.AnyStructuralMapping_ord:
			specificBuilder._AnyStructuralMapping();
			break;
		case MappingEntityDescriptorEnum.AnyElementMapping_ord:
			specificBuilder._AnyElementMapping();
			break;
		case MappingEntityDescriptorEnum.AnyAttributeMapping_ord:
			specificBuilder._AnyAttributeMapping();
			break;
		case MappingEntityDescriptorEnum.StructuralMapping_ord:
			specificBuilder._StructuralMapping();
			break;
		case MappingEntityDescriptorEnum.ElementMapping_ord:
			specificBuilder._ElementMapping();
			break;
		case MappingEntityDescriptorEnum.AttributeMapping_ord:
			specificBuilder._AttributeMapping();
			break;
		case MappingEntityDescriptorEnum.UnionMapping_ord:
			specificBuilder._UnionMapping();
			break;
		case MappingEntityDescriptorEnum.DataTypes_ord:
			specificBuilder._DataTypes();
			break;
		case MappingEntityDescriptorEnum.EnumDataType_ord:
			specificBuilder._EnumDataType();
			break;
		case MappingEntityDescriptorEnum.EnumValues_ord:
			specificBuilder._EnumValues();
			break;
		case MappingEntityDescriptorEnum.EnumValue_ord:
			specificBuilder._EnumValue();
			break;
		case MappingEntityDescriptorEnum.CustomDataType_ord:
			specificBuilder._CustomDataType();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case MappingEntityDescriptorEnum.Mappings_ord:
			specificBuilder.Mappings_(initialCapacity);
			break;
		case MappingEntityDescriptorEnum.Types_ord:
			specificBuilder.Types_(initialCapacity);
			break;
		case MappingEntityDescriptorEnum.DataTypes_ord:
			specificBuilder.DataTypes_(initialCapacity);
			break;
		case MappingEntityDescriptorEnum.EnumValues_ord:
			specificBuilder.EnumValues_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case MappingEntityDescriptorEnum.URI_ord:
			specificBuilder.URI(value);
			break;
		case MappingEntityDescriptorEnum.NCName_ord:
			specificBuilder.NCName(value);
			break;
		case MappingEntityDescriptorEnum.Value_ord:
			specificBuilder.Value(value);
			break;
		case MappingEntityDescriptorEnum.BuiltInType_ord:
			specificBuilder.BuiltInType(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
		switch (entityDesc.getOrdinal()) {
		case MappingEntityDescriptorEnum.BooleanType_ord:
			specificBuilder.BooleanType(value);
			break;
		}
	}
}
