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
public class ReturnEventImpl extends AbstractSimpleEntity implements
		ReturnEvent {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ReturnEvent> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.ReturnEvent;
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.ReturnEvent_ord;
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

	private Result result;

	public Result getResult() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.result, result);
	}

	public void setResult(Result result) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.result, this.result,
				this.result = result);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLabel().wGetAdaptee(false);
		case 1:
			return getResult().wGetAdaptee(false);
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
			setResult(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Result));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
