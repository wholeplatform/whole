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
package org.whole.lang.java.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/**
 *  @generator Whole
 */
public class AssignmentOperatorEnum extends EnumType<AssignmentOperatorEnum.Value> {
    public static final int assign_ord = 0;
    public static final int plus_assign_ord = 1;
    public static final int minus_assign_ord = 2;
    public static final int times_assign_ord = 3;
    public static final int divide_assign_ord = 4;
    public static final int bit_and_assign_ord = 5;
    public static final int bit_or_assign_ord = 6;
    public static final int bit_xor_assign_ord = 7;
    public static final int remainder_assign_ord = 8;
    public static final int left_shift_assign_ord = 9;
    public static final int right_shift_signed_assign_ord = 10;
    public static final int right_shift_unsigned_assign_ord = 11;
    public static final AssignmentOperatorEnum instance = new AssignmentOperatorEnum();
    public static final Value assign = instance.valueOf(assign_ord);
    public static final Value plus_assign = instance.valueOf(plus_assign_ord);
    public static final Value minus_assign = instance.valueOf(minus_assign_ord);
    public static final Value times_assign = instance.valueOf(times_assign_ord);
    public static final Value divide_assign = instance.valueOf(divide_assign_ord);
    public static final Value bit_and_assign = instance.valueOf(bit_and_assign_ord);
    public static final Value bit_or_assign = instance.valueOf(bit_or_assign_ord);
    public static final Value bit_xor_assign = instance.valueOf(bit_xor_assign_ord);
    public static final Value remainder_assign = instance.valueOf(remainder_assign_ord);
    public static final Value left_shift_assign = instance.valueOf(left_shift_assign_ord);
    public static final Value right_shift_signed_assign = instance.valueOf(right_shift_signed_assign_ord);
    public static final Value right_shift_unsigned_assign = instance.valueOf(right_shift_unsigned_assign_ord);

    private AssignmentOperatorEnum() {
        enumValue(assign_ord, "assign");
        enumValue(plus_assign_ord, "plus_assign");
        enumValue(minus_assign_ord, "minus_assign");
        enumValue(times_assign_ord, "times_assign");
        enumValue(divide_assign_ord, "divide_assign");
        enumValue(bit_and_assign_ord, "bit_and_assign");
        enumValue(bit_or_assign_ord, "bit_or_assign");
        enumValue(bit_xor_assign_ord, "bit_xor_assign");
        enumValue(remainder_assign_ord, "remainder_assign");
        enumValue(left_shift_assign_ord, "left_shift_assign");
        enumValue(right_shift_signed_assign_ord, "right_shift_signed_assign");
        enumValue(right_shift_unsigned_assign_ord, "right_shift_unsigned_assign");
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
