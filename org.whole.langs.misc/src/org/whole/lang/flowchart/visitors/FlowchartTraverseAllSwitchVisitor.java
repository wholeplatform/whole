package org.whole.lang.flowchart.visitors;

import org.whole.lang.flowchart.visitors.FlowchartIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.flowchart.model.*;

/** 
 * @generator Whole
 */
public class FlowchartTraverseAllSwitchVisitor extends
		FlowchartIdentityUnaryVisitor<IVisitor> {
	public FlowchartTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Flowchart entity) {
		wGetVisitor1().visit(entity.getNodes());
		wGetVisitor1().visit(entity.getTransitions());
	}

	public void visit(Nodes entity) {
		for (Node child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(Transitions entity) {
		for (Transition child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(Transition entity) {
		wGetVisitor1().visit(entity.getSource());
		wGetVisitor1().visit(entity.getTarget());
	}

	public void visit(SimpleTransition entity) {
		wGetVisitor1().visit(entity.getSource());
		wGetVisitor1().visit(entity.getTarget());
	}

	public void visit(LabeledTransition entity) {
		wGetVisitor1().visit(entity.getLabel());
		wGetVisitor1().visit(entity.getSource());
		wGetVisitor1().visit(entity.getTarget());
	}

	public void visit(Node entity) {
		wGetVisitor1().visit(entity.getX());
		wGetVisitor1().visit(entity.getY());
		wGetVisitor1().visit(entity.getWidth());
		wGetVisitor1().visit(entity.getHeight());
		wGetVisitor1().visit(entity.getDescription());
	}

	public void visit(Entry entity) {
		wGetVisitor1().visit(entity.getX());
		wGetVisitor1().visit(entity.getY());
		wGetVisitor1().visit(entity.getWidth());
		wGetVisitor1().visit(entity.getHeight());
		wGetVisitor1().visit(entity.getDescription());
		wGetVisitor1().visit(entity.getSourceTransition());
	}

	public void visit(Exit entity) {
		wGetVisitor1().visit(entity.getX());
		wGetVisitor1().visit(entity.getY());
		wGetVisitor1().visit(entity.getWidth());
		wGetVisitor1().visit(entity.getHeight());
		wGetVisitor1().visit(entity.getDescription());
		wGetVisitor1().visit(entity.getTargetTransition());
	}

	public void visit(Block entity) {
		wGetVisitor1().visit(entity.getX());
		wGetVisitor1().visit(entity.getY());
		wGetVisitor1().visit(entity.getWidth());
		wGetVisitor1().visit(entity.getHeight());
		wGetVisitor1().visit(entity.getDescription());
		wGetVisitor1().visit(entity.getTargetTransition());
		wGetVisitor1().visit(entity.getSourceTransition());
	}

	public void visit(Choice entity) {
		wGetVisitor1().visit(entity.getX());
		wGetVisitor1().visit(entity.getY());
		wGetVisitor1().visit(entity.getWidth());
		wGetVisitor1().visit(entity.getHeight());
		wGetVisitor1().visit(entity.getDescription());
		wGetVisitor1().visit(entity.getTargetTransition());
		wGetVisitor1().visit(entity.getTrueSourceTransition());
		wGetVisitor1().visit(entity.getFalseSourceTransition());
	}

	public void visit(Join entity) {
		wGetVisitor1().visit(entity.getX());
		wGetVisitor1().visit(entity.getY());
		wGetVisitor1().visit(entity.getWidth());
		wGetVisitor1().visit(entity.getHeight());
		wGetVisitor1().visit(entity.getDescription());
		wGetVisitor1().visit(entity.getTargetTransitions());
		wGetVisitor1().visit(entity.getSourceTransition());
	}
}
