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
package org.whole.lang.steppers.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 *  @generator Whole
 */
public class SteppersFeatureDescriptorEnum extends FeatureDescriptorEnum {
    public static final int goals_ord = 0;
    public static final int arguments_ord = 1;
    public static final int name_ord = 2;
    public static final int calls_ord = 3;
    public static final int actions_ord = 4;
    public static final int expression_ord = 5;
    public static final SteppersFeatureDescriptorEnum instance = new SteppersFeatureDescriptorEnum();
    public static final FeatureDescriptor goals = instance.valueOf(goals_ord);
    public static final FeatureDescriptor arguments = instance.valueOf(arguments_ord);
    public static final FeatureDescriptor name = instance.valueOf(name_ord);
    public static final FeatureDescriptor calls = instance.valueOf(calls_ord);
    public static final FeatureDescriptor actions = instance.valueOf(actions_ord);
    public static final FeatureDescriptor expression = instance.valueOf(expression_ord);

    private SteppersFeatureDescriptorEnum() {
        putFeatureDescriptor(goals_ord, "goals");
        putFeatureDescriptor(arguments_ord, "arguments");
        putFeatureDescriptor(name_ord, "name");
        putFeatureDescriptor(calls_ord, "calls");
        putFeatureDescriptor(actions_ord, "actions");
        putFeatureDescriptor(expression_ord, "expression");
    }
    private static final long serialVersionUID = 1;
}
