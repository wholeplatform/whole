package org.whole.lang.commons.visitors;

import org.whole.lang.commons.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class CommonsFailureVisitor extends CommonsIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(Resolver entity) {
		throw new VisitException();
	}

	public void visit(RootFragment entity) {
		throw new VisitException();
	}

	public void visit(SameStageFragment entity) {
		throw new VisitException();
	}

	public void visit(StageUpFragment entity) {
		throw new VisitException();
	}

	public void visit(StageDownFragment entity) {
		throw new VisitException();
	}

	public void visit(TemplateFragment entity) {
		throw new VisitException();
	}

	public void visit(BaseFragment entity) {
		throw new VisitException();
	}

	public void visit(Phase entity) {
		throw new VisitException();
	}

	public void visit(Multiplexer entity) {
		throw new VisitException();
	}

	public void visit(Variable entity) {
		throw new VisitException();
	}

	public void visit(InlineVariable entity) {
		throw new VisitException();
	}

	public void visit(VarName entity) {
		throw new VisitException();
	}

	public void visit(VarType entity) {
		throw new VisitException();
	}

	public void visit(Quantifier entity) {
		throw new VisitException();
	}
}
