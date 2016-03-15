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
package org.whole.lang.patterns.reflect;

import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.patterns.builders.IPatternsBuilder;
import org.whole.lang.patterns.builders.PatternsGenericBuilderAdapter;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.patterns.builders.PatternsSpecificBuilderAdapter;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;

/**
 *  @generator Whole
 */
public class PatternsLanguageDeployer extends AbstractLanguageDeployer {

    public void deploy(ReflectionFactory platform) {
        platform.addLanguageKit(new PatternsLanguageKit());
        platform.addOperationFactory(PatternsLanguageKit.URI, GenericBuilderAdapterOperation.ID, new IBuilderFactory() {

            public IBuilder create(IBuilder strategy, IEntityContext entityContext) {
                return new PatternsGenericBuilderAdapter((IPatternsBuilder) strategy, entityContext);
            }
        });
        platform.addOperationFactory(PatternsLanguageKit.URI, SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {

            public IBuilder create(IBuilder strategy, IEntityContext entityContext) {
                return new PatternsSpecificBuilderAdapter(strategy, entityContext);
            }
        });
    }

    public void undeploy(ReflectionFactory platform) {
        platform.removeLanguageKit(PatternsLanguageKit.URI);
    }
}
