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
package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class SuperFieldAccessAdapter extends AbstractEntityAdapter implements SuperFieldAccess {
    private static final long serialVersionUID = 1;

    public SuperFieldAccessAdapter(IEntity implementor) {
        super(implementor);
    }

    public SuperFieldAccessAdapter() {
    }

    public void accept(IJavaVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<SuperFieldAccess> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.SuperFieldAccess;
    }

    public Name getQualifier() {
        return wGet(JavaFeatureDescriptorEnum.qualifier).wGetAdapter(JavaEntityDescriptorEnum.Name);
    }

    public void setQualifier(Name qualifier) {
        wSet(JavaFeatureDescriptorEnum.qualifier, qualifier);
    }

    public SimpleName getName() {
        return wGet(JavaFeatureDescriptorEnum.name).wGetAdapter(JavaEntityDescriptorEnum.SimpleName);
    }

    public void setName(SimpleName name) {
        wSet(JavaFeatureDescriptorEnum.name, name);
    }
}
