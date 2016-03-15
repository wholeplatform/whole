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

import org.whole.lang.builders.IBuilder;
import org.whole.lang.types.model.LegacyTypeEnum;

/**
 *  @generator Whole
 */
public interface ITypesBuilder extends IBuilder {


    public void visit();

    public void name();

    public void expressions();

    public void cases();

    public void arguments();

    public void type();

    public void domain();

    public void rules();

    public void checkBefore();

    public void TypeSystem();

    public void TypeSystem_();

    public void _TypeSystem();

    public void TypeRules();

    public void TypeRules_();

    public void TypeRules_(int initialCapacity);

    public void _TypeRules();

    public void TypeRule();

    public void TypeRule_();

    public void _TypeRule();

    public void AnyType();

    public void AnyType_();

    public void _AnyType();

    public void LegacyType();

    public void LegacyType(LegacyTypeEnum.Value value);

    public void LegacyType(String value);

    public void VariableType();

    public void VariableType(int value);

    public void EntityType();

    public void EntityType(String value);

    public void UnionType();

    public void UnionType_();

    public void UnionType_(int initialCapacity);

    public void _UnionType();

    public void FeatureType();

    public void FeatureType(String value);

    public void FeatureTableType();

    public void FeatureTableType_();

    public void _FeatureTableType();

    public void Arguments();

    public void Arguments_();

    public void Arguments_(int initialCapacity);

    public void _Arguments();

    public void Cases();

    public void Cases_();

    public void Cases_(int initialCapacity);

    public void _Cases();

    public void Case();

    public void Case_();

    public void _Case();

    public void OrExpressions();

    public void OrExpressions_();

    public void OrExpressions_(int initialCapacity);

    public void _OrExpressions();

    public void TypeExpressions();

    public void TypeExpressions_();

    public void TypeExpressions_(int initialCapacity);

    public void _TypeExpressions();

    public void Subtype();

    public void Subtype_();

    public void _Subtype();

    public void Supertype();

    public void Supertype_();

    public void _Supertype();
}
