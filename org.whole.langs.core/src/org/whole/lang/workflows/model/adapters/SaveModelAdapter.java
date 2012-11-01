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
public class SaveModelAdapter extends AbstractEntityAdapter implements
		SaveModel {
	private static final long serialVersionUID = 1;

	public SaveModelAdapter(IEntity implementor) {
		super(implementor);
	}

	public SaveModelAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SaveModel> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.SaveModel;
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

	public Expression getPersistence() {
		return wGet(WorkflowsFeatureDescriptorEnum.persistence).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Expression);
	}

	public void setPersistence(Expression persistence) {
		wSet(WorkflowsFeatureDescriptorEnum.persistence, persistence);
	}

	public ResourceKind getResourceKind() {
		return wGet(WorkflowsFeatureDescriptorEnum.resourceKind).wGetAdapter(
				WorkflowsEntityDescriptorEnum.ResourceKind);
	}

	public void setResourceKind(ResourceKind resourceKind) {
		wSet(WorkflowsFeatureDescriptorEnum.resourceKind, resourceKind);
	}

	public Expression getResource() {
		return wGet(WorkflowsFeatureDescriptorEnum.resource).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Expression);
	}

	public void setResource(Expression resource) {
		wSet(WorkflowsFeatureDescriptorEnum.resource, resource);
	}

	public Assignments getBindings() {
		return wGet(WorkflowsFeatureDescriptorEnum.bindings).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Assignments);
	}

	public void setBindings(Assignments bindings) {
		wSet(WorkflowsFeatureDescriptorEnum.bindings, bindings);
	}
}
