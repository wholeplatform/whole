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
package org.whole.lang.models.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/**
 *  @generator Whole
 */
public class ComponentModifierEnum extends EnumType<ComponentModifierEnum.Value> {
    public static final int ordered_ord = 0;
    public static final int unique_ord = 1;
    public static final int reference_ord = 2;
    public static final int derived_ord = 3;
    public static final int shared_ord = 4;
    public static final ComponentModifierEnum instance = new ComponentModifierEnum();
    public static final Value ordered = instance.valueOf(ordered_ord);
    public static final Value unique = instance.valueOf(unique_ord);
    public static final Value reference = instance.valueOf(reference_ord);
    public static final Value derived = instance.valueOf(derived_ord);
    public static final Value shared = instance.valueOf(shared_ord);

    private ComponentModifierEnum() {
        enumValue(ordered_ord, "ordered");
        enumValue(unique_ord, "unique");
        enumValue(reference_ord, "reference");
        enumValue(derived_ord, "derived");
        enumValue(shared_ord, "shared");
    }
    private static final long serialVersionUID = 1;

    protected void enumValue(int ordinal, String name) {
        if (valueOf(name) == null)
            putEnumValue(new Value(ordinal, name));
    }

    protected void enumValue(int ordinal, String name, String implName) {
        if (valueOf(name) == null)
            putEnumValue(new Value(ordinal, name, implName));
    }

    public static class Value extends EnumValueImpl {
        private static final long serialVersionUID = 1;

        public Value() {
            super();
        }

        public Value(int ordinal, String name) {
            super(ordinal, name);
        }

        public Value(int ordinal, String name, String implName) {
            super(ordinal, name, implName);
        }
    }
}
