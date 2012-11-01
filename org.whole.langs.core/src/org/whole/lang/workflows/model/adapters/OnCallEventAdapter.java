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
public class OnCallEventAdapter extends AbstractEntityAdapter implements
		OnCallEvent {
	private static final long serialVersionUID = 1;

	public OnCallEventAdapter(IEntity implementor) {
		super(implementor);
	}

	public OnCallEventAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<OnCallEvent> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.OnCallEvent;
	}

	public Name getName() {
		return wGet(WorkflowsFeatureDescriptorEnum.name).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(WorkflowsFeatureDescriptorEnum.name, name);
	}

	public Label getLabel() {
		return wGet(WorkflowsFeatureDescriptorEnum.label).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Label);
	}

	public void setLabel(Label label) {
		wSet(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public Parameters getParameters() {
		return wGet(WorkflowsFeatureDescriptorEnum.parameters).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Parameters);
	}

	public void setParameters(Parameters parameters) {
		wSet(WorkflowsFeatureDescriptorEnum.parameters, parameters);
	}
}
