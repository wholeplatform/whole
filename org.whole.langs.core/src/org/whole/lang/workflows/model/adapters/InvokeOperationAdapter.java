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
public class InvokeOperationAdapter extends AbstractEntityAdapter implements
		InvokeOperation {
	private static final long serialVersionUID = 1;

	public InvokeOperationAdapter(IEntity implementor) {
		super(implementor);
	}

	public InvokeOperationAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<InvokeOperation> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.InvokeOperation;
	}

	public Label getLabel() {
		return wGet(WorkflowsFeatureDescriptorEnum.label).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Label);
	}

	public void setLabel(Label label) {
		wSet(WorkflowsFeatureDescriptorEnum.label, label);
	}

	public Variable getModel() {
		return wGet(WorkflowsFeatureDescriptorEnum.model).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Variable);
	}

	public void setModel(Variable model) {
		wSet(WorkflowsFeatureDescriptorEnum.model, model);
	}

	public Operation getOperation() {
		return wGet(WorkflowsFeatureDescriptorEnum.operation).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Operation);
	}

	public void setOperation(Operation operation) {
		wSet(WorkflowsFeatureDescriptorEnum.operation, operation);
	}

	public Assignments getBindings() {
		return wGet(WorkflowsFeatureDescriptorEnum.bindings).wGetAdapter(
				WorkflowsEntityDescriptorEnum.Assignments);
	}

	public void setBindings(Assignments bindings) {
		wSet(WorkflowsFeatureDescriptorEnum.bindings, bindings);
	}
}
