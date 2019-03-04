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
package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.ExportsDirective;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.java.model.Name;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.Names;

/**
 *  @generator Whole
 */
public class ExportsDirectiveImpl extends AbstractSimpleEntity implements ExportsDirective {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ExportsDirective> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.ExportsDirective;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.ExportsDirective_ord;
    }

    public void accept(IJavaVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Name name;

    public Name getName() {
        return notifyRequested(JavaFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(JavaFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Names modules;

    public Names getModules() {
        return notifyRequested(JavaFeatureDescriptorEnum.modules, modules);
    }

    public void setModules(Names modules) {
        notifyChanged(JavaFeatureDescriptorEnum.modules, this.modules, this.modules = modules);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getModules().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(JavaEntityDescriptorEnum.Name));
            break;
            case 1 :
            setModules(value.wGetAdapter(JavaEntityDescriptorEnum.Names));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
