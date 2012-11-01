package org.whole.lang.versions.visitors;

import org.whole.lang.versions.visitors.VersionsIdentityUnaryVisitor;
import org.whole.lang.versions.visitors.IVersionsVisitor;
import org.whole.lang.versions.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class VersionsTraverseAllAdjacentsVisitor extends
		VersionsIdentityUnaryVisitor<IVersionsVisitor> {
	public VersionsTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public VersionsTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(History entity) {
		entity.getRootVersion().accept(wGetVisitor1());
	}

	public void visit(Version entity) {
		entity.getHistory().accept(wGetVisitor1());
		entity.getPredecessors().accept(wGetVisitor1());
		entity.getSuccessors().accept(wGetVisitor1());
		entity.getVersionable().accept(wGetVisitor1());
	}

	public void visit(Versionable entity) {
		entity.getBaseVersion().accept(wGetVisitor1());
		entity.getPredecessors().accept(wGetVisitor1());
	}

	public void visit(VersionsRefs entity) {
		for (Version child : entity)
			child.accept(wGetVisitor1());
	}
}
