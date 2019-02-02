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
package org.whole.lang.queries.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/**
 *  @generator Whole
 */
public class DataKindTestEnum extends EnumType<DataKindTestEnum.Value> {
    public static final int BOOLEAN_ord = 0;
    public static final int INT_ord = 1;
    public static final int LONG_ord = 2;
    public static final int FLOAT_ord = 3;
    public static final int DOUBLE_ord = 4;
    public static final int CHAR_ord = 5;
    public static final int BYTE_ord = 6;
    public static final int SHORT_ord = 7;
    public static final int DATE_ord = 8;
    public static final int ENUM_VALUE_ord = 9;
    public static final int OBJECT_ord = 10;
    public static final int STRING_ord = 11;
    public static final int NOT_A_DATA_ord = 12;
    public static final DataKindTestEnum instance = new DataKindTestEnum();
    public static final Value BOOLEAN = instance.valueOf(BOOLEAN_ord);
    public static final Value INT = instance.valueOf(INT_ord);
    public static final Value LONG = instance.valueOf(LONG_ord);
    public static final Value FLOAT = instance.valueOf(FLOAT_ord);
    public static final Value DOUBLE = instance.valueOf(DOUBLE_ord);
    public static final Value CHAR = instance.valueOf(CHAR_ord);
    public static final Value BYTE = instance.valueOf(BYTE_ord);
    public static final Value SHORT = instance.valueOf(SHORT_ord);
    public static final Value DATE = instance.valueOf(DATE_ord);
    public static final Value ENUM_VALUE = instance.valueOf(ENUM_VALUE_ord);
    public static final Value OBJECT = instance.valueOf(OBJECT_ord);
    public static final Value STRING = instance.valueOf(STRING_ord);
    public static final Value NOT_A_DATA = instance.valueOf(NOT_A_DATA_ord);

    private DataKindTestEnum() {
        enumValue(BOOLEAN_ord, "BOOLEAN");
        enumValue(INT_ord, "INT");
        enumValue(LONG_ord, "LONG");
        enumValue(FLOAT_ord, "FLOAT");
        enumValue(DOUBLE_ord, "DOUBLE");
        enumValue(CHAR_ord, "CHAR");
        enumValue(BYTE_ord, "BYTE");
        enumValue(SHORT_ord, "SHORT");
        enumValue(DATE_ord, "DATE");
        enumValue(ENUM_VALUE_ord, "ENUM_VALUE");
        enumValue(OBJECT_ord, "OBJECT");
        enumValue(STRING_ord, "STRING");
        enumValue(NOT_A_DATA_ord, "NOT_A_DATA");
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
