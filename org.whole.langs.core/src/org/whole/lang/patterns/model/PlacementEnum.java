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
package org.whole.lang.patterns.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/**
 *  @generator Whole
 */
public class PlacementEnum extends EnumType<PlacementEnum.Value> {
    public static final int AT_ord = 0;
    public static final int AROUND_ord = 1;
    public static final int BEFORE_ord = 2;
    public static final int AFTER_ord = 3;
    public static final int BEFORE_FIRST_CHILD_ord = 4;
    public static final int AFTER_LAST_CHILD_ord = 5;
    public static final PlacementEnum instance = new PlacementEnum();
    public static final Value AT = instance.valueOf(AT_ord);
    public static final Value AROUND = instance.valueOf(AROUND_ord);
    public static final Value BEFORE = instance.valueOf(BEFORE_ord);
    public static final Value AFTER = instance.valueOf(AFTER_ord);
    public static final Value BEFORE_FIRST_CHILD = instance.valueOf(BEFORE_FIRST_CHILD_ord);
    public static final Value AFTER_LAST_CHILD = instance.valueOf(AFTER_LAST_CHILD_ord);

    private PlacementEnum() {
        enumValue(AT_ord, "AT");
        enumValue(AROUND_ord, "AROUND");
        enumValue(BEFORE_ord, "BEFORE");
        enumValue(AFTER_ord, "AFTER");
        enumValue(BEFORE_FIRST_CHILD_ord, "BEFORE_FIRST_CHILD");
        enumValue(AFTER_LAST_CHILD_ord, "AFTER_LAST_CHILD");
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
