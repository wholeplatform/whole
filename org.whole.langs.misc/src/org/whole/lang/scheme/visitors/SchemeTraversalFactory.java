package org.whole.lang.scheme.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class SchemeTraversalFactory extends GenericTraversalFactory {
	public static final SchemeTraversalFactory instance = new SchemeTraversalFactory();

	private SchemeTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof ISchemeVisitor)
			return visitor;
		else
			return new SchemeForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new SchemeFailureVisitor();
	}

	public IVisitor identity() {
		return new SchemeIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new SchemeForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new SchemeSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new SchemeTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new SchemeTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new SchemeTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
