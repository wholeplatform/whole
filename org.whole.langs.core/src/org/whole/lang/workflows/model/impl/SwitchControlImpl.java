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
import org.whole.lang.workflows.model.SwitchControl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.workflows.model.Label;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.model.SwitchType;
import org.whole.lang.workflows.model.ConditionalCases;
import org.whole.lang.workflows.model.DefaultCase;

/**
 *  @generator Whole
 */
public class SwitchControlImpl extends AbstractSimpleEntity implements SwitchControl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<SwitchControl> wGetEntityDescriptor() {
        return WorkflowsEntityDescriptorEnum.SwitchControl;
    }

    public int wGetEntityOrd() {
        return WorkflowsEntityDescriptorEnum.SwitchControl_ord;
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
    private SwitchType switchType;

    public SwitchType getSwitchType() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.switchType, switchType);
    }

    public void setSwitchType(SwitchType switchType) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.switchType, this.switchType, this.switchType = switchType);
    }
    private ConditionalCases conditionalCases;

    public ConditionalCases getConditionalCases() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.conditionalCases, conditionalCases);
    }

    public void setConditionalCases(ConditionalCases conditionalCases) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.conditionalCases, this.conditionalCases, this.conditionalCases = conditionalCases);
    }
    private DefaultCase defaultCase;

    public DefaultCase getDefaultCase() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.defaultCase, defaultCase);
    }

    public void setDefaultCase(DefaultCase defaultCase) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.defaultCase, this.defaultCase, this.defaultCase = defaultCase);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabel().wGetAdaptee(false);
            case 1 :
            return getSwitchType().wGetAdaptee(false);
            case 2 :
            return getConditionalCases().wGetAdaptee(false);
            case 3 :
            return getDefaultCase().wGetAdaptee(false);
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
            setSwitchType(value.wGetAdapter(WorkflowsEntityDescriptorEnum.SwitchType));
            break;
            case 2 :
            setConditionalCases(value.wGetAdapter(WorkflowsEntityDescriptorEnum.ConditionalCases));
            break;
            case 3 :
            setDefaultCase(value.wGetAdapter(WorkflowsEntityDescriptorEnum.DefaultCase));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
