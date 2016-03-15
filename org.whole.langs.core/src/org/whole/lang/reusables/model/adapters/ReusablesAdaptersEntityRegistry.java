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
package org.whole.lang.reusables.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class ReusablesAdaptersEntityRegistry extends AbstractEntityRegistry {

    public ReusablesAdaptersEntityRegistry() {
        super(ReusablesEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new ReusableAdapter());
        put(new AdaptAdapter());
        put(new ReuseAdapter());
        put(new SynchAdapter());
        put(new IncludeAdapter());
        put(new ReusablesAdapter());
        put(new SourceAdapter());
        put(new PathExpressionAdapter());
        put(new StepExpressionAdapter());
        put(new ReferenceStepAdapter());
        put(new ResourceAdapter());
        put(new RegistryAdapter());
        put(new LocatorAdapter());
        put(new WorkspacePathAdapter());
        put(new FileSystemPathAdapter());
        put(new ClassPathURIAdapter());
        put(new URIAdapter());
        put(new PersistenceAdapter());
        put(new RevisionAdapter());
    }
}
