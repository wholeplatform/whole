package org.whole.lang.workflows.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.workflows.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;

/** 
 * @generator Whole
 */
public class CurrentJavaProjectImpl extends AbstractSimpleEntity implements
		CurrentJavaProject {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<CurrentJavaProject> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.CurrentJavaProject;
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.CurrentJavaProject_ord;
	}

	public void accept(IWorkflowsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
