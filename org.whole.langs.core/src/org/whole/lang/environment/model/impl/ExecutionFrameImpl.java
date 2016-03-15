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

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.environment.model.ExecutionFrame;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.environment.model.Data;
import org.whole.lang.environment.reflect.EnvironmentFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.model.Value;

/**
 *  @generator Whole
 */
public class ExecutionFrameImpl extends AbstractSimpleEntity implements ExecutionFrame {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ExecutionFrame> wGetEntityDescriptor() {
        return EnvironmentEntityDescriptorEnum.ExecutionFrame;
    }

    public int wGetEntityOrd() {
        return EnvironmentEntityDescriptorEnum.ExecutionFrame_ord;
    }

    public void accept(IEnvironmentVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Data sourceFragment;

    public Data getSourceFragment() {
        return notifyRequested(EnvironmentFeatureDescriptorEnum.sourceFragment, sourceFragment);
    }

    public void setSourceFragment(Data sourceFragment) {
        notifyChanged(EnvironmentFeatureDescriptorEnum.sourceFragment, this.sourceFragment, this.sourceFragment = sourceFragment);
    }
    private Value sourceEntity;

    public Value getSourceEntity() {
        return notifyRequested(EnvironmentFeatureDescriptorEnum.sourceEntity, sourceEntity);
    }

    public void setSourceEntity(Value sourceEntity) {
        notifyChanged(EnvironmentFeatureDescriptorEnum.sourceEntity, this.sourceEntity, this.sourceEntity = sourceEntity);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getSourceFragment().wGetAdaptee(false);
            case 1 :
            return getSourceEntity().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setSourceFragment(value.wGetAdapter(EnvironmentEntityDescriptorEnum.Data));
            break;
            case 1 :
            setSourceEntity(value.wGetAdapter(EnvironmentEntityDescriptorEnum.Value));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
