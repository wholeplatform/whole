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
public class ReturnEventAdapter extends AbstractEntityAdapter implements
		ReturnEvent {
	private static final long serialVersionUID = 1;

	public ReturnEventAdapter(IEntity implementor) {
		super(implementor);
	}

	public ReturnEventAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ReturnEvent> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.ReturnEvent;
	}

	public Label getLabel() {
		return wGet(WorkflowsFeatureDescriptorEnum.label).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Label);
	}

	public void setLabel(Label label) {
		wSet(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public Result getResult() {
		return wGet(WorkflowsFeatureDescriptorEnum.result).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Result);
	}

	public void setResult(Result result) {
		wSet(WorkflowsFeatureDescriptorEnum.result, result);
	}
}
