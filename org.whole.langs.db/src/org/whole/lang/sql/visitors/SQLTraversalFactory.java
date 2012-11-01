package org.whole.lang.sql.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class SQLTraversalFactory extends GenericTraversalFactory {
	public static final SQLTraversalFactory instance = new SQLTraversalFactory();

	private SQLTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof ISQLVisitor)
			return visitor;
		else
			return new SQLForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new SQLFailureVisitor();
	}

	public IVisitor identity() {
		return new SQLIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new SQLForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new SQLSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new SQLTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new SQLTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new SQLTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
