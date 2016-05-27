package org.whole.lang.commons.visitors;

import org.whole.lang.commons.visitors.CommonsIdentityUnaryVisitor;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.commons.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class CommonsTraverseAllVisitor extends CommonsIdentityUnaryVisitor<ICommonsVisitor> {
	public CommonsTraverseAllVisitor() {
		wSetVisitor1(this);
	}

	public CommonsTraverseAllVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Fragment entity) {
		entity.getRootEntity().accept(wGetVisitor1());
	}

	public void visit(RootFragment entity) {
		entity.getRootEntity().accept(wGetVisitor1());
	}

	public void visit(SameStageFragment entity) {
		entity.getRootEntity().accept(wGetVisitor1());
	}

	public void visit(StageUpFragment entity) {
		entity.getRootEntity().accept(wGetVisitor1());
	}

	public void visit(StageDownFragment entity) {
		entity.getRootEntity().accept(wGetVisitor1());
	}

	public void visit(TemplateFragment entity) {
		entity.getPhase().accept(wGetVisitor1());
		entity.getRootEntity().accept(wGetVisitor1());
	}

	public void visit(BaseFragment entity) {
		entity.getPhase().accept(wGetVisitor1());
		entity.getRootEntity().accept(wGetVisitor1());
	}

	public void visit(Multiplexer entity) {
		for (Any child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(Variable entity) {
		entity.getVarType().accept(wGetVisitor1());
		entity.getVarName().accept(wGetVisitor1());
		entity.getQuantifier().accept(wGetVisitor1());
	}

	public void visit(InlineVariable entity) {
		entity.getVarType().accept(wGetVisitor1());
		entity.getVarName().accept(wGetVisitor1());
		entity.getQuantifier().accept(wGetVisitor1());
	}
}
