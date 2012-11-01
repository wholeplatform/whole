package org.whole.lang.versions.visitors;

import org.whole.lang.versions.visitors.VersionsIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.versions.model.*;

/** 
 * @generator Whole
 */
public class VersionsTraverseAllSwitchVisitor extends
		VersionsIdentityUnaryVisitor<IVisitor> {
	public VersionsTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(History entity) {
		wGetVisitor1().visit(entity.getVersions());
		wGetVisitor1().visit(entity.getRootVersion());
	}

	public void visit(Version entity) {
		wGetVisitor1().visit(entity.getVersionLabel());
		wGetVisitor1().visit(entity.getHistory());
		wGetVisitor1().visit(entity.getPredecessors());
		wGetVisitor1().visit(entity.getSuccessors());
		wGetVisitor1().visit(entity.getVersionable());
	}

	public void visit(Versionable entity) {
		wGetVisitor1().visit(entity.getBaseVersion());
		wGetVisitor1().visit(entity.getPredecessors());
	}

	public void visit(Versions entity) {
		for (Version child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(VersionsRefs entity) {
		for (Version child : entity)
			wGetVisitor1().visit(child);
	}
}
