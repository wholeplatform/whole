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
package org.whole.lang.patterns.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 *  @generator Whole
 */
public class PatternsFeatureDescriptorEnum extends FeatureDescriptorEnum {
    public static final int uri_ord = 0;
    public static final int namespace_ord = 1;
    public static final int name_ord = 2;
    public static final int version_ord = 3;
    public static final int patterns_ord = 4;
    public static final int declarations_ord = 5;
    public static final int resultTypes_ord = 6;
    public static final int template_ord = 7;
    public static final int type_ord = 8;
    public static final int supertypes_ord = 9;
    public static final int types_ord = 10;
    public static final int resultType_ord = 11;
    public static final int values_ord = 12;
    public static final int value_ord = 13;
    public static final int result_ord = 14;
    public static final int dataType_ord = 15;
    public static final int arguments_ord = 16;
    public static final int expression_ord = 17;
    public static final int optional_ord = 18;
    public static final int adapter_ord = 19;
    public static final int weaver_ord = 20;
    public static final int context_ord = 21;
    public static final int condition_ord = 22;
    public static final int variability_ord = 23;
    public static final int variants_ord = 24;
    public static final int iterator_ord = 25;
    public static final int applicationTypes_ord = 26;
    public static final int body_ord = 27;
    public static final int subgoals_ord = 28;
    public static final int variant_ord = 29;
    public static final int path_ord = 30;
    public static final int placement_ord = 31;
    public static final PatternsFeatureDescriptorEnum instance = new PatternsFeatureDescriptorEnum();
    public static final FeatureDescriptor uri = instance.valueOf(uri_ord);
    public static final FeatureDescriptor namespace = instance.valueOf(namespace_ord);
    public static final FeatureDescriptor name = instance.valueOf(name_ord);
    public static final FeatureDescriptor version = instance.valueOf(version_ord);
    public static final FeatureDescriptor patterns = instance.valueOf(patterns_ord);
    public static final FeatureDescriptor declarations = instance.valueOf(declarations_ord);
    public static final FeatureDescriptor resultTypes = instance.valueOf(resultTypes_ord);
    public static final FeatureDescriptor template = instance.valueOf(template_ord);
    public static final FeatureDescriptor type = instance.valueOf(type_ord);
    public static final FeatureDescriptor supertypes = instance.valueOf(supertypes_ord);
    public static final FeatureDescriptor types = instance.valueOf(types_ord);
    public static final FeatureDescriptor resultType = instance.valueOf(resultType_ord);
    public static final FeatureDescriptor values = instance.valueOf(values_ord);
    public static final FeatureDescriptor value = instance.valueOf(value_ord);
    public static final FeatureDescriptor result = instance.valueOf(result_ord);
    public static final FeatureDescriptor dataType = instance.valueOf(dataType_ord);
    public static final FeatureDescriptor arguments = instance.valueOf(arguments_ord);
    public static final FeatureDescriptor expression = instance.valueOf(expression_ord);
    public static final FeatureDescriptor optional = instance.valueOf(optional_ord);
    public static final FeatureDescriptor adapter = instance.valueOf(adapter_ord);
    public static final FeatureDescriptor weaver = instance.valueOf(weaver_ord);
    public static final FeatureDescriptor context = instance.valueOf(context_ord);
    public static final FeatureDescriptor condition = instance.valueOf(condition_ord);
    public static final FeatureDescriptor variability = instance.valueOf(variability_ord);
    public static final FeatureDescriptor variants = instance.valueOf(variants_ord);
    public static final FeatureDescriptor iterator = instance.valueOf(iterator_ord);
    public static final FeatureDescriptor applicationTypes = instance.valueOf(applicationTypes_ord);
    public static final FeatureDescriptor body = instance.valueOf(body_ord);
    public static final FeatureDescriptor subgoals = instance.valueOf(subgoals_ord);
    public static final FeatureDescriptor variant = instance.valueOf(variant_ord);
    public static final FeatureDescriptor path = instance.valueOf(path_ord);
    public static final FeatureDescriptor placement = instance.valueOf(placement_ord);

    private PatternsFeatureDescriptorEnum() {
        putFeatureDescriptor(uri_ord, "uri");
        putFeatureDescriptor(namespace_ord, "namespace");
        putFeatureDescriptor(name_ord, "name");
        putFeatureDescriptor(version_ord, "version");
        putFeatureDescriptor(patterns_ord, "patterns");
        putFeatureDescriptor(declarations_ord, "declarations");
        putFeatureDescriptor(resultTypes_ord, "resultTypes");
        putFeatureDescriptor(template_ord, "template");
        putFeatureDescriptor(type_ord, "type");
        putFeatureDescriptor(supertypes_ord, "supertypes");
        putFeatureDescriptor(types_ord, "types");
        putFeatureDescriptor(resultType_ord, "resultType");
        putFeatureDescriptor(values_ord, "values");
        putFeatureDescriptor(value_ord, "value");
        putFeatureDescriptor(result_ord, "result");
        putFeatureDescriptor(dataType_ord, "dataType");
        putFeatureDescriptor(arguments_ord, "arguments");
        putFeatureDescriptor(expression_ord, "expression");
        putFeatureDescriptor(optional_ord, "optional");
        putFeatureDescriptor(adapter_ord, "adapter");
        putFeatureDescriptor(weaver_ord, "weaver");
        putFeatureDescriptor(context_ord, "context");
        putFeatureDescriptor(condition_ord, "condition");
        putFeatureDescriptor(variability_ord, "variability");
        putFeatureDescriptor(variants_ord, "variants");
        putFeatureDescriptor(iterator_ord, "iterator");
        putFeatureDescriptor(applicationTypes_ord, "applicationTypes");
        putFeatureDescriptor(body_ord, "body");
        putFeatureDescriptor(subgoals_ord, "subgoals");
        putFeatureDescriptor(variant_ord, "variant");
        putFeatureDescriptor(path_ord, "path");
        putFeatureDescriptor(placement_ord, "placement");
    }
    private static final long serialVersionUID = 1;
}
