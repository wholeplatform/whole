package org.whole.lang.templates.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/** 
 * @generator Whole
 */
public class TemplatesFeatureDescriptorEnum extends FeatureDescriptorEnum {
	public static final int name_ord = 0;
	public static final int templates_ord = 1;
	public static final int forNames_ord = 2;
	public static final int template_ord = 3;
	public static final int qualifier_ord = 4;
	public static final TemplatesFeatureDescriptorEnum instance = new TemplatesFeatureDescriptorEnum();
	public static final FeatureDescriptor name = instance.valueOf(name_ord);
	public static final FeatureDescriptor templates = instance
			.valueOf(templates_ord);
	public static final FeatureDescriptor forNames = instance
			.valueOf(forNames_ord);
	public static final FeatureDescriptor template = instance
			.valueOf(template_ord);
	public static final FeatureDescriptor qualifier = instance
			.valueOf(qualifier_ord);

	private TemplatesFeatureDescriptorEnum() {
		putFeatureDescriptor(name_ord, "name");
		putFeatureDescriptor(templates_ord, "templates");
		putFeatureDescriptor(forNames_ord, "forNames");
		putFeatureDescriptor(template_ord, "template");
		putFeatureDescriptor(qualifier_ord, "qualifier");
	}

	private static final long serialVersionUID = 1;
}
