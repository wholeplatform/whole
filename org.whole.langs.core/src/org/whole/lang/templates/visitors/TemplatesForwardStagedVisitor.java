package org.whole.lang.templates.visitors;

import org.whole.lang.templates.model.*;

/** 
 * @generator Whole
 */
public class TemplatesForwardStagedVisitor extends TemplatesIdentityVisitor {
	public void visit(TemplateManager entity) {
		stagedVisit(entity);
	}

	public void visit(Templates entity) {
		stagedVisit(entity);
	}

	public void visit(TemplateFactory entity) {
		stagedVisit(entity);
	}

	public void visit(Names entity) {
		stagedVisit(entity);
	}

	public void visit(QualifiedName entity) {
		stagedVisit(entity);
	}

	public void visit(SimpleName entity) {
		stagedVisit(entity);
	}
}
