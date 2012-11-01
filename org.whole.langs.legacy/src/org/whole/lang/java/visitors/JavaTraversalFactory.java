package org.whole.lang.java.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class JavaTraversalFactory extends GenericTraversalFactory {
	public static final JavaTraversalFactory instance = new JavaTraversalFactory();

	private JavaTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IJavaVisitor)
			return visitor;
		else
			return new JavaForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new JavaFailureVisitor();
	}

	public IVisitor identity() {
		return new JavaIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new JavaForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new JavaSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new JavaTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new JavaTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new JavaTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
