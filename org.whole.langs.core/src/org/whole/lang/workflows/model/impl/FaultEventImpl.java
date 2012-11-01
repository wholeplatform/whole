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
public class FaultEventImpl extends AbstractSimpleEntity implements FaultEvent {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FaultEvent> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.FaultEvent;
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.FaultEvent_ord;
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

	private Fault fault;

	public Fault getFault() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.fault, fault);
	}

	public void setFault(Fault fault) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.fault, this.fault,
				this.fault = fault);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLabel().wGetAdaptee(false);
		case 1:
			return getFault().wGetAdaptee(false);
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
			setFault(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Fault));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
