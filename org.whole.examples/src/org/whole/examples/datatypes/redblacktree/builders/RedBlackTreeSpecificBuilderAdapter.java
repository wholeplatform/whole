package org.whole.examples.datatypes.redblacktree.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeFeatureDescriptorEnum;
import org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeEntityDescriptorEnum;
import org.whole.examples.datatypes.redblacktree.model.ColorEnum;

/** 
 * @generator Whole
 */
public class RedBlackTreeSpecificBuilderAdapter extends GenericBuilderContext
		implements IRedBlackTreeBuilder {
	public RedBlackTreeSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public RedBlackTreeSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void right() {
		wFeature(RedBlackTreeFeatureDescriptorEnum.right);
	}

	public void left() {
		wFeature(RedBlackTreeFeatureDescriptorEnum.left);
	}

	public void color() {
		wFeature(RedBlackTreeFeatureDescriptorEnum.color);
	}

	public void value() {
		wFeature(RedBlackTreeFeatureDescriptorEnum.value);
	}

	public void visit() {
	}

	public void RBNode() {
		wEntity(RedBlackTreeEntityDescriptorEnum.RBNode);
	}

	public void RBNode_() {
		wEntity_(RedBlackTreeEntityDescriptorEnum.RBNode);
	}

	public void _RBNode() {
		_wEntity(RedBlackTreeEntityDescriptorEnum.RBNode);
	}

	public void Value() {
		wEntity(RedBlackTreeEntityDescriptorEnum.Value);
	}

	public void Value(int value) {
		wEntity(RedBlackTreeEntityDescriptorEnum.Value, value);
	}

	public void Color() {
		wEntity(RedBlackTreeEntityDescriptorEnum.Color);
	}

	public void Color(ColorEnum.Value value) {
		wEntity(RedBlackTreeEntityDescriptorEnum.Color, value);
	}

	public void Color(String value) {
		wEntity(RedBlackTreeEntityDescriptorEnum.Color, value);
	}
}
