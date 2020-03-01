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
package org.whole.lang.workflows.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.workflows.model.EventHandler;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.workflows.model.Name;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.model.Label;
import org.whole.lang.workflows.model.StartEvent;
import org.whole.lang.workflows.model.FlowObject;

/**
 *  @generator Whole
 */
public class EventHandlerImpl extends AbstractSimpleEntity implements EventHandler {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<EventHandler> wGetEntityDescriptor() {
        return WorkflowsEntityDescriptorEnum.EventHandler;
    }

    public int wGetEntityOrd() {
        return WorkflowsEntityDescriptorEnum.EventHandler_ord;
    }

    public void accept(IWorkflowsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }

    public int wHashCode() {
        return getName().wHashCode();
    }

    public boolean wEquals(IEntity entity) {
        if (this == entity)
            return true;
        if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
            return false;
        try {
            return getName().wEquals(entity.wGet(WorkflowsFeatureDescriptorEnum.name));
        } catch (Exception e) {
            return false;
        }
    }

    protected void toString(StringBuffer buffer) {
        buffer.append("name=");
        buffer.append(name);
    }
    private Name name;

    public Name getName() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Label label;

    public Label getLabel() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.label, label);
    }

    public void setLabel(Label label) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.label, this.label, this.label = label);
    }
    private StartEvent triggerEvent;

    public StartEvent getTriggerEvent() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.triggerEvent, triggerEvent);
    }

    public void setTriggerEvent(StartEvent triggerEvent) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.triggerEvent, this.triggerEvent, this.triggerEvent = triggerEvent);
    }
    private FlowObject flowObject;

    public FlowObject getFlowObject() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.flowObject, flowObject);
    }

    public void setFlowObject(FlowObject flowObject) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.flowObject, this.flowObject, this.flowObject = flowObject);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getLabel().wGetAdaptee(false);
            case 2 :
            return getTriggerEvent().wGetAdaptee(false);
            case 3 :
            return getFlowObject().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Name));
            break;
            case 1 :
            setLabel(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Label));
            break;
            case 2 :
            setTriggerEvent(value.wGetAdapter(WorkflowsEntityDescriptorEnum.StartEvent));
            break;
            case 3 :
            setFlowObject(value.wGetAdapter(WorkflowsEntityDescriptorEnum.FlowObject));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
