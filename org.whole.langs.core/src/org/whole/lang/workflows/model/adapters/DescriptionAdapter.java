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
public class DescriptionAdapter extends AbstractEntityAdapter implements
		Description {
	private static final long serialVersionUID = 1;

	public DescriptionAdapter(IEntity implementor) {
		super(implementor);
	}

	public DescriptionAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Description> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.Description;
	}
}
