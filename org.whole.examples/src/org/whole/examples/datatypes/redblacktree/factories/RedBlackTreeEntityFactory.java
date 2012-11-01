package org.whole.examples.datatypes.redblacktree.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.examples.datatypes.redblacktree.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;

/** 
 * @generator Whole
 */
public class RedBlackTreeEntityFactory extends GenericEntityFactory {
	public static final RedBlackTreeEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static RedBlackTreeEntityFactory instance(
			IEntityRegistryProvider provider) {
		return new RedBlackTreeEntityFactory(provider);
	}

	protected RedBlackTreeEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public RBNode createRBNode() {
		return create(RedBlackTreeEntityDescriptorEnum.RBNode);
	}

	public RBNode createRBNode(Value value, Color color, RBNode left,
			RBNode right) {
		return create(RedBlackTreeEntityDescriptorEnum.RBNode, value, color,
				left, right);
	}

	public IEntityBuilder<RBNode> buildRBNode() {
		return new EntityBuilder<RBNode>(
				create(RedBlackTreeEntityDescriptorEnum.RBNode));
	}

	public Value createValue() {
		return create(RedBlackTreeEntityDescriptorEnum.Value);
	}

	public Value createValue(int value) {
		return create(RedBlackTreeEntityDescriptorEnum.Value, value);
	}

	public Color createColor() {
		return create(RedBlackTreeEntityDescriptorEnum.Color);
	}

	public Color createColor(ColorEnum.Value value) {
		return create(RedBlackTreeEntityDescriptorEnum.Color, value);
	}
}
