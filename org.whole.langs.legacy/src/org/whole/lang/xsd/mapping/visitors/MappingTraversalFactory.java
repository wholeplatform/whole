package org.whole.lang.xsd.mapping.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class MappingTraversalFactory extends GenericTraversalFactory {
	public static final MappingTraversalFactory instance = new MappingTraversalFactory();

	private MappingTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IMappingVisitor)
			return visitor;
		else
			return new MappingForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new MappingFailureVisitor();
	}

	public IVisitor identity() {
		return new MappingIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new MappingForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new MappingSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new MappingTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new MappingTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new MappingTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
