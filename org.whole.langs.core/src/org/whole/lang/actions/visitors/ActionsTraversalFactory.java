package org.whole.lang.actions.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class ActionsTraversalFactory extends GenericTraversalFactory {
	public static final ActionsTraversalFactory instance = new ActionsTraversalFactory();

	private ActionsTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IActionsVisitor)
			return visitor;
		else
			return new ActionsForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new ActionsFailureVisitor();
	}

	public IVisitor identity() {
		return new ActionsIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new ActionsForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new ActionsSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new ActionsTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new ActionsTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new ActionsTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
