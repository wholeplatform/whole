package org.whole.lang.scripts.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.scripts.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ScriptsIdentityVisitor extends AbstractVisitor implements
		IScriptsVisitor {
	public void visit(IEntity entity) {
		((IScriptsEntity) entity).accept(this);
	}

	public void visit(Script entity) {
	}

	public void visit(LanguageName entity) {
	}
}
