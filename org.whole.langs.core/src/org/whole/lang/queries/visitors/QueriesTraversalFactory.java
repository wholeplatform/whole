package org.whole.lang.queries.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class QueriesTraversalFactory extends GenericTraversalFactory {
	public static final QueriesTraversalFactory instance = new QueriesTraversalFactory();

	private QueriesTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IQueriesVisitor)
			return visitor;
		else
			return new QueriesForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new QueriesFailureVisitor();
	}

	public IVisitor identity() {
		return new QueriesIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new QueriesForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new QueriesSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new QueriesTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new QueriesTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new QueriesTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
