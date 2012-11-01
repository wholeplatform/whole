package org.whole.examples.datatypes.redblacktree.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.examples.datatypes.redblacktree.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class RedBlackTreeIdentityVisitor extends AbstractVisitor implements
		IRedBlackTreeVisitor {
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
