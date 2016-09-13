package org.whole.lang.models.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.models.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class ModelsEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int Model_ord = 0;
	public static final int ModelDeclarations_ord = 1;
	public static final int ModelDeclaration_ord = 2;
	public static final int SimpleEntity_ord = 3;
	public static final int CompositeEntity_ord = 4;
	public static final int MapEntity_ord = 5;
	public static final int DataEntity_ord = 6;
	public static final int EnumEntity_ord = 7;
	public static final int EntityModifiers_ord = 8;
	public static final int EntityModifier_ord = 9;
	public static final int Features_ord = 10;
	public static final int Feature_ord = 11;
	public static final int FeatureModifiers_ord = 12;
	public static final int FeatureModifier_ord = 13;
	public static final int ComponentModifiers_ord = 14;
	public static final int ComponentModifier_ord = 15;
	public static final int DataType_ord = 16;
	public static final int EnumValues_ord = 17;
	public static final int EnumValue_ord = 18;
	public static final int Types_ord = 19;
	public static final int TypeRelations_ord = 20;
	public static final int TypeRelation_ord = 21;
	public static final int SupertypesOf_ord = 22;
	public static final int SubtypesOf_ord = 23;
	public static final int TypeAliasOf_ord = 24;
	public static final int ForeignType_ord = 25;
	public static final int AnyType_ord = 26;
	public static final int EntityType_ord = 27;
	public static final int Type_ord = 28;
	public static final int SimpleName_ord = 29;
	public static final int Namespace_ord = 30;
	public static final int Version_ord = 31;
	public static final int URI_ord = 32;
	public static final ModelsEntityDescriptorEnum instance = new ModelsEntityDescriptorEnum();
	public static final EntityDescriptor<Model> Model = (EntityDescriptor<Model>) instance
			.valueOf(Model_ord);
	public static final EntityDescriptor<ModelDeclarations> ModelDeclarations = (EntityDescriptor<ModelDeclarations>) instance
			.valueOf(ModelDeclarations_ord);
	public static final EntityDescriptor<ModelDeclaration> ModelDeclaration = (EntityDescriptor<ModelDeclaration>) instance
			.valueOf(ModelDeclaration_ord);
	public static final EntityDescriptor<SimpleEntity> SimpleEntity = (EntityDescriptor<SimpleEntity>) instance
			.valueOf(SimpleEntity_ord);
	public static final EntityDescriptor<CompositeEntity> CompositeEntity = (EntityDescriptor<CompositeEntity>) instance
			.valueOf(CompositeEntity_ord);
	public static final EntityDescriptor<MapEntity> MapEntity = (EntityDescriptor<MapEntity>) instance
			.valueOf(MapEntity_ord);
	public static final EntityDescriptor<DataEntity> DataEntity = (EntityDescriptor<DataEntity>) instance
			.valueOf(DataEntity_ord);
	public static final EntityDescriptor<EnumEntity> EnumEntity = (EntityDescriptor<EnumEntity>) instance
			.valueOf(EnumEntity_ord);
	public static final EntityDescriptor<EntityModifiers> EntityModifiers = (EntityDescriptor<EntityModifiers>) instance
			.valueOf(EntityModifiers_ord);
	public static final EntityDescriptor<EntityModifier> EntityModifier = (EntityDescriptor<EntityModifier>) instance
			.valueOf(EntityModifier_ord);
	public static final EntityDescriptor<Features> Features = (EntityDescriptor<Features>) instance
			.valueOf(Features_ord);
	public static final EntityDescriptor<Feature> Feature = (EntityDescriptor<Feature>) instance
			.valueOf(Feature_ord);
	public static final EntityDescriptor<FeatureModifiers> FeatureModifiers = (EntityDescriptor<FeatureModifiers>) instance
			.valueOf(FeatureModifiers_ord);
	public static final EntityDescriptor<FeatureModifier> FeatureModifier = (EntityDescriptor<FeatureModifier>) instance
			.valueOf(FeatureModifier_ord);
	public static final EntityDescriptor<ComponentModifiers> ComponentModifiers = (EntityDescriptor<ComponentModifiers>) instance
			.valueOf(ComponentModifiers_ord);
	public static final EntityDescriptor<ComponentModifier> ComponentModifier = (EntityDescriptor<ComponentModifier>) instance
			.valueOf(ComponentModifier_ord);
	public static final EntityDescriptor<DataType> DataType = (EntityDescriptor<DataType>) instance
			.valueOf(DataType_ord);
	public static final EntityDescriptor<EnumValues> EnumValues = (EntityDescriptor<EnumValues>) instance
			.valueOf(EnumValues_ord);
	public static final EntityDescriptor<EnumValue> EnumValue = (EntityDescriptor<EnumValue>) instance
			.valueOf(EnumValue_ord);
	public static final EntityDescriptor<Types> Types = (EntityDescriptor<Types>) instance
			.valueOf(Types_ord);
	public static final EntityDescriptor<TypeRelations> TypeRelations = (EntityDescriptor<TypeRelations>) instance
			.valueOf(TypeRelations_ord);
	public static final EntityDescriptor<TypeRelation> TypeRelation = (EntityDescriptor<TypeRelation>) instance
			.valueOf(TypeRelation_ord);
	public static final EntityDescriptor<SupertypesOf> SupertypesOf = (EntityDescriptor<SupertypesOf>) instance
			.valueOf(SupertypesOf_ord);
	public static final EntityDescriptor<SubtypesOf> SubtypesOf = (EntityDescriptor<SubtypesOf>) instance
			.valueOf(SubtypesOf_ord);
	public static final EntityDescriptor<TypeAliasOf> TypeAliasOf = (EntityDescriptor<TypeAliasOf>) instance
			.valueOf(TypeAliasOf_ord);
	public static final EntityDescriptor<ForeignType> ForeignType = (EntityDescriptor<ForeignType>) instance
			.valueOf(ForeignType_ord);
	public static final EntityDescriptor<AnyType> AnyType = (EntityDescriptor<AnyType>) instance
			.valueOf(AnyType_ord);
	public static final EntityDescriptor<EntityType> EntityType = (EntityDescriptor<EntityType>) instance
			.valueOf(EntityType_ord);
	public static final EntityDescriptor<Type> Type = (EntityDescriptor<Type>) instance
			.valueOf(Type_ord);
	public static final EntityDescriptor<SimpleName> SimpleName = (EntityDescriptor<SimpleName>) instance
			.valueOf(SimpleName_ord);
	public static final EntityDescriptor<Namespace> Namespace = (EntityDescriptor<Namespace>) instance
			.valueOf(Namespace_ord);
	public static final EntityDescriptor<Version> Version = (EntityDescriptor<Version>) instance
			.valueOf(Version_ord);
	public static final EntityDescriptor<URI> URI = (EntityDescriptor<URI>) instance
			.valueOf(URI_ord);

	private ModelsEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(Model_ord, "Model", Model.class, false)
				.withFeature(ModelsFeatureDescriptorEnum.name, SimpleName_ord)
				.withFeature(ModelsFeatureDescriptorEnum.typeRelations,
						TypeRelations_ord, true, false, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.declarations,
						ModelDeclarations_ord)
				.withFeature(ModelsFeatureDescriptorEnum.namespace,
						Namespace_ord)
				.withFeature(ModelsFeatureDescriptorEnum.version, Version_ord,
						true, false, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.uri, URI_ord);
		putCompositeEntity(
		ModelDeclarations_ord, "ModelDeclarations", ModelDeclarations.class, false, ModelDeclaration_ord, true, false);
		putSimpleEntity(ModelDeclaration_ord, "ModelDeclaration",
				ModelDeclaration.class, true, EnumEntity_ord, SimpleEntity_ord,
				CompositeEntity_ord, MapEntity_ord, DataEntity_ord)
				.withFeature(ModelsFeatureDescriptorEnum.modifiers,
						EntityModifiers_ord, true, false, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.name, SimpleName_ord,
						false, true, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.types, Types_ord,
						true, false, false, false, false);
		putSimpleEntity(SimpleEntity_ord, "SimpleEntity", SimpleEntity.class,
				false)
				.withFeature(ModelsFeatureDescriptorEnum.modifiers,
						EntityModifiers_ord, true, false, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.name, SimpleName_ord,
						false, true, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.types, Types_ord,
						true, false, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.features,
						Features_ord, true, false, false, false, false);
		putSimpleEntity(CompositeEntity_ord, "CompositeEntity",
				CompositeEntity.class, false)
				.withFeature(ModelsFeatureDescriptorEnum.modifiers,
						EntityModifiers_ord, true, false, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.name, SimpleName_ord,
						false, true, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.types, Types_ord,
						true, false, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.componentModifiers,
						ComponentModifiers_ord, true, false, false, false,
						false)
				.withFeature(ModelsFeatureDescriptorEnum.componentType,
						Type_ord);
		putSimpleEntity(MapEntity_ord, "MapEntity", MapEntity.class, false)
				.withFeature(ModelsFeatureDescriptorEnum.modifiers,
						EntityModifiers_ord, true, false, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.name, SimpleName_ord,
						false, true, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.types, Types_ord,
						true, false, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.keyType, Type_ord)
				.withFeature(ModelsFeatureDescriptorEnum.valueType, Type_ord);
		putSimpleEntity(DataEntity_ord, "DataEntity", DataEntity.class, false)
				.withFeature(ModelsFeatureDescriptorEnum.modifiers,
						EntityModifiers_ord, true, false, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.name, SimpleName_ord,
						false, true, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.types, Types_ord,
						true, false, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.dataType, DataType_ord);
		putSimpleEntity(EnumEntity_ord, "EnumEntity", EnumEntity.class, false)
				.withFeature(ModelsFeatureDescriptorEnum.modifiers,
						EntityModifiers_ord, true, false, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.name, SimpleName_ord,
						false, true, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.types, Types_ord,
						true, false, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.values, EnumValues_ord);
		putCompositeEntity(
		EntityModifiers_ord, "EntityModifiers", EntityModifiers.class, false, EntityModifier_ord, false, true);
		putDataEntity(EntityModifier_ord, "EntityModifier",
				EntityModifier.class, false, EntityModifierEnum.Value.class);
		putCompositeEntity(
		Features_ord, "Features", Features.class, false, Feature_ord, true, false);
		putSimpleEntity(Feature_ord, "Feature", Feature.class, false)
				.withFeature(ModelsFeatureDescriptorEnum.modifiers,
						FeatureModifiers_ord, true, false, false, false, false)
				.withFeature(ModelsFeatureDescriptorEnum.type, Type_ord)
				.withFeature(ModelsFeatureDescriptorEnum.name, SimpleName_ord)
				.withFeature(ModelsFeatureDescriptorEnum.oppositeName,
						SimpleName_ord, true, false, false, false, false);
		putCompositeEntity(
		FeatureModifiers_ord, "FeatureModifiers", FeatureModifiers.class, false, FeatureModifier_ord, false, true);
		putDataEntity(FeatureModifier_ord, "FeatureModifier",
				FeatureModifier.class, false, FeatureModifierEnum.Value.class);
		putCompositeEntity(
		ComponentModifiers_ord, "ComponentModifiers", ComponentModifiers.class, false, ComponentModifier_ord, false, true);
		putDataEntity(ComponentModifier_ord, "ComponentModifier",
				ComponentModifier.class, false,
				ComponentModifierEnum.Value.class);
		putDataEntity(DataType_ord, "DataType", DataType.class, false,
				String.class);
		putCompositeEntity(
		EnumValues_ord, "EnumValues", EnumValues.class, false, EnumValue_ord, true, true);
		putDataEntity(EnumValue_ord, "EnumValue", EnumValue.class, false,
				String.class);
		putCompositeEntity(
		Types_ord, "Types", Types.class, false, Type_ord, true, false);
		putCompositeEntity(
		TypeRelations_ord, "TypeRelations", TypeRelations.class, false, TypeRelation_ord, true, false);
		putSimpleEntity(TypeRelation_ord, "TypeRelation", TypeRelation.class,
				true, SupertypesOf_ord, SubtypesOf_ord, TypeAliasOf_ord);
		putSimpleEntity(SupertypesOf_ord, "SupertypesOf", SupertypesOf.class,
				false)
				.withFeature(ModelsFeatureDescriptorEnum.types, Types_ord)
				.withFeature(ModelsFeatureDescriptorEnum.foreignType,
						ForeignType_ord);
		putSimpleEntity(SubtypesOf_ord, "SubtypesOf", SubtypesOf.class, false)
				.withFeature(ModelsFeatureDescriptorEnum.types, Types_ord)
				.withFeature(ModelsFeatureDescriptorEnum.foreignType,
						ForeignType_ord);
		putSimpleEntity(TypeAliasOf_ord, "TypeAliasOf", TypeAliasOf.class,
				false).withFeature(ModelsFeatureDescriptorEnum.type, Type_ord)
				.withFeature(ModelsFeatureDescriptorEnum.foreignType,
						EntityType_ord);
		putSimpleEntity(ForeignType_ord, "ForeignType", ForeignType.class,
				true, AnyType_ord, EntityType_ord);
		putSimpleEntity(AnyType_ord, "AnyType", AnyType.class, false);
		putDataEntity(EntityType_ord, "EntityType", EntityType.class, false,
				String.class);
		putSimpleEntity(Type_ord, "Type", Type.class, true, SimpleName_ord);
		putDataEntity(SimpleName_ord, "SimpleName", SimpleName.class, false,
				String.class);
		putDataEntity(Namespace_ord, "Namespace", Namespace.class, false,
				String.class);
		putDataEntity(Version_ord, "Version", Version.class, false,
				String.class);
		putDataEntity(URI_ord, "URI", URI.class, false, String.class);
	}
}
