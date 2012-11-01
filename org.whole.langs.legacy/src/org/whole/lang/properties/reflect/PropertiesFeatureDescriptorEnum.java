package org.whole.lang.properties.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/** 
 * @generator Whole
 */
public class PropertiesFeatureDescriptorEnum extends FeatureDescriptorEnum {
	public static final int comment_ord = 0;
	public static final int defaults_ord = 1;
	public static final int entries_ord = 2;
	public static final int name_ord = 3;
	public static final int value_ord = 4;
	public static final PropertiesFeatureDescriptorEnum instance = new PropertiesFeatureDescriptorEnum();
	public static final FeatureDescriptor comment = instance
			.valueOf(comment_ord);
	public static final FeatureDescriptor defaults = instance
			.valueOf(defaults_ord);
	public static final FeatureDescriptor entries = instance
			.valueOf(entries_ord);
	public static final FeatureDescriptor name = instance.valueOf(name_ord);
	public static final FeatureDescriptor value = instance.valueOf(value_ord);

	private PropertiesFeatureDescriptorEnum() {
		putFeatureDescriptor(comment_ord, "comment");
		putFeatureDescriptor(defaults_ord, "defaults");
		putFeatureDescriptor(entries_ord, "entries");
		putFeatureDescriptor(name_ord, "name");
		putFeatureDescriptor(value_ord, "value");
	}

	private static final long serialVersionUID = 1;
}
