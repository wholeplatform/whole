package org.whole.lang.workflows.model.impl;

import org.whole.lang.model.AbstractUniqueListCompositeEntity;
import org.whole.lang.workflows.model.*;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class FaultHandlersStrictImpl extends
		AbstractUniqueListCompositeEntity<FaultHandler> implements
		FaultHandlers {
	private static final long serialVersionUID = 1;

	public void accept(IWorkflowsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.FaultHandlers_ord;
	}

	public EntityDescriptor<FaultHandlers> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.FaultHandlers;
	}
}
