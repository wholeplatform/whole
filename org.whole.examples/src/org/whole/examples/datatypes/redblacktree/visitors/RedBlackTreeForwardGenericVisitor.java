package org.whole.examples.datatypes.redblacktree.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.examples.datatypes.redblacktree.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class RedBlackTreeForwardGenericVisitor extends
		AbstractUnaryVisitor<IVisitor> implements IRedBlackTreeVisitor {
	public RedBlackTreeForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(RBNode entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Value entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Color entity) {
		wGetVisitor1().visit(entity);
	}
}
