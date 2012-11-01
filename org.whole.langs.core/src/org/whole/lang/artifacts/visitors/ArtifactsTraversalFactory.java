package org.whole.lang.artifacts.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class ArtifactsTraversalFactory extends GenericTraversalFactory {
	public static final ArtifactsTraversalFactory instance = new ArtifactsTraversalFactory();

	private ArtifactsTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IArtifactsVisitor)
			return visitor;
		else
			return new ArtifactsForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new ArtifactsFailureVisitor();
	}

	public IVisitor identity() {
		return new ArtifactsIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new ArtifactsForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new ArtifactsSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new ArtifactsTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new ArtifactsTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new ArtifactsTraverseAllAdjacentsVisitor(
				ensureSpecific(visitor1));
	}
}
