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
package org.whole.lang.reusables.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.reusables.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public abstract class ReusablesIdentitySwitchVisitor extends AbstractVisitor implements IReusablesVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case ReusablesEntityDescriptorEnum.Adapt_ord :
            visit((Adapt) entity);
            break;
            case ReusablesEntityDescriptorEnum.Reuse_ord :
            visit((Reuse) entity);
            break;
            case ReusablesEntityDescriptorEnum.Sync_ord :
            visit((Sync) entity);
            break;
            case ReusablesEntityDescriptorEnum.Include_ord :
            visit((Include) entity);
            break;
            case ReusablesEntityDescriptorEnum.Reusables_ord :
            visit((Reusables) entity);
            break;
            case ReusablesEntityDescriptorEnum.Workspace_ord :
            visit((Workspace) entity);
            break;
            case ReusablesEntityDescriptorEnum.FileSystem_ord :
            visit((FileSystem) entity);
            break;
            case ReusablesEntityDescriptorEnum.Classpath_ord :
            visit((Classpath) entity);
            break;
            case ReusablesEntityDescriptorEnum.URL_ord :
            visit((URL) entity);
            break;
            case ReusablesEntityDescriptorEnum.Model_ord :
            visit((Model) entity);
            break;
            case ReusablesEntityDescriptorEnum.Registry_ord :
            visit((Registry) entity);
            break;
            case ReusablesEntityDescriptorEnum.Contents_ord :
            visit((Contents) entity);
            break;
            case ReusablesEntityDescriptorEnum.Folder_ord :
            visit((Folder) entity);
            break;
            case ReusablesEntityDescriptorEnum.File_ord :
            visit((File) entity);
            break;
            case ReusablesEntityDescriptorEnum.Exists_ord :
            visit((Exists) entity);
            break;
            case ReusablesEntityDescriptorEnum.Delete_ord :
            visit((Delete) entity);
            break;
            case ReusablesEntityDescriptorEnum.Load_ord :
            visit((Load) entity);
            break;
            case ReusablesEntityDescriptorEnum.Save_ord :
            visit((Save) entity);
            break;
            case ReusablesEntityDescriptorEnum.PathName_ord :
            visit((PathName) entity);
            break;
            case ReusablesEntityDescriptorEnum.PathWithExtension_ord :
            visit((PathWithExtension) entity);
            break;
            case ReusablesEntityDescriptorEnum.PathSegments_ord :
            visit((PathSegments) entity);
            break;
            case ReusablesEntityDescriptorEnum.URI_ord :
            visit((URI) entity);
            break;
            case ReusablesEntityDescriptorEnum.PersistenceId_ord :
            visit((PersistenceId) entity);
            break;
        }
    }
}
