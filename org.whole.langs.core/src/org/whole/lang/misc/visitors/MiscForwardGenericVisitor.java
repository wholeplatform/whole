package org.whole.lang.misc.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.misc.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class MiscForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor>
		implements IMiscVisitor {
	public MiscForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Misc entity) {
		wGetVisitor1().visit(entity);
	}
}
