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
public class ConditionalCaseAdapter extends AbstractEntityAdapter implements
		ConditionalCase {
	private static final long serialVersionUID = 1;

	public ConditionalCaseAdapter(IEntity implementor) {
		super(implementor);
	}

	public ConditionalCaseAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ConditionalCase> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.ConditionalCase;
	}

	public Label getLabel() {
		return wGet(WorkflowsFeatureDescriptorEnum.label).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Label);
	}

	public void setLabel(Label label) {
		wSet(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public Condition getCondition() {
		return wGet(WorkflowsFeatureDescriptorEnum.condition).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Condition);
	}

	public void setCondition(Condition condition) {
		wSet(WorkflowsFeatureDescriptorEnum.condition, condition);
	}

	public FlowObject getFlowObject() {
		return wGet(WorkflowsFeatureDescriptorEnum.flowObject).wGetAdapter(
				WorkflowsEntityDescriptorEnum.FlowObject);
	}

	public void setFlowObject(FlowObject flowObject) {
		wSet(WorkflowsFeatureDescriptorEnum.flowObject, flowObject);
	}
}
