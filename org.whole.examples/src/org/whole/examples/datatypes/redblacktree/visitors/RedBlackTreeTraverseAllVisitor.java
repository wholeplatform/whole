package org.whole.examples.datatypes.redblacktree.visitors;

import org.whole.examples.datatypes.redblacktree.visitors.RedBlackTreeIdentityUnaryVisitor;
import org.whole.examples.datatypes.redblacktree.visitors.IRedBlackTreeVisitor;
import org.whole.examples.datatypes.redblacktree.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class RedBlackTreeTraverseAllVisitor extends
		RedBlackTreeIdentityUnaryVisitor<IRedBlackTreeVisitor> {
	public RedBlackTreeTraverseAllVisitor() {
		wSetVisitor1(this);
	}

	public RedBlackTreeTraverseAllVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(RBNode entity) {
		entity.getValue().accept(wGetVisitor1());
		entity.getColor().accept(wGetVisitor1());
		entity.getLeft().accept(wGetVisitor1());
		entity.getRight().accept(wGetVisitor1());
	}
}
