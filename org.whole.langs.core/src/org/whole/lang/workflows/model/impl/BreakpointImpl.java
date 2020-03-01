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
import org.whole.lang.workflows.model.Breakpoint;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.workflows.model.Label;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.model.BooleanLiteral;
import org.whole.lang.workflows.model.IntLiteral;
import org.whole.lang.workflows.model.Condition;
import org.whole.lang.workflows.model.ConditionTest;
import org.whole.lang.workflows.model.Variables;

/**
 *  @generator Whole
 */
public class BreakpointImpl extends AbstractSimpleEntity implements Breakpoint {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Breakpoint> wGetEntityDescriptor() {
        return WorkflowsEntityDescriptorEnum.Breakpoint;
    }

    public int wGetEntityOrd() {
        return WorkflowsEntityDescriptorEnum.Breakpoint_ord;
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
    private BooleanLiteral disabled;

    public BooleanLiteral getDisabled() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.disabled, disabled);
    }

    public void setDisabled(BooleanLiteral disabled) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.disabled, this.disabled, this.disabled = disabled);
    }
    private IntLiteral hitCount;

    public IntLiteral getHitCount() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.hitCount, hitCount);
    }

    public void setHitCount(IntLiteral hitCount) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.hitCount, this.hitCount, this.hitCount = hitCount);
    }
    private Condition condition;

    public Condition getCondition() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.condition, condition);
    }

    public void setCondition(Condition condition) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.condition, this.condition, this.condition = condition);
    }
    private ConditionTest conditionTest;

    public ConditionTest getConditionTest() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.conditionTest, conditionTest);
    }

    public void setConditionTest(ConditionTest conditionTest) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.conditionTest, this.conditionTest, this.conditionTest = conditionTest);
    }
    private Variables showVariables;

    public Variables getShowVariables() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.showVariables, showVariables);
    }

    public void setShowVariables(Variables showVariables) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.showVariables, this.showVariables, this.showVariables = showVariables);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabel().wGetAdaptee(false);
            case 1 :
            return getDisabled().wGetAdaptee(false);
            case 2 :
            return getHitCount().wGetAdaptee(false);
            case 3 :
            return getCondition().wGetAdaptee(false);
            case 4 :
            return getConditionTest().wGetAdaptee(false);
            case 5 :
            return getShowVariables().wGetAdaptee(false);
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
            setDisabled(value.wGetAdapter(WorkflowsEntityDescriptorEnum.BooleanLiteral));
            break;
            case 2 :
            setHitCount(value.wGetAdapter(WorkflowsEntityDescriptorEnum.IntLiteral));
            break;
            case 3 :
            setCondition(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Condition));
            break;
            case 4 :
            setConditionTest(value.wGetAdapter(WorkflowsEntityDescriptorEnum.ConditionTest));
            break;
            case 5 :
            setShowVariables(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Variables));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 6;
    }
}
