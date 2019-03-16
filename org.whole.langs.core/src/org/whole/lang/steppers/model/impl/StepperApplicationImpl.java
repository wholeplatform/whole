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
import org.whole.lang.steppers.model.StepperApplication;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.steppers.reflect.SteppersEntityDescriptorEnum;
import org.whole.lang.steppers.visitors.ISteppersVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.steppers.model.CallFlow;
import org.whole.lang.steppers.reflect.SteppersFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.steppers.model.ArgumentFlow;

/**
 *  @generator Whole
 */
public class StepperApplicationImpl extends AbstractSimpleEntity implements StepperApplication {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<StepperApplication> wGetEntityDescriptor() {
        return SteppersEntityDescriptorEnum.StepperApplication;
    }

    public int wGetEntityOrd() {
        return SteppersEntityDescriptorEnum.StepperApplication_ord;
    }

    public void accept(ISteppersVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private CallFlow goals;

    public CallFlow getGoals() {
        return notifyRequested(SteppersFeatureDescriptorEnum.goals, goals);
    }

    public void setGoals(CallFlow goals) {
        notifyChanged(SteppersFeatureDescriptorEnum.goals, this.goals, this.goals = goals);
    }
    private ArgumentFlow results;

    public ArgumentFlow getResults() {
        return notifyRequested(SteppersFeatureDescriptorEnum.results, results);
    }

    public void setResults(ArgumentFlow results) {
        notifyChanged(SteppersFeatureDescriptorEnum.results, this.results, this.results = results);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getGoals().wGetAdaptee(false);
            case 1 :
            return getResults().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setGoals(value.wGetAdapter(SteppersEntityDescriptorEnum.CallFlow));
            break;
            case 1 :
            setResults(value.wGetAdapter(SteppersEntityDescriptorEnum.ArgumentFlow));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
