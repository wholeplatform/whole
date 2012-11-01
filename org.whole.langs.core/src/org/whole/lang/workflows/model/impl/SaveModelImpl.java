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
public class SaveModelImpl extends AbstractSimpleEntity implements SaveModel {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SaveModel> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.SaveModel;
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.SaveModel_ord;
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

	private Expression persistence;

	public Expression getPersistence() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.persistence,
				persistence);
	}

	public void setPersistence(Expression persistence) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.persistence,
				this.persistence, this.persistence = persistence);
	}

	private ResourceKind resourceKind;

	public ResourceKind getResourceKind() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.resourceKind,
				resourceKind);
	}

	public void setResourceKind(ResourceKind resourceKind) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.resourceKind,
				this.resourceKind, this.resourceKind = resourceKind);
	}

	private Expression resource;

	public Expression getResource() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.resource,
				resource);
	}

	public void setResource(Expression resource) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.resource, this.resource,
				this.resource = resource);
	}

	private Assignments bindings;

	public Assignments getBindings() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.bindings,
				bindings);
	}

	public void setBindings(Assignments bindings) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.bindings, this.bindings,
				this.bindings = bindings);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLabel().wGetAdaptee(false);
		case 1:
			return getModel().wGetAdaptee(false);
		case 2:
			return getPersistence().wGetAdaptee(false);
		case 3:
			return getResourceKind().wGetAdaptee(false);
		case 4:
			return getResource().wGetAdaptee(false);
		case 5:
			return getBindings().wGetAdaptee(false);
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
			setPersistence(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
			break;
		case 3:
			setResourceKind(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.ResourceKind));
			break;
		case 4:
			setResource(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Expression));
			break;
		case 5:
			setBindings(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Assignments));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 6;
	}
}
