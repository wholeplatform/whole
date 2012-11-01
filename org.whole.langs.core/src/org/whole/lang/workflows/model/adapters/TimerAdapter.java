package org.whole.lang.workflows.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.workflows.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TimerAdapter extends AbstractEntityAdapter implements Timer {
	private static final long serialVersionUID = 1;

	public TimerAdapter(IEntity implementor) {
		super(implementor);
	}

	public TimerAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Timer> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.Timer;
	}
}
