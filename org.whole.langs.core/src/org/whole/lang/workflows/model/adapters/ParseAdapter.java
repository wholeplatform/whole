package org.whole.lang.workflows.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.workflows.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ParseAdapter extends AbstractEntityAdapter implements Parse {
	private static final long serialVersionUID = 1;

	public ParseAdapter(IEntity implementor) {
		super(implementor);
	}

	public ParseAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Parse> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.Parse;
	}

	public Label getLabel() {
		return wGet(WorkflowsFeatureDescriptorEnum.label).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Label);
	}

	public void setLabel(Label label) {
		wSet(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public Variable getModel() {
		return wGet(WorkflowsFeatureDescriptorEnum.model).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Variable);
	}

	public void setModel(Variable model) {
		wSet(WorkflowsFeatureDescriptorEnum.model, model);
	}

	public Expression getText() {
		return wGet(WorkflowsFeatureDescriptorEnum.text).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Expression);
	}

	public void setText(Expression text) {
		wSet(WorkflowsFeatureDescriptorEnum.text, text);
	}

	public Expression getGrammar() {
		return wGet(WorkflowsFeatureDescriptorEnum.grammar).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Expression);
	}

	public void setGrammar(Expression grammar) {
		wSet(WorkflowsFeatureDescriptorEnum.grammar, grammar);
	}

	public Expression getNt() {
		return wGet(WorkflowsFeatureDescriptorEnum.nt).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Expression);
	}

	public void setNt(Expression nt) {
		wSet(WorkflowsFeatureDescriptorEnum.nt, nt);
	}
}
