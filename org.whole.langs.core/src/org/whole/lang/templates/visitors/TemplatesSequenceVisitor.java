package org.whole.lang.templates.visitors;

import org.whole.lang.visitors.AbstractBinaryVisitor;
import org.whole.lang.templates.visitors.ITemplatesVisitor;
import org.whole.lang.templates.model.*;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TemplatesSequenceVisitor extends
		AbstractBinaryVisitor<ITemplatesVisitor> implements ITemplatesVisitor {
	public TemplatesSequenceVisitor(IVisitor visitor1, IVisitor visitor2) {
		super(visitor1, visitor2);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(TemplateManager entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Templates entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(TemplateFactory entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Names entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(QualifiedName entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(SimpleName entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}
}
