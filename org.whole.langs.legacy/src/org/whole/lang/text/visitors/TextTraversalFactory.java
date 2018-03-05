package org.whole.lang.text.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class TextTraversalFactory extends GenericTraversalFactory {
	public static final TextTraversalFactory instance = new TextTraversalFactory();

	private TextTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof ITextVisitor)
			return visitor;
		else
			return new TextForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new TextFailureVisitor();
	}

	public IVisitor identity() {
		return new TextIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new TextForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new TextSequenceVisitor(ensureSpecific(visitor1), ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new TextTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new TextTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new TextTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
