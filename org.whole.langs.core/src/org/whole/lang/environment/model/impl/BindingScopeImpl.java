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
package org.whole.lang.environment.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.environment.model.BindingScope;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator Whole
 */
public class BindingScopeImpl extends AbstractDataEntity implements BindingScope {
    private static final long serialVersionUID = 1;
    private org.whole.lang.bindings.IBindingScope value;

    public org.whole.lang.bindings.IBindingScope getValue() {
        return notifyRequested(value);
    }

    public void setValue(org.whole.lang.bindings.IBindingScope value) {
        notifyChanged(this.value, this.value = value);
    }

    public void accept(IEnvironmentVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }

    public int wGetEntityOrd() {
        return EnvironmentEntityDescriptorEnum.BindingScope_ord;
    }

    public EntityDescriptor<BindingScope> wGetEntityDescriptor() {
        return EnvironmentEntityDescriptorEnum.BindingScope;
    }

    public Object wGetValue() {
        return getValue();
    }

    public void wSetValue(Object value) {
        setValue((org.whole.lang.bindings.IBindingScope) value);
    }
}
