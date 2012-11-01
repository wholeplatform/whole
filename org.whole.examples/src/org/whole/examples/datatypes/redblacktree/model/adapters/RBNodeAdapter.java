package org.whole.examples.datatypes.redblacktree.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.examples.datatypes.redblacktree.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.datatypes.redblacktree.visitors.IRedBlackTreeVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeEntityDescriptorEnum;
import org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class RBNodeAdapter extends AbstractEntityAdapter implements RBNode {
	private static final long serialVersionUID = 1;

	public RBNodeAdapter(IEntity implementor) {
		super(implementor);
	}

	public RBNodeAdapter() {
	}

	public void accept(IRedBlackTreeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<RBNode> wGetEntityDescriptor() {
		return RedBlackTreeEntityDescriptorEnum.RBNode;
	}

	public Value getValue() {
		return wGet(RedBlackTreeFeatureDescriptorEnum.value).wGetAdapter(
				RedBlackTreeEntityDescriptorEnum.Value);
	}

	public void setValue(Value value) {
		wSet(RedBlackTreeFeatureDescriptorEnum.value, value);
	}

	public Color getColor() {
		return wGet(RedBlackTreeFeatureDescriptorEnum.color).wGetAdapter(
				RedBlackTreeEntityDescriptorEnum.Color);
	}

	public void setColor(Color color) {
		wSet(RedBlackTreeFeatureDescriptorEnum.color, color);
	}

	public RBNode getLeft() {
		return wGet(RedBlackTreeFeatureDescriptorEnum.left).wGetAdapter(
				RedBlackTreeEntityDescriptorEnum.RBNode);
	}

	public void setLeft(RBNode left) {
		wSet(RedBlackTreeFeatureDescriptorEnum.left, left);
	}

	public RBNode getRight() {
		return wGet(RedBlackTreeFeatureDescriptorEnum.right).wGetAdapter(
				RedBlackTreeEntityDescriptorEnum.RBNode);
	}

	public void setRight(RBNode right) {
		wSet(RedBlackTreeFeatureDescriptorEnum.right, right);
	}
}
