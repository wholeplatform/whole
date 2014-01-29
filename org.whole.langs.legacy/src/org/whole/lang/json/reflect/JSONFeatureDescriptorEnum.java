package org.whole.lang.json.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 *  @generator  Whole
 */
public class JSONFeatureDescriptorEnum extends FeatureDescriptorEnum {
    public static final int name_ord = 0;
    public static final int value_ord = 1;
    public static final JSONFeatureDescriptorEnum instance = new JSONFeatureDescriptorEnum();
    public static final FeatureDescriptor name = instance.valueOf(name_ord);
    public static final FeatureDescriptor value = instance.valueOf(value_ord);

    private JSONFeatureDescriptorEnum() {
        putFeatureDescriptor(name_ord, "name");
        putFeatureDescriptor(value_ord, "value");
    }
    private static final long serialVersionUID = 1;
}
