package org.whole.lang.workflows.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.workflows.model.*;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class FlowObjectsImpl extends AbstractListCompositeEntity<FlowObject>
		implements FlowObjects {
	private static final long serialVersionUID = 1;

	public void accept(IWorkflowsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.FlowObjects_ord;
	}

	public EntityDescriptor<FlowObjects> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.FlowObjects;
	}
}
