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
package org.whole.lang.artifacts.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public abstract class ArtifactsIdentitySwitchVisitor extends AbstractVisitor implements IArtifactsVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case ArtifactsEntityDescriptorEnum.Workspace_ord :
            visit((Workspace) entity);
            break;
            case ArtifactsEntityDescriptorEnum.Projects_ord :
            visit((Projects) entity);
            break;
            case ArtifactsEntityDescriptorEnum.Project_ord :
            visit((Project) entity);
            break;
            case ArtifactsEntityDescriptorEnum.Artifacts_ord :
            visit((Artifacts) entity);
            break;
            case ArtifactsEntityDescriptorEnum.PackageArtifact_ord :
            visit((PackageArtifact) entity);
            break;
            case ArtifactsEntityDescriptorEnum.FolderArtifact_ord :
            visit((FolderArtifact) entity);
            break;
            case ArtifactsEntityDescriptorEnum.FileArtifact_ord :
            visit((FileArtifact) entity);
            break;
            case ArtifactsEntityDescriptorEnum.Natures_ord :
            visit((Natures) entity);
            break;
            case ArtifactsEntityDescriptorEnum.Nature_ord :
            visit((Nature) entity);
            break;
            case ArtifactsEntityDescriptorEnum.LocationURI_ord :
            visit((LocationURI) entity);
            break;
            case ArtifactsEntityDescriptorEnum.Metadata_ord :
            visit((Metadata) entity);
            break;
            case ArtifactsEntityDescriptorEnum.Name_ord :
            visit((Name) entity);
            break;
            case ArtifactsEntityDescriptorEnum.NameWithExtension_ord :
            visit((NameWithExtension) entity);
            break;
            case ArtifactsEntityDescriptorEnum.Copyright_ord :
            visit((Copyright) entity);
            break;
            case ArtifactsEntityDescriptorEnum.License_ord :
            visit((License) entity);
            break;
            case ArtifactsEntityDescriptorEnum.Author_ord :
            visit((Author) entity);
            break;
            case ArtifactsEntityDescriptorEnum.Extension_ord :
            visit((Extension) entity);
            break;
            case ArtifactsEntityDescriptorEnum.Attributes_ord :
            visit((Attributes) entity);
            break;
            case ArtifactsEntityDescriptorEnum.Attribute_ord :
            visit((Attribute) entity);
            break;
            case ArtifactsEntityDescriptorEnum.PersistenceKitId_ord :
            visit((PersistenceKitId) entity);
            break;
        }
    }
}
