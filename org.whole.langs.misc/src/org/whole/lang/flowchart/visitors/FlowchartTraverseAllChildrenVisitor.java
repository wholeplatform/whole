package org.whole.lang.flowchart.visitors;

import org.whole.lang.flowchart.visitors.FlowchartIdentityUnaryVisitor;
import org.whole.lang.flowchart.visitors.IFlowchartVisitor;
import org.whole.lang.flowchart.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class FlowchartTraverseAllChildrenVisitor extends
		FlowchartIdentityUnaryVisitor<IFlowchartVisitor> {
	public FlowchartTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public FlowchartTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Flowchart entity) {
		entity.getNodes().accept(wGetVisitor1());
		entity.getTransitions().accept(wGetVisitor1());
	}

	public void visit(Nodes entity) {
		for (Node child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(Transitions entity) {
		for (Transition child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(LabeledTransition entity) {
		entity.getLabel().accept(wGetVisitor1());
	}

	public void visit(Node entity) {
		entity.getX().accept(wGetVisitor1());
		entity.getY().accept(wGetVisitor1());
		entity.getWidth().accept(wGetVisitor1());
		entity.getHeight().accept(wGetVisitor1());
		entity.getDescription().accept(wGetVisitor1());
	}

	public void visit(Entry entity) {
		entity.getX().accept(wGetVisitor1());
		entity.getY().accept(wGetVisitor1());
		entity.getWidth().accept(wGetVisitor1());
		entity.getHeight().accept(wGetVisitor1());
		entity.getDescription().accept(wGetVisitor1());
	}

	public void visit(Exit entity) {
		entity.getX().accept(wGetVisitor1());
		entity.getY().accept(wGetVisitor1());
		entity.getWidth().accept(wGetVisitor1());
		entity.getHeight().accept(wGetVisitor1());
		entity.getDescription().accept(wGetVisitor1());
	}

	public void visit(Block entity) {
		entity.getX().accept(wGetVisitor1());
		entity.getY().accept(wGetVisitor1());
		entity.getWidth().accept(wGetVisitor1());
		entity.getHeight().accept(wGetVisitor1());
		entity.getDescription().accept(wGetVisitor1());
	}

	public void visit(Choice entity) {
		entity.getX().accept(wGetVisitor1());
		entity.getY().accept(wGetVisitor1());
		entity.getWidth().accept(wGetVisitor1());
		entity.getHeight().accept(wGetVisitor1());
		entity.getDescription().accept(wGetVisitor1());
	}

	public void visit(Join entity) {
		entity.getX().accept(wGetVisitor1());
		entity.getY().accept(wGetVisitor1());
		entity.getWidth().accept(wGetVisitor1());
		entity.getHeight().accept(wGetVisitor1());
		entity.getDescription().accept(wGetVisitor1());
	}
}
