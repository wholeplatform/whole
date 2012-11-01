package org.whole.lang.workflows.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.workflows.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.model.ConditionTestEnum.Value;

/** 
 * @generator Whole
 */
public class ConditionTestAdapter extends AbstractEntityAdapter implements
		ConditionTest {
	private static final long serialVersionUID = 1;

	public ConditionTestAdapter(IEntity implementor) {
		super(implementor);
	}

	public ConditionTestAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ConditionTest> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.ConditionTest;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
