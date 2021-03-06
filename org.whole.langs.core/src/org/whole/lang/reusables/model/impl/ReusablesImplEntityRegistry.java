/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.reusables.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class ReusablesImplEntityRegistry extends AbstractEntityRegistry {

    public ReusablesImplEntityRegistry() {
        super(ReusablesEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new AdaptImpl());
        put(new ReuseImpl());
        put(new SyncImpl());
        put(new IncludeImpl());
        put(new ReusablesImpl());
        put(new WorkspaceImpl());
        put(new FileSystemImpl());
        put(new ClasspathImpl());
        put(new URLImpl());
        put(new ModelImpl());
        put(new RegistryImpl());
        put(new ContentsImpl());
        put(new FolderImpl());
        put(new FileImpl());
        put(new ExistsImpl());
        put(new DeleteImpl());
        put(new LoadImpl());
        put(new SaveImpl());
        put(new PathNameImpl());
        put(new PathWithExtensionImpl());
        put(new PathSegmentsImpl());
        put(new URIImpl());
        put(new PersistenceIdImpl());
    }
}
