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
public class SaveArtifactsAdapter extends AbstractEntityAdapter implements
		SaveArtifacts {
	private static final long serialVersionUID = 1;

	public SaveArtifactsAdapter(IEntity implementor) {
		super(implementor);
	}

	public SaveArtifactsAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SaveArtifacts> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.SaveArtifacts;
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

	public ArtifactsTraversalStrategy getTraversalStrategy() {
		return wGet(WorkflowsFeatureDescriptorEnum.traversalStrategy)
				.wGetAdapter(
						WorkflowsEntityDescriptorEnum.ArtifactsTraversalStrategy);
	}

	public void setTraversalStrategy(
			ArtifactsTraversalStrategy traversalStrategy) {
		wSet(WorkflowsFeatureDescriptorEnum.traversalStrategy,
				traversalStrategy);
	}

	public ArtifactsSynchronizeStrategy getSynchronizeStrategy() {
		return wGet(WorkflowsFeatureDescriptorEnum.synchronizeStrategy)
				.wGetAdapter(
						WorkflowsEntityDescriptorEnum.ArtifactsSynchronizeStrategy);
	}

	public void setSynchronizeStrategy(
			ArtifactsSynchronizeStrategy synchronizeStrategy) {
		wSet(WorkflowsFeatureDescriptorEnum.synchronizeStrategy,
				synchronizeStrategy);
	}

	public Expression getDefaultPersistence() {
		return wGet(WorkflowsFeatureDescriptorEnum.defaultPersistence)
				.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression);
	}

	public void setDefaultPersistence(Expression defaultPersistence) {
		wSet(WorkflowsFeatureDescriptorEnum.defaultPersistence,
				defaultPersistence);
	}
}
