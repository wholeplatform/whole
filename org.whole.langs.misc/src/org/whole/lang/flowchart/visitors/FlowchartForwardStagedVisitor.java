package org.whole.lang.flowchart.visitors;

import org.whole.lang.flowchart.model.*;

/** 
 * @generator Whole
 */
public class FlowchartForwardStagedVisitor extends FlowchartIdentityVisitor {
	public void visit(Flowchart entity) {
		stagedVisit(entity);
	}

	public void visit(Nodes entity) {
		stagedVisit(entity);
	}

	public void visit(Transitions entity) {
		stagedVisit(entity);
	}

	public void visit(SimpleTransition entity) {
		stagedVisit(entity);
	}

	public void visit(LabeledTransition entity) {
		stagedVisit(entity);
	}

	public void visit(Pixels entity) {
		stagedVisit(entity);
	}

	public void visit(Text entity) {
		stagedVisit(entity);
	}

	public void visit(Entry entity) {
		stagedVisit(entity);
	}

	public void visit(Exit entity) {
		stagedVisit(entity);
	}

	public void visit(Block entity) {
		stagedVisit(entity);
	}

	public void visit(Choice entity) {
		stagedVisit(entity);
	}

	public void visit(Join entity) {
		stagedVisit(entity);
	}
}
