package org.whole.lang.versions.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.versions.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class VersionsForwardGenericVisitor extends
		AbstractUnaryVisitor<IVisitor> implements IVersionsVisitor {
	public VersionsForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(History entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Version entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Versions entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(VersionsRefs entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(VersionLabel entity) {
		wGetVisitor1().visit(entity);
	}
}
