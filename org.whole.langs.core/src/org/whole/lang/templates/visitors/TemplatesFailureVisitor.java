package org.whole.lang.templates.visitors;

import org.whole.lang.templates.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class TemplatesFailureVisitor extends TemplatesIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(TemplateManager entity) {
		throw new VisitException();
	}

	public void visit(Templates entity) {
		throw new VisitException();
	}

	public void visit(TemplateFactory entity) {
		throw new VisitException();
	}

	public void visit(Names entity) {
		throw new VisitException();
	}

	public void visit(QualifiedName entity) {
		throw new VisitException();
	}

	public void visit(SimpleName entity) {
		throw new VisitException();
	}
}
