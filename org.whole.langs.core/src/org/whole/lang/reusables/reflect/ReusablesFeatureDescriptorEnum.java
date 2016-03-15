/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.reusables.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 *  @generator Whole
 */
public class ReusablesFeatureDescriptorEnum extends FeatureDescriptorEnum {
    public static final int original_ord = 0;
    public static final int adapter_ord = 1;
    public static final int adapted_ord = 2;
    public static final int adaptedRevision_ord = 3;
    public static final int source_ord = 4;
    public static final int variant_ord = 5;
    public static final int variantRevision_ord = 6;
    public static final int locator_ord = 7;
    public static final int persistence_ord = 8;
    public static final int uri_ord = 9;
    public static final ReusablesFeatureDescriptorEnum instance = new ReusablesFeatureDescriptorEnum();
    public static final FeatureDescriptor original = instance.valueOf(original_ord);
    public static final FeatureDescriptor adapter = instance.valueOf(adapter_ord);
    public static final FeatureDescriptor adapted = instance.valueOf(adapted_ord);
    public static final FeatureDescriptor adaptedRevision = instance.valueOf(adaptedRevision_ord);
    public static final FeatureDescriptor source = instance.valueOf(source_ord);
    public static final FeatureDescriptor variant = instance.valueOf(variant_ord);
    public static final FeatureDescriptor variantRevision = instance.valueOf(variantRevision_ord);
    public static final FeatureDescriptor locator = instance.valueOf(locator_ord);
    public static final FeatureDescriptor persistence = instance.valueOf(persistence_ord);
    public static final FeatureDescriptor uri = instance.valueOf(uri_ord);

    private ReusablesFeatureDescriptorEnum() {
        putFeatureDescriptor(original_ord, "original");
        putFeatureDescriptor(adapter_ord, "adapter");
        putFeatureDescriptor(adapted_ord, "adapted");
        putFeatureDescriptor(adaptedRevision_ord, "adaptedRevision");
        putFeatureDescriptor(source_ord, "source");
        putFeatureDescriptor(variant_ord, "variant");
        putFeatureDescriptor(variantRevision_ord, "variantRevision");
        putFeatureDescriptor(locator_ord, "locator");
        putFeatureDescriptor(persistence_ord, "persistence");
        putFeatureDescriptor(uri_ord, "uri");
    }
    private static final long serialVersionUID = 1;
}
