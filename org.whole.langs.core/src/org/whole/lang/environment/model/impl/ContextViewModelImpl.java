/**
 *  Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.environment.model.ContextViewModel;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.environment.model.Environments;
import org.whole.lang.environment.reflect.EnvironmentFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.model.Bindings;

/**
 *  @generator Whole
 */
public class ContextViewModelImpl extends AbstractSimpleEntity implements ContextViewModel {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ContextViewModel> wGetEntityDescriptor() {
        return EnvironmentEntityDescriptorEnum.ContextViewModel;
    }

    public int wGetEntityOrd() {
        return EnvironmentEntityDescriptorEnum.ContextViewModel_ord;
    }

    public void accept(IEnvironmentVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Environments environments;

    public Environments getEnvironments() {
        return notifyRequested(EnvironmentFeatureDescriptorEnum.environments, environments);
    }

    public void setEnvironments(Environments environments) {
        notifyChanged(EnvironmentFeatureDescriptorEnum.environments, this.environments, this.environments = environments);
    }
    private Bindings bindings;

    public Bindings getBindings() {
        return notifyRequested(EnvironmentFeatureDescriptorEnum.bindings, bindings);
    }

    public void setBindings(Bindings bindings) {
        notifyChanged(EnvironmentFeatureDescriptorEnum.bindings, this.bindings, this.bindings = bindings);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getEnvironments().wGetAdaptee(false);
            case 1 :
            return getBindings().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setEnvironments(value.wGetAdapter(EnvironmentEntityDescriptorEnum.Environments));
            break;
            case 1 :
            setBindings(value.wGetAdapter(EnvironmentEntityDescriptorEnum.Bindings));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
