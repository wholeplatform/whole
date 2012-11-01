package org.whole.lang.workflows.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;

/** 
 * @generator Whole
 */
public interface IWorkflowsEntity extends IEntity {
	public void accept(IWorkflowsVisitor visitor);
}
