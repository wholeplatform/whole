/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.migrations.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 *  @generator Whole
 */
public class MigrationsFeatureDescriptorEnum extends FeatureDescriptorEnum {
    public static final int uri_ord = 0;
    public static final int namespace_ord = 1;
    public static final int name_ord = 2;
    public static final int artifacts_ord = 3;
    public static final int rules_ord = 4;
    public static final int functions_ord = 5;
    public static final int label_ord = 6;
    public static final int source_ord = 7;
    public static final int target_ord = 8;
    public static final int registry_ord = 9;
    public static final int when_ord = 10;
    public static final int path_ord = 11;
    public static final int feature_ord = 12;
    public static final MigrationsFeatureDescriptorEnum instance = new MigrationsFeatureDescriptorEnum();
    public static final FeatureDescriptor uri = instance.valueOf(uri_ord);
    public static final FeatureDescriptor namespace = instance.valueOf(namespace_ord);
    public static final FeatureDescriptor name = instance.valueOf(name_ord);
    public static final FeatureDescriptor artifacts = instance.valueOf(artifacts_ord);
    public static final FeatureDescriptor rules = instance.valueOf(rules_ord);
    public static final FeatureDescriptor functions = instance.valueOf(functions_ord);
    public static final FeatureDescriptor label = instance.valueOf(label_ord);
    public static final FeatureDescriptor source = instance.valueOf(source_ord);
    public static final FeatureDescriptor target = instance.valueOf(target_ord);
    public static final FeatureDescriptor registry = instance.valueOf(registry_ord);
    public static final FeatureDescriptor when = instance.valueOf(when_ord);
    public static final FeatureDescriptor path = instance.valueOf(path_ord);
    public static final FeatureDescriptor feature = instance.valueOf(feature_ord);

    private MigrationsFeatureDescriptorEnum() {
        putFeatureDescriptor(uri_ord, "uri");
        putFeatureDescriptor(namespace_ord, "namespace");
        putFeatureDescriptor(name_ord, "name");
        putFeatureDescriptor(artifacts_ord, "artifacts");
        putFeatureDescriptor(rules_ord, "rules");
        putFeatureDescriptor(functions_ord, "functions");
        putFeatureDescriptor(label_ord, "label");
        putFeatureDescriptor(source_ord, "source");
        putFeatureDescriptor(target_ord, "target");
        putFeatureDescriptor(registry_ord, "registry");
        putFeatureDescriptor(when_ord, "when");
        putFeatureDescriptor(path_ord, "path");
        putFeatureDescriptor(feature_ord, "feature");
    }
    private static final long serialVersionUID = 1;
}
