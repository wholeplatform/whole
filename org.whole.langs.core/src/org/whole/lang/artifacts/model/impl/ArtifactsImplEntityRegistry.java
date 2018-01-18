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
package org.whole.lang.artifacts.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class ArtifactsImplEntityRegistry extends AbstractEntityRegistry {

    public ArtifactsImplEntityRegistry() {
        super(ArtifactsEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new WorkspaceImpl());
        put(new ProjectsImpl());
        put(new ProjectImpl());
        put(new ArtifactsImpl());
        put(new PackageArtifactImpl());
        put(new FolderArtifactImpl());
        put(new FileArtifactImpl());
        put(new NaturesImpl());
        put(new NatureImpl());
        put(new LocationURIImpl());
        put(new MetadataImpl());
        put(new NameImpl());
        put(new NameWithExtensionImpl());
        put(new CopyrightImpl());
        put(new LicenseImpl());
        put(new AuthorImpl());
        put(new ExtensionImpl());
        put(new AttributesImpl());
        put(new AttributeImpl());
        put(new PersistenceKitIdImpl());
    }
}
