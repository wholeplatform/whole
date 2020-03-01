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
import org.whole.lang.workflows.model.LoadModel;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.workflows.model.Label;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.model.Variable;
import org.whole.lang.workflows.model.Expression;
import org.whole.lang.workflows.model.ResourceKind;
import org.whole.lang.workflows.model.Assignments;

/**
 *  @generator Whole
 */
public class LoadModelImpl extends AbstractSimpleEntity implements LoadModel {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<LoadModel> wGetEntityDescriptor() {
        return WorkflowsEntityDescriptorEnum.LoadModel;
    }

    public int wGetEntityOrd() {
        return WorkflowsEntityDescriptorEnum.LoadModel_ord;
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
    private Variable model;

    public Variable getModel() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.model, model);
    }

    public void setModel(Variable model) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.model, this.model, this.model = model);
    }
    private Expression persistence;

    public Expression getPersistence() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.persistence, persistence);
    }

    public void setPersistence(Expression persistence) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.persistence, this.persistence, this.persistence = persistence);
    }
    private ResourceKind resourceKind;

    public ResourceKind getResourceKind() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.resourceKind, resourceKind);
    }

    public void setResourceKind(ResourceKind resourceKind) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.resourceKind, this.resourceKind, this.resourceKind = resourceKind);
    }
    private Expression resource;

    public Expression getResource() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.resource, resource);
    }

    public void setResource(Expression resource) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.resource, this.resource, this.resource = resource);
    }
    private Assignments bindings;

    public Assignments getBindings() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.bindings, bindings);
    }

    public void setBindings(Assignments bindings) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.bindings, this.bindings, this.bindings = bindings);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabel().wGetAdaptee(false);
            case 1 :
            return getModel().wGetAdaptee(false);
            case 2 :
            return getPersistence().wGetAdaptee(false);
            case 3 :
            return getResourceKind().wGetAdaptee(false);
            case 4 :
            return getResource().wGetAdaptee(false);
            case 5 :
            return getBindings().wGetAdaptee(false);
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
            setModel(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Variable));
            break;
            case 2 :
            setPersistence(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
            break;
            case 3 :
            setResourceKind(value.wGetAdapter(WorkflowsEntityDescriptorEnum.ResourceKind));
            break;
            case 4 :
            setResource(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
            break;
            case 5 :
            setBindings(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Assignments));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 6;
    }
}
