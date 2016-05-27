package org.whole.lang.commons.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class CommonsTraversalFactory extends GenericTraversalFactory {
	public static final CommonsTraversalFactory instance = new CommonsTraversalFactory();

	private CommonsTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof ICommonsVisitor)
			return visitor;
		else
			return new CommonsForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new CommonsFailureVisitor();
	}

	public IVisitor identity() {
		return new CommonsIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new CommonsForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new CommonsSequenceVisitor(ensureSpecific(visitor1), ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new CommonsTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new CommonsTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new CommonsTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
