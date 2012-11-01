package org.whole.lang.firstorderlogic.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class FirstOrderLogicTraversalFactory extends GenericTraversalFactory {
	public static final FirstOrderLogicTraversalFactory instance = new FirstOrderLogicTraversalFactory();

	private FirstOrderLogicTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IFirstOrderLogicVisitor)
			return visitor;
		else
			return new FirstOrderLogicForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new FirstOrderLogicFailureVisitor();
	}

	public IVisitor identity() {
		return new FirstOrderLogicIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new FirstOrderLogicForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new FirstOrderLogicSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new FirstOrderLogicTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new FirstOrderLogicTraverseAllChildrenVisitor(
				ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new FirstOrderLogicTraverseAllAdjacentsVisitor(
				ensureSpecific(visitor1));
	}
}
