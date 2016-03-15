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
package org.whole.lang.queries.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 *  @generator Whole
 */
public class QueriesFeatureDescriptorEnum extends FeatureDescriptorEnum {
    public static final int name_ord = 0;
    public static final int parameters_ord = 1;
    public static final int body_ord = 2;
    public static final int fromClause_ord = 3;
    public static final int placement_ord = 4;
    public static final int valuesClause_ord = 5;
    public static final int selectClause_ord = 6;
    public static final int whereClause_ord = 7;
    public static final int clearClause_ord = 8;
    public static final int expression_ord = 9;
    public static final int predicate_ord = 10;
    public static final int constraints_ord = 11;
    public static final int bindings_ord = 12;
    public static final int arguments_ord = 13;
    public static final int localNames_ord = 14;
    public static final int index_ord = 15;
    public static final int startIndex_ord = 16;
    public static final int endIndex_ord = 17;
    public static final int comparator_ord = 18;
    public static final int names_ord = 19;
    public static final int expressions_ord = 20;
    public static final int identity_ord = 21;
    public static final int pexp1_ord = 22;
    public static final int pexp2_ord = 23;
    public static final int exp1_ord = 24;
    public static final int exp2_ord = 25;
    public static final QueriesFeatureDescriptorEnum instance = new QueriesFeatureDescriptorEnum();
    public static final FeatureDescriptor name = instance.valueOf(name_ord);
    public static final FeatureDescriptor parameters = instance.valueOf(parameters_ord);
    public static final FeatureDescriptor body = instance.valueOf(body_ord);
    public static final FeatureDescriptor fromClause = instance.valueOf(fromClause_ord);
    public static final FeatureDescriptor placement = instance.valueOf(placement_ord);
    public static final FeatureDescriptor valuesClause = instance.valueOf(valuesClause_ord);
    public static final FeatureDescriptor selectClause = instance.valueOf(selectClause_ord);
    public static final FeatureDescriptor whereClause = instance.valueOf(whereClause_ord);
    public static final FeatureDescriptor clearClause = instance.valueOf(clearClause_ord);
    public static final FeatureDescriptor expression = instance.valueOf(expression_ord);
    public static final FeatureDescriptor predicate = instance.valueOf(predicate_ord);
    public static final FeatureDescriptor constraints = instance.valueOf(constraints_ord);
    public static final FeatureDescriptor bindings = instance.valueOf(bindings_ord);
    public static final FeatureDescriptor arguments = instance.valueOf(arguments_ord);
    public static final FeatureDescriptor localNames = instance.valueOf(localNames_ord);
    public static final FeatureDescriptor index = instance.valueOf(index_ord);
    public static final FeatureDescriptor startIndex = instance.valueOf(startIndex_ord);
    public static final FeatureDescriptor endIndex = instance.valueOf(endIndex_ord);
    public static final FeatureDescriptor comparator = instance.valueOf(comparator_ord);
    public static final FeatureDescriptor names = instance.valueOf(names_ord);
    public static final FeatureDescriptor expressions = instance.valueOf(expressions_ord);
    public static final FeatureDescriptor identity = instance.valueOf(identity_ord);
    public static final FeatureDescriptor pexp1 = instance.valueOf(pexp1_ord);
    public static final FeatureDescriptor pexp2 = instance.valueOf(pexp2_ord);
    public static final FeatureDescriptor exp1 = instance.valueOf(exp1_ord);
    public static final FeatureDescriptor exp2 = instance.valueOf(exp2_ord);

    private QueriesFeatureDescriptorEnum() {
        putFeatureDescriptor(name_ord, "name");
        putFeatureDescriptor(parameters_ord, "parameters");
        putFeatureDescriptor(body_ord, "body");
        putFeatureDescriptor(fromClause_ord, "fromClause");
        putFeatureDescriptor(placement_ord, "placement");
        putFeatureDescriptor(valuesClause_ord, "valuesClause");
        putFeatureDescriptor(selectClause_ord, "selectClause");
        putFeatureDescriptor(whereClause_ord, "whereClause");
        putFeatureDescriptor(clearClause_ord, "clearClause");
        putFeatureDescriptor(expression_ord, "expression");
        putFeatureDescriptor(predicate_ord, "predicate");
        putFeatureDescriptor(constraints_ord, "constraints");
        putFeatureDescriptor(bindings_ord, "bindings");
        putFeatureDescriptor(arguments_ord, "arguments");
        putFeatureDescriptor(localNames_ord, "localNames");
        putFeatureDescriptor(index_ord, "index");
        putFeatureDescriptor(startIndex_ord, "startIndex");
        putFeatureDescriptor(endIndex_ord, "endIndex");
        putFeatureDescriptor(comparator_ord, "comparator");
        putFeatureDescriptor(names_ord, "names");
        putFeatureDescriptor(expressions_ord, "expressions");
        putFeatureDescriptor(identity_ord, "identity");
        putFeatureDescriptor(pexp1_ord, "pexp1");
        putFeatureDescriptor(pexp2_ord, "pexp2");
        putFeatureDescriptor(exp1_ord, "exp1");
        putFeatureDescriptor(exp2_ord, "exp2");
    }
    private static final long serialVersionUID = 1;
}
