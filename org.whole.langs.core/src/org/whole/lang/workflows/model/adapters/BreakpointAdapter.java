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
public class BreakpointAdapter extends AbstractEntityAdapter implements
		Breakpoint {
	private static final long serialVersionUID = 1;

	public BreakpointAdapter(IEntity implementor) {
		super(implementor);
	}

	public BreakpointAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Breakpoint> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.Breakpoint;
	}

	public Label getLabel() {
		return wGet(WorkflowsFeatureDescriptorEnum.label).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Label);
	}

	public void setLabel(Label label) {
		wSet(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public BooleanLiteral getDisabled() {
		return wGet(WorkflowsFeatureDescriptorEnum.disabled).wGetAdapter(
				WorkflowsEntityDescriptorEnum.BooleanLiteral);
	}

	public void setDisabled(BooleanLiteral disabled) {
		wSet(WorkflowsFeatureDescriptorEnum.disabled, disabled);
	}

	public IntLiteral getHitCount() {
		return wGet(WorkflowsFeatureDescriptorEnum.hitCount).wGetAdapter(
				WorkflowsEntityDescriptorEnum.IntLiteral);
	}

	public void setHitCount(IntLiteral hitCount) {
		wSet(WorkflowsFeatureDescriptorEnum.hitCount, hitCount);
	}

	public Condition getCondition() {
		return wGet(WorkflowsFeatureDescriptorEnum.condition).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Condition);
	}

	public void setCondition(Condition condition) {
		wSet(WorkflowsFeatureDescriptorEnum.condition, condition);
	}

	public ConditionTest getConditionTest() {
		return wGet(WorkflowsFeatureDescriptorEnum.conditionTest).wGetAdapter(
				WorkflowsEntityDescriptorEnum.ConditionTest);
	}

	public void setConditionTest(ConditionTest conditionTest) {
		wSet(WorkflowsFeatureDescriptorEnum.conditionTest, conditionTest);
	}

	public Variables getShowVariables() {
		return wGet(WorkflowsFeatureDescriptorEnum.showVariables).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Variables);
	}

	public void setShowVariables(Variables showVariables) {
		wSet(WorkflowsFeatureDescriptorEnum.showVariables, showVariables);
	}
}
