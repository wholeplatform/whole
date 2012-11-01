package org.whole.lang.templates.visitors;

import org.whole.lang.templates.visitors.TemplatesIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.templates.model.*;

/** 
 * @generator Whole
 */
public class TemplatesTraverseAllSwitchVisitor extends
		TemplatesIdentityUnaryVisitor<IVisitor> {
	public TemplatesTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(TemplateManager entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getTemplates());
	}

	public void visit(Templates entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(TemplateFactory entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getForNames());
		wGetVisitor1().visit(entity.getTemplate());
	}

	public void visit(Names entity) {
		for (Name child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(QualifiedName entity) {
		wGetVisitor1().visit(entity.getQualifier());
		wGetVisitor1().visit(entity.getName());
	}
}
