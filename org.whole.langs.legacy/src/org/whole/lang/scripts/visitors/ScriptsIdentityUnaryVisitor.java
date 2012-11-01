package org.whole.lang.scripts.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.scripts.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ScriptsIdentityUnaryVisitor<V extends IVisitor> extends
		AbstractUnaryVisitor<V> implements IScriptsVisitor {
	public ScriptsIdentityUnaryVisitor() {
		super(null);
	}

	public ScriptsIdentityUnaryVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		((IScriptsEntity) entity).accept(this);
	}

	public void visit(Script entity) {
	}

	public void visit(LanguageName entity) {
	}
}
