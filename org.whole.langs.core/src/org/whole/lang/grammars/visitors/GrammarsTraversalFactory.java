package org.whole.lang.grammars.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class GrammarsTraversalFactory extends GenericTraversalFactory {
	public static final GrammarsTraversalFactory instance = new GrammarsTraversalFactory();

	private GrammarsTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IGrammarsVisitor)
			return visitor;
		else
			return new GrammarsForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new GrammarsFailureVisitor();
	}

	public IVisitor identity() {
		return new GrammarsIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new GrammarsForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new GrammarsSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new GrammarsTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new GrammarsTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new GrammarsTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
