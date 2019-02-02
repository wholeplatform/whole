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
import org.whole.lang.environment.model.DebugViewModel;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.environment.model.Index;
import org.whole.lang.environment.reflect.EnvironmentFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.model.Jobs;

/**
 *  @generator Whole
 */
public class DebugViewModelImpl extends AbstractSimpleEntity implements DebugViewModel {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<DebugViewModel> wGetEntityDescriptor() {
        return EnvironmentEntityDescriptorEnum.DebugViewModel;
    }

    public int wGetEntityOrd() {
        return EnvironmentEntityDescriptorEnum.DebugViewModel_ord;
    }

    public void accept(IEnvironmentVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Index focusJob;

    public Index getFocusJob() {
        return notifyRequested(EnvironmentFeatureDescriptorEnum.focusJob, focusJob);
    }

    public void setFocusJob(Index focusJob) {
        notifyChanged(EnvironmentFeatureDescriptorEnum.focusJob, this.focusJob, this.focusJob = focusJob);
    }
    private Jobs jobs;

    public Jobs getJobs() {
        return notifyRequested(EnvironmentFeatureDescriptorEnum.jobs, jobs);
    }

    public void setJobs(Jobs jobs) {
        notifyChanged(EnvironmentFeatureDescriptorEnum.jobs, this.jobs, this.jobs = jobs);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getFocusJob().wGetAdaptee(false);
            case 1 :
            return getJobs().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setFocusJob(value.wGetAdapter(EnvironmentEntityDescriptorEnum.Index));
            break;
            case 1 :
            setJobs(value.wGetAdapter(EnvironmentEntityDescriptorEnum.Jobs));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
