package org.whole.lang.versions.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.versions.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class VersionsIdentityVisitor extends AbstractVisitor implements
		IVersionsVisitor {
	public void visit(IEntity entity) {
		((IVersionsEntity) entity).accept(this);
	}

	public void visit(History entity) {
	}

	public void visit(Version entity) {
	}

	public void visit(Versions entity) {
	}

	public void visit(VersionsRefs entity) {
	}

	public void visit(VersionLabel entity) {
	}
}
