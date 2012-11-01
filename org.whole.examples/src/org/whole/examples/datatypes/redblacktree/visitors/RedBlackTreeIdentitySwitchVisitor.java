package org.whole.examples.datatypes.redblacktree.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.examples.datatypes.redblacktree.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class RedBlackTreeIdentitySwitchVisitor extends AbstractVisitor
		implements IRedBlackTreeVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case RedBlackTreeEntityDescriptorEnum.RBNode_ord:
			visit((RBNode) entity);
			break;
		case RedBlackTreeEntityDescriptorEnum.Value_ord:
			visit((Value) entity);
			break;
		case RedBlackTreeEntityDescriptorEnum.Color_ord:
			visit((Color) entity);
			break;
		}
	}
}
