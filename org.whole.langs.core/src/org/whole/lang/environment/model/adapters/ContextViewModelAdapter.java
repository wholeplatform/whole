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
public class ContextViewModelAdapter extends AbstractEntityAdapter implements ContextViewModel {
    private static final long serialVersionUID = 1;

    public ContextViewModelAdapter(IEntity implementor) {
        super(implementor);
    }

    public ContextViewModelAdapter() {
    }

    public void accept(IEnvironmentVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ContextViewModel> wGetEntityDescriptor() {
        return EnvironmentEntityDescriptorEnum.ContextViewModel;
    }

    public Environments getEnvironments() {
        return wGet(EnvironmentFeatureDescriptorEnum.environments).wGetAdapter(EnvironmentEntityDescriptorEnum.Environments);
    }

    public void setEnvironments(Environments environments) {
        wSet(EnvironmentFeatureDescriptorEnum.environments, environments);
    }

    public Bindings getBindings() {
        return wGet(EnvironmentFeatureDescriptorEnum.bindings).wGetAdapter(EnvironmentEntityDescriptorEnum.Bindings);
    }

    public void setBindings(Bindings bindings) {
        wSet(EnvironmentFeatureDescriptorEnum.bindings, bindings);
    }
}
