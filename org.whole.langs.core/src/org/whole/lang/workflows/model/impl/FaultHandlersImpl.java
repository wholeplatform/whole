package org.whole.lang.workflows.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.workflows.model.*;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class FaultHandlersImpl extends
		AbstractCollectionCompositeEntity<FaultHandler> implements
		FaultHandlers {
	private static final long serialVersionUID = 1;

	public void accept(IWorkflowsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.FaultHandlers_ord;
	}

	public EntityDescriptor<FaultHandlers> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.FaultHandlers;
	}
}
