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
public class FaultHandlerAdapter extends AbstractEntityAdapter implements
		FaultHandler {
	private static final long serialVersionUID = 1;

	public FaultHandlerAdapter(IEntity implementor) {
		super(implementor);
	}

	public FaultHandlerAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FaultHandler> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.FaultHandler;
	}

	public Name getName() {
		return wGet(WorkflowsFeatureDescriptorEnum.name).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(WorkflowsFeatureDescriptorEnum.name, name);
	}

	public Label getLabel() {
		return wGet(WorkflowsFeatureDescriptorEnum.label).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Label);
	}

	public void setLabel(Label label) {
		wSet(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public Fault getFaultName() {
		return wGet(WorkflowsFeatureDescriptorEnum.faultName).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Fault);
	}

	public void setFaultName(Fault faultName) {
		wSet(WorkflowsFeatureDescriptorEnum.faultName, faultName);
	}

	public Variable getFaultVariable() {
		return wGet(WorkflowsFeatureDescriptorEnum.faultVariable).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Variable);
	}

	public void setFaultVariable(Variable faultVariable) {
		wSet(WorkflowsFeatureDescriptorEnum.faultVariable, faultVariable);
	}

	public FlowObject getFlowObject() {
		return wGet(WorkflowsFeatureDescriptorEnum.flowObject).wGetAdapter(
				WorkflowsEntityDescriptorEnum.FlowObject);
	}

	public void setFlowObject(FlowObject flowObject) {
		wSet(WorkflowsFeatureDescriptorEnum.flowObject, flowObject);
	}
}
