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
package org.whole.lang.math.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 *  @generator Whole
 */
public class MathFeatureDescriptorEnum extends FeatureDescriptorEnum {
    public static final int minuend_ord = 0;
    public static final int subtrahend_ord = 1;
    public static final int dividend_ord = 2;
    public static final int divisor_ord = 3;
    public static final int base_ord = 4;
    public static final int exponent_ord = 5;
    public static final int expression_ord = 6;
    public static final int degree_ord = 7;
    public static final int exp1_ord = 8;
    public static final int exp2_ord = 9;
    public static final int bits_ord = 10;
    public static final int elements_ord = 11;
    public static final int first_ord = 12;
    public static final int second_ord = 13;
    public static final int element_ord = 14;
    public static final int rule_ord = 15;
    public static final int collection1_ord = 16;
    public static final int collection2_ord = 17;
    public static final int collection_ord = 18;
    public static final int index_ord = 19;
    public static final int numerator_ord = 20;
    public static final int denominator_ord = 21;
    public static final MathFeatureDescriptorEnum instance = new MathFeatureDescriptorEnum();
    public static final FeatureDescriptor minuend = instance.valueOf(minuend_ord);
    public static final FeatureDescriptor subtrahend = instance.valueOf(subtrahend_ord);
    public static final FeatureDescriptor dividend = instance.valueOf(dividend_ord);
    public static final FeatureDescriptor divisor = instance.valueOf(divisor_ord);
    public static final FeatureDescriptor base = instance.valueOf(base_ord);
    public static final FeatureDescriptor exponent = instance.valueOf(exponent_ord);
    public static final FeatureDescriptor expression = instance.valueOf(expression_ord);
    public static final FeatureDescriptor degree = instance.valueOf(degree_ord);
    public static final FeatureDescriptor exp1 = instance.valueOf(exp1_ord);
    public static final FeatureDescriptor exp2 = instance.valueOf(exp2_ord);
    public static final FeatureDescriptor bits = instance.valueOf(bits_ord);
    public static final FeatureDescriptor elements = instance.valueOf(elements_ord);
    public static final FeatureDescriptor first = instance.valueOf(first_ord);
    public static final FeatureDescriptor second = instance.valueOf(second_ord);
    public static final FeatureDescriptor element = instance.valueOf(element_ord);
    public static final FeatureDescriptor rule = instance.valueOf(rule_ord);
    public static final FeatureDescriptor collection1 = instance.valueOf(collection1_ord);
    public static final FeatureDescriptor collection2 = instance.valueOf(collection2_ord);
    public static final FeatureDescriptor collection = instance.valueOf(collection_ord);
    public static final FeatureDescriptor index = instance.valueOf(index_ord);
    public static final FeatureDescriptor numerator = instance.valueOf(numerator_ord);
    public static final FeatureDescriptor denominator = instance.valueOf(denominator_ord);

    private MathFeatureDescriptorEnum() {
        putFeatureDescriptor(minuend_ord, "minuend");
        putFeatureDescriptor(subtrahend_ord, "subtrahend");
        putFeatureDescriptor(dividend_ord, "dividend");
        putFeatureDescriptor(divisor_ord, "divisor");
        putFeatureDescriptor(base_ord, "base");
        putFeatureDescriptor(exponent_ord, "exponent");
        putFeatureDescriptor(expression_ord, "expression");
        putFeatureDescriptor(degree_ord, "degree");
        putFeatureDescriptor(exp1_ord, "exp1");
        putFeatureDescriptor(exp2_ord, "exp2");
        putFeatureDescriptor(bits_ord, "bits");
        putFeatureDescriptor(elements_ord, "elements");
        putFeatureDescriptor(first_ord, "first");
        putFeatureDescriptor(second_ord, "second");
        putFeatureDescriptor(element_ord, "element");
        putFeatureDescriptor(rule_ord, "rule");
        putFeatureDescriptor(collection1_ord, "collection1");
        putFeatureDescriptor(collection2_ord, "collection2");
        putFeatureDescriptor(collection_ord, "collection");
        putFeatureDescriptor(index_ord, "index");
        putFeatureDescriptor(numerator_ord, "numerator");
        putFeatureDescriptor(denominator_ord, "denominator");
    }
    private static final long serialVersionUID = 1;
}
