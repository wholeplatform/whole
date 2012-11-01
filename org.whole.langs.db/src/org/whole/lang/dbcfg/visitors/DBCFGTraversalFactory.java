package org.whole.lang.dbcfg.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class DBCFGTraversalFactory extends GenericTraversalFactory {
	public static final DBCFGTraversalFactory instance = new DBCFGTraversalFactory();

	private DBCFGTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IDBCFGVisitor)
			return visitor;
		else
			return new DBCFGForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new DBCFGFailureVisitor();
	}

	public IVisitor identity() {
		return new DBCFGIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new DBCFGForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new DBCFGSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new DBCFGTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new DBCFGTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new DBCFGTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
