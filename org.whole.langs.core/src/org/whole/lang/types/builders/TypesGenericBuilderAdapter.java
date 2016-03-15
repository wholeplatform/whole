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

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.types.reflect.TypesFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.types.model.LegacyTypeEnum.Value;

/**
 *  @generator Whole
 */
public class TypesGenericBuilderAdapter extends GenericIdentityBuilder {
    private ITypesBuilder specificBuilder;

    public TypesGenericBuilderAdapter(ITypesBuilder specificBuilder) {
        this.specificBuilder = specificBuilder;
    }

    public TypesGenericBuilderAdapter(ITypesBuilder specificBuilder, IEntityContext entityContext) {
        this(specificBuilder);
        wSetEntityContext(entityContext);
    }

    public void visit() {
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case TypesFeatureDescriptorEnum.checkBefore_ord :
            specificBuilder.checkBefore();
            break;
            case TypesFeatureDescriptorEnum.rules_ord :
            specificBuilder.rules();
            break;
            case TypesFeatureDescriptorEnum.domain_ord :
            specificBuilder.domain();
            break;
            case TypesFeatureDescriptorEnum.type_ord :
            specificBuilder.type();
            break;
            case TypesFeatureDescriptorEnum.arguments_ord :
            specificBuilder.arguments();
            break;
            case TypesFeatureDescriptorEnum.cases_ord :
            specificBuilder.cases();
            break;
            case TypesFeatureDescriptorEnum.expressions_ord :
            specificBuilder.expressions();
            break;
            case TypesFeatureDescriptorEnum.name_ord :
            specificBuilder.name();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case TypesEntityDescriptorEnum.TypeSystem_ord :
            specificBuilder.TypeSystem();
            break;
            case TypesEntityDescriptorEnum.TypeRules_ord :
            specificBuilder.TypeRules();
            break;
            case TypesEntityDescriptorEnum.TypeRule_ord :
            specificBuilder.TypeRule();
            break;
            case TypesEntityDescriptorEnum.AnyType_ord :
            specificBuilder.AnyType();
            break;
            case TypesEntityDescriptorEnum.UnionType_ord :
            specificBuilder.UnionType();
            break;
            case TypesEntityDescriptorEnum.FeatureTableType_ord :
            specificBuilder.FeatureTableType();
            break;
            case TypesEntityDescriptorEnum.Arguments_ord :
            specificBuilder.Arguments();
            break;
            case TypesEntityDescriptorEnum.Cases_ord :
            specificBuilder.Cases();
            break;
            case TypesEntityDescriptorEnum.Case_ord :
            specificBuilder.Case();
            break;
            case TypesEntityDescriptorEnum.OrExpressions_ord :
            specificBuilder.OrExpressions();
            break;
            case TypesEntityDescriptorEnum.TypeExpressions_ord :
            specificBuilder.TypeExpressions();
            break;
            case TypesEntityDescriptorEnum.Subtype_ord :
            specificBuilder.Subtype();
            break;
            case TypesEntityDescriptorEnum.Supertype_ord :
            specificBuilder.Supertype();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case TypesEntityDescriptorEnum.TypeSystem_ord :
            specificBuilder.TypeSystem_();
            break;
            case TypesEntityDescriptorEnum.TypeRules_ord :
            specificBuilder.TypeRules_();
            break;
            case TypesEntityDescriptorEnum.TypeRule_ord :
            specificBuilder.TypeRule_();
            break;
            case TypesEntityDescriptorEnum.AnyType_ord :
            specificBuilder.AnyType_();
            break;
            case TypesEntityDescriptorEnum.UnionType_ord :
            specificBuilder.UnionType_();
            break;
            case TypesEntityDescriptorEnum.FeatureTableType_ord :
            specificBuilder.FeatureTableType_();
            break;
            case TypesEntityDescriptorEnum.Arguments_ord :
            specificBuilder.Arguments_();
            break;
            case TypesEntityDescriptorEnum.Cases_ord :
            specificBuilder.Cases_();
            break;
            case TypesEntityDescriptorEnum.Case_ord :
            specificBuilder.Case_();
            break;
            case TypesEntityDescriptorEnum.OrExpressions_ord :
            specificBuilder.OrExpressions_();
            break;
            case TypesEntityDescriptorEnum.TypeExpressions_ord :
            specificBuilder.TypeExpressions_();
            break;
            case TypesEntityDescriptorEnum.Subtype_ord :
            specificBuilder.Subtype_();
            break;
            case TypesEntityDescriptorEnum.Supertype_ord :
            specificBuilder.Supertype_();
            break;
        }
    }

    public void _wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case TypesEntityDescriptorEnum.TypeSystem_ord :
            specificBuilder._TypeSystem();
            break;
            case TypesEntityDescriptorEnum.TypeRules_ord :
            specificBuilder._TypeRules();
            break;
            case TypesEntityDescriptorEnum.TypeRule_ord :
            specificBuilder._TypeRule();
            break;
            case TypesEntityDescriptorEnum.AnyType_ord :
            specificBuilder._AnyType();
            break;
            case TypesEntityDescriptorEnum.UnionType_ord :
            specificBuilder._UnionType();
            break;
            case TypesEntityDescriptorEnum.FeatureTableType_ord :
            specificBuilder._FeatureTableType();
            break;
            case TypesEntityDescriptorEnum.Arguments_ord :
            specificBuilder._Arguments();
            break;
            case TypesEntityDescriptorEnum.Cases_ord :
            specificBuilder._Cases();
            break;
            case TypesEntityDescriptorEnum.Case_ord :
            specificBuilder._Case();
            break;
            case TypesEntityDescriptorEnum.OrExpressions_ord :
            specificBuilder._OrExpressions();
            break;
            case TypesEntityDescriptorEnum.TypeExpressions_ord :
            specificBuilder._TypeExpressions();
            break;
            case TypesEntityDescriptorEnum.Subtype_ord :
            specificBuilder._Subtype();
            break;
            case TypesEntityDescriptorEnum.Supertype_ord :
            specificBuilder._Supertype();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        switch (entityDesc.getOrdinal()) {
            case TypesEntityDescriptorEnum.TypeRules_ord :
            specificBuilder.TypeRules_(initialCapacity);
            break;
            case TypesEntityDescriptorEnum.UnionType_ord :
            specificBuilder.UnionType_(initialCapacity);
            break;
            case TypesEntityDescriptorEnum.Arguments_ord :
            specificBuilder.Arguments_(initialCapacity);
            break;
            case TypesEntityDescriptorEnum.Cases_ord :
            specificBuilder.Cases_(initialCapacity);
            break;
            case TypesEntityDescriptorEnum.OrExpressions_ord :
            specificBuilder.OrExpressions_(initialCapacity);
            break;
            case TypesEntityDescriptorEnum.TypeExpressions_ord :
            specificBuilder.TypeExpressions_(initialCapacity);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
        switch (entityDesc.getOrdinal()) {
            case TypesEntityDescriptorEnum.LegacyType_ord :
            specificBuilder.LegacyType((Value) value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, int value) {
        switch (entityDesc.getOrdinal()) {
            case TypesEntityDescriptorEnum.VariableType_ord :
            specificBuilder.VariableType(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        switch (entityDesc.getOrdinal()) {
            case TypesEntityDescriptorEnum.EntityType_ord :
            specificBuilder.EntityType(value);
            break;
            case TypesEntityDescriptorEnum.FeatureType_ord :
            specificBuilder.FeatureType(value);
            break;
        }
    }
}
