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
            case ReusablesEntityDescriptorEnum.Synch_ord :
            visit((Synch) entity);
            break;
            case ReusablesEntityDescriptorEnum.Include_ord :
            visit((Include) entity);
            break;
            case ReusablesEntityDescriptorEnum.Reusables_ord :
            visit((Reusables) entity);
            break;
            case ReusablesEntityDescriptorEnum.ReferenceStep_ord :
            visit((ReferenceStep) entity);
            break;
            case ReusablesEntityDescriptorEnum.Resource_ord :
            visit((Resource) entity);
            break;
            case ReusablesEntityDescriptorEnum.Registry_ord :
            visit((Registry) entity);
            break;
            case ReusablesEntityDescriptorEnum.WorkspacePath_ord :
            visit((WorkspacePath) entity);
            break;
            case ReusablesEntityDescriptorEnum.FileSystemPath_ord :
            visit((FileSystemPath) entity);
            break;
            case ReusablesEntityDescriptorEnum.ClassPathURI_ord :
            visit((ClassPathURI) entity);
            break;
            case ReusablesEntityDescriptorEnum.URI_ord :
            visit((URI) entity);
            break;
            case ReusablesEntityDescriptorEnum.Persistence_ord :
            visit((Persistence) entity);
            break;
        }
    }
}
