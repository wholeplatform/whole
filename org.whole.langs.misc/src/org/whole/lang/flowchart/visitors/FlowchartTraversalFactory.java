package org.whole.lang.flowchart.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/** 
 * @generator Whole
 */
public class FlowchartTraversalFactory extends GenericTraversalFactory {
	public static final FlowchartTraversalFactory instance = new FlowchartTraversalFactory();

	private FlowchartTraversalFactory() {
	}

	protected IVisitor ensureSpecific(IVisitor visitor) {
		if (visitor instanceof IFlowchartVisitor)
			return visitor;
		else
			return new FlowchartForwardGenericVisitor(visitor);
	}

	public IVisitor failure() {
		return new FlowchartFailureVisitor();
	}

	public IVisitor identity() {
		return new FlowchartIdentityVisitor();
	}

	public IVisitor forwardStaged() {
		return new FlowchartForwardStagedVisitor();
	}

	public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
		return new FlowchartSequenceVisitor(ensureSpecific(visitor1),
				ensureSpecific(visitor2));
	}

	public IUnaryVisitor traverseAll(IVisitor visitor1) {
		return new FlowchartTraverseAllVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
		return new FlowchartTraverseAllChildrenVisitor(ensureSpecific(visitor1));
	}

	public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
		return new FlowchartTraverseAllAdjacentsVisitor(
				ensureSpecific(visitor1));
	}
}
