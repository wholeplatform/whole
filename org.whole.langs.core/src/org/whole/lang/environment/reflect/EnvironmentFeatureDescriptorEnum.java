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
package org.whole.lang.environment.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 *  @generator Whole
 */
public class EnvironmentFeatureDescriptorEnum extends FeatureDescriptorEnum {
    public static final int environments_ord = 0;
    public static final int bindings_ord = 1;
    public static final int behavior_ord = 2;
    public static final int result_ord = 3;
    public static final int focusJob_ord = 4;
    public static final int jobs_ord = 5;
    public static final int focusFrame_ord = 6;
    public static final int executionStack_ord = 7;
    public static final int sourceFragment_ord = 8;
    public static final int sourceEntity_ord = 9;
    public static final int environmentManager_ord = 10;
    public static final int name_ord = 11;
    public static final int filter_ord = 12;
    public static final int bindingManager_ord = 13;
    public static final int value_ord = 14;
    public static final int scope_ord = 15;
    public static final EnvironmentFeatureDescriptorEnum instance = new EnvironmentFeatureDescriptorEnum();
    public static final FeatureDescriptor environments = instance.valueOf(environments_ord);
    public static final FeatureDescriptor bindings = instance.valueOf(bindings_ord);
    public static final FeatureDescriptor behavior = instance.valueOf(behavior_ord);
    public static final FeatureDescriptor result = instance.valueOf(result_ord);
    public static final FeatureDescriptor focusJob = instance.valueOf(focusJob_ord);
    public static final FeatureDescriptor jobs = instance.valueOf(jobs_ord);
    public static final FeatureDescriptor focusFrame = instance.valueOf(focusFrame_ord);
    public static final FeatureDescriptor executionStack = instance.valueOf(executionStack_ord);
    public static final FeatureDescriptor sourceFragment = instance.valueOf(sourceFragment_ord);
    public static final FeatureDescriptor sourceEntity = instance.valueOf(sourceEntity_ord);
    public static final FeatureDescriptor environmentManager = instance.valueOf(environmentManager_ord);
    public static final FeatureDescriptor name = instance.valueOf(name_ord);
    public static final FeatureDescriptor filter = instance.valueOf(filter_ord);
    public static final FeatureDescriptor bindingManager = instance.valueOf(bindingManager_ord);
    public static final FeatureDescriptor value = instance.valueOf(value_ord);
    public static final FeatureDescriptor scope = instance.valueOf(scope_ord);

    private EnvironmentFeatureDescriptorEnum() {
        putFeatureDescriptor(environments_ord, "environments");
        putFeatureDescriptor(bindings_ord, "bindings");
        putFeatureDescriptor(behavior_ord, "behavior");
        putFeatureDescriptor(result_ord, "result");
        putFeatureDescriptor(focusJob_ord, "focusJob");
        putFeatureDescriptor(jobs_ord, "jobs");
        putFeatureDescriptor(focusFrame_ord, "focusFrame");
        putFeatureDescriptor(executionStack_ord, "executionStack");
        putFeatureDescriptor(sourceFragment_ord, "sourceFragment");
        putFeatureDescriptor(sourceEntity_ord, "sourceEntity");
        putFeatureDescriptor(environmentManager_ord, "environmentManager");
        putFeatureDescriptor(name_ord, "name");
        putFeatureDescriptor(filter_ord, "filter");
        putFeatureDescriptor(bindingManager_ord, "bindingManager");
        putFeatureDescriptor(value_ord, "value");
        putFeatureDescriptor(scope_ord, "scope");
    }
    private static final long serialVersionUID = 1;
}
