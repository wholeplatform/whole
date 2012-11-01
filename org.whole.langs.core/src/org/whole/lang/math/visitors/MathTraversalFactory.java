package org.whole.lang.math.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class MathTraversalFactory extends GenericTraversalFactory {
	public static final MathTraversalFactory instance = new MathTraversalFactory();

	private MathTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IMathVisitor)
			return visitor;
		else
			return new MathForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new MathFailureVisitor();
	}

	public IVisitor identity() {
		return new MathIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new MathForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new MathSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new MathTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new MathTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new MathTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
