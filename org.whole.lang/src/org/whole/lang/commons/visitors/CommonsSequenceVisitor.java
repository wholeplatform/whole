package org.whole.lang.commons.visitors;

import org.whole.lang.visitors.AbstractBinaryVisitor;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.commons.model.*;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class CommonsSequenceVisitor extends AbstractBinaryVisitor<ICommonsVisitor> implements ICommonsVisitor {
	public CommonsSequenceVisitor(IVisitor visitor1, IVisitor visitor2) {
		super(visitor1, visitor2);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Resolver entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(RootFragment entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(SameStageFragment entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(StageUpFragment entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(StageDownFragment entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(TemplateFragment entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(BaseFragment entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Phase entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Multiplexer entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Variable entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(InlineVariable entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(VarName entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(VarType entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Quantifier entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}
}
