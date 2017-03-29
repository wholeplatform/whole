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
package org.whole.lang.reusables.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.reusables.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reusables.visitors.IReusablesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;
import org.whole.lang.reusables.reflect.ReusablesFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class FileAdapter extends AbstractEntityAdapter implements File {
    private static final long serialVersionUID = 1;

    public FileAdapter(IEntity implementor) {
        super(implementor);
    }

    public FileAdapter() {
    }

    public void accept(IReusablesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<File> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.File;
    }

    public Path getPath() {
        return wGet(ReusablesFeatureDescriptorEnum.path).wGetAdapter(ReusablesEntityDescriptorEnum.Path);
    }

    public void setPath(Path path) {
        wSet(ReusablesFeatureDescriptorEnum.path, path);
    }

    public Any getContent() {
        return wGet(ReusablesFeatureDescriptorEnum.content).wGetAdapter(ReusablesEntityDescriptorEnum.Any);
    }

    public void setContent(Any content) {
        wSet(ReusablesFeatureDescriptorEnum.content, content);
    }

    public Persistence getPersistence() {
        return wGet(ReusablesFeatureDescriptorEnum.persistence).wGetAdapter(ReusablesEntityDescriptorEnum.Persistence);
    }

    public void setPersistence(Persistence persistence) {
        wSet(ReusablesFeatureDescriptorEnum.persistence, persistence);
    }
}