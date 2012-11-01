package org.whole.lang.versions.visitors;

import org.whole.lang.versions.model.*;

/** 
 * @generator Whole
 */
public class VersionsForwardStagedVisitor extends VersionsIdentityVisitor {
	public void visit(History entity) {
		stagedVisit(entity);
	}

	public void visit(Version entity) {
		stagedVisit(entity);
	}

	public void visit(Versions entity) {
		stagedVisit(entity);
	}

	public void visit(VersionsRefs entity) {
		stagedVisit(entity);
	}

	public void visit(VersionLabel entity) {
		stagedVisit(entity);
	}
}
