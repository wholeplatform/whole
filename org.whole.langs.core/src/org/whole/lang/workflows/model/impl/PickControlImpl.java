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
public class PickControlImpl extends AbstractSimpleEntity implements
		PickControl {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<PickControl> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.PickControl;
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.PickControl_ord;
	}

	public void accept(IWorkflowsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Label label;

	public Label getLabel() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public void setLabel(Label label) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.label, this.label,
				this.label = label);
	}

	private EventHandlers eventHandlers;

	public EventHandlers getEventHandlers() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.eventHandlers,
				eventHandlers);
	}

	public void setEventHandlers(EventHandlers eventHandlers) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.eventHandlers,
				this.eventHandlers, this.eventHandlers = eventHandlers);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLabel().wGetAdaptee(false);
		case 1:
			return getEventHandlers().wGetAdaptee(false);
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
			setEventHandlers(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.EventHandlers));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
