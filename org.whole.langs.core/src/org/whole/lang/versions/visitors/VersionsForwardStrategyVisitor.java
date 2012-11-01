package org.whole.lang.versions.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.versions.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class VersionsForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IVersionsVisitor> implements
		IVersionsVisitor {
	public VersionsForwardStrategyVisitor() {
		this(new VersionsIdentityVisitor());
	}

	public VersionsForwardStrategyVisitor(IVersionsVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IVersionsEntity) entity).accept(this);
	}

	public void visit(History entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Version entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Versions entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(VersionsRefs entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(VersionLabel entity) {
		wGetStrategy().visit(entity);
	}
}
