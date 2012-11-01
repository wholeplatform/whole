package org.whole.lang.frames.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class FramesTraversalFactory extends GenericTraversalFactory {
	public static final FramesTraversalFactory instance = new FramesTraversalFactory();

	private FramesTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IFramesVisitor)
			return visitor;
		else
			return new FramesForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new FramesFailureVisitor();
	}

	public IVisitor identity() {
		return new FramesIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new FramesForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new FramesSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new FramesTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new FramesTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new FramesTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
