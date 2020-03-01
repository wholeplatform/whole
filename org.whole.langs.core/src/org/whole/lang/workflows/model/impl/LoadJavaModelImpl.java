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
import org.whole.lang.workflows.model.LoadJavaModel;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.workflows.model.Label;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.model.Variable;
import org.whole.lang.workflows.model.Expression;
import org.whole.lang.workflows.model.ClassProvider;

/**
 *  @generator Whole
 */
public class LoadJavaModelImpl extends AbstractSimpleEntity implements LoadJavaModel {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<LoadJavaModel> wGetEntityDescriptor() {
        return WorkflowsEntityDescriptorEnum.LoadJavaModel;
    }

    public int wGetEntityOrd() {
        return WorkflowsEntityDescriptorEnum.LoadJavaModel_ord;
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
    private Expression className;

    public Expression getClassName() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.className, className);
    }

    public void setClassName(Expression className) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.className, this.className, this.className = className);
    }
    private ClassProvider classProvider;

    public ClassProvider getClassProvider() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.classProvider, classProvider);
    }

    public void setClassProvider(ClassProvider classProvider) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.classProvider, this.classProvider, this.classProvider = classProvider);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabel().wGetAdaptee(false);
            case 1 :
            return getModel().wGetAdaptee(false);
            case 2 :
            return getClassName().wGetAdaptee(false);
            case 3 :
            return getClassProvider().wGetAdaptee(false);
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
            setClassName(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
            break;
            case 3 :
            setClassProvider(value.wGetAdapter(WorkflowsEntityDescriptorEnum.ClassProvider));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
