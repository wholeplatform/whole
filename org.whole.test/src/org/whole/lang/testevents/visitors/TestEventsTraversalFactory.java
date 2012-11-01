package org.whole.lang.testevents.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class TestEventsTraversalFactory extends GenericTraversalFactory {
	public static final TestEventsTraversalFactory instance = new TestEventsTraversalFactory();

	private TestEventsTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof ITestEventsVisitor)
			return visitor;
		else
			return new TestEventsForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new TestEventsFailureVisitor();
	}

	public IVisitor identity() {
		return new TestEventsIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new TestEventsForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new TestEventsSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new TestEventsTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new TestEventsTraverseAllChildrenVisitor(
				ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new TestEventsTraverseAllAdjacentsVisitor(
				ensureSpecific(visitor1));
	}
}
