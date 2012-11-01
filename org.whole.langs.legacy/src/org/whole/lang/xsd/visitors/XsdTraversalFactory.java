package org.whole.lang.xsd.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class XsdTraversalFactory extends GenericTraversalFactory {
	public static final XsdTraversalFactory instance = new XsdTraversalFactory();

	private XsdTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IXsdVisitor)
			return visitor;
		else
			return new XsdForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new XsdFailureVisitor();
	}

	public IVisitor identity() {
		return new XsdIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new XsdForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new XsdSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new XsdTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new XsdTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new XsdTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
