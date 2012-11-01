package org.whole.lang.misc.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.misc.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class MiscIdentityUnaryVisitor<V extends IVisitor> extends
		AbstractUnaryVisitor<V> implements IMiscVisitor {
	public MiscIdentityUnaryVisitor() {
		super(null);
	}

	public MiscIdentityUnaryVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		((IMiscEntity) entity).accept(this);
	}

	public void visit(Misc entity) {
	}
}
