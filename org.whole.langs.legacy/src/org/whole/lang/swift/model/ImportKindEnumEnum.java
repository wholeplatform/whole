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
package org.whole.lang.swift.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/**
 *  @generator Whole
 */
public class ImportKindEnumEnum extends EnumType<ImportKindEnumEnum.Value> {
    public static final int Typealias_ord = 0;
    public static final int Struct_ord = 1;
    public static final int Class_ord = 2;
    public static final int Enum_ord = 3;
    public static final int Protocol_ord = 4;
    public static final int Var_ord = 5;
    public static final int Let_ord = 6;
    public static final int Func_ord = 7;
    public static final ImportKindEnumEnum instance = new ImportKindEnumEnum();
    public static final Value Typealias = instance.valueOf(Typealias_ord);
    public static final Value Struct = instance.valueOf(Struct_ord);
    public static final Value Class = instance.valueOf(Class_ord);
    public static final Value Enum = instance.valueOf(Enum_ord);
    public static final Value Protocol = instance.valueOf(Protocol_ord);
    public static final Value Var = instance.valueOf(Var_ord);
    public static final Value Let = instance.valueOf(Let_ord);
    public static final Value Func = instance.valueOf(Func_ord);

    private ImportKindEnumEnum() {
        enumValue(Typealias_ord, "Typealias");
        enumValue(Struct_ord, "Struct");
        enumValue(Class_ord, "Class");
        enumValue(Enum_ord, "Enum");
        enumValue(Protocol_ord, "Protocol");
        enumValue(Var_ord, "Var");
        enumValue(Let_ord, "Let");
        enumValue(Func_ord, "Func");
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
