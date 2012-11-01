package org.whole.lang.scripts.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.scripts.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ScriptsForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IScriptsVisitor> implements
		IScriptsVisitor {
	public ScriptsForwardStrategyVisitor() {
		this(new ScriptsIdentityVisitor());
	}

	public ScriptsForwardStrategyVisitor(IScriptsVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IScriptsEntity) entity).accept(this);
	}

	public void visit(Script entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LanguageName entity) {
		wGetStrategy().visit(entity);
	}
}
