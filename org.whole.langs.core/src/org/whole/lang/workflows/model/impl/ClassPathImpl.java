package org.whole.lang.workflows.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.workflows.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;

/** 
 * @generator Whole
 */
public class ClassPathImpl extends AbstractSimpleEntity implements ClassPath {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ClassPath> wGetEntityDescriptor() {
		return WorkflowsEntityDescriptorEnum.ClassPath;
	}

	public int wGetEntityOrd() {
		return WorkflowsEntityDescriptorEnum.ClassPath_ord;
	}

	public void accept(IWorkflowsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
