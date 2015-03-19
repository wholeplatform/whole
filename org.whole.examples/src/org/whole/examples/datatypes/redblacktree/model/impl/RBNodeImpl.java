package org.whole.examples.datatypes.redblacktree.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.datatypes.redblacktree.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeEntityDescriptorEnum;
import org.whole.examples.datatypes.redblacktree.visitors.IRedBlackTreeVisitor;
import org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class RBNodeImpl extends AbstractSimpleEntity implements RBNode {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<RBNode> wGetEntityDescriptor() {
		return RedBlackTreeEntityDescriptorEnum.RBNode;
	}

	public int wGetEntityOrd() {
		return RedBlackTreeEntityDescriptorEnum.RBNode_ord;
	}

	public void accept(IRedBlackTreeVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Value value;

	public Value getValue() {
		return notifyRequested(RedBlackTreeFeatureDescriptorEnum.value, value);
	}

	public void setValue(Value value) {
		notifyChanged(RedBlackTreeFeatureDescriptorEnum.value, this.value,
				this.value = value);
	}

	private Color color;

	public Color getColor() {
		return notifyRequested(RedBlackTreeFeatureDescriptorEnum.color, color);
	}

	public void setColor(Color color) {
		notifyChanged(RedBlackTreeFeatureDescriptorEnum.color, this.color,
				this.color = color);
	}

	private RBNode left;

	public RBNode getLeft() {
		return notifyRequested(RedBlackTreeFeatureDescriptorEnum.left, left);
	}

	public void setLeft(RBNode left) {
		notifyChanged(RedBlackTreeFeatureDescriptorEnum.left, this.left,
				this.left = left);
	}

	private RBNode right;

	public RBNode getRight() {
		return notifyRequested(RedBlackTreeFeatureDescriptorEnum.right, right);
	}

	public void setRight(RBNode right) {
		notifyChanged(RedBlackTreeFeatureDescriptorEnum.right, this.right,
				this.right = right);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getValue().wGetAdaptee(false);
		case 1:
			return getColor().wGetAdaptee(false);
		case 2:
			return getLeft().wGetAdaptee(false);
		case 3:
			return getRight().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setValue(value.wGetAdapter(RedBlackTreeEntityDescriptorEnum.Value));
			break;
		case 1:
			setColor(value.wGetAdapter(RedBlackTreeEntityDescriptorEnum.Color));
			break;
		case 2:
			setLeft(value.wGetAdapter(RedBlackTreeEntityDescriptorEnum.RBNode));
			break;
		case 3:
			setRight(value.wGetAdapter(RedBlackTreeEntityDescriptorEnum.RBNode));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
