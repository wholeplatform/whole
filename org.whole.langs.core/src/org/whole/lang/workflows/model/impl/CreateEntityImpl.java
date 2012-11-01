package org.whole.lang.workflows.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.workflows.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class CreateEntityImpl extends AbstractSimpleEntity implements
		CreateEntity {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<CreateEntity> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.CreateEntity;
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.CreateEntity_ord;
	}

	public void accept(IWorkflowsVisitor visitor) {
		visitor.visit(this);
	}

	private Label label;

	public Label getLabel() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public void setLabel(Label label) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.label, this.label,
				this.label = label);
	}

	private Variable model;

	public Variable getModel() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.model, model);
	}

	public void setModel(Variable model) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.model, this.model,
				this.model = model);
	}

	private Registry registry;

	public Registry getRegistry() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.registry,
				registry);
	}

	public void setRegistry(Registry registry) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.registry, this.registry,
				this.registry = registry);
	}

	private Expression entityName;

	public Expression getEntityName() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.entityName,
				entityName);
	}

	public void setEntityName(Expression entityName) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.entityName,
				this.entityName, this.entityName = entityName);
	}

	private Arguments arguments;

	public Arguments getArguments() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.arguments,
				arguments);
	}

	public void setArguments(Arguments arguments) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.arguments, this.arguments,
				this.arguments = arguments);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLabel().wGetAdaptee(false);
		case 1:
			return getModel().wGetAdaptee(false);
		case 2:
			return getRegistry().wGetAdaptee(false);
		case 3:
			return getEntityName().wGetAdaptee(false);
		case 4:
			return getArguments().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLabel(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Label));
			break;
		case 1:
			setModel(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Variable));
			break;
		case 2:
			setRegistry(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Registry));
			break;
		case 3:
			setEntityName(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
			break;
		case 4:
			setArguments(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Arguments));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 5;
	}
}
