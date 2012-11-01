package org.whole.examples.datatypes.redblacktree.visitors;

import org.whole.examples.datatypes.redblacktree.visitors.RedBlackTreeIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.examples.datatypes.redblacktree.model.*;

/** 
 * @generator Whole
 */
public class RedBlackTreeTraverseAllSwitchVisitor extends
		RedBlackTreeIdentityUnaryVisitor<IVisitor> {
	public RedBlackTreeTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(RBNode entity) {
		wGetVisitor1().visit(entity.getValue());
		wGetVisitor1().visit(entity.getColor());
		wGetVisitor1().visit(entity.getLeft());
		wGetVisitor1().visit(entity.getRight());
	}
}
