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
package org.whole.lang.tests.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/**
 *  @generator Whole
 */
public class KindEnum extends EnumType<KindEnum.Value> {
    public static final int SIMPLE_ord = 0;
    public static final int COMPOSITE_ord = 1;
    public static final int DATA_ord = 2;
    public static final KindEnum instance = new KindEnum();
    public static final Value SIMPLE = instance.valueOf(SIMPLE_ord);
    public static final Value COMPOSITE = instance.valueOf(COMPOSITE_ord);
    public static final Value DATA = instance.valueOf(DATA_ord);

    private KindEnum() {
        enumValue(SIMPLE_ord, "SIMPLE");
        enumValue(COMPOSITE_ord, "COMPOSITE");
        enumValue(DATA_ord, "DATA");
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
