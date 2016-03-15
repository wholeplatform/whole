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
package org.whole.lang.types.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class TypesImplEntityRegistry extends AbstractEntityRegistry {

    public TypesImplEntityRegistry() {
        super(TypesEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new TypeSystemImpl());
        put(new TypeRulesImpl());
        put(new TypeRuleImpl());
        put(new AnyTypeImpl());
        put(new LegacyTypeImpl());
        put(new VariableTypeImpl());
        put(new EntityTypeImpl());
        put(new UnionTypeImpl());
        put(new FeatureTypeImpl());
        put(new FeatureTableTypeImpl());
        put(new ArgumentsImpl());
        put(new CasesImpl());
        put(new CaseImpl());
        put(new OrExpressionsImpl());
        put(new TypeExpressionsImpl());
        put(new SubtypeImpl());
        put(new SupertypeImpl());
    }
}
