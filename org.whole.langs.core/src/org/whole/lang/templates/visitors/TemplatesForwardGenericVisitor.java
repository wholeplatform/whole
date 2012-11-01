package org.whole.lang.templates.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.templates.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TemplatesForwardGenericVisitor extends
		AbstractUnaryVisitor<IVisitor> implements ITemplatesVisitor {
	public TemplatesForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TemplateManager entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Templates entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TemplateFactory entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Names entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(QualifiedName entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SimpleName entity) {
		wGetVisitor1().visit(entity);
	}
}
