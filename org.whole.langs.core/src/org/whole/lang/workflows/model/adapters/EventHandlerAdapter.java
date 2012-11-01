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
public class EventHandlerAdapter extends AbstractEntityAdapter implements
		EventHandler {
	private static final long serialVersionUID = 1;

	public EventHandlerAdapter(IEntity implementor) {
		super(implementor);
	}

	public EventHandlerAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<EventHandler> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.EventHandler;
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

	public StartEvent getTriggerEvent() {
		return wGet(WorkflowsFeatureDescriptorEnum.triggerEvent).wGetAdapter(
				WorkflowsEntityDescriptorEnum.StartEvent);
	}

	public void setTriggerEvent(StartEvent triggerEvent) {
		wSet(WorkflowsFeatureDescriptorEnum.triggerEvent, triggerEvent);
	}

	public FlowObject getFlowObject() {
		return wGet(WorkflowsFeatureDescriptorEnum.flowObject).wGetAdapter(
				WorkflowsEntityDescriptorEnum.FlowObject);
	}

	public void setFlowObject(FlowObject flowObject) {
		wSet(WorkflowsFeatureDescriptorEnum.flowObject, flowObject);
	}
}
