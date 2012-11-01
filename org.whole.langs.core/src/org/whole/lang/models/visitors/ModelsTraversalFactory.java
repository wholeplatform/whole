package org.whole.lang.models.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class ModelsTraversalFactory extends GenericTraversalFactory {
	public static final ModelsTraversalFactory instance = new ModelsTraversalFactory();

	private ModelsTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IModelsVisitor)
			return visitor;
		else
			return new ModelsForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new ModelsFailureVisitor();
	}

	public IVisitor identity() {
		return new ModelsIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new ModelsForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new ModelsSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new ModelsTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new ModelsTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new ModelsTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
