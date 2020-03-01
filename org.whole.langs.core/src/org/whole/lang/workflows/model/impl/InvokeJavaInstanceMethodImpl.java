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
import org.whole.lang.workflows.model.InvokeJavaInstanceMethod;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.workflows.model.Label;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.model.Variable;
import org.whole.lang.workflows.model.Expression;
import org.whole.lang.workflows.model.Expressions;

/**
 *  @generator Whole
 */
public class InvokeJavaInstanceMethodImpl extends AbstractSimpleEntity implements InvokeJavaInstanceMethod {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<InvokeJavaInstanceMethod> wGetEntityDescriptor() {
        return WorkflowsEntityDescriptorEnum.InvokeJavaInstanceMethod;
    }

    public int wGetEntityOrd() {
        return WorkflowsEntityDescriptorEnum.InvokeJavaInstanceMethod_ord;
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
    private Variable result;

    public Variable getResult() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.result, result);
    }

    public void setResult(Variable result) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.result, this.result, this.result = result);
    }
    private Expression object;

    public Expression getObject() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.object, object);
    }

    public void setObject(Expression object) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.object, this.object, this.object = object);
    }
    private Expressions typeArguments;

    public Expressions getTypeArguments() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.typeArguments, typeArguments);
    }

    public void setTypeArguments(Expressions typeArguments) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.typeArguments, this.typeArguments, this.typeArguments = typeArguments);
    }
    private Expression className;

    public Expression getClassName() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.className, className);
    }

    public void setClassName(Expression className) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.className, this.className, this.className = className);
    }
    private Expression method;

    public Expression getMethod() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.method, method);
    }

    public void setMethod(Expression method) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.method, this.method, this.method = method);
    }
    private Expressions arguments;

    public Expressions getArguments() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.arguments, arguments);
    }

    public void setArguments(Expressions arguments) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.arguments, this.arguments, this.arguments = arguments);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabel().wGetAdaptee(false);
            case 1 :
            return getResult().wGetAdaptee(false);
            case 2 :
            return getObject().wGetAdaptee(false);
            case 3 :
            return getTypeArguments().wGetAdaptee(false);
            case 4 :
            return getClassName().wGetAdaptee(false);
            case 5 :
            return getMethod().wGetAdaptee(false);
            case 6 :
            return getArguments().wGetAdaptee(false);
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
            setResult(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Variable));
            break;
            case 2 :
            setObject(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
            break;
            case 3 :
            setTypeArguments(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Expressions));
            break;
            case 4 :
            setClassName(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
            break;
            case 5 :
            setMethod(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
            break;
            case 6 :
            setArguments(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Expressions));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 7;
    }
}
