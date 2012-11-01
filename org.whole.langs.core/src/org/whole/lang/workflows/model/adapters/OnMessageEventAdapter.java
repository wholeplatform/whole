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
public class OnMessageEventAdapter extends AbstractEntityAdapter implements
		OnMessageEvent {
	private static final long serialVersionUID = 1;

	public OnMessageEventAdapter(IEntity implementor) {
		super(implementor);
	}

	public OnMessageEventAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<OnMessageEvent> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.OnMessageEvent;
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

	public Message getMessage() {
		return wGet(WorkflowsFeatureDescriptorEnum.message).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Message);
	}

	public void setMessage(Message message) {
		wSet(WorkflowsFeatureDescriptorEnum.message, message);
	}
}
