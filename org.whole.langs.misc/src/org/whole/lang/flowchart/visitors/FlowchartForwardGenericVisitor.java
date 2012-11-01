package org.whole.lang.flowchart.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.flowchart.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class FlowchartForwardGenericVisitor extends
		AbstractUnaryVisitor<IVisitor> implements IFlowchartVisitor {
	public FlowchartForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Flowchart entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Nodes entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Transitions entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SimpleTransition entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LabeledTransition entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Pixels entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Text entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Entry entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Exit entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Block entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Choice entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Join entity) {
		wGetVisitor1().visit(entity);
	}
}
