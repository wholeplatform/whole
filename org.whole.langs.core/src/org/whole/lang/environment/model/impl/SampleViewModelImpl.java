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
import org.whole.lang.environment.model.SampleViewModel;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.environment.model.Data;
import org.whole.lang.environment.reflect.EnvironmentFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class SampleViewModelImpl extends AbstractSimpleEntity implements SampleViewModel {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<SampleViewModel> wGetEntityDescriptor() {
        return EnvironmentEntityDescriptorEnum.SampleViewModel;
    }

    public int wGetEntityOrd() {
        return EnvironmentEntityDescriptorEnum.SampleViewModel_ord;
    }

    public void accept(IEnvironmentVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Data behavior;

    public Data getBehavior() {
        return notifyRequested(EnvironmentFeatureDescriptorEnum.behavior, behavior);
    }

    public void setBehavior(Data behavior) {
        notifyChanged(EnvironmentFeatureDescriptorEnum.behavior, this.behavior, this.behavior = behavior);
    }
    private Data result;

    public Data getResult() {
        return notifyRequested(EnvironmentFeatureDescriptorEnum.result, result);
    }

    public void setResult(Data result) {
        notifyChanged(EnvironmentFeatureDescriptorEnum.result, this.result, this.result = result);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getBehavior().wGetAdaptee(false);
            case 1 :
            return getResult().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setBehavior(value.wGetAdapter(EnvironmentEntityDescriptorEnum.Data));
            break;
            case 1 :
            setResult(value.wGetAdapter(EnvironmentEntityDescriptorEnum.Data));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
