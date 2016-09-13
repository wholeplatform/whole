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
package org.whole.lang.types.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.model.*;

/**
 *  @generator Whole
 */
@SuppressWarnings("unchecked")
public class TypesEntityDescriptorEnum extends EntityDescriptorEnum {
    public static final int TypeSystem_ord = 0;
    public static final int TypeRules_ord = 1;
    public static final int TypeRule_ord = 2;
    public static final int Type_ord = 3;
    public static final int ArgumentType_ord = 4;
    public static final int BasicType_ord = 5;
    public static final int AnyType_ord = 6;
    public static final int LegacyType_ord = 7;
    public static final int VariableType_ord = 8;
    public static final int DomainType_ord = 9;
    public static final int EntityType_ord = 10;
    public static final int UnionType_ord = 11;
    public static final int FeatureType_ord = 12;
    public static final int FeatureTableType_ord = 13;
    public static final int Arguments_ord = 14;
    public static final int Cases_ord = 15;
    public static final int Case_ord = 16;
    public static final int Expressions_ord = 17;
    public static final int OrExpressions_ord = 18;
    public static final int TypeExpressions_ord = 19;
    public static final int TypeExpression_ord = 20;
    public static final int Subtype_ord = 21;
    public static final int Supertype_ord = 22;
    public static final int Operations_ord = 23;
    public static final TypesEntityDescriptorEnum instance = new TypesEntityDescriptorEnum();
    public static final EntityDescriptor<TypeSystem> TypeSystem = (EntityDescriptor<TypeSystem>) instance.valueOf(TypeSystem_ord);
    public static final EntityDescriptor<TypeRules> TypeRules = (EntityDescriptor<TypeRules>) instance.valueOf(TypeRules_ord);
    public static final EntityDescriptor<TypeRule> TypeRule = (EntityDescriptor<TypeRule>) instance.valueOf(TypeRule_ord);
    public static final EntityDescriptor<Type> Type = (EntityDescriptor<Type>) instance.valueOf(Type_ord);
    public static final EntityDescriptor<ArgumentType> ArgumentType = (EntityDescriptor<ArgumentType>) instance.valueOf(ArgumentType_ord);
    public static final EntityDescriptor<BasicType> BasicType = (EntityDescriptor<BasicType>) instance.valueOf(BasicType_ord);
    public static final EntityDescriptor<AnyType> AnyType = (EntityDescriptor<AnyType>) instance.valueOf(AnyType_ord);
    public static final EntityDescriptor<LegacyType> LegacyType = (EntityDescriptor<LegacyType>) instance.valueOf(LegacyType_ord);
    public static final EntityDescriptor<VariableType> VariableType = (EntityDescriptor<VariableType>) instance.valueOf(VariableType_ord);
    public static final EntityDescriptor<DomainType> DomainType = (EntityDescriptor<DomainType>) instance.valueOf(DomainType_ord);
    public static final EntityDescriptor<EntityType> EntityType = (EntityDescriptor<EntityType>) instance.valueOf(EntityType_ord);
    public static final EntityDescriptor<UnionType> UnionType = (EntityDescriptor<UnionType>) instance.valueOf(UnionType_ord);
    public static final EntityDescriptor<FeatureType> FeatureType = (EntityDescriptor<FeatureType>) instance.valueOf(FeatureType_ord);
    public static final EntityDescriptor<FeatureTableType> FeatureTableType = (EntityDescriptor<FeatureTableType>) instance.valueOf(FeatureTableType_ord);
    public static final EntityDescriptor<Arguments> Arguments = (EntityDescriptor<Arguments>) instance.valueOf(Arguments_ord);
    public static final EntityDescriptor<Cases> Cases = (EntityDescriptor<Cases>) instance.valueOf(Cases_ord);
    public static final EntityDescriptor<Case> Case = (EntityDescriptor<Case>) instance.valueOf(Case_ord);
    public static final EntityDescriptor<Expressions> Expressions = (EntityDescriptor<Expressions>) instance.valueOf(Expressions_ord);
    public static final EntityDescriptor<OrExpressions> OrExpressions = (EntityDescriptor<OrExpressions>) instance.valueOf(OrExpressions_ord);
    public static final EntityDescriptor<TypeExpressions> TypeExpressions = (EntityDescriptor<TypeExpressions>) instance.valueOf(TypeExpressions_ord);
    public static final EntityDescriptor<TypeExpression> TypeExpression = (EntityDescriptor<TypeExpression>) instance.valueOf(TypeExpression_ord);
    public static final EntityDescriptor<Subtype> Subtype = (EntityDescriptor<Subtype>) instance.valueOf(Subtype_ord);
    public static final EntityDescriptor<Supertype> Supertype = (EntityDescriptor<Supertype>) instance.valueOf(Supertype_ord);
    public static final EntityDescriptor<Operations> Operations = (EntityDescriptor<Operations>) instance.valueOf(Operations_ord);

    private TypesEntityDescriptorEnum() {
    }
    private static final long serialVersionUID = 1;

    protected void initEntityDescriptors() {
        putSimpleEntity(TypeSystem_ord, "TypeSystem", TypeSystem.class, false).withFeature(TypesFeatureDescriptorEnum.checkBefore, Operations_ord).withFeature(TypesFeatureDescriptorEnum.rules, TypeRules_ord);
        putCompositeEntity(
		TypeRules_ord, "TypeRules", TypeRules.class, false, TypeRule_ord, true, false);
        putSimpleEntity(TypeRule_ord, "TypeRule", TypeRule.class, false).withFeature(TypesFeatureDescriptorEnum.domain, DomainType_ord).withFeature(TypesFeatureDescriptorEnum.type, Type_ord);
        putSimpleEntity(Type_ord, "Type", Type.class, true, LegacyType_ord, EntityType_ord, UnionType_ord, FeatureType_ord, BasicType_ord, DomainType_ord, VariableType_ord, FeatureTableType_ord, ArgumentType_ord, AnyType_ord);
        putSimpleEntity(ArgumentType_ord, "ArgumentType", ArgumentType.class, true, FeatureType_ord);
        putSimpleEntity(BasicType_ord, "BasicType", BasicType.class, true, LegacyType_ord, VariableType_ord, AnyType_ord);
        putSimpleEntity(AnyType_ord, "AnyType", AnyType.class, false);
        putDataEntity(LegacyType_ord, "LegacyType", LegacyType.class, false, LegacyTypeEnum.Value.class);
        putDataEntity(VariableType_ord, "VariableType", VariableType.class, false, int.class);
        putSimpleEntity(DomainType_ord, "DomainType", DomainType.class, true, EntityType_ord, UnionType_ord);
        putDataEntity(EntityType_ord, "EntityType", EntityType.class, false, String.class);
        putCompositeEntity(
		UnionType_ord, "UnionType", UnionType.class, false, EntityType_ord, true, false);
        putDataEntity(FeatureType_ord, "FeatureType", FeatureType.class, false, String.class);
        putSimpleEntity(FeatureTableType_ord, "FeatureTableType", FeatureTableType.class, false).withFeature(TypesFeatureDescriptorEnum.arguments, Arguments_ord).withFeature(TypesFeatureDescriptorEnum.cases, Cases_ord);
        putCompositeEntity(
		Arguments_ord, "Arguments", Arguments.class, false, ArgumentType_ord, true, false);
        putCompositeEntity(
		Cases_ord, "Cases", Cases.class, false, Case_ord, true, false);
        putSimpleEntity(Case_ord, "Case", Case.class, false).withFeature(TypesFeatureDescriptorEnum.type, BasicType_ord).withFeature(TypesFeatureDescriptorEnum.expressions, Expressions_ord);
        putSimpleEntity(Expressions_ord, "Expressions", Expressions.class, true, TypeExpressions_ord, OrExpressions_ord);
        putCompositeEntity(
		OrExpressions_ord, "OrExpressions", OrExpressions.class, false, TypeExpressions_ord, true, false);
        putCompositeEntity(
		TypeExpressions_ord, "TypeExpressions", TypeExpressions.class, false, TypeExpression_ord, true, false);
        putSimpleEntity(TypeExpression_ord, "TypeExpression", TypeExpression.class, true, LegacyType_ord, BasicType_ord, VariableType_ord, Supertype_ord, Subtype_ord, AnyType_ord);
        putSimpleEntity(Subtype_ord, "Subtype", Subtype.class, false).withFeature(TypesFeatureDescriptorEnum.name, VariableType_ord, true, false, false, false, false).withFeature(TypesFeatureDescriptorEnum.type, VariableType_ord);
        putSimpleEntity(Supertype_ord, "Supertype", Supertype.class, false).withFeature(TypesFeatureDescriptorEnum.name, VariableType_ord, true, false, false, false, false).withFeature(TypesFeatureDescriptorEnum.type, VariableType_ord);
        putSimpleEntity(Operations_ord, "Operations", Operations.class, true);
    }
}
