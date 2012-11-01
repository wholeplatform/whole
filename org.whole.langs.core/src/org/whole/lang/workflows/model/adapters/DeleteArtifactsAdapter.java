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
public class DeleteArtifactsAdapter extends AbstractEntityAdapter implements
		DeleteArtifacts {
	private static final long serialVersionUID = 1;

	public DeleteArtifactsAdapter(IEntity implementor) {
		super(implementor);
	}

	public DeleteArtifactsAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DeleteArtifacts> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.DeleteArtifacts;
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

	public ResourceKind getRootResourceKind() {
		return wGet(WorkflowsFeatureDescriptorEnum.rootResourceKind)
				.wGetAdapter(WorkflowsEntityDescriptorEnum.ResourceKind);
	}

	public void setRootResourceKind(ResourceKind rootResourceKind) {
		wSet(WorkflowsFeatureDescriptorEnum.rootResourceKind, rootResourceKind);
	}

	public Expression getRootResource() {
		return wGet(WorkflowsFeatureDescriptorEnum.rootResource).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Expression);
	}

	public void setRootResource(Expression rootResource) {
		wSet(WorkflowsFeatureDescriptorEnum.rootResource, rootResource);
	}
}
