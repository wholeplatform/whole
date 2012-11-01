package org.whole.lang.templates.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.templates.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TemplatesForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<ITemplatesVisitor> implements
		ITemplatesVisitor {
	public TemplatesForwardStrategyVisitor() {
		this(new TemplatesIdentityVisitor());
	}

	public TemplatesForwardStrategyVisitor(
			ITemplatesVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((ITemplatesEntity) entity).accept(this);
	}

	public void visit(TemplateManager entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Templates entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(TemplateFactory entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Names entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(QualifiedName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SimpleName entity) {
		wGetStrategy().visit(entity);
	}
}
