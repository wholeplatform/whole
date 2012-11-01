package org.whole.lang.workflows.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.workflows.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.model.TestTimeEnum.Value;

/** 
 * @generator Whole
 */
public class TestTimeAdapter extends AbstractEntityAdapter implements TestTime {
	private static final long serialVersionUID = 1;

	public TestTimeAdapter(IEntity implementor) {
		super(implementor);
	}

	public TestTimeAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TestTime> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.TestTime;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
