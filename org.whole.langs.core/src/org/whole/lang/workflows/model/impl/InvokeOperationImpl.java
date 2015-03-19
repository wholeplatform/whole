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
public class InvokeOperationImpl extends AbstractSimpleEntity implements
		InvokeOperation {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<InvokeOperation> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.InvokeOperation;
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.InvokeOperation_ord;
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

	private Variable model;

	public Variable getModel() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.model, model);
	}

	public void setModel(Variable model) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.model, this.model,
				this.model = model);
	}

	private Operation operation;

	public Operation getOperation() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.operation,
				operation);
	}

	public void setOperation(Operation operation) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.operation, this.operation,
				this.operation = operation);
	}

	private Assignments bindings;

	public Assignments getBindings() {
		return notifyRequested(WorkflowsFeatureDescriptorEnum.bindings,
				bindings);
	}

	public void setBindings(Assignments bindings) {
		notifyChanged(WorkflowsFeatureDescriptorEnum.bindings, this.bindings,
				this.bindings = bindings);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLabel().wGetAdaptee(false);
		case 1:
			return getModel().wGetAdaptee(false);
		case 2:
			return getOperation().wGetAdaptee(false);
		case 3:
			return getBindings().wGetAdaptee(false);
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
			setModel(value.wGetAdapter(WorkflowsEntityDescriptorEnum.Variable));
			break;
		case 2:
			setOperation(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Operation));
			break;
		case 3:
			setBindings(value
					.wGetAdapter(WorkflowsEntityDescriptorEnum.Assignments));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
