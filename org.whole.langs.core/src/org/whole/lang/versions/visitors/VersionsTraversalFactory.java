package org.whole.lang.versions.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class VersionsTraversalFactory extends GenericTraversalFactory {
	public static final VersionsTraversalFactory instance = new VersionsTraversalFactory();

	private VersionsTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IVersionsVisitor)
			return visitor;
		else
			return new VersionsForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new VersionsFailureVisitor();
	}

	public IVisitor identity() {
		return new VersionsIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new VersionsForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new VersionsSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new VersionsTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new VersionsTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new VersionsTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
