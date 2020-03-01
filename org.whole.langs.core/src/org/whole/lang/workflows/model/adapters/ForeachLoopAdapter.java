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
public class ForeachLoopAdapter extends AbstractEntityAdapter implements ForeachLoop {
    private static final long serialVersionUID = 1;

    public ForeachLoopAdapter(IEntity implementor) {
        super(implementor);
    }

    public ForeachLoopAdapter() {
    }

    public void accept(IWorkflowsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ForeachLoop> wGetEntityDescriptor() {
        return WorkflowsEntityDescriptorEnum.ForeachLoop;
    }

    public Label getLabel() {
        return wGet(WorkflowsFeatureDescriptorEnum.label).wGetAdapter(WorkflowsEntityDescriptorEnum.Label);
    }

    public void setLabel(Label label) {
        wSet(WorkflowsFeatureDescriptorEnum.label, label);
    }

    public Variable getCompositeVariable() {
        return wGet(WorkflowsFeatureDescriptorEnum.compositeVariable).wGetAdapter(WorkflowsEntityDescriptorEnum.Variable);
    }

    public void setCompositeVariable(Variable compositeVariable) {
        wSet(WorkflowsFeatureDescriptorEnum.compositeVariable, compositeVariable);
    }

    public Variable getElementVariable() {
        return wGet(WorkflowsFeatureDescriptorEnum.elementVariable).wGetAdapter(WorkflowsEntityDescriptorEnum.Variable);
    }

    public void setElementVariable(Variable elementVariable) {
        wSet(WorkflowsFeatureDescriptorEnum.elementVariable, elementVariable);
    }

    public Variable getIndexVariable() {
        return wGet(WorkflowsFeatureDescriptorEnum.indexVariable).wGetAdapter(WorkflowsEntityDescriptorEnum.Variable);
    }

    public void setIndexVariable(Variable indexVariable) {
        wSet(WorkflowsFeatureDescriptorEnum.indexVariable, indexVariable);
    }

    public FlowObject getFlowObject() {
        return wGet(WorkflowsFeatureDescriptorEnum.flowObject).wGetAdapter(WorkflowsEntityDescriptorEnum.FlowObject);
    }

    public void setFlowObject(FlowObject flowObject) {
        wSet(WorkflowsFeatureDescriptorEnum.flowObject, flowObject);
    }
}
