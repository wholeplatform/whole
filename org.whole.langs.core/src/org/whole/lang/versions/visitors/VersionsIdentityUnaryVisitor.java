package org.whole.lang.versions.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.versions.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class VersionsIdentityUnaryVisitor<V extends IVisitor> extends
		AbstractUnaryVisitor<V> implements IVersionsVisitor {
	public VersionsIdentityUnaryVisitor() {
		super(null);
	}

	public VersionsIdentityUnaryVisitor(IVisitor visitor1) {
		super(visitor1);
	}

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
