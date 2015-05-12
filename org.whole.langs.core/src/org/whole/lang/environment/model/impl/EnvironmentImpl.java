/**
 *  Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.environment.model.Environment;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.environment.model.Name;
import org.whole.lang.environment.reflect.EnvironmentFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.model.Names;
import org.whole.lang.environment.model.BindingManager;
import org.whole.lang.environment.model.BindingsModel;

/**
 *  @generator Whole
 */
public class EnvironmentImpl extends AbstractSimpleEntity implements Environment {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Environment> wGetEntityDescriptor() {
        return EnvironmentEntityDescriptorEnum.Environment;
    }

    public int wGetEntityOrd() {
        return EnvironmentEntityDescriptorEnum.Environment_ord;
    }

    public void accept(IEnvironmentVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Name name;

    public Name getName() {
        return notifyRequested(EnvironmentFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(EnvironmentFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Names filter;

    public Names getFilter() {
        return notifyRequested(EnvironmentFeatureDescriptorEnum.filter, filter);
    }

    public void setFilter(Names filter) {
        notifyChanged(EnvironmentFeatureDescriptorEnum.filter, this.filter, this.filter = filter);
    }
    private BindingManager bindingManager;

    public BindingManager getBindingManager() {
        return notifyRequested(EnvironmentFeatureDescriptorEnum.bindingManager, bindingManager);
    }

    public void setBindingManager(BindingManager bindingManager) {
        notifyChanged(EnvironmentFeatureDescriptorEnum.bindingManager, this.bindingManager, this.bindingManager = bindingManager);
    }
    private BindingsModel bindings;

    public BindingsModel getBindings() {
        return notifyRequested(EnvironmentFeatureDescriptorEnum.bindings, bindings);
    }

    public void setBindings(BindingsModel bindings) {
        notifyChanged(EnvironmentFeatureDescriptorEnum.bindings, this.bindings, this.bindings = bindings);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getFilter().wGetAdaptee(false);
            case 2 :
            return getBindingManager().wGetAdaptee(false);
            case 3 :
            return getBindings().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(EnvironmentEntityDescriptorEnum.Name));
            break;
            case 1 :
            setFilter(value.wGetAdapter(EnvironmentEntityDescriptorEnum.Names));
            break;
            case 2 :
            setBindingManager(value.wGetAdapter(EnvironmentEntityDescriptorEnum.BindingManager));
            break;
            case 3 :
            setBindings(value.wGetAdapter(EnvironmentEntityDescriptorEnum.BindingsModel));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
