package org.whole.examples.datatypes.redblacktree.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.datatypes.redblacktree.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class RedBlackTreeEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int RBNode_ord = 0;
	public static final int Value_ord = 1;
	public static final int Color_ord = 2;
	public static final RedBlackTreeEntityDescriptorEnum instance = new RedBlackTreeEntityDescriptorEnum();
	public static final EntityDescriptor<RBNode> RBNode = (EntityDescriptor<RBNode>) instance
			.valueOf(RBNode_ord);
	public static final EntityDescriptor<Value> Value = (EntityDescriptor<Value>) instance
			.valueOf(Value_ord);
	public static final EntityDescriptor<Color> Color = (EntityDescriptor<Color>) instance
			.valueOf(Color_ord);

	private RedBlackTreeEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(RBNode_ord, "RBNode", RBNode.class, false)
				.withFeature(RedBlackTreeFeatureDescriptorEnum.value, Value_ord)
				.withFeature(RedBlackTreeFeatureDescriptorEnum.color, Color_ord)
				.withFeature(RedBlackTreeFeatureDescriptorEnum.left,
						RBNode_ord, true, false, false, false, false)
				.withFeature(RedBlackTreeFeatureDescriptorEnum.right,
						RBNode_ord, true, false, false, false, false);
		putDataEntity(Value_ord, "Value", Value.class, false, int.class);
		putDataEntity(Color_ord, "Color", Color.class, false,
				ColorEnum.Value.class);
	}
}
