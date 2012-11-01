package org.whole.lang.xsd.mapping.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.xsd.mapping.reflect.MappingFeatureDescriptorEnum;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class MappingSpecificBuilderAdapter extends GenericBuilderContext
		implements IMappingBuilder {
	public MappingSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public MappingSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void builtInType() {
		wFeature(MappingFeatureDescriptorEnum.builtInType);
	}

	public void value() {
		wFeature(MappingFeatureDescriptorEnum.value);
	}

	public void enumValue() {
		wFeature(MappingFeatureDescriptorEnum.enumValue);
	}

	public void enumValues() {
		wFeature(MappingFeatureDescriptorEnum.enumValues);
	}

	public void unionTypes() {
		wFeature(MappingFeatureDescriptorEnum.unionTypes);
	}

	public void featureType() {
		wFeature(MappingFeatureDescriptorEnum.featureType);
	}

	public void contextEntityType() {
		wFeature(MappingFeatureDescriptorEnum.contextEntityType);
	}

	public void entityType() {
		wFeature(MappingFeatureDescriptorEnum.entityType);
	}

	public void name() {
		wFeature(MappingFeatureDescriptorEnum.name);
	}

	public void dataTypes() {
		wFeature(MappingFeatureDescriptorEnum.dataTypes);
	}

	public void mappings() {
		wFeature(MappingFeatureDescriptorEnum.mappings);
	}

	public void mixedTypes() {
		wFeature(MappingFeatureDescriptorEnum.mixedTypes);
	}

	public void mixedDataType() {
		wFeature(MappingFeatureDescriptorEnum.mixedDataType);
	}

	public void attributesFormQualified() {
		wFeature(MappingFeatureDescriptorEnum.attributesFormQualified);
	}

	public void elementsFormQualified() {
		wFeature(MappingFeatureDescriptorEnum.elementsFormQualified);
	}

	public void synthesized() {
		wFeature(MappingFeatureDescriptorEnum.synthesized);
	}

	public void schemaLocation() {
		wFeature(MappingFeatureDescriptorEnum.schemaLocation);
	}

	public void namespace() {
		wFeature(MappingFeatureDescriptorEnum.namespace);
	}

	public void visit() {
	}

	public void MappingStrategy() {
		wEntity(MappingEntityDescriptorEnum.MappingStrategy);
	}

	public void MappingStrategy_() {
		wEntity_(MappingEntityDescriptorEnum.MappingStrategy);
	}

	public void _MappingStrategy() {
		_wEntity(MappingEntityDescriptorEnum.MappingStrategy);
	}

	public void Mappings() {
		wEntity(MappingEntityDescriptorEnum.Mappings);
	}

	public void Mappings_() {
		wEntity_(MappingEntityDescriptorEnum.Mappings);
	}

	public void Mappings_(int initialCapacity) {
		wEntity_(MappingEntityDescriptorEnum.Mappings, initialCapacity);
	}

	public void _Mappings() {
		_wEntity(MappingEntityDescriptorEnum.Mappings);
	}

	public void Types() {
		wEntity(MappingEntityDescriptorEnum.Types);
	}

	public void Types_() {
		wEntity_(MappingEntityDescriptorEnum.Types);
	}

	public void Types_(int initialCapacity) {
		wEntity_(MappingEntityDescriptorEnum.Types, initialCapacity);
	}

	public void _Types() {
		_wEntity(MappingEntityDescriptorEnum.Types);
	}

	public void RootMapping() {
		wEntity(MappingEntityDescriptorEnum.RootMapping);
	}

	public void RootMapping_() {
		wEntity_(MappingEntityDescriptorEnum.RootMapping);
	}

	public void _RootMapping() {
		_wEntity(MappingEntityDescriptorEnum.RootMapping);
	}

	public void ContentMapping() {
		wEntity(MappingEntityDescriptorEnum.ContentMapping);
	}

	public void ContentMapping_() {
		wEntity_(MappingEntityDescriptorEnum.ContentMapping);
	}

	public void _ContentMapping() {
		_wEntity(MappingEntityDescriptorEnum.ContentMapping);
	}

	public void MixedStructuralMapping() {
		wEntity(MappingEntityDescriptorEnum.MixedStructuralMapping);
	}

	public void MixedStructuralMapping_() {
		wEntity_(MappingEntityDescriptorEnum.MixedStructuralMapping);
	}

	public void _MixedStructuralMapping() {
		_wEntity(MappingEntityDescriptorEnum.MixedStructuralMapping);
	}

	public void AnyStructuralMapping() {
		wEntity(MappingEntityDescriptorEnum.AnyStructuralMapping);
	}

	public void AnyStructuralMapping_() {
		wEntity_(MappingEntityDescriptorEnum.AnyStructuralMapping);
	}

	public void _AnyStructuralMapping() {
		_wEntity(MappingEntityDescriptorEnum.AnyStructuralMapping);
	}

	public void AnyElementMapping() {
		wEntity(MappingEntityDescriptorEnum.AnyElementMapping);
	}

	public void AnyElementMapping_() {
		wEntity_(MappingEntityDescriptorEnum.AnyElementMapping);
	}

	public void _AnyElementMapping() {
		_wEntity(MappingEntityDescriptorEnum.AnyElementMapping);
	}

	public void AnyAttributeMapping() {
		wEntity(MappingEntityDescriptorEnum.AnyAttributeMapping);
	}

	public void AnyAttributeMapping_() {
		wEntity_(MappingEntityDescriptorEnum.AnyAttributeMapping);
	}

	public void _AnyAttributeMapping() {
		_wEntity(MappingEntityDescriptorEnum.AnyAttributeMapping);
	}

	public void StructuralMapping() {
		wEntity(MappingEntityDescriptorEnum.StructuralMapping);
	}

	public void StructuralMapping_() {
		wEntity_(MappingEntityDescriptorEnum.StructuralMapping);
	}

	public void _StructuralMapping() {
		_wEntity(MappingEntityDescriptorEnum.StructuralMapping);
	}

	public void ElementMapping() {
		wEntity(MappingEntityDescriptorEnum.ElementMapping);
	}

	public void ElementMapping_() {
		wEntity_(MappingEntityDescriptorEnum.ElementMapping);
	}

	public void _ElementMapping() {
		_wEntity(MappingEntityDescriptorEnum.ElementMapping);
	}

	public void AttributeMapping() {
		wEntity(MappingEntityDescriptorEnum.AttributeMapping);
	}

	public void AttributeMapping_() {
		wEntity_(MappingEntityDescriptorEnum.AttributeMapping);
	}

	public void _AttributeMapping() {
		_wEntity(MappingEntityDescriptorEnum.AttributeMapping);
	}

	public void UnionMapping() {
		wEntity(MappingEntityDescriptorEnum.UnionMapping);
	}

	public void UnionMapping_() {
		wEntity_(MappingEntityDescriptorEnum.UnionMapping);
	}

	public void _UnionMapping() {
		_wEntity(MappingEntityDescriptorEnum.UnionMapping);
	}

	public void DataTypes() {
		wEntity(MappingEntityDescriptorEnum.DataTypes);
	}

	public void DataTypes_() {
		wEntity_(MappingEntityDescriptorEnum.DataTypes);
	}

	public void DataTypes_(int initialCapacity) {
		wEntity_(MappingEntityDescriptorEnum.DataTypes, initialCapacity);
	}

	public void _DataTypes() {
		_wEntity(MappingEntityDescriptorEnum.DataTypes);
	}

	public void EnumDataType() {
		wEntity(MappingEntityDescriptorEnum.EnumDataType);
	}

	public void EnumDataType_() {
		wEntity_(MappingEntityDescriptorEnum.EnumDataType);
	}

	public void _EnumDataType() {
		_wEntity(MappingEntityDescriptorEnum.EnumDataType);
	}

	public void EnumValues() {
		wEntity(MappingEntityDescriptorEnum.EnumValues);
	}

	public void EnumValues_() {
		wEntity_(MappingEntityDescriptorEnum.EnumValues);
	}

	public void EnumValues_(int initialCapacity) {
		wEntity_(MappingEntityDescriptorEnum.EnumValues, initialCapacity);
	}

	public void _EnumValues() {
		_wEntity(MappingEntityDescriptorEnum.EnumValues);
	}

	public void EnumValue() {
		wEntity(MappingEntityDescriptorEnum.EnumValue);
	}

	public void EnumValue_() {
		wEntity_(MappingEntityDescriptorEnum.EnumValue);
	}

	public void _EnumValue() {
		_wEntity(MappingEntityDescriptorEnum.EnumValue);
	}

	public void CustomDataType() {
		wEntity(MappingEntityDescriptorEnum.CustomDataType);
	}

	public void CustomDataType_() {
		wEntity_(MappingEntityDescriptorEnum.CustomDataType);
	}

	public void _CustomDataType() {
		_wEntity(MappingEntityDescriptorEnum.CustomDataType);
	}

	public void URI() {
		wEntity(MappingEntityDescriptorEnum.URI);
	}

	public void URI(String value) {
		wEntity(MappingEntityDescriptorEnum.URI, value);
	}

	public void BooleanType() {
		wEntity(MappingEntityDescriptorEnum.BooleanType);
	}

	public void BooleanType(boolean value) {
		wEntity(MappingEntityDescriptorEnum.BooleanType, value);
	}

	public void NCName() {
		wEntity(MappingEntityDescriptorEnum.NCName);
	}

	public void NCName(String value) {
		wEntity(MappingEntityDescriptorEnum.NCName, value);
	}

	public void Value() {
		wEntity(MappingEntityDescriptorEnum.Value);
	}

	public void Value(String value) {
		wEntity(MappingEntityDescriptorEnum.Value, value);
	}

	public void BuiltInType() {
		wEntity(MappingEntityDescriptorEnum.BuiltInType);
	}

	public void BuiltInType(String value) {
		wEntity(MappingEntityDescriptorEnum.BuiltInType, value);
	}
}
