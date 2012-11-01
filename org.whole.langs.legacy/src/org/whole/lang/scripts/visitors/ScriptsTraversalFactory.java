package org.whole.lang.scripts.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class ScriptsTraversalFactory extends GenericTraversalFactory {
	public static final ScriptsTraversalFactory instance = new ScriptsTraversalFactory();

	private ScriptsTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IScriptsVisitor)
			return visitor;
		else
			return new ScriptsForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new ScriptsFailureVisitor();
	}

	public IVisitor identity() {
		return new ScriptsIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new ScriptsForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new ScriptsSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new ScriptsTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new ScriptsTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new ScriptsTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
