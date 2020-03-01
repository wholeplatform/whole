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
import org.whole.lang.workflows.model.ForeachLoop;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.workflows.model.Label;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.model.Variable;
import org.whole.lang.workflows.model.FlowObject;

/**
 *  @generator Whole
 */
public class ForeachLoopImpl extends AbstractSimpleEntity implements ForeachLoop {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ForeachLoop> wGetEntityDescriptor() {
        return WorkflowsEntityDescriptorEnum.ForeachLoop;
    }

    public int wGetEntityOrd() {
        return WorkflowsEntityDescriptorEnum.ForeachLoop_ord;
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
    private Variable compositeVariable;

    public Variable getCompositeVariable() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.compositeVariable, compositeVariable);
    }

    public void setCompositeVariable(Variable compositeVariable) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.compositeVariable, this.compositeVariable, this.compositeVariable = compositeVariable);
    }
    private Variable elementVariable;

    public Variable getElementVariable() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.elementVariable, elementVariable);
    }

    public void setElementVariable(Variable elementVariable) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.elementVariable, this.elementVariable, this.elementVariable = elementVariable);
    }
    private Variable indexVariable;

    public Variable getIndexVariable() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.indexVariable, indexVariable);
    }

    public void setIndexVariable(Variable indexVariable) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.indexVariable, this.indexVariable, this.indexVariable = indexVariable);
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
            return getLabel().wGetAdaptee(false);
            case 1 :
            return getCompositeVariable().wGetAdaptee(false);
            case 2 :
            return getElementVariable().wGetAdaptee(false);
            case 3 :
            return getIndexVariable().wGetAdaptee(false);
            case 4 :
            return getFlowObject().wGetAdaptee(false);
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
            setCompositeVariable(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Variable));
            break;
            case 2 :
            setElementVariable(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Variable));
            break;
            case 3 :
            setIndexVariable(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Variable));
            break;
            case 4 :
            setFlowObject(value.wGetAdapter(WorkflowsEntityDescriptorEnum.FlowObject));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
