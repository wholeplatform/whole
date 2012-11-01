package org.whole.lang.templates.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class TemplatesTraversalFactory extends GenericTraversalFactory {
	public static final TemplatesTraversalFactory instance = new TemplatesTraversalFactory();

	private TemplatesTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof ITemplatesVisitor)
			return visitor;
		else
			return new TemplatesForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new TemplatesFailureVisitor();
	}

	public IVisitor identity() {
		return new TemplatesIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new TemplatesForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new TemplatesSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new TemplatesTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new TemplatesTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new TemplatesTraverseAllAdjacentsVisitor(
				ensureSpecific(visitor1));
	}
}
