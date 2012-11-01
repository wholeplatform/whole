package org.whole.lang.xsd.mapping.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.xsd.mapping.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.xsd.mapping.reflect.MappingEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class MappingEntityFactory extends GenericEntityFactory {
	public static final MappingEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static MappingEntityFactory instance(IEntityRegistryProvider provider) {
		return new MappingEntityFactory(provider);
	}

	protected MappingEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public MappingStrategy createMappingStrategy() {
		return create(MappingEntityDescriptorEnum.MappingStrategy);
	}

	public MappingStrategy createMappingStrategy(URI namespace,
			URI schemaLocation, BooleanType synthesized,
			BooleanType elementsFormQualified,
			BooleanType attributesFormQualified, URI mixedDataType,
			Types mixedTypes, Mappings mappings, DataTypes dataTypes) {
		return create(MappingEntityDescriptorEnum.MappingStrategy, namespace,
				schemaLocation, synthesized, elementsFormQualified,
				attributesFormQualified, mixedDataType, mixedTypes, mappings,
				dataTypes);
	}

	public IEntityBuilder<MappingStrategy> buildMappingStrategy() {
		return new EntityBuilder<MappingStrategy>(
				create(MappingEntityDescriptorEnum.MappingStrategy));
	}

	public Mappings createMappings() {
		return create(MappingEntityDescriptorEnum.Mappings);
	}

	public Mappings createMappings(Mapping... entities) {
		return create(MappingEntityDescriptorEnum.Mappings,
				(IEntity[]) entities);
	}

	public Mappings createMappings(int initialSize) {
		return clone(MappingEntityDescriptorEnum.Mappings, initialSize);
	}

	public Types createTypes() {
		return create(MappingEntityDescriptorEnum.Types);
	}

	public Types createTypes(URI... entities) {
		return create(MappingEntityDescriptorEnum.Types, (IEntity[]) entities);
	}

	public Types createTypes(int initialSize) {
		return clone(MappingEntityDescriptorEnum.Types, initialSize);
	}

	public RootMapping createRootMapping() {
		return create(MappingEntityDescriptorEnum.RootMapping);
	}

	public RootMapping createRootMapping(NCName name, URI entityType) {
		return create(MappingEntityDescriptorEnum.RootMapping, name, entityType);
	}

	public IEntityBuilder<RootMapping> buildRootMapping() {
		return new EntityBuilder<RootMapping>(
				create(MappingEntityDescriptorEnum.RootMapping));
	}

	public ContentMapping createContentMapping() {
		return create(MappingEntityDescriptorEnum.ContentMapping);
	}

	public ContentMapping createContentMapping(URI contextEntityType,
			URI entityType, URI featureType) {
		return create(MappingEntityDescriptorEnum.ContentMapping,
				contextEntityType, entityType, featureType);
	}

	public IEntityBuilder<ContentMapping> buildContentMapping() {
		return new EntityBuilder<ContentMapping>(
				create(MappingEntityDescriptorEnum.ContentMapping));
	}

	public MixedStructuralMapping createMixedStructuralMapping() {
		return create(MappingEntityDescriptorEnum.MixedStructuralMapping);
	}

	public MixedStructuralMapping createMixedStructuralMapping(
			URI contextEntityType, URI entityType, URI featureType) {
		return create(MappingEntityDescriptorEnum.MixedStructuralMapping,
				contextEntityType, entityType, featureType);
	}

	public IEntityBuilder<MixedStructuralMapping> buildMixedStructuralMapping() {
		return new EntityBuilder<MixedStructuralMapping>(
				create(MappingEntityDescriptorEnum.MixedStructuralMapping));
	}

	public AnyStructuralMapping createAnyStructuralMapping() {
		return create(MappingEntityDescriptorEnum.AnyStructuralMapping);
	}

	public AnyStructuralMapping createAnyStructuralMapping(
			URI contextEntityType, URI entityType, URI featureType) {
		return create(MappingEntityDescriptorEnum.AnyStructuralMapping,
				contextEntityType, entityType, featureType);
	}

	public IEntityBuilder<AnyStructuralMapping> buildAnyStructuralMapping() {
		return new EntityBuilder<AnyStructuralMapping>(
				create(MappingEntityDescriptorEnum.AnyStructuralMapping));
	}

	public AnyElementMapping createAnyElementMapping() {
		return create(MappingEntityDescriptorEnum.AnyElementMapping);
	}

	public AnyElementMapping createAnyElementMapping(URI contextEntityType,
			URI entityType, URI featureType) {
		return create(MappingEntityDescriptorEnum.AnyElementMapping,
				contextEntityType, entityType, featureType);
	}

	public IEntityBuilder<AnyElementMapping> buildAnyElementMapping() {
		return new EntityBuilder<AnyElementMapping>(
				create(MappingEntityDescriptorEnum.AnyElementMapping));
	}

	public AnyAttributeMapping createAnyAttributeMapping() {
		return create(MappingEntityDescriptorEnum.AnyAttributeMapping);
	}

	public AnyAttributeMapping createAnyAttributeMapping(URI contextEntityType,
			URI entityType, URI featureType) {
		return create(MappingEntityDescriptorEnum.AnyAttributeMapping,
				contextEntityType, entityType, featureType);
	}

	public IEntityBuilder<AnyAttributeMapping> buildAnyAttributeMapping() {
		return new EntityBuilder<AnyAttributeMapping>(
				create(MappingEntityDescriptorEnum.AnyAttributeMapping));
	}

	public StructuralMapping createStructuralMapping() {
		return create(MappingEntityDescriptorEnum.StructuralMapping);
	}

	public StructuralMapping createStructuralMapping(URI contextEntityType,
			NCName name, URI entityType, URI featureType) {
		return create(MappingEntityDescriptorEnum.StructuralMapping,
				contextEntityType, name, entityType, featureType);
	}

	public IEntityBuilder<StructuralMapping> buildStructuralMapping() {
		return new EntityBuilder<StructuralMapping>(
				create(MappingEntityDescriptorEnum.StructuralMapping));
	}

	public ElementMapping createElementMapping() {
		return create(MappingEntityDescriptorEnum.ElementMapping);
	}

	public ElementMapping createElementMapping(URI contextEntityType,
			NCName name, URI entityType, URI featureType) {
		return create(MappingEntityDescriptorEnum.ElementMapping,
				contextEntityType, name, entityType, featureType);
	}

	public IEntityBuilder<ElementMapping> buildElementMapping() {
		return new EntityBuilder<ElementMapping>(
				create(MappingEntityDescriptorEnum.ElementMapping));
	}

	public AttributeMapping createAttributeMapping() {
		return create(MappingEntityDescriptorEnum.AttributeMapping);
	}

	public AttributeMapping createAttributeMapping(URI contextEntityType,
			NCName name, URI entityType, URI featureType) {
		return create(MappingEntityDescriptorEnum.AttributeMapping,
				contextEntityType, name, entityType, featureType);
	}

	public IEntityBuilder<AttributeMapping> buildAttributeMapping() {
		return new EntityBuilder<AttributeMapping>(
				create(MappingEntityDescriptorEnum.AttributeMapping));
	}

	public UnionMapping createUnionMapping() {
		return create(MappingEntityDescriptorEnum.UnionMapping);
	}

	public UnionMapping createUnionMapping(URI contextEntityType,
			Types unionTypes) {
		return create(MappingEntityDescriptorEnum.UnionMapping,
				contextEntityType, unionTypes);
	}

	public IEntityBuilder<UnionMapping> buildUnionMapping() {
		return new EntityBuilder<UnionMapping>(
				create(MappingEntityDescriptorEnum.UnionMapping));
	}

	public DataTypes createDataTypes() {
		return create(MappingEntityDescriptorEnum.DataTypes);
	}

	public DataTypes createDataTypes(DataType... entities) {
		return create(MappingEntityDescriptorEnum.DataTypes,
				(IEntity[]) entities);
	}

	public DataTypes createDataTypes(int initialSize) {
		return clone(MappingEntityDescriptorEnum.DataTypes, initialSize);
	}

	public EnumDataType createEnumDataType() {
		return create(MappingEntityDescriptorEnum.EnumDataType);
	}

	public EnumDataType createEnumDataType(URI entityType, EnumValues enumValues) {
		return create(MappingEntityDescriptorEnum.EnumDataType, entityType,
				enumValues);
	}

	public IEntityBuilder<EnumDataType> buildEnumDataType() {
		return new EntityBuilder<EnumDataType>(
				create(MappingEntityDescriptorEnum.EnumDataType));
	}

	public EnumValues createEnumValues() {
		return create(MappingEntityDescriptorEnum.EnumValues);
	}

	public EnumValues createEnumValues(EnumValue... entities) {
		return create(MappingEntityDescriptorEnum.EnumValues,
				(IEntity[]) entities);
	}

	public EnumValues createEnumValues(int initialSize) {
		return clone(MappingEntityDescriptorEnum.EnumValues, initialSize);
	}

	public EnumValue createEnumValue() {
		return create(MappingEntityDescriptorEnum.EnumValue);
	}

	public EnumValue createEnumValue(Value enumValue, Value value) {
		return create(MappingEntityDescriptorEnum.EnumValue, enumValue, value);
	}

	public IEntityBuilder<EnumValue> buildEnumValue() {
		return new EntityBuilder<EnumValue>(
				create(MappingEntityDescriptorEnum.EnumValue));
	}

	public CustomDataType createCustomDataType() {
		return create(MappingEntityDescriptorEnum.CustomDataType);
	}

	public CustomDataType createCustomDataType(URI entityType,
			BuiltInType builtInType) {
		return create(MappingEntityDescriptorEnum.CustomDataType, entityType,
				builtInType);
	}

	public IEntityBuilder<CustomDataType> buildCustomDataType() {
		return new EntityBuilder<CustomDataType>(
				create(MappingEntityDescriptorEnum.CustomDataType));
	}

	public URI createURI() {
		return create(MappingEntityDescriptorEnum.URI);
	}

	public URI createURI(String value) {
		return create(MappingEntityDescriptorEnum.URI, value);
	}

	public BooleanType createBooleanType() {
		return create(MappingEntityDescriptorEnum.BooleanType);
	}

	public BooleanType createBooleanType(boolean value) {
		return create(MappingEntityDescriptorEnum.BooleanType, value);
	}

	public NCName createNCName() {
		return create(MappingEntityDescriptorEnum.NCName);
	}

	public NCName createNCName(String value) {
		return create(MappingEntityDescriptorEnum.NCName, value);
	}

	public Value createValue() {
		return create(MappingEntityDescriptorEnum.Value);
	}

	public Value createValue(String value) {
		return create(MappingEntityDescriptorEnum.Value, value);
	}

	public BuiltInType createBuiltInType() {
		return create(MappingEntityDescriptorEnum.BuiltInType);
	}

	public BuiltInType createBuiltInType(String value) {
		return create(MappingEntityDescriptorEnum.BuiltInType, value);
	}
}
