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
import org.whole.lang.workflows.model.Unparse;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.workflows.model.Label;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.model.Variable;
import org.whole.lang.workflows.model.Expression;

/**
 *  @generator Whole
 */
public class UnparseImpl extends AbstractSimpleEntity implements Unparse {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Unparse> wGetEntityDescriptor() {
        return WorkflowsEntityDescriptorEnum.Unparse;
    }

    public int wGetEntityOrd() {
        return WorkflowsEntityDescriptorEnum.Unparse_ord;
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
    private Expression text;

    public Expression getText() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.text, text);
    }

    public void setText(Expression text) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.text, this.text, this.text = text);
    }
    private Expression grammar;

    public Expression getGrammar() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.grammar, grammar);
    }

    public void setGrammar(Expression grammar) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.grammar, this.grammar, this.grammar = grammar);
    }
    private Expression nt;

    public Expression getNt() {
        return notifyRequested(WorkflowsFeatureDescriptorEnum.nt, nt);
    }

    public void setNt(Expression nt) {
        notifyChanged(WorkflowsFeatureDescriptorEnum.nt, this.nt, this.nt = nt);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabel().wGetAdaptee(false);
            case 1 :
            return getModel().wGetAdaptee(false);
            case 2 :
            return getText().wGetAdaptee(false);
            case 3 :
            return getGrammar().wGetAdaptee(false);
            case 4 :
            return getNt().wGetAdaptee(false);
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
            setText(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
            break;
            case 3 :
            setGrammar(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
            break;
            case 4 :
            setNt(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
