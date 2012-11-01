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
public class CreateModelAdapter extends AbstractEntityAdapter implements
		CreateModel {
	private static final long serialVersionUID = 1;

	public CreateModelAdapter(IEntity implementor) {
		super(implementor);
	}

	public CreateModelAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CreateModel> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.CreateModel;
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

	public Variable getTemplate() {
		return wGet(WorkflowsFeatureDescriptorEnum.template).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Variable);
	}

	public void setTemplate(Variable template) {
		wSet(WorkflowsFeatureDescriptorEnum.template, template);
	}

	public Assignments getBindings() {
		return wGet(WorkflowsFeatureDescriptorEnum.bindings).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Assignments);
	}

	public void setBindings(Assignments bindings) {
		wSet(WorkflowsFeatureDescriptorEnum.bindings, bindings);
	}
}
