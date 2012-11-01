package org.whole.lang.javascript.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class JavaScriptTraversalFactory extends GenericTraversalFactory {
	public static final JavaScriptTraversalFactory instance = new JavaScriptTraversalFactory();

	private JavaScriptTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IJavaScriptVisitor)
			return visitor;
		else
			return new JavaScriptForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new JavaScriptFailureVisitor();
	}

	public IVisitor identity() {
		return new JavaScriptIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new JavaScriptForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new JavaScriptSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new JavaScriptTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new JavaScriptTraverseAllChildrenVisitor(
				ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new JavaScriptTraverseAllAdjacentsVisitor(
				ensureSpecific(visitor1));
	}
}
