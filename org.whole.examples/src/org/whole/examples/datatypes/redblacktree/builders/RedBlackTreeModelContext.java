package org.whole.examples.datatypes.redblacktree.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class RedBlackTreeModelContext extends EntityContext {
	public RedBlackTreeModelContext(IEntity root) {
		super(root);
	}

	public RedBlackTreeModelContext getValue() {
		return (RedBlackTreeModelContext) wGet(RedBlackTreeFeatureDescriptorEnum.value);
	}

	public void setValue(RedBlackTreeModelContext value) {
		wSet(RedBlackTreeFeatureDescriptorEnum.value, value);
	}

	public RedBlackTreeModelContext getColor() {
		return (RedBlackTreeModelContext) wGet(RedBlackTreeFeatureDescriptorEnum.color);
	}

	public void setColor(RedBlackTreeModelContext color) {
		wSet(RedBlackTreeFeatureDescriptorEnum.color, color);
	}

	public RedBlackTreeModelContext getLeft() {
		return (RedBlackTreeModelContext) wGet(RedBlackTreeFeatureDescriptorEnum.left);
	}

	public void setLeft(RedBlackTreeModelContext left) {
		wSet(RedBlackTreeFeatureDescriptorEnum.left, left);
	}

	public RedBlackTreeModelContext getRight() {
		return (RedBlackTreeModelContext) wGet(RedBlackTreeFeatureDescriptorEnum.right);
	}

	public void setRight(RedBlackTreeModelContext right) {
		wSet(RedBlackTreeFeatureDescriptorEnum.right, right);
	}
}
