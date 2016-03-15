/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.types.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.types.reflect.TypesFeatureDescriptorEnum;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.types.model.LegacyTypeEnum;

/**
 *  @generator Whole
 */
public class TypesSpecificBuilderAdapter extends GenericBuilderContext implements ITypesBuilder {

    public TypesSpecificBuilderAdapter(IBuilder strategy) {
        super(strategy);
    }

    public TypesSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
        super(strategy, entityContext);
    }

    public void name() {
        wFeature(TypesFeatureDescriptorEnum.name);
    }

    public void expressions() {
        wFeature(TypesFeatureDescriptorEnum.expressions);
    }

    public void cases() {
        wFeature(TypesFeatureDescriptorEnum.cases);
    }

    public void arguments() {
        wFeature(TypesFeatureDescriptorEnum.arguments);
    }

    public void type() {
        wFeature(TypesFeatureDescriptorEnum.type);
    }

    public void domain() {
        wFeature(TypesFeatureDescriptorEnum.domain);
    }

    public void rules() {
        wFeature(TypesFeatureDescriptorEnum.rules);
    }

    public void checkBefore() {
        wFeature(TypesFeatureDescriptorEnum.checkBefore);
    }

    public void visit() {
    }

    public void TypeSystem() {
        wEntity(TypesEntityDescriptorEnum.TypeSystem);
    }

    public void TypeSystem_() {
        wEntity_(TypesEntityDescriptorEnum.TypeSystem);
    }

    public void _TypeSystem() {
        _wEntity(TypesEntityDescriptorEnum.TypeSystem);
    }

    public void TypeRules() {
        wEntity(TypesEntityDescriptorEnum.TypeRules);
    }

    public void TypeRules_() {
        wEntity_(TypesEntityDescriptorEnum.TypeRules);
    }

    public void TypeRules_(int initialCapacity) {
        wEntity_(TypesEntityDescriptorEnum.TypeRules, initialCapacity);
    }

    public void _TypeRules() {
        _wEntity(TypesEntityDescriptorEnum.TypeRules);
    }

    public void TypeRule() {
        wEntity(TypesEntityDescriptorEnum.TypeRule);
    }

    public void TypeRule_() {
        wEntity_(TypesEntityDescriptorEnum.TypeRule);
    }

    public void _TypeRule() {
        _wEntity(TypesEntityDescriptorEnum.TypeRule);
    }

    public void AnyType() {
        wEntity(TypesEntityDescriptorEnum.AnyType);
    }

    public void AnyType_() {
        wEntity_(TypesEntityDescriptorEnum.AnyType);
    }

    public void _AnyType() {
        _wEntity(TypesEntityDescriptorEnum.AnyType);
    }

    public void LegacyType() {
        wEntity(TypesEntityDescriptorEnum.LegacyType);
    }

    public void LegacyType(LegacyTypeEnum.Value value) {
        wEntity(TypesEntityDescriptorEnum.LegacyType, value);
    }

    public void LegacyType(String value) {
        wEntity(TypesEntityDescriptorEnum.LegacyType, value);
    }

    public void VariableType() {
        wEntity(TypesEntityDescriptorEnum.VariableType);
    }

    public void VariableType(int value) {
        wEntity(TypesEntityDescriptorEnum.VariableType, value);
    }

    public void EntityType() {
        wEntity(TypesEntityDescriptorEnum.EntityType);
    }

    public void EntityType(String value) {
        wEntity(TypesEntityDescriptorEnum.EntityType, value);
    }

    public void UnionType() {
        wEntity(TypesEntityDescriptorEnum.UnionType);
    }

    public void UnionType_() {
        wEntity_(TypesEntityDescriptorEnum.UnionType);
    }

    public void UnionType_(int initialCapacity) {
        wEntity_(TypesEntityDescriptorEnum.UnionType, initialCapacity);
    }

    public void _UnionType() {
        _wEntity(TypesEntityDescriptorEnum.UnionType);
    }

    public void FeatureType() {
        wEntity(TypesEntityDescriptorEnum.FeatureType);
    }

    public void FeatureType(String value) {
        wEntity(TypesEntityDescriptorEnum.FeatureType, value);
    }

    public void FeatureTableType() {
        wEntity(TypesEntityDescriptorEnum.FeatureTableType);
    }

    public void FeatureTableType_() {
        wEntity_(TypesEntityDescriptorEnum.FeatureTableType);
    }

    public void _FeatureTableType() {
        _wEntity(TypesEntityDescriptorEnum.FeatureTableType);
    }

    public void Arguments() {
        wEntity(TypesEntityDescriptorEnum.Arguments);
    }

    public void Arguments_() {
        wEntity_(TypesEntityDescriptorEnum.Arguments);
    }

    public void Arguments_(int initialCapacity) {
        wEntity_(TypesEntityDescriptorEnum.Arguments, initialCapacity);
    }

    public void _Arguments() {
        _wEntity(TypesEntityDescriptorEnum.Arguments);
    }

    public void Cases() {
        wEntity(TypesEntityDescriptorEnum.Cases);
    }

    public void Cases_() {
        wEntity_(TypesEntityDescriptorEnum.Cases);
    }

    public void Cases_(int initialCapacity) {
        wEntity_(TypesEntityDescriptorEnum.Cases, initialCapacity);
    }

    public void _Cases() {
        _wEntity(TypesEntityDescriptorEnum.Cases);
    }

    public void Case() {
        wEntity(TypesEntityDescriptorEnum.Case);
    }

    public void Case_() {
        wEntity_(TypesEntityDescriptorEnum.Case);
    }

    public void _Case() {
        _wEntity(TypesEntityDescriptorEnum.Case);
    }

    public void OrExpressions() {
        wEntity(TypesEntityDescriptorEnum.OrExpressions);
    }

    public void OrExpressions_() {
        wEntity_(TypesEntityDescriptorEnum.OrExpressions);
    }

    public void OrExpressions_(int initialCapacity) {
        wEntity_(TypesEntityDescriptorEnum.OrExpressions, initialCapacity);
    }

    public void _OrExpressions() {
        _wEntity(TypesEntityDescriptorEnum.OrExpressions);
    }

    public void TypeExpressions() {
        wEntity(TypesEntityDescriptorEnum.TypeExpressions);
    }

    public void TypeExpressions_() {
        wEntity_(TypesEntityDescriptorEnum.TypeExpressions);
    }

    public void TypeExpressions_(int initialCapacity) {
        wEntity_(TypesEntityDescriptorEnum.TypeExpressions, initialCapacity);
    }

    public void _TypeExpressions() {
        _wEntity(TypesEntityDescriptorEnum.TypeExpressions);
    }

    public void Subtype() {
        wEntity(TypesEntityDescriptorEnum.Subtype);
    }

    public void Subtype_() {
        wEntity_(TypesEntityDescriptorEnum.Subtype);
    }

    public void _Subtype() {
        _wEntity(TypesEntityDescriptorEnum.Subtype);
    }

    public void Supertype() {
        wEntity(TypesEntityDescriptorEnum.Supertype);
    }

    public void Supertype_() {
        wEntity_(TypesEntityDescriptorEnum.Supertype);
    }

    public void _Supertype() {
        _wEntity(TypesEntityDescriptorEnum.Supertype);
    }
}
