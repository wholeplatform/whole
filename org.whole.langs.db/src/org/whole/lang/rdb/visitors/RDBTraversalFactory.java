package org.whole.lang.rdb.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class RDBTraversalFactory extends GenericTraversalFactory {
	public static final RDBTraversalFactory instance = new RDBTraversalFactory();

	private RDBTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IRDBVisitor)
			return visitor;
		else
			return new RDBForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new RDBFailureVisitor();
	}

	public IVisitor identity() {
		return new RDBIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new RDBForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new RDBSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new RDBTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new RDBTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new RDBTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
