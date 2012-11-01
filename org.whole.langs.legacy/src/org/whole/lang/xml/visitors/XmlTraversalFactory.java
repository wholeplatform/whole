package org.whole.lang.xml.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class XmlTraversalFactory extends GenericTraversalFactory {
	public static final XmlTraversalFactory instance = new XmlTraversalFactory();

	private XmlTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IXmlVisitor)
			return visitor;
		else
			return new XmlForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new XmlFailureVisitor();
	}

	public IVisitor identity() {
		return new XmlIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new XmlForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new XmlSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new XmlTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new XmlTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new XmlTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
	}
}
