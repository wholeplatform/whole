package org.whole.lang.commons.visitors;

import org.whole.lang.commons.model.*;

/** 
 * @generator Whole
 */
public class CommonsForwardStagedVisitor extends CommonsIdentityVisitor {
	public void visit(Resolver entity) {
		stagedVisit(entity);
	}

	public void visit(RootFragment entity) {
		stagedVisit(entity);
	}

	public void visit(SameStageFragment entity) {
		stagedVisit(entity);
	}

	public void visit(StageUpFragment entity) {
		stagedVisit(entity);
	}

	public void visit(StageDownFragment entity) {
		stagedVisit(entity);
	}

	public void visit(TemplateFragment entity) {
		stagedVisit(entity);
	}

	public void visit(BaseFragment entity) {
		stagedVisit(entity);
	}

	public void visit(Phase entity) {
		stagedVisit(entity);
	}

	public void visit(Multiplexer entity) {
		stagedVisit(entity);
	}

	public void visit(Variable entity) {
		stagedVisit(entity);
	}

	public void visit(InlineVariable entity) {
		stagedVisit(entity);
	}

	public void visit(VarName entity) {
		stagedVisit(entity);
	}

	public void visit(VarType entity) {
		stagedVisit(entity);
	}

	public void visit(Quantifier entity) {
		stagedVisit(entity);
	}
}
