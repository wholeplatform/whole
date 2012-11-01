package org.whole.lang.semantics.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class SemanticsTraversalFactory extends GenericTraversalFactory {
	public static final SemanticsTraversalFactory instance = new SemanticsTraversalFactory();

	private SemanticsTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof ISemanticsVisitor)
			return visitor;
		else
			return new SemanticsForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new SemanticsFailureVisitor();
	}

	public IVisitor identity() {
		return new SemanticsIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new SemanticsForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new SemanticsSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new SemanticsTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new SemanticsTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new SemanticsTraverseAllAdjacentsVisitor(
				ensureSpecific(visitor1));
	}
}
