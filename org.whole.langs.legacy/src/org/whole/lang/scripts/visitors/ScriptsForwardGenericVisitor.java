package org.whole.lang.scripts.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.scripts.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ScriptsForwardGenericVisitor extends
		AbstractUnaryVisitor<IVisitor> implements IScriptsVisitor {
	public ScriptsForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Script entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LanguageName entity) {
		wGetVisitor1().visit(entity);
	}
}
