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
package org.whole.lang.artifacts.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class ArtifactsAdaptersEntityRegistry extends AbstractEntityRegistry {

    public ArtifactsAdaptersEntityRegistry() {
        super(ArtifactsEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new WorkspaceAdapter());
        put(new ProjectsAdapter());
        put(new ProjectAdapter());
        put(new ArtifactsAdapter());
        put(new PackageArtifactAdapter());
        put(new FolderArtifactAdapter());
        put(new FileArtifactAdapter());
        put(new NaturesAdapter());
        put(new NatureAdapter());
        put(new LocationURIAdapter());
        put(new MetadataAdapter());
        put(new NameAdapter());
        put(new NameWithExtensionAdapter());
        put(new CopyrightAdapter());
        put(new LicenseAdapter());
        put(new AuthorAdapter());
        put(new ExtensionAdapter());
        put(new AttributesAdapter());
        put(new AttributeAdapter());
        put(new PersistenceKitIdAdapter());
        put(new ContentAdapter());
        put(new ProjectNameAdapter());
        put(new PackageNameAdapter());
        put(new FileNameAdapter());
        put(new FolderNameAdapter());
        put(new ArtifactAdapter());
    }
}
