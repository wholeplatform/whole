package org.whole.lang.workflows.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.workflows.model.*;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ConditionalCasesImpl extends
		AbstractListCompositeEntity<ConditionalCase> implements
		ConditionalCases {
	private static final long serialVersionUID = 1;

	public void accept(IWorkflowsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.ConditionalCases_ord;
	}

	public EntityDescriptor<ConditionalCases> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.ConditionalCases;
	}
}
