package org.whole.examples.datatypes.redblacktree.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.examples.datatypes.redblacktree.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class RedBlackTreeForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IRedBlackTreeVisitor> implements
		IRedBlackTreeVisitor {
	public RedBlackTreeForwardStrategyVisitor() {
		this(new RedBlackTreeIdentityVisitor());
	}

	public RedBlackTreeForwardStrategyVisitor(
			IRedBlackTreeVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IRedBlackTreeEntity) entity).accept(this);
	}

	public void visit(RBNode entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Value entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Color entity) {
		wGetStrategy().visit(entity);
	}
}
