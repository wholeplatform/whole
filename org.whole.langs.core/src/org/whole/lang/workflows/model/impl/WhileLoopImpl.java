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
public class WhileLoopImpl extends AbstractSimpleEntity implements WhileLoop {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<WhileLoop> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.WhileLoop;
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.WhileLoop_ord;
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

	private TestTime testTime;

	public TestTime getTestTime() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.testTime,
				testTime);
	}

	public void setTestTime(TestTime testTime) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.testTime, this.testTime,
				this.testTime = testTime);
	}

	private Condition condition;

	public Condition getCondition() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.condition,
				condition);
	}

	public void setCondition(Condition condition) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.condition, this.condition,
				this.condition = condition);
	}

	private FlowObject flowObject;

	public FlowObject getFlowObject() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.flowObject,
				flowObject);
	}

	public void setFlowObject(FlowObject flowObject) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.flowObject,
				this.flowObject, this.flowObject = flowObject);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLabel().wGetAdaptee(false);
		case 1:
			return getTestTime().wGetAdaptee(false);
		case 2:
			return getCondition().wGetAdaptee(false);
		case 3:
			return getFlowObject().wGetAdaptee(false);
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
			setTestTime(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.TestTime));
			break;
		case 2:
			setCondition(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Condition));
			break;
		case 3:
			setFlowObject(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.FlowObject));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
