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
public class ParallelAdapter extends AbstractEntityAdapter implements Parallel {
	private static final long serialVersionUID = 1;

	public ParallelAdapter(IEntity implementor) {
		super(implementor);
	}

	public ParallelAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Parallel> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.Parallel;
	}

	public Label getLabel() {
		return wGet(WorkflowsFeatureDescriptorEnum.label).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Label);
	}

	public void setLabel(Label label) {
		wSet(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public FlowObjects getFlowObjects() {
		return wGet(WorkflowsFeatureDescriptorEnum.flowObjects).wGetAdapter(
				WorkflowsEntityDescriptorEnum.FlowObjects);
	}

	public void setFlowObjects(FlowObjects flowObjects) {
		wSet(WorkflowsFeatureDescriptorEnum.flowObjects, flowObjects);
	}
}
