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
public class SwitchControlAdapter extends AbstractEntityAdapter implements
		SwitchControl {
	private static final long serialVersionUID = 1;

	public SwitchControlAdapter(IEntity implementor) {
		super(implementor);
	}

	public SwitchControlAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SwitchControl> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.SwitchControl;
	}

	public Label getLabel() {
		return wGet(WorkflowsFeatureDescriptorEnum.label).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Label);
	}

	public void setLabel(Label label) {
		wSet(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public SwitchType getSwitchType() {
		return wGet(WorkflowsFeatureDescriptorEnum.switchType).wGetAdapter(
				WorkflowsEntityDescriptorEnum.SwitchType);
	}

	public void setSwitchType(SwitchType switchType) {
		wSet(WorkflowsFeatureDescriptorEnum.switchType, switchType);
	}

	public ConditionalCases getConditionalCases() {
		return wGet(WorkflowsFeatureDescriptorEnum.conditionalCases)
				.wGetAdapter(WorkflowsEntityDescriptorEnum.ConditionalCases);
	}

	public void setConditionalCases(ConditionalCases conditionalCases) {
		wSet(WorkflowsFeatureDescriptorEnum.conditionalCases, conditionalCases);
	}

	public DefaultCase getDefaultCase() {
		return wGet(WorkflowsFeatureDescriptorEnum.defaultCase).wGetAdapter(
				WorkflowsEntityDescriptorEnum.DefaultCase);
	}

	public void setDefaultCase(DefaultCase defaultCase) {
		wSet(WorkflowsFeatureDescriptorEnum.defaultCase, defaultCase);
	}
}
