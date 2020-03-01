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
package org.whole.lang.workflows.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.workflows.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class WorkflowAdapter extends AbstractEntityAdapter implements Workflow {
    private static final long serialVersionUID = 1;

    public WorkflowAdapter(IEntity implementor) {
        super(implementor);
    }

    public WorkflowAdapter() {
    }

    public void accept(IWorkflowsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Workflow> wGetEntityDescriptor() {
        return WorkflowsEntityDescriptorEnum.Workflow;
    }

    public Name getName() {
        return wGet(WorkflowsFeatureDescriptorEnum.name).wGetAdapter(WorkflowsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(WorkflowsFeatureDescriptorEnum.name, name);
    }

    public Description getDescription() {
        return wGet(WorkflowsFeatureDescriptorEnum.description).wGetAdapter(WorkflowsEntityDescriptorEnum.Description);
    }

    public void setDescription(Description description) {
        wSet(WorkflowsFeatureDescriptorEnum.description, description);
    }

    public Declarations getDeclarations() {
        return wGet(WorkflowsFeatureDescriptorEnum.declarations).wGetAdapter(WorkflowsEntityDescriptorEnum.Declarations);
    }

    public void setDeclarations(Declarations declarations) {
        wSet(WorkflowsFeatureDescriptorEnum.declarations, declarations);
    }

    public StartEvent getStartEvent() {
        return wGet(WorkflowsFeatureDescriptorEnum.startEvent).wGetAdapter(WorkflowsEntityDescriptorEnum.StartEvent);
    }

    public void setStartEvent(StartEvent startEvent) {
        wSet(WorkflowsFeatureDescriptorEnum.startEvent, startEvent);
    }

    public FlowObject getFlowObject() {
        return wGet(WorkflowsFeatureDescriptorEnum.flowObject).wGetAdapter(WorkflowsEntityDescriptorEnum.FlowObject);
    }

    public void setFlowObject(FlowObject flowObject) {
        wSet(WorkflowsFeatureDescriptorEnum.flowObject, flowObject);
    }

    public FlowEvent getEndEvent() {
        return wGet(WorkflowsFeatureDescriptorEnum.endEvent).wGetAdapter(WorkflowsEntityDescriptorEnum.FlowEvent);
    }

    public void setEndEvent(FlowEvent endEvent) {
        wSet(WorkflowsFeatureDescriptorEnum.endEvent, endEvent);
    }
}
