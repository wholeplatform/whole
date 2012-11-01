package org.whole.lang.testentities.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class TestEntitiesTraversalFactory extends GenericTraversalFactory {
	public static final TestEntitiesTraversalFactory instance = new TestEntitiesTraversalFactory();

	private TestEntitiesTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof ITestEntitiesVisitor)
			return visitor;
		else
			return new TestEntitiesForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new TestEntitiesFailureVisitor();
	}

	public IVisitor identity() {
		return new TestEntitiesIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new TestEntitiesForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new TestEntitiesSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new TestEntitiesTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new TestEntitiesTraverseAllChildrenVisitor(
				ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new TestEntitiesTraverseAllAdjacentsVisitor(
				ensureSpecific(visitor1));
	}
}
