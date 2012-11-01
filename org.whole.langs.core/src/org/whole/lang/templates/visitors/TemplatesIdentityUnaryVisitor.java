package org.whole.lang.templates.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.templates.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TemplatesIdentityUnaryVisitor<V extends IVisitor> extends
		AbstractUnaryVisitor<V> implements ITemplatesVisitor {
	public TemplatesIdentityUnaryVisitor() {
		super(null);
	}

	public TemplatesIdentityUnaryVisitor(IVisitor visitor1) {
		super(visitor1);
	}

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
