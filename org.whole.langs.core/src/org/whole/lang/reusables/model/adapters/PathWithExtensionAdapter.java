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
public class PathWithExtensionAdapter extends AbstractEntityAdapter implements PathWithExtension {
    private static final long serialVersionUID = 1;

    public PathWithExtensionAdapter(IEntity implementor) {
        super(implementor);
    }

    public PathWithExtensionAdapter() {
    }

    public void accept(IReusablesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<PathWithExtension> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.PathWithExtension;
    }

    public Expression getPath() {
        return wGet(ReusablesFeatureDescriptorEnum.path).wGetAdapter(ReusablesEntityDescriptorEnum.Expression);
    }

    public void setPath(Expression path) {
        wSet(ReusablesFeatureDescriptorEnum.path, path);
    }

    public Expression getExtension() {
        return wGet(ReusablesFeatureDescriptorEnum.extension).wGetAdapter(ReusablesEntityDescriptorEnum.Expression);
    }

    public void setExtension(Expression extension) {
        wSet(ReusablesFeatureDescriptorEnum.extension, extension);
    }
}
