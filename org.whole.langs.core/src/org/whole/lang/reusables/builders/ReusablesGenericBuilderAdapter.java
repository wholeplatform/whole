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
package org.whole.lang.reusables.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reusables.reflect.ReusablesFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class ReusablesGenericBuilderAdapter extends GenericIdentityBuilder {
    private IReusablesBuilder specificBuilder;

    public ReusablesGenericBuilderAdapter(IReusablesBuilder specificBuilder) {
        this.specificBuilder = specificBuilder;
    }

    public ReusablesGenericBuilderAdapter(IReusablesBuilder specificBuilder, IEntityContext entityContext) {
        this(specificBuilder);
        wSetEntityContext(entityContext);
    }

    public void visit() {
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case ReusablesFeatureDescriptorEnum.original_ord :
            specificBuilder.original();
            break;
            case ReusablesFeatureDescriptorEnum.adapter_ord :
            specificBuilder.adapter();
            break;
            case ReusablesFeatureDescriptorEnum.adapted_ord :
            specificBuilder.adapted();
            break;
            case ReusablesFeatureDescriptorEnum.adaptedRevision_ord :
            specificBuilder.adaptedRevision();
            break;
            case ReusablesFeatureDescriptorEnum.resource_ord :
            specificBuilder.resource();
            break;
            case ReusablesFeatureDescriptorEnum.variant_ord :
            specificBuilder.variant();
            break;
            case ReusablesFeatureDescriptorEnum.variantRevision_ord :
            specificBuilder.variantRevision();
            break;
            case ReusablesFeatureDescriptorEnum.content_ord :
            specificBuilder.content();
            break;
            case ReusablesFeatureDescriptorEnum.persistence_ord :
            specificBuilder.persistence();
            break;
            case ReusablesFeatureDescriptorEnum.registryUri_ord :
            specificBuilder.registryUri();
            break;
            case ReusablesFeatureDescriptorEnum.uri_ord :
            specificBuilder.uri();
            break;
            case ReusablesFeatureDescriptorEnum.path_ord :
            specificBuilder.path();
            break;
            case ReusablesFeatureDescriptorEnum.extension_ord :
            specificBuilder.extension();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case ReusablesEntityDescriptorEnum.Adapt_ord :
            specificBuilder.Adapt();
            break;
            case ReusablesEntityDescriptorEnum.Reuse_ord :
            specificBuilder.Reuse();
            break;
            case ReusablesEntityDescriptorEnum.Sync_ord :
            specificBuilder.Sync();
            break;
            case ReusablesEntityDescriptorEnum.Include_ord :
            specificBuilder.Include();
            break;
            case ReusablesEntityDescriptorEnum.Reusables_ord :
            specificBuilder.Reusables();
            break;
            case ReusablesEntityDescriptorEnum.Workspace_ord :
            specificBuilder.Workspace();
            break;
            case ReusablesEntityDescriptorEnum.FileSystem_ord :
            specificBuilder.FileSystem();
            break;
            case ReusablesEntityDescriptorEnum.Classpath_ord :
            specificBuilder.Classpath();
            break;
            case ReusablesEntityDescriptorEnum.Model_ord :
            specificBuilder.Model();
            break;
            case ReusablesEntityDescriptorEnum.Registry_ord :
            specificBuilder.Registry();
            break;
            case ReusablesEntityDescriptorEnum.Load_ord :
            specificBuilder.Load();
            break;
            case ReusablesEntityDescriptorEnum.Save_ord :
            specificBuilder.Save();
            break;
            case ReusablesEntityDescriptorEnum.Contents_ord :
            specificBuilder.Contents();
            break;
            case ReusablesEntityDescriptorEnum.Folder_ord :
            specificBuilder.Folder();
            break;
            case ReusablesEntityDescriptorEnum.File_ord :
            specificBuilder.File();
            break;
            case ReusablesEntityDescriptorEnum.PathWithExtension_ord :
            specificBuilder.PathWithExtension();
            break;
            case ReusablesEntityDescriptorEnum.PathSegments_ord :
            specificBuilder.PathSegments();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case ReusablesEntityDescriptorEnum.Adapt_ord :
            specificBuilder.Adapt_();
            break;
            case ReusablesEntityDescriptorEnum.Reuse_ord :
            specificBuilder.Reuse_();
            break;
            case ReusablesEntityDescriptorEnum.Sync_ord :
            specificBuilder.Sync_();
            break;
            case ReusablesEntityDescriptorEnum.Include_ord :
            specificBuilder.Include_();
            break;
            case ReusablesEntityDescriptorEnum.Reusables_ord :
            specificBuilder.Reusables_();
            break;
            case ReusablesEntityDescriptorEnum.Workspace_ord :
            specificBuilder.Workspace_();
            break;
            case ReusablesEntityDescriptorEnum.FileSystem_ord :
            specificBuilder.FileSystem_();
            break;
            case ReusablesEntityDescriptorEnum.Classpath_ord :
            specificBuilder.Classpath_();
            break;
            case ReusablesEntityDescriptorEnum.Model_ord :
            specificBuilder.Model_();
            break;
            case ReusablesEntityDescriptorEnum.Registry_ord :
            specificBuilder.Registry_();
            break;
            case ReusablesEntityDescriptorEnum.Load_ord :
            specificBuilder.Load_();
            break;
            case ReusablesEntityDescriptorEnum.Save_ord :
            specificBuilder.Save_();
            break;
            case ReusablesEntityDescriptorEnum.Contents_ord :
            specificBuilder.Contents_();
            break;
            case ReusablesEntityDescriptorEnum.Folder_ord :
            specificBuilder.Folder_();
            break;
            case ReusablesEntityDescriptorEnum.File_ord :
            specificBuilder.File_();
            break;
            case ReusablesEntityDescriptorEnum.PathWithExtension_ord :
            specificBuilder.PathWithExtension_();
            break;
            case ReusablesEntityDescriptorEnum.PathSegments_ord :
            specificBuilder.PathSegments_();
            break;
        }
    }

    public void _wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case ReusablesEntityDescriptorEnum.Adapt_ord :
            specificBuilder._Adapt();
            break;
            case ReusablesEntityDescriptorEnum.Reuse_ord :
            specificBuilder._Reuse();
            break;
            case ReusablesEntityDescriptorEnum.Sync_ord :
            specificBuilder._Sync();
            break;
            case ReusablesEntityDescriptorEnum.Include_ord :
            specificBuilder._Include();
            break;
            case ReusablesEntityDescriptorEnum.Reusables_ord :
            specificBuilder._Reusables();
            break;
            case ReusablesEntityDescriptorEnum.Workspace_ord :
            specificBuilder._Workspace();
            break;
            case ReusablesEntityDescriptorEnum.FileSystem_ord :
            specificBuilder._FileSystem();
            break;
            case ReusablesEntityDescriptorEnum.Classpath_ord :
            specificBuilder._Classpath();
            break;
            case ReusablesEntityDescriptorEnum.Model_ord :
            specificBuilder._Model();
            break;
            case ReusablesEntityDescriptorEnum.Registry_ord :
            specificBuilder._Registry();
            break;
            case ReusablesEntityDescriptorEnum.Load_ord :
            specificBuilder._Load();
            break;
            case ReusablesEntityDescriptorEnum.Save_ord :
            specificBuilder._Save();
            break;
            case ReusablesEntityDescriptorEnum.Contents_ord :
            specificBuilder._Contents();
            break;
            case ReusablesEntityDescriptorEnum.Folder_ord :
            specificBuilder._Folder();
            break;
            case ReusablesEntityDescriptorEnum.File_ord :
            specificBuilder._File();
            break;
            case ReusablesEntityDescriptorEnum.PathWithExtension_ord :
            specificBuilder._PathWithExtension();
            break;
            case ReusablesEntityDescriptorEnum.PathSegments_ord :
            specificBuilder._PathSegments();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        switch (entityDesc.getOrdinal()) {
            case ReusablesEntityDescriptorEnum.Reusables_ord :
            specificBuilder.Reusables_(initialCapacity);
            break;
            case ReusablesEntityDescriptorEnum.Contents_ord :
            specificBuilder.Contents_(initialCapacity);
            break;
            case ReusablesEntityDescriptorEnum.PathSegments_ord :
            specificBuilder.PathSegments_(initialCapacity);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        switch (entityDesc.getOrdinal()) {
            case ReusablesEntityDescriptorEnum.PathName_ord :
            specificBuilder.PathName(value);
            break;
            case ReusablesEntityDescriptorEnum.URI_ord :
            specificBuilder.URI(value);
            break;
            case ReusablesEntityDescriptorEnum.PersistenceId_ord :
            specificBuilder.PersistenceId(value);
            break;
        }
    }
}
