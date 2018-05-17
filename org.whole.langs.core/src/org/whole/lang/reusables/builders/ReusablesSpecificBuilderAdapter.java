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

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reusables.reflect.ReusablesFeatureDescriptorEnum;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class ReusablesSpecificBuilderAdapter extends GenericBuilderContext implements IReusablesBuilder {

    public ReusablesSpecificBuilderAdapter(IBuilder strategy) {
        super(strategy);
    }

    public ReusablesSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
        super(strategy, entityContext);
    }

    public void extension() {
        wFeature(ReusablesFeatureDescriptorEnum.extension);
    }

    public void path() {
        wFeature(ReusablesFeatureDescriptorEnum.path);
    }

    public void uri() {
        wFeature(ReusablesFeatureDescriptorEnum.uri);
    }

    public void registryUri() {
        wFeature(ReusablesFeatureDescriptorEnum.registryUri);
    }

    public void persistence() {
        wFeature(ReusablesFeatureDescriptorEnum.persistence);
    }

    public void content() {
        wFeature(ReusablesFeatureDescriptorEnum.content);
    }

    public void variantRevision() {
        wFeature(ReusablesFeatureDescriptorEnum.variantRevision);
    }

    public void variant() {
        wFeature(ReusablesFeatureDescriptorEnum.variant);
    }

    public void resource() {
        wFeature(ReusablesFeatureDescriptorEnum.resource);
    }

    public void adaptedRevision() {
        wFeature(ReusablesFeatureDescriptorEnum.adaptedRevision);
    }

    public void adapted() {
        wFeature(ReusablesFeatureDescriptorEnum.adapted);
    }

    public void adapter() {
        wFeature(ReusablesFeatureDescriptorEnum.adapter);
    }

    public void original() {
        wFeature(ReusablesFeatureDescriptorEnum.original);
    }

    public void visit() {
    }

    public void Adapt() {
        wEntity(ReusablesEntityDescriptorEnum.Adapt);
    }

    public void Adapt_() {
        wEntity_(ReusablesEntityDescriptorEnum.Adapt);
    }

    public void _Adapt() {
        _wEntity(ReusablesEntityDescriptorEnum.Adapt);
    }

    public void Reuse() {
        wEntity(ReusablesEntityDescriptorEnum.Reuse);
    }

    public void Reuse_() {
        wEntity_(ReusablesEntityDescriptorEnum.Reuse);
    }

    public void _Reuse() {
        _wEntity(ReusablesEntityDescriptorEnum.Reuse);
    }

    public void Sync() {
        wEntity(ReusablesEntityDescriptorEnum.Sync);
    }

    public void Sync_() {
        wEntity_(ReusablesEntityDescriptorEnum.Sync);
    }

    public void _Sync() {
        _wEntity(ReusablesEntityDescriptorEnum.Sync);
    }

    public void Include() {
        wEntity(ReusablesEntityDescriptorEnum.Include);
    }

    public void Include_() {
        wEntity_(ReusablesEntityDescriptorEnum.Include);
    }

    public void _Include() {
        _wEntity(ReusablesEntityDescriptorEnum.Include);
    }

    public void Reusables() {
        wEntity(ReusablesEntityDescriptorEnum.Reusables);
    }

    public void Reusables_() {
        wEntity_(ReusablesEntityDescriptorEnum.Reusables);
    }

    public void Reusables_(int initialCapacity) {
        wEntity_(ReusablesEntityDescriptorEnum.Reusables, initialCapacity);
    }

    public void _Reusables() {
        _wEntity(ReusablesEntityDescriptorEnum.Reusables);
    }

    public void Workspace() {
        wEntity(ReusablesEntityDescriptorEnum.Workspace);
    }

    public void Workspace_() {
        wEntity_(ReusablesEntityDescriptorEnum.Workspace);
    }

    public void _Workspace() {
        _wEntity(ReusablesEntityDescriptorEnum.Workspace);
    }

    public void FileSystem() {
        wEntity(ReusablesEntityDescriptorEnum.FileSystem);
    }

    public void FileSystem_() {
        wEntity_(ReusablesEntityDescriptorEnum.FileSystem);
    }

    public void _FileSystem() {
        _wEntity(ReusablesEntityDescriptorEnum.FileSystem);
    }

    public void Classpath() {
        wEntity(ReusablesEntityDescriptorEnum.Classpath);
    }

    public void Classpath_() {
        wEntity_(ReusablesEntityDescriptorEnum.Classpath);
    }

    public void _Classpath() {
        _wEntity(ReusablesEntityDescriptorEnum.Classpath);
    }

    public void URL() {
        wEntity(ReusablesEntityDescriptorEnum.URL);
    }

    public void URL_() {
        wEntity_(ReusablesEntityDescriptorEnum.URL);
    }

    public void _URL() {
        _wEntity(ReusablesEntityDescriptorEnum.URL);
    }

    public void Model() {
        wEntity(ReusablesEntityDescriptorEnum.Model);
    }

    public void Model_() {
        wEntity_(ReusablesEntityDescriptorEnum.Model);
    }

    public void _Model() {
        _wEntity(ReusablesEntityDescriptorEnum.Model);
    }

    public void Registry() {
        wEntity(ReusablesEntityDescriptorEnum.Registry);
    }

    public void Registry_() {
        wEntity_(ReusablesEntityDescriptorEnum.Registry);
    }

    public void _Registry() {
        _wEntity(ReusablesEntityDescriptorEnum.Registry);
    }

    public void Contents() {
        wEntity(ReusablesEntityDescriptorEnum.Contents);
    }

    public void Contents_() {
        wEntity_(ReusablesEntityDescriptorEnum.Contents);
    }

    public void Contents_(int initialCapacity) {
        wEntity_(ReusablesEntityDescriptorEnum.Contents, initialCapacity);
    }

    public void _Contents() {
        _wEntity(ReusablesEntityDescriptorEnum.Contents);
    }

    public void Folder() {
        wEntity(ReusablesEntityDescriptorEnum.Folder);
    }

    public void Folder_() {
        wEntity_(ReusablesEntityDescriptorEnum.Folder);
    }

    public void _Folder() {
        _wEntity(ReusablesEntityDescriptorEnum.Folder);
    }

    public void File() {
        wEntity(ReusablesEntityDescriptorEnum.File);
    }

    public void File_() {
        wEntity_(ReusablesEntityDescriptorEnum.File);
    }

    public void _File() {
        _wEntity(ReusablesEntityDescriptorEnum.File);
    }

    public void Exists() {
        wEntity(ReusablesEntityDescriptorEnum.Exists);
    }

    public void Exists_() {
        wEntity_(ReusablesEntityDescriptorEnum.Exists);
    }

    public void _Exists() {
        _wEntity(ReusablesEntityDescriptorEnum.Exists);
    }

    public void Delete() {
        wEntity(ReusablesEntityDescriptorEnum.Delete);
    }

    public void Delete_() {
        wEntity_(ReusablesEntityDescriptorEnum.Delete);
    }

    public void _Delete() {
        _wEntity(ReusablesEntityDescriptorEnum.Delete);
    }

    public void Load() {
        wEntity(ReusablesEntityDescriptorEnum.Load);
    }

    public void Load_() {
        wEntity_(ReusablesEntityDescriptorEnum.Load);
    }

    public void _Load() {
        _wEntity(ReusablesEntityDescriptorEnum.Load);
    }

    public void Save() {
        wEntity(ReusablesEntityDescriptorEnum.Save);
    }

    public void Save_() {
        wEntity_(ReusablesEntityDescriptorEnum.Save);
    }

    public void _Save() {
        _wEntity(ReusablesEntityDescriptorEnum.Save);
    }

    public void PathName() {
        wEntity(ReusablesEntityDescriptorEnum.PathName);
    }

    public void PathName(String value) {
        wEntity(ReusablesEntityDescriptorEnum.PathName, value);
    }

    public void PathWithExtension() {
        wEntity(ReusablesEntityDescriptorEnum.PathWithExtension);
    }

    public void PathWithExtension_() {
        wEntity_(ReusablesEntityDescriptorEnum.PathWithExtension);
    }

    public void _PathWithExtension() {
        _wEntity(ReusablesEntityDescriptorEnum.PathWithExtension);
    }

    public void PathSegments() {
        wEntity(ReusablesEntityDescriptorEnum.PathSegments);
    }

    public void PathSegments_() {
        wEntity_(ReusablesEntityDescriptorEnum.PathSegments);
    }

    public void PathSegments_(int initialCapacity) {
        wEntity_(ReusablesEntityDescriptorEnum.PathSegments, initialCapacity);
    }

    public void _PathSegments() {
        _wEntity(ReusablesEntityDescriptorEnum.PathSegments);
    }

    public void URI() {
        wEntity(ReusablesEntityDescriptorEnum.URI);
    }

    public void URI(String value) {
        wEntity(ReusablesEntityDescriptorEnum.URI, value);
    }

    public void PersistenceId() {
        wEntity(ReusablesEntityDescriptorEnum.PersistenceId);
    }

    public void PersistenceId(String value) {
        wEntity(ReusablesEntityDescriptorEnum.PersistenceId, value);
    }
}
