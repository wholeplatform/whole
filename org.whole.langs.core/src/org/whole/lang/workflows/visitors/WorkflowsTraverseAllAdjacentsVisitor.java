package org.whole.lang.workflows.visitors;

import org.whole.lang.workflows.visitors.WorkflowsIdentityUnaryVisitor;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.workflows.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class WorkflowsTraverseAllAdjacentsVisitor extends
		WorkflowsIdentityUnaryVisitor<IWorkflowsVisitor> {
	public WorkflowsTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public WorkflowsTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
