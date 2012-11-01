package org.whole.lang.models.builders;

import org.whole.lang.builders.IBuilder;
import org.whole.lang.models.model.EntityModifierEnum;
import org.whole.lang.models.model.FeatureModifierEnum;
import org.whole.lang.models.model.ComponentModifierEnum;

/** 
 * @generator Whole
 */
public interface IModelsBuilder extends IBuilder {
	public void visit();

	public void foreignType();

	public void oppositeName();

	public void type();

	public void values();

	public void dataType();

	public void valueType();

	public void keyType();

	public void componentType();

	public void componentModifiers();

	public void features();

	public void types();

	public void modifiers();

	public void uri();

	public void version();

	public void namespace();

	public void declarations();

	public void typeRelations();

	public void name();

	public void Model();

	public void Model_();

	public void _Model();

	public void ModelDeclarations();

	public void ModelDeclarations_();

	public void ModelDeclarations_(int initialCapacity);

	public void _ModelDeclarations();

	public void SimpleEntity();

	public void SimpleEntity_();

	public void _SimpleEntity();

	public void CompositeEntity();

	public void CompositeEntity_();

	public void _CompositeEntity();

	public void MapEntity();

	public void MapEntity_();

	public void _MapEntity();

	public void DataEntity();

	public void DataEntity_();

	public void _DataEntity();

	public void EnumEntity();

	public void EnumEntity_();

	public void _EnumEntity();

	public void EntityModifiers();

	public void EntityModifiers_();

	public void EntityModifiers_(int initialCapacity);

	public void _EntityModifiers();

	public void EntityModifier();

	public void EntityModifier(EntityModifierEnum.Value value);

	public void EntityModifier(String value);

	public void Features();

	public void Features_();

	public void Features_(int initialCapacity);

	public void _Features();

	public void Feature();

	public void Feature_();

	public void _Feature();

	public void FeatureModifiers();

	public void FeatureModifiers_();

	public void FeatureModifiers_(int initialCapacity);

	public void _FeatureModifiers();

	public void FeatureModifier();

	public void FeatureModifier(FeatureModifierEnum.Value value);

	public void FeatureModifier(String value);

	public void ComponentModifiers();

	public void ComponentModifiers_();

	public void ComponentModifiers_(int initialCapacity);

	public void _ComponentModifiers();

	public void ComponentModifier();

	public void ComponentModifier(ComponentModifierEnum.Value value);

	public void ComponentModifier(String value);

	public void DataType();

	public void DataType(String value);

	public void EnumValues();

	public void EnumValues_();

	public void EnumValues_(int initialCapacity);

	public void _EnumValues();

	public void EnumValue();

	public void EnumValue(String value);

	public void Types();

	public void Types_();

	public void Types_(int initialCapacity);

	public void _Types();

	public void TypeRelations();

	public void TypeRelations_();

	public void TypeRelations_(int initialCapacity);

	public void _TypeRelations();

	public void SupertypesOf();

	public void SupertypesOf_();

	public void _SupertypesOf();

	public void SubtypesOf();

	public void SubtypesOf_();

	public void _SubtypesOf();

	public void TypeAliasOf();

	public void TypeAliasOf_();

	public void _TypeAliasOf();

	public void AnyType();

	public void AnyType_();

	public void _AnyType();

	public void EntityType();

	public void EntityType(String value);

	public void SimpleName();

	public void SimpleName(String value);

	public void Namespace();

	public void Namespace(String value);

	public void Version();

	public void Version(String value);

	public void URI();

	public void URI(String value);
}
