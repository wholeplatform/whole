package org.whole.lang.versions.visitors;

import org.whole.lang.visitors.AbstractBinaryVisitor;
import org.whole.lang.versions.visitors.IVersionsVisitor;
import org.whole.lang.versions.model.*;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class VersionsSequenceVisitor extends
		AbstractBinaryVisitor<IVersionsVisitor> implements IVersionsVisitor {
	public VersionsSequenceVisitor(IVisitor visitor1, IVisitor visitor2) {
		super(visitor1, visitor2);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(History entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Version entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Versions entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(VersionsRefs entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(VersionLabel entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}
}
