package org.whole.lang.workflows.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.workflows.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.model.OperationEnum.Value;

/** 
 * @generator Whole
 */
public class OperationAdapter extends AbstractEntityAdapter implements
		Operation {
	private static final long serialVersionUID = 1;

	public OperationAdapter(IEntity implementor) {
		super(implementor);
	}

	public OperationAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Operation> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.Operation;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
