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
package org.whole.lang.environment.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.environment.model.VariablesViewModel;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.environment.model.EnvironmentManager;
import org.whole.lang.environment.reflect.EnvironmentFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.model.Environments;

/**
 *  @generator Whole
 */
public class VariablesViewModelImpl extends AbstractSimpleEntity implements VariablesViewModel {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<VariablesViewModel> wGetEntityDescriptor() {
        return EnvironmentEntityDescriptorEnum.VariablesViewModel;
    }

    public int wGetEntityOrd() {
        return EnvironmentEntityDescriptorEnum.VariablesViewModel_ord;
    }

    public void accept(IEnvironmentVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private EnvironmentManager environmentManager;

    public EnvironmentManager getEnvironmentManager() {
        return notifyRequested(EnvironmentFeatureDescriptorEnum.environmentManager, environmentManager);
    }

    public void setEnvironmentManager(EnvironmentManager environmentManager) {
        notifyChanged(EnvironmentFeatureDescriptorEnum.environmentManager, this.environmentManager, this.environmentManager = environmentManager);
    }
    private Environments environments;

    public Environments getEnvironments() {
        return notifyRequested(EnvironmentFeatureDescriptorEnum.environments, environments);
    }

    public void setEnvironments(Environments environments) {
        notifyChanged(EnvironmentFeatureDescriptorEnum.environments, this.environments, this.environments = environments);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getEnvironmentManager().wGetAdaptee(false);
            case 1 :
            return getEnvironments().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setEnvironmentManager(value.wGetAdapter(EnvironmentEntityDescriptorEnum.EnvironmentManager));
            break;
            case 1 :
            setEnvironments(value.wGetAdapter(EnvironmentEntityDescriptorEnum.Environments));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
