package org.whole.lang.editors.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class EditorsTraversalFactory extends GenericTraversalFactory {
	public static final EditorsTraversalFactory instance = new EditorsTraversalFactory();

	private EditorsTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IEditorsVisitor)
			return visitor;
		else
			return new EditorsForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new EditorsFailureVisitor();
	}

	public IVisitor identity() {
		return new EditorsIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new EditorsForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new EditorsSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new EditorsTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new EditorsTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new EditorsTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
