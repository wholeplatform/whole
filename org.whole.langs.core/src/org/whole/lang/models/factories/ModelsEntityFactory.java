package org.whole.lang.models.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.models.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ModelsEntityFactory extends GenericEntityFactory {
	public static final ModelsEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static ModelsEntityFactory instance(IEntityRegistryProvider provider) {
		return new ModelsEntityFactory(provider);
	}

	protected ModelsEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Model createModel() {
		return create(ModelsEntityDescriptorEnum.Model);
	}

	public Model createModel(SimpleName name, TypeRelations typeRelations,
			ModelDeclarations declarations, Namespace namespace,
			Version version, URI uri) {
		return create(ModelsEntityDescriptorEnum.Model, name, typeRelations,
				declarations, namespace, version, uri);
	}

	public IEntityBuilder<Model> buildModel() {
		return new EntityBuilder<Model>(
				create(ModelsEntityDescriptorEnum.Model));
	}

	public ModelDeclarations createModelDeclarations() {
		return create(ModelsEntityDescriptorEnum.ModelDeclarations);
	}

	public ModelDeclarations createModelDeclarations(
			ModelDeclaration... entities) {
		return create(ModelsEntityDescriptorEnum.ModelDeclarations,
				(IEntity[]) entities);
	}

	public ModelDeclarations createModelDeclarations(int initialSize) {
		return clone(ModelsEntityDescriptorEnum.ModelDeclarations, initialSize);
	}

	public SimpleEntity createSimpleEntity() {
		return create(ModelsEntityDescriptorEnum.SimpleEntity);
	}

	public SimpleEntity createSimpleEntity(EntityModifiers modifiers,
			SimpleName name, Types types, Features features) {
		return create(ModelsEntityDescriptorEnum.SimpleEntity, modifiers, name,
				types, features);
	}

	public IEntityBuilder<SimpleEntity> buildSimpleEntity() {
		return new EntityBuilder<SimpleEntity>(
				create(ModelsEntityDescriptorEnum.SimpleEntity));
	}

	public CompositeEntity createCompositeEntity() {
		return create(ModelsEntityDescriptorEnum.CompositeEntity);
	}

	public CompositeEntity createCompositeEntity(EntityModifiers modifiers,
			SimpleName name, Types types,
			ComponentModifiers componentModifiers, Type componentType) {
		return create(ModelsEntityDescriptorEnum.CompositeEntity, modifiers,
				name, types, componentModifiers, componentType);
	}

	public IEntityBuilder<CompositeEntity> buildCompositeEntity() {
		return new EntityBuilder<CompositeEntity>(
				create(ModelsEntityDescriptorEnum.CompositeEntity));
	}

	public MapEntity createMapEntity() {
		return create(ModelsEntityDescriptorEnum.MapEntity);
	}

	public MapEntity createMapEntity(EntityModifiers modifiers,
			SimpleName name, Types types, Type keyType, Type valueType) {
		return create(ModelsEntityDescriptorEnum.MapEntity, modifiers, name,
				types, keyType, valueType);
	}

	public IEntityBuilder<MapEntity> buildMapEntity() {
		return new EntityBuilder<MapEntity>(
				create(ModelsEntityDescriptorEnum.MapEntity));
	}

	public DataEntity createDataEntity() {
		return create(ModelsEntityDescriptorEnum.DataEntity);
	}

	public DataEntity createDataEntity(EntityModifiers modifiers,
			SimpleName name, Types types, DataType dataType) {
		return create(ModelsEntityDescriptorEnum.DataEntity, modifiers, name,
				types, dataType);
	}

	public IEntityBuilder<DataEntity> buildDataEntity() {
		return new EntityBuilder<DataEntity>(
				create(ModelsEntityDescriptorEnum.DataEntity));
	}

	public EnumEntity createEnumEntity() {
		return create(ModelsEntityDescriptorEnum.EnumEntity);
	}

	public EnumEntity createEnumEntity(EntityModifiers modifiers,
			SimpleName name, Types types, EnumValues values) {
		return create(ModelsEntityDescriptorEnum.EnumEntity, modifiers, name,
				types, values);
	}

	public IEntityBuilder<EnumEntity> buildEnumEntity() {
		return new EntityBuilder<EnumEntity>(
				create(ModelsEntityDescriptorEnum.EnumEntity));
	}

	public EntityModifiers createEntityModifiers() {
		return create(ModelsEntityDescriptorEnum.EntityModifiers);
	}

	public EntityModifiers createEntityModifiers(EntityModifier... entities) {
		return create(ModelsEntityDescriptorEnum.EntityModifiers,
				(IEntity[]) entities);
	}

	public EntityModifiers createEntityModifiers(int initialSize) {
		return clone(ModelsEntityDescriptorEnum.EntityModifiers, initialSize);
	}

	public EntityModifier createEntityModifier() {
		return create(ModelsEntityDescriptorEnum.EntityModifier);
	}

	public EntityModifier createEntityModifier(EntityModifierEnum.Value value) {
		return create(ModelsEntityDescriptorEnum.EntityModifier, value);
	}

	public Features createFeatures() {
		return create(ModelsEntityDescriptorEnum.Features);
	}

	public Features createFeatures(Feature... entities) {
		return create(ModelsEntityDescriptorEnum.Features, (IEntity[]) entities);
	}

	public Features createFeatures(int initialSize) {
		return clone(ModelsEntityDescriptorEnum.Features, initialSize);
	}

	public Feature createFeature() {
		return create(ModelsEntityDescriptorEnum.Feature);
	}

	public Feature createFeature(FeatureModifiers modifiers, Type type,
			SimpleName name, SimpleName oppositeName) {
		return create(ModelsEntityDescriptorEnum.Feature, modifiers, type,
				name, oppositeName);
	}

	public IEntityBuilder<Feature> buildFeature() {
		return new EntityBuilder<Feature>(
				create(ModelsEntityDescriptorEnum.Feature));
	}

	public FeatureModifiers createFeatureModifiers() {
		return create(ModelsEntityDescriptorEnum.FeatureModifiers);
	}

	public FeatureModifiers createFeatureModifiers(FeatureModifier... entities) {
		return create(ModelsEntityDescriptorEnum.FeatureModifiers,
				(IEntity[]) entities);
	}

	public FeatureModifiers createFeatureModifiers(int initialSize) {
		return clone(ModelsEntityDescriptorEnum.FeatureModifiers, initialSize);
	}

	public FeatureModifier createFeatureModifier() {
		return create(ModelsEntityDescriptorEnum.FeatureModifier);
	}

	public FeatureModifier createFeatureModifier(FeatureModifierEnum.Value value) {
		return create(ModelsEntityDescriptorEnum.FeatureModifier, value);
	}

	public ComponentModifiers createComponentModifiers() {
		return create(ModelsEntityDescriptorEnum.ComponentModifiers);
	}

	public ComponentModifiers createComponentModifiers(
			ComponentModifier... entities) {
		return create(ModelsEntityDescriptorEnum.ComponentModifiers,
				(IEntity[]) entities);
	}

	public ComponentModifiers createComponentModifiers(int initialSize) {
		return clone(ModelsEntityDescriptorEnum.ComponentModifiers, initialSize);
	}

	public ComponentModifier createComponentModifier() {
		return create(ModelsEntityDescriptorEnum.ComponentModifier);
	}

	public ComponentModifier createComponentModifier(
			ComponentModifierEnum.Value value) {
		return create(ModelsEntityDescriptorEnum.ComponentModifier, value);
	}

	public DataType createDataType() {
		return create(ModelsEntityDescriptorEnum.DataType);
	}

	public DataType createDataType(String value) {
		return create(ModelsEntityDescriptorEnum.DataType, value);
	}

	public EnumValues createEnumValues() {
		return create(ModelsEntityDescriptorEnum.EnumValues);
	}

	public EnumValues createEnumValues(EnumValue... entities) {
		return create(ModelsEntityDescriptorEnum.EnumValues,
				(IEntity[]) entities);
	}

	public EnumValues createEnumValues(int initialSize) {
		return clone(ModelsEntityDescriptorEnum.EnumValues, initialSize);
	}

	public EnumValue createEnumValue() {
		return create(ModelsEntityDescriptorEnum.EnumValue);
	}

	public EnumValue createEnumValue(String value) {
		return create(ModelsEntityDescriptorEnum.EnumValue, value);
	}

	public Types createTypes() {
		return create(ModelsEntityDescriptorEnum.Types);
	}

	public Types createTypes(Type... entities) {
		return create(ModelsEntityDescriptorEnum.Types, (IEntity[]) entities);
	}

	public Types createTypes(int initialSize) {
		return clone(ModelsEntityDescriptorEnum.Types, initialSize);
	}

	public TypeRelations createTypeRelations() {
		return create(ModelsEntityDescriptorEnum.TypeRelations);
	}

	public TypeRelations createTypeRelations(TypeRelation... entities) {
		return create(ModelsEntityDescriptorEnum.TypeRelations,
				(IEntity[]) entities);
	}

	public TypeRelations createTypeRelations(int initialSize) {
		return clone(ModelsEntityDescriptorEnum.TypeRelations, initialSize);
	}

	public SupertypesOf createSupertypesOf() {
		return create(ModelsEntityDescriptorEnum.SupertypesOf);
	}

	public SupertypesOf createSupertypesOf(Types types, ForeignType foreignType) {
		return create(ModelsEntityDescriptorEnum.SupertypesOf, types,
				foreignType);
	}

	public IEntityBuilder<SupertypesOf> buildSupertypesOf() {
		return new EntityBuilder<SupertypesOf>(
				create(ModelsEntityDescriptorEnum.SupertypesOf));
	}

	public SubtypesOf createSubtypesOf() {
		return create(ModelsEntityDescriptorEnum.SubtypesOf);
	}

	public SubtypesOf createSubtypesOf(Types types, ForeignType foreignType) {
		return create(ModelsEntityDescriptorEnum.SubtypesOf, types, foreignType);
	}

	public IEntityBuilder<SubtypesOf> buildSubtypesOf() {
		return new EntityBuilder<SubtypesOf>(
				create(ModelsEntityDescriptorEnum.SubtypesOf));
	}

	public TypeAliasOf createTypeAliasOf() {
		return create(ModelsEntityDescriptorEnum.TypeAliasOf);
	}

	public TypeAliasOf createTypeAliasOf(Type type, EntityType foreignType) {
		return create(ModelsEntityDescriptorEnum.TypeAliasOf, type, foreignType);
	}

	public IEntityBuilder<TypeAliasOf> buildTypeAliasOf() {
		return new EntityBuilder<TypeAliasOf>(
				create(ModelsEntityDescriptorEnum.TypeAliasOf));
	}

	public AnyType createAnyType() {
		return create(ModelsEntityDescriptorEnum.AnyType);
	}

	public EntityType createEntityType() {
		return create(ModelsEntityDescriptorEnum.EntityType);
	}

	public EntityType createEntityType(String value) {
		return create(ModelsEntityDescriptorEnum.EntityType, value);
	}

	public SimpleName createSimpleName() {
		return create(ModelsEntityDescriptorEnum.SimpleName);
	}

	public SimpleName createSimpleName(String value) {
		return create(ModelsEntityDescriptorEnum.SimpleName, value);
	}

	public Namespace createNamespace() {
		return create(ModelsEntityDescriptorEnum.Namespace);
	}

	public Namespace createNamespace(String value) {
		return create(ModelsEntityDescriptorEnum.Namespace, value);
	}

	public Version createVersion() {
		return create(ModelsEntityDescriptorEnum.Version);
	}

	public Version createVersion(String value) {
		return create(ModelsEntityDescriptorEnum.Version, value);
	}

	public URI createURI() {
		return create(ModelsEntityDescriptorEnum.URI);
	}

	public URI createURI(String value) {
		return create(ModelsEntityDescriptorEnum.URI, value);
	}
}
