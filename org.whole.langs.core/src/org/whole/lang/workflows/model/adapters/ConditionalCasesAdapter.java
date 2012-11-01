package org.whole.lang.workflows.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.workflows.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ConditionalCasesAdapter extends
		AbstractListEntityAdapter<ConditionalCase> implements ConditionalCases {
	private static final long serialVersionUID = 1;

	public ConditionalCasesAdapter(IEntity implementor) {
		super(implementor);
	}

	public ConditionalCasesAdapter() {
	}

	public void accept(IWorkflowsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ConditionalCases> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.ConditionalCases;
	}
}
