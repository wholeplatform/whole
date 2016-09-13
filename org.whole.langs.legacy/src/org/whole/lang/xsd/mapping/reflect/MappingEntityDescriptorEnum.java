package org.whole.lang.xsd.mapping.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.mapping.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class MappingEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int MappingStrategy_ord = 0;
	public static final int Mappings_ord = 1;
	public static final int Types_ord = 2;
	public static final int Mapping_ord = 3;
	public static final int RootMapping_ord = 4;
	public static final int ContextMapping_ord = 5;
	public static final int ContentMapping_ord = 6;
	public static final int MixedStructuralMapping_ord = 7;
	public static final int AnyMapping_ord = 8;
	public static final int AnyStructuralMapping_ord = 9;
	public static final int AnyElementMapping_ord = 10;
	public static final int AnyAttributeMapping_ord = 11;
	public static final int TypeMapping_ord = 12;
	public static final int StructuralMapping_ord = 13;
	public static final int ElementMapping_ord = 14;
	public static final int AttributeMapping_ord = 15;
	public static final int UnionMapping_ord = 16;
	public static final int DataTypes_ord = 17;
	public static final int DataType_ord = 18;
	public static final int EnumDataType_ord = 19;
	public static final int EnumValues_ord = 20;
	public static final int EnumValue_ord = 21;
	public static final int CustomDataType_ord = 22;
	public static final int URI_ord = 23;
	public static final int BooleanType_ord = 24;
	public static final int NCName_ord = 25;
	public static final int Value_ord = 26;
	public static final int BuiltInType_ord = 27;
	public static final MappingEntityDescriptorEnum instance = new MappingEntityDescriptorEnum();
	public static final EntityDescriptor<MappingStrategy> MappingStrategy = (EntityDescriptor<MappingStrategy>) instance
			.valueOf(MappingStrategy_ord);
	public static final EntityDescriptor<Mappings> Mappings = (EntityDescriptor<Mappings>) instance
			.valueOf(Mappings_ord);
	public static final EntityDescriptor<Types> Types = (EntityDescriptor<Types>) instance
			.valueOf(Types_ord);
	public static final EntityDescriptor<Mapping> Mapping = (EntityDescriptor<Mapping>) instance
			.valueOf(Mapping_ord);
	public static final EntityDescriptor<RootMapping> RootMapping = (EntityDescriptor<RootMapping>) instance
			.valueOf(RootMapping_ord);
	public static final EntityDescriptor<ContextMapping> ContextMapping = (EntityDescriptor<ContextMapping>) instance
			.valueOf(ContextMapping_ord);
	public static final EntityDescriptor<ContentMapping> ContentMapping = (EntityDescriptor<ContentMapping>) instance
			.valueOf(ContentMapping_ord);
	public static final EntityDescriptor<MixedStructuralMapping> MixedStructuralMapping = (EntityDescriptor<MixedStructuralMapping>) instance
			.valueOf(MixedStructuralMapping_ord);
	public static final EntityDescriptor<AnyMapping> AnyMapping = (EntityDescriptor<AnyMapping>) instance
			.valueOf(AnyMapping_ord);
	public static final EntityDescriptor<AnyStructuralMapping> AnyStructuralMapping = (EntityDescriptor<AnyStructuralMapping>) instance
			.valueOf(AnyStructuralMapping_ord);
	public static final EntityDescriptor<AnyElementMapping> AnyElementMapping = (EntityDescriptor<AnyElementMapping>) instance
			.valueOf(AnyElementMapping_ord);
	public static final EntityDescriptor<AnyAttributeMapping> AnyAttributeMapping = (EntityDescriptor<AnyAttributeMapping>) instance
			.valueOf(AnyAttributeMapping_ord);
	public static final EntityDescriptor<TypeMapping> TypeMapping = (EntityDescriptor<TypeMapping>) instance
			.valueOf(TypeMapping_ord);
	public static final EntityDescriptor<StructuralMapping> StructuralMapping = (EntityDescriptor<StructuralMapping>) instance
			.valueOf(StructuralMapping_ord);
	public static final EntityDescriptor<ElementMapping> ElementMapping = (EntityDescriptor<ElementMapping>) instance
			.valueOf(ElementMapping_ord);
	public static final EntityDescriptor<AttributeMapping> AttributeMapping = (EntityDescriptor<AttributeMapping>) instance
			.valueOf(AttributeMapping_ord);
	public static final EntityDescriptor<UnionMapping> UnionMapping = (EntityDescriptor<UnionMapping>) instance
			.valueOf(UnionMapping_ord);
	public static final EntityDescriptor<DataTypes> DataTypes = (EntityDescriptor<DataTypes>) instance
			.valueOf(DataTypes_ord);
	public static final EntityDescriptor<DataType> DataType = (EntityDescriptor<DataType>) instance
			.valueOf(DataType_ord);
	public static final EntityDescriptor<EnumDataType> EnumDataType = (EntityDescriptor<EnumDataType>) instance
			.valueOf(EnumDataType_ord);
	public static final EntityDescriptor<EnumValues> EnumValues = (EntityDescriptor<EnumValues>) instance
			.valueOf(EnumValues_ord);
	public static final EntityDescriptor<EnumValue> EnumValue = (EntityDescriptor<EnumValue>) instance
			.valueOf(EnumValue_ord);
	public static final EntityDescriptor<CustomDataType> CustomDataType = (EntityDescriptor<CustomDataType>) instance
			.valueOf(CustomDataType_ord);
	public static final EntityDescriptor<URI> URI = (EntityDescriptor<URI>) instance
			.valueOf(URI_ord);
	public static final EntityDescriptor<BooleanType> BooleanType = (EntityDescriptor<BooleanType>) instance
			.valueOf(BooleanType_ord);
	public static final EntityDescriptor<NCName> NCName = (EntityDescriptor<NCName>) instance
			.valueOf(NCName_ord);
	public static final EntityDescriptor<Value> Value = (EntityDescriptor<Value>) instance
			.valueOf(Value_ord);
	public static final EntityDescriptor<BuiltInType> BuiltInType = (EntityDescriptor<BuiltInType>) instance
			.valueOf(BuiltInType_ord);

	private MappingEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(MappingStrategy_ord, "MappingStrategy",
				MappingStrategy.class, false)
				.withFeature(MappingFeatureDescriptorEnum.namespace, URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.schemaLocation,
						URI_ord, true, false, false, false, false)
				.withFeature(MappingFeatureDescriptorEnum.synthesized,
						BooleanType_ord)
				.withFeature(
						MappingFeatureDescriptorEnum.elementsFormQualified,
						BooleanType_ord)
				.withFeature(
						MappingFeatureDescriptorEnum.attributesFormQualified,
						BooleanType_ord)
				.withFeature(MappingFeatureDescriptorEnum.mixedDataType,
						URI_ord, true, false, false, false, false)
				.withFeature(MappingFeatureDescriptorEnum.mixedTypes,
						Types_ord, true, false, false, false, false)
				.withFeature(MappingFeatureDescriptorEnum.mappings,
						Mappings_ord)
				.withFeature(MappingFeatureDescriptorEnum.dataTypes,
						DataTypes_ord);
		putCompositeEntity(
		Mappings_ord, "Mappings", Mappings.class, false, Mapping_ord, false, false);
		putCompositeEntity(
		Types_ord, "Types", Types.class, false, URI_ord, false, true);
		putSimpleEntity(Mapping_ord, "Mapping", Mapping.class, true,
				MixedStructuralMapping_ord, TypeMapping_ord,
				ElementMapping_ord, StructuralMapping_ord,
				AttributeMapping_ord, AnyMapping_ord, UnionMapping_ord,
				ContextMapping_ord, RootMapping_ord, AnyAttributeMapping_ord,
				AnyElementMapping_ord, AnyStructuralMapping_ord,
				ContentMapping_ord);
		putSimpleEntity(RootMapping_ord, "RootMapping", RootMapping.class,
				false).withFeature(MappingFeatureDescriptorEnum.name,
				NCName_ord).withFeature(
				MappingFeatureDescriptorEnum.entityType, URI_ord);
		putSimpleEntity(ContextMapping_ord, "ContextMapping",
				ContextMapping.class, true, MixedStructuralMapping_ord,
				TypeMapping_ord, ElementMapping_ord, StructuralMapping_ord,
				AttributeMapping_ord, AnyAttributeMapping_ord, AnyMapping_ord,
				AnyElementMapping_ord, UnionMapping_ord, ContentMapping_ord,
				AnyStructuralMapping_ord).withFeature(
				MappingFeatureDescriptorEnum.contextEntityType, URI_ord);
		putSimpleEntity(ContentMapping_ord, "ContentMapping",
				ContentMapping.class, false)
				.withFeature(MappingFeatureDescriptorEnum.contextEntityType,
						URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.entityType, URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.featureType, URI_ord,
						true, false, false, false, false);
		putSimpleEntity(MixedStructuralMapping_ord, "MixedStructuralMapping",
				MixedStructuralMapping.class, false)
				.withFeature(MappingFeatureDescriptorEnum.contextEntityType,
						URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.entityType, URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.featureType, URI_ord,
						true, false, false, false, false);
		putSimpleEntity(AnyMapping_ord, "AnyMapping", AnyMapping.class, true,
				AnyAttributeMapping_ord, AnyStructuralMapping_ord,
				AnyElementMapping_ord)
				.withFeature(MappingFeatureDescriptorEnum.contextEntityType,
						URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.entityType, URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.featureType, URI_ord,
						true, false, false, false, false);
		putSimpleEntity(AnyStructuralMapping_ord, "AnyStructuralMapping",
				AnyStructuralMapping.class, false)
				.withFeature(MappingFeatureDescriptorEnum.contextEntityType,
						URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.entityType, URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.featureType, URI_ord,
						true, false, false, false, false);
		putSimpleEntity(AnyElementMapping_ord, "AnyElementMapping",
				AnyElementMapping.class, false)
				.withFeature(MappingFeatureDescriptorEnum.contextEntityType,
						URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.entityType, URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.featureType, URI_ord,
						true, false, false, false, false);
		putSimpleEntity(AnyAttributeMapping_ord, "AnyAttributeMapping",
				AnyAttributeMapping.class, false)
				.withFeature(MappingFeatureDescriptorEnum.contextEntityType,
						URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.entityType, URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.featureType, URI_ord,
						true, false, false, false, false);
		putSimpleEntity(TypeMapping_ord, "TypeMapping", TypeMapping.class,
				true, StructuralMapping_ord, AttributeMapping_ord,
				ElementMapping_ord)
				.withFeature(MappingFeatureDescriptorEnum.contextEntityType,
						URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.name, NCName_ord)
				.withFeature(MappingFeatureDescriptorEnum.entityType, URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.featureType, URI_ord,
						true, false, false, false, false);
		putSimpleEntity(StructuralMapping_ord, "StructuralMapping",
				StructuralMapping.class, false)
				.withFeature(MappingFeatureDescriptorEnum.contextEntityType,
						URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.name, NCName_ord)
				.withFeature(MappingFeatureDescriptorEnum.entityType, URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.featureType, URI_ord,
						true, false, false, false, false);
		putSimpleEntity(ElementMapping_ord, "ElementMapping",
				ElementMapping.class, false)
				.withFeature(MappingFeatureDescriptorEnum.contextEntityType,
						URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.name, NCName_ord)
				.withFeature(MappingFeatureDescriptorEnum.entityType, URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.featureType, URI_ord,
						true, false, false, false, false);
		putSimpleEntity(AttributeMapping_ord, "AttributeMapping",
				AttributeMapping.class, false)
				.withFeature(MappingFeatureDescriptorEnum.contextEntityType,
						URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.name, NCName_ord)
				.withFeature(MappingFeatureDescriptorEnum.entityType, URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.featureType, URI_ord,
						true, false, false, false, false);
		putSimpleEntity(UnionMapping_ord, "UnionMapping", UnionMapping.class,
				false)
				.withFeature(MappingFeatureDescriptorEnum.contextEntityType,
						URI_ord)
				.withFeature(MappingFeatureDescriptorEnum.unionTypes, Types_ord);
		putCompositeEntity(
		DataTypes_ord, "DataTypes", DataTypes.class, false, DataType_ord, false, false);
		putSimpleEntity(DataType_ord, "DataType", DataType.class, true,
				CustomDataType_ord, EnumDataType_ord).withFeature(
				MappingFeatureDescriptorEnum.entityType, URI_ord);
		putSimpleEntity(EnumDataType_ord, "EnumDataType", EnumDataType.class,
				false).withFeature(MappingFeatureDescriptorEnum.entityType,
				URI_ord).withFeature(MappingFeatureDescriptorEnum.enumValues,
				EnumValues_ord);
		putCompositeEntity(
		EnumValues_ord, "EnumValues", EnumValues.class, false, EnumValue_ord, false, false);
		putSimpleEntity(EnumValue_ord, "EnumValue", EnumValue.class, false)
				.withFeature(MappingFeatureDescriptorEnum.enumValue, Value_ord)
				.withFeature(MappingFeatureDescriptorEnum.value, Value_ord);
		putSimpleEntity(CustomDataType_ord, "CustomDataType",
				CustomDataType.class, false).withFeature(
				MappingFeatureDescriptorEnum.entityType, URI_ord).withFeature(
				MappingFeatureDescriptorEnum.builtInType, BuiltInType_ord);
		putDataEntity(URI_ord, "URI", URI.class, false, String.class);
		putDataEntity(BooleanType_ord, "BooleanType", BooleanType.class, false,
				boolean.class);
		putDataEntity(NCName_ord, "NCName", NCName.class, false, String.class);
		putDataEntity(Value_ord, "Value", Value.class, false, String.class);
		putDataEntity(BuiltInType_ord, "BuiltInType", BuiltInType.class, false,
				String.class);
	}
}
