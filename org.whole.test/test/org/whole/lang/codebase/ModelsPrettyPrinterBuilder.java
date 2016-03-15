/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.codebase;

import java.util.Date;

import org.whole.lang.contexts.IBuilderContext;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.model.EnumValue;
import org.whole.lang.models.builders.IModelsBuilder;
import org.whole.lang.models.model.EntityModifierEnum.Value;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.templates.ITemplate;

/**
 * @author Riccardo Solmi
 */
public class ModelsPrettyPrinterBuilder implements IModelsBuilder {
	protected void print(String text) {
		System.out.print(text);
	}

	public void SimpleEntity() {
	}

	public void SimpleEntity_() {
		print("entity");
		
	}

	public void _SimpleEntity() {
		print("_entity\n");
	}

	
	
	
	
	public void visit() {
		// TODO Auto-generated method stub
		
	}

	public void values() {
		// TODO Auto-generated method stub
		
	}

	public void dataType() {
		// TODO Auto-generated method stub
		
	}

	public void valueType() {
		// TODO Auto-generated method stub
		
	}

	public void keyType() {
		// TODO Auto-generated method stub
		
	}

	public void componentType() {
		// TODO Auto-generated method stub
		
	}

	public void componentModifiers() {
		// TODO Auto-generated method stub
		
	}

	public void type() {
		// TODO Auto-generated method stub
		
	}

	public void features() {
		// TODO Auto-generated method stub
		
	}

	public void types() {
		// TODO Auto-generated method stub
		
	}

	public void modifiers() {
		// TODO Auto-generated method stub
		
	}

	public void declarations() {
		// TODO Auto-generated method stub
		
	}

	public void typeRelations() {
		// TODO Auto-generated method stub
		
	}

	public void name() {
		// TODO Auto-generated method stub
		
	}

	public void qualifier() {
		// TODO Auto-generated method stub
		
	}

	public void Models() {
		// TODO Auto-generated method stub
		
	}

	public void Models_() {
		// TODO Auto-generated method stub
		
	}

	public void Models_(int initialCapacity) {
		// TODO Auto-generated method stub
		
	}

	public void _Models() {
		// TODO Auto-generated method stub
		
	}

	public void SimpleName() {
		// TODO Auto-generated method stub
		
	}

	public void SimpleName(String value) {
		// TODO Auto-generated method stub
		
	}

	public void QualifiedName() {
		// TODO Auto-generated method stub
		
	}

	public void QualifiedName_() {
		// TODO Auto-generated method stub
		
	}

	public void _QualifiedName() {
		// TODO Auto-generated method stub
		
	}

	public void Types() {
		// TODO Auto-generated method stub
		
	}

	public void Types_() {
		// TODO Auto-generated method stub
		
	}

	public void Types_(int initialCapacity) {
		// TODO Auto-generated method stub
		
	}

	public void _Types() {
		// TODO Auto-generated method stub
		
	}

	public void TypeRelations() {
		// TODO Auto-generated method stub
		
	}

	public void TypeRelations_() {
		// TODO Auto-generated method stub
		
	}

	public void TypeRelations_(int initialCapacity) {
		// TODO Auto-generated method stub
		
	}

	public void _TypeRelations() {
		// TODO Auto-generated method stub
		
	}

	public void Model() {
		// TODO Auto-generated method stub
		
	}

	public void Model_() {
		// TODO Auto-generated method stub
		
	}

	public void _Model() {
		// TODO Auto-generated method stub
		
	}

	public void ModelDeclarations() {
		// TODO Auto-generated method stub
		
	}

	public void ModelDeclarations_() {
		// TODO Auto-generated method stub
		
	}

	public void ModelDeclarations_(int initialCapacity) {
		// TODO Auto-generated method stub
		
	}

	public void _ModelDeclarations() {
		// TODO Auto-generated method stub
		
	}


	public void EntityModifiers() {
		// TODO Auto-generated method stub
		
	}

	public void EntityModifiers_() {
		// TODO Auto-generated method stub
		
	}

	public void EntityModifiers_(int initialCapacity) {
		// TODO Auto-generated method stub
		
	}

	public void _EntityModifiers() {
		// TODO Auto-generated method stub
		
	}

	public void EntityModifier() {
		// TODO Auto-generated method stub
		
	}

	public void EntityModifier(Value value) {
		// TODO Auto-generated method stub
		
	}

	public void EntityModifier(String value) {
		// TODO Auto-generated method stub
		
	}

	public void Features() {
		// TODO Auto-generated method stub
		
	}

	public void Features_() {
		// TODO Auto-generated method stub
		
	}

	public void Features_(int initialCapacity) {
		// TODO Auto-generated method stub
		
	}

	public void _Features() {
		// TODO Auto-generated method stub
		
	}

	public void Feature() {
		// TODO Auto-generated method stub
		
	}

	public void Feature_() {
		// TODO Auto-generated method stub
		
	}

	public void _Feature() {
		// TODO Auto-generated method stub
		
	}

	public void FeatureModifiers() {
		// TODO Auto-generated method stub
		
	}

	public void FeatureModifiers_() {
		// TODO Auto-generated method stub
		
	}

	public void FeatureModifiers_(int initialCapacity) {
		// TODO Auto-generated method stub
		
	}

	public void _FeatureModifiers() {
		// TODO Auto-generated method stub
		
	}

	public void FeatureModifier() {
		// TODO Auto-generated method stub
		
	}

	public void FeatureModifier(org.whole.lang.models.model.FeatureModifierEnum.Value value) {
		// TODO Auto-generated method stub
		
	}

	public void FeatureModifier(String value) {
		// TODO Auto-generated method stub
		
	}

	public void CompositeEntity() {
		// TODO Auto-generated method stub
		
	}

	public void CompositeEntity_() {
		// TODO Auto-generated method stub
		
	}

	public void _CompositeEntity() {
		// TODO Auto-generated method stub
		
	}

	public void ComponentModifiers() {
		// TODO Auto-generated method stub
		
	}

	public void ComponentModifiers_() {
		// TODO Auto-generated method stub
		
	}

	public void ComponentModifiers_(int initialCapacity) {
		// TODO Auto-generated method stub
		
	}

	public void _ComponentModifiers() {
		// TODO Auto-generated method stub
		
	}

	public void ComponentModifier() {
		// TODO Auto-generated method stub
		
	}

	public void ComponentModifier(org.whole.lang.models.model.ComponentModifierEnum.Value value) {
		// TODO Auto-generated method stub
		
	}

	public void ComponentModifier(String value) {
		// TODO Auto-generated method stub
		
	}

	public void MapEntity() {
		// TODO Auto-generated method stub
		
	}

	public void MapEntity_() {
		// TODO Auto-generated method stub
		
	}

	public void _MapEntity() {
		// TODO Auto-generated method stub
		
	}

	public void DataEntity() {
		// TODO Auto-generated method stub
		
	}

	public void DataEntity_() {
		// TODO Auto-generated method stub
		
	}

	public void _DataEntity() {
		// TODO Auto-generated method stub
		
	}

	public void DataType() {
		// TODO Auto-generated method stub
		
	}

	public void DataType(String value) {
		// TODO Auto-generated method stub
		
	}

	public void EnumEntity() {
		// TODO Auto-generated method stub
		
	}

	public void EnumEntity_() {
		// TODO Auto-generated method stub
		
	}

	public void _EnumEntity() {
		// TODO Auto-generated method stub
		
	}

	public void EnumValues() {
		// TODO Auto-generated method stub
		
	}

	public void EnumValues_() {
		// TODO Auto-generated method stub
		
	}

	public void EnumValues_(int initialCapacity) {
		// TODO Auto-generated method stub
		
	}

	public void _EnumValues() {
		// TODO Auto-generated method stub
		
	}

	public void EnumValue() {
		// TODO Auto-generated method stub
		
	}

	public void EnumValue(String value) {
		// TODO Auto-generated method stub
		
	}

	public void AliasType() {
		// TODO Auto-generated method stub
		
	}

	public void AliasType_() {
		// TODO Auto-generated method stub
		
	}

	public void _AliasType() {
		// TODO Auto-generated method stub
		
	}

	public void ModelsAdapterFragment() {
		// TODO Auto-generated method stub
		
	}

	public void ModelsAdapterFragment_() {
		// TODO Auto-generated method stub
		
	}

	public void _ModelsAdapterFragment() {
		// TODO Auto-generated method stub
		
	}

	public void ModelsBaseFragment() {
		// TODO Auto-generated method stub
		
	}

	public void ModelsBaseFragment_() {
		// TODO Auto-generated method stub
		
	}

	public void _ModelsBaseFragment() {
		// TODO Auto-generated method stub
		
	}

	public void ModelsMetaFragment() {
		// TODO Auto-generated method stub
		
	}

	public void ModelsMetaFragment_() {
		// TODO Auto-generated method stub
		
	}

	public void _ModelsMetaFragment() {
		// TODO Auto-generated method stub
		
	}

	public void TypeResolver() {
		// TODO Auto-generated method stub
		
	}

	public void IEntityModifiersResolver() {
		// TODO Auto-generated method stub
		
	}

	public void ModelDeclarationResolver() {
		// TODO Auto-generated method stub
		
	}

	public void ITypeRelationsResolver() {
		// TODO Auto-generated method stub
		
	}

	public void IFeatureModifiersResolver() {
		// TODO Auto-generated method stub
		
	}

	public void IModelResolver() {
		// TODO Auto-generated method stub
		
	}

	public void ISimpleNameResolver() {
		// TODO Auto-generated method stub
		
	}

	public void ITypesResolver() {
		// TODO Auto-generated method stub
		
	}

	public void IEntityModifierResolver() {
		// TODO Auto-generated method stub
		
	}

	public void IEnumValuesResolver() {
		// TODO Auto-generated method stub
		
	}

	public void IDataTypeResolver() {
		// TODO Auto-generated method stub
		
	}

	public void IFeatureModifierResolver() {
		// TODO Auto-generated method stub
		
	}

	public void IComponentModifierResolver() {
		// TODO Auto-generated method stub
		
	}

	public void IComponentModifiersResolver() {
		// TODO Auto-generated method stub
		
	}

	public void IFeaturesResolver() {
		// TODO Auto-generated method stub
		
	}

	public void IModelDeclarationsResolver() {
		// TODO Auto-generated method stub
		
	}

	public void IEnumValueResolver() {
		// TODO Auto-generated method stub
		
	}

	public void IFeatureResolver() {
		// TODO Auto-generated method stub
		
	}

	public void wSetBuilderContext(IBuilderContext context) {
		// TODO Auto-generated method stub
		
	}

	public void wSetEntityContext(IEntityContext context) {
		// TODO Auto-generated method stub
		
	}

	public void wDefault() {
		// TODO Auto-generated method stub
		
	}

	public void wEntity() {
		// TODO Auto-generated method stub
		
	}

	public void wEntity_() {
		// TODO Auto-generated method stub
		
	}

	public void _wEntity() {
		// TODO Auto-generated method stub
		
	}

	public void wFeature(int index) {
		// TODO Auto-generated method stub
		
	}

	public void wFeature(FeatureDescriptor feature) {
		// TODO Auto-generated method stub
		
	}

	public void wFeature(ITemplate template) {
		// TODO Auto-generated method stub
		
	}

	public void varName() {
		// TODO Auto-generated method stub
		
	}

	public void varType() {
		// TODO Auto-generated method stub
		
	}

	public void ModelsEntityDescriptor() {
		// TODO Auto-generated method stub
		
	}

	public void ModelsEntityDescriptor(EntityDescriptor value) {
		// TODO Auto-generated method stub
		
	}

	public void ModelsEntityDescriptor(String value) {
		// TODO Auto-generated method stub
		
	}

	public void ModelsStringData() {
		// TODO Auto-generated method stub
		
	}

	public void ModelsStringData(String value) {
		// TODO Auto-generated method stub
		
	}

	public void ModelsVariable() {
		// TODO Auto-generated method stub
		
	}

	public void ModelsVariable_() {
		// TODO Auto-generated method stub
		
	}

	public void _ModelsVariable() {
		// TODO Auto-generated method stub
		
	}

	public void IModelsStringDataResolver() {
		// TODO Auto-generated method stub
		
	}

	public void Namespace() {
		// TODO Auto-generated method stub
		
	}

	public void Namespace(String value) {
		// TODO Auto-generated method stub
		
	}

	public void URI() {
		// TODO Auto-generated method stub
		
	}

	public void URI(String value) {
		// TODO Auto-generated method stub
		
	}

	public void Version() {
		// TODO Auto-generated method stub
		
	}

	public void Version(String value) {
		// TODO Auto-generated method stub
		
	}

	public void namespace() {
		// TODO Auto-generated method stub
		
	}

	public void oppositeName() {
		// TODO Auto-generated method stub
		
	}

	public void uri() {
		// TODO Auto-generated method stub
		
	}

	public void version() {
		// TODO Auto-generated method stub
		
	}

	public void wEntity(EntityDescriptor<?> entity) {
		// TODO Auto-generated method stub
		
	}

	public void wEntity_(EntityDescriptor<?> entity) {
		// TODO Auto-generated method stub
		
	}

	public void wEntity_(EntityDescriptor<?> entity, int initialCapacity) {
		// TODO Auto-generated method stub
		
	}

	public void _wEntity(EntityDescriptor<?> entity) {
		// TODO Auto-generated method stub
		
	}

	public void wEntity(EntityDescriptor<?> entity, boolean value) {
		// TODO Auto-generated method stub
		
	}

	public void wEntity(EntityDescriptor<?> entity, byte value) {
		// TODO Auto-generated method stub
		
	}

	public void wEntity(EntityDescriptor<?> entity, char value) {
		// TODO Auto-generated method stub
		
	}

	public void wEntity(EntityDescriptor<?> entity, double value) {
		// TODO Auto-generated method stub
		
	}

	public void wEntity(EntityDescriptor<?> entity, float value) {
		// TODO Auto-generated method stub
		
	}

	public void wEntity(EntityDescriptor<?> entity, int value) {
		// TODO Auto-generated method stub
		
	}

	public void wEntity(EntityDescriptor<?> entity, long value) {
		// TODO Auto-generated method stub
		
	}

	public void wEntity(EntityDescriptor<?> entity, short value) {
		// TODO Auto-generated method stub
		
	}

	public void wEntity(EntityDescriptor<?> entity, String value) {
		// TODO Auto-generated method stub
		
	}

	public void wEntity(EntityDescriptor<?> entity, Date value) {
		// TODO Auto-generated method stub
		
	}

	public void wEntity(EntityDescriptor<?> entity,
			org.whole.lang.model.EnumValue value) {
		// TODO Auto-generated method stub
		
	}

	public void wEntity(EntityDescriptor<?> entity, Object value) {
		// TODO Auto-generated method stub
		
	}

	public void foreignType() {
		// TODO Auto-generated method stub
		
	}

	public void SupertypesOf() {
		// TODO Auto-generated method stub
		
	}

	public void SupertypesOf_() {
		// TODO Auto-generated method stub
		
	}

	public void _SupertypesOf() {
		// TODO Auto-generated method stub
		
	}

	public void SubtypesOf() {
		// TODO Auto-generated method stub
		
	}

	public void SubtypesOf_() {
		// TODO Auto-generated method stub
		
	}

	public void _SubtypesOf() {
		// TODO Auto-generated method stub
		
	}

	public void TypeAliasOf() {
		// TODO Auto-generated method stub
		
	}

	public void TypeAliasOf_() {
		// TODO Auto-generated method stub
		
	}

	public void _TypeAliasOf() {
		// TODO Auto-generated method stub
		
	}

	public void AnyType() {
		// TODO Auto-generated method stub
		
	}

	public void AnyType_() {
		// TODO Auto-generated method stub
		
	}

	public void _AnyType() {
		// TODO Auto-generated method stub
		
	}

	public void EntityType() {
		// TODO Auto-generated method stub
		
	}

	public void EntityType(String value) {
		// TODO Auto-generated method stub
		
	}

}
