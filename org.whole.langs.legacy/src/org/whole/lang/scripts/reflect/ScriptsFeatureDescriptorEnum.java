package org.whole.lang.scripts.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/** 
 * @generator Whole
 */
public class ScriptsFeatureDescriptorEnum extends FeatureDescriptorEnum {
	public static final int languageName_ord = 0;
	public static final int source_ord = 1;
	public static final ScriptsFeatureDescriptorEnum instance = new ScriptsFeatureDescriptorEnum();
	public static final FeatureDescriptor languageName = instance
			.valueOf(languageName_ord);
	public static final FeatureDescriptor source = instance.valueOf(source_ord);

	private ScriptsFeatureDescriptorEnum() {
		putFeatureDescriptor(languageName_ord, "languageName");
		putFeatureDescriptor(source_ord, "source");
	}

	private static final long serialVersionUID = 1;
}
