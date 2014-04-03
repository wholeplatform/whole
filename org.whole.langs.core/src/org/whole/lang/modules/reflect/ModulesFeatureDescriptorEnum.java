package org.whole.lang.modules.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 *  @generator  Whole
 */
public class ModulesFeatureDescriptorEnum extends FeatureDescriptorEnum {
    public static final int content_ord = 0;
    public static final int resource_ord = 1;
    public static final int adapter_ord = 2;
    public static final int original_ord = 3;
    public static final int adapted_ord = 4;
    public static final int variant_ord = 5;
    public static final int locator_ord = 6;
    public static final int persistence_ord = 7;
    public static final int registry_ord = 8;
    public static final ModulesFeatureDescriptorEnum instance = new ModulesFeatureDescriptorEnum();
    public static final FeatureDescriptor content = instance.valueOf(content_ord);
    public static final FeatureDescriptor resource = instance.valueOf(resource_ord);
    public static final FeatureDescriptor adapter = instance.valueOf(adapter_ord);
    public static final FeatureDescriptor original = instance.valueOf(original_ord);
    public static final FeatureDescriptor adapted = instance.valueOf(adapted_ord);
    public static final FeatureDescriptor variant = instance.valueOf(variant_ord);
    public static final FeatureDescriptor locator = instance.valueOf(locator_ord);
    public static final FeatureDescriptor persistence = instance.valueOf(persistence_ord);
    public static final FeatureDescriptor registry = instance.valueOf(registry_ord);

    private ModulesFeatureDescriptorEnum() {
        putFeatureDescriptor(content_ord, "content");
        putFeatureDescriptor(resource_ord, "resource");
        putFeatureDescriptor(adapter_ord, "adapter");
        putFeatureDescriptor(original_ord, "original");
        putFeatureDescriptor(adapted_ord, "adapted");
        putFeatureDescriptor(variant_ord, "variant");
        putFeatureDescriptor(locator_ord, "locator");
        putFeatureDescriptor(persistence_ord, "persistence");
        putFeatureDescriptor(registry_ord, "registry");
    }
    private static final long serialVersionUID = 1;
}
