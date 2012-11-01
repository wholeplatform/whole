package org.whole.lang.versions.visitors;

import org.whole.lang.versions.visitors.VersionsIdentityUnaryVisitor;
import org.whole.lang.versions.visitors.IVersionsVisitor;
import org.whole.lang.versions.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class VersionsTraverseAllChildrenVisitor extends
		VersionsIdentityUnaryVisitor<IVersionsVisitor> {
	public VersionsTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public VersionsTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(History entity) {
		entity.getVersions().accept(wGetVisitor1());
	}

	public void visit(Version entity) {
		entity.getVersionLabel().accept(wGetVisitor1());
	}

	public void visit(Versions entity) {
		for (Version child : entity)
			child.accept(wGetVisitor1());
	}
}
