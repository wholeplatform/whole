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
public class InvokeJavaInstanceMethodAdapter extends AbstractEntityAdapter implements InvokeJavaInstanceMethod {
    private static final long serialVersionUID = 1;

    public InvokeJavaInstanceMethodAdapter(IEntity implementor) {
        super(implementor);
    }

    public InvokeJavaInstanceMethodAdapter() {
    }

    public void accept(IWorkflowsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<InvokeJavaInstanceMethod> wGetEntityDescriptor() {
        return WorkflowsEntityDescriptorEnum.InvokeJavaInstanceMethod;
    }

    public Label getLabel() {
        return wGet(WorkflowsFeatureDescriptorEnum.label).wGetAdapter(WorkflowsEntityDescriptorEnum.Label);
    }

    public void setLabel(Label label) {
        wSet(WorkflowsFeatureDescriptorEnum.label, label);
    }

    public Variable getResult() {
        return wGet(WorkflowsFeatureDescriptorEnum.result).wGetAdapter(WorkflowsEntityDescriptorEnum.Variable);
    }

    public void setResult(Variable result) {
        wSet(WorkflowsFeatureDescriptorEnum.result, result);
    }

    public Expression getObject() {
        return wGet(WorkflowsFeatureDescriptorEnum.object).wGetAdapter(WorkflowsEntityDescriptorEnum.Expression);
    }

    public void setObject(Expression object) {
        wSet(WorkflowsFeatureDescriptorEnum.object, object);
    }

    public Expressions getTypeArguments() {
        return wGet(WorkflowsFeatureDescriptorEnum.typeArguments).wGetAdapter(WorkflowsEntityDescriptorEnum.Expressions);
    }

    public void setTypeArguments(Expressions typeArguments) {
        wSet(WorkflowsFeatureDescriptorEnum.typeArguments, typeArguments);
    }

    public Expression getClassName() {
        return wGet(WorkflowsFeatureDescriptorEnum.className).wGetAdapter(WorkflowsEntityDescriptorEnum.Expression);
    }

    public void setClassName(Expression className) {
        wSet(WorkflowsFeatureDescriptorEnum.className, className);
    }

    public Expression getMethod() {
        return wGet(WorkflowsFeatureDescriptorEnum.method).wGetAdapter(WorkflowsEntityDescriptorEnum.Expression);
    }

    public void setMethod(Expression method) {
        wSet(WorkflowsFeatureDescriptorEnum.method, method);
    }

    public Expressions getArguments() {
        return wGet(WorkflowsFeatureDescriptorEnum.arguments).wGetAdapter(WorkflowsEntityDescriptorEnum.Expressions);
    }

    public void setArguments(Expressions arguments) {
        wSet(WorkflowsFeatureDescriptorEnum.arguments, arguments);
    }
}
