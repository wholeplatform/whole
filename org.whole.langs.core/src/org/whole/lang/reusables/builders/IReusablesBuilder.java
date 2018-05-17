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

import org.whole.lang.builders.IBuilder;

/**
 *  @generator Whole
 */
public interface IReusablesBuilder extends IBuilder {


    public void visit();

    public void extension();

    public void path();

    public void uri();

    public void registryUri();

    public void persistence();

    public void content();

    public void variantRevision();

    public void variant();

    public void resource();

    public void adaptedRevision();

    public void adapted();

    public void adapter();

    public void original();

    public void Adapt();

    public void Adapt_();

    public void _Adapt();

    public void Reuse();

    public void Reuse_();

    public void _Reuse();

    public void Sync();

    public void Sync_();

    public void _Sync();

    public void Include();

    public void Include_();

    public void _Include();

    public void Reusables();

    public void Reusables_();

    public void Reusables_(int initialCapacity);

    public void _Reusables();

    public void Workspace();

    public void Workspace_();

    public void _Workspace();

    public void FileSystem();

    public void FileSystem_();

    public void _FileSystem();

    public void Classpath();

    public void Classpath_();

    public void _Classpath();

    public void URL();

    public void URL_();

    public void _URL();

    public void Model();

    public void Model_();

    public void _Model();

    public void Registry();

    public void Registry_();

    public void _Registry();

    public void Contents();

    public void Contents_();

    public void Contents_(int initialCapacity);

    public void _Contents();

    public void Folder();

    public void Folder_();

    public void _Folder();

    public void File();

    public void File_();

    public void _File();

    public void Exists();

    public void Exists_();

    public void _Exists();

    public void Delete();

    public void Delete_();

    public void _Delete();

    public void Load();

    public void Load_();

    public void _Load();

    public void Save();

    public void Save_();

    public void _Save();

    public void PathName();

    public void PathName(String value);

    public void PathWithExtension();

    public void PathWithExtension_();

    public void _PathWithExtension();

    public void PathSegments();

    public void PathSegments_();

    public void PathSegments_(int initialCapacity);

    public void _PathSegments();

    public void URI();

    public void URI(String value);

    public void PersistenceId();

    public void PersistenceId(String value);
}
