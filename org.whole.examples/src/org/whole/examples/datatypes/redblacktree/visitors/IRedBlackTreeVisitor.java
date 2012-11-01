package org.whole.examples.datatypes.redblacktree.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.examples.datatypes.redblacktree.model.*;

/** 
 * @generator Whole
 */
public interface IRedBlackTreeVisitor extends IVisitor {
	public void visit(RBNode entity);

	public void visit(Value entity);

	public void visit(Color entity);
}
