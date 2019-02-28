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
package org.whole.lang.steppers.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.steppers.model.ArgumentBranch;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.steppers.reflect.SteppersEntityDescriptorEnum;
import org.whole.lang.steppers.visitors.ISteppersVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.steppers.model.ArgumentFlow;
import org.whole.lang.steppers.reflect.SteppersFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class ArgumentBranchImpl extends AbstractSimpleEntity implements ArgumentBranch {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ArgumentBranch> wGetEntityDescriptor() {
        return SteppersEntityDescriptorEnum.ArgumentBranch;
    }

    public int wGetEntityOrd() {
        return SteppersEntityDescriptorEnum.ArgumentBranch_ord;
    }

    public void accept(ISteppersVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private ArgumentFlow calls;

    public ArgumentFlow getCalls() {
        return notifyRequested(SteppersFeatureDescriptorEnum.calls, calls);
    }

    public void setCalls(ArgumentFlow calls) {
        notifyChanged(SteppersFeatureDescriptorEnum.calls, this.calls, this.calls = calls);
    }
    private ArgumentFlow actions;

    public ArgumentFlow getActions() {
        return notifyRequested(SteppersFeatureDescriptorEnum.actions, actions);
    }

    public void setActions(ArgumentFlow actions) {
        notifyChanged(SteppersFeatureDescriptorEnum.actions, this.actions, this.actions = actions);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getCalls().wGetAdaptee(false);
            case 1 :
            return getActions().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setCalls(value.wGetAdapter(SteppersEntityDescriptorEnum.ArgumentFlow));
            break;
            case 1 :
            setActions(value.wGetAdapter(SteppersEntityDescriptorEnum.ArgumentFlow));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
