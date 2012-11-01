package org.whole.lang.versions.visitors;

import org.whole.lang.versions.model.*;

/** 
 * @generator Whole
 */
public class VersionsIdentityDefaultVisitor extends VersionsIdentityVisitor {
	public void visit(IVersionsEntity entity) {
	}

	public void visit(History entity) {
		visit((IVersionsEntity) entity);
	}

	public void visit(Version entity) {
		visit((IVersionsEntity) entity);
	}

	public void visit(Versions entity) {
		visit((IVersionsEntity) entity);
	}

	public void visit(VersionsRefs entity) {
		visit((IVersionsEntity) entity);
	}

	public void visit(VersionLabel entity) {
		visit((IVersionsEntity) entity);
	}
}
