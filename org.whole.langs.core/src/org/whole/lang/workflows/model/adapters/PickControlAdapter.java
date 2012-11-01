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
public class PickControlAdapter extends AbstractEntityAdapter implements
		PickControl {
	private static final long serialVersionUID = 1;

	public PickControlAdapter(IEntity implementor) {
		super(implementor);
	}

	public PickControlAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PickControl> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.PickControl;
	}

	public Label getLabel() {
		return wGet(WorkflowsFeatureDescriptorEnum.label).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Label);
	}

	public void setLabel(Label label) {
		wSet(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public EventHandlers getEventHandlers() {
		return wGet(WorkflowsFeatureDescriptorEnum.eventHandlers).wGetAdapter(
				WorkflowsEntityDescriptorEnum.EventHandlers);
	}

	public void setEventHandlers(EventHandlers eventHandlers) {
		wSet(WorkflowsFeatureDescriptorEnum.eventHandlers, eventHandlers);
	}
}
