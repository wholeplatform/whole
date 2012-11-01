package org.whole.lang.flowchart.visitors;

import org.whole.lang.flowchart.model.*;

/** 
 * @generator Whole
 */
public class FlowchartIdentityDefaultVisitor extends FlowchartIdentityVisitor {
	public void visit(IFlowchartEntity entity) {
	}

	public void visit(Flowchart entity) {
		visit((IFlowchartEntity) entity);
	}

	public void visit(Nodes entity) {
		visit((IFlowchartEntity) entity);
	}

	public void visit(Transitions entity) {
		visit((IFlowchartEntity) entity);
	}

	public void visit(Transition entity) {
	}

	public void visit(SimpleTransition entity) {
		visit((IFlowchartEntity) entity);
		visit((Transition) entity);
	}

	public void visit(LabeledTransition entity) {
		visit((IFlowchartEntity) entity);
		visit((Transition) entity);
	}

	public void visit(Pixels entity) {
		visit((IFlowchartEntity) entity);
	}

	public void visit(Text entity) {
		visit((IFlowchartEntity) entity);
	}

	public void visit(Node entity) {
	}

	public void visit(Entry entity) {
		visit((IFlowchartEntity) entity);
		visit((Node) entity);
	}

	public void visit(Exit entity) {
		visit((IFlowchartEntity) entity);
		visit((Node) entity);
	}

	public void visit(Block entity) {
		visit((IFlowchartEntity) entity);
		visit((Node) entity);
	}

	public void visit(Choice entity) {
		visit((IFlowchartEntity) entity);
		visit((Node) entity);
	}

	public void visit(Join entity) {
		visit((IFlowchartEntity) entity);
		visit((Node) entity);
	}
}
