package org.whole.lang.flowchart.visitors;

import org.whole.lang.flowchart.visitors.FlowchartIdentityUnaryVisitor;
import org.whole.lang.flowchart.visitors.IFlowchartVisitor;
import org.whole.lang.flowchart.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class FlowchartTraverseAllAdjacentsVisitor extends
		FlowchartIdentityUnaryVisitor<IFlowchartVisitor> {
	public FlowchartTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public FlowchartTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Transition entity) {
		entity.getSource().accept(wGetVisitor1());
		entity.getTarget().accept(wGetVisitor1());
	}

	public void visit(SimpleTransition entity) {
		entity.getSource().accept(wGetVisitor1());
		entity.getTarget().accept(wGetVisitor1());
	}

	public void visit(LabeledTransition entity) {
		entity.getSource().accept(wGetVisitor1());
		entity.getTarget().accept(wGetVisitor1());
	}

	public void visit(Entry entity) {
		entity.getSourceTransition().accept(wGetVisitor1());
	}

	public void visit(Exit entity) {
		entity.getTargetTransition().accept(wGetVisitor1());
	}

	public void visit(Block entity) {
		entity.getTargetTransition().accept(wGetVisitor1());
		entity.getSourceTransition().accept(wGetVisitor1());
	}

	public void visit(Choice entity) {
		entity.getTargetTransition().accept(wGetVisitor1());
		entity.getTrueSourceTransition().accept(wGetVisitor1());
		entity.getFalseSourceTransition().accept(wGetVisitor1());
	}

	public void visit(Join entity) {
		entity.getTargetTransitions().accept(wGetVisitor1());
		entity.getSourceTransition().accept(wGetVisitor1());
	}
}
