package org.whole.examples.datatypes.redblacktree.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.examples.datatypes.redblacktree.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class RedBlackTreeIdentityUnaryVisitor<V extends IVisitor> extends
		AbstractUnaryVisitor<V> implements IRedBlackTreeVisitor {
	public RedBlackTreeIdentityUnaryVisitor() {
		super(null);
	}

	public RedBlackTreeIdentityUnaryVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		((IRedBlackTreeEntity) entity).accept(this);
	}

	public void visit(RBNode entity) {
	}

	public void visit(Value entity) {
	}

	public void visit(Color entity) {
	}
}
