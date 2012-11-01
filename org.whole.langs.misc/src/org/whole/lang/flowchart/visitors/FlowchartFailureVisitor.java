package org.whole.lang.flowchart.visitors;

import org.whole.lang.flowchart.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class FlowchartFailureVisitor extends FlowchartIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(Flowchart entity) {
		throw new VisitException();
	}

	public void visit(Nodes entity) {
		throw new VisitException();
	}

	public void visit(Transitions entity) {
		throw new VisitException();
	}

	public void visit(SimpleTransition entity) {
		throw new VisitException();
	}

	public void visit(LabeledTransition entity) {
		throw new VisitException();
	}

	public void visit(Pixels entity) {
		throw new VisitException();
	}

	public void visit(Text entity) {
		throw new VisitException();
	}

	public void visit(Entry entity) {
		throw new VisitException();
	}

	public void visit(Exit entity) {
		throw new VisitException();
	}

	public void visit(Block entity) {
		throw new VisitException();
	}

	public void visit(Choice entity) {
		throw new VisitException();
	}

	public void visit(Join entity) {
		throw new VisitException();
	}
}
