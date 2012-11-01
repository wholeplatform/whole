package org.whole.examples.datatypes.redblacktree.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class RedBlackTreeTraversalFactory extends GenericTraversalFactory {
	public static final RedBlackTreeTraversalFactory instance = new RedBlackTreeTraversalFactory();

	private RedBlackTreeTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IRedBlackTreeVisitor)
			return visitor;
		else
			return new RedBlackTreeForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new RedBlackTreeFailureVisitor();
	}

	public IVisitor identity() {
		return new RedBlackTreeIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new RedBlackTreeForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new RedBlackTreeSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new RedBlackTreeTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new RedBlackTreeTraverseAllChildrenVisitor(
				ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new RedBlackTreeTraverseAllAdjacentsVisitor(
				ensureSpecific(visitor1));
	}
}
