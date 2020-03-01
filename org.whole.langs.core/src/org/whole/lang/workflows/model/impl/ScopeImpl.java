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
import org.whole.lang.workflows.model.Scope;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.workflows.model.Label;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.model.Declarations;
import org.whole.lang.workflows.model.FlowObject;
import org.whole.lang.workflows.model.EventHandlers;
import org.whole.lang.workflows.model.FaultHandlers;

/**
 *  @generator Whole
 */
public class ScopeImpl extends AbstractSimpleEntity implements Scope {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Scope> wGetEntityDescriptor() {
        return WorkflowsEntityDescriptorEnum.Scope;
    }

    public int wGetEntityOrd() {
        return WorkflowsEntityDescriptorEnum.Scope_ord;
    }

    public void accept(IWorkflowsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Label label;

    public Label getLabel() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.label, label);
    }

    public void setLabel(Label label) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.label, this.label, this.label = label);
    }
    private Declarations declarations;

    public Declarations getDeclarations() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.declarations, declarations);
    }

    public void setDeclarations(Declarations declarations) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.declarations, this.declarations, this.declarations = declarations);
    }
    private FlowObject flowObject;

    public FlowObject getFlowObject() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.flowObject, flowObject);
    }

    public void setFlowObject(FlowObject flowObject) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.flowObject, this.flowObject, this.flowObject = flowObject);
    }
    private FlowObject compensationHandler;

    public FlowObject getCompensationHandler() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.compensationHandler, compensationHandler);
    }

    public void setCompensationHandler(FlowObject compensationHandler) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.compensationHandler, this.compensationHandler, this.compensationHandler = compensationHandler);
    }
    private EventHandlers eventHandlers;

    public EventHandlers getEventHandlers() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.eventHandlers, eventHandlers);
    }

    public void setEventHandlers(EventHandlers eventHandlers) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.eventHandlers, this.eventHandlers, this.eventHandlers = eventHandlers);
    }
    private FaultHandlers faultHandlers;

    public FaultHandlers getFaultHandlers() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.faultHandlers, faultHandlers);
    }

    public void setFaultHandlers(FaultHandlers faultHandlers) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.faultHandlers, this.faultHandlers, this.faultHandlers = faultHandlers);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabel().wGetAdaptee(false);
            case 1 :
            return getDeclarations().wGetAdaptee(false);
            case 2 :
            return getFlowObject().wGetAdaptee(false);
            case 3 :
            return getCompensationHandler().wGetAdaptee(false);
            case 4 :
            return getEventHandlers().wGetAdaptee(false);
            case 5 :
            return getFaultHandlers().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLabel(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Label));
            break;
            case 1 :
            setDeclarations(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Declarations));
            break;
            case 2 :
            setFlowObject(value.wGetAdapter(WorkflowsEntityDescriptorEnum.FlowObject));
            break;
            case 3 :
            setCompensationHandler(value.wGetAdapter(WorkflowsEntityDescriptorEnum.FlowObject));
            break;
            case 4 :
            setEventHandlers(value.wGetAdapter(WorkflowsEntityDescriptorEnum.EventHandlers));
            break;
            case 5 :
            setFaultHandlers(value.wGetAdapter(WorkflowsEntityDescriptorEnum.FaultHandlers));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 6;
    }
}
