package org.whole.lang.patterns.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class PatternsTraversalFactory extends GenericTraversalFactory {
	public static final PatternsTraversalFactory instance = new PatternsTraversalFactory();

	private PatternsTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IPatternsVisitor)
			return visitor;
		else
			return new PatternsForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new PatternsFailureVisitor();
	}

	public IVisitor identity() {
		return new PatternsIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new PatternsForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new PatternsSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new PatternsTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new PatternsTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new PatternsTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}