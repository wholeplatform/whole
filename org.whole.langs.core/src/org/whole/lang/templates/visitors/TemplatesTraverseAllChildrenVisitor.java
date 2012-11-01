package org.whole.lang.templates.visitors;

import org.whole.lang.templates.visitors.TemplatesIdentityUnaryVisitor;
import org.whole.lang.templates.visitors.ITemplatesVisitor;
import org.whole.lang.templates.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class TemplatesTraverseAllChildrenVisitor extends
		TemplatesIdentityUnaryVisitor<ITemplatesVisitor> {
	public TemplatesTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public TemplatesTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(TemplateManager entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getTemplates().accept(wGetVisitor1());
	}

	public void visit(Templates entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(TemplateFactory entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getForNames().accept(wGetVisitor1());
		entity.getTemplate().accept(wGetVisitor1());
	}

	public void visit(Names entity) {
		for (Name child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(QualifiedName entity) {
		entity.getQualifier().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
	}
}
