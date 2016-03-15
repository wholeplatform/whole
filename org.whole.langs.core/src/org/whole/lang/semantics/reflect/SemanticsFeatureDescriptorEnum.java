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
package org.whole.lang.semantics.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 *  @generator Whole
 */
public class SemanticsFeatureDescriptorEnum extends FeatureDescriptorEnum {
    public static final int uri_ord = 0;
    public static final int namespace_ord = 1;
    public static final int name_ord = 2;
    public static final int version_ord = 3;
    public static final int functions_ord = 4;
    public static final int signature_ord = 5;
    public static final int rules_ord = 6;
    public static final int source_ord = 7;
    public static final int target_ord = 8;
    public static final int category_ord = 9;
    public static final int condition_ord = 10;
    public static final int meaning_ord = 11;
    public static final int premises_ord = 12;
    public static final int conclusion_ord = 13;
    public static final int sourceConfiguration_ord = 14;
    public static final int targetConfiguration_ord = 15;
    public static final int variable_ord = 16;
    public static final int index_ord = 17;
    public static final int time_ord = 18;
    public static final int identifier_ord = 19;
    public static final int newIdentifier_ord = 20;
    public static final int oldIdentifier_ord = 21;
    public static final int bindings_ord = 22;
    public static final int nestedScope_ord = 23;
    public static final int op_ord = 24;
    public static final int expression_ord = 25;
    public static final int environment_ord = 26;
    public static final int type_ord = 27;
    public static final int arguments_ord = 28;
    public static final int environments_ord = 29;
    public static final int stage_ord = 30;
    public static final int where_ord = 31;
    public static final int sub_ord = 32;
    public static final int sup_ord = 33;
    public static final SemanticsFeatureDescriptorEnum instance = new SemanticsFeatureDescriptorEnum();
    public static final FeatureDescriptor uri = instance.valueOf(uri_ord);
    public static final FeatureDescriptor namespace = instance.valueOf(namespace_ord);
    public static final FeatureDescriptor name = instance.valueOf(name_ord);
    public static final FeatureDescriptor version = instance.valueOf(version_ord);
    public static final FeatureDescriptor functions = instance.valueOf(functions_ord);
    public static final FeatureDescriptor signature = instance.valueOf(signature_ord);
    public static final FeatureDescriptor rules = instance.valueOf(rules_ord);
    public static final FeatureDescriptor source = instance.valueOf(source_ord);
    public static final FeatureDescriptor target = instance.valueOf(target_ord);
    public static final FeatureDescriptor category = instance.valueOf(category_ord);
    public static final FeatureDescriptor condition = instance.valueOf(condition_ord);
    public static final FeatureDescriptor meaning = instance.valueOf(meaning_ord);
    public static final FeatureDescriptor premises = instance.valueOf(premises_ord);
    public static final FeatureDescriptor conclusion = instance.valueOf(conclusion_ord);
    public static final FeatureDescriptor sourceConfiguration = instance.valueOf(sourceConfiguration_ord);
    public static final FeatureDescriptor targetConfiguration = instance.valueOf(targetConfiguration_ord);
    public static final FeatureDescriptor variable = instance.valueOf(variable_ord);
    public static final FeatureDescriptor index = instance.valueOf(index_ord);
    public static final FeatureDescriptor time = instance.valueOf(time_ord);
    public static final FeatureDescriptor identifier = instance.valueOf(identifier_ord);
    public static final FeatureDescriptor newIdentifier = instance.valueOf(newIdentifier_ord);
    public static final FeatureDescriptor oldIdentifier = instance.valueOf(oldIdentifier_ord);
    public static final FeatureDescriptor bindings = instance.valueOf(bindings_ord);
    public static final FeatureDescriptor nestedScope = instance.valueOf(nestedScope_ord);
    public static final FeatureDescriptor op = instance.valueOf(op_ord);
    public static final FeatureDescriptor expression = instance.valueOf(expression_ord);
    public static final FeatureDescriptor environment = instance.valueOf(environment_ord);
    public static final FeatureDescriptor type = instance.valueOf(type_ord);
    public static final FeatureDescriptor arguments = instance.valueOf(arguments_ord);
    public static final FeatureDescriptor environments = instance.valueOf(environments_ord);
    public static final FeatureDescriptor stage = instance.valueOf(stage_ord);
    public static final FeatureDescriptor where = instance.valueOf(where_ord);
    public static final FeatureDescriptor sub = instance.valueOf(sub_ord);
    public static final FeatureDescriptor sup = instance.valueOf(sup_ord);

    private SemanticsFeatureDescriptorEnum() {
        putFeatureDescriptor(uri_ord, "uri");
        putFeatureDescriptor(namespace_ord, "namespace");
        putFeatureDescriptor(name_ord, "name");
        putFeatureDescriptor(version_ord, "version");
        putFeatureDescriptor(functions_ord, "functions");
        putFeatureDescriptor(signature_ord, "signature");
        putFeatureDescriptor(rules_ord, "rules");
        putFeatureDescriptor(source_ord, "source");
        putFeatureDescriptor(target_ord, "target");
        putFeatureDescriptor(category_ord, "category");
        putFeatureDescriptor(condition_ord, "condition");
        putFeatureDescriptor(meaning_ord, "meaning");
        putFeatureDescriptor(premises_ord, "premises");
        putFeatureDescriptor(conclusion_ord, "conclusion");
        putFeatureDescriptor(sourceConfiguration_ord, "sourceConfiguration");
        putFeatureDescriptor(targetConfiguration_ord, "targetConfiguration");
        putFeatureDescriptor(variable_ord, "variable");
        putFeatureDescriptor(index_ord, "index");
        putFeatureDescriptor(time_ord, "time");
        putFeatureDescriptor(identifier_ord, "identifier");
        putFeatureDescriptor(newIdentifier_ord, "newIdentifier");
        putFeatureDescriptor(oldIdentifier_ord, "oldIdentifier");
        putFeatureDescriptor(bindings_ord, "bindings");
        putFeatureDescriptor(nestedScope_ord, "nestedScope");
        putFeatureDescriptor(op_ord, "op");
        putFeatureDescriptor(expression_ord, "expression");
        putFeatureDescriptor(environment_ord, "environment");
        putFeatureDescriptor(type_ord, "type");
        putFeatureDescriptor(arguments_ord, "arguments");
        putFeatureDescriptor(environments_ord, "environments");
        putFeatureDescriptor(stage_ord, "stage");
        putFeatureDescriptor(where_ord, "where");
        putFeatureDescriptor(sub_ord, "sub");
        putFeatureDescriptor(sup_ord, "sup");
    }
    private static final long serialVersionUID = 1;
}
