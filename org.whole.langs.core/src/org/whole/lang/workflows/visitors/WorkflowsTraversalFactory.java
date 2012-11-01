package org.whole.lang.workflows.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class WorkflowsTraversalFactory extends GenericTraversalFactory {
	public static final WorkflowsTraversalFactory instance = new WorkflowsTraversalFactory();

	private WorkflowsTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IWorkflowsVisitor)
			return visitor;
		else
			return new WorkflowsForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new WorkflowsFailureVisitor();
	}

	public IVisitor identity() {
		return new WorkflowsIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new WorkflowsForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new WorkflowsSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new WorkflowsTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new WorkflowsTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new WorkflowsTraverseAllAdjacentsVisitor(
				ensureSpecific(visitor1));
	}
}
