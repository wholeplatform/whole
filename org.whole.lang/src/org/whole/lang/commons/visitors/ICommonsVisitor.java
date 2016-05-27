package org.whole.lang.commons.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.commons.model.*;

/** 
 * @generator Whole
 */
public interface ICommonsVisitor extends IVisitor {
	public void visit(Resolver entity);

	public void visit(RootFragment entity);

	public void visit(SameStageFragment entity);

	public void visit(StageUpFragment entity);

	public void visit(StageDownFragment entity);

	public void visit(TemplateFragment entity);

	public void visit(BaseFragment entity);

	public void visit(Phase entity);

	public void visit(Multiplexer entity);

	public void visit(Variable entity);

	public void visit(InlineVariable entity);

	public void visit(VarName entity);

	public void visit(VarType entity);

	public void visit(Quantifier entity);
}
