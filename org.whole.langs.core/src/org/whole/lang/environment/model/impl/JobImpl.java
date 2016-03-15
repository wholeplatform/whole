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
import org.whole.lang.environment.model.Job;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.environment.model.Index;
import org.whole.lang.environment.reflect.EnvironmentFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.model.ExecutionStack;

/**
 *  @generator Whole
 */
public class JobImpl extends AbstractSimpleEntity implements Job {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Job> wGetEntityDescriptor() {
        return EnvironmentEntityDescriptorEnum.Job;
    }

    public int wGetEntityOrd() {
        return EnvironmentEntityDescriptorEnum.Job_ord;
    }

    public void accept(IEnvironmentVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Index focusFrame;

    public Index getFocusFrame() {
        return notifyRequested(EnvironmentFeatureDescriptorEnum.focusFrame, focusFrame);
    }

    public void setFocusFrame(Index focusFrame) {
        notifyChanged(EnvironmentFeatureDescriptorEnum.focusFrame, this.focusFrame, this.focusFrame = focusFrame);
    }
    private ExecutionStack executionStack;

    public ExecutionStack getExecutionStack() {
        return notifyRequested(EnvironmentFeatureDescriptorEnum.executionStack, executionStack);
    }

    public void setExecutionStack(ExecutionStack executionStack) {
        notifyChanged(EnvironmentFeatureDescriptorEnum.executionStack, this.executionStack, this.executionStack = executionStack);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getFocusFrame().wGetAdaptee(false);
            case 1 :
            return getExecutionStack().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setFocusFrame(value.wGetAdapter(EnvironmentEntityDescriptorEnum.Index));
            break;
            case 1 :
            setExecutionStack(value.wGetAdapter(EnvironmentEntityDescriptorEnum.ExecutionStack));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
