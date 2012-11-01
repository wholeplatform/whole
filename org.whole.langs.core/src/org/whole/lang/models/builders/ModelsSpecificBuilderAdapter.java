package org.whole.lang.models.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.models.reflect.ModelsFeatureDescriptorEnum;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.model.EntityModifierEnum;
import org.whole.lang.models.model.FeatureModifierEnum;
import org.whole.lang.models.model.ComponentModifierEnum;

/** 
 * @generator Whole
 */
public class ModelsSpecificBuilderAdapter extends GenericBuilderContext
		implements IModelsBuilder {
	public ModelsSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public ModelsSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void foreignType() {
		wFeature(ModelsFeatureDescriptorEnum.foreignType);
	}

	public void oppositeName() {
		wFeature(ModelsFeatureDescriptorEnum.oppositeName);
	}

	public void type() {
		wFeature(ModelsFeatureDescriptorEnum.type);
	}

	public void values() {
		wFeature(ModelsFeatureDescriptorEnum.values);
	}

	public void dataType() {
		wFeature(ModelsFeatureDescriptorEnum.dataType);
	}

	public void valueType() {
		wFeature(ModelsFeatureDescriptorEnum.valueType);
	}

	public void keyType() {
		wFeature(ModelsFeatureDescriptorEnum.keyType);
	}

	public void componentType() {
		wFeature(ModelsFeatureDescriptorEnum.componentType);
	}

	public void componentModifiers() {
		wFeature(ModelsFeatureDescriptorEnum.componentModifiers);
	}

	public void features() {
		wFeature(ModelsFeatureDescriptorEnum.features);
	}

	public void types() {
		wFeature(ModelsFeatureDescriptorEnum.types);
	}

	public void modifiers() {
		wFeature(ModelsFeatureDescriptorEnum.modifiers);
	}

	public void uri() {
		wFeature(ModelsFeatureDescriptorEnum.uri);
	}

	public void version() {
		wFeature(ModelsFeatureDescriptorEnum.version);
	}

	public void namespace() {
		wFeature(ModelsFeatureDescriptorEnum.namespace);
	}

	public void declarations() {
		wFeature(ModelsFeatureDescriptorEnum.declarations);
	}

	public void typeRelations() {
		wFeature(ModelsFeatureDescriptorEnum.typeRelations);
	}

	public void name() {
		wFeature(ModelsFeatureDescriptorEnum.name);
	}

	public void visit() {
	}

	public void Model() {
		wEntity(ModelsEntityDescriptorEnum.Model);
	}

	public void Model_() {
		wEntity_(ModelsEntityDescriptorEnum.Model);
	}

	public void _Model() {
		_wEntity(ModelsEntityDescriptorEnum.Model);
	}

	public void ModelDeclarations() {
		wEntity(ModelsEntityDescriptorEnum.ModelDeclarations);
	}

	public void ModelDeclarations_() {
		wEntity_(ModelsEntityDescriptorEnum.ModelDeclarations);
	}

	public void ModelDeclarations_(int initialCapacity) {
		wEntity_(ModelsEntityDescriptorEnum.ModelDeclarations, initialCapacity);
	}

	public void _ModelDeclarations() {
		_wEntity(ModelsEntityDescriptorEnum.ModelDeclarations);
	}

	public void SimpleEntity() {
		wEntity(ModelsEntityDescriptorEnum.SimpleEntity);
	}

	public void SimpleEntity_() {
		wEntity_(ModelsEntityDescriptorEnum.SimpleEntity);
	}

	public void _SimpleEntity() {
		_wEntity(ModelsEntityDescriptorEnum.SimpleEntity);
	}

	public void CompositeEntity() {
		wEntity(ModelsEntityDescriptorEnum.CompositeEntity);
	}

	public void CompositeEntity_() {
		wEntity_(ModelsEntityDescriptorEnum.CompositeEntity);
	}

	public void _CompositeEntity() {
		_wEntity(ModelsEntityDescriptorEnum.CompositeEntity);
	}

	public void MapEntity() {
		wEntity(ModelsEntityDescriptorEnum.MapEntity);
	}

	public void MapEntity_() {
		wEntity_(ModelsEntityDescriptorEnum.MapEntity);
	}

	public void _MapEntity() {
		_wEntity(ModelsEntityDescriptorEnum.MapEntity);
	}

	public void DataEntity() {
		wEntity(ModelsEntityDescriptorEnum.DataEntity);
	}

	public void DataEntity_() {
		wEntity_(ModelsEntityDescriptorEnum.DataEntity);
	}

	public void _DataEntity() {
		_wEntity(ModelsEntityDescriptorEnum.DataEntity);
	}

	public void EnumEntity() {
		wEntity(ModelsEntityDescriptorEnum.EnumEntity);
	}

	public void EnumEntity_() {
		wEntity_(ModelsEntityDescriptorEnum.EnumEntity);
	}

	public void _EnumEntity() {
		_wEntity(ModelsEntityDescriptorEnum.EnumEntity);
	}

	public void EntityModifiers() {
		wEntity(ModelsEntityDescriptorEnum.EntityModifiers);
	}

	public void EntityModifiers_() {
		wEntity_(ModelsEntityDescriptorEnum.EntityModifiers);
	}

	public void EntityModifiers_(int initialCapacity) {
		wEntity_(ModelsEntityDescriptorEnum.EntityModifiers, initialCapacity);
	}

	public void _EntityModifiers() {
		_wEntity(ModelsEntityDescriptorEnum.EntityModifiers);
	}

	public void EntityModifier() {
		wEntity(ModelsEntityDescriptorEnum.EntityModifier);
	}

	public void EntityModifier(EntityModifierEnum.Value value) {
		wEntity(ModelsEntityDescriptorEnum.EntityModifier, value);
	}

	public void EntityModifier(String value) {
		wEntity(ModelsEntityDescriptorEnum.EntityModifier, value);
	}

	public void Features() {
		wEntity(ModelsEntityDescriptorEnum.Features);
	}

	public void Features_() {
		wEntity_(ModelsEntityDescriptorEnum.Features);
	}

	public void Features_(int initialCapacity) {
		wEntity_(ModelsEntityDescriptorEnum.Features, initialCapacity);
	}

	public void _Features() {
		_wEntity(ModelsEntityDescriptorEnum.Features);
	}

	public void Feature() {
		wEntity(ModelsEntityDescriptorEnum.Feature);
	}

	public void Feature_() {
		wEntity_(ModelsEntityDescriptorEnum.Feature);
	}

	public void _Feature() {
		_wEntity(ModelsEntityDescriptorEnum.Feature);
	}

	public void FeatureModifiers() {
		wEntity(ModelsEntityDescriptorEnum.FeatureModifiers);
	}

	public void FeatureModifiers_() {
		wEntity_(ModelsEntityDescriptorEnum.FeatureModifiers);
	}

	public void FeatureModifiers_(int initialCapacity) {
		wEntity_(ModelsEntityDescriptorEnum.FeatureModifiers, initialCapacity);
	}

	public void _FeatureModifiers() {
		_wEntity(ModelsEntityDescriptorEnum.FeatureModifiers);
	}

	public void FeatureModifier() {
		wEntity(ModelsEntityDescriptorEnum.FeatureModifier);
	}

	public void FeatureModifier(FeatureModifierEnum.Value value) {
		wEntity(ModelsEntityDescriptorEnum.FeatureModifier, value);
	}

	public void FeatureModifier(String value) {
		wEntity(ModelsEntityDescriptorEnum.FeatureModifier, value);
	}

	public void ComponentModifiers() {
		wEntity(ModelsEntityDescriptorEnum.ComponentModifiers);
	}

	public void ComponentModifiers_() {
		wEntity_(ModelsEntityDescriptorEnum.ComponentModifiers);
	}

	public void ComponentModifiers_(int initialCapacity) {
		wEntity_(ModelsEntityDescriptorEnum.ComponentModifiers, initialCapacity);
	}

	public void _ComponentModifiers() {
		_wEntity(ModelsEntityDescriptorEnum.ComponentModifiers);
	}

	public void ComponentModifier() {
		wEntity(ModelsEntityDescriptorEnum.ComponentModifier);
	}

	public void ComponentModifier(ComponentModifierEnum.Value value) {
		wEntity(ModelsEntityDescriptorEnum.ComponentModifier, value);
	}

	public void ComponentModifier(String value) {
		wEntity(ModelsEntityDescriptorEnum.ComponentModifier, value);
	}

	public void DataType() {
		wEntity(ModelsEntityDescriptorEnum.DataType);
	}

	public void DataType(String value) {
		wEntity(ModelsEntityDescriptorEnum.DataType, value);
	}

	public void EnumValues() {
		wEntity(ModelsEntityDescriptorEnum.EnumValues);
	}

	public void EnumValues_() {
		wEntity_(ModelsEntityDescriptorEnum.EnumValues);
	}

	public void EnumValues_(int initialCapacity) {
		wEntity_(ModelsEntityDescriptorEnum.EnumValues, initialCapacity);
	}

	public void _EnumValues() {
		_wEntity(ModelsEntityDescriptorEnum.EnumValues);
	}

	public void EnumValue() {
		wEntity(ModelsEntityDescriptorEnum.EnumValue);
	}

	public void EnumValue(String value) {
		wEntity(ModelsEntityDescriptorEnum.EnumValue, value);
	}

	public void Types() {
		wEntity(ModelsEntityDescriptorEnum.Types);
	}

	public void Types_() {
		wEntity_(ModelsEntityDescriptorEnum.Types);
	}

	public void Types_(int initialCapacity) {
		wEntity_(ModelsEntityDescriptorEnum.Types, initialCapacity);
	}

	public void _Types() {
		_wEntity(ModelsEntityDescriptorEnum.Types);
	}

	public void TypeRelations() {
		wEntity(ModelsEntityDescriptorEnum.TypeRelations);
	}

	public void TypeRelations_() {
		wEntity_(ModelsEntityDescriptorEnum.TypeRelations);
	}

	public void TypeRelations_(int initialCapacity) {
		wEntity_(ModelsEntityDescriptorEnum.TypeRelations, initialCapacity);
	}

	public void _TypeRelations() {
		_wEntity(ModelsEntityDescriptorEnum.TypeRelations);
	}

	public void SupertypesOf() {
		wEntity(ModelsEntityDescriptorEnum.SupertypesOf);
	}

	public void SupertypesOf_() {
		wEntity_(ModelsEntityDescriptorEnum.SupertypesOf);
	}

	public void _SupertypesOf() {
		_wEntity(ModelsEntityDescriptorEnum.SupertypesOf);
	}

	public void SubtypesOf() {
		wEntity(ModelsEntityDescriptorEnum.SubtypesOf);
	}

	public void SubtypesOf_() {
		wEntity_(ModelsEntityDescriptorEnum.SubtypesOf);
	}

	public void _SubtypesOf() {
		_wEntity(ModelsEntityDescriptorEnum.SubtypesOf);
	}

	public void TypeAliasOf() {
		wEntity(ModelsEntityDescriptorEnum.TypeAliasOf);
	}

	public void TypeAliasOf_() {
		wEntity_(ModelsEntityDescriptorEnum.TypeAliasOf);
	}

	public void _TypeAliasOf() {
		_wEntity(ModelsEntityDescriptorEnum.TypeAliasOf);
	}

	public void AnyType() {
		wEntity(ModelsEntityDescriptorEnum.AnyType);
	}

	public void AnyType_() {
		wEntity_(ModelsEntityDescriptorEnum.AnyType);
	}

	public void _AnyType() {
		_wEntity(ModelsEntityDescriptorEnum.AnyType);
	}

	public void EntityType() {
		wEntity(ModelsEntityDescriptorEnum.EntityType);
	}

	public void EntityType(String value) {
		wEntity(ModelsEntityDescriptorEnum.EntityType, value);
	}

	public void SimpleName() {
		wEntity(ModelsEntityDescriptorEnum.SimpleName);
	}

	public void SimpleName(String value) {
		wEntity(ModelsEntityDescriptorEnum.SimpleName, value);
	}

	public void Namespace() {
		wEntity(ModelsEntityDescriptorEnum.Namespace);
	}

	public void Namespace(String value) {
		wEntity(ModelsEntityDescriptorEnum.Namespace, value);
	}

	public void Version() {
		wEntity(ModelsEntityDescriptorEnum.Version);
	}

	public void Version(String value) {
		wEntity(ModelsEntityDescriptorEnum.Version, value);
	}

	public void URI() {
		wEntity(ModelsEntityDescriptorEnum.URI);
	}

	public void URI(String value) {
		wEntity(ModelsEntityDescriptorEnum.URI, value);
	}
}
