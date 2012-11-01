package org.whole.examples.datatypes.redblacktree.visitors;

import org.whole.examples.datatypes.redblacktree.model.*;

/** 
 * @generator Whole
 */
public class RedBlackTreeForwardStagedVisitor extends
		RedBlackTreeIdentityVisitor {
	public void visit(RBNode entity) {
		stagedVisit(entity);
	}

	public void visit(Value entity) {
		stagedVisit(entity);
	}

	public void visit(Color entity) {
		stagedVisit(entity);
	}
}
