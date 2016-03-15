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
package org.whole.lang.types.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 *  @generator Whole
 */
public class TypesFeatureDescriptorEnum extends FeatureDescriptorEnum {
    public static final int checkBefore_ord = 0;
    public static final int rules_ord = 1;
    public static final int domain_ord = 2;
    public static final int type_ord = 3;
    public static final int arguments_ord = 4;
    public static final int cases_ord = 5;
    public static final int expressions_ord = 6;
    public static final int name_ord = 7;
    public static final TypesFeatureDescriptorEnum instance = new TypesFeatureDescriptorEnum();
    public static final FeatureDescriptor checkBefore = instance.valueOf(checkBefore_ord);
    public static final FeatureDescriptor rules = instance.valueOf(rules_ord);
    public static final FeatureDescriptor domain = instance.valueOf(domain_ord);
    public static final FeatureDescriptor type = instance.valueOf(type_ord);
    public static final FeatureDescriptor arguments = instance.valueOf(arguments_ord);
    public static final FeatureDescriptor cases = instance.valueOf(cases_ord);
    public static final FeatureDescriptor expressions = instance.valueOf(expressions_ord);
    public static final FeatureDescriptor name = instance.valueOf(name_ord);

    private TypesFeatureDescriptorEnum() {
        putFeatureDescriptor(checkBefore_ord, "checkBefore");
        putFeatureDescriptor(rules_ord, "rules");
        putFeatureDescriptor(domain_ord, "domain");
        putFeatureDescriptor(type_ord, "type");
        putFeatureDescriptor(arguments_ord, "arguments");
        putFeatureDescriptor(cases_ord, "cases");
        putFeatureDescriptor(expressions_ord, "expressions");
        putFeatureDescriptor(name_ord, "name");
    }
    private static final long serialVersionUID = 1;
}
