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
public class FaultHandlerImpl extends AbstractSimpleEntity implements
		FaultHandler {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FaultHandler> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.FaultHandler;
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.FaultHandler_ord;
	}

	public void accept(IWorkflowsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Name name;

	public Name getName() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Label label;

	public Label getLabel() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public void setLabel(Label label) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.label, this.label,
				this.label = label);
	}

	public int wHashCode() {
		return getFaultName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getFaultName().wEquals(
					entity.wGet(WorkflowsFeatureDescriptorEnum.faultName));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("faultName=");
		buffer.append(faultName);
	}

	private Fault faultName;

	public Fault getFaultName() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.faultName,
				faultName);
	}

	public void setFaultName(Fault faultName) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.faultName, this.faultName,
				this.faultName = faultName);
	}

	private Variable faultVariable;

	public Variable getFaultVariable() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.faultVariable,
				faultVariable);
	}

	public void setFaultVariable(Variable faultVariable) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.faultVariable,
				this.faultVariable, this.faultVariable = faultVariable);
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
			return getName().wGetAdaptee(false);
		case 1:
			return getLabel().wGetAdaptee(false);
		case 2:
			return getFaultName().wGetAdaptee(false);
		case 3:
			return getFaultVariable().wGetAdaptee(false);
		case 4:
			return getFlowObject().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Name));
			break;
		case 1:
			setLabel(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Label));
			break;
		case 2:
			setFaultName(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Fault));
			break;
		case 3:
			setFaultVariable(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Variable));
			break;
		case 4:
			setFlowObject(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.FlowObject));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 5;
	}
}
