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
package org.whole.lang.types.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class TypesAdaptersEntityRegistry extends AbstractEntityRegistry {

    public TypesAdaptersEntityRegistry() {
        super(TypesEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new TypeSystemAdapter());
        put(new TypeRulesAdapter());
        put(new TypeRuleAdapter());
        put(new TypeAdapter());
        put(new ArgumentTypeAdapter());
        put(new BasicTypeAdapter());
        put(new AnyTypeAdapter());
        put(new LegacyTypeAdapter());
        put(new VariableTypeAdapter());
        put(new DomainTypeAdapter());
        put(new EntityTypeAdapter());
        put(new UnionTypeAdapter());
        put(new FeatureTypeAdapter());
        put(new FeatureTableTypeAdapter());
        put(new ArgumentsAdapter());
        put(new CasesAdapter());
        put(new CaseAdapter());
        put(new ExpressionsAdapter());
        put(new OrExpressionsAdapter());
        put(new TypeExpressionsAdapter());
        put(new TypeExpressionAdapter());
        put(new SubtypeAdapter());
        put(new SupertypeAdapter());
        put(new OperationsAdapter());
    }
}
