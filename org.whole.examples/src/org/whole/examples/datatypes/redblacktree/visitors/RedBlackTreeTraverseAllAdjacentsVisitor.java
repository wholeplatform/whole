package org.whole.examples.datatypes.redblacktree.visitors;

import org.whole.examples.datatypes.redblacktree.visitors.RedBlackTreeIdentityUnaryVisitor;
import org.whole.examples.datatypes.redblacktree.visitors.IRedBlackTreeVisitor;
import org.whole.examples.datatypes.redblacktree.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class RedBlackTreeTraverseAllAdjacentsVisitor extends
		RedBlackTreeIdentityUnaryVisitor<IRedBlackTreeVisitor> {
	public RedBlackTreeTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public RedBlackTreeTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
