package org.whole.lang.properties.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class PropertiesTraversalFactory extends GenericTraversalFactory {
	public static final PropertiesTraversalFactory instance = new PropertiesTraversalFactory();

	private PropertiesTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IPropertiesVisitor)
			return visitor;
		else
			return new PropertiesForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new PropertiesFailureVisitor();
	}

	public IVisitor identity() {
		return new PropertiesIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new PropertiesForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new PropertiesSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new PropertiesTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new PropertiesTraverseAllChildrenVisitor(
				ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new PropertiesTraverseAllAdjacentsVisitor(
				ensureSpecific(visitor1));
	}
}
