package org.whole.examples.lang.imp.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class ImpTraversalFactory extends GenericTraversalFactory {
	public static final ImpTraversalFactory instance = new ImpTraversalFactory();

	private ImpTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IImpVisitor)
			return visitor;
		else
			return new ImpForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new ImpFailureVisitor();
	}

	public IVisitor identity() {
		return new ImpIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new ImpForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new ImpSequenceVisitor(ensureSpecific(visitor1), ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new ImpTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new ImpTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new ImpTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
