package org.whole.lang.pojo.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class PojoTraversalFactory extends GenericTraversalFactory {
	public static final PojoTraversalFactory instance = new PojoTraversalFactory();

	private PojoTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IPojoVisitor)
			return visitor;
		else
			return new PojoForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new PojoFailureVisitor();
	}

	public IVisitor identity() {
		return new PojoIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new PojoForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new PojoSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new PojoTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new PojoTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new PojoTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
