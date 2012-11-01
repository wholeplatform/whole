package org.whole.lang.scripts.visitors;

import org.whole.lang.visitors.AbstractBinaryVisitor;
import org.whole.lang.scripts.visitors.IScriptsVisitor;
import org.whole.lang.scripts.model.*;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ScriptsSequenceVisitor extends
		AbstractBinaryVisitor<IScriptsVisitor> implements IScriptsVisitor {
	public ScriptsSequenceVisitor(IVisitor visitor1, IVisitor visitor2) {
		super(visitor1, visitor2);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Script entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(LanguageName entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}
}
