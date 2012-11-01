package org.whole.lang.xsd.mapping.builders;

import org.whole.lang.builders.IBuilder;

/** 
 * @generator Whole
 */
public interface IMappingBuilder extends IBuilder {
	public void visit();

	public void builtInType();

	public void value();

	public void enumValue();

	public void enumValues();

	public void unionTypes();

	public void featureType();

	public void contextEntityType();

	public void entityType();

	public void name();

	public void dataTypes();

	public void mappings();

	public void mixedTypes();

	public void mixedDataType();

	public void attributesFormQualified();

	public void elementsFormQualified();

	public void synthesized();

	public void schemaLocation();

	public void namespace();

	public void MappingStrategy();

	public void MappingStrategy_();

	public void _MappingStrategy();

	public void Mappings();

	public void Mappings_();

	public void Mappings_(int initialCapacity);

	public void _Mappings();

	public void Types();

	public void Types_();

	public void Types_(int initialCapacity);

	public void _Types();

	public void RootMapping();

	public void RootMapping_();

	public void _RootMapping();

	public void ContentMapping();

	public void ContentMapping_();

	public void _ContentMapping();

	public void MixedStructuralMapping();

	public void MixedStructuralMapping_();

	public void _MixedStructuralMapping();

	public void AnyStructuralMapping();

	public void AnyStructuralMapping_();

	public void _AnyStructuralMapping();

	public void AnyElementMapping();

	public void AnyElementMapping_();

	public void _AnyElementMapping();

	public void AnyAttributeMapping();

	public void AnyAttributeMapping_();

	public void _AnyAttributeMapping();

	public void StructuralMapping();

	public void StructuralMapping_();

	public void _StructuralMapping();

	public void ElementMapping();

	public void ElementMapping_();

	public void _ElementMapping();

	public void AttributeMapping();

	public void AttributeMapping_();

	public void _AttributeMapping();

	public void UnionMapping();

	public void UnionMapping_();

	public void _UnionMapping();

	public void DataTypes();

	public void DataTypes_();

	public void DataTypes_(int initialCapacity);

	public void _DataTypes();

	public void EnumDataType();

	public void EnumDataType_();

	public void _EnumDataType();

	public void EnumValues();

	public void EnumValues_();

	public void EnumValues_(int initialCapacity);

	public void _EnumValues();

	public void EnumValue();

	public void EnumValue_();

	public void _EnumValue();

	public void CustomDataType();

	public void CustomDataType_();

	public void _CustomDataType();

	public void URI();

	public void URI(String value);

	public void BooleanType();

	public void BooleanType(boolean value);

	public void NCName();

	public void NCName(String value);

	public void Value();

	public void Value(String value);

	public void BuiltInType();

	public void BuiltInType(String value);
}
