package org.whole.lang.versions.visitors;

import org.whole.lang.versions.visitors.VersionsIdentityUnaryVisitor;
import org.whole.lang.versions.visitors.IVersionsVisitor;
import org.whole.lang.versions.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class VersionsTraverseAllVisitor extends
		VersionsIdentityUnaryVisitor<IVersionsVisitor> {
	public VersionsTraverseAllVisitor() {
		wSetVisitor1(this);
	}

	public VersionsTraverseAllVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(History entity) {
		entity.getVersions().accept(wGetVisitor1());
		entity.getRootVersion().accept(wGetVisitor1());
	}

	public void visit(Version entity) {
		entity.getVersionLabel().accept(wGetVisitor1());
		entity.getHistory().accept(wGetVisitor1());
		entity.getPredecessors().accept(wGetVisitor1());
		entity.getSuccessors().accept(wGetVisitor1());
		entity.getVersionable().accept(wGetVisitor1());
	}

	public void visit(Versionable entity) {
		entity.getBaseVersion().accept(wGetVisitor1());
		entity.getPredecessors().accept(wGetVisitor1());
	}

	public void visit(Versions entity) {
		for (Version child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(VersionsRefs entity) {
		for (Version child : entity)
			child.accept(wGetVisitor1());
	}
}
