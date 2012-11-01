package org.whole.lang.flowchart.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.flowchart.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class FlowchartIdentityUnaryVisitor<V extends IVisitor> extends
		AbstractUnaryVisitor<V> implements IFlowchartVisitor {
	public FlowchartIdentityUnaryVisitor() {
		super(null);
	}

	public FlowchartIdentityUnaryVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		((IFlowchartEntity) entity).accept(this);
	}

	public void visit(Flowchart entity) {
	}

	public void visit(Nodes entity) {
	}

	public void visit(Transitions entity) {
	}

	public void visit(SimpleTransition entity) {
	}

	public void visit(LabeledTransition entity) {
	}

	public void visit(Pixels entity) {
	}

	public void visit(Text entity) {
	}

	public void visit(Entry entity) {
	}

	public void visit(Exit entity) {
	}

	public void visit(Block entity) {
	}

	public void visit(Choice entity) {
	}

	public void visit(Join entity) {
	}
}
