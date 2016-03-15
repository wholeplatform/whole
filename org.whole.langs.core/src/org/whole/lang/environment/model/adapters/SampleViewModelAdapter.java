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
package org.whole.lang.environment.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.environment.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.environment.reflect.EnvironmentFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class SampleViewModelAdapter extends AbstractEntityAdapter implements SampleViewModel {
    private static final long serialVersionUID = 1;

    public SampleViewModelAdapter(IEntity implementor) {
        super(implementor);
    }

    public SampleViewModelAdapter() {
    }

    public void accept(IEnvironmentVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<SampleViewModel> wGetEntityDescriptor() {
        return EnvironmentEntityDescriptorEnum.SampleViewModel;
    }

    public Data getBehavior() {
        return wGet(EnvironmentFeatureDescriptorEnum.behavior).wGetAdapter(EnvironmentEntityDescriptorEnum.Data);
    }

    public void setBehavior(Data behavior) {
        wSet(EnvironmentFeatureDescriptorEnum.behavior, behavior);
    }

    public Data getResult() {
        return wGet(EnvironmentFeatureDescriptorEnum.result).wGetAdapter(EnvironmentEntityDescriptorEnum.Data);
    }

    public void setResult(Data result) {
        wSet(EnvironmentFeatureDescriptorEnum.result, result);
    }
}
