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
package org.whole.lang.artifacts.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.artifacts.model.AttributeEnum.Value;

/**
 *  @generator Whole
 */
public class ArtifactsGenericBuilderAdapter extends GenericIdentityBuilder {
    private IArtifactsBuilder specificBuilder;

    public ArtifactsGenericBuilderAdapter(IArtifactsBuilder specificBuilder) {
        this.specificBuilder = specificBuilder;
    }

    public ArtifactsGenericBuilderAdapter(IArtifactsBuilder specificBuilder, IEntityContext entityContext) {
        this(specificBuilder);
        wSetEntityContext(entityContext);
    }

    public void visit() {
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case ArtifactsFeatureDescriptorEnum.metadata_ord :
            specificBuilder.metadata();
            break;
            case ArtifactsFeatureDescriptorEnum.projects_ord :
            specificBuilder.projects();
            break;
            case ArtifactsFeatureDescriptorEnum.name_ord :
            specificBuilder.name();
            break;
            case ArtifactsFeatureDescriptorEnum.natures_ord :
            specificBuilder.natures();
            break;
            case ArtifactsFeatureDescriptorEnum.artifacts_ord :
            specificBuilder.artifacts();
            break;
            case ArtifactsFeatureDescriptorEnum.locationURI_ord :
            specificBuilder.locationURI();
            break;
            case ArtifactsFeatureDescriptorEnum.content_ord :
            specificBuilder.content();
            break;
            case ArtifactsFeatureDescriptorEnum.copyright_ord :
            specificBuilder.copyright();
            break;
            case ArtifactsFeatureDescriptorEnum.license_ord :
            specificBuilder.license();
            break;
            case ArtifactsFeatureDescriptorEnum.author_ord :
            specificBuilder.author();
            break;
            case ArtifactsFeatureDescriptorEnum.attributes_ord :
            specificBuilder.attributes();
            break;
            case ArtifactsFeatureDescriptorEnum.persistenceKitId_ord :
            specificBuilder.persistenceKitId();
            break;
            case ArtifactsFeatureDescriptorEnum.extension_ord :
            specificBuilder.extension();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case ArtifactsEntityDescriptorEnum.Workspace_ord :
            specificBuilder.Workspace();
            break;
            case ArtifactsEntityDescriptorEnum.Projects_ord :
            specificBuilder.Projects();
            break;
            case ArtifactsEntityDescriptorEnum.Project_ord :
            specificBuilder.Project();
            break;
            case ArtifactsEntityDescriptorEnum.Artifacts_ord :
            specificBuilder.Artifacts();
            break;
            case ArtifactsEntityDescriptorEnum.PackageArtifact_ord :
            specificBuilder.PackageArtifact();
            break;
            case ArtifactsEntityDescriptorEnum.FolderArtifact_ord :
            specificBuilder.FolderArtifact();
            break;
            case ArtifactsEntityDescriptorEnum.FileArtifact_ord :
            specificBuilder.FileArtifact();
            break;
            case ArtifactsEntityDescriptorEnum.Natures_ord :
            specificBuilder.Natures();
            break;
            case ArtifactsEntityDescriptorEnum.Metadata_ord :
            specificBuilder.Metadata();
            break;
            case ArtifactsEntityDescriptorEnum.NameWithExtension_ord :
            specificBuilder.NameWithExtension();
            break;
            case ArtifactsEntityDescriptorEnum.Attributes_ord :
            specificBuilder.Attributes();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case ArtifactsEntityDescriptorEnum.Workspace_ord :
            specificBuilder.Workspace_();
            break;
            case ArtifactsEntityDescriptorEnum.Projects_ord :
            specificBuilder.Projects_();
            break;
            case ArtifactsEntityDescriptorEnum.Project_ord :
            specificBuilder.Project_();
            break;
            case ArtifactsEntityDescriptorEnum.Artifacts_ord :
            specificBuilder.Artifacts_();
            break;
            case ArtifactsEntityDescriptorEnum.PackageArtifact_ord :
            specificBuilder.PackageArtifact_();
            break;
            case ArtifactsEntityDescriptorEnum.FolderArtifact_ord :
            specificBuilder.FolderArtifact_();
            break;
            case ArtifactsEntityDescriptorEnum.FileArtifact_ord :
            specificBuilder.FileArtifact_();
            break;
            case ArtifactsEntityDescriptorEnum.Natures_ord :
            specificBuilder.Natures_();
            break;
            case ArtifactsEntityDescriptorEnum.Metadata_ord :
            specificBuilder.Metadata_();
            break;
            case ArtifactsEntityDescriptorEnum.NameWithExtension_ord :
            specificBuilder.NameWithExtension_();
            break;
            case ArtifactsEntityDescriptorEnum.Attributes_ord :
            specificBuilder.Attributes_();
            break;
        }
    }

    public void _wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case ArtifactsEntityDescriptorEnum.Workspace_ord :
            specificBuilder._Workspace();
            break;
            case ArtifactsEntityDescriptorEnum.Projects_ord :
            specificBuilder._Projects();
            break;
            case ArtifactsEntityDescriptorEnum.Project_ord :
            specificBuilder._Project();
            break;
            case ArtifactsEntityDescriptorEnum.Artifacts_ord :
            specificBuilder._Artifacts();
            break;
            case ArtifactsEntityDescriptorEnum.PackageArtifact_ord :
            specificBuilder._PackageArtifact();
            break;
            case ArtifactsEntityDescriptorEnum.FolderArtifact_ord :
            specificBuilder._FolderArtifact();
            break;
            case ArtifactsEntityDescriptorEnum.FileArtifact_ord :
            specificBuilder._FileArtifact();
            break;
            case ArtifactsEntityDescriptorEnum.Natures_ord :
            specificBuilder._Natures();
            break;
            case ArtifactsEntityDescriptorEnum.Metadata_ord :
            specificBuilder._Metadata();
            break;
            case ArtifactsEntityDescriptorEnum.NameWithExtension_ord :
            specificBuilder._NameWithExtension();
            break;
            case ArtifactsEntityDescriptorEnum.Attributes_ord :
            specificBuilder._Attributes();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        switch (entityDesc.getOrdinal()) {
            case ArtifactsEntityDescriptorEnum.Projects_ord :
            specificBuilder.Projects_(initialCapacity);
            break;
            case ArtifactsEntityDescriptorEnum.Artifacts_ord :
            specificBuilder.Artifacts_(initialCapacity);
            break;
            case ArtifactsEntityDescriptorEnum.Natures_ord :
            specificBuilder.Natures_(initialCapacity);
            break;
            case ArtifactsEntityDescriptorEnum.Attributes_ord :
            specificBuilder.Attributes_(initialCapacity);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        switch (entityDesc.getOrdinal()) {
            case ArtifactsEntityDescriptorEnum.Nature_ord :
            specificBuilder.Nature(value);
            break;
            case ArtifactsEntityDescriptorEnum.LocationURI_ord :
            specificBuilder.LocationURI(value);
            break;
            case ArtifactsEntityDescriptorEnum.Name_ord :
            specificBuilder.Name(value);
            break;
            case ArtifactsEntityDescriptorEnum.Copyright_ord :
            specificBuilder.Copyright(value);
            break;
            case ArtifactsEntityDescriptorEnum.License_ord :
            specificBuilder.License(value);
            break;
            case ArtifactsEntityDescriptorEnum.Author_ord :
            specificBuilder.Author(value);
            break;
            case ArtifactsEntityDescriptorEnum.Extension_ord :
            specificBuilder.Extension(value);
            break;
            case ArtifactsEntityDescriptorEnum.PersistenceKitId_ord :
            specificBuilder.PersistenceKitId(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
        switch (entityDesc.getOrdinal()) {
            case ArtifactsEntityDescriptorEnum.Attribute_ord :
            specificBuilder.Attribute((Value) value);
            break;
        }
    }
}
