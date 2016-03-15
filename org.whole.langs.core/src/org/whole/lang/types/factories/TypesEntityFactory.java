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
package org.whole.lang.types.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.types.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class TypesEntityFactory extends GenericEntityFactory {
    public static final TypesEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

    public static TypesEntityFactory instance(IEntityRegistryProvider provider) {
        return new TypesEntityFactory(provider);
    }

    protected TypesEntityFactory(IEntityRegistryProvider provider) {
        super(provider);
    }

    public TypeSystem createTypeSystem() {
        return create(TypesEntityDescriptorEnum.TypeSystem);
    }

    public TypeSystem createTypeSystem(Operations checkBefore, TypeRules rules) {
        return create(TypesEntityDescriptorEnum.TypeSystem, checkBefore, rules);
    }

    public IEntityBuilder<TypeSystem> buildTypeSystem() {
        return new EntityBuilder<TypeSystem>(create(TypesEntityDescriptorEnum.TypeSystem));
    }

    public TypeRules createTypeRules() {
        return create(TypesEntityDescriptorEnum.TypeRules);
    }

    public TypeRules createTypeRules(TypeRule... entities) {
        return create(TypesEntityDescriptorEnum.TypeRules, (IEntity[]) entities);
    }

    public TypeRules createTypeRules(int initialSize) {
        return clone(TypesEntityDescriptorEnum.TypeRules, initialSize);
    }

    public TypeRule createTypeRule() {
        return create(TypesEntityDescriptorEnum.TypeRule);
    }

    public TypeRule createTypeRule(DomainType domain, Type type) {
        return create(TypesEntityDescriptorEnum.TypeRule, domain, type);
    }

    public IEntityBuilder<TypeRule> buildTypeRule() {
        return new EntityBuilder<TypeRule>(create(TypesEntityDescriptorEnum.TypeRule));
    }

    public AnyType createAnyType() {
        return create(TypesEntityDescriptorEnum.AnyType);
    }

    public LegacyType createLegacyType() {
        return create(TypesEntityDescriptorEnum.LegacyType);
    }

    public LegacyType createLegacyType(LegacyTypeEnum.Value value) {
        return create(TypesEntityDescriptorEnum.LegacyType, value);
    }

    public VariableType createVariableType() {
        return create(TypesEntityDescriptorEnum.VariableType);
    }

    public VariableType createVariableType(int value) {
        return create(TypesEntityDescriptorEnum.VariableType, value);
    }

    public EntityType createEntityType() {
        return create(TypesEntityDescriptorEnum.EntityType);
    }

    public EntityType createEntityType(String value) {
        return create(TypesEntityDescriptorEnum.EntityType, value);
    }

    public UnionType createUnionType() {
        return create(TypesEntityDescriptorEnum.UnionType);
    }

    public UnionType createUnionType(EntityType... entities) {
        return create(TypesEntityDescriptorEnum.UnionType, (IEntity[]) entities);
    }

    public UnionType createUnionType(int initialSize) {
        return clone(TypesEntityDescriptorEnum.UnionType, initialSize);
    }

    public FeatureType createFeatureType() {
        return create(TypesEntityDescriptorEnum.FeatureType);
    }

    public FeatureType createFeatureType(String value) {
        return create(TypesEntityDescriptorEnum.FeatureType, value);
    }

    public FeatureTableType createFeatureTableType() {
        return create(TypesEntityDescriptorEnum.FeatureTableType);
    }

    public FeatureTableType createFeatureTableType(Arguments arguments, Cases cases) {
        return create(TypesEntityDescriptorEnum.FeatureTableType, arguments, cases);
    }

    public IEntityBuilder<FeatureTableType> buildFeatureTableType() {
        return new EntityBuilder<FeatureTableType>(create(TypesEntityDescriptorEnum.FeatureTableType));
    }

    public Arguments createArguments() {
        return create(TypesEntityDescriptorEnum.Arguments);
    }

    public Arguments createArguments(ArgumentType... entities) {
        return create(TypesEntityDescriptorEnum.Arguments, (IEntity[]) entities);
    }

    public Arguments createArguments(int initialSize) {
        return clone(TypesEntityDescriptorEnum.Arguments, initialSize);
    }

    public Cases createCases() {
        return create(TypesEntityDescriptorEnum.Cases);
    }

    public Cases createCases(Case... entities) {
        return create(TypesEntityDescriptorEnum.Cases, (IEntity[]) entities);
    }

    public Cases createCases(int initialSize) {
        return clone(TypesEntityDescriptorEnum.Cases, initialSize);
    }

    public Case createCase() {
        return create(TypesEntityDescriptorEnum.Case);
    }

    public Case createCase(BasicType type, Expressions expressions) {
        return create(TypesEntityDescriptorEnum.Case, type, expressions);
    }

    public IEntityBuilder<Case> buildCase() {
        return new EntityBuilder<Case>(create(TypesEntityDescriptorEnum.Case));
    }

    public OrExpressions createOrExpressions() {
        return create(TypesEntityDescriptorEnum.OrExpressions);
    }

    public OrExpressions createOrExpressions(TypeExpressions... entities) {
        return create(TypesEntityDescriptorEnum.OrExpressions, (IEntity[]) entities);
    }

    public OrExpressions createOrExpressions(int initialSize) {
        return clone(TypesEntityDescriptorEnum.OrExpressions, initialSize);
    }

    public TypeExpressions createTypeExpressions() {
        return create(TypesEntityDescriptorEnum.TypeExpressions);
    }

    public TypeExpressions createTypeExpressions(TypeExpression... entities) {
        return create(TypesEntityDescriptorEnum.TypeExpressions, (IEntity[]) entities);
    }

    public TypeExpressions createTypeExpressions(int initialSize) {
        return clone(TypesEntityDescriptorEnum.TypeExpressions, initialSize);
    }

    public Subtype createSubtype() {
        return create(TypesEntityDescriptorEnum.Subtype);
    }

    public Subtype createSubtype(VariableType name, VariableType type) {
        return create(TypesEntityDescriptorEnum.Subtype, name, type);
    }

    public IEntityBuilder<Subtype> buildSubtype() {
        return new EntityBuilder<Subtype>(create(TypesEntityDescriptorEnum.Subtype));
    }

    public Supertype createSupertype() {
        return create(TypesEntityDescriptorEnum.Supertype);
    }

    public Supertype createSupertype(VariableType name, VariableType type) {
        return create(TypesEntityDescriptorEnum.Supertype, name, type);
    }

    public IEntityBuilder<Supertype> buildSupertype() {
        return new EntityBuilder<Supertype>(create(TypesEntityDescriptorEnum.Supertype));
    }
}
