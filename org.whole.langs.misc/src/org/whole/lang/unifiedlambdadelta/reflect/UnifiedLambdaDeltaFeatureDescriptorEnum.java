package org.whole.lang.unifiedlambdadelta.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaFeatureDescriptorEnum extends
		FeatureDescriptorEnum {
	public static final int name_ord = 0;
	public static final int polarity_ord = 1;
	public static final int front_ord = 2;
	public static final int back_ord = 3;
	public static final int index_ord = 4;
	public static final int level_ord = 5;
	public static final int access_ord = 6;
	public static final int prefix_ord = 7;
	public static final int postfix_ord = 8;
	public static final UnifiedLambdaDeltaFeatureDescriptorEnum instance = new UnifiedLambdaDeltaFeatureDescriptorEnum();
	public static final FeatureDescriptor name = instance.valueOf(name_ord);
	public static final FeatureDescriptor polarity = instance
			.valueOf(polarity_ord);
	public static final FeatureDescriptor front = instance.valueOf(front_ord);
	public static final FeatureDescriptor back = instance.valueOf(back_ord);
	public static final FeatureDescriptor index = instance.valueOf(index_ord);
	public static final FeatureDescriptor level = instance.valueOf(level_ord);
	public static final FeatureDescriptor access = instance.valueOf(access_ord);
	public static final FeatureDescriptor prefix = instance.valueOf(prefix_ord);
	public static final FeatureDescriptor postfix = instance
			.valueOf(postfix_ord);

	private UnifiedLambdaDeltaFeatureDescriptorEnum() {
		putFeatureDescriptor(name_ord, "name");
		putFeatureDescriptor(polarity_ord, "polarity");
		putFeatureDescriptor(front_ord, "front");
		putFeatureDescriptor(back_ord, "back");
		putFeatureDescriptor(index_ord, "index");
		putFeatureDescriptor(level_ord, "level");
		putFeatureDescriptor(access_ord, "access");
		putFeatureDescriptor(prefix_ord, "prefix");
		putFeatureDescriptor(postfix_ord, "postfix");
	}

	private static final long serialVersionUID = 1;
}
