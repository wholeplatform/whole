package org.whole.lang.templates.visitors;

import org.whole.lang.templates.model.*;

/** 
 * @generator Whole
 */
public class TemplatesIdentityDefaultVisitor extends TemplatesIdentityVisitor {
	public void visit(ITemplatesEntity entity) {
	}

	public void visit(TemplateManager entity) {
		visit((ITemplatesEntity) entity);
	}

	public void visit(Templates entity) {
		visit((ITemplatesEntity) entity);
	}

	public void visit(TemplateFactory entity) {
		visit((ITemplatesEntity) entity);
	}

	public void visit(Names entity) {
		visit((ITemplatesEntity) entity);
	}

	public void visit(Name entity) {
	}

	public void visit(QualifiedName entity) {
		visit((ITemplatesEntity) entity);
		visit((Name) entity);
	}

	public void visit(SimpleName entity) {
		visit((ITemplatesEntity) entity);
		visit((Name) entity);
	}
}
