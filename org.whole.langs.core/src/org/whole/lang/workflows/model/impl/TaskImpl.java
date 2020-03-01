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
import org.whole.lang.workflows.model.Task;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.workflows.model.Label;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.model.Description;
import org.whole.lang.workflows.model.Assignments;
import org.whole.lang.workflows.model.Variable;

/**
 *  @generator Whole
 */
public class TaskImpl extends AbstractSimpleEntity implements Task {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Task> wGetEntityDescriptor() {
        return WorkflowsEntityDescriptorEnum.Task;
    }

    public int wGetEntityOrd() {
        return WorkflowsEntityDescriptorEnum.Task_ord;
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
    private Description description;

    public Description getDescription() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.description, description);
    }

    public void setDescription(Description description) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.description, this.description, this.description = description);
    }
    private Assignments assignments;

    public Assignments getAssignments() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.assignments, assignments);
    }

    public void setAssignments(Assignments assignments) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.assignments, this.assignments, this.assignments = assignments);
    }
    private Variable factory;

    public Variable getFactory() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.factory, factory);
    }

    public void setFactory(Variable factory) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.factory, this.factory, this.factory = factory);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabel().wGetAdaptee(false);
            case 1 :
            return getDescription().wGetAdaptee(false);
            case 2 :
            return getAssignments().wGetAdaptee(false);
            case 3 :
            return getFactory().wGetAdaptee(false);
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
            setDescription(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Description));
            break;
            case 2 :
            setAssignments(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Assignments));
            break;
            case 3 :
            setFactory(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Variable));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
