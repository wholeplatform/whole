package org.whole.lang.unifiedlambdadelta.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaTraversalFactory extends GenericTraversalFactory {
	public static final UnifiedLambdaDeltaTraversalFactory instance = new UnifiedLambdaDeltaTraversalFactory();

	private UnifiedLambdaDeltaTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IUnifiedLambdaDeltaVisitor)
			return visitor;
		else
			return new UnifiedLambdaDeltaForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new UnifiedLambdaDeltaFailureVisitor();
	}

	public IVisitor identity() {
		return new UnifiedLambdaDeltaIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new UnifiedLambdaDeltaForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new UnifiedLambdaDeltaSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new UnifiedLambdaDeltaTraverseAllVisitor(
				ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new UnifiedLambdaDeltaTraverseAllChildrenVisitor(
				ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new UnifiedLambdaDeltaTraverseAllAdjacentsVisitor(
				ensureSpecific(visitor1));
	}
}
