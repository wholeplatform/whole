package org.whole.examples.datatypes.redblacktree.visitors;

import org.whole.lang.visitors.AbstractBinaryVisitor;
import org.whole.examples.datatypes.redblacktree.visitors.IRedBlackTreeVisitor;
import org.whole.examples.datatypes.redblacktree.model.*;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class RedBlackTreeSequenceVisitor extends
		AbstractBinaryVisitor<IRedBlackTreeVisitor> implements
		IRedBlackTreeVisitor {
	public RedBlackTreeSequenceVisitor(IVisitor visitor1, IVisitor visitor2) {
		super(visitor1, visitor2);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(RBNode entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Value entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Color entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}
}
