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
package org.whole.lang.json.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 *  @generator Whole
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
