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
public class OnTimerEventAdapter extends AbstractEntityAdapter implements
		OnTimerEvent {
	private static final long serialVersionUID = 1;

	public OnTimerEventAdapter(IEntity implementor) {
		super(implementor);
	}

	public OnTimerEventAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<OnTimerEvent> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.OnTimerEvent;
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

	public Timer getTimer() {
		return wGet(WorkflowsFeatureDescriptorEnum.timer).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Timer);
	}

	public void setTimer(Timer timer) {
		wSet(WorkflowsFeatureDescriptorEnum.timer, timer);
	}
}
