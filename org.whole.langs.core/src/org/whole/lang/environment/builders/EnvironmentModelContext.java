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
package org.whole.lang.environment.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.reflect.EnvironmentFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class EnvironmentModelContext extends EntityContext {

    public EnvironmentModelContext(IEntity root) {
        super(root);
    }

    public EnvironmentModelContext getEnvironments() {
        return (EnvironmentModelContext) wGet(EnvironmentFeatureDescriptorEnum.environments);
    }

    public void setEnvironments(EnvironmentModelContext environments) {
        wSet(EnvironmentFeatureDescriptorEnum.environments, environments);
    }

    public EnvironmentModelContext getBindings() {
        return (EnvironmentModelContext) wGet(EnvironmentFeatureDescriptorEnum.bindings);
    }

    public void setBindings(EnvironmentModelContext bindings) {
        wSet(EnvironmentFeatureDescriptorEnum.bindings, bindings);
    }

    public EnvironmentModelContext getBehavior() {
        return (EnvironmentModelContext) wGet(EnvironmentFeatureDescriptorEnum.behavior);
    }

    public void setBehavior(EnvironmentModelContext behavior) {
        wSet(EnvironmentFeatureDescriptorEnum.behavior, behavior);
    }

    public EnvironmentModelContext getResult() {
        return (EnvironmentModelContext) wGet(EnvironmentFeatureDescriptorEnum.result);
    }

    public void setResult(EnvironmentModelContext result) {
        wSet(EnvironmentFeatureDescriptorEnum.result, result);
    }

    public EnvironmentModelContext getFocusJob() {
        return (EnvironmentModelContext) wGet(EnvironmentFeatureDescriptorEnum.focusJob);
    }

    public void setFocusJob(EnvironmentModelContext focusJob) {
        wSet(EnvironmentFeatureDescriptorEnum.focusJob, focusJob);
    }

    public EnvironmentModelContext getJobs() {
        return (EnvironmentModelContext) wGet(EnvironmentFeatureDescriptorEnum.jobs);
    }

    public void setJobs(EnvironmentModelContext jobs) {
        wSet(EnvironmentFeatureDescriptorEnum.jobs, jobs);
    }

    public EnvironmentModelContext getFocusFrame() {
        return (EnvironmentModelContext) wGet(EnvironmentFeatureDescriptorEnum.focusFrame);
    }

    public void setFocusFrame(EnvironmentModelContext focusFrame) {
        wSet(EnvironmentFeatureDescriptorEnum.focusFrame, focusFrame);
    }

    public EnvironmentModelContext getExecutionStack() {
        return (EnvironmentModelContext) wGet(EnvironmentFeatureDescriptorEnum.executionStack);
    }

    public void setExecutionStack(EnvironmentModelContext executionStack) {
        wSet(EnvironmentFeatureDescriptorEnum.executionStack, executionStack);
    }

    public EnvironmentModelContext getSourceFragment() {
        return (EnvironmentModelContext) wGet(EnvironmentFeatureDescriptorEnum.sourceFragment);
    }

    public void setSourceFragment(EnvironmentModelContext sourceFragment) {
        wSet(EnvironmentFeatureDescriptorEnum.sourceFragment, sourceFragment);
    }

    public EnvironmentModelContext getSourceEntity() {
        return (EnvironmentModelContext) wGet(EnvironmentFeatureDescriptorEnum.sourceEntity);
    }

    public void setSourceEntity(EnvironmentModelContext sourceEntity) {
        wSet(EnvironmentFeatureDescriptorEnum.sourceEntity, sourceEntity);
    }

    public EnvironmentModelContext getEnvironmentManager() {
        return (EnvironmentModelContext) wGet(EnvironmentFeatureDescriptorEnum.environmentManager);
    }

    public void setEnvironmentManager(EnvironmentModelContext environmentManager) {
        wSet(EnvironmentFeatureDescriptorEnum.environmentManager, environmentManager);
    }

    public EnvironmentModelContext getName() {
        return (EnvironmentModelContext) wGet(EnvironmentFeatureDescriptorEnum.name);
    }

    public void setName(EnvironmentModelContext name) {
        wSet(EnvironmentFeatureDescriptorEnum.name, name);
    }

    public EnvironmentModelContext getFilter() {
        return (EnvironmentModelContext) wGet(EnvironmentFeatureDescriptorEnum.filter);
    }

    public void setFilter(EnvironmentModelContext filter) {
        wSet(EnvironmentFeatureDescriptorEnum.filter, filter);
    }

    public EnvironmentModelContext getBindingManager() {
        return (EnvironmentModelContext) wGet(EnvironmentFeatureDescriptorEnum.bindingManager);
    }

    public void setBindingManager(EnvironmentModelContext bindingManager) {
        wSet(EnvironmentFeatureDescriptorEnum.bindingManager, bindingManager);
    }

    public EnvironmentModelContext getValue() {
        return (EnvironmentModelContext) wGet(EnvironmentFeatureDescriptorEnum.value);
    }

    public void setValue(EnvironmentModelContext value) {
        wSet(EnvironmentFeatureDescriptorEnum.value, value);
    }

    public EnvironmentModelContext getScope() {
        return (EnvironmentModelContext) wGet(EnvironmentFeatureDescriptorEnum.scope);
    }

    public void setScope(EnvironmentModelContext scope) {
        wSet(EnvironmentFeatureDescriptorEnum.scope, scope);
    }
}
