package org.whole.lang.environment.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class EnvironmentTraversalFactory extends GenericTraversalFactory {
	public static final EnvironmentTraversalFactory instance = new EnvironmentTraversalFactory();

	private EnvironmentTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IEnvironmentVisitor)
			return visitor;
		else
			return new EnvironmentForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new EnvironmentFailureVisitor();
	}

	public IVisitor identity() {
		return new EnvironmentIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new EnvironmentForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new EnvironmentSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new EnvironmentTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new EnvironmentTraverseAllChildrenVisitor(
				ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new EnvironmentTraverseAllAdjacentsVisitor(
				ensureSpecific(visitor1));
	}
}
