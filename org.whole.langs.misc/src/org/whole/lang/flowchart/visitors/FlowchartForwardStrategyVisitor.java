package org.whole.lang.flowchart.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.flowchart.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class FlowchartForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IFlowchartVisitor> implements
		IFlowchartVisitor {
	public FlowchartForwardStrategyVisitor() {
		this(new FlowchartIdentityVisitor());
	}

	public FlowchartForwardStrategyVisitor(
			IFlowchartVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IFlowchartEntity) entity).accept(this);
	}

	public void visit(Flowchart entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Nodes entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Transitions entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SimpleTransition entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LabeledTransition entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Pixels entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Text entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Entry entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Exit entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Block entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Choice entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Join entity) {
		wGetStrategy().visit(entity);
	}
}
