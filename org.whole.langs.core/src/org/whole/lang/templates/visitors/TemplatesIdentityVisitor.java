package org.whole.lang.templates.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.templates.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TemplatesIdentityVisitor extends AbstractVisitor implements
		ITemplatesVisitor {
	public void visit(IEntity entity) {
		((ITemplatesEntity) entity).accept(this);
	}

	public void visit(TemplateManager entity) {
	}

	public void visit(Templates entity) {
	}

	public void visit(TemplateFactory entity) {
	}

	public void visit(Names entity) {
	}

	public void visit(QualifiedName entity) {
	}

	public void visit(SimpleName entity) {
	}
}
