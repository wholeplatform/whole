package org.whole.lang.misc.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class MiscTraversalFactory extends GenericTraversalFactory {
	public static final MiscTraversalFactory instance = new MiscTraversalFactory();

	private MiscTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IMiscVisitor)
			return visitor;
		else
			return new MiscForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new MiscFailureVisitor();
	}

	public IVisitor identity() {
		return new MiscIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new MiscForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new MiscSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new MiscTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new MiscTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new MiscTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
