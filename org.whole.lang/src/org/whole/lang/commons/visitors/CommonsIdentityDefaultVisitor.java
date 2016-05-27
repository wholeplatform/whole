package org.whole.lang.commons.visitors;

import org.whole.lang.commons.model.*;

/** 
 * @generator Whole
 */
public class CommonsIdentityDefaultVisitor extends CommonsIdentityVisitor {
	public void visit(ICommonsEntity entity) {
	}

	public void visit(Any entity) {
	}

	public void visit(Resolver entity) {
		visit((ICommonsEntity) entity);
		visit((Any) entity);
	}

	public void visit(Fragment entity) {
		visit((Any) entity);
	}

	public void visit(RootFragment entity) {
		visit((ICommonsEntity) entity);
		visit((Fragment) entity);
	}

	public void visit(SameStageFragment entity) {
		visit((ICommonsEntity) entity);
		visit((Fragment) entity);
	}

	public void visit(StageUpFragment entity) {
		visit((ICommonsEntity) entity);
		visit((Fragment) entity);
	}

	public void visit(StageDownFragment entity) {
		visit((ICommonsEntity) entity);
		visit((Fragment) entity);
	}

	public void visit(TemplateFragment entity) {
		visit((ICommonsEntity) entity);
		visit((Fragment) entity);
	}

	public void visit(BaseFragment entity) {
		visit((ICommonsEntity) entity);
		visit((Fragment) entity);
	}

	public void visit(Phase entity) {
		visit((ICommonsEntity) entity);
		visit((Any) entity);
	}

	public void visit(Multiplexer entity) {
		visit((ICommonsEntity) entity);
	}

	public void visit(Variable entity) {
		visit((ICommonsEntity) entity);
		visit((Any) entity);
	}

	public void visit(InlineVariable entity) {
		visit((ICommonsEntity) entity);
		visit((Variable) entity);
	}

	public void visit(VarName entity) {
		visit((ICommonsEntity) entity);
		visit((Any) entity);
	}

	public void visit(VarType entity) {
		visit((ICommonsEntity) entity);
		visit((Any) entity);
	}

	public void visit(Quantifier entity) {
		visit((ICommonsEntity) entity);
		visit((Any) entity);
	}
}
