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
public class ParallelImpl extends AbstractSimpleEntity implements Parallel {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Parallel> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.Parallel;
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.Parallel_ord;
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

	private FlowObjects flowObjects;

	public FlowObjects getFlowObjects() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.flowObjects,
				flowObjects);
	}

	public void setFlowObjects(FlowObjects flowObjects) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.flowObjects,
				this.flowObjects, this.flowObjects = flowObjects);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLabel().wGetAdaptee(false);
		case 1:
			return getFlowObjects().wGetAdaptee(false);
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
			setFlowObjects(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.FlowObjects));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
