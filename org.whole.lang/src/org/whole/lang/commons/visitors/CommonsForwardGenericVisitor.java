package org.whole.lang.commons.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.commons.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class CommonsForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor> implements ICommonsVisitor {
	public CommonsForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Resolver entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(RootFragment entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SameStageFragment entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(StageUpFragment entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(StageDownFragment entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TemplateFragment entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BaseFragment entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Phase entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Multiplexer entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Variable entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(InlineVariable entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(VarName entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(VarType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Quantifier entity) {
		wGetVisitor1().visit(entity);
	}
}
