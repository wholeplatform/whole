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
public class FaultEventAdapter extends AbstractEntityAdapter implements
		FaultEvent {
	private static final long serialVersionUID = 1;

	public FaultEventAdapter(IEntity implementor) {
		super(implementor);
	}

	public FaultEventAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FaultEvent> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.FaultEvent;
	}

	public Label getLabel() {
		return wGet(WorkflowsFeatureDescriptorEnum.label).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Label);
	}

	public void setLabel(Label label) {
		wSet(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public Fault getFault() {
		return wGet(WorkflowsFeatureDescriptorEnum.fault).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Fault);
	}

	public void setFault(Fault fault) {
		wSet(WorkflowsFeatureDescriptorEnum.fault, fault);
	}
}
