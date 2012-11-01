package org.whole.lang.types.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class TypesTraversalFactory extends GenericTraversalFactory {
	public static final TypesTraversalFactory instance = new TypesTraversalFactory();

	private TypesTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof ITypesVisitor)
			return visitor;
		else
			return new TypesForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new TypesFailureVisitor();
	}

	public IVisitor identity() {
		return new TypesIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new TypesForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new TypesSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new TypesTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new TypesTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new TypesTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
