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
package org.whole.lang.queries.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/**
 *  @generator Whole
 */
public class CompositeKindTestEnum extends EnumType<CompositeKindTestEnum.Value> {
    public static final int LIST_ord = 0;
    public static final int UNIQUE_LIST_ord = 1;
    public static final int SET_ord = 2;
    public static final int BAG_ord = 3;
    public static final int NOT_A_COMPOSITE_ord = 4;
    public static final CompositeKindTestEnum instance = new CompositeKindTestEnum();
    public static final Value LIST = instance.valueOf(LIST_ord);
    public static final Value UNIQUE_LIST = instance.valueOf(UNIQUE_LIST_ord);
    public static final Value SET = instance.valueOf(SET_ord);
    public static final Value BAG = instance.valueOf(BAG_ord);
    public static final Value NOT_A_COMPOSITE = instance.valueOf(NOT_A_COMPOSITE_ord);

    private CompositeKindTestEnum() {
        enumValue(LIST_ord, "LIST");
        enumValue(UNIQUE_LIST_ord, "UNIQUE_LIST");
        enumValue(SET_ord, "SET");
        enumValue(BAG_ord, "BAG");
        enumValue(NOT_A_COMPOSITE_ord, "NOT_A_COMPOSITE");
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
