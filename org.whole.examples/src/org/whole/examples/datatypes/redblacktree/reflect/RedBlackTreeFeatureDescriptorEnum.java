package org.whole.examples.datatypes.redblacktree.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/** 
 * @generator Whole
 */
public class RedBlackTreeFeatureDescriptorEnum extends FeatureDescriptorEnum {
	public static final int value_ord = 0;
	public static final int color_ord = 1;
	public static final int left_ord = 2;
	public static final int right_ord = 3;
	public static final RedBlackTreeFeatureDescriptorEnum instance = new RedBlackTreeFeatureDescriptorEnum();
	public static final FeatureDescriptor value = instance.valueOf(value_ord);
	public static final FeatureDescriptor color = instance.valueOf(color_ord);
	public static final FeatureDescriptor left = instance.valueOf(left_ord);
	public static final FeatureDescriptor right = instance.valueOf(right_ord);

	private RedBlackTreeFeatureDescriptorEnum() {
		putFeatureDescriptor(value_ord, "value");
		putFeatureDescriptor(color_ord, "color");
		putFeatureDescriptor(left_ord, "left");
		putFeatureDescriptor(right_ord, "right");
	}

	private static final long serialVersionUID = 1;
}
