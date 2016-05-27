package org.whole.lang.commons.visitors;

import org.whole.lang.commons.visitors.CommonsIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.commons.model.*;

/** 
 * @generator Whole
 */
public class CommonsTraverseAllSwitchVisitor extends CommonsIdentityUnaryVisitor<IVisitor> {
	public CommonsTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Fragment entity) {
		wGetVisitor1().visit(entity.getRootEntity());
	}

	public void visit(RootFragment entity) {
		wGetVisitor1().visit(entity.getRootEntity());
	}

	public void visit(SameStageFragment entity) {
		wGetVisitor1().visit(entity.getRootEntity());
	}

	public void visit(StageUpFragment entity) {
		wGetVisitor1().visit(entity.getRootEntity());
	}

	public void visit(StageDownFragment entity) {
		wGetVisitor1().visit(entity.getRootEntity());
	}

	public void visit(TemplateFragment entity) {
		wGetVisitor1().visit(entity.getPhase());
		wGetVisitor1().visit(entity.getRootEntity());
	}

	public void visit(BaseFragment entity) {
		wGetVisitor1().visit(entity.getPhase());
		wGetVisitor1().visit(entity.getRootEntity());
	}

	public void visit(Multiplexer entity) {
		for (Any child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(Variable entity) {
		wGetVisitor1().visit(entity.getVarType());
		wGetVisitor1().visit(entity.getVarName());
		wGetVisitor1().visit(entity.getQuantifier());
	}

	public void visit(InlineVariable entity) {
		wGetVisitor1().visit(entity.getVarType());
		wGetVisitor1().visit(entity.getVarName());
		wGetVisitor1().visit(entity.getQuantifier());
	}
}
