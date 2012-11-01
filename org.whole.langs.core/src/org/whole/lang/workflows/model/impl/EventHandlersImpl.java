package org.whole.lang.workflows.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.workflows.model.*;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class EventHandlersImpl extends
		AbstractListCompositeEntity<EventHandler> implements EventHandlers {
	private static final long serialVersionUID = 1;

	public void accept(IWorkflowsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.EventHandlers_ord;
	}

	public EntityDescriptor<EventHandlers> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.EventHandlers;
	}
}
