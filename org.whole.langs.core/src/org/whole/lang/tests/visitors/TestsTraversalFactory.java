package org.whole.lang.tests.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class TestsTraversalFactory extends GenericTraversalFactory {
	public static final TestsTraversalFactory instance = new TestsTraversalFactory();

	private TestsTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof ITestsVisitor)
			return visitor;
		else
			return new TestsForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new TestsFailureVisitor();
	}

	public IVisitor identity() {
		return new TestsIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new TestsForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new TestsSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new TestsTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new TestsTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new TestsTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
