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
public class CreateEntityAdapter extends AbstractEntityAdapter implements
		CreateEntity {
	private static final long serialVersionUID = 1;

	public CreateEntityAdapter(IEntity implementor) {
		super(implementor);
	}

	public CreateEntityAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CreateEntity> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.CreateEntity;
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

	public Registry getRegistry() {
		return wGet(WorkflowsFeatureDescriptorEnum.registry).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Registry);
	}

	public void setRegistry(Registry registry) {
		wSet(WorkflowsFeatureDescriptorEnum.registry, registry);
	}

	public Expression getEntityName() {
		return wGet(WorkflowsFeatureDescriptorEnum.entityName).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Expression);
	}

	public void setEntityName(Expression entityName) {
		wSet(WorkflowsFeatureDescriptorEnum.entityName, entityName);
	}

	public Arguments getArguments() {
		return wGet(WorkflowsFeatureDescriptorEnum.arguments).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Arguments);
	}

	public void setArguments(Arguments arguments) {
		wSet(WorkflowsFeatureDescriptorEnum.arguments, arguments);
	}
}
